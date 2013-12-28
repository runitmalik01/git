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
import static com.mootly.wcm.utils.Constants.income_Chargeable;
import static com.mootly.wcm.utils.Constants.name_Employer;
import static com.mootly.wcm.utils.Constants.tan_Employer;
import static com.mootly.wcm.utils.Constants.total_Taxdeducted;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.FormMapFiller;


/**
 * User: Pankaj Singh
 * Date: 3/13/2013
 * 
 */

// this bean is used for processapplication.jsp
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
@Node(jcrType = "mootlywcm:tdsfromsalarydetail")
public class TdsFromSalaryDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:tdsfromsalarydetail";            
	static final public String NODE_NAME = TdsFromSalaryDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(TdsFromSalaryDetail.class); 

	
	private String tan_employer ;
	private String name_employer ;
	private Double income_chargeable ;
	private Double total_taxdeducted;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
	
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getTan_Employer() {
    	if (tan_employer == null) tan_employer = getProperty(tan_Employer);
    	return tan_employer;
    }

    public String getName_Employer() {
    	if (name_employer == null) name_employer = getProperty(name_Employer);
    	return name_employer;
    }

    public Double getIncome_Chargeable() {
    	if (income_chargeable == null) income_chargeable = getProperty(income_Chargeable);
    	
    	return income_chargeable;
    }
 
    public Double getTotal_TaxDeducted() {
    	if (total_taxdeducted == null) total_taxdeducted = getProperty(total_Taxdeducted);
    	return total_taxdeducted;
    }
   
	public final void setTan_Employer(String tan_employer) {
		this.tan_employer = tan_employer;
	}
	public final void setName_Employer(String name_employer) {
		this.name_employer = name_employer;
	}
	public final void setIncome_Chargeable(Double income_chargeable) {
		this.income_chargeable = income_chargeable;
	}

	public final void setTotal_TaxDeducted(Double total_taxdeducted) {
		this.total_taxdeducted = total_taxdeducted;
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
			
	   	node.setProperty(tan_Employer, getTan_Employer());
	   	node.setProperty(name_Employer, getName_Employer());
	   	node.setProperty(income_Chargeable, getIncome_Chargeable());
	   	node.setProperty(total_Taxdeducted, getTotal_TaxDeducted());
	   	

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
		
		if ( formMap.getField("tan_employertds") != null) {
			setTan_Employer(formMap.getField("tan_employertds").getValue());
		}
		if ( formMap.getField("name_employertds") != null) {
			setName_Employer(formMap.getField("name_employertds").getValue());
		}
		if ( formMap.getField("income_chargeabletds") != null) {
			String strIncome=formMap.getField("income_chargeabletds").getValue();
			double DecIncome= Double.parseDouble(strIncome);
			setIncome_Chargeable(DecIncome);
		}
		if ( formMap.getField("total_taxdeductedtds") != null) {
			String StrTax=formMap.getField("total_taxdeductedtds").getValue();
			double taxdeducted= Double.parseDouble(StrTax);
			setTotal_TaxDeducted(taxdeducted);
		}
		
	}
	
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		TdsFromSalaryDetail objTdsfromsalary = (TdsFromSalaryDetail) sourceBean;
		setTan_Employer(objTdsfromsalary.getTan_Employer());
		setName_Employer(objTdsfromsalary.getName_Employer());
		setIncome_Chargeable(objTdsfromsalary.getIncome_Chargeable());
		setTotal_TaxDeducted(objTdsfromsalary.getTotal_TaxDeducted());
		
		
	};
}
