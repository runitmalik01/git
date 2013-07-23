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

import java.util.Calendar;
import java.util.Date;

import org.hippoecm.hst.content.beans.Node;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@Node(jcrType = "mootlywcm:job")
public class JobsDocument extends Document {

    public Date getClosingDate() {
        Calendar cal = getProperty("mootlywcm:closingdate");
        if (cal == null) {
            return null;
        }
        return cal.getTime();
    }

    public String[] getIndustries() {
        return getProperty("mootlywcm:industries");
    }

    public Double getExperience() {
        return getProperty("mootlywcm:experience");
    }

    public String getEducation() {
        return getProperty("mootlywcm:education");
    }

    public String getLocation() {
        return getProperty("mootlywcm:location");
    }

    public Double getSalary() {
        return getProperty("mootlywcm:salary");
    }

    public String getJobtype() {
        return getProperty("mootlywcm:title");
    }
    public String getEmployer()
    {
        return getProperty("mootlywcm:employer");
    }
}
