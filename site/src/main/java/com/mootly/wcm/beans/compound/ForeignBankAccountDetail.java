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

import static com.mootly.wcm.utils.Constants.ACCOUNT_NO;

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.ADDRESS_BANK;
import static com.mootly.wcm.utils.Constants.NAME_ACCOUNT;
import static com.mootly.wcm.utils.Constants.NAME_BANK;
import static com.mootly.wcm.utils.Constants.PEAK_BALANCE;
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

@Node(jcrType = "mootlywcm:foreignbankaccountdetail")
public class ForeignBankAccountDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:foreignbankaccountdetail";   
	static final public String NODE_NAME = ForeignBankAccountDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ForeignBankAccountDetail.class); 
	
	

	
	private String country_Code ;
	private String name_bank ;
	private String address_bank;
	private String name_account;
	private String account_no;
	private Double peak_balance;
	private String country_name;
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
    public String getName_Bank() {
    	if (name_bank == null) name_bank = getProperty(NAME_BANK);
    	return name_bank;
    }
    public String getAddress_Bank() {
    	if (address_bank == null) address_bank = getProperty(ADDRESS_BANK);
    	return address_bank;
    }
    public String getName_Account() {
    	if (name_account == null) name_account = getProperty(NAME_ACCOUNT);
    	return name_account;
    }

    public String getAccount_No() {
    	if (account_no == null) account_no = getProperty(ACCOUNT_NO);
    	return account_no;
    }
   
    public Double getPeak_Balance() {
    	if (peak_balance == null) peak_balance = getProperty(PEAK_BALANCE);
    	return peak_balance;
    }
   
    public String getCountry_Name(){
    	if(country_name == null) country_name= getProperty(COUNTRYNAME);
    	return country_name;
    }
   
   
    public final void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public final void setName_Bank(String name_bank) {
		this.name_bank = name_bank;
	}
	public final void setAddress_Bank(String address_bank) {
		this.address_bank = address_bank;
	}
	public final void setName_Account(String name_account) {
		this.name_account = name_account;
	}
	public final void setAccount_No(String account_no) {
		this.account_no = account_no;
	}
	public final void setPeak_Balance(Double peak_balance) {
		this.peak_balance = peak_balance;
	}
	public final void setCountry_Name(String country_name){
		this.country_name=country_name;
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
			node.setProperty(NAME_BANK,getName_Bank());
			node.setProperty(ADDRESS_BANK,getName_Bank());
			node.setProperty(NAME_ACCOUNT,getName_Account());
			node.setProperty(ACCOUNT_NO,getAccount_No());
			node.setProperty(PEAK_BALANCE,getPeak_Balance());
			node.setProperty(COUNTRYNAME,getCountry_Name());
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
		if ( formMap.getField("name_bank") != null) {
			setName_Bank(formMap.getField("name_bank").getValue());
		}
		if ( formMap.getField("address_bank") != null) {
			setAddress_Bank(formMap.getField("address_bank").getValue());
		}
		if ( formMap.getField("name_account") != null) {
			setName_Account(formMap.getField("name_account").getValue());
		}
		if ( formMap.getField("account_no") != null) {
			setAccount_No(formMap.getField("account_no").getValue());
		}
		if ( formMap.getField("peak_balance") != null) {
			String strPeakBalance=formMap.getField("peak_balance").getValue();
			double PeakBalance=Double.parseDouble(strPeakBalance);
			setPeak_Balance(PeakBalance);
		}
		if(formMap.getField("country_name") != null){
			setCountry_Name(formMap.getField("country_name").getValue());
		}
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ForeignBankAccountDetail objForeignAsset = (ForeignBankAccountDetail) sourceBean;
		setCountry_Code(objForeignAsset.getCountry_Code());
		setName_Account(objForeignAsset.getName_Account());
		setAddress_Bank(objForeignAsset.getAddress_Bank());
		setAccount_No(objForeignAsset.getAccount_No());
		setName_Bank(objForeignAsset.getName_Bank());
		setPeak_Balance(objForeignAsset.getPeak_Balance());
		setCountry_Name(objForeignAsset.getCountry_Name());
		
		
	}
}
