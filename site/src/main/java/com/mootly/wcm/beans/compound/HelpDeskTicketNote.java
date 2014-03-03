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
 * User: megha
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.compound;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.NodeBinder;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.UserType;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.utils.BeanCloneHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;
import com.mootly.wcm.utils.NodeBinderHelper;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:HelpDeskTicketNote")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class HelpDeskTicketNote extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = HelpDeskTicketNote.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(HelpDeskTicketNote.class); 
	
	final String PROP_Q = "mootlywcm:question";
	final String PROP_A = "mootlywcm:answer";
	final String PROP_NOTE = "mootlywcm:note";
	final String PROP_SCRIPT_NAME = "mootlywcm:scriptName";
	final String PROP_FILE_NAME = "mootlywcm:fileName";
	final String PROP_UPDATER_TYPE = "mootlywcm:updaterType";
	
	final String PROP_ANSWERED = "mootlywcm:answered";
	final String PROP_IS_QA = "mootlywcm:isqa";
	final String PROP_READ = "mootlywcm:read";
	
	private String question;
	private String answer;
	private String note;
	private String fileName;
	private String scriptName;
	private String strUpdaterType;
	private UserType updaterType;
	
	private Boolean answered;
	private Boolean isqa;
	private Boolean read;
	
	
	private boolean markedForDeletion;
	
	@FormField(name="question")
	@NodeBinder(nodePropertyName=PROP_Q,propertyName="question")
	public String getQuestion() {
		if (question == null) question = getProperty(PROP_Q);
		return question;
	}
	
	@FormField(name="answer")
	@NodeBinder(nodePropertyName=PROP_A,propertyName="answer")
	public String getAnswer() {
		if (answer == null) answer = getProperty(PROP_A);
		return answer;
	}
	
	@FormField(name="fileName")
	@NodeBinder(nodePropertyName=PROP_FILE_NAME,propertyName="fileName")
	public String getFileName() {
		if (fileName == null) fileName = getProperty(PROP_FILE_NAME);
		return fileName;
	}
	
	@FormField(name="note")
	@NodeBinder(nodePropertyName=PROP_NOTE,propertyName="note")
	public final String getNote() {
		if (note == null) note = getProperty(PROP_NOTE);
		return note;
	}
	
	@FormField(name="scriptName")
	@NodeBinder(nodePropertyName=PROP_SCRIPT_NAME,propertyName="scriptName")
	public final String getScriptName() {
		if (scriptName == null) scriptName = getProperty(PROP_SCRIPT_NAME);
		return scriptName;
	}
	
	@FormField(name="strUpdaterType")
	@NodeBinder(nodePropertyName=PROP_UPDATER_TYPE,propertyName="strUpdaterType")
	public final String getStrUpdaterType() {
		if (strUpdaterType == null) strUpdaterType = getProperty(PROP_UPDATER_TYPE);
		return strUpdaterType;
	}

	public final UserType getUpdaterType() {
		getStrUpdaterType();
		if( strUpdaterType != null) {
			updaterType = UserType.valueOf(strUpdaterType);
		}
		return updaterType;
	}
	
	@FormField(name="answered",convert=Boolean.class)
	@NodeBinder(nodePropertyName=PROP_ANSWERED,propertyName="answered")
	public Boolean getAnswered() {
		if (answered == null) answered = getProperty(PROP_ANSWERED);
		return answered;
	}

	@FormField(name="isqa",convert=Boolean.class)
	@NodeBinder(nodePropertyName=PROP_IS_QA,propertyName="isqa")
	public Boolean getIsqa() {
		if (isqa == null) isqa = getProperty(PROP_IS_QA);
		return isqa;
	}

	@FormField(name="read",convert=Boolean.class)
	@NodeBinder(nodePropertyName=PROP_READ,propertyName="read")
	public Boolean getRead() {
		if (read == null) read = getProperty(PROP_READ);
		return read;
	}

	@BeanClone
	public final void setNote(String note) {
		this.note = note;
	}
	
	@BeanClone
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public final void setUpdaterType(UserType updaterType) {
		this.updaterType = updaterType;
		if (updaterType == null) {
			this.strUpdaterType = null; 
		}
		else {
			this.strUpdaterType = updaterType.name();
		}
	}
	
	@BeanClone
	public final void setStrUpdaterType(String strUpdaterType) {
		this.strUpdaterType = strUpdaterType;
		if (strUpdaterType == null) {
			this.updaterType = null; 
		}
		else {
			this.updaterType = UserType.valueOf(strUpdaterType);
		}
	}
	
	@BeanClone
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@BeanClone
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@BeanClone
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@BeanClone
	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

	@BeanClone
	public void setIsqa(Boolean isqa) {
		this.isqa = isqa;
	}

	@BeanClone
	public void setRead(Boolean read) {
		this.read = read;
	}

	public boolean bindToNode(javax.jcr.Node node) throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		//try {
		super.bindToNode(node);
		NodeBinderHelper nodeBinderHelper = new NodeBinderHelper();
		nodeBinderHelper.bindObjectToNode(node, this);		
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		super.fill(formMap);
		FormMapHelper formMapHelper = new FormMapHelper();
		formMapHelper.fillFromFormMap(this, formMap);
		CalculatedFieldHelper calculatedFieldHelper = new CalculatedFieldHelper();
		calculatedFieldHelper.processCalculatedFields(this);
	}

	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		HelpDeskTicketNote objinvoiceDetail = (HelpDeskTicketNote) sourceBean;
		super.cloneBean(sourceBean);
		BeanCloneHelper beanCloneHelper = new BeanCloneHelper();
		beanCloneHelper.cloneTheBean(sourceBean,this);		
	}
}
