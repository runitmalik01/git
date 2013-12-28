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

import com.mootly.wcm.beans.compound.PricingPlanAdditionalServices;
import com.mootly.wcm.beans.compound.PricingPlanDeductions;
import com.mootly.wcm.beans.compound.PricingPlanIncome;
import com.mootly.wcm.beans.compound.PricingPlanTaxes;

@Node(jcrType="mootlywcm:PricingPlan")
public class PricingPlan extends BaseDocument {

	public String getTitle() {
		return getProperty("mootlywcm:title");
	}

	public String getEfilePricing() {
		return getProperty("mootlywcm:efilepricing");
	}

	public String getEzfilePricing() {
		return getProperty("mootlywcm:ezfilepricing");
	}

	public String getDescription() {
		return getProperty("mootlywcm:desciption");
	}
	public String[] getFeatures() {
		return getProperty("mootlywcm:features");
	}

	public Boolean getEfiling() {
		return getProperty("mootlywcm:efiling");
	}

	public PricingPlanDeductions getPricingPlanDeductions(){
		return getBean("mootlywcm:pricingplandeductions");
	}
	public PricingPlanIncome getPricingPlanIncome(){
		return getBean("mootlywcm:pricingplanincome");
	}
	public PricingPlanTaxes getPricingPlanTaxes(){
		return getBean("mootlywcm:pricingplantaxes");
	}
	public PricingPlanAdditionalServices getPricingPlanAdditionalServices(){
		return getBean("mootlywcm:pricingplanadditionalservices");
	}

}
