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

@Node(jcrType = "mootlywcm:firmspartnerdetail")
public class FirmsPartnerDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:firmspartnerdetail";   
	static final public String NODE_NAME = FirmsPartnerDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(FirmsPartnerDetail.class); 
	
	

	
	private String name_Firm ;
	private String pan_Firm ;
	private String perShare_InProfit;
	private Double amountShare_InProfit;
	private Double capital_Balance ;
	
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getName_Firm() {
    	if (name_Firm == null) name_Firm = getProperty("mootlywcm:name_Firm");
    	return name_Firm;
    }
    public String getPan_Firm() {
    	if (pan_Firm == null) pan_Firm = getProperty("mootlywcm:Pan_Firm");
    	return pan_Firm;
    }
    public String getPerShare_InProfit() {
    	if (perShare_InProfit == null) perShare_InProfit = getProperty("mootlywcm:perShare_InProfit");
    	return perShare_InProfit;
    }
    public Double getAmountShare_InProfit() {
    	if (amountShare_InProfit == null) amountShare_InProfit = getProperty("mootlywcm:amountShare_InProfit");
    	return amountShare_InProfit;
    }
    public Double getCapital_Balance() {
    	if (capital_Balance == null) capital_Balance = getProperty("mootlywcm:capital_Balance");
    	return capital_Balance;
    }
   
 
   public final void setName_Firm(String name_Firm){
	   this.name_Firm=name_Firm;
   }
   
    public final void setPan_Firm(String pan_Firm) {
		this.pan_Firm = pan_Firm;
	}
	public final void setPerShare_InProfit(String perShare_InProfit) {
		this.perShare_InProfit = perShare_InProfit;
	}
	  public final void setAmountShare_InProfit(Double amountShare_InProfit){
		   this.amountShare_InProfit=amountShare_InProfit;
	   }
	   
	    public final void setCapital_Balance(Double capital_Balance) {
			this.capital_Balance = capital_Balance;
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
			node.setProperty("mootlywcm:name_Firm", getName_Firm());
			node.setProperty("mootlywcm:pan_Firm",getPan_Firm());
			node.setProperty("mootlywcm:perShare_InProfit",getPerShare_InProfit());
			node.setProperty("mootlywcm:amountShare_InProfit",getAmountShare_InProfit());
			node.setProperty("mootlywcm:capital_Balance", getCapital_Balance());
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
		
		if ( formMap.getField("name_Firm") != null) {
			setName_Firm(formMap.getField("name_Firm").getValue());
		}
		if ( formMap.getField("pan_Firm") != null) {
			setPan_Firm(formMap.getField("pan_Firm").getValue());
		}
		if ( formMap.getField("perShare_InProfit") != null) {
			setPerShare_InProfit(formMap.getField("perShare_InProfit").getValue());
		}
		Double amtShare_InProfit=0.0d;
		if ( formMap.getField("amountShare_InProfit") != null) {
			String strAmountShare_InProfit = formMap.getField("amountShare_InProfit").getValue();
			setAmountShare_InProfit(Double.parseDouble(strAmountShare_InProfit));
		} else  setAmountShare_InProfit(amtShare_InProfit);
		
		Double Doubcapital_Balance=0.0d;
		if ( formMap.getField("capital_Balance") != null) {
			String strCapital_Balance = formMap.getField("capital_Balance").getValue();
			setCapital_Balance(Double.parseDouble(strCapital_Balance));
		} else  setCapital_Balance(Doubcapital_Balance);
		
	}
		
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		FirmsPartnerDetail objFirmpartner = (FirmsPartnerDetail) sourceBean;
		setName_Firm(objFirmpartner.getName_Firm());
		setPan_Firm(objFirmpartner.getPan_Firm());
		setPerShare_InProfit(objFirmpartner.getPerShare_InProfit());
		setAmountShare_InProfit(objFirmpartner.getAmountShare_InProfit());
		setCapital_Balance(objFirmpartner.getCapital_Balance());
		
		
		
	}
}
