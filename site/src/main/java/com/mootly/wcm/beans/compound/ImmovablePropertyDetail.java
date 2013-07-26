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
import static com.mootly.wcm.utils.Constants.CODECOUNTRY;
import static com.mootly.wcm.utils.Constants.ADDRESS_PROPERTY;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.TOTAL_INVESTMENT;
import static com.mootly.wcm.utils.Constants.COUNTRYNAME;


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

@Node(jcrType = "mootlywcm:immovablepropertydetail")
public class ImmovablePropertyDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:immovablepropertydetail";   
	static final public String NODE_NAME = ImmovablePropertyDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ImmovablePropertyDetail.class); 
	
	

	
	private String country_Code ;
	private String address_property ;
	private String country_name;
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
    	if (country_Code == null) country_Code = getProperty(CODECOUNTRY);
    	return country_Code;
    }
    public String getAddress_Property() {
    	if (address_property == null) address_property = getProperty(ADDRESS_PROPERTY);
    	return address_property;
    }
    public Double getTotal_Investment() {
    	if (total_investment == null) total_investment = getProperty(TOTAL_INVESTMENT);
    	return total_investment;
    }
    
    public String getCountry_Name() {
    	if (country_name == null) country_name = getProperty(COUNTRYNAME);
    	return country_name;
    }
   
 
   public final void setCountry_Name(String country_name){
	   this.country_name=country_name;
   }
   
    public final void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public final void setAddress_Property(String address_property) {
		this.address_property = address_property;
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
			node.setProperty(CODECOUNTRY, getCountry_Code());
			node.setProperty(ADDRESS_PROPERTY,getAddress_Property());
			node.setProperty(COUNTRYNAME,getCountry_Name());
			node.setProperty(TOTAL_INVESTMENT,getTotal_Investment());
			
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
		if ( formMap.getField("address_property") != null) {
			setAddress_Property(formMap.getField("address_property").getValue());
		}
		if ( formMap.getField("country_name") != null) {
			setCountry_Name(formMap.getField("country_name").getValue());
		}
		if ( formMap.getField("total_investment") != null) {
			 String strInvestment=formMap.getField("total_investment").getValue();
			double Investment=Double.parseDouble(strInvestment);
			setTotal_Investment(Investment);
		}
	}
		
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ImmovablePropertyDetail objImmProp = (ImmovablePropertyDetail) sourceBean;
		setCountry_Code(objImmProp.getCountry_Code());
		setAddress_Property(objImmProp.getAddress_Property());
		setTotal_Investment(objImmProp.getTotal_Investment());
		setCountry_Name(objImmProp.getCountry_Name());
		
		
		
	}
}
