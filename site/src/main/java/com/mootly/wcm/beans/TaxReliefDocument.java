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
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */




package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.TaxReliefDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:taxreliefdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class TaxReliefDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:taxreliefdocument";
	static final public String NODE_NAME = "taxreliefdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:taxreliefdetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	//private Double total_amount;
	private Double total_taxFsi;
	private Double rebate9091;
	private Double rebate90;
	private final static Logger log = LoggerFactory.getLogger(TaxReliefDocument.class); 

	private List<TaxReliefDetail> taxreliefDetailList;

	public final List<TaxReliefDetail> getTaxReliefDetailList() {
		if (taxreliefDetailList == null) taxreliefDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return taxreliefDetailList;
	}

	public final void setSalaryIncomeDetailList(List<TaxReliefDetail> tdsothersDetailList) {
		this.taxreliefDetailList = tdsothersDetailList;
	}
	
	public final void addTaxReliefDetail(TaxReliefDetail tdsothersdetail) {
		getTaxReliefDetailList();
		if (taxreliefDetailList == null) taxreliefDetailList = new ArrayList<TaxReliefDetail>();
		taxreliefDetailList.add(tdsothersdetail);
	}
	   public Double getTotal_TaxFsi() {
	    	if (total_taxFsi == null) total_taxFsi = getProperty("mootlywcm:total_taxFsi");
	    	return total_taxFsi;
	 }
	   
	   public final void setTotal_TaxFsi(Double total_taxFsi) {
			this.total_taxFsi = total_taxFsi;
		}
	   public Double getRebate9091() {
	    	if (rebate9091 == null) rebate9091 = getProperty("mootlywcm:rebate9091");
	    	return rebate9091;
	   }
	   
	   public final void setRebate9091(Double rebate9091) {
			this.rebate9091 = rebate9091;
		}
	   public Double getRebate90() {
	    	if (rebate90 == null) rebate90 = getProperty("mootlywcm:rebate90");
	    	return rebate90;
	 }
	   
	   public final void setRebate90(Double rebate90) {
			this.rebate90 = rebate90;
		}

	public final String getItFolderUuid() {
		return itFolderUuid;
	}

	public final void setItFolderUuid(String itFolderUuid) {
		this.itFolderUuid = itFolderUuid;
	}

	public PersonalInformation getPersonalInformation() {
		HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
		if (!(bean instanceof HippoMirror)) {
			return null;
		}
		PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();
		if (prdBean == null) {
			return null;
		}
		return prdBean;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			TaxReliefDocument tdssalary = (TaxReliefDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	 double sumTaxFsi=0.0;
        	 double sumrebate9091=0.0;
        	 double sumrebate91=0.0;
        	 String strSum="";
        	if ( tdssalary.getTaxReliefDetailList() != null &&  tdssalary.getTaxReliefDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ tdssalary.getTaxReliefDetailList().size());
        		
        		for (TaxReliefDetail objtdsfromothers:tdssalary.getTaxReliefDetailList()) {
        		    
        			if (!objtdsfromothers.isMarkedForDeletion()) {
        				double tax_fsi=objtdsfromothers.getTotaltax_fsi();
        				double rebate9091=objtdsfromothers.getRelief90_91();
        				double rebate90=objtdsfromothers.getRelief91();
        				 sumTaxFsi=sumTaxFsi+ tax_fsi;
            		    sumrebate9091=sumrebate9091+rebate9091;
            		    sumrebate91=sumrebate91+rebate90;
            		    // Double sum1= (double) sum;
            		   //  strSum= BigDecimal.valueOf(sum1).toPlainString();
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                objtdsfromothers.bindToNode(html); 
        			}
        		}
        		setTotal_TaxFsi(sumTaxFsi);
                setRebate9091(sumrebate9091);
                setRebate90(sumrebate91);
        	}
        	node.setProperty("mootlywcm:total_taxFsi", getTotal_TaxFsi());
        	node.setProperty("mootlywcm:rebate9091", getRebate9091());
        	node.setProperty("mootlywcm:rebate90", getRebate90());
        	/*
			javax.jcr.Node prdLinkNode;
			if (node.hasNode(NT_PERSONAL_INFO_LINK)) {
				prdLinkNode = node.getNode(NT_PERSONAL_INFO_LINK);
			} else {
				prdLinkNode = node.addNode(NT_PERSONAL_INFO_LINK, "hippo:mirror");
			}
			prdLinkNode.setProperty("hippo:docbase", salaryincome.getPersonalInfoUuid());
			*/

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap != null) {
			
		}
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		//we know the source bean will be SalaryIncomeDocument but doesn't hurt to check
		TaxReliefDocument salaryIncomeDocument = (TaxReliefDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			TaxReliefDetail source =(TaxReliefDetail) child;
			addTaxReliefDetail(source);
		}
		boolean found = false;
		List<TaxReliefDetail> listOfChildren = getTaxReliefDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				TaxReliefDetail destination =(TaxReliefDetail) o;
				TaxReliefDetail source  = (TaxReliefDetail) child;
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
		TaxReliefDetail source =(TaxReliefDetail) child;
		addTaxReliefDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<TaxReliefDetail> listOfChildren = getTaxReliefDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				TaxReliefDetail destination =(TaxReliefDetail) o;
				TaxReliefDetail source  = (TaxReliefDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			TaxReliefDetail source =(TaxReliefDetail) child;
			addTaxReliefDetail(source);
		}		
	}
}
