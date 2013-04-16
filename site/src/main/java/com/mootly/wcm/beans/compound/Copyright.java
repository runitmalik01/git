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

package com.mootly.wcm.beans.compound;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;

import com.mootly.wcm.utils.Constants;

/**
 * Bean mapping class for the 'mootlywcm:copyright' document type
 */
@Node(jcrType = Constants.NT_COPYRIGHT)
public class Copyright extends HippoItem {
    public String getDescription() {
        return getProperty(Constants.PROP_COPYRIGHT_DESCRIPTION);
    }

    public String getUrl() {
        return getProperty(Constants.PROP_COPYRIGHT_URL);
    }

}
