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
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.math.BigInteger;
import java.util.Calendar;

import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.CalculatedField;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.NodeBinder;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.annotations.prop.FormMapKey;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.model.UserType;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.Transaction.ENQUIRY_RESP_CODE;
import com.mootly.wcm.utils.BeanCloneHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;
import com.mootly.wcm.utils.NodeBinderHelper;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:HelpDeskTicketNote")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class HelpDeskTicketNote extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = HelpDeskTicketNote.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(HelpDeskTicketNote.class); 

	final String PROP_NOTE = "mootlywcm:note";
	final String PROP_UPDATER_TYPE = "mootlywcm:updaterType";
	
	String note;
	String strUpdaterType;
	UserType updaterType;
	
	
	private boolean markedForDeletion;
	
	@FormField(name="note")
	@NodeBinder(nodePropertyName=PROP_NOTE,propertyName="note")
	public final String getNote() {
		if (note == null) note = getProperty(PROP_NOTE);
		return note;
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


	@BeanClone
	public final void setNote(String note) {
		this.note = note;
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
