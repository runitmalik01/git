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

package com.mootly.wcm.utils;

public interface Constants {

	String PAGE = "pageNumber";
	String PAGEABLE_RESULT = "pageableResult";
	String PAGE_SIZE = "pageSize";
	int DEFAULT_PAGE_SIZE = 10;
	int DEFAULT_PAGE_NUMBER = 1;
	int NOT_FOUND_INT_VALUE = -1;

	String PROP_ANSWER = "mootlywcm:answer";
	String PROP_BODY = "mootlywcm:body";
	String PROP_CATEGORIES = "mootlywcm:categories";
	String PROP_COMMENT = "mootlywcm:comment";
	String PROP_COPYRIGHT = "mootlywcm:copyright";
	String PROP_COPYRIGHT_DESCRIPTION = "mootlywcm:description";
	String PROP_COPYRIGHT_URL = "mootlywcm:url";
	String PROP_DATE = "mootlywcm:date";
	String PROP_DESCRIPTION = "mootlywcm:description";
	String PROP_EMAIL = "mootlywcm:email";
	String PROP_ENDDATE = "mootlywcm:enddate";
	String PROP_HIPPO_DOCBASE = "hippo:docbase";
	String PROP_IMAGELINK = "hippogallerypicker:imagelink";
	String PROP_LOCATION = "mootlywcm:location";
	String PROP_NAME = "mootlywcm:name";
	String PROP_RATING = "mootlywcm:rating";
	String PROP_QUESTION = "mootlywcm:question";
	String PROP_SUMMARY = "mootlywcm:summary";
	String PROP_TITLE = "mootlywcm:title";
	String PROP_FORM = "mootlywcm:form";
	String PROP_NEW_PASSWORD = "mootlywcm:New_Password";
	String PROP_OLD_PASSWORD = "mootlywcm:Old_Password";

	String PROP_CONTACT_US = "mootlywcm:contactus";
	String PROP_CU_USER_NAME = "mootlywcm:cu_user_name";
	String PROP_CU_EMAIL_ADDRESS = "mootlywcm:cu_email_address";
	String PROP_CU_COMMENTS = "mootlywcm:cu_comments";

	String NT_NOTIFICATIONITEMS="mootlywcm:notificationitems";

	String BSR1="mootlywcm:BSR_code1";
	String DATE1="mootlywcm:Date of credit into Govt Account1";
	String SERIAL1="mootlywcm:Serail_No_of_Challan1";
	String AMOUNT1="mootlywcm:Amount1";

	String Rsstatus_q="mootlywcm:rsstatus_q";
	String Rsstatus_q_yes="mootlywcm:rsstatus_q_yes";
	String Rsstatus_q_yes_yes="mootlywcm:rsstatus_q_yes_yes";
	String Rsstatus_q_yes_yes_yes="mootlywcm:rsstatus_q_yes_yes_yes";
	String Rsstatus_q_yes_no="mootlywcm:rsstatus_q_yes_no";
	String Rsstatus_q_yes_yes_no="mootlywcm:rsstatus_q_yes_yes_no";
	String Rsstatus_q_no="mootlywcm:rsstatus_q_no";
	String Rsstatus_q_no_yes="mootlywcm:rsstatus_q_no_yes";
	String Rsstatus_q_no_yes_no="mootlywcm:rsstatus_q_no_yes_no";
	String Rsstatus_q_no_yes_yes="mootlywcm:rsstatus_q_no_yes_yes";
	String Rsstatus_q_no_no="mootlywcm:rsstatus_q_no_no";
	String Rsstatus_q_no_no_no="mootlywcm:rsstatus_q_no_no_no";
	String Rsstatus_q_no_no_yes="mootlywcm:rsstatus_q_no_no_yes";
	String Rsstatus_q_no_no_yes_yes="mootlywcm:rsstatus_q_no_no_yes_yes";
	String Rsstatus_q_no_no_yes_yes_yes="mootlywcm:rsstatus_q_no_no_yes_yes_yes";
	String Rsstatus_q_no_yes_yes_yes="mootlywcm:rsstatus_q_no_yes_yes_yes";
	String Rsstatus_q_no_yes_yes_yes_yes="mootlywcm:rsstatus_q_no_yes_yes_yes_yes";
	String Rsstatus_q_no_yes_yes_yes_no="mootlywcm:rsstatus_q_no_yes_yes_yes_no";

    String NT_COMMENT = "mootlywcm:comment";
    String NT_COPYRIGHT = "mootlywcm:copyright";
    String NT_DOCUMENTLINK = "mootlywcm:documentlink";
    String NT_FAQ = "mootlywcm:faq";
    String NT_HIPPO_MIRROR = "hippo:mirror";
    String NT_NEWSITEM = "mootlywcm:newsitem";
    String NT_PRODUCTLINK = "mootlywcm:productlink";
    String NT_REVIEW = "mootlywcm:review";
    String NT_PRODUCT = "mootlywcm:product";
    String NT_SIMPLE_DOCUMENT = "mootlywcm:simpledocument";
    String NT_ITR_1 = "mootlywcm:itrone";
    String NT_ITR = "mootlywcm:incometaxreturn";
    String BSR="mootlywcm:BSRcode";
    String DATE="mootlywcm:Dateofcredit";
    String SERIAL="mootlywcm:challanNo";
    String AMOUNT="mootlywcm:Amount";   
    
    String BD_BANK_NAME="mootlywcm:bankName";
    String BD_MICR_CODE="mootlywcm:micrCode";
    String BD_ADD_BANK_BRANCH="mootlywcm:addBankBranch";
    String BD_TYPE_ACC="mootlywcm:typeAcc";
    String BD_ACC_NUMBER="mootlywcm:accNumber";
    String BD_ECS="mootlywcm:ecs";
    String BD_STATUS="mootlywcm:bankDetailStatus";
    
    String tan_Employer="mootlywcm:tanofemployer";
    String name_Employer="mootlywcm:nameofemployer";
    String income_Chargeable="mootlywcm:incomechargeable";
    String total_Taxdeducted="mootlywcm:totaltaxdeducted";
    
    String tan_deductor="mootlywcm:tandeductor";
    String name_deductor="mootlywcm:namedeductor";
    String tds_Certificate="mootlywcm:tdscertificate";
    String financial_Year="mootlywcm:financialyear";
    String total_taxdeducted="mootlywcm:totaltaxdeducted";
     
    String amount="mootlywcm:amount";
   
	String PROP_PERSONAL_INFORMATION = "mootlywcm:personalinformation";
	String PROP_PI_FIRST_NAME = "mootlywcm:pi_first_name";
	String PROP_PI_FATHER_NAME = "mootlywcm:pi_father_name";
	String PROP_PI_MIDDLE_NAME = "mootlywcm:pi_middle_name";
	String PROP_PI_LAST_NAME = "mootlywcm:pi_last_name";

	String PROP_PI_RESIDENTIAL_CATEGORY = "mootlywcm:pi_residential_category";
	String PROP_PI_PAN = "mootlywcm:pi_pan";
	String PROP_PI_FLAT_FLOOR_BUILDING = "mootlywcm:pi_flat_door_building";
	String PROP_PI_PREMISES_BUILDING = "mootlywcm:pi_premises_building";
	String PROP_PI_FILING_STATUS = "mootlywcm:pi_filing_status";
	String PROP_PI_ROAD_STREET = "mootlywcm:pi_road_street";
	String PROP_PI_AREA_LOCALITY = "mootlywcm:pi_area_locality";
	String PROP_PI_DOB = "mootlywcm:pi_dob";
	String PROP_PI_TOWN_CITY_DISTRICT = "mootlywcm:pi_town_city_district";
	String PROP_PI_STATE = "mootlywcm:pi_state";
	String PROP_PI_COUNTRY = "mootlywcm:pi_country";
	String PROP_PI_PINCODE = "mootlywcm:pi_pin_code";
	String PROP_PI_SEX = "mootlywcm:pi_sex";
	String PROP_PI_EMAIL = "mootlywcm:pi_email";
	String PROP_PI_MOBILE = "mootlywcm:pi_mobile";
	String PROP_PI_MOBILE1 = "mootlywcm:pi_mobile1";
	String PROP_PI_STD_CODE = "mootlywcm:pi_std_code";
	String PROP_PI_WARD_CIRCLE = "mootlywcm:ward";
	String PROP_PI_PHONE = "mootlywcm:pi_phone";
	String PROP_PI_RESIDENT_CATEGORY = "mootlywcm:pi_residential_category";
	String PROP_PI_FINANCIAL_YEAR="mootlywcm:financialYear";
	String PROP_PI_RETURN_TYPE="mootlywcm:returnType";
	String PROP_PI_ORIGINAL_ACK_NO="mootlywcm:originalAckNo";
	String PROP_PI_ORIGINAL_ACK_DATE="mootlywcm:originalAckDate";
	String PROP_PI_DEFECTIVE="mootlywcm:defective";
	String PROP_PI_NOTICE_NO="mootlywcm:noticeNo";
	String PROP_PI_NOTICE_DATE="mootlywcm:noticeDate";
	String PROP_PI_EMPLOYEE_CATEGORY="mootlywcm:employeeCategory";
	String PROP_PI_RETURN_FILE_SECTION="mootlywcm:returnFileSection";
	String PROP_PI_INCOME_TAX_WARD="mootlywcm:incomeTaxWard";
	String PROP_PI_RECEIPT_NO="mootlywcm:receiptNo";
	String PROP_PI_TAX_STATUS="mootlywcm:taxStatus";
	String PROP_PI_RETURN_SECTION="mootlywcm:returnsection";
	String PROP_PI_PORTUGESE_CIVIL="mootlywcm:portugeseCivil";
	
	String PROP_PI_EMPLOYER_CATEGORY = "mootlywcm:pi_employer_category";

	String PROP_PI_PERSONALINFO_LINK="mootlywcm:personalinfolink";
	String NT_PERSONAL_INFO_LINK = "mootlywcm:personalinfolink";

	String PROP_TDS_SALARY = "mootlywcm:tdssalary";
	String TEST_TDSOTHERS="mootlywcm:testTdsothers";
	String COMPTDS_OTHERS="mootlywcm:CompTdsOthers";
	String ADVANCETAX="mootlywcm:advancetaxinfo";
	String SELFASSESMENT="mootlywcm:selfassesmentinfo";

	String PROP_EMPLOYER_TAN = "mootlywcm:employer_name";
	String PROP_EMPLOYER_NAME = "mootlywcm:employer_tan";
	String PROP_EMPLOYER_SALARIES = "mootlywcm:income_salaries";
	String PROP_TOTAL_TAX_DEDUCTED = "mootlywcm:total_tax_deducted";

	String tds_certificate="mootlywcm:tdscertificate";
	String deducted_year="mootlywcm:deductedyear";
	String PROP_FORM_16_LINK="mootlywcm:formsixteenlink";
	
	String NAMEPERSON="mootlywcm:name_Person";
	String PANPERSON="mootlywcm:pan_Person";
	String RELATIONSHIP="mootlywcm:relationship";
	String NATUREINCOME="mootlywcm:nature_income";
	String AMOUNTCLUB="mootlywcm:amount";
	
	String COUNTRYCODE="mootlywcm:country_code";
	String TAXPAYERID="mootlywcm:taxpayer_ID";
	String INCOMESALARY="mootlywcm:income_salary";
	String INCOMEHOUSE="mootlywcm:income_house";
	String INCOMEBUSINESS="mootlywcm:income_business";
	String INCOMECAPITALGAIN="mootlywcm:income_capitalgain";
	String INCOMESOURCES="mootlywcm:income_othersources";
	String INCOMETOTAL="mootlywcm:income_total";
	



}
