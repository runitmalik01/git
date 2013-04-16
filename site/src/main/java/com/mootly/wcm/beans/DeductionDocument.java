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
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:deductiondocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class DeductionDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	final String PROP_DETAIL_BEAN="mootlywcm:deductiondocumentdetail";
	private final static Logger log = LoggerFactory.getLogger(DeductionDocument.class); 

	private List<DeductionDocumentDetail> deductionDocumentDetailList;

	public final List<DeductionDocumentDetail> getDeductionDocumentDetailList() {
		if (deductionDocumentDetailList == null) deductionDocumentDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return deductionDocumentDetailList;
	}

	public final void setDeductionDocumentDetailList(List<DeductionDocumentDetail> deductionDocumentDetailList) {
		this.deductionDocumentDetailList = deductionDocumentDetailList;
	}
	
	public final void addDeductionDocumentDetail(DeductionDocumentDetail deductionDocumentDetail) {
		getDeductionDocumentDetailList();
		if (deductionDocumentDetailList == null) deductionDocumentDetailList = new ArrayList<DeductionDocumentDetail>();
		deductionDocumentDetailList.add(deductionDocumentDetail);
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			DeductionDocument deductionDocument = (DeductionDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	if (deductionDocument.getDeductionDocumentDetailList() != null && deductionDocument.getDeductionDocumentDetailList().size() > 0 ){ 
        		for (DeductionDocumentDetail deductionDocumentDetail:deductionDocument.getDeductionDocumentDetailList()) {
        			if (!deductionDocumentDetail.isMarkedForDeletion()) {
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                deductionDocumentDetail.bindToNode(html); 
        			}
        		}
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
		DeductionDocument salaryIncomeDocument = (DeductionDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			DeductionDocumentDetail source =(DeductionDocumentDetail) child;
			addDeductionDocumentDetail(source);
		}
		boolean found = false;
		List<DeductionDocumentDetail> listOfChildren = getDeductionDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				DeductionDocumentDetail destination =(DeductionDocumentDetail) o;
				DeductionDocumentDetail source  = (DeductionDocumentDetail) child;
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
		DeductionDocumentDetail source =(DeductionDocumentDetail) child;
		addDeductionDocumentDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<DeductionDocumentDetail> listOfChildren = getDeductionDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				DeductionDocumentDetail destination =(DeductionDocumentDetail) o;
				DeductionDocumentDetail source  = (DeductionDocumentDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			DeductionDocumentDetail source =(DeductionDocumentDetail) child;
			addDeductionDocumentDetail(source);
		}		
	}
}
