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
import com.mootly.wcm.beans.cms.compound.PageRowDetail;
import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.compound.InvoiceRefundDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.InvoicePaymentStatus;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.SequenceGenerator;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:pbpagedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class PageDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller {
	
	private final static Logger log = LoggerFactory.getLogger(PageDocument.class); 
	final String PROP_DETAIL_BEAN="mootlywcm:pbpagerowdetail";

	String title;
	List<HippoBean> blocks;
	
	private List<PageRowDetail> pageRowDetails;

	@FormField(name="title")
	public final String getTitle() {
		if (title == null) title = getProperty("mootlywcm:title");
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}
	
	
	public List<HippoBean> getBlocks() {
		if (blocks == null) {
			loadBlocks();
		}
		return blocks;
	}
	
	private void loadBlocks() {
		blocks = new ArrayList<HippoBean>();
		List<HippoBean> hippoBeans = getChildBeansByName("mootlywcm:blocks");
		log.info("Testing");
		if (hippoBeans != null) {
			for (HippoBean hippoBean : hippoBeans) {
				 if (hippoBean instanceof HippoMirror) {
					 HippoMirror hippoMirror = (HippoMirror) hippoBean;
					 blocks.add( hippoMirror.getReferencedBean() );
				 }
			}
		}
		//getChildBeans(mootlywcm:blocks)
		/*
		String[] mirrors = getProperty("mootlywcm:blocks", new String[]{});
        for (String mirror : mirrors) {
            if (mirror instanceof HippoFacetSelect) {
                HippoFacetSelect facetSelect = (HippoFacetSelect) mirror;
                HippoBean referenced = facetSelect.getReferencedBean();
                if (referenced instanceof BlockDocument) {
                	BlockDocument image = (BlockDocument) referenced;
                    blocks.add(image);
                }
            }
        }
        */
    }
	
	public final List<PageRowDetail> getPageRowDetails() {
		if (pageRowDetails == null) pageRowDetails= getChildBeans(PROP_DETAIL_BEAN);
		return pageRowDetails;
	}

	public final void setPageRowDetails(List<PageRowDetail> pageRowDetails) {
		this.pageRowDetails = pageRowDetails;
	}

	public final void addPageRowDetail(PageRowDetail pageRowDetail) {
		getPageRowDetails();
		if (pageRowDetails == null) pageRowDetails = new ArrayList<PageRowDetail>();
		pageRowDetails.add(pageRowDetail);
	}
	

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
