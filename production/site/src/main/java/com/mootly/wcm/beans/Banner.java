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

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.ImageSet;
import com.mootly.wcm.beans.compound.ImageSetLink;


/**
 * [mootlywcm:banner] > mootlywcm:basedocument
 * - mootlywcm:title (string)
 * + mootlywcm:image (hippogallerypicker:imagelink)
 * + mootlywcm:doclink (hippo:mirror)
 */

@Node(jcrType = "mootlywcm:banner")
public class Banner extends HippoDocument {

    public String getTitle() {
        return getProperty("mootlywcm:title");
    }

    public HippoBean getDocLink() {
        HippoMirror mirrorBean = (HippoMirror) getBean("mootlywcm:doclink");
        return mirrorBean.getReferencedBean();
    }


    public ImageSet getImage() {
        ImageSetLink imageLink = (ImageSetLink) getBean("mootlywcm:image");
        return (ImageSet) imageLink.getReferencedBean();
    }


}
