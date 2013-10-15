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

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;



// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:incomefromfirmsdetail")
public class IncomeFromFirmsDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:incomefromfirmsdetail";   
	static final public String NODE_NAME = IncomeFromFirmsDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(IncomeFromFirmsDetail.class); 
	
	

	
	private String firm_PAN ;
	private Double salary_BonusRcv ;
	private Double interest_Rcv;
	private Double total_SalaryAndInterest;
	private Double expenses_RelTotal;
	private Double netIncome;
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getFirm_PAN() {
    	if (firm_PAN == null) firm_PAN = getProperty("mootlywcm:firm_PAN");
    	return firm_PAN;
    }

    public Double getSalary_BonusRcv() {
    	if (salary_BonusRcv == null) salary_BonusRcv = getProperty("mootlywcm:salary_BonusRcv");
    	return salary_BonusRcv;
    }

    public Double getInterest_Rcv() {
    	if (interest_Rcv == null) interest_Rcv = getProperty("mootlywcm:interest_Rcv");
    	return interest_Rcv;
    }
    public Double getTotal_SalaryAndInterest() {
    	if (total_SalaryAndInterest == null) total_SalaryAndInterest = getProperty("mootlywcm:total_SalaryAndInterest");
    	return total_SalaryAndInterest;
    }
    public Double getExpenses_RelTotal() {
    	if (expenses_RelTotal == null) expenses_RelTotal = getProperty("mootlywcm:expenses_RelTotal");
    	return expenses_RelTotal;
    }
    public Double getNetIncome() {
    	   if (netIncome == null) netIncome = getProperty("mootlywcm:netIncome");
    	    	return netIncome;
    }
 
   
   
    public final void setFirm_PAN(String firm_PAN) {
		this.firm_PAN = firm_PAN;
	}
	public final void setSalary_BonusRcv(Double salary_BonusRcv) {
		this.salary_BonusRcv = salary_BonusRcv;
	}
	public final void setTotal_SalaryAndInterest(Double total_SalaryAndInterest) {
		this.total_SalaryAndInterest = total_SalaryAndInterest;
	}
	

	public final void setInterest_Rcv(Double interest_Rcv) {
		this.interest_Rcv = interest_Rcv;
	}
	public final void setExpenses_RelTotal(Double expenses_RelTotal) {
		this.expenses_RelTotal = expenses_RelTotal;
	}
	public final void setNetIncome(Double netIncome) {
		this.netIncome = netIncome;
	}
	
		public final String getPersonalInfoUuid() {
			return personalInfoUuid;
		}
		public final void setPersonalInfoUuid(String personalInfoUuid) {
			this.personalInfoUuid = personalInfoUuid;
		}
		
		public PersonalInformation getPersonalInformation() {
	        HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
	        if (!(bean instanceof HippoMirror)) {
	            return null;
	        }

	        PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();

	        if (prdBean == null) {
	            return null;
	        }
	        return prdBean;
	    }
    
	
		public boolean bindToNode(javax.jcr.Node node)
				throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			
			
			node.setProperty("mootlywcm:firm_PAN", getFirm_PAN());
			node.setProperty("mootlywcm:salary_BonusRcv",getSalary_BonusRcv());
			node.setProperty("mootlywcm:interest_Rcv", getInterest_Rcv());
			node.setProperty("mootlywcm:total_SalaryAndInterest",getTotal_SalaryAndInterest());
			node.setProperty("mootlywcm:expenses_RelTotal",getExpenses_RelTotal());
			node.setProperty("mootlywcm:netIncome",getNetIncome());
			
	    	

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		double defaultValue=0.0d;
		if (formMap == null) return;
		
		if ( formMap.getField("firm_PAN") != null) {
			setFirm_PAN(formMap.getField("firm_PAN").getValue());
		}
		if ( formMap.getField("salary_BonusRcv").getValue() != null) {
			setSalary_BonusRcv(Double.parseDouble(formMap.getField("salary_BonusRcv").getValue()));
		} else setSalary_BonusRcv(defaultValue);
		
		if ( formMap.getField("interest_Rcv").getValue() != null) {
			setInterest_Rcv(Double.parseDouble(formMap.getField("interest_Rcv").getValue()));
		} else setInterest_Rcv(defaultValue);
		
		if ( formMap.getField("total_SalaryAndInterest").getValue() != null) {
			setTotal_SalaryAndInterest(Double.parseDouble(formMap.getField("total_SalaryAndInterest").getValue()));
		} else setTotal_SalaryAndInterest(defaultValue);
		
		if ( formMap.getField("expenses_RelTotal").getValue() != null) {
			setExpenses_RelTotal(Double.parseDouble(formMap.getField("expenses_RelTotal").getValue()));
		}  else setExpenses_RelTotal(defaultValue);
		
		if ( formMap.getField("netIncome").getValue() != null) {
			setNetIncome(Double.parseDouble(formMap.getField("netIncome").getValue()));
		} else setNetIncome(defaultValue);
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		IncomeFromFirmsDetail objIncomeFirms = (IncomeFromFirmsDetail) sourceBean;
		setFirm_PAN(objIncomeFirms.getFirm_PAN());
		setSalary_BonusRcv(objIncomeFirms.getSalary_BonusRcv());
		setInterest_Rcv(objIncomeFirms.getInterest_Rcv());
		setTotal_SalaryAndInterest(objIncomeFirms.getTotal_SalaryAndInterest());
		setExpenses_RelTotal(objIncomeFirms.getExpenses_RelTotal());
		setNetIncome(objIncomeFirms.getNetIncome());
		
	}
}
