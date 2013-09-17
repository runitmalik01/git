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

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.CalculatedField;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.NodeBinder;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.utils.BeanCloneHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;
import com.mootly.wcm.utils.NodeBinderHelper;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:invoicedocumentdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class InvoiceDocumentDetail extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = InvoiceDocumentDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(InvoiceDocumentDetail.class); 

	private String serviceName;
	private String serviceDesc;
	private Double serviceQty;
	private Double serviceRate;
	private Double serviceAmount;
	
	private String filingMode; 
	private boolean markedForDeletion;
	
	@FormField(name="serviceName",propertyName="serviceName",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:serviceName",propertyName="serviceName")	
	public final String getServiceName() {
		if (serviceName == null) NodeBinderHelper.setObjectProperty("serviceName", this, "");
		return serviceName;
	}
	
	@FormField(name="serviceDesc",propertyName="serviceDesc",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:serviceDescription",propertyName="serviceDesc")	
	public final String getServiceDesc() {
		if (serviceDesc == null) NodeBinderHelper.setObjectProperty("serviceDesc", this, "");
		return serviceDesc;
	}
	
	@FormField(name="serviceQty",propertyName="serviceQty",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:serviceQuantity",propertyName="serviceQty")	
	public final Double getServiceQty() {
		if (serviceQty == null) NodeBinderHelper.setObjectProperty("serviceQty", this, "");
		return serviceQty;
	}

	@FormField(name="serviceRate",propertyName="serviceRate",dataTypeValidationTypes={},convert = Double.class)
	@NodeBinder(nodePropertyName="mootlywcm:serviceRate",propertyName="serviceRate")	
	public final Double getServiceRate() {
		if (serviceRate == null) NodeBinderHelper.setObjectProperty("serviceRate", this, 0.00D);
		return serviceRate;
	}
	
	@FormField(name="filingMode",propertyName="filingMode",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:filingMode",propertyName="filingMode")	
	public final String getFilingMode() {
		if (filingMode == null) NodeBinderHelper.setObjectProperty("filingMode", this, "");
		return filingMode;
	}
	
	@NodeBinder(nodePropertyName="mootlywcm:serviceAmount",propertyName="serviceAmount")	
	public Double getServiceAmount() {
		if (serviceAmount == null) NodeBinderHelper.setObjectProperty("serviceAmount", this, "");
		return serviceAmount;
	}
	
	@BeanClone(propertyName="serviceName")
	public final void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@BeanClone(propertyName="serviceDesc")
	public final void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	
	@BeanClone(propertyName="serviceQty")
	public final void setServiceQty(Double serviceQty) {
		this.serviceQty = serviceQty;
	}

	@BeanClone(propertyName="serviceRate")
	public final void setServiceRate(Double serviceRate) {
		this.serviceRate = serviceRate;
	}

	@BeanClone(propertyName="filingMode")
	public final void setFilingMode(String filingMode) {
		this.filingMode = filingMode;
	}
	
	@CalculatedField(springExpression="#serviceRate * #serviceQty")
	@BeanClone(propertyName="serviceAmount")
	public void setServiceAmount(Double serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
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
		InvoiceDocumentDetail objinvoiceDetail = (InvoiceDocumentDetail) sourceBean;
		super.cloneBean(sourceBean);
		BeanCloneHelper beanCloneHelper = new BeanCloneHelper();
		beanCloneHelper.cloneTheBean(sourceBean,this);
	}
}
