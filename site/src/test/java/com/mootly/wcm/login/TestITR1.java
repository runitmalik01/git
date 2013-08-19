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
package com.mootly.wcm.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.ValueFactory;

import org.apache.commons.jexl.junit.Asserter;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.security.TransientUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.member.HouseIncome;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.schedules.y2012_2013.Form16DocumentSchedules;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.y2012_2013.ITR1XmlGeneratorService;
import com.mootly.wcm.services.y2012_2013.ITRXmlGeneratorService;

/**
 * Senior, Super Senior, YOUNG/KIDS
 * @author admin
 *
 */
public class TestITR1 {

	private MockServletContext servletContext;
	private HstConcurrentLoginFilter filter;
	MemberPersonalInformation memberPersonalInformation = null;
	ValueFactory vf = ValueFactoryImpl.getInstance();
	@Before
	public void setUp() throws Exception {
		servletContext = new MockServletContext();
		filter = new HstConcurrentLoginFilter();        
	}
	
	public void initMemberInfo() {
		memberPersonalInformation = new MemberPersonalInformation();
		memberPersonalInformation.setFirstName("Amit");
		memberPersonalInformation.setMiddleName("");
		memberPersonalInformation.setLastName("PATKAR");
		memberPersonalInformation.setPAN("ABNPP1234G");
		memberPersonalInformation.setFlexField("flex_string_ITRForm", vf.createValue("ITR1"));
		GregorianCalendar gc = IndianGregorianCalendar.getIndianInstance();
		gc.set(1930, 03, 31, 12, 00);
		memberPersonalInformation.setDOB(gc);
		
	}
	
	void makeSuperSenior() {
		
	}
	
	@Test
	public void testTaxRefundSingleSalary() {
		try {
			//
			initMemberInfo();
			
			BigInteger expectedRefund = new BigInteger("100");
			
			Map<String,HippoBean> mapOfBeans = new HashMap<String, HippoBean>();

			/** -- house income --*/
			HouseProperty hp = new HouseProperty();
			HouseIncomeDetail houseIncomeDetail = new HouseIncomeDetail();    	
			houseIncomeDetail.setLetOut("L");
			houseIncomeDetail.setBalance(34000D);
			mapOfBeans.put(HouseProperty.class.getSimpleName().toLowerCase(),hp);

			/** -- Form Sixteen --*/
			FormSixteenDocument formSixteenDocument = new FormSixteenDocument();
			FormSixteenDetail formSixteenDetail = new FormSixteenDetail();
			formSixteenDetail.setEmploye_category("PSU");
			formSixteenDetail.setGross_a(9000D);			
			mapOfBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);
			
			
			XmlGeneratorService xmlGeneratorService = new ITRXmlGeneratorService();			
			mapOfBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(),memberPersonalInformation);
			
			
			Map<String,Object> returnMap = ITR1XmlGeneratorService.generateITR1(FinancialYear.TwentyTweleve, mapOfBeans);
			
			
			//get the value from the returnMap analyze the code and then you should be able to assert and check
			BigInteger salaryIncome = (BigInteger) returnMap.get("salaryincome");			
			assertTrue("Failed Salary Income", (salaryIncome.equals(1000))); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse("Exception " + e.getMessage(), e != null);
			throw new AssertionError(e);
		}

	}

}
