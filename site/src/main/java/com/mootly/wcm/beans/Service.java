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


import java.util.List;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.CostModel;


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

    public List<CostModel> getCostModel() {
        return getChildBeans("mootlywcm:costmodel");
    }

    public String getServiceDescription() {
        return getProperty("mootlywcm:description");
    }
    
    public String getHighlights() {
        return getProperty("mootlywcm:highlights");
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
