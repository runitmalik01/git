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
import static com.mootly.wcm.utils.Constants.NAME_TRUST;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.ADDRESS_TRUST;
import static com.mootly.wcm.utils.Constants.NAME_OTHERTRUST;
import static com.mootly.wcm.utils.Constants.ADDRESS_OTHERTRUST;
import static com.mootly.wcm.utils.Constants.NAME_BENEFICIARIES;
import static com.mootly.wcm.utils.Constants.ADDRESS_BENEFICIARIES;
import static com.mootly.wcm.utils.Constants.NAME_SETTLOR;
import static com.mootly.wcm.utils.Constants.ADDRESS_SETTLOR;
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

@Node(jcrType = "mootlywcm:detailoftrustdetail")
public class DetailOfTrustDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:detailoftrustdetail";   
	static final public String NODE_NAME = DetailOfTrustDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(DetailOfTrustDetail.class); 
	
	

	private String country_Code ;
	private String name_trust ;
	private String country_name;
	private String address_trust;
	private String name_othertrust;
	private String address_othertrust;
	private String name_settlor;
	private String address_settlor;
	private String name_beneficiaries;
	private String address_beneficiaries;
	
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
    public String getName_Trust() {
    	if (name_trust == null) name_trust = getProperty(NAME_TRUST);
    	return name_trust;
    }
    
    public String getAddress_Trust() {
    	if (address_trust == null) address_trust = getProperty(ADDRESS_TRUST);
    	return address_trust;
    }

    public String getName_Othertrust() {
    	if (name_othertrust == null) name_othertrust = getProperty(NAME_OTHERTRUST);
    	return name_othertrust;
    }
   
    public String getAddress_Othertrust() {
    	if (address_othertrust == null) address_othertrust = getProperty(ADDRESS_OTHERTRUST);
    	return address_othertrust;
    }
    public String getName_Settlor() {
    	if (name_settlor == null) name_settlor = getProperty(NAME_SETTLOR);
    	return name_settlor;
    }
    public String getAddress_Settlor() {
    	if (address_settlor == null) address_settlor = getProperty(ADDRESS_SETTLOR);
    	return address_settlor;
    }
    public String getName_Beneficiaries() {
    	if (name_beneficiaries == null) name_beneficiaries = getProperty(NAME_BENEFICIARIES);
    	return name_beneficiaries;
    }
    public String getAddress_Beneficiaries() {
    	if (address_beneficiaries == null) address_beneficiaries = getProperty(ADDRESS_BENEFICIARIES);
    	return address_beneficiaries;
    }
    public String getCountry_Name(){
    	if(country_name == null ) country_name = getProperty(COUNTRYNAME);
    	return country_name;
    }
    public final void setCountry_Name(String country_name){
    	this.country_name=country_name;
    }
    public final void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public final void setName_Trust(String name_trust) {
		this.name_trust = name_trust;
	}
	public final void setAddress_Trust(String address_trust) {
		this.address_trust = address_trust;
	}
	public final void setName_Othertrust(String name_othertrust) {
		this.name_othertrust = name_othertrust;
	}
	public final void setAddress_Othertrust(String address_othertrust) {
		this.address_othertrust = address_othertrust;
	}
	public final void setName_Settlor(String name_settlor) {
		this.name_settlor = name_settlor;
	}
	public final void setAddress_Settlor(String address_settlor) {
		this.address_settlor = address_settlor;
	}
	public final void setName_Beneficiaries(String name_beneficiaries) {
		this.name_beneficiaries = name_beneficiaries;
	}
	public final void setAddress_Beneficiaries(String address_beneficiaries) {
		this.address_beneficiaries = address_beneficiaries;
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
			node.setProperty(NAME_TRUST,getName_Trust());
			node.setProperty(ADDRESS_TRUST,getAddress_Trust());
			node.setProperty(NAME_OTHERTRUST,getName_Othertrust());
			node.setProperty(ADDRESS_OTHERTRUST,getAddress_Othertrust());
			node.setProperty(NAME_SETTLOR,getName_Settlor());
			node.setProperty(ADDRESS_SETTLOR,getAddress_Settlor());
			node.setProperty(NAME_BENEFICIARIES,getName_Beneficiaries());
			node.setProperty(ADDRESS_BENEFICIARIES,getAddress_Beneficiaries());
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
		if ( formMap.getField("name_trust") != null) {
			setName_Trust(formMap.getField("name_trust").getValue());
		}
		if ( formMap.getField("address_trust") != null) {
			setAddress_Trust(formMap.getField("address_trust").getValue());
		}
		if ( formMap.getField("name_othertrust") != null) {
			setName_Othertrust(formMap.getField("name_othertrust").getValue());
		}
		if ( formMap.getField("address_othertrust") != null) {
			setAddress_Othertrust(formMap.getField("address_othertrust").getValue());
		}
		if ( formMap.getField("name_settlor") != null) {
			setName_Settlor(formMap.getField("name_settlor").getValue());
		}
		if ( formMap.getField("address_settlor") != null) {
			setAddress_Settlor(formMap.getField("address_settlor").getValue());
		}
		if ( formMap.getField("name_beneficiaries") != null) {
			setName_Beneficiaries(formMap.getField("name_beneficiaries").getValue());
		}
		if ( formMap.getField("address_beneficiaries") != null) {
			setAddress_Beneficiaries(formMap.getField("address_beneficiaries").getValue());
		}
		if(formMap.getField("country_name") != null){
			setCountry_Name(formMap.getField("country_name").getValue());
		}
		
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		DetailOfTrustDetail objDetailTrust = (DetailOfTrustDetail) sourceBean;
		setCountry_Code(objDetailTrust.getCountry_Code());
		setName_Settlor(objDetailTrust.getName_Settlor());
		setAddress_Trust(objDetailTrust.getAddress_Trust());
		setAddress_Settlor(objDetailTrust.getAddress_Settlor());
		setName_Trust(objDetailTrust.getName_Settlor());
		setName_Beneficiaries(objDetailTrust.getName_Beneficiaries());
		setAddress_Beneficiaries(objDetailTrust.getAddress_Beneficiaries());
		setName_Othertrust(objDetailTrust.getName_Othertrust());
		setCountry_Name(objDetailTrust.getCountry_Name());
		
		
	}
}
