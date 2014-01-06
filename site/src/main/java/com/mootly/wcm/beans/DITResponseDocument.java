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

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:ditResponseDocument")
public class DITResponseDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate { 
	
	private List<DITResponseDocumentDetail> ditResponseDocumentDetailList;
	final String PROP_DETAIL_BEAN="mootlywcm:ditResponseDocumentDetail";

	public final List<DITResponseDocumentDetail> getDitResponseDocumentDetails() {
		if (ditResponseDocumentDetailList == null) ditResponseDocumentDetailList = getChildBeans(PROP_DETAIL_BEAN);
		return ditResponseDocumentDetailList;
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
				log.info("GOT A MATCH");
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
