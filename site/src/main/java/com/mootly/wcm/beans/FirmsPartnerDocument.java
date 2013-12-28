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
import com.mootly.wcm.beans.compound.FirmsPartnerDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:firmspartnerdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class FirmsPartnerDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:firmspartnerdocument";
	static final public String NODE_NAME = "firmspartnerdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:firmspartnerdetail";
	private String itFolderUuid;
	private Double total_AmountShare_InProfit;
	private Double total_Capital_Balance;
	
	public String getGross_salary() {
		return "0";
	}
	private final static Logger log = LoggerFactory.getLogger(FirmsPartnerDocument.class); 
	private List<FirmsPartnerDetail> FirmsPartnerDetailList;
	public final List<FirmsPartnerDetail> getFirmsPartnerDetailList() {
		if (FirmsPartnerDetailList == null) FirmsPartnerDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return FirmsPartnerDetailList;
	}
	public final void setFirmsPartnerDetailList(List<FirmsPartnerDetail> firmpartner) {
		this.FirmsPartnerDetailList = firmpartner;
	}
	
	public  Double getTotal_AmountInProfit(){
		if(total_AmountShare_InProfit == null) total_AmountShare_InProfit=getProperty("mootlywcm:total_AmountShare_InProfit");
		return total_AmountShare_InProfit;
	}
	public  Double getTotal_Capital_Balance(){
		if(total_Capital_Balance == null) total_Capital_Balance=getProperty("mootlywcm:total_Capital_Balance");
		return total_Capital_Balance;
		
	}
	public final void setTotal_AmountInProfit(Double total_AmountShare_InProfit ){
		this.total_AmountShare_InProfit=total_AmountShare_InProfit;
	}
	public final void setTotal_Capital_Balance(Double total_Capital_Balance){
		this.total_Capital_Balance = total_Capital_Balance;
	}
	
	public final void addFirmsPartnerDetail(FirmsPartnerDetail QuantitativeUnit) {
		getFirmsPartnerDetailList();
		if (FirmsPartnerDetailList == null) FirmsPartnerDetailList = new ArrayList<FirmsPartnerDetail>();
		FirmsPartnerDetailList.add(QuantitativeUnit);
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
			FirmsPartnerDocument objFirmsPartnerDocument = (FirmsPartnerDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	Double sum_AmountShareInProfit=0.0d;
        	Double sum_CapitalBalance=0.0d;
        	if ( objFirmsPartnerDocument.getFirmsPartnerDetailList() != null &&  objFirmsPartnerDocument.getFirmsPartnerDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ objFirmsPartnerDocument.getFirmsPartnerDetailList().size());
        		for (FirmsPartnerDetail objFirmPartner:objFirmsPartnerDocument.getFirmsPartnerDetailList()) {
        		    Double val_AmountShareInProfit = objFirmPartner.getAmountShare_InProfit();
        		    Double val_CapitalBalance =  objFirmPartner.getCapital_Balance();
        		    sum_AmountShareInProfit = sum_AmountShareInProfit + val_AmountShareInProfit;
        		    sum_CapitalBalance = sum_CapitalBalance + val_CapitalBalance;
        			if (!objFirmPartner.isMarkedForDeletion()) {
        				 javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
        				 objFirmPartner.bindToNode(html); 
        			}
        		}
        		setTotal_AmountInProfit(sum_AmountShareInProfit);
        		setTotal_Capital_Balance(sum_CapitalBalance);
        	}
        	/*
			javax.jcr.Node prdLinkNode;
			if (node.hasNode(NT_PERSONAL_INFO_LINK)) {
				prdLinkNode = node.getNode(NT_PERSONAL_INFO_LINK);
			} else {
				prdLinkNode = node.addNode(NT_PERSONAL_INFO_LINK, "hippo:mirror");
			}
			prdLinkNode.setProperty("hippo:docbase", salaryincome.getPersonalInfoUuid());
			*/
        	node.setProperty("mootlywcm:total_AmountShare_InProfit", getTotal_AmountInProfit());
        	node.setProperty("mootlywcm:total_Capital_Balance", getTotal_Capital_Balance());
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
		FirmsPartnerDocument salaryIncomeDocument = (FirmsPartnerDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			FirmsPartnerDetail source =(FirmsPartnerDetail) child;
			addFirmsPartnerDetail(source);
		}
		boolean found = false;
		List<FirmsPartnerDetail> listOfChildren = getFirmsPartnerDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				FirmsPartnerDetail destination =(FirmsPartnerDetail) o;
				FirmsPartnerDetail source  = (FirmsPartnerDetail) child;
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
		FirmsPartnerDetail source =(FirmsPartnerDetail) child;
		addFirmsPartnerDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<FirmsPartnerDetail> listOfChildren = getFirmsPartnerDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				FirmsPartnerDetail destination =(FirmsPartnerDetail) o;
				FirmsPartnerDetail source  = (FirmsPartnerDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			FirmsPartnerDetail source =(FirmsPartnerDetail) child;
			addFirmsPartnerDetail(source);
		}		
	}
}
