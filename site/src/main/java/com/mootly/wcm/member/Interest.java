/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.math.BigDecimal;
import javax.jcr.Session;
import javax.transaction.SystemException;
import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.InterestDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mootly.wcm.beans.CapitalAssetInformation;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.MemberRebateSectionEightyNine;
import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SecuritiesInformation;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromOthersInformation;
import com.mootly.wcm.beans.TdsFromSalaryInformation;
import com.mootly.wcm.utils.ContentStructure;

@PrimaryBean(primaryBeanClass=InterestDocument.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"section234A","section234B","section234C"})
public class Interest extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Interest.class);

	Member member = null;
	String filing_year = null;
	String modusername= null;
	String pan = null;
	String itReturnType = null;
	Session persistableSession = null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		//fetching values for calculation
		log.warn("This is Start calculation Page");
		
		filing_year = request.getRequestContext().getResolvedSiteMapItem().getParameter("assessmentYear");
		itReturnType = request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType"); //original versus amend
		pan = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend
		
		
		WorkflowPersistenceManager wpm;
		member=(Member)request.getSession().getAttribute("user");
	
		if(null == pan)
		{
			pan ="abcdp12234p";
		}

		if(null == filing_year)
		{
			filing_year ="2012-2013";
		}
		String username=member.getUserName().trim();
		modusername=username.replaceAll("@", "-at-").trim();
		log.info("inside fetchSalaryIncomeDocument--->member:-"+ modusername);
		if(member!=null){
        log.info("inside memberrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			

     // fetching Salary Income value
     			float fSalaryIncome = fetchSalaryIncomeValue(request,response);
     			// fetching OtherIncome value
     			float fOtherIncome = fetchOtherIncomeValue(request,response);
     			//fetching house property values
     			float fHouseProperty = fetchHousePropertyValue(request,response);
     			//fetching capital gain values
     			float fCapitalGain = fetchCapitalGainValue(request,response);
     			//fetching tcs document values
     			float fTcsDoc = fetchTcsDocumentValue(request,response);
     			// fetching Salary Income value
     			float fDeduction = fetchDeductionsValue(request,response);
     			// fetching Salary Income value
     			float fAdjustLosses = fetchLossesValue(request,response);
     			// fetching Salary Income value
     			float fSecurities = fetchSecurityValue(request,response);
     			// fetching Salary Income value
     			float fInterest = fetchinterestValue(request,response);

     			float fRebate89 = fetchrebate89Value(request,response);

     			float fRebate90_91 = fetchrebate90_91Value(request,response);

     			float ftdsSalary=fetchTdsfromsalaryValue(request,response);

     			float flessRebate=fRebate89 + fRebate90_91;
     			float ftdsother=fetchTdsOtherValue(request,response);
     			float fTotal= fSalaryIncome + fOtherIncome + fHouseProperty + fCapitalGain + fSecurities;
     			log.info("Total of all"+fTotal);
     			log.info("big decimal"+BigDecimal.valueOf(fTotal).toPlainString());
     			float fGrossTotal = fTotal-fAdjustLosses;
     			float fTaxableIncome= fGrossTotal-fDeduction;
     			float fIncomeTax=(float)fTaxableIncome*(0.1f);
     			float fEduCess=fIncomeTax*0.03f;
     			float fIncomeTaxEduCess=fIncomeTax + fEduCess ;
     			float fTaxafterrebate= fIncomeTaxEduCess - flessRebate;
     			float fselfasses =0.0f;
     			float fLessPrepaidTax = ftdsother +  ftdsSalary + fTcsDoc+ fselfasses;
     			float fTax_Payable = fTaxafterrebate + fInterest - fLessPrepaidTax;
     			float fNormaltax= 0.0f;
     			float fSpecialtax= 0.0f;
        
			float fTaxLiability=fTaxafterrebate-fLessPrepaidTax;;
			log.info("tax liabilityyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+fTaxLiability);

			final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
             
			if(fTaxLiability<=0){
				log.info("inside less than 0000000000000000000000000");
				request.setAttribute("section234a", "0");
				request.setAttribute("section234b", "0");
				request.setAttribute("section234c", "0");
			}else
			//if taxliability is smaller than 10000 or is equal to 10000 then section234A will be calculated
			if(fTaxLiability<=10000){
             log.info("inside less than 1000000000000000000000000000000000000000000");
				// calculation for Section234a

				//getting Current Date
				final Date currentdate=cal.getTime();
				System.out.println("currentdateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+currentdate);

				//setting harcoded value of Due Date i.e 31-July-2013
				cal.set(Calendar.YEAR, 2013);
				cal.set(Calendar.MONTH, 06);
				cal.set(Calendar.DAY_OF_MONTH, 31);
				cal.set(Calendar.HOUR, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				final Date duedate = cal.getTime();
				System.out.println("enddateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+duedate);

				//calculating difference between current and due date in months
				float currentdatemonth = currentdate.getYear()* 12 + currentdate.getMonth();
				float duedatemonth = duedate.getYear() * 12 + duedate.getMonth();
				float monthdiff= currentdatemonth - duedatemonth;
				System.out.println("monthdifferenceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+monthdiff);

				if(monthdiff>0){
					//calculating interest according to section 234a
					float interest234=fTaxLiability*monthdiff;
					float interest234a=interest234/100;
					System.out.println("interesttttttttttttttttttttttttttttttttttt"+interest234a);

					request.setAttribute("section234a", interest234a);
					
				}else{
					request.setAttribute("section234a", "0");
					
				}
				request.setAttribute("section234b", "0");
				request.setAttribute("section234c", "0");
			}else
				//if tax liability is greater than 10000 then section234B, section234B will be calculated
				
				if(fTaxLiability>10000){
                log.info("inside greater than110000000000000000000000000000000000000000000000000000000000000");
					// Calculation for Section234b

					//Setting hardcoded value of financial date i.e 01-April-2012			
					cal.set(Calendar.YEAR, 2012);
					cal.set(Calendar.MONTH, 03);
					cal.set(Calendar.DAY_OF_MONTH, 01);
					cal.set(Calendar.HOUR, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					final Date financialdate = cal.getTime();
					System.out.println("financialdateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+financialdate);

					//Setting hardcoded value of first advance tax payment date i.e 15-September-2012            
					cal.set(Calendar.YEAR, 2012);
					cal.set(Calendar.MONTH, 8);
					cal.set(Calendar.DAY_OF_MONTH, 15);
					cal.set(Calendar.HOUR, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					final Date advancedate = cal.getTime();
					System.out.println("advancedateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+advancedate);
					float amount=75000;

					//calculating difference between financial date and date of first advance tax payment in months         
					float financialdatemonth = financialdate.getYear()* 12 + financialdate.getMonth();
					float advancedatemonth = advancedate.getYear() * 12 + advancedate.getMonth();
					float monthdiff1= advancedatemonth - financialdatemonth;
					System.out.println("monthdifferenceeeeeeeeeeeeeeeeeeeeedelay1------------------------"+monthdiff1);

					// Hardcoded value of taxableincome,tds and advancetax
					float advancetax=135000;

					//calculating interest according to section 234b
					float assessedtax=fTaxLiability;
					float assessedtaxper=assessedtax*90;
					float ninteyassessed=assessedtaxper/100;

					if(advancetax < ninteyassessed){
						float shortfall=assessedtax-advancetax;
						float interest2344=shortfall*monthdiff1;
						float interest234b=interest2344/100;
						System.out.println("interset234bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+interest234b);
						request.setAttribute("section234b", interest234b);
					}else{
						request.setAttribute("section234b", "0");
					}

					// Calculation for Section234c

					//Setting hardcoded value of second advance tax payment date i.e 12-December-2012            
					cal.set(Calendar.YEAR, 2012);
					cal.set(Calendar.MONTH, 11);
					cal.set(Calendar.DAY_OF_MONTH, 12);
					cal.set(Calendar.HOUR, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					final Date advancedate1 = cal.getTime();
					System.out.println("advancedateeeeeeeeeeeeeeeee111111111111111-----------------------------"+advancedate1);
					float amount1=125000;

					//Setting haedcoded value of third advance tax payment date i.e 15-March-2013            
					cal.set(Calendar.YEAR, 2013);
					cal.set(Calendar.MONTH, 02);
					cal.set(Calendar.DAY_OF_MONTH, 15);
					cal.set(Calendar.HOUR, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					final Date advancedate2 = cal.getTime();
					System.out.println("advancedateeeeeeeeeeeeeeee22222222222222222222----------------------"+advancedate2);
					float amount2=200000;

					// calculating interest according to section234c
					float assessedtax1=assessedtax*30;
					float amountpayable=assessedtax1/100;
					float difference=amountpayable-amount;
					float interestcharged=difference*3;
					float interestcharged1=interestcharged/100;

					float assessedtax2=assessedtax*60;
					float amountpayable1=assessedtax2/100;
					float difference1=amountpayable1-amount1;
					float interestcharged2=difference1*3;
					float interestcharged3=interestcharged2/100;

					float assessedtax3=assessedtax*100;
					float amountpayable2=assessedtax3/100;
					float difference2=amountpayable2-amount2;
					float interestcharged4=difference2*1;
					float interestcharged5=interestcharged4/100;

					float interest234c=interestcharged1+interestcharged3+interestcharged5;
					System.out.println("section234ccccccccccccccccccccccccccccc"+interest234c);

					request.setAttribute("section234c", interest234c);
					request.setAttribute("section234a", "0");
				}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}


	/**
	 * This method is used to fetch Salary Income  Document from Repository
	 * when page is loaded
	 * @param HstRequest 
	 * @param con Connection object required for transaction. If value of the connection 
	 * object is null the method will create a new connection object. 
	 * @return fetched data from repository
	 * @throws SystemException System Exception thrown by the system
	 * @author Abhishek
	 */
	@SuppressWarnings("unused")
	private float  fetchSalaryIncomeValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fSalary = 0.0f;
		log.info("inside fetchSalaryIncomeDocument--->before try:-");
		try {

			final String itReturnFolderPath = ContentStructure.getMemberSalaryPathFetchInterest(request,member.getUserName(),pan,filing_year);
			log.info("tttttttttttttttttttttttttttttttttttttttttttttttttttttt");

			log.info("inside fetchSalaryIncomeDocument---> itReturnFolderPath:-"+itReturnFolderPath);
			log.info("after array listttttttttttt");
			SalaryIncomeDocument objSalaryIncomeDocument = null;
			objSalaryIncomeDocument = (SalaryIncomeDocument)getObjectBeanManager(request).getObject(itReturnFolderPath);
			log.info("after objjjjjjjjjjjjsalaryincome documenttttttttttttttttt");
			fSalary = Float.parseFloat(objSalaryIncomeDocument.getTotal());
			log.info("total is "+fSalary);
		}
		catch (ObjectBeanManagerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			//}
		}
		return fSalary; 

	}


	@SuppressWarnings("unused")

	private float   fetchOtherIncomeValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fOtherIncome= 0;
		log.info("inside fetchOtherIncomeDocument--->before try:-");
		try {

			String itReturnFolderPathFetch = ContentStructure.getOtherIncomePathUpdateInterest(request,member.getUserName(),pan,filing_year);
			OtherSourceIncome	objOtherSourceIncome = (OtherSourceIncome)getObjectBeanManager(request).getObject(itReturnFolderPathFetch);
			log.info("Calculation->fetchSalaryIncomeDocument--->objSalaryIncomeDocument:"+objOtherSourceIncome);
			if(objOtherSourceIncome!=null){
				fOtherIncome = Float.parseFloat(objOtherSourceIncome.getTaxable_income());
				log.info("Calculation->fetchSalaryIncomeDocument--->arrlSalaryIncome list:"+fOtherIncome);
			}

		}catch (ObjectBeanManagerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			//}
		}	
		return fOtherIncome;
	}

	private float  fetchHousePropertyValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fHouseProperty=0.0f;
		try {


			String path=ContentStructure.getHousePropertyDocPath(pan,filing_year, modusername);
			log.warn(path);
			HouseProperty houseincome =(HouseProperty)getObjectBeanManager(request).getObject(path);
			request.setAttribute("houseincome", houseincome);
			if(houseincome != null){
				fHouseProperty = Float.parseFloat(houseincome.getTotalIncome());

				log.info("object is"+fHouseProperty);
			}

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fHouseProperty;


	}

	private float   fetchCapitalGainValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fCapitalGain=0.0f;
		log.info("inside fetchOtherIncomeDocument--->before try:-");
		try {
			String path=ContentStructure.getMemberAssetDocPath(pan,filing_year, modusername);
			log.warn(path);
			CapitalAssetInformation capital =(CapitalAssetInformation)getObjectBeanManager(request).getObject(path);
			request.setAttribute("capital", capital);
			if(capital != null){

				fCapitalGain = Float.parseFloat(capital.getCapitalGain());

				log.info("object is"+fCapitalGain);
			}

			log.warn("capital object is"+capital);



		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fCapitalGain;
	}

	private float  fetchTcsDocumentValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fTcsDoc=0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getTcsDocPath(pan,filing_year, modusername);
			log.warn(path);
			TcsDocument fetchtcs =(TcsDocument)getObjectBeanManager(request).getObject(path);

			request.setAttribute("fetchtcs", fetchtcs);
			if(fetchtcs!= null){
				fTcsDoc = Float.parseFloat(fetchtcs.getAmountClaimed());

				log.warn("security object is"+fetchtcs.getName());
				log.info("fTcsDoc isssssssss"+fTcsDoc);

			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return fTcsDoc;
	}
	private float  fetchDeductionsValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fDeduction= 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getScheduleVIADocumentPath(pan,filing_year, modusername);
			log.warn(path);
			MemberDeductionScheduleVIA objDeduction =(MemberDeductionScheduleVIA)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objDeduction", objDeduction);
			if(objDeduction!= null){
				fDeduction = Float.parseFloat(objDeduction.getTotal());

			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return fDeduction;
	}
	private float  fetchLossesValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fAdjustLosses= 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getScheduleVIADocumentPath(pan,filing_year, modusername);
			log.warn(path);
			MemberDeductionScheduleVIA objDeduction =(MemberDeductionScheduleVIA)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objDeduction", objDeduction);
			if(objDeduction!= null){
				fAdjustLosses = Float.parseFloat(objDeduction.getTotal());

			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return fAdjustLosses;
	}
	private float  fetchSecurityValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fSecurities = 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getMemberSecurityDocPath(pan,filing_year, modusername);
			log.info(path);
			SecuritiesInformation objSecurity =(SecuritiesInformation)getObjectBeanManager(request).getObject(path);

			request.setAttribute("security", objSecurity);
			if(objSecurity != null){
				fSecurities = Float.parseFloat(objSecurity.getCapitalGain());
				log.info("securities is"+fSecurities);
			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fSecurities;
	}
	private float  fetchinterestValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fInterest = 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getinterestdocumentfetch(pan,filing_year, modusername);
			log.info(path);
			InterestDocument objInterestDocument =(InterestDocument)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objInterestDocument", objInterestDocument);
			if(objInterestDocument != null){
				fInterest = Float.parseFloat(objInterestDocument.getSection234A())+ Float.parseFloat(objInterestDocument.getSection234B())+ Float.parseFloat(objInterestDocument.getSection234C());
			}		log.info("tooooootalllllll isssss"+fInterest);

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fInterest;
	}
	private float  fetchrebate89Value(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fRebate89 = 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getRebateSection89(pan,filing_year, modusername);
			log.info(path);
			MemberRebateSectionEightyNine objRebate89 =(MemberRebateSectionEightyNine)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objRebate89", objRebate89);
			if(objRebate89 != null){
				fRebate89 = Float.parseFloat(objRebate89.getTaxRelief());
			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fRebate89;
	}
	private float  fetchrebate90_91Value(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fRebate90 = 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getRebateSec90DocPath(pan,filing_year, modusername);
			log.info(path);
			RebateSec90Document objRebate90 =(RebateSec90Document)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objRebate90", objRebate90);
			if(objRebate90 != null){
				fRebate90 = Float.parseFloat(objRebate90.getSection90()) + Float.parseFloat(objRebate90.getSection91());
			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fRebate90;
	}

	private float  fetchTdsfromsalaryValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fTdssalry = 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getTdsSalaryDocPath(pan,filing_year, modusername);
			log.info(path);
			TdsFromSalaryInformation objtdssalry =(TdsFromSalaryInformation)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objtdssalry", objtdssalry);
			if(objtdssalry != null){
				fTdssalry = Float.parseFloat(objtdssalry.getTotal_Value());
			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fTdssalry;
	}
	private float  fetchTdsOtherValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fTdsother = 0.0f;
		log.info("inside fetchtcsDocument--->before try:-");
		try {

			String path=ContentStructure.getTdsOthersDocPath(pan,filing_year, modusername);
			log.info(path);
			TdsFromOthersInformation objtdsother =(TdsFromOthersInformation)getObjectBeanManager(request).getObject(path);

			request.setAttribute("objtdsother", objtdsother);
			if(objtdsother != null){
				fTdsother = Float.parseFloat(objtdsother.getTotal_Value());
			}		

		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fTdsother;
	}

}
