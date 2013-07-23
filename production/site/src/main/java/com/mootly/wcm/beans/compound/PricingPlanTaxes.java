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
@Node(jcrType = "mootlywcm:PricingPlanTaxes")
public class PricingPlanTaxes extends HippoItem {
    public Boolean getTdsSalary() {
        return getProperty("mootlywcm:tdssalary");
    }

    public Boolean getTdsOther() {
        return getProperty("mootlywcm:tdsother");
    }

    public Boolean getTcs() {
        return getProperty("mootlywcm:tcs");
    }

    public Boolean getAdvanceTax() {
        return getProperty("mootlywcm:advancetax");
    }

    public Boolean getSelfAssessmentTax() {
        return getProperty("mootlywcm:sefassessment");
    }
}
