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
import java.util.Calendar;

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
import com.mootly.wcm.model.IndianGregorianCalendar;

/**
 * @author BEN-10
 * Date: 2/4/2012
 * 
 */

@Node(jcrType = "mootlywcm:eventlogdetail")
public class EventLogDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:eventlogdetail";   
	static final public String NODE_NAME = EventLogDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(EventLogDetail.class); 

	private String eventLogName ;
	private String eventLogDocument ;
	private String eventLogAction ;
	private String eventLogUrl;
	private Calendar eventLogDate;
	private String eventLogDocumentUrl;

	private String personalInfoUuid;
	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	public String getEventLogName() {
		if(eventLogName == null) eventLogName = getProperty("mootlywcm:eventLogName");
		return eventLogName;
	}
	public void setEventLogName(String eventLogName) {
		this.eventLogName = eventLogName;
	}
	public String getEventLogDocument() {
		if(eventLogDocument == null) eventLogDocument = getProperty("mootlywcm:eventLogDocument");
		return eventLogDocument;
	}
	public void setEventLogDocument(String eventLogDocument) {
		this.eventLogDocument = eventLogDocument;
	}
	public String getEventLogAction() {
		if(eventLogAction == null) eventLogAction = getProperty("mootlywcm:eventLogAction");
		return eventLogAction;
	}
	public void setEventLogAction(String eventLogAction) {
		this.eventLogAction = eventLogAction;
	}
	public String getEventLogUrl() {
		if(eventLogUrl == null) eventLogUrl = getProperty("mootlywcm:eventLogUrl");
		return eventLogUrl;
	}
	public void setEventLogUrl(String eventLogUrl) {
		this.eventLogUrl = eventLogUrl;
	}
	public Calendar getEventLogDate() {
		if(eventLogDate == null) eventLogDate = getProperty("mootlywcm:eventLogDate");
		return eventLogDate;
	}
	public void setEventLogDate(Calendar eventLogDate) {
		this.eventLogDate = eventLogDate;
	}
	public String getEventLogDocumentUrl() {
		if(eventLogDocumentUrl == null) eventLogDocumentUrl = getProperty("mootlywcm:eventLogDocumentUrl");
		return eventLogDocumentUrl;
	}
	public void setEventLogDocumentUrl(String eventLogDocumentUrl) {
		this.eventLogDocumentUrl = eventLogDocumentUrl;
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
			node.setProperty("mootlywcm:eventLogName",getEventLogName());
			node.setProperty("mootlywcm:eventLogAction", getEventLogAction());
			node.setProperty("mootlywcm:eventLogDocument", getEventLogDocument());
			node.setProperty("mootlywcm:eventLogDocumentUrl", getEventLogDocumentUrl());
			node.setProperty("mootlywcm:eventLogDate",IndianGregorianCalendar.getCurrentDateInIndiaAsDate());
			node.setProperty("mootlywcm:eventLogUrl",getEventLogUrl());
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
		if ( formMap.getField("eventLogName") != null) {
			setEventLogName(formMap.getField("eventLogName").getValue());
		}
		if ( formMap.getField("eventLogAction") != null) {
			setEventLogAction(formMap.getField("eventLogAction").getValue());
		}
		if ( formMap.getField("eventLogDocument") != null) {
			setEventLogDocument(formMap.getField("eventLogDocument").getValue());
		}
		if ( formMap.getField("eventLogDocumentUrl") != null) {
			setEventLogDocumentUrl(formMap.getField("eventLogDocumentUrl").getValue());
		}
		if ( formMap.getField("eventLogUrl") != null) {
			setEventLogUrl(formMap.getField("eventLogUrl").getValue());
		}
	}

	public static final SimpleDateFormat getIndianDateFormatter() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		EventLogDetail objEventLogDetail = (EventLogDetail) sourceBean;
		setEventLogName(objEventLogDetail.getEventLogName());
		setEventLogAction(objEventLogDetail.getEventLogAction());
		setEventLogDocument(objEventLogDetail.getEventLogDocument());
		setEventLogDate(objEventLogDetail.getEventLogDate());
		setEventLogUrl(objEventLogDetail.getEventLogUrl());
	}
}
