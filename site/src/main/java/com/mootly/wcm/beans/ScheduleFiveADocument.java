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

package com.mootly.wcm.beans;

import static com.mootly.wcm.utils.Constants.CAPITAL_GAINS;
import static com.mootly.wcm.utils.Constants.HOUSE_PROPERTY;
import static com.mootly.wcm.utils.Constants.INCOMETOTAL;
import static com.mootly.wcm.utils.Constants.NAME_SPOUSE;
import static com.mootly.wcm.utils.Constants.OTHER_SOURCES;
import static com.mootly.wcm.utils.Constants.PAN_SPOUSE;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:schedulefiveadocument")
public class ScheduleFiveADocument extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:schedulefiveadocument";
	static final public String NODE_NAME = "schedulefiveadocument";
	
	

	
	private String name_spouse ;
	private String pan_spouse;
	private Double house_property;
	private Double capital_gains ;
	private Double other_sources;
	private Double total;
	
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getName_Spouse() {
    	if (name_spouse == null) name_spouse = getProperty(NAME_SPOUSE);
    	return name_spouse;
    }

    public String getPan_Spouse() {
    	if (pan_spouse == null) pan_spouse = getProperty(PAN_SPOUSE);
    	return pan_spouse;
    }

    public Double getHouse_Property() {
    	if (house_property == null) house_property = getProperty(HOUSE_PROPERTY);
    	return house_property;
    }
 
    public Double getCapital_Gains() {
    	if (capital_gains == null) capital_gains = getProperty(CAPITAL_GAINS);
    	return capital_gains;
    }
    public Double getOther_Sources() {
    	if (other_sources == null) other_sources = getProperty(OTHER_SOURCES);
    	return other_sources;
    }
    public Double getTotal() {
    	if (total == null) total = getProperty(INCOMETOTAL);
    	return total;
    }
 
	public final void setName_Spouse(String name_spouse) {
		this.name_spouse = name_spouse;
	}
	public final void setPan_Spouse(String pan_spouse) {
		this.pan_spouse = pan_spouse;
	}
	
	public final void setHouse_Property(Double house_property) {
		this.house_property = house_property;
	}
	public final void setCapital_Gains(Double capital_gains) {
		this.capital_gains = capital_gains;
	}
	public final void setOther_Sources(Double other_sources) {
		this.other_sources = other_sources;
	}
	public final void setTotal(Double total) {
		this.total = total;
	}
		public final String getPersonalInfoUuid() {
			return personalInfoUuid;
		}
		public final void setPersonalInfoUuid(String personalInfoUuid) {
			this.personalInfoUuid = personalInfoUuid;
		}
		
		@Override
		public boolean bind(Object content, javax.jcr.Node node)
				throws ContentNodeBindingException {
			// TODO Auto-generated method stub
			try {
			
				ScheduleFiveADocument scheduleFiveADocument = (ScheduleFiveADocument) content;
			node.setProperty(NAME_SPOUSE,scheduleFiveADocument.getName_Spouse() );
			node.setProperty(PAN_SPOUSE,scheduleFiveADocument.getPan_Spouse());
			node.setProperty(HOUSE_PROPERTY,scheduleFiveADocument.getHouse_Property());
			node.setProperty(CAPITAL_GAINS,scheduleFiveADocument.getCapital_Gains());
			node.setProperty(OTHER_SOURCES,scheduleFiveADocument.getOther_Sources());
			node.setProperty(INCOMETOTAL, scheduleFiveADocument.getTotal());
			
	    	

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
		
		if ( formMap.getField("name_spouse") != null) {
			setName_Spouse(formMap.getField("name_spouse").getValue());
		}
		if ( formMap.getField("pan_spouse") != null) {
			setPan_Spouse(formMap.getField("pan_spouse").getValue());
		}
		if ( formMap.getField("capital_gains") != null) {
			String strcg=formMap.getField("capital_gains").getValue();
			double capitalGain = Double.parseDouble(strcg);
			setCapital_Gains(capitalGain);
		}
		if ( formMap.getField("house_property") != null) {
			 String strHp=formMap.getField("house_property").getValue();
			double houseProperty=Double.parseDouble(strHp);
			setHouse_Property(houseProperty);
		}
		if ( formMap.getField("other_sources") != null) {
			String strOs=formMap.getField("other_sources").getValue();
			double otherSources=Double.parseDouble(strOs);
			setOther_Sources(otherSources);
		}
		if ( formMap.getField("total") != null) {
			String strTotal=formMap.getField("total").getValue();
			double Total=Double.parseDouble(strTotal);
			setTotal(Total);
		}
		
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
		
	}
	
}
