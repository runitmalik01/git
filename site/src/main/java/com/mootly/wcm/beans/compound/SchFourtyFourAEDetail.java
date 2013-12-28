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





@Node(jcrType = "mootlywcm:schfourtyfouraedetail")
public class SchFourtyFourAEDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:schfourtyfouraedetail";   
	static final public String NODE_NAME = SchFourtyFourAEDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(SchFourtyFourAEDetail.class); 
	
	private String type_Vehicle ;
	private String hold_Period ;
	private Double income_PerVehicle;
	private Double deemedIncome_Heavy;
	private Double deemedIncome_Light;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getType_Vehicle() {
    	if (type_Vehicle == null) type_Vehicle = getProperty("mootlywcm:type_Vehicle");
    	return type_Vehicle;
    }

    public String getHold_Period() {
    	if (hold_Period == null) hold_Period = getProperty("mootlywcm:hold_Period");
    	return hold_Period;
    }

    public Double getIncome_PerVehicle() {
    	if (income_PerVehicle == null) income_PerVehicle = getProperty("mootlywcm:income_PerVehicle");
    	return income_PerVehicle;
    }
    public Double getDeemedIncome_Heavy() {
    	if (deemedIncome_Heavy == null) deemedIncome_Heavy = getProperty("mootlywcm:deemedIncome_Heavy");
    	return deemedIncome_Heavy;
    }
    public Double getDeemedIncome_Light() {
    	if (deemedIncome_Light == null) deemedIncome_Light = getProperty("mootlywcm:deemedIncome_Light");
    	return deemedIncome_Light;
    }
   
   
   
    public final void setType_Vehicle(String type_Vehicle) {
		this.type_Vehicle = type_Vehicle;
	}
	public final void setHold_Period(String hold_Period) {
		this.hold_Period = hold_Period;
	}
	public final void setIncome_PerVehicle(Double income_PerVehicle) {
		this.income_PerVehicle = income_PerVehicle;
	}
	public final void setDeemedIncome_Heavy(Double deemedIncome_Heavy) {
		this.deemedIncome_Heavy = deemedIncome_Heavy;
	}
	public final void setDeemedIncome_Light(Double deemedIncome_Light) {
		this.deemedIncome_Light = deemedIncome_Light;
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
			
			
			node.setProperty("mootlywcm:type_Vehicle", getType_Vehicle());
			node.setProperty("mootlywcm:hold_Period",getHold_Period());
			node.setProperty("mootlywcm:income_PerVehicle",getIncome_PerVehicle());
			node.setProperty("mootlywcm:deemedIncome_Heavy",getDeemedIncome_Heavy());
			node.setProperty("mootlywcm:deemedIncome_Light",getDeemedIncome_Light());

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
		
		if ( formMap.getField("type_Vehicle").getValue() != null) {
			setType_Vehicle(formMap.getField("type_Vehicle").getValue());
		}
		if ( formMap.getField("hold_Period").getValue() != null) {
			setHold_Period(formMap.getField("hold_Period").getValue());
		}
		Double val_income_PerVehicle=0.0d;
		if ( formMap.getField("income_PerVehicle").getValue() != null) {
		String str_Income_PerVehicle = formMap.getField("income_PerVehicle").getValue();
		val_income_PerVehicle = Double.parseDouble(str_Income_PerVehicle);
			
		} setIncome_PerVehicle(val_income_PerVehicle);
		Double val_deemedIncome_Heavy=0.0d;
		if ( formMap.getField("deemedIncome_Heavy").getValue() != null) {
		String str_deemedIncome_Heavy = formMap.getField("deemedIncome_Heavy").getValue();
		val_deemedIncome_Heavy = Double.parseDouble(str_deemedIncome_Heavy);
		}  
		setDeemedIncome_Heavy(val_deemedIncome_Heavy);
		Double val_deemedIncome_Light=0.0d;
		if ( formMap.getField("deemedIncome_Light").getValue() != null) {
		String str_deemedIncome_Light = formMap.getField("deemedIncome_Light").getValue();
		val_deemedIncome_Light = Double.parseDouble(str_deemedIncome_Light);
		}
		setDeemedIncome_Light(val_deemedIncome_Light);
		
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		SchFourtyFourAEDetail objSchFourtyFourAEDetail = (SchFourtyFourAEDetail) sourceBean;
		setType_Vehicle(objSchFourtyFourAEDetail.getType_Vehicle());
		setHold_Period(objSchFourtyFourAEDetail.getHold_Period());
		setDeemedIncome_Heavy(objSchFourtyFourAEDetail.getDeemedIncome_Heavy());
		setDeemedIncome_Light(objSchFourtyFourAEDetail.getDeemedIncome_Light());
		
		
		
	}
}
