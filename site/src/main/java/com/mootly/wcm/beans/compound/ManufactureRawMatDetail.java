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

@Node(jcrType = "mootlywcm:manufacturerawmatdetail")
public class ManufactureRawMatDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:manufacturerawmatdetail";   
	static final public String NODE_NAME = ManufactureRawMatDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ManufactureRawMatDetail.class); 
	
	

	
	private String itemUnit_Code ;
	private String item_Name ;
	private String itemUnit_Name;
	private String opening_Stock;
	private String purchage ;
	private String consumption;
	private String sales ;
	private String closing_Stock;
	private String yield_finishedProd;
	private String percentage_Yield;
	private String shortage_IfAny;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getItemUnit_Code() {
    	if (itemUnit_Code == null) itemUnit_Code = getProperty("mootlywcm:itemUnit_Code");
    	return itemUnit_Code;
    }
    public String getItem_Name() {
    	if (item_Name == null) item_Name = getProperty("mootlywcm:item_Name");
    	return item_Name;
    }
    public String getItemUnit_Name() {
    	if (itemUnit_Name == null) itemUnit_Name = getProperty("mootlywcm:itemUnit_Name");
    	return itemUnit_Name;
    }
    public String getOpening_Stock() {
    	if (opening_Stock == null) opening_Stock = getProperty("mootlywcm:opening_Stock");
    	return opening_Stock;
    }
    public String getPurchage() {
    	if (purchage == null) purchage = getProperty("mootlywcm:purchage");
    	return purchage;
    }
    public String getConsumption() {
    	if (consumption == null) consumption = getProperty("mootlywcm:consumption");
    	return consumption;
    }
    public String getSales() {
    	if (sales == null) sales = getProperty("mootlywcm:sales");
    	return sales;
    }
    public String getClosing_Stock() {
    	if (closing_Stock == null) closing_Stock = getProperty("mootlywcm:closing_Stock");
    	return closing_Stock;
    }
    public String getYield_finishedProd() {
    	if (yield_finishedProd == null) yield_finishedProd = getProperty("mootlywcm:yield_finishedProd");
    	return yield_finishedProd;
    }
    public String getPercentage_Yield() {
    	if (percentage_Yield == null) percentage_Yield = getProperty("mootlywcm:percentage_Yield");
    	return percentage_Yield;
    }
    public String getShortage_IfAny() {
    	if (shortage_IfAny == null) shortage_IfAny = getProperty("mootlywcm:shortage_IfAny");
    	return shortage_IfAny;
    }
    
   
 
   public final void setItemUnit_Code(String itemUnit_Code){
	   this.itemUnit_Code=itemUnit_Code;
   }
   
    public final void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public final void setItemUnit_Name(String itemUnit_Name) {
		this.itemUnit_Name = itemUnit_Name;
	}
	  public final void setOpening_Stock(String opening_Stock){
		   this.opening_Stock=opening_Stock;
	   }
	   
	    public final void setPurchage(String purchage) {
			this.purchage = purchage;
		}
	    public final void setconsumption(String consumption) {
			this.consumption = consumption;
		}
		public final void setSales(String sales) {
			this.sales = sales;
		}
		public final void setClosing_Stock(String closing_Stock) {
			this.closing_Stock = closing_Stock;
		}
		public final void setYield_finishedProd(String yield_finishedProd) {
			this.yield_finishedProd = yield_finishedProd;
		}
		public final void setPercentage_Yield(String percentage_Yield) {
			this.percentage_Yield = percentage_Yield;
		}
	public final void setShortage_IfAny(String shortage_IfAny){
		this.shortage_IfAny = shortage_IfAny;
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
			node.setProperty("mootlywcm:itemUnit_Code", getItemUnit_Code());
			node.setProperty("mootlywcm:item_Name",getItem_Name());
			node.setProperty("mootlywcm:itemUnit_Name",getItemUnit_Name());
			node.setProperty("mootlywcm:opening_Stock",getOpening_Stock());
			node.setProperty("mootlywcm:purchage", getPurchage());
			node.setProperty("mootlywcm:consumption", getConsumption());
			node.setProperty("mootlywcm:sales",getSales());
			node.setProperty("mootlywcm:closing_Stock",getClosing_Stock());
			node.setProperty("mootlywcm:yield_finishedProd",getYield_finishedProd());
			node.setProperty("mootlywcm:percentage_Yield", getPercentage_Yield());
			node.setProperty("mootlywcm:shortage_IfAny",getShortage_IfAny());
			
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
		
		if ( formMap.getField("itemUnit_Code") != null) {
			setItemUnit_Code(formMap.getField("itemUnit_Code").getValue());
		}
		if ( formMap.getField("item_Name") != null) {
			setItem_Name(formMap.getField("item_Name").getValue());
		}
		if ( formMap.getField("opening_Stock") != null) {
			setOpening_Stock(formMap.getField("opening_Stock").getValue());
		}
		if ( formMap.getField("purchage") != null) {                       
			setPurchage(formMap.getField("purchage").getValue());
		}
		if ( formMap.getField("consumption") != null) {                       
			setconsumption(formMap.getField("consumption").getValue());
		}
		if ( formMap.getField("itemUnit_Name") != null) {
			setItemUnit_Name(formMap.getField("itemUnit_Name").getValue());
		}
		if ( formMap.getField("sales") != null) {
			setSales(formMap.getField("sales").getValue());
		}
		if ( formMap.getField("closing_Stock") != null) {
			setClosing_Stock(formMap.getField("closing_Stock").getValue());
		}
		if ( formMap.getField("yield_finishedProd") != null) {
			setYield_finishedProd(formMap.getField("yield_finishedProd").getValue());
		}
		if ( formMap.getField("percentage_Yield") != null) {
			setPercentage_Yield(formMap.getField("percentage_Yield").getValue());
		}
		if ( formMap.getField("shortage_IfAny") != null) {
			setShortage_IfAny(formMap.getField("shortage_IfAny").getValue());
		}
	}
		
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ManufactureRawMatDetail objManufactureRawMat = (ManufactureRawMatDetail) sourceBean;
		setItemUnit_Code(objManufactureRawMat.getItemUnit_Code());
		setItem_Name(objManufactureRawMat.getItem_Name());
		setItemUnit_Name(objManufactureRawMat.getItemUnit_Name());
		setOpening_Stock(objManufactureRawMat.getOpening_Stock());
		setPurchage(objManufactureRawMat.getPurchage());
		setconsumption(objManufactureRawMat.getConsumption());
		setSales(objManufactureRawMat.getSales());
		setClosing_Stock(objManufactureRawMat.getClosing_Stock());
		setYield_finishedProd(objManufactureRawMat.getYield_finishedProd());
		setPercentage_Yield(objManufactureRawMat.getPercentage_Yield());
		setShortage_IfAny(objManufactureRawMat.getShortage_IfAny());
		
		
		
	}
}
