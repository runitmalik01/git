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
import java.util.Date;
import java.util.List;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.Address;
import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.beans.compound.ImageSetLink;
import com.mootly.wcm.utils.Constants;

@Node(jcrType = "mootlywcm:event")
public class EventDocument extends Document {
	static final public String NAMESPACE = "mootlywcm:event";
    private List<ImageSet> images;
	private Date date;

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
            List<ImageSetLink> links = getChildBeans("hippogallerypicker:imagelink");

            images = new ArrayList<ImageSet>(links.size());

            for (ImageSetLink link : links) {
                HippoBean referenced = link.getReferencedBean();
                if (referenced instanceof ImageSet) {
                    ImageSet imageSet = (ImageSet) referenced;
                    images.add(imageSet);
                }
            }
        }
    }

    public Calendar getDate() {
        return getProperty(Constants.PROP_DATE);
    }
    public Date setDate( Date dt) {
    	 return this.date = dt;
    }


    public Calendar getEndDate() {
        return getProperty(Constants.PROP_ENDDATE);
    }

    public Address getLocation() {
        return getBean(Constants.PROP_LOCATION);
    }
    public Address setLocation() {
        return getBean(Constants.PROP_LOCATION);
    }

    public HippoBean getFormBean() {
        final HippoMirror formMirror = getBean("mootlywcm:form");
        if (formMirror != null) {
            HippoBean fb = formMirror.getReferencedBean();
            if (fb instanceof HippoDocument) {
                //return form bean only if it is a HippoDocument.
                return fb;
            }
        }
        return null;
    }

}
