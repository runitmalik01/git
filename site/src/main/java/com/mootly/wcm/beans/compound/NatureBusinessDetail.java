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

@Node(jcrType = "mootlywcm:naturebusinessdetail")
public class NatureBusinessDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:naturebusinessdetail";   
	static final public String NODE_NAME = NatureBusinessDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(NatureBusinessDetail.class); 
	
	

	
	private String business_name ;
	private String business_code ;
	private String tradeName_Proprietorship;

	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getBusiness_Name() {
    	if (business_name == null) business_name = getProperty("mootlywcm:business_name");
    	return business_name;
    }
    public String getBusiness_Code() {
    	if (business_code == null) business_code = getProperty("mootlywcm:business_code");
    	return business_code;
    }
    public String getTradeName_Proprietorship() {
    	if (tradeName_Proprietorship == null) tradeName_Proprietorship = getProperty("mootlywcm:tradeName_Proprietorship");
    	return tradeName_Proprietorship;
    }
   
   public final void setBusiness_Name(String business_name){
	   this.business_name=business_name;
   }
   
    public final void setbusiness_Code(String business_code) {
		this.business_code = business_code;
	}
	public final void setTradeName_Proprietorship(String tradeName_Proprietorship) {
		this.tradeName_Proprietorship = tradeName_Proprietorship;
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
			node.setProperty("mootlywcm:business_name", getBusiness_Name());
			node.setProperty("mootlywcm:business_code",getBusiness_Code());
			node.setProperty("mootlywcm:tradeName_Proprietorship",getTradeName_Proprietorship());
			
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
		
		if ( formMap.getField("business_name") != null) {
			setBusiness_Name(formMap.getField("business_name").getValue());
		}
		if ( formMap.getField("business_code") != null) {
			setbusiness_Code(formMap.getField("business_code").getValue());
		}
		if ( formMap.getField("tradeName_Proprietorship") != null) {
			setTradeName_Proprietorship(formMap.getField("tradeName_Proprietorship").getValue());
		}
		
	}
		
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		NatureBusinessDetail objNatureBusiness = (NatureBusinessDetail) sourceBean;
		setBusiness_Name(objNatureBusiness.getBusiness_Name());
		setbusiness_Code(objNatureBusiness.getBusiness_Code());
		setTradeName_Proprietorship(objNatureBusiness.getTradeName_Proprietorship());
		
		
		
		
	}
}
