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
 * User: Megha
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.cms;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetSelect;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.InvoicePaymentStatus;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.SequenceGenerator;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:pbblockdocument")
public class BlockDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller {
	
	private final static Logger log = LoggerFactory.getLogger(BlockDocument.class); 
	
	public static enum BLOCK_TYPE {HTML,CATALOG_COMPONENT};
	
	String title;
	String script;
	Boolean showAsIs;

	@FormField(name="title")
	public final String getTitle() {
		if (title == null) title = getProperty("mootlywcm:title");
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}
	
	public final String getScript() {
		if (script == null) script= getProperty("hst:script");
		return script;
	}

	public final void setScript(String script) {
		this.script = script;
	}
	
	public final Boolean getShowAsIs() {
		if (showAsIs == null) showAsIs = getProperty("mootlywcm:showAsIs");
		return showAsIs;
	}

	public final void setShowAsIs(Boolean showAsIs) {
		this.showAsIs = showAsIs;
	}
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		//super.bindToNode(node);
		BlockDocument blockDocument = (BlockDocument) content;
		try {
			node.setProperty("mootlywcm:title", blockDocument.getTitle());
			node.setProperty("hst:script", blockDocument.getScript());
			node.setProperty("mootlywcm:showAsIs", blockDocument.getShowAsIs());
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		super.fill(formMap);
		if(formMap == null)
			return;
		if(formMap.getField("title")!=null){
			setTitle(formMap.getField("title").getValue());
		}
		if(formMap.getField("script")!=null){
			setScript(formMap.getField("script").getValue());
		}
		if(formMap.getField("showAsIs")!=null){
			setShowAsIs(Boolean.valueOf(formMap.getField("showAsIs").getValue()));
		}
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		super.cloneBean(sourceBean);
	}
}
