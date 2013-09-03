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
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.standard.FlexibleDocument;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:interestdocumentdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class InvoiceDocumentDetail extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = InvoiceDocumentDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(InvoiceDocumentDetail.class); 
	private String services;
	private String mode; 
	private String amount;
	private String quantity;
	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
	public final String Amount() {
		if (amount == null) amount = getProperty("mootlywcm:amount");
		return amount;
	}
	
	public final void setAmount(String amount) {
		this.amount = amount;
	}
	public final String getQuantity() {
		if (quantity == null) quantity = getProperty("mootlywcm:quantity");
		return quantity;
	}
	
	public final void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public final String getMode() {
		if (mode == null) mode = getProperty("mootlywcm:mode");
		return mode;
	}
	
	public final String getServices() {
		if (services == null) services = getProperty("mootlywcm:services");
		return services;
	}
	
	public final void setServices(String services) {
		this.services = services;
	}

	public final void setMode(String mode) {
		this.mode = mode;
	}

	
	public boolean bindToNode(javax.jcr.Node node) throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is bean");
			//HouseProperty memberSignup = (HouseProperty) ;
			 node.setProperty("mootlywcm:quantity",getQuantity());
			// node.setProperty("mootlywcm:amount",getAmount());
			 node.setProperty("mootlywcm:services",getServices());
			 node.setProperty("mootlywcm:mode",getMode());
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		
		if (formMap.getField("mode") != null){
			log.info("value"+formMap.getField("mode").getValue());
			setMode(formMap.getField("mode").getValue());
		}
		if (formMap.getField("services") != null){
			log.info("value"+formMap.getField("services").getValue());
			setServices(formMap.getField("services").getValue());
		}
		if (formMap.getField("quantity") != null){
			log.info("value"+formMap.getField("quantity").getValue());
			setQuantity(formMap.getField("quantity").getValue());
		}
		if (formMap.getField("amount") != null){
			log.info("value"+formMap.getField("amount").getValue());
			setAmount(formMap.getField("amount").getValue());
		}
	}


	public <T extends HippoBean> void cloneBean(T sourceBean) {
		InvoiceDocumentDetail objinvoiceDetail = (InvoiceDocumentDetail) sourceBean;
		setQuantity(objinvoiceDetail.getQuantity());
		//setAmount(objinvoiceDetail.getAmount());
		setMode(objinvoiceDetail.getMode());
		setServices(objinvoiceDetail.getServices());
		
	};
}
