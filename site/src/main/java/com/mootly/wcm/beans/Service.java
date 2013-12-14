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
import java.util.List;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.CostModel;
import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.beans.compound.ImageSetLink;
import com.mootly.wcm.utils.Constants;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:Service")
public class Service extends Document {
    
    private List<ImageSet> images;
    Double cost;
    
    public List<ImageSet> getImages() {
        initImages();
        return images;
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
	private String PROP_PI_PERSONALINFO_LINK="mootlywcm:srForm";
	
    public String getID() {
        return getProperty("mootlywcm:id");
    }
    
    public String getName() {
        return getProperty("mootlywcm:Name");
    }

    public String getServiceCode() {
        return getProperty("mootlywcm:serviceCode");
    }

    public Boolean getEnable() {
        return getProperty("mootlywcm:enable");
    }

    public String[] getCategories() {
        return getProperty("mootlywcm:categories");
    }

    public String[] getOfferingMode() {
        return getProperty("mootlywcm:offeringmode");
    }
    
    public Double getCost() {
    	if (cost == null) cost = getProperty("mootlywcm:cost");
    	return cost;
    }

    public List<CostModel> getCostModel() {
        return getChildBeans("mootlywcm:costmodel");
    }

    public String getServiceDescription() {
        return getProperty("mootlywcm:description");
    }
    
    public String[] getHighlights() {
        return getProperty("mootlywcm:highlights");
    }
    
    public String[] getSubCategories() {
        return getProperty("mootlywcm:subCategories");
    }
    
    public ServiceRequestForm getServiceRequestForm() {
    	HippoBean bean = getBean(PROP_PI_PERSONALINFO_LINK);
    	if (!(bean instanceof HippoMirror)) {
    		return null;
    	}
    	ServiceRequestForm prdBean = (ServiceRequestForm) ((HippoMirror) bean).getReferencedBean();
    	if (prdBean == null) {
    		return null;
    	}
    	return prdBean;
    }

}
