/*
 * 
 * In this class we are creating a document for calculations of incomes from all head
 * @author abhishek
 * 29/03/2013
 * 
 */

package com.mootly.wcm.member;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;
import javax.transaction.SystemException;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CapitalAssetInformation;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDocument;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberRebateSectionEightyNine;
import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SecuritiesInformation;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromOthersInformation;
import com.mootly.wcm.beans.TdsFromSalaryInformation;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

public class Calculations extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(Calculations.class);
	Member member = null;
	String filing_year = null;
	String modusername= null;
	String pan = null;
	Session persistableSession = null;

	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.warn("This is Start calculation Page");
		member=(Member)request.getSession().getAttribute("user");
		pan=(String) request.getSession().getAttribute("pan");
		if(null == pan)
		{
			pan ="abcdb1234a";
		}
		filing_year=(String) request.getSession().getAttribute("filing_year");
		if(null == filing_year)
		{
			filing_year ="2012-2013";
		}
		String username=member.getUserName().trim();
		modusername=username.replaceAll("@", "-at-").trim();
		log.info("inside fetchSalaryIncomeDocument--->member:-"+member);
		if(member!=null){

			// fetching Salary Income value
			float fSalaryIncome = fetchSalaryIncomeValue(request,response);
			// fetching OtherIncome value
			float fOtherIncome = fetchOtherIncomeValue(request,response);
			//fetching house property values
			float fHouseProperty = fetchHousePropertyValue(request,response);
			//fetching capital gain values
			float fCapitalGain = fetchCapitalGainValue(request,response);
			//fetching TCS document values
			float fTcsDoc = fetchTcsDocumentValue(request,response);
			// fetching Deduction  value
			float fDeduction = fetchDeductionsValue(request,response);
			// fetching Losses value
			float fAdjustLosses = fetchLossesValue(request,response);
			// fetching Securities value
			float fSecurities = fetchSecurityValue(request,response);
			// fetching Interest value
			float fInterest = fetchinterestValue(request,response);
			// fetching Rebate89  value
			float fRebate89 = fetchrebate89Value(request,response);
			// fetching Rebate 90-91 value
			float fRebate90_91 = fetchrebate90_91Value(request,response);
			// fetching TDS from salary value
			float ftdsSalary=fetchTdsfromsalaryValue(request,response);

			float flessRebate=fRebate89 + fRebate90_91;
			float ftdsother=fetchTdsOtherValue(request,response);
			float fTotal= fSalaryIncome + fOtherIncome + fHouseProperty + fCapitalGain + fSecurities;
			log.info("Total of all"+fTotal);
			log.info("big decimal"+BigDecimal.valueOf(fTotal).toPlainString());
			float fGrossTotal = fTotal-fAdjustLosses;
			float fTaxableIncome= fGrossTotal-fDeduction;
			//float fIncomeTax=(float)Math.round(fTaxableIncome*(0.1f));
			// for fetching income tax according to slab rates
			float fIncomeTax= fetchIncomeTaxValue(request,response,fTaxableIncome);
			log.info("income tax is"+fIncomeTax);
			float fEduCess=(float) Math.round(fIncomeTax*0.03f);
			float fIncomeTaxEduCess=fIncomeTax + fEduCess ;
			float fTaxafterrebate= fIncomeTaxEduCess - flessRebate;
			float fselfasses =0.0f;
			float fLessPrepaidTax = ftdsother +  ftdsSalary + fTcsDoc+ fselfasses;
			float fTax_Payable =(fTaxafterrebate + fInterest - fLessPrepaidTax);
			float fNormaltax= 0.0f;
			float fSpecialtax= 0.0f;
			float fSurcharge= 0.0f;
			log.info("dhvdhdg################"+fCapitalGain);
			int decimalPlace = 2;

			//setting textfield values of Summary page

			request.setAttribute("GROSS_SALARY", BigDecimal.valueOf(fSalaryIncome).toPlainString());
			request.setAttribute("TAXABLE_INCOME",BigDecimal.valueOf(fOtherIncome).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("HouseProperty", BigDecimal.valueOf(fHouseProperty).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("CAPITALGAIN",  BigDecimal.valueOf(fCapitalGain).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("TAXCOLLECTED", BigDecimal.valueOf(fTcsDoc).toPlainString());
			request.setAttribute("DEDUCTION",BigDecimal.valueOf(fDeduction).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Total", BigDecimal.valueOf(fTotal).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Normaltax", BigDecimal.valueOf(fNormaltax).toPlainString());
			request.setAttribute("Surcharge", BigDecimal.valueOf(fSurcharge).toPlainString());
			request.setAttribute("Specialtax", BigDecimal.valueOf(fSpecialtax).toPlainString());
			request.setAttribute("Taxable", BigDecimal.valueOf(fTaxableIncome).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Interest",BigDecimal.valueOf(fInterest).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("GrossTotal",BigDecimal.valueOf(fGrossTotal).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("TdsSalary", BigDecimal.valueOf(ftdsSalary).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("TdsOther", BigDecimal.valueOf(ftdsother).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Rebate89", BigDecimal.valueOf(fRebate89).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Rebate90_91",BigDecimal.valueOf(fRebate90_91).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("LesssRebate", BigDecimal.valueOf(flessRebate).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Incometax",BigDecimal.valueOf(fIncomeTax).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("EduCess", BigDecimal.valueOf(fEduCess).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Losses",BigDecimal.valueOf(fAdjustLosses).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("tax_payable",BigDecimal.valueOf(fTax_Payable).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Security",BigDecimal.valueOf(fSecurities).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Lessprepaidtax",BigDecimal.valueOf(fLessPrepaidTax).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Selfasses",BigDecimal.valueOf(fselfasses).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("Taxafterrebate",BigDecimal.valueOf(fTaxafterrebate).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("IncomeTaxEduCess", BigDecimal.valueOf(fIncomeTaxEduCess).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
			request.setAttribute("screenMode","nextScreen");

		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		String Screen_Mode=GoGreenUtil.getEscapedParameter(request, "screenMode");
		// redirect to next page when user clicks on "next" button
		if(Screen_Mode.equals("nextScreen")){
			log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxx nextscreen modeeeeeeeeeeeee");
			try {
				response.sendRedirect(UrlUtility.MemberfrontPage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.warn("SalaryIncome-doAction()-->error in redirection:-"+e);
			} 	
		}
		else{
			try {
				response.sendRedirect(UrlUtility.MemberfrontPage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

			final String itReturnFolderPath = ContentStructure.getMemberSalaryPathFetch(request,member.getUserName());
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

				String itReturnFolderPathFetch = ContentStructure.getOtherIncomePathUpdate(request,member.getUserName());
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
		private float  fetchIncomeTaxValue(HstRequest request,HstResponse response,float fTaxableIncome) {
			// TODO Auto-generated method stub
			float fIncomeTax = 0.0f;
			log.info("inside fetchtcsDocument--->before try:-");
			try {
				String path=ContentStructure.getPersonalDocumentPath(pan,filing_year,modusername);
				MemberPersonalInformation document=(MemberPersonalInformation)getObjectBeanManager(request).getObject(path);				
				Calendar dob=document.getDOB();
				Date date =dob.getTime();
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String fetchdob=formatter.format(date);
				request.setAttribute("dob", fetchdob);
				request.setAttribute("document", document);
				MemberAge age = new MemberAge();
				log.info("dob currentdate1 date  is"+age.MemberAgeCalculate(dob));
				int Age = age.MemberAgeCalculate(dob);
				if(filing_year=="2012-2013") {
					log.info("i am fetching income tax "+filing_year);
					log.info("value of taxable income is"+fTaxableIncome);
					if (document.getSex().matches("M")){

						if((Age - 2) < 60 ){


							log.info("value of taxable income i male"+fTaxableIncome);
							if (fTaxableIncome <= 180000.0f && fTaxableIncome !=0.0f ) {
								log.info("Male is there");
								float fIncomeTax1=0.0f;
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 180000.0f && fTaxableIncome <= 500000.0f){
								float A = (float) ((fTaxableIncome - 200000.0f) * 0.1); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 2000001 and 500000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 500001.0f && fTaxableIncome <= 800000.0f){
								log.info(" First-->Second Else IF condition");
								float A = (float) (((fTaxableIncome - 500000.0f) * 0.2) + 32000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 500001 and 1000000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome >800000.0f){
								log.info(" First-->Third Else IF condition");
								float A = (float) (((fTaxableIncome - 800000.0f) * 0.3) + 92000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is more then 1000000");
								return fIncomeTax1;

							}
						}else{
							log.info("here we are for senior citizen");
							log.info("value of taxable income i male"+fTaxableIncome);
							if (fTaxableIncome <= 250000.0f && fTaxableIncome !=0.0f ) {
								log.info("Male is there");
								float fIncomeTax1=0.0f;
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 250000.0f && fTaxableIncome <= 500000.0f){
								float A = (float) ((fTaxableIncome - 250000.0f) * 0.1); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 2000001 and 500000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 500001.0f && fTaxableIncome <= 800000.0f){
								log.info(" First-->Second Else IF condition");
								float A = (float) (((fTaxableIncome - 500000.0f) * 0.2) + 25000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 500001 and 1000000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome >800000.0f){
								log.info(" First-->Third Else IF condition");
								float A = (float) (((fTaxableIncome - 800000.0f) * 0.3) + 85000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is more then 1000000");
								return fIncomeTax1;

							}

						}
					}
					else{
						log.info("here we are dealing for female");
						log.info("value of taxable income"+fTaxableIncome);
						if((Age-2)< 60){

							if (fTaxableIncome <= 190000.0f && fTaxableIncome !=0.0f ) {
								log.info("FeMale is there");
								float fIncomeTax1 = 0.0f;
								return fIncomeTax1;

							}
							else if (fTaxableIncome > 190000.0f && fTaxableIncome <= 500000.0f){
								float A = (float) ((fTaxableIncome - 190000.0f) * 0.1); 

								float fIncomeTax1 = Math.round((A )* 100) / 100;
								log.info("Tax is between 2000001 and 500000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 500001.0f && fTaxableIncome <= 800000.0f){
								log.info(" First-->Second Else IF condition");
								float A = (float) (((fTaxableIncome - 500000.0f) * 0.2) + 32000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 500001 and 1000000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 800000.0f){
								log.info(" First-->Third Else IF condition");
								float A = (float) (((fTaxableIncome - 1000000.0f) * 0.3) + 91000.0f); 
								float fIncomeTax1 = Math.round((A )* 100) / 100;
								log.info("Tax is more then 1000000");
								return fIncomeTax1;

							}
						}else{
							log.info("cinior citizen female");
							if (fTaxableIncome <= 250000.0f && fTaxableIncome !=0.0f ) {
								log.info("feMale is there");
								float fIncomeTax1=0.0f;
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 250000.0f && fTaxableIncome <= 500000.0f){
								float A = (float) ((fTaxableIncome - 250000.0f) * 0.1); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 2000001 and 500000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome > 500001.0f && fTaxableIncome <= 800000.0f){
								log.info(" First-->Second Else IF condition");
								float A = (float) (((fTaxableIncome - 500000.0f) * 0.2) + 25000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is between 500001 and 1000000");
								return fIncomeTax1;
							}
							else if (fTaxableIncome >800000.0f){
								log.info(" First-->Third Else IF condition");
								float A = (float) (((fTaxableIncome - 800000.0f) * 0.3) + 85000.0f); 
								float fIncomeTax1 = Math.round((A)* 100) / 100;
								log.info("Tax is more then 1000000");
								return fIncomeTax1;

							}
						}
					}
				}
			}
			catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fIncomeTax;
		}
	}