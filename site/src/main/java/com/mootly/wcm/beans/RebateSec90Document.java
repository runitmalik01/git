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
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PREMISES_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Value;


import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;

import com.mootly.wcm.member.Calculations;
import com.mootly.wcm.utils.ValueListService;
import com.mootly.wcm.utils.ValueListServiceImpl;

/**
 * author: Pankaj Singh
 * Date: 30/03/2013
 * 
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:rebatedocumentninety")
public class RebateSec90Document extends BaseDocument implements ContentNodeBinder,FormMapFiller {

	static final public String NAMESPACE = "mootlywcm:rebatedocumentninety";
	static final public String NODE_NAME = "rebatedocumentninety";



	private String section90;
	private String section91;
	private String userCountry;
	private Double taxPaidForeignCountry;
	private Double incomeForeignCountry;
	
	public String getSection90() {
    	if (section90 == null) section90 = getProperty("mootlywcm:section90");
    	return section90;
    }

    public String getSection91() {
    	if (section91== null) section91= getProperty("mootlywcm:section91");
    	return section91;
    }
    public String getUserCountry() {
    	if (userCountry== null) userCountry= getProperty("mootlywcm:userCountry");
    	return userCountry;
    }
    public Double getTaxPaidForeignCountry() {
    	if (taxPaidForeignCountry == null) taxPaidForeignCountry= getProperty("mootlywcm:taxPaidForeignCountry");
    	return taxPaidForeignCountry;
    }
    public Double getIncomeForeignCountry() {
    	if (incomeForeignCountry == null) incomeForeignCountry= getProperty("mootlywcm:incomeForeignCountry");
    	return incomeForeignCountry;
    }


	public final void setSection90(String Section90) {
		this.section90 = Section90;
	}

	public final void setSection91(String Section91) {
		this.section91 = Section91;
	}
	public final void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public final void setTaxPaidForeignCountry(Double taxPaidForeignCountry) {
		this.taxPaidForeignCountry = taxPaidForeignCountry;
	}
	public final void setIncomeForeignCountry(Double incomeForeignCountry) {
		this.incomeForeignCountry = incomeForeignCountry;
	}
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if(log.isInfoEnabled()){
			log.info("this is Contact bean");
			}
			RebateSec90Document rebate = (RebateSec90Document) content;
			node.setProperty("mootlywcm:section90", rebate.getSection90());
	    	node.setProperty("mootlywcm:section91", rebate.getSection91());
	    	node.setProperty("mootlywcm:userCountry", rebate.getUserCountry());
	    	node.setProperty("mootlywcm:taxPaidForeignCountry", rebate.getTaxPaidForeignCountry());
	    	node.setProperty("mootlywcm:incomeForeignCountry", rebate.getIncomeForeignCountry());
	    	
	    		
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
		String strTaxpaid=null;
		String strIncomeForeign=null;
		if (formMap.getField("userCountry") != null) setUserCountry(formMap.getField("userCountry").getValue());
		if (formMap.getField("taxPaidForeignCountry") != null) 
			strTaxpaid=formMap.getField("taxPaidForeignCountry").getValue();
			double TaxpaidInForeignCountry=Double.parseDouble(strTaxpaid);
			setTaxPaidForeignCountry(TaxpaidInForeignCountry);
		if (formMap.getField("incomeForeignCountry") != null) 
			strIncomeForeign=formMap.getField("incomeForeignCountry").getValue();
		double IncomeForeign=Double.parseDouble(strIncomeForeign);
				setIncomeForeignCountry(IncomeForeign);
		
		
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}

	
	
}
