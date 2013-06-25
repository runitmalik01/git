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
import static com.mootly.wcm.utils.Constants.AMOUNTCLUB;
import static com.mootly.wcm.utils.Constants.NAMEPERSON;
import static com.mootly.wcm.utils.Constants.RELATIONSHIP;
import static com.mootly.wcm.utils.Constants.NATUREINCOME;
import static com.mootly.wcm.utils.Constants.PANPERSON;
import javax.jcr.RepositoryException;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
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

@Node(jcrType = "mootlywcm:clubincomedetail")
public class ClubIncomeDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:clubincomedetail";   
	static final public String NODE_NAME = ClubIncomeDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(ClubIncomeDetail.class); 
	
	private String name_Person ;
	private String pan_person;
	private String relationship;
	private String nature_income;
	private Double amountclub;
	private String personalInfoUuid;
	private boolean markedForDeletion;
   
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
    public String getName_Person() {
    	if (name_Person == null) name_Person = getProperty(NAMEPERSON);
    	return name_Person;
    }
 public String getPan_person() {
    	if (pan_person == null) pan_person = getProperty(PANPERSON);
    	return pan_person;
    }

    public String getRelationship() {
    	if (relationship == null) relationship = getProperty(RELATIONSHIP);
    	return relationship;
    }
    public String getNature_income() {
    	if (nature_income == null) nature_income = getProperty(NATUREINCOME);
    	return nature_income;
    }
    public Double getAmountclub() {
    	if (amountclub == null) amountclub = getProperty(AMOUNTCLUB);
    	return amountclub;
    }
   
   
   
    public final void setName_Person(String name_Person) {
		this.name_Person = name_Person;
	}
	public final void setPan_person(String pan_person) {
		this.pan_person = pan_person;
	}
	public final void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	

	public final void setNature_income(String nature_income) {
		this.nature_income = nature_income;
	}
	public final void setAmountclub(Double amountclub) {
		this.amountclub = amountclub;
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
			
			
			node.setProperty(NAMEPERSON, getName_Person());
			node.setProperty(PANPERSON,getPan_person());
			node.setProperty(RELATIONSHIP,getRelationship());
			node.setProperty(NATUREINCOME,getNature_income());
			node.setProperty(AMOUNTCLUB,getAmountclub());
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
		
		if ( formMap.getField("name_person") != null) {
			setName_Person(formMap.getField("name_person").getValue());
		}
		if ( formMap.getField("pan_person") != null) {
			setPan_person(formMap.getField("pan_person").getValue());
		}
		if ( formMap.getField("relationship") != null) {
			setRelationship(formMap.getField("relationship").getValue());
		}
		
		if ( formMap.getField("amountclub") != null) {
			String strAmt=formMap.getField("amountclub").getValue();
			double amt=Double.parseDouble(strAmt);
			setAmountclub(amt);
		}
		if ( formMap.getField("nature_income") != null) {
			setNature_income(formMap.getField("nature_income").getValue());
		}
		
		
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		ClubIncomeDetail objClubIncome = (ClubIncomeDetail) sourceBean;
		setName_Person(objClubIncome.getName_Person());
		setPan_person(objClubIncome.getPan_person());
		setRelationship(objClubIncome.getRelationship());
		setAmountclub(objClubIncome.getAmountclub());
	}
}
