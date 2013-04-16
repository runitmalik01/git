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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMPLOYER_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FATHER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_RESIDENT_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberPersonalInformation")
public class MemberPersonalInformation extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberPersonalInformation";
	static final public String NODE_NAME = "PersonalInformation";
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private String PAN;	
	private String filingStatus;
	private Calendar DOB;
	private String sex;
	private String resident;
	
	//This is just a calculated field
	public String getName() {
		StringBuffer sb = new StringBuffer();
		if (getFirstName() != null) sb.append(firstName).append(" ");
		if (getLastName() != null) sb.append(lastName);
		return sb.toString();
	}
	//for personal information
	public String getFirstName() {
        if (firstName == null) firstName = getProperty(PROP_PI_FIRST_NAME);
        return firstName;
    }

    public String getMiddleName() {
    	if (middleName == null) middleName = getProperty(PROP_PI_MIDDLE_NAME);
    	return middleName;
    }

    public String getLastName() {
    	if (lastName == null) lastName = getProperty(PROP_PI_LAST_NAME);
    	return lastName;
    }

    public String getFatherName() {
    	if (fatherName == null) fatherName = getProperty(PROP_PI_FATHER_NAME);
    	return fatherName;
    }

    public String getPAN() {
    	if (PAN == null) PAN = getProperty(PROP_PI_PAN);
    	return PAN;
    }

    public String getFilingStatus() {
    	if (filingStatus == null) filingStatus = getProperty(PROP_PI_FILING_STATUS);
    	return filingStatus;
    }

    public Calendar getDOB() {
    	if (DOB == null) DOB = getProperty(PROP_PI_DOB);
    	return DOB;
    }
    
    public String getDOBStr() {
    	if (DOB == null) DOB = getProperty(PROP_PI_DOB);
    	if (DOB != null) {
    		String dobStr = getIndianDateFormatter().format(DOB.getTime());
    		return dobStr;
    	}
    	return null;
    }
    
    
    public String getSex() {
    	if (sex == null) sex = getProperty(PROP_PI_SEX);
    	return sex;
    }
    public String getResident() {
    	if (resident == null) resident = getProperty(PROP_PI_RESIDENT_CATEGORY);
    	return resident;
    }
    public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public final void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public final void setPAN(String pAN) {
		this.PAN = pAN;
	}
	public final void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}
	public final void setDOB(Calendar dOB) {
		this.DOB = dOB;
	}

	public final void setSex(String sex) {
		this.sex = sex;
	}
	public final void setResident(String resident) {
		this.resident = resident;
	}
	
//for personal information
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is bean");
			MemberPersonalInformation memberpersonal = (MemberPersonalInformation) content;
			node.setProperty(PROP_PI_FIRST_NAME,memberpersonal.getFirstName());
	    	node.setProperty(PROP_PI_MIDDLE_NAME,memberpersonal.getMiddleName());
	    	node.setProperty(PROP_PI_LAST_NAME, memberpersonal.getLastName());
	    	node.setProperty(PROP_PI_FATHER_NAME, memberpersonal.getFatherName());
	    	node.setProperty(PROP_PI_PAN, memberpersonal.getPAN());
	    	node.setProperty(PROP_PI_FILING_STATUS, memberpersonal.getFilingStatus());
	    	node.setProperty(PROP_PI_DOB, memberpersonal.getDOB());	    	
	    	node.setProperty(PROP_PI_SEX, memberpersonal.getSex());
	    	node.setProperty(PROP_PI_RESIDENT_CATEGORY, memberpersonal.getResident());
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
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
		if ( formMap.getField("pi_pan") != null) {
			setFirstName(formMap.getField("pi_pan").getValue());
		}
		if ( formMap.getField("pi_first_name") != null) {
			setFirstName(formMap.getField("pi_first_name").getValue());
		}
		if ( formMap.getField("pi_last_name") != null) {
			setLastName(formMap.getField("pi_last_name").getValue());
		}
		if ( formMap.getField("pi_middle_name") != null) {
			setMiddleName(formMap.getField("pi_middle_name").getValue());
		}
		if ( formMap.getField("pi_father_name") != null) {
			setFatherName(formMap.getField("pi_father_name").getValue());
		}
		if ( formMap.getField("gender") != null) {
			setSex(formMap.getField("gender").getValue());
		}
		if ( formMap.getField("pi_dob") != null) {
			String strDate = formMap.getField("pi_dob").getValue();
			Date date = null ;
			DateFormat formatter ; 
			formatter = getIndianDateFormatter();
			Calendar cal=Calendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate); 
				log.info("date"+date);
				cal.setTime(date);
				setDOB(cal);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		}		
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
