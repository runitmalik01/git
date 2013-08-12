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

import static com.mootly.wcm.utils.Constants.TAXID;

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.ARTICLEDTAA;
import static com.mootly.wcm.utils.Constants.TOTALTAXFSI;
import static com.mootly.wcm.utils.Constants.RELIEF9091;
import static com.mootly.wcm.utils.Constants.RELIEF91;
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

@Node(jcrType = "mootlywcm:taxreliefdetail")
public class TaxReliefDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:taxreliefdetail";   
	static final public String NODE_NAME = TaxReliefDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(TaxReliefDetail.class); 
	
	

	
	private String country_Code ;
	
	private String tax_ID ;
	private String article_dtaa;
	private Double totaltax_fsi;
	private Double relief90_91;
	private Double relief91;
	private String country_name;
	private String isDtaaCountry;
	private Double dtaa_CountryTax;
	private Double Nodtaa_CountryTax;
	
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
    public String getTax_ID() {
    	if (tax_ID == null) tax_ID = getProperty(TAXID);
    	return tax_ID;
    }
    public String getArticle_dtaa() {
    	if (article_dtaa == null) article_dtaa = getProperty(ARTICLEDTAA);
    	return article_dtaa;
    }
    public Double getTotaltax_fsi() {
    	if (totaltax_fsi == null) totaltax_fsi = getProperty(TOTALTAXFSI);
    	return totaltax_fsi;
    }

    public Double getRelief90_91() {
    	if (relief90_91 == null) relief90_91 = getProperty(RELIEF9091);
    	return relief90_91;
    }
   
    public Double getRelief91() {
    	if (relief91 == null) relief91 = getProperty(RELIEF91);
    	return relief91;
    }
    public String getCountry_Name(){
    	if(country_name == null) country_name= getProperty(COUNTRYNAME);
    	return country_name;
    }
    public Double getDtaa_CountryTax(){
    	if(dtaa_CountryTax == null) dtaa_CountryTax= getProperty("mootlywcm:dtaa_CountryTax");
    	return dtaa_CountryTax;
    }
    public String getIsDtaaCountry(){
    	if(isDtaaCountry == null) isDtaaCountry= getProperty("mootlywcm:isDtaaCountry");
    	return isDtaaCountry;
    }
    
  
    public Double getNodtaa_CountryTax(){
    	if(Nodtaa_CountryTax == null) Nodtaa_CountryTax= getProperty("mootlywcm:Nodtaa_CountryTax");
    	return Nodtaa_CountryTax;
    }
    
   public final void setCountry_Name(String country_name){
	   this.country_name=country_name;
   }
    public final void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public final void setTax_ID(String tax_ID) {
		this.tax_ID = tax_ID;
	}
	public final void setArticle_dtaa(String article_dtaa) {
		this.article_dtaa = article_dtaa;
	}
	public final void setTotaltax_fsi(Double totaltax_fsi) {
		this.totaltax_fsi = totaltax_fsi;
	}
	public final void setRelief90_91(Double relief90_91) {
		this.relief90_91 = relief90_91;
	}
	public final void setRelief91(Double relief91) {
		this.relief91 = relief91;
	}
	public final void setIsDtaaCountry(String isDtaaCountry) {
		this.isDtaaCountry = isDtaaCountry;
	}
	public final void setNodtaa_CountryTax(Double Nodtaa_CountryTax) {
		this.Nodtaa_CountryTax = Nodtaa_CountryTax;
	}
	public final void setDtaa_CountryTax(Double dtaa_CountryTax) {
		this.dtaa_CountryTax = dtaa_CountryTax;
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
			node.setProperty(TAXID,getTax_ID());
			node.setProperty(ARTICLEDTAA,getArticle_dtaa());
			node.setProperty(TOTALTAXFSI,getTotaltax_fsi());
			node.setProperty(RELIEF9091,getRelief90_91());
			node.setProperty(RELIEF91,getRelief91());
			node.setProperty(COUNTRYNAME,getCountry_Name());
			node.setProperty("mootlywcm:isDtaaCountry",getIsDtaaCountry());
			node.setProperty("mootlywcm:dtaa_CountryTax",getDtaa_CountryTax());
			node.setProperty("mootlywcm:Nodtaa_CountryTax",getNodtaa_CountryTax());
			
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
		if ( formMap.getField("tax_ID") != null) {
			setTax_ID(formMap.getField("tax_ID").getValue());
		}
		if ( formMap.getField("article_dtaa") != null) {
			setArticle_dtaa(formMap.getField("article_dtaa").getValue());
		}
		if ( formMap.getField("totaltax_fsi") != null) {
			 String strTaxFsi=formMap.getField("totaltax_fsi").getValue();
			double TaxFsi=Double.parseDouble(strTaxFsi);
			setTotaltax_fsi(TaxFsi);
		}
		if ( formMap.getField("relief90_91") != null) {
			String strRelief9091=formMap.getField("relief90_91").getValue();
			double Relief9091=Double.parseDouble(strRelief9091);
			setRelief90_91(Relief9091);
		}
		if ( formMap.getField("relief91") != null) {
			String strRelief90=formMap.getField("relief91").getValue();
			double Relief90=Double.parseDouble(strRelief90);
			setRelief91(Relief90);
		}
		if(formMap.getField("country_name") != null){
			setCountry_Name(formMap.getField("country_name").getValue());
		}
		if(formMap.getField("isDtaaCountry") != null){
			setIsDtaaCountry(formMap.getField("isDtaaCountry").getValue());
		}
		if ( formMap.getField("dtaa_CountryTax") != null) {
			String strdtaa_CountryTax=formMap.getField("dtaa_CountryTax").getValue();
			double dtaa_CountryTax=Double.parseDouble(strdtaa_CountryTax);
			setDtaa_CountryTax(dtaa_CountryTax);
		}
		if ( formMap.getField("Nodtaa_CountryTax") != null) {
			String strNodtaa_CountryTax=formMap.getField("Nodtaa_CountryTax").getValue();
			double Nodtaa_CountryTax=Double.parseDouble(strNodtaa_CountryTax);
			setNodtaa_CountryTax(Nodtaa_CountryTax);
		}
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		TaxReliefDetail objTaxRelief = (TaxReliefDetail) sourceBean;
		setCountry_Code(objTaxRelief.getCountry_Code());
		setTax_ID(objTaxRelief.getTax_ID());
		setArticle_dtaa(objTaxRelief.getArticle_dtaa());
		setTotaltax_fsi(objTaxRelief.getTotaltax_fsi());
		setRelief90_91(objTaxRelief.getRelief90_91());
		setRelief91(objTaxRelief.getRelief91());
		setCountry_Name(objTaxRelief.getCountry_Name());
		setIsDtaaCountry(objTaxRelief.getIsDtaaCountry());
		setDtaa_CountryTax(objTaxRelief.getDtaa_CountryTax());
		setNodtaa_CountryTax(objTaxRelief.getNodtaa_CountryTax());
		
	}
}
