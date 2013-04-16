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

import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMPLOYER_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;

import java.util.Calendar;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Bean mapping class for the 'mootlywcm:address' document type
 */
@Node(jcrType = "mootlywcm:personalinformation")
public class PersonalInformation extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(PersonalInformation.class);
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String PAN;
	private String flatDoorBuilding;
	private String filingStatus;
	private String roadStreet;
	private String areaLocality;
	private Calendar DOB;
	private String townCityDistrict;
	private String state;
	private String pinCode;
	private String sex;
	private String email;
	private String mobile;
	private String stdCode;
	private String phone;
	private String employerCategory;
	
	
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

    public String getPAN() {
    	if (PAN == null) PAN = getProperty(PROP_PI_PAN);
    	return PAN;
    }

    public String getFlatDoorBuilding() {
    	if (flatDoorBuilding == null) flatDoorBuilding = getProperty(PROP_PI_FLAT_FLOOR_BUILDING);
    	return flatDoorBuilding;
    }

    public String getFilingStatus() {
    	if (filingStatus == null) filingStatus = getProperty(PROP_PI_FILING_STATUS);
    	return filingStatus;
    }

    public String getRoadStreet() {
    	if (roadStreet == null) roadStreet = getProperty(PROP_PI_ROAD_STREET);
    	return roadStreet;
    }

    public String getAreaLocality() {
    	if (areaLocality == null) areaLocality = getProperty(PROP_PI_AREA_LOCALITY);
    	return areaLocality;
    }

    public Calendar getDOB() {
    	if (DOB == null) areaLocality = getProperty(PROP_PI_AREA_LOCALITY);
    	return getProperty(PROP_PI_DOB);
    }

    public String getTownCityDistrict() {
    	if (townCityDistrict == null) townCityDistrict = getProperty(PROP_PI_TOWN_CITY_DISTRICT);
    	return townCityDistrict;
    }

    public String getState() {
    	if (state == null) state = getProperty(PROP_PI_STATE);
    	return state;
    }

    public String getPinCode() {
    	if (pinCode == null) pinCode = getProperty(PROP_PI_PINCODE);
    	return pinCode;
    }
    
    public String getSex() {
    	if (sex == null) sex = getProperty(PROP_PI_SEX);
    	return getProperty(PROP_PI_SEX);
    }
    
    public String getEmail() {
    	if (email == null) email =  getProperty(PROP_PI_EMAIL);
    	return email;
    }
    
    public String getMobile() {
    	if (mobile == null) mobile =  getProperty(PROP_PI_MOBILE);
    	return mobile;
    }
    
    public String getStdCode() {
    	if (stdCode == null) stdCode = getProperty(PROP_PI_STD_CODE);
    	return stdCode;
    }
    
    public String getPhone() {
    	if (phone == null) phone = getProperty(PROP_PI_PHONE);
    	return phone;
    }
    
    public String getEmployerCategory() {
    	if (employerCategory == null) employerCategory =  getProperty(PROP_PI_EMPLOYER_CATEGORY);
    	return employerCategory;
    }
    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {
	    	node.setProperty(PROP_PI_FIRST_NAME,getFirstName());
	    	node.setProperty(PROP_PI_MIDDLE_NAME,getMiddleName());
	    	node.setProperty(PROP_PI_LAST_NAME, getLastName());
	    	
	    	node.setProperty(PROP_PI_PAN, getPAN());
	    	node.setProperty(PROP_PI_FLAT_FLOOR_BUILDING, getFlatDoorBuilding());
	    	node.setProperty(PROP_PI_FILING_STATUS, getFilingStatus());
	    	node.setProperty(PROP_PI_ROAD_STREET, getRoadStreet());
	    	
	    	node.setProperty(PROP_PI_AREA_LOCALITY, getAreaLocality());
	    	node.setProperty(PROP_PI_DOB, getDOB());
	    	node.setProperty(PROP_PI_TOWN_CITY_DISTRICT, getTownCityDistrict());
	    	
	    	node.setProperty(PROP_PI_STATE, getState());
	    	node.setProperty(PROP_PI_PINCODE, getPinCode());
	    	
	    	node.setProperty(PROP_PI_SEX, getSex());
	    	node.setProperty(PROP_PI_EMAIL, getEmail());
	    	node.setProperty(PROP_PI_MOBILE, getMobile());
	    	
	    	node.setProperty(PROP_PI_STD_CODE, getStdCode());
	    	node.setProperty(PROP_PI_PHONE, getPhone());
	    	node.setProperty(PROP_PI_EMPLOYER_CATEGORY, getEmployerCategory());
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
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

	public final void setPAN(String pAN) {
		PAN = pAN;
	}

	public final void setFlatDoorBuilding(String flatDoorBuilding) {
		this.flatDoorBuilding = flatDoorBuilding;
	}

	public final void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}

	public final void setRoadStreet(String roadStreet) {
		this.roadStreet = roadStreet;
	}

	public final void setAreaLocality(String areaLocality) {
		this.areaLocality = areaLocality;
	}

	public final void setDOB(Calendar dOB) {
		DOB = dOB;
	}

	public final void setTownCityDistrict(String townCityDistrict) {
		this.townCityDistrict = townCityDistrict;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public final void setSex(String sex) {
		this.sex = sex;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public final void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final void setEmployerCategory(String employerCategory) {
		this.employerCategory = employerCategory;
	}
    	
}    	