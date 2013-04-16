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
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.springframework.beans.factory.config.SetFactoryBean;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:houseincome")
public class HouseProperty extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:houseincome";
	static final public String NODE_NAME = "houseincome";
	private String grossAnnualIncome;
	private String unrealisedRent;
	private String localTaxes;
	private String totalIncome;
	private String interestBorrowed1;
	private String interestBorrowed2;
	private String incomeHproperty;
	
	
	//for personal information
	public String getGrossAnnualIncome() {
        if (grossAnnualIncome == null) grossAnnualIncome = getProperty("mootlywcm:grossAnnualIncome");
        return grossAnnualIncome;
    }

    public String getUnrealisedRent() {
    	if (unrealisedRent == null) unrealisedRent = getProperty("mootlywcm:unrealisedRent");
    	return unrealisedRent;
    }

    public String getLocalTaxes() {
    	if (localTaxes== null) localTaxes= getProperty("mootlywcm:localTaxes");
    	return localTaxes;
    }

    public String getTotalIncome() {
    	if (totalIncome == null) totalIncome = getProperty("mootlywcm:totalIncome");
    	return totalIncome;
    }

    public String getInterestBorrowed1() {
    	if (interestBorrowed1 == null) interestBorrowed1= getProperty("mootlywcm:interestBorrowed1");
    	return interestBorrowed1;
    }
    public String getInterestBorrowed2() {
    	if (interestBorrowed2 == null) interestBorrowed2= getProperty("mootlywcm:interestBorrowed2");
    	return interestBorrowed2;
    }
    public String getIncomeHproperty() {
    	if (incomeHproperty == null) incomeHproperty = getProperty("mootlywcm:incomeHproperty");
    	return incomeHproperty;
    }
    public final void setGrossAnnualIncome(String  GrossAnnualIncome) {
		this. grossAnnualIncome =  GrossAnnualIncome;
	}

	public final void setUnrealisedRent(String UnrealisedRent) {
		this.unrealisedRent = UnrealisedRent;
	}

	public final void setLocalTaxes(String LocalTaxes) {
		this.localTaxes = LocalTaxes;
	}
 
	public final void setTotalIncome(String TotalIncome) {
		this.totalIncome = TotalIncome;
	}
	public final void setInterestBorrowed1(String InterestBorrowed1) {
		this.interestBorrowed1 = InterestBorrowed1;
	}
	public final void setInterestBorrowed2(String InterestBorrowed2) {
		this.interestBorrowed2 = InterestBorrowed2;
	}
	public final void setIncomeHproperty(String IncomeHproperty) {
		this.incomeHproperty = IncomeHproperty;
	}
	
    
	
//for house property
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is bean");
			HouseProperty memberSignup = (HouseProperty) content;
			node.setProperty("mootlywcm:grossAnnualIncome",memberSignup.getGrossAnnualIncome());
	    	node.setProperty("mootlywcm:unrealisedRent",memberSignup.getUnrealisedRent());
	    	node.setProperty("mootlywcm:localTaxes", memberSignup.getLocalTaxes());
	    	node.setProperty("mootlywcm:totalIncome", memberSignup.getTotalIncome());
	    	node.setProperty("mootlywcm:interestBorrowed1", memberSignup.getInterestBorrowed1());
	    	node.setProperty("mootlywcm:interestBorrowed2", memberSignup.getInterestBorrowed2());
	    	node.setProperty("mootlywcm:incomeHproperty", memberSignup.getIncomeHproperty());
	    	 	
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (formMap == null) return;
		if (formMap.getField("Gross_Annual_Income") != null) setGrossAnnualIncome(formMap.getField("Gross_Annual_Income").getValue());
		if (formMap.getField("Unrealised_Rent") != null) setUnrealisedRent(formMap.getField("Unrealised_Rent").getValue());
		if (formMap.getField("Local_Taxes") != null) setLocalTaxes(formMap.getField("Local_Taxes").getValue());
		if (formMap.getField("Interest_Borrowed2") != null) setInterestBorrowed2(formMap.getField("Interest_Borrowed2").getValue());
		if (formMap.getField("Interest_Borrowed1") != null) setInterestBorrowed1(formMap.getField("Interest_Borrowed1").getValue());
		if (formMap.getField("Total_Income") != null) setTotalIncome(formMap.getField("Total_Income").getValue());
		if (formMap.getField("Income_Hproperty") != null) setIncomeHproperty(formMap.getField("Income_Hproperty").getValue());
	}

	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
