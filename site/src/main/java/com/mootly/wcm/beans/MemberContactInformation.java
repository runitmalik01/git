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
import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PERSONALINFO_LINK;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PREMISES_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberContactInformation")
public class MemberContactInformation extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberContactInformation";
	static final public String NODE_NAME = "ContactInformation";
	
	private String flatDoorBuilding;
	private String premisesBuilding;
	private String roadStreet;
	private String areaLocality;
	private String townCityDistrict;
	private String state;
	private String pinCode;
	private String email;
	private String mobile;
	private String stdCode;
	private String phone;
	private String PAN;
    private String PIUUID;
	

    public String getPAN() {
    	if (PAN == null) PAN = getProperty(PROP_PI_PAN);
    	return PAN;
    }
    public String getFlatDoorBuilding() {
    	if (flatDoorBuilding == null) flatDoorBuilding = getProperty(PROP_PI_FLAT_FLOOR_BUILDING);
    	return flatDoorBuilding;
    }
    public String getPremisesBuilding() {
    	if (premisesBuilding == null) premisesBuilding = getProperty(PROP_PI_PREMISES_BUILDING);
    	return premisesBuilding;
    }

    public String getRoadStreet() {
    	if (roadStreet == null) roadStreet = getProperty(PROP_PI_ROAD_STREET);
    	return roadStreet;
    }

    public String getAreaLocality() {
    	if (areaLocality == null) areaLocality = getProperty(PROP_PI_AREA_LOCALITY);
    	return areaLocality;
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
    public String getPersonalInfoUuid() {
    	return PIUUID;
    }

    public final void setPAN(String pAN) {
    	this.PAN = pAN;
    }
    public final void setFlatDoorBuilding(String flatDoorBuilding) {
    	this.flatDoorBuilding = flatDoorBuilding;
    }
    public final void setPremisesBuilding(String premisesBuilding) {
    	this.premisesBuilding = premisesBuilding;
    }
    public final void setRoadStreet(String roadStreet) {
    	this.roadStreet = roadStreet;
    }

    public final void setAreaLocality(String areaLocality) {
    	this.areaLocality = areaLocality;
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
    public void setPersonalInforUuid(String piuuid) {
    	this.PIUUID = piuuid;
    }
    public MemberPersonalInformation getMemberPersoanlInformation() {
    	HippoBean bean = getBean(PROP_PI_PERSONALINFO_LINK);
    	if (!(bean instanceof HippoMirror)) {
    		return null;
    	}
    	MemberPersonalInformation prdBean = (MemberPersonalInformation) ((HippoMirror) bean).getReferencedBean();
    	if (prdBean == null) {
    		return null;
    	}
    	return prdBean;
    }
//for personal information
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is Contact bean");
			MemberContactInformation contact_info = (MemberContactInformation) content;
			node.setProperty(PROP_PI_PAN, contact_info.getPAN());
	    	node.setProperty(PROP_PI_FLAT_FLOOR_BUILDING, contact_info.getFlatDoorBuilding());
	    	node.setProperty(PROP_PI_PREMISES_BUILDING, contact_info.getPremisesBuilding());
	    	node.setProperty(PROP_PI_ROAD_STREET, contact_info.getRoadStreet());
	    	node.setProperty(PROP_PI_AREA_LOCALITY, contact_info.getAreaLocality());
	    	node.setProperty(PROP_PI_TOWN_CITY_DISTRICT, contact_info.getTownCityDistrict());
	    	node.setProperty(PROP_PI_STATE, contact_info.getState());
	    	node.setProperty(PROP_PI_PINCODE, contact_info.getPinCode());
	    	node.setProperty(PROP_PI_EMAIL, contact_info.getEmail());
	    	node.setProperty(PROP_PI_MOBILE, contact_info.getMobile());
	    	node.setProperty(PROP_PI_STD_CODE, contact_info.getStdCode());
	    	node.setProperty(PROP_PI_PHONE, contact_info.getPhone());	
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", contact_info.getPersonalInfoUuid());
	       */
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		if (formMap.getField("pi_email") != null) setEmail(formMap.getField("pi_email").getValue());
		if (formMap.getField("pi_road_street") != null) setRoadStreet(formMap.getField("pi_road_street").getValue());
		if (formMap.getField("pi_std_code") != null) setStdCode(formMap.getField("pi_std_code").getValue());
		if (formMap.getField("pi_phone") != null) setPhone(formMap.getField("pi_phone").getValue());
		if (formMap.getField("pi_flat_door_building") != null) setFlatDoorBuilding(formMap.getField("pi_flat_door_building").getValue());
		if (formMap.getField("pi_premises_building") != null) setPremisesBuilding(formMap.getField("pi_premises_building").getValue());
		if (formMap.getField("pi_area_locality") != null) setAreaLocality(formMap.getField("pi_area_locality").getValue());
		if (formMap.getField("pi_town_city_district") != null) setTownCityDistrict(formMap.getField("pi_town_city_district").getValue());
		if (formMap.getField("pi_pin_code") != null) setPinCode(formMap.getField("pi_pin_code").getValue());
		if (formMap.getField("pi_state") != null) setState(formMap.getField("pi_state").getValue());
		if (formMap.getField("pi_mobile") != null) setMobile(formMap.getField("pi_mobile").getValue());
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
