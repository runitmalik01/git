/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 * User: Megha
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */




package com.mootly.wcm.beans;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.InvoicePaymentStatus;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.SequenceGenerator;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:invoicedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class InvoiceDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	final String PROP_DETAIL_BEAN="mootlywcm:invoicedocumentdetail";

	private final static Logger log = LoggerFactory.getLogger(InvoiceDocument.class); 

	private List<InvoiceDocumentDetail> invoiceDocumentDetailList;
	private boolean UNPAID = false;
	private boolean PARTIALLY_PAID = false;
	private boolean FULLY_PAID = false;
	private boolean OVER_PAID = false;
	private String invoiceNumber;
	/** is the invoice paid fully */
	private Boolean isPaid;
	private List<MemberPayment> listOfMemberPayment;
	
	@Autowired ApplicationContext applicationContext;

	public final String getInvoiceNumber() {
		if (invoiceNumber == null) invoiceNumber = getProperty("mootlywcm:invoiceNumber");
		return invoiceNumber;
	}

	public final void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public InvoicePaymentStatus getPaymentStatus() {
		for (InvoicePaymentStatus p : InvoicePaymentStatus.values()) {		
			for(MemberPayment memPayment:getListOfMemberPayment()){
				if(PaymentVerificationStatus.UNVERIFIED.equals(memPayment.getPaymentVerificationStatus())){
					UNPAID = true;
					System.out.println("unpaid ????????????");
				}
				if(PaymentVerificationStatus.VERIFIED.equals(memPayment.getPaymentVerificationStatus())){
					FULLY_PAID = true;
					System.out.println("fullypaid ????????????");
				}
			}
			if(UNPAID && FULLY_PAID){
				return InvoicePaymentStatus.PARTIALLY_PAID;
			}
			if(!UNPAID && FULLY_PAID){
				return InvoicePaymentStatus.FULLY_PAID;
			}
		}
		return InvoicePaymentStatus.UNPAID;
	}

	public final List<InvoiceDocumentDetail> getInvoiceDocumentDetailList() {
		if (invoiceDocumentDetailList == null) invoiceDocumentDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return invoiceDocumentDetailList;
	}

	public final void setInvoiceDocumentDetailList(List<InvoiceDocumentDetail> invoiceDocumentDetailList) {
		this.invoiceDocumentDetailList = invoiceDocumentDetailList;
	}

	public final void addInvoiceDocumentDetail(InvoiceDocumentDetail invoiceIncomeDetail) {
		getInvoiceDocumentDetailList();
		if (invoiceDocumentDetailList == null) invoiceDocumentDetailList = new ArrayList<InvoiceDocumentDetail>();
		invoiceDocumentDetailList.add(invoiceIncomeDetail);
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			InvoiceDocument invoiceDocument = (InvoiceDocument) content;
			
			
			if (content != null && invoiceDocument.getInvoiceNumber() != null) {
				node.setProperty("mootlywcm:invoiceNumber",invoiceDocument.getInvoiceNumber());
			}

			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			double sum_rentSec25A=0.0d;
			double sum_arrearRentSec25B=0.0d;
			double sum_total_houseIncome=0.0d;
			if (invoiceDocument.getInvoiceDocumentDetailList() != null && invoiceDocument.getInvoiceDocumentDetailList().size() > 0 ){ 
				for (InvoiceDocumentDetail invoiceDocumentDetail:invoiceDocument.getInvoiceDocumentDetailList()) {
					if (!invoiceDocumentDetail.isMarkedForDeletion()) {
						//double value_rentSec25A=houseincomeDetail.getRentSec25A();

						//double value_arrearRentSec25B=houseincomeDetail.getArrearRentSec25B();
						//double value_total_houseIncome=houseincomeDetail.getTotal_houseIncome();

						//sum_rentSec25A = sum_rentSec25A+value_rentSec25A;
						//sum_arrearRentSec25B = sum_arrearRentSec25B+value_arrearRentSec25B;
						//sum_total_houseIncome = sum_total_houseIncome+value_total_houseIncome;

						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						invoiceDocumentDetail.bindToNode(html); 
					}
				}
				//setRentSec25A(sum_rentSec25A);
				//setArrearRentSec25B(sum_arrearRentSec25B);
				//setTotal_HouseIncome(sum_total_houseIncome);
			}
			//if (getRentSec25A() != null) node.setProperty("mootlywcm:rentSec25A", getRentSec25A());
			//if (getArrearRentSec25B() != null)  node.setProperty("mootlywcm:arrearRentSec25B", getArrearRentSec25B());
			//if (getTotal_HouseIncome() != null)  node.setProperty("mootlywcm:total_houseIncome", getTotal_HouseIncome());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap != null) {
			if (formMap.getField("invoiceNumber") != null && formMap.getField("invoiceNumber").getValue() != null) setInvoiceNumber(formMap.getField("invoiceNumber").getValue());
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		//we know the source bean will be CapitalAssetDocument but doesn't hurt to check
		InvoiceDocument housePropertyDocument = (InvoiceDocument) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			InvoiceDocumentDetail source =(InvoiceDocumentDetail) child;
			addInvoiceDocumentDetail(source);
		}
		boolean found = false;
		List<InvoiceDocumentDetail> listOfChildren = getInvoiceDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				InvoiceDocumentDetail destination =(InvoiceDocumentDetail) o;
				InvoiceDocumentDetail source  = (InvoiceDocumentDetail) child;
				destination.cloneBean(source);
				found = true;
				break;
			}
		}		
	}

	@Override
	public void add(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		InvoiceDocumentDetail source =(InvoiceDocumentDetail) child;
		addInvoiceDocumentDetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<InvoiceDocumentDetail> listOfChildren = getInvoiceDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				InvoiceDocumentDetail destination =(InvoiceDocumentDetail) o;
				InvoiceDocumentDetail source  = (InvoiceDocumentDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			InvoiceDocumentDetail source =(InvoiceDocumentDetail) child;
			addInvoiceDocumentDetail(source);
		}		
	}

	public List<MemberPayment> getListOfMemberPayment() {
		return listOfMemberPayment;
	}

	public void setListOfMemberPayment(List<MemberPayment> listOfMemberPayment) {
		this.listOfMemberPayment = listOfMemberPayment;
	}
}
