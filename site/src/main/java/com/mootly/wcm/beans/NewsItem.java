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

package com.mootly.wcm.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoAssetBean;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.hippoecm.hst.content.beans.standard.HippoMirrorBean;

import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.beans.compound.ImageSetLink;
import com.mootly.wcm.utils.Constants;

//@Node(jcrType=Constants.NT_NEWSITEM)
@Node(jcrType = "mootlywcm:newsitem")

public class NewsItem extends Document  implements FormMapFiller{
	static final public String NAMESPACE = "mootlywcm:newsitem";
    private List<ImageSet> images;
    private List<HippoAssetBean> attachments;
    
    public List<ImageSet> getImages() {
        initImages();
        return images;
    }
    
    public List<HippoAssetBean> getAttachments() {
        initAttachments();
        return attachments;
    }

    public ImageSet getFirstImage() {
        initImages();
        return images.isEmpty() ? null : images.get(0);
    }
    
    private void initImages() {
        if (images == null) {
            List<ImageSetLink> links = getChildBeans(Constants.PROP_IMAGELINK);

            images = new ArrayList<ImageSet>(links.size());
            
            for (ImageSetLink link: links) {
                HippoBean referenced = link.getReferencedBean();
                if (referenced instanceof ImageSet) {
                    ImageSet imageSet = (ImageSet)referenced;
                    images.add(imageSet);
                }
            }
        }
    }
    
    private void initAttachments() {
        if (attachments == null) {
            List<HippoMirrorBean> links = getChildBeansByName("mootlywcm:attachments");
            attachments = new ArrayList<HippoAssetBean>(links.size());
            
            for (HippoMirrorBean link: links) {            	
                HippoBean referenced = link.getReferencedBean();
                if (referenced instanceof HippoAssetBean) {
                	HippoAssetBean hippoMirrorBean = (HippoAssetBean)referenced;    
                    attachments.add(hippoMirrorBean);
                }
            }
        }
    }
    
    public Calendar getDate() {
        return getProperty(Constants.PROP_DATE);
    }

    public String[] getCategories() {
        return getProperty(Constants.PROP_CATEGORIES);
    }  
    
    @Override
    public boolean bind(Object content, javax.jcr.Node node)
    		throws ContentNodeBindingException {
    	// TODO Auto-generated method stub
    	return super.bind(content, node);
    }
    
    @Override
    public void fill(FormMap formMap) {
    	// TODO Auto-generated method stub
    	super.fill(formMap);
    }
}
