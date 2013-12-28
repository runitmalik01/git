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

import static com.mootly.wcm.utils.Constants.ACCOUNT_NUMBER;
import static com.mootly.wcm.utils.Constants.ADDRESS_INSTITUTE;
import static com.mootly.wcm.utils.Constants.NAME_ACHOLDER;
import static com.mootly.wcm.utils.Constants.NAME_ISTITUTE;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.PEAK_BALANCE;

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

@Node(jcrType = "mootlywcm:signingauthorityaccountdetail")
public class SigningAuthorityAccountsDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:signingauthorityaccountdetail";   
	static final public String NODE_NAME = SigningAuthorityAccountsDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(SigningAuthorityAccountsDetail.class); 
	
	

	
	private String name_institution ;
	private String address_institution ;
	private String name_accountholder;
	private String account_number;
	private Double peak_balance;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getName_Institution() {
    	if (name_institution == null) name_institution = getProperty(NAME_ISTITUTE);
    	return name_institution;
    }
    public String getAddress_Institution() {
    	if (address_institution == null) address_institution = getProperty(ADDRESS_INSTITUTE);
    	return address_institution;
    }
    public String getName_Accountholder() {
    	if (name_accountholder == null) name_accountholder = getProperty(NAME_ACHOLDER);
    	return name_accountholder;
    }
    public String getAccount_Number() {
    	if (account_number == null) account_number = getProperty(ACCOUNT_NUMBER);
    	return account_number;
    }
    public Double getPeak_Balance() {
    	if (peak_balance == null) peak_balance = getProperty(PEAK_BALANCE);
    	return peak_balance;
    }
   
 
   
   
    public final void setName_Institution(String name_institution) {
		this.name_institution = name_institution;
	}
	public final void setAddress_Institution(String address_institution) {
		this.address_institution = address_institution;
	}
	public final void setName_Accountholder(String name_accountholder) {
		this.name_accountholder = name_accountholder;
	}
	public final void setAccount_Number(String account_number) {
		this.account_number = account_number;
	}
	
	public final void setPeak_Balance(Double peak_balance) {
		this.peak_balance = peak_balance;
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
			node.setProperty(NAME_ISTITUTE, getName_Institution());
			node.setProperty(ADDRESS_INSTITUTE,getAddress_Institution());
			node.setProperty(NAME_ACHOLDER,getName_Accountholder());
			node.setProperty(ACCOUNT_NUMBER,getAccount_Number());
			node.setProperty(PEAK_BALANCE,getPeak_Balance());
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
		
		if ( formMap.getField("name_institution") != null) {
			setName_Institution(formMap.getField("name_institution").getValue());
		}
		if ( formMap.getField("address_institution") != null) {
			setAddress_Institution(formMap.getField("address_institution").getValue());
		}
		if ( formMap.getField("name_accountholder") != null) {
			setName_Accountholder(formMap.getField("name_accountholder").getValue());
		}
		if ( formMap.getField("account_number") != null) {
			setAccount_Number(formMap.getField("account_number").getValue());
		}
		
		if ( formMap.getField("peak_balance") != null) {
			String strPeakBalance=formMap.getField("peak_balance").getValue();
			double PeakBalance=Double.parseDouble(strPeakBalance);
			setPeak_Balance(PeakBalance);
		}
		
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		SigningAuthorityAccountsDetail objAccountDetail = (SigningAuthorityAccountsDetail) sourceBean;
		setName_Institution(objAccountDetail.getName_Institution());
		setAddress_Institution(objAccountDetail.getAddress_Institution());
		setName_Accountholder(objAccountDetail.getName_Accountholder());
		setAccount_Number(objAccountDetail.getAccount_Number());
		setPeak_Balance(objAccountDetail.getPeak_Balance());
		
		
	}
}
