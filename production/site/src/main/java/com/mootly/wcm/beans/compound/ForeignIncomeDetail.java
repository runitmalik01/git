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
import static com.mootly.wcm.utils.Constants.COUNTRYCODE;
import static com.mootly.wcm.utils.Constants.TAXPAYERID;
import static com.mootly.wcm.utils.Constants.INCOMESALARY;
import static com.mootly.wcm.utils.Constants.INCOMEHOUSE;
import static com.mootly.wcm.utils.Constants.INCOMEBUSINESS;
import static com.mootly.wcm.utils.Constants.INCOMECAPITALGAIN;
import static com.mootly.wcm.utils.Constants.INCOMESOURCES;
import static com.mootly.wcm.utils.Constants.INCOMETOTAL;

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

@Node(jcrType = "mootlywcm:foreignincomedetail")
public class ForeignIncomeDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:foreignincomedetail";   
	static final public String NODE_NAME = ForeignIncomeDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ForeignIncomeDetail.class); 
	
	private String country_Code ;
	private String taxpayer_ID ;
	private Double income_Salary;
	private Double income_House;
	private Double income_Business;
	private Double income_Capitalgain;
	private Double income_Othersources;
	private Double income_Total;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getCountry_Code() {
    	if (country_Code == null) country_Code = getProperty(COUNTRYCODE);
    	return country_Code;
    }

    public String getTaxpayer_ID() {
    	if (taxpayer_ID == null) taxpayer_ID = getProperty(TAXPAYERID);
    	return taxpayer_ID;
    }

    public Double getIncome_Salary() {
    	if (income_Salary == null) income_Salary = getProperty(INCOMESALARY);
    	return income_Salary;
    }
    public Double getIncome_House() {
    	if (income_House == null) income_House = getProperty(INCOMEHOUSE);
    	return income_House;
    }
    public Double getIncome_Business() {
    	if (income_Business == null) income_Business = getProperty(INCOMEBUSINESS);
    	return income_Business;
    }
    public Double getIncome_Capitalgain() {
    	   if (income_Capitalgain == null) income_Capitalgain = getProperty(INCOMECAPITALGAIN);
    	    	return income_Capitalgain;
    }
    public Double getIncome_Othersources() {
 	   if (income_Othersources == null) income_Othersources = getProperty(INCOMESOURCES);
 	    	return income_Othersources;
    }
    public Double getIncome_Total() {
 	   if (income_Total == null) income_Total = getProperty(INCOMETOTAL);
 	    	return income_Total;
 }
   
   
    public final void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public final void setTaxpayer_ID(String taxpayer_ID) {
		this.taxpayer_ID = taxpayer_ID;
	}
	public final void setIncome_Salary(Double income_Salary) {
		this.income_Salary = income_Salary;
	}
	
	public final void setIncome_House(Double income_House) {
		this.income_House = income_House;
	}
	public final void setIncome_Business(Double income_Business) {
		this.income_Business = income_Business;
	}
	public final void setIncome_Capitalgain(Double income_Capitalgain) {
		this.income_Capitalgain = income_Capitalgain;
	}
	public final void setIncome_Othersources(Double income_Othersources) {
		this.income_Othersources = income_Othersources;
	}
	public final void setincome_Total(Double income_Total) {
		this.income_Total = income_Total;
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
			
			
			node.setProperty(COUNTRYCODE, getCountry_Code());
			node.setProperty(TAXPAYERID,getTaxpayer_ID());
			node.setProperty(INCOMESALARY,getIncome_Salary());
			node.setProperty(INCOMEHOUSE,getIncome_House());
			node.setProperty(INCOMEBUSINESS,getIncome_Business());
			node.setProperty(INCOMECAPITALGAIN,getIncome_Capitalgain());
			node.setProperty(INCOMESOURCES,getIncome_Othersources());
			node.setProperty(INCOMETOTAL,getIncome_Total());
			
	    	

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
		if (formMap == null) return;
		
		if ( formMap.getField("country_code") != null) {
			setCountry_Code(formMap.getField("country_code").getValue());
		}
		if ( formMap.getField("taxpayer_ID") != null) {
			setTaxpayer_ID(formMap.getField("taxpayer_ID").getValue());
		}
		
		if ( formMap.getField("income_salary") != null) {
			 String strIncomeSlry=formMap.getField("income_salary").getValue();
			double IncomeSalary=Double.parseDouble(strIncomeSlry);
			setIncome_Salary(IncomeSalary);
		}
		if ( formMap.getField("income_house") != null) {
			String strIncomeHouse=formMap.getField("income_house").getValue();
			double IncomeHouse=Double.parseDouble(strIncomeHouse);
			setIncome_House(IncomeHouse);
		}
		if ( formMap.getField("income_business") != null) {
			String strIncomeBusiness=formMap.getField("income_business").getValue();
			double IncomeBusiness=Double.parseDouble(strIncomeBusiness);
			setIncome_Business(IncomeBusiness);
		}
		if ( formMap.getField("income_capitalgain") != null) {
			String strIncomeCapital=formMap.getField("income_capitalgain").getValue();
			log.info("strIncomeCapital UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU"+strIncomeCapital);
			double IncomeCapital=Double.parseDouble(strIncomeCapital);
			log.info("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV"+IncomeCapital);
			setIncome_Capitalgain(IncomeCapital);
		}
		if ( formMap.getField("income_othersources") != null) {
			String strIncomeHouse=formMap.getField("income_othersources").getValue();
			double Incomeother=Double.parseDouble(strIncomeHouse);
			setIncome_Othersources(Incomeother);
		}
		if ( formMap.getField("income_total") != null) {
			String strIncomeTotal=formMap.getField("income_total").getValue();
			double IncomeTotal=Double.parseDouble(strIncomeTotal);
			setincome_Total(IncomeTotal);
		}
		
		
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ForeignIncomeDetail objForeignIncome = (ForeignIncomeDetail) sourceBean;
		setCountry_Code(objForeignIncome.getCountry_Code());
		setTaxpayer_ID(objForeignIncome.getTaxpayer_ID());
		setIncome_Salary(objForeignIncome.getIncome_Salary());
		setIncome_Business(objForeignIncome.getIncome_Business());
		setIncome_Capitalgain(objForeignIncome.getIncome_Capitalgain());
		setIncome_Othersources(objForeignIncome.getIncome_Othersources());
		setincome_Total(objForeignIncome.getIncome_Total());
		
	}
}
