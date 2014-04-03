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
import com.mootly.wcm.beans.compound.OTPResponseDocumentDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.DITSubmissionStatus;
import com.mootly.wcm.model.VerificationStatus;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:otpResponseDocument")
@DoNotDuplicate
public class OTPResponseDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate { 
	
	private List<OTPResponseDocumentDetail> otpResponseDocumentDetailList;
	final String PROP_DETAIL_BEAN="mootlywcm:otpResponseDocumentDetail";
	
	int totalCountLastOperation;

	public final List<OTPResponseDocumentDetail> getOtpResponseDocumentDetails() {
		if (otpResponseDocumentDetailList == null) otpResponseDocumentDetailList = getChildBeans(PROP_DETAIL_BEAN);
		return otpResponseDocumentDetailList;
	}
	
	public void setOtpResponseDocumentDetails(
			List<OTPResponseDocumentDetail> otpResponseDocumentDetailList) {
		this.otpResponseDocumentDetailList = otpResponseDocumentDetailList;
	}
	
	public final void addOTPResponseDocumentDetail(OTPResponseDocumentDetail otpResponseDocumentDetail) {
		getOtpResponseDocumentDetails();
		if (otpResponseDocumentDetailList == null) otpResponseDocumentDetailList = new ArrayList<OTPResponseDocumentDetail>();
		otpResponseDocumentDetailList.add(otpResponseDocumentDetail);
	}
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			OTPResponseDocument otpResponseDocument = (OTPResponseDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	double sum=0d;
        	if ( otpResponseDocument.getOtpResponseDocumentDetails() != null &&  otpResponseDocument.getOtpResponseDocumentDetails().size() > 0 ){         		
        		for (OTPResponseDocumentDetail otpResponseDocumentDetail:otpResponseDocument.getOtpResponseDocumentDetails()) {       		    
        			if (!otpResponseDocumentDetail.isMarkedForDeletion()) {
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                otpResponseDocumentDetail.bindToNode(html); 
        			}
        		}
        	}
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
			OTPResponseDocumentDetail source =(OTPResponseDocumentDetail) child;
			addOTPResponseDocumentDetail(source);
		}
		boolean found = false;
		List<OTPResponseDocumentDetail> listOfChildren = getOtpResponseDocumentDetails();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				OTPResponseDocumentDetail destination =(OTPResponseDocumentDetail) o;
				OTPResponseDocumentDetail source  = (OTPResponseDocumentDetail) child;
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
		OTPResponseDocumentDetail source =(OTPResponseDocumentDetail) child;
		addOTPResponseDocumentDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<OTPResponseDocumentDetail> listOfChildren = getOtpResponseDocumentDetails();
		for (HippoBean o:listOfChildren) {
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				OTPResponseDocumentDetail destination =(OTPResponseDocumentDetail) o;
				OTPResponseDocumentDetail source  = (OTPResponseDocumentDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			OTPResponseDocumentDetail source =(OTPResponseDocumentDetail) child;
			addOTPResponseDocumentDetail(source);
		}		
	}
}
