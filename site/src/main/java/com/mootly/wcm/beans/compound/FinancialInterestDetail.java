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

import java.util.Calendar;

import javax.jcr.RepositoryException;
import static com.mootly.wcm.utils.Constants.CODE_COUNTRY;
import static com.mootly.wcm.utils.Constants.NAME_ENTITY;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.NATURE_ENTITY;
import static com.mootly.wcm.utils.Constants.ADDRESS_ENTITY;
import static com.mootly.wcm.utils.Constants.COUNTRYNAME;

import static com.mootly.wcm.utils.Constants.TOTAL_INVESTMENT;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormMapFiller;



// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:financialinterestdetail")
public class FinancialInterestDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:financialinterestdetail";   
	static final public String NODE_NAME = FinancialInterestDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(FinancialInterestDetail.class); 
	
	

	
	private String country_Code ;
	private String country_name;
	private String nature_entity ;
	private String name_entity;
	private String address_entity;
	private Double total_investment;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getCountry_Code() {
    	if (country_Code == null) country_Code = getProperty(CODE_COUNTRY);
    	return country_Code;
    }
    public String getName_Entity() {
    	if (name_entity == null) name_entity = getProperty(NAME_ENTITY);
    	return name_entity;
    }
    public String getNature_Entity() {
    	if (nature_entity == null) nature_entity = getProperty(NATURE_ENTITY);
    	return nature_entity;
    }
    public String getAddress_Entity() {
    	if (address_entity == null) address_entity = getProperty(ADDRESS_ENTITY);
    	return address_entity;
    }
    public Double getTotal_Investment() {
    	if (total_investment == null) total_investment = getProperty(TOTAL_INVESTMENT);
    	return total_investment;
    }
   public String getCountry_Name(){
	   if(country_name == null) country_name = getProperty(COUNTRYNAME);
	   return country_name;
   }
 
   public final void setCountry_Name(String country_name){
	   this.country_name=country_name;
	   
   }
   
    public final void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public final void setNature_Entity(String nature_entity) {
		this.nature_entity = nature_entity;
	}
	public final void setName_Entity(String name_entity) {
		this.name_entity = name_entity;
	}
	public final void setAddress_Entity(String address_entity) {
		this.address_entity = address_entity;
	}
	
	public final void setTotal_Investment(Double total_investment) {
		this.total_investment = total_investment;
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
			node.setProperty(CODE_COUNTRY, getCountry_Code());
			node.setProperty(NAME_ENTITY,getName_Entity());
			node.setProperty(NATURE_ENTITY,getNature_Entity());
			node.setProperty(ADDRESS_ENTITY,getAddress_Entity());
			node.setProperty(TOTAL_INVESTMENT,getTotal_Investment());
			node.setProperty(COUNTRYNAME, getCountry_Name());
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
		if(formMap.getField("country_name") != null){
			setCountry_Name(formMap.getField("country_name").getValue());
		}
		if ( formMap.getField("nature_entity") != null) {
			setNature_Entity(formMap.getField("nature_entity").getValue());
		}
		if ( formMap.getField("name_entity") != null) {
			setName_Entity(formMap.getField("name_entity").getValue());
		}
		if ( formMap.getField("address_entity") != null) {
			setAddress_Entity(formMap.getField("address_entity").getValue());
		}
		
		if ( formMap.getField("total_investment") != null) {
			String strPeakBalance=formMap.getField("total_investment").getValue();
			double PeakBalance=Double.parseDouble(strPeakBalance);
			setTotal_Investment(PeakBalance);
		}
		
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		FinancialInterestDetail objFinancialInterest = (FinancialInterestDetail) sourceBean;
		setCountry_Code(objFinancialInterest.getCountry_Code());
		setNature_Entity(objFinancialInterest.getNature_Entity());
		setName_Entity(objFinancialInterest.getName_Entity());
		setAddress_Entity(objFinancialInterest.getAddress_Entity());
		setTotal_Investment(objFinancialInterest.getTotal_Investment());
		setCountry_Name(objFinancialInterest.getCountry_Name());
		
		
	}
}
