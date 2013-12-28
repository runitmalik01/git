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

package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.MemberDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:memberdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class MemberDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:memberdetail";
	static final public String NODE_NAME = MemberDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(MemberDocument.class); 
	private String attachment;
	private String notes;
	private String personalInfoUuid;
	
	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information
	public final String getAttachment() {
		if (attachment == null) attachment = getProperty("mootlywcm:attach");
		return attachment;
	}
	
	public final String getNotes() {
		if (notes== null) notes = getProperty("mootlywcm:attach_name");
		return notes;
	}
	
	
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
//for personal information
	public final String getPersonalInfoUuid() {
		return personalInfoUuid;
	}
	
	public final void setPersonalInfoUuid(String personalInfoUuid) {
		this.personalInfoUuid = personalInfoUuid;
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
	
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if(getAttachment()!=null){
			node.setProperty("mootlywcm:attach", getAttachment());
			}
			if(getNotes()!=null){
			node.setProperty("mootlywcm:attach_name", getNotes());
			}		
		}
	
	catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		
		if ( formMap.getField("attachments").getValue().isEmpty()) {}
		else{
			setAttachment(formMap.getField("attachments").getValue());
		}
		if ( formMap.getField("notes").getValue().isEmpty()) {}
		else{
			setNotes(formMap.getField("notes").getValue());
		}
		
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		MemberDetail salaryIncomeDetail = (MemberDetail) sourceBean;
		setAttachment(salaryIncomeDetail.getAttachment());
		setNotes(salaryIncomeDetail.getNotes());
		
	};
}
