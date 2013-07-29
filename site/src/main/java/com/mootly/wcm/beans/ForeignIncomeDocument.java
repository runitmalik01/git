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
import com.mootly.wcm.beans.compound.ForeignIncomeDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.TdsOthersDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:foreignincomedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ForeignIncomeDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:foreignincomedocument";
	static final public String NODE_NAME = "foreignincomedocument";
	final String PROP_DETAIL_BEAN="mootlywcm:foreignincomedetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	private Double total_amount;
	private Double IncomeApplDtaa;
	private Double IncomeNotApplDtaa;
	private Double defDouble=0.0d;
	private final static Logger log = LoggerFactory.getLogger(ForeignIncomeDocument.class); 

	private List<ForeignIncomeDetail> foreignincomeDetailList;
	
	public final List<ForeignIncomeDetail> getForeignIncomeDetailList() {
		if (foreignincomeDetailList == null) foreignincomeDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return foreignincomeDetailList;
	}

	public final void setSalaryIncomeDetailList(List<ForeignIncomeDetail> foreignincomeDetailList) {
		this.foreignincomeDetailList = foreignincomeDetailList;
	}
	
	public final void addForeignIncomeDetail(ForeignIncomeDetail foreignincome) {
		getForeignIncomeDetailList();
		if (foreignincomeDetailList == null) foreignincomeDetailList = new ArrayList<ForeignIncomeDetail>();
		foreignincomeDetailList.add(foreignincome);
	}
	   public Double getTotal_Amount() {
	    	if (total_amount == null) total_amount = getProperty("mootlywcm:totalamount");
	    	return total_amount;
	 }
	   
	   public final void setTotal_Amount(Double totalamount) {
			this.total_amount = totalamount;
		}
	   public Double getIncomeApplDtaa(){
		   if(IncomeApplDtaa== null) IncomeApplDtaa = getProperty("mootlywcm:IncomeApplDtaa");
		   return IncomeApplDtaa;
	   }
	   public final void setIncomeApplDtaa(Double IncomeApplDtaa){
		   this.IncomeApplDtaa=IncomeApplDtaa;
	   }
	   public Double getIncomeNotApplDtaa(){
		   if(IncomeNotApplDtaa == null) IncomeNotApplDtaa=getProperty("mootlywcm:IncomeNotApplDtaa");
		   return IncomeNotApplDtaa;
	   }
	   public final void setIncomeNotApplDtaa(Double IncomeNotApplDtaa){
		   this.IncomeNotApplDtaa=IncomeNotApplDtaa;
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
			ForeignIncomeDocument foreignincome = (ForeignIncomeDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	 double sum=0.0;
        	 String strSum="";
        	if ( foreignincome.getForeignIncomeDetailList() != null &&  foreignincome.getForeignIncomeDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ foreignincome.getForeignIncomeDetailList().size());
        		
        		for (ForeignIncomeDetail objtdsfromothers:foreignincome.getForeignIncomeDetailList()) {
        		    
        			if (!objtdsfromothers.isMarkedForDeletion()) {
        				double amount=objtdsfromothers.getIncome_Total();
            		    log.info("value of amount after fetching from compound bean"+amount);
            		     sum=sum+ amount;
            		    // Double sum1= (double) sum;
            		   //  strSum= BigDecimal.valueOf(sum1).toPlainString();
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                objtdsfromothers.bindToNode(html); 
        			}
        		}
        		setTotal_Amount(sum);
        		if(getTotal_Amount()<getIncomeApplDtaa()){
        			defDouble=0.0d;
        		}
        		else {
        			defDouble= (getTotal_Amount()-getIncomeApplDtaa());
        		}
        		setIncomeNotApplDtaa(defDouble);
        	}
        	node.setProperty("mootlywcm:totalamount", getTotal_Amount());
        	node.setProperty("mootlywcm:IncomeApplDtaa",getIncomeApplDtaa());
        	node.setProperty("mootlywcm:IncomeNotApplDtaa", getIncomeNotApplDtaa());
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
			if(formMap.getField("IncomeApplDtaa") != null){
				setIncomeApplDtaa(Double.parseDouble(formMap.getField("IncomeApplDtaa").getValue()));
						} 
			}
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		//we know the source bean will be SalaryIncomeDocument but doesn't hurt to check
		ForeignIncomeDocument salaryIncomeDocument = (ForeignIncomeDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			ForeignIncomeDetail source =(ForeignIncomeDetail) child;
			addForeignIncomeDetail(source);
		}
		boolean found = false;
		List<ForeignIncomeDetail> listOfChildren = getForeignIncomeDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				ForeignIncomeDetail destination =(ForeignIncomeDetail) o;
				ForeignIncomeDetail source  = (ForeignIncomeDetail) child;
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
		ForeignIncomeDetail source =(ForeignIncomeDetail) child;
		addForeignIncomeDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<ForeignIncomeDetail> listOfChildren = getForeignIncomeDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				ForeignIncomeDetail destination =(ForeignIncomeDetail) o;
				ForeignIncomeDetail source  = (ForeignIncomeDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			ForeignIncomeDetail source =(ForeignIncomeDetail) child;
			addForeignIncomeDetail(source);
		}		
	}
}
