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

package com.mootly.wcm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.annotations.DoNotDuplicate;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.DITSubmissionStatus;
import com.mootly.wcm.model.VerificationStatus;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:ditResponseDocument")
@DoNotDuplicate
public class DITResponseDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate { 
	
	private List<DITResponseDocumentDetail> ditResponseDocumentDetailList;
	final String PROP_DETAIL_BEAN="mootlywcm:ditResponseDocumentDetail";
	
	int totalCountLastOperation;

	public final List<DITResponseDocumentDetail> getDitResponseDocumentDetails() {
		if (ditResponseDocumentDetailList == null) ditResponseDocumentDetailList = getChildBeans(PROP_DETAIL_BEAN);
		return ditResponseDocumentDetailList;
	}
	
	//how 
	public final List<DITResponseDocumentDetail> getDitResponseDocumentDetailsBySOAPOperation(String soapOperation) {
		getDitResponseDocumentDetails();
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocal = null;
		if ( ditResponseDocumentDetailList != null || ditResponseDocumentDetailList.size() > 0 ) {
			ditResponseDocumentDetailListLocal = new ArrayList<DITResponseDocumentDetail>();
			for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocumentDetailList) {
				if (ditResponseDocumentDetail.getSoapOperation() != null && soapOperation.equals(ditResponseDocumentDetail.getSoapOperation())) {
					ditResponseDocumentDetailListLocal.add(ditResponseDocumentDetail);
				}
			}
		}
		return ditResponseDocumentDetailListLocal;
	}
	
	public final DITResponseDocumentDetail getLastDitResponseDocumentDetailsBySOAPOperation(String soapOperation) {
		getDitResponseDocumentDetails();
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocal = null;
		if ( ditResponseDocumentDetailList != null || ditResponseDocumentDetailList.size() > 0 ) {
			ditResponseDocumentDetailListLocal = new ArrayList<DITResponseDocumentDetail>();
			for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocumentDetailList) {
				if (ditResponseDocumentDetail.getSoapOperation() != null && soapOperation.equals(ditResponseDocumentDetail.getSoapOperation())) {
					ditResponseDocumentDetailListLocal.add(ditResponseDocumentDetail);
				}
			}
		}
		if (ditResponseDocumentDetailListLocal != null && ditResponseDocumentDetailListLocal.size() > 0) {
			return ditResponseDocumentDetailListLocal.get(ditResponseDocumentDetailListLocal.size() - 1);
		}
		else {
			return null;
		}
	}
	
	public final DITResponseDocumentDetail getLastDITSubmissionDocument() {
		return getLastDitResponseDocumentDetailsBySOAPOperation("submitITR");
	}
	
	public final String getLastDITSubmissionStatus() {
		DITResponseDocumentDetail ditResponseDocumentDetail = getLastDitResponseDocumentDetailsBySOAPOperation("submitITR");
		if (ditResponseDocumentDetail == null) {
			return null;
		}
		else {
			return ditResponseDocumentDetail.getDitSubmissionStatus();
		}
	}
	
	//how 
	/*
	 * FormField frmField2 = new FormField("verificationStatus");
											frmField2.addValue(VerificationStatus.VERIFIED.name());
											childFormMap.addFormField(frmField2);
											
											FormField frmField3 = new FormField("ditSubmissionStatus");
											frmField3.addValue(DITSubmissionStatus.SUCCESS.name());
											childFormMap.addFormField(frmField3);
	 */
	/**
	 * 
	 * @return
	 */
	public final List<DITResponseDocumentDetail> getEfileHistory() {
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocalReturn = null;
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocal = getDitResponseDocumentDetailsBySOAPOperation("submitITR");
		return ditResponseDocumentDetailListLocal;
	}
	/**
	 * 
	 * @return
	 */
	public final List<DITResponseDocumentDetail> getEFileFailureHistory() {
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocalReturn = null;
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocal = getDitResponseDocumentDetailsBySOAPOperation("submitITR");
		if (ditResponseDocumentDetailListLocal != null && ditResponseDocumentDetailListLocal.size() > 0) {
			ditResponseDocumentDetailListLocalReturn = new ArrayList<DITResponseDocumentDetail>();
			for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocumentDetailListLocal) {
				if (ditResponseDocumentDetail.getDitSubmissionStatus() != null && DITSubmissionStatus.FAILED.name().equals(ditResponseDocumentDetail.getDitSubmissionStatus()) ) {
					ditResponseDocumentDetailListLocalReturn.add(ditResponseDocumentDetail);
				}
			}
		}
		return ditResponseDocumentDetailListLocalReturn;
	}
	/**
	 * 
	 * @return
	 */
	public final List<DITResponseDocumentDetail> getEFileSuccessHistory() {
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocalReturn = null;
		List<DITResponseDocumentDetail> ditResponseDocumentDetailListLocal = getDitResponseDocumentDetailsBySOAPOperation("submitITR");
		if (ditResponseDocumentDetailListLocal != null && ditResponseDocumentDetailListLocal.size() > 0) {
			ditResponseDocumentDetailListLocalReturn = new ArrayList<DITResponseDocumentDetail>();
			for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocumentDetailListLocal) {
				if (ditResponseDocumentDetail.getDitSubmissionStatus() != null && DITSubmissionStatus.SUCCESS.name().equals(ditResponseDocumentDetail.getDitSubmissionStatus()) ) {
					ditResponseDocumentDetailListLocalReturn.add(ditResponseDocumentDetail);
				}
			}
		}
		return ditResponseDocumentDetailListLocalReturn;
	}
	
	public void setDitResponseDocumentDetails(
			List<DITResponseDocumentDetail> ditResponseDocumentDetailList) {
		this.ditResponseDocumentDetailList = ditResponseDocumentDetailList;
	}
	
	public final void addDITResponseDocumentDetail(DITResponseDocumentDetail ditResponseDocumentDetail) {
		getDitResponseDocumentDetails();
		if (ditResponseDocumentDetailList == null) ditResponseDocumentDetailList = new ArrayList<DITResponseDocumentDetail>();
		ditResponseDocumentDetailList.add(ditResponseDocumentDetail);
	}
	
	/**
	 * 
	 * @param ditSOAPOperation
	 * @return
	 */
	public final Integer getTotalCountOfOperation(String ditSOAPOperation) {
		getDitResponseDocumentDetails();
		Integer totalCount = 0;
		if ( ditResponseDocumentDetailList != null && ditResponseDocumentDetailList.size() > 0) {
			for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocumentDetailList) {
				if ( (ditResponseDocumentDetail.getIsFault() == null || !ditResponseDocumentDetail.getIsFault()) && ditResponseDocumentDetail.getSoapOperation() != null && ditResponseDocumentDetail.getSoapOperation().equals(ditSOAPOperation) ) {
					totalCount++;
				}
			}
		}
		return totalCount;
	}
	
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			DITResponseDocument ditResponseDocument = (DITResponseDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	double sum=0d;
        	if ( ditResponseDocument.getDitResponseDocumentDetails() != null &&  ditResponseDocument.getDitResponseDocumentDetails().size() > 0 ){         		
        		for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocument.getDitResponseDocumentDetails()) {       		    
        			if (!ditResponseDocumentDetail.isMarkedForDeletion()) {
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                ditResponseDocumentDetail.bindToNode(html); 
        			}
        		}
        	}
       		//Map<String,Object> totalMapForJSSalary = new HashMap<String, Object>();
    		//Map<String,String[]> requestParameterMap=new HashMap<String,String[]>();
    		//totalMapForJSSalary.put("selfassess", selfasses);
    		//Map<String,Object> resultMapSalary = ScreenCalculatorService.getScreenCalculations("selfassess.js", requestParameterMap , totalMapForJSSalary);
    		//setTotal_Amount(Double.parseDouble(resultMapSalary.get("total_selfassess").toString()));
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
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			DITResponseDocumentDetail source =(DITResponseDocumentDetail) child;
			addDITResponseDocumentDetail(source);
		}
		boolean found = false;
		List<DITResponseDocumentDetail> listOfChildren = getDitResponseDocumentDetails();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				DITResponseDocumentDetail destination =(DITResponseDocumentDetail) o;
				DITResponseDocumentDetail source  = (DITResponseDocumentDetail) child;
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
		DITResponseDocumentDetail source =(DITResponseDocumentDetail) child;
		addDITResponseDocumentDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<DITResponseDocumentDetail> listOfChildren = getDitResponseDocumentDetails();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				DITResponseDocumentDetail destination =(DITResponseDocumentDetail) o;
				DITResponseDocumentDetail source  = (DITResponseDocumentDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			DITResponseDocumentDetail source =(DITResponseDocumentDetail) child;
			addDITResponseDocumentDetail(source);
		}		
	}
	
}
