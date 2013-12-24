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

package com.mootly.wcm.beans.cms.compound;

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.text.SimpleDateFormat;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.compound.PersonalInformation;

/**
 * @author BEN-10
 * Date: 2/4/2012
 * 
 */

@Node(jcrType = "mootlywcm:dashboardshortcutdetail")
public class DashboardShortcutDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:dashboardshortcutdetail";   
	static final public String NODE_NAME = DashboardShortcutDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(DashboardShortcutDetail.class); 

	private String shortcutLabel ;
	private Boolean enable ;
	private String contentFolder ;
	private String documentType;
	private Long weight;

	private String personalInfoUuid;
	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	public String getShortcutLabel() {
		if(shortcutLabel == null) shortcutLabel = getProperty("mootlywcm:shortcutLabel");
		return shortcutLabel;
	}
	public void setShortcutLabel(String shortcutLabel) {
		this.shortcutLabel = shortcutLabel;
	}
	public Boolean getEnable() {
		if(enable == null) enable = getProperty("mootlywcm:enable");
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getContentFolder() {
		if(contentFolder == null) contentFolder = getProperty("mootlywcm:contentFolder");
		return contentFolder;
	}
	public void setContentFolder(String contentFolder) {
		this.contentFolder = contentFolder;
	}
	public String getDocumentType() {
		if(documentType == null) documentType = getProperty("mootlywcm:documentType");
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public Long getWeight() {
		if(weight == null) weight = getProperty("mootlywcm:weight");
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
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
	public void bindToNode(javax.jcr.Node node) throws RepositoryException {
		try {
			log.warn("Bind to Node for TdsSalary Called");
			node.setProperty("mootlywcm:shortcutLabel",getShortcutLabel());
			node.setProperty("mootlywcm:contentFolder", getContentFolder());
			node.setProperty("mootlywcm:enable", getEnable());
			node.setProperty("mootlywcm:weight",getWeight());
			node.setProperty("mootlywcm:documentType",getDocumentType());
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);
			throw re;
		}
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;

	}

	public static final SimpleDateFormat getIndianDateFormatter() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		DashboardShortcutDetail objDashboardShortcutDetail = (DashboardShortcutDetail) sourceBean;
		setShortcutLabel(objDashboardShortcutDetail.getShortcutLabel());
		setContentFolder(objDashboardShortcutDetail.getContentFolder());
		setEnable(objDashboardShortcutDetail.getEnable());
		setWeight(objDashboardShortcutDetail.getWeight());
		setDocumentType(objDashboardShortcutDetail.getDocumentType());
	}
}
