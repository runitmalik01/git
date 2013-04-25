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

import java.text.SimpleDateFormat;
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
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:advancetaxdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class AdvanceTaxDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:advancetaxdocument";
	static final public String NODE_NAME = "advancetaxdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:advancetaxdetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	private Double total_amount;
	private Double total_sum1;
	private  Double total_sum2;
	private  Double total_sum3;
	private  Double total_sum4;
	private  Double total_sum5;
	private  Double total_sum6;
	private final static Logger log = LoggerFactory.getLogger(AdvanceTaxDocument.class); 

	private List<AdvanceTaxDetail> advancetaxDetailList;

	public final List<AdvanceTaxDetail> getAdvanceTaxDetailList() {
		if (advancetaxDetailList == null) advancetaxDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return advancetaxDetailList;
	}

	public final void setSelfAssesmentDetailList(List<AdvanceTaxDetail> advancetaxDetailList) {
		this.advancetaxDetailList = advancetaxDetailList;
	}
	
	public final void addSelfAssesmentDetail(AdvanceTaxDetail tdsothersdetail) {
		getAdvanceTaxDetailList();
		if (advancetaxDetailList == null) advancetaxDetailList = new ArrayList<AdvanceTaxDetail>();
		advancetaxDetailList.add(tdsothersdetail);
	}
	
	   public double getTotal_Amount() {
	    	if (total_amount == null) total_amount = getProperty("mootlywcm:totalamount");
	    	return total_amount;
	 }
	   public final void setTotal_Amount(double sum) {
			this.total_amount = sum;
		}
	   public Double getTotal_Sum1() {
	    	if (total_sum1 == null) total_sum1 = getProperty("mootlywcm:totalsum1");
	    	return total_sum1;
	 }
	   public final void setTotal_Sum1(Double totalsum1) {
			this.total_sum1 = totalsum1;
		}
	   public Double getTotal_Sum2() {
	    	if (total_sum2 == null) total_sum2 = getProperty("mootlywcm:totalsum2");
	    	return total_sum2;
	 }
	   public final void setTotal_Sum2(Double totalsum2) {
			this.total_sum2 = totalsum2;
		}
	   public Double getTotal_Sum3() {
	    	if (total_sum3 == null) total_sum3 = getProperty("mootlywcm:totalsum3");
	    	return total_sum3;
	 }
	   public final void setTotal_Sum3(Double totalsum3) {
			this.total_sum3 = totalsum3;
		}
	   public Double getTotal_Sum4() {
	    	if (total_sum4 == null) total_sum4 = getProperty("mootlywcm:totalsum4");
	    	return total_sum4;
	 }
	   
	   public final void setTotal_Sum4(Double totalsum4) {
			this.total_sum4 = totalsum4;
		}
	   public Double getTotal_Sum5() {
	    	if (total_sum5 == null) total_sum5 = getProperty("mootlywcm:totalsum5");
	    	return total_sum5;
	 }
	   public final void setTotal_Sum5(Double totalsum5) {
			this.total_sum5 = totalsum5;
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
			AdvanceTaxDocument selfasses = (AdvanceTaxDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	 double sum=0.0;
        	 double sum1=0.0;
        	 double sum2=0.0;
        	 double sum3=0.0;
        	 double sum4=0.0;
        	 double sum5=0.0;
        	 double sum6=0.0;
        	if ( selfasses.getAdvanceTaxDetailList() != null &&  selfasses.getAdvanceTaxDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ selfasses.getAdvanceTaxDetailList().size());
        		
        		for (AdvanceTaxDetail objSelfAssesment:selfasses.getAdvanceTaxDetailList()) {
        		    
        			if (!objSelfAssesment.isMarkedForDeletion()) {
        				double amount=objSelfAssesment.getP_Amount();
            		    log.info("value of amount after fetching from compound bean"+amount);
            		     sum=sum+amount;
            		     try{
            		    
            		     String fetchDatefull=objSelfAssesment.getDateStr();
            		     log.info("fetchDate"+fetchDatefull);
            		     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            		     java.util.Date fetchDate= sdf.parse(fetchDatefull);
            		     java.util.Date date1= sdf.parse("01/04/2012");  
            		    		 java.util.Date date2=sdf.parse("15/06/2012");  
            		    		 java.util.Date date3=sdf.parse("15/09/2012");  
            		    		 java.util.Date date4=sdf.parse("15/12/2012");  
            		    		 java.util.Date date5=sdf.parse("15/03/2013");  
            		    		 java.util.Date date6=sdf.parse("31/03/2013");  
            		    		 
            		  if(fetchDate.equals(date1) || fetchDate.after(date1)  && fetchDate.before(date2) || fetchDate.equals(date2))  {
            			  sum1=sum1+objSelfAssesment.getP_Amount();
            			  log.info("conditionfirst");
            			 
            		  }else{
            			  if(fetchDate.after(date2)  && fetchDate.before(date3) ||fetchDate.equals(date3)){
            			  sum2=sum2+objSelfAssesment.getP_Amount();
            			  log.info("condition second");
            		   }else {
            			   if(fetchDate.after(date3)  && fetchDate.before(date4) || fetchDate.equals(date4)){
                 			  sum3=sum3+objSelfAssesment.getP_Amount();
                 			 log.info("condition third");
            			   
            		   } else{
            			   if(fetchDate.after(date4) && fetchDate.before(date5) || fetchDate.equals(date5)){
            		   
            			   sum4=sum4+objSelfAssesment.getP_Amount();
            			   log.info("condition four");
            		   			} else{
            		   	 if(fetchDate.after(date5) && fetchDate.before(date6) || fetchDate.equals(date6)){
            	        			   sum5=sum5+objSelfAssesment.getP_Amount();
                        			   log.info("condition five");
            		   				
            		   			} else{
            		   				log.info("condition last");
            		   			}
            		   				
            		   			}
            			   }
            		   }
            			   }
            		     }catch(Exception e){
            		    	 
            		     }
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                objSelfAssesment.bindToNode(html); 
        			}
        		}
        		
        			setTotal_Sum5(sum5);
        			node.setProperty("mootlywcm:totalsum5", getTotal_Sum5());
        			setTotal_Sum4(sum4);
        			node.setProperty("mootlywcm:totalsum4", getTotal_Sum4());
        			setTotal_Sum3(sum3);
        			node.setProperty("mootlywcm:totalsum3", getTotal_Sum3());
        			setTotal_Sum2(sum2);
        			node.setProperty("mootlywcm:totalsum2", getTotal_Sum2());
        			setTotal_Sum1(sum1);
        			node.setProperty("mootlywcm:totalsum1", getTotal_Sum1());
        			setTotal_Amount(sum);
        			log.info("value of sum"+sum);
        	}
        	node.setProperty("mootlywcm:totalamount", getTotal_Amount());
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
		AdvanceTaxDocument salaryIncomeDocument = (AdvanceTaxDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			AdvanceTaxDetail source =(AdvanceTaxDetail) child;
			addSelfAssesmentDetail(source);
		}
		boolean found = false;
		List<AdvanceTaxDetail> listOfChildren = getAdvanceTaxDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				AdvanceTaxDetail destination =(AdvanceTaxDetail) o;
				AdvanceTaxDetail source  = (AdvanceTaxDetail) child;
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
		AdvanceTaxDetail source =(AdvanceTaxDetail) child;
		addSelfAssesmentDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<AdvanceTaxDetail> listOfChildren = getAdvanceTaxDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				AdvanceTaxDetail destination =(AdvanceTaxDetail) o;
				AdvanceTaxDetail source  = (AdvanceTaxDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			AdvanceTaxDetail source =(AdvanceTaxDetail) child;
			addSelfAssesmentDetail(source);
		}		
	}
}
