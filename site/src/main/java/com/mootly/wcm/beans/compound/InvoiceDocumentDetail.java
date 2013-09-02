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
	
	private Integer quantity;
	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
	public final Integer getQuantity() {
		if (quantity == null) quantity = getProperty("mootlywcm:quantity");
		return quantity;
	}
	
	public final void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean bindToNode(javax.jcr.Node node) throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is bean");
			//HouseProperty memberSignup = (HouseProperty) ;
			if (getQuantity() != null) node.setProperty("mootlywcm:quantity",getQuantity());
			
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		

	}


	public <T extends HippoBean> void cloneBean(T sourceBean) {
		InvoiceDocumentDetail objhouseIncomeDetail = (InvoiceDocumentDetail) sourceBean;

		
	};
}
