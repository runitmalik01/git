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
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.InvoicePaymentStatus;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.SequenceGenerator;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:invoicedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class InvoiceDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	final String PROP_DETAIL_BEAN="mootlywcm:invoicedocumentdetail";
	final String PROP_DETAIL_PAYMENT_BEAN="mootlywcm:invoicepaymentdetail";
	final String PROP_DETAIL_REFUND_BEAN="mootlywcm:invoicerefunddetail";

	private final static Logger log = LoggerFactory.getLogger(InvoiceDocument.class); 

	private List<InvoiceDocumentDetail> invoiceDocumentDetailList;
	private List<InvoicePaymentDetail> invoicePaymentDetailList;
	private List<InvoiceRefundDetail> invoiceRefundDetailList;
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
	
	public Double getTotalInvoiceAmount() {
		Double totalInvoiceAmount = 0.00D;
		List<InvoiceDocumentDetail> invoiceDocumentDetailList = getInvoiceDocumentDetailList();
		if (invoiceDocumentDetailList == null || invoiceDocumentDetailList.size() == 0) {
			return totalInvoiceAmount;
		}
		
		for (InvoiceDocumentDetail invoiceDocumentDetail:invoiceDocumentDetailList) {
			totalInvoiceAmount += invoiceDocumentDetail.getServiceAmount();
		}		
		return totalInvoiceAmount;
		
	}
	
	public Double getTotalPaymentAmount() {
		Double totalPaymentAmount = 0.00D;
		List<InvoicePaymentDetail> invoicePaymentDetailListLocal = getInvoicePaymentDetailList();
		List<InvoiceRefundDetail> invoiceRefundDetailListLocal = getInvoiceRefundDetailList();
		if (invoicePaymentDetailListLocal == null || invoicePaymentDetailListLocal.size() == 0) {
			return totalPaymentAmount;
		}
		
		//all val
		for (InvoicePaymentDetail invoicePaymentDetail:invoicePaymentDetailListLocal) {
			if ( invoicePaymentDetail.isValid()) {
				totalPaymentAmount += invoicePaymentDetail.getTxnAmount();
			}
		}	
		
		//now deduct the valid refund 
		for (InvoiceRefundDetail invoiceRefundDetail:invoiceRefundDetailListLocal) {
			if ( invoiceRefundDetail.isValid()) {
				totalPaymentAmount -= invoiceRefundDetail.getTxnAmount();
			}
		}
		return totalPaymentAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getAmountDue() {
		return getTotalInvoiceAmount() - getTotalPaymentAmount();
	}
	
	public InvoicePaymentStatus getPaymentStatus() {
		Double totalInvoiceAmount = getTotalInvoiceAmount();
		Double totalPaymentAmount = getTotalPaymentAmount();
		
		Double amountDue = getAmountDue();
		if (totalInvoiceAmount == totalPaymentAmount) {
			return InvoicePaymentStatus.FULLY_PAID;
		}
		else if (totalInvoiceAmount > totalPaymentAmount && totalPaymentAmount > 0) {
			return InvoicePaymentStatus.PARTIALLY_PAID;
		}
		else if (totalInvoiceAmount > totalPaymentAmount && totalPaymentAmount == 0) {
			return InvoicePaymentStatus.UNPAID;
		}
		else {
			return InvoicePaymentStatus.OVER_PAID;
		}
		/*
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
		*/
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
	
	
	public final List<InvoicePaymentDetail> getInvoicePaymentDetailList() {
		if (invoicePaymentDetailList == null) invoicePaymentDetailList= getChildBeans(PROP_DETAIL_PAYMENT_BEAN);
		return invoicePaymentDetailList;
	}

	public final void setInvoicePaymentDetailList(List<InvoicePaymentDetail> invoicePaymentDetailList) {
		this.invoicePaymentDetailList = invoicePaymentDetailList;
	}

	public final void addInvoicePaymentDetail(InvoicePaymentDetail invoicePaymentDetail) {
		getInvoicePaymentDetailList();
		if (invoicePaymentDetailList == null) invoicePaymentDetailList = new ArrayList<InvoicePaymentDetail>();
		invoicePaymentDetailList.add(invoicePaymentDetail);
	}

	public final List<InvoiceRefundDetail> getInvoiceRefundDetailList() {
		if (invoiceRefundDetailList == null) invoiceRefundDetailList= getChildBeans(PROP_DETAIL_REFUND_BEAN);
		return invoiceRefundDetailList;
	}

	public final void setInvoiceRefundDetailList(List<InvoiceRefundDetail> invoiceRefundDetailList) {
		this.invoiceRefundDetailList = invoiceRefundDetailList;
	}

	public final void addInvoiceRefundDetail(InvoiceRefundDetail invoiceRefundDetail) {
		getInvoiceRefundDetailList();
		if (invoiceRefundDetailList == null) invoiceRefundDetailList = new ArrayList<InvoiceRefundDetail>();
		invoiceRefundDetailList.add(invoiceRefundDetail);
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
			
			nodeIterator = node.getNodes(PROP_DETAIL_PAYMENT_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			nodeIterator = node.getNodes(PROP_DETAIL_REFUND_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			if (invoiceDocument.getInvoiceDocumentDetailList() != null && invoiceDocument.getInvoiceDocumentDetailList().size() > 0 ){ 
				for (InvoiceDocumentDetail invoiceDocumentDetail:invoiceDocument.getInvoiceDocumentDetailList()) {
					if (!invoiceDocumentDetail.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						invoiceDocumentDetail.bindToNode(html); 
					}
				}
			}
			
			if (invoiceDocument.getInvoicePaymentDetailList() != null && invoiceDocument.getInvoicePaymentDetailList().size() > 0 ){ 
				for (InvoicePaymentDetail invoicePaymentDetail:invoiceDocument.getInvoicePaymentDetailList()) {
					if (!invoicePaymentDetail.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_DETAIL_PAYMENT_BEAN, PROP_DETAIL_PAYMENT_BEAN);
						invoicePaymentDetail.bindToNode(html); 
					}
				}
			}
			
			if (invoiceDocument.getInvoiceRefundDetailList() != null && invoiceDocument.getInvoiceRefundDetailList().size() > 0 ){ 
				for (InvoiceRefundDetail invoiceRefundDetail:invoiceDocument.getInvoiceRefundDetailList()) {
					if (!invoiceRefundDetail.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_DETAIL_REFUND_BEAN, PROP_DETAIL_REFUND_BEAN);
						invoiceRefundDetail.bindToNode(html); 
					}
				}
			}


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
	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null && child instanceof InvoiceDocumentDetail) {
			InvoiceDocumentDetail source =(InvoiceDocumentDetail) child;
			addInvoiceDocumentDetail(source);
		}
		else if (child.getCanonicalUUID() == null && child instanceof InvoicePaymentDetail) {
			InvoicePaymentDetail source =(InvoicePaymentDetail) child;
			addInvoicePaymentDetail(source);
		}
		else if (child.getCanonicalUUID() == null && child instanceof InvoiceRefundDetail) {
			InvoiceRefundDetail source =(InvoiceRefundDetail) child;
			addInvoiceRefundDetail(source);
		}
		boolean found = false;
		List<InvoiceDocumentDetail> listOfChildren = getInvoiceDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID()) && child instanceof InvoiceDocumentDetail) {
				InvoiceDocumentDetail destination =(InvoiceDocumentDetail) o;
				InvoiceDocumentDetail source  = (InvoiceDocumentDetail) child;
				destination.cloneBean(source);
				found = true;
				break;
			}
		}		
		if (!found) {
			List<InvoicePaymentDetail> listOfPaymentChildren = getInvoicePaymentDetailList();
			for (HippoBean o:listOfPaymentChildren) {
				log.info( o.getCanonicalUUID() );
				if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID()) && child instanceof InvoicePaymentDetail) {
					InvoicePaymentDetail destination =(InvoicePaymentDetail) o;
					InvoicePaymentDetail source  = (InvoicePaymentDetail) child;
					destination.cloneBean(source);
					found = true;
					break;
				}
			}		
		}
		if (!found) {
			List<InvoiceRefundDetail> listOfRefundChildren = getInvoiceRefundDetailList();
			for (HippoBean o:listOfRefundChildren) {
				log.info( o.getCanonicalUUID() );
				if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID()) && child instanceof InvoiceRefundDetail) {
					InvoiceRefundDetail destination =(InvoiceRefundDetail) o;
					InvoiceRefundDetail source  = (InvoiceRefundDetail) child;
					destination.cloneBean(source);
					found = true;
					break;
				}
			}		
		}
	}

	@Override
	public void add(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child instanceof InvoiceDocumentDetail) {
			InvoiceDocumentDetail source =(InvoiceDocumentDetail) child;
			addInvoiceDocumentDetail(source);
		}
		else if (child instanceof InvoiceRefundDetail) { //remember this class extends InvoicePaymentDetail so make sure this comes before in 
			InvoiceRefundDetail source =(InvoiceRefundDetail) child;
			addInvoiceRefundDetail(source);
		}
		else if (child instanceof InvoicePaymentDetail) {
			InvoicePaymentDetail source =(InvoicePaymentDetail) child;
			addInvoicePaymentDetail(source);
		}
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
			List<InvoicePaymentDetail> listOfPaymentChildren = getInvoicePaymentDetailList();
			for (HippoBean o:listOfPaymentChildren) {
				log.info( o.getCanonicalUUID() );
				if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
					InvoicePaymentDetail destination =(InvoicePaymentDetail) o;
					InvoicePaymentDetail source  = (InvoicePaymentDetail) child;
					destination.setMarkedForDeletion(true);
					found = true;
					break;
				}
			}
		}		
		if (!found) {
			List<InvoiceRefundDetail> listOfRefundChildren = getInvoiceRefundDetailList();
			for (HippoBean o:listOfRefundChildren) {
				log.info( o.getCanonicalUUID() );
				if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
					InvoiceRefundDetail destination =(InvoiceRefundDetail) o;
					InvoiceRefundDetail source  = (InvoiceRefundDetail) child;
					destination.setMarkedForDeletion(true);
					found = true;
					break;
				}
			}
		}	
	}

}
