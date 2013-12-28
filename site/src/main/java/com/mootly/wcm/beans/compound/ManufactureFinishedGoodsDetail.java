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

@Node(jcrType = "mootlywcm:manufacturefinishedgoodsdetail")
public class ManufactureFinishedGoodsDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:manufacturefinishedgoodsdetail";   
	static final public String NODE_NAME = ManufactureFinishedGoodsDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ManufactureFinishedGoodsDetail.class); 
	
	

	
	private String itemUnit_Code ;
	private String item_Name ;
	private String itemUnit_Name;
	private String opening_Stock;
	private String purchage ;
	private String finished_Goods;
	private String sales_Qty ;
	private String closing_Stock;
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
    public String getFinished_Goods() {
    	if (finished_Goods == null) finished_Goods = getProperty("mootlywcm:finished_Goods");
    	return finished_Goods;
    }
    public String getPurchage() {
    	if (purchage == null) purchage = getProperty("mootlywcm:purchage");
    	return purchage;
    }
    public String getSales_Qty() {
    	if (sales_Qty == null) sales_Qty = getProperty("mootlywcm:sales_Qty");
    	return sales_Qty;
    }
    public String getClosing_Stock() {
    	if (closing_Stock == null) closing_Stock = getProperty("mootlywcm:closing_Stock");
    	return closing_Stock;
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
	   public final void setFinished_Goods(String finished_Goods) {
			this.finished_Goods = finished_Goods;
		}
		public final void setSales_Qty(String sales_Qty) {
			this.sales_Qty = sales_Qty;
		}
		public final void setClosing_Stock(String closing_Stock) {
			this.closing_Stock = closing_Stock;
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
			node.setProperty("mootlywcm:finished_Goods", getFinished_Goods());
			node.setProperty("mootlywcm:sales_Qty",getSales_Qty());
			node.setProperty("mootlywcm:closing_Stock",getClosing_Stock());
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
		if ( formMap.getField("finished_Goods") != null) {
			setFinished_Goods(formMap.getField("finished_Goods").getValue());
		}
		if ( formMap.getField("itemUnit_Name") != null) {
			setItemUnit_Name(formMap.getField("itemUnit_Name").getValue());
		}
		if ( formMap.getField("sales_Qty") != null) {
			setSales_Qty(formMap.getField("sales_Qty").getValue());
		}
		if ( formMap.getField("closing_Stock") != null) {
			setClosing_Stock(formMap.getField("closing_Stock").getValue());
		}
		if ( formMap.getField("shortage_IfAny") != null) {
			setShortage_IfAny(formMap.getField("shortage_IfAny").getValue());
		}
	}
		
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ManufactureFinishedGoodsDetail objManufactureFinishedGoodsDetail = (ManufactureFinishedGoodsDetail) sourceBean;
		setItemUnit_Code(objManufactureFinishedGoodsDetail.getItemUnit_Code());
		setItem_Name(objManufactureFinishedGoodsDetail.getItem_Name());
		setItemUnit_Name(objManufactureFinishedGoodsDetail.getItemUnit_Name());
		setOpening_Stock(objManufactureFinishedGoodsDetail.getOpening_Stock());
		setPurchage(objManufactureFinishedGoodsDetail.getPurchage());
		setFinished_Goods(objManufactureFinishedGoodsDetail.getFinished_Goods());
		setSales_Qty(objManufactureFinishedGoodsDetail.getSales_Qty());
		setClosing_Stock(objManufactureFinishedGoodsDetail.getClosing_Stock());
		setShortage_IfAny(objManufactureFinishedGoodsDetail.getShortage_IfAny());
		
		
		
	}
}
