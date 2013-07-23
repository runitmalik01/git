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

/**
 * Bean mapping class for the 'mootlywcm:address' document type
 */
@Node(jcrType = "mootlywcm:address")
public class Address extends HippoItem {
    public String getStreet() {
        return getProperty("mootlywcm:street");
    }

    public String getNumber() {
        return getProperty("mootlywcm:number");
    }

    public String getCity() {
        return getProperty("mootlywcm:city");
    }

    public String getPostalCode() {
        return getProperty("mootlywcm:postalcode");
    }

    public String getProvince() {
        return getProperty("mootlywcm:province");
    }

    public String getCountry() {
        return getProperty("mootlywcm:country");
    }

    public String getTelephone() {
        return getProperty("mootlywcm:telephone");
    }

    public String getFax() {
        return getProperty("mootlywcm:fax");
    }

    public String getEmail() {
        return getProperty("mootlywcm:email");
    }

    public String getWebsite() {
        return getProperty("mootlywcm:website");
    }

    public String getOptionalText() {
        return getProperty("mootlywcm:optionalText");
    }

    public Double getLatitude() {
        return getProperty("mootlywcm:latitude");
    }

    public Double getLongitude() {
        return getProperty("mootlywcm:longitude");
    }
}
