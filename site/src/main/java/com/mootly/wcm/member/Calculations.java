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
import com.mootly.wcm.beans.MemberRebateSectionEightyNine;
import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SecuritiesInformation;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromOthersInformation;
import com.mootly.wcm.beans.TdsFromSalaryInformation;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

public class Calculations extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Calculations.class);
	private static final String NAME_EMPLOYER = "Name_employer";
	private static final String PAN_EMPLOYER = "Pan_employer";
	private static final String TAN_EMPLOYER = "Tan_employer";
	private static final String EMPLOYE_CATEGORY= "Employe_category";
	private static final String ERRORS = "errors";
	private static final String FROM = "From";
	private static final String CITY = "City";
	private static final String ADDRESS = "Address";
	private static final String TO = "To";
	private static final String PIN= "Pin";
	private static final String STATE = "State";
	private static final String GROSS_SALARY = "Gross_salary";
	private static final String PROFIT = "Profit";
	private static final String PERQUISITE = "Perquisite";
	private static final String ALLOWANCE = "Allowance";
	private static final String TAXABLE_EARNING = "Taxable_earning";

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
		WorkflowPersistenceManager wpm;
		member=(Member)request.getSession().getAttribute("user");
		pan=(String) request.getSession().getAttribute("pan");
		filing_year=(String) request.getSession().getAttribute("filing_year");
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
		    float fSurcharge= 0.0f;
		    log.info("dhvdhdg################"+fCapitalGain);
			//setting textfield values of Summary page

			request.setAttribute("GROSS_SALARY", BigDecimal.valueOf(fSalaryIncome).toPlainString());
			request.setAttribute("TAXABLE_INCOME",BigDecimal.valueOf(fOtherIncome).toPlainString());
			request.setAttribute("HouseProperty", BigDecimal.valueOf(fHouseProperty).toPlainString());
			request.setAttribute("CAPITALGAIN",BigDecimal.valueOf(fCapitalGain).toPlainString());
			request.setAttribute("TAXCOLLECTED", BigDecimal.valueOf(fTcsDoc).toPlainString());
			request.setAttribute("DEDUCTION",BigDecimal.valueOf(fDeduction).toPlainString());
			request.setAttribute("Total", BigDecimal.valueOf(fTotal).toPlainString());
			request.setAttribute("Normaltax", BigDecimal.valueOf(fNormaltax).toPlainString());
			request.setAttribute("Surcharge", BigDecimal.valueOf(fSurcharge).toPlainString());
			request.setAttribute("Specialtax", BigDecimal.valueOf(fSpecialtax).toPlainString());
			request.setAttribute("Taxable", BigDecimal.valueOf(fTaxableIncome).toPlainString());
			request.setAttribute("Interest",BigDecimal.valueOf(fInterest).toPlainString());
			request.setAttribute("GrossTotal",BigDecimal.valueOf(fGrossTotal).toPlainString());
			request.setAttribute("TdsSalary", BigDecimal.valueOf(ftdsSalary).toPlainString());
			request.setAttribute("TdsOther", BigDecimal.valueOf(ftdsother).toPlainString());
			request.setAttribute("Rebate89", BigDecimal.valueOf(fRebate89).toPlainString());
			request.setAttribute("Rebate90_91",BigDecimal.valueOf(fRebate90_91).toPlainString());
			request.setAttribute("LesssRebate", BigDecimal.valueOf(flessRebate).toPlainString());
			request.setAttribute("Incometax",BigDecimal.valueOf(fIncomeTax).toPlainString());
			request.setAttribute("EduCess", BigDecimal.valueOf(fEduCess).toPlainString());
			request.setAttribute("Losses",BigDecimal.valueOf(fAdjustLosses).toPlainString());
			request.setAttribute("tax_payable",BigDecimal.valueOf(fTax_Payable).toPlainString());
			request.setAttribute("Security",BigDecimal.valueOf(fSecurities).toPlainString());
			request.setAttribute("Lessprepaidtax",BigDecimal.valueOf(fLessPrepaidTax).toPlainString());
			request.setAttribute("Selfasses",BigDecimal.valueOf(fselfasses).toPlainString());
			request.setAttribute("Taxafterrebate",BigDecimal.valueOf(fTaxafterrebate).toPlainString());
			request.setAttribute("IncomeTaxEduCess", BigDecimal.valueOf(fIncomeTaxEduCess).toPlainString());
			request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
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
					log.info("after objjjjjjjjjjjjsalaryincome documenttttttttttttttttt");
					String itReturnFolderPathTAN = null;
					String sTAN = null;
					log.info("after objjjjjjjjjjjjsalaryincome documenttttttttttttttttt");
					Session session = request.getRequestContext().getSession();
					log.info("after taking session........................");
					Node node = (Node)session.getNode(itReturnFolderPath);
					log.info("gggggggggggggggggg"+node);
					NodeIterator nodeiterator=(NodeIterator)node.getNodes();
					log.info("SalaryIncome-fetchSalaryIncomeDocument number of nodes##############################S:"+nodeiterator.getSize()); 
					if(null == nodeiterator){  								    	
						response.sendRedirect("/site/salaryincome");
					}else{
						try {     
							log.info("SalaryIncome-fetchSalaryIncomeDocument-->TAN Available");

							while(nodeiterator.hasNext()){ 
								log.warn("in while");
								sTAN = (String) nodeiterator.nextNode().getName();
								String reg_tan = "^[A-Z]{4}\\d{5}[A-Z]$";;
								if(sTAN.matches(reg_tan.toLowerCase() )){
									log.info("stan is"+sTAN);
								//String sTAN1 = (String) nodeiterator.nextNode().getName();
								itReturnFolderPathTAN = ContentStructure.getMemberSalaryPathUpdate(request,sTAN,member.getUserName());
								log.info("in fetching after fetching tan:----%%%%%%%%%%"+itReturnFolderPathTAN);
								objSalaryIncomeDocument = (SalaryIncomeDocument)getObjectBeanManager(request).getObject(itReturnFolderPathTAN);
								log.info("in fetching after fetching tan:----%%%%%%%%%%"+objSalaryIncomeDocument);
								fSalary += Float.parseFloat(objSalaryIncomeDocument.getGross_salary());
							}
							}//end of while
						}

						catch (ObjectBeanManagerException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							//}
						}
					}
				return fSalary;
			} 
			catch (Exception e) {
				log.warn("Failed to create a review for product '" + "----- IT RETURN ------" + "'", e);
				return fSalary;
			}
			finally
			{
				if (persistableSession != null)
				{
					persistableSession.logout();
				}
			}
	}
		
	@SuppressWarnings("unused")

	private float   fetchOtherIncomeValue(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		float fOtherIncome= 0;
		log.info("inside fetchOtherIncomeDocument--->before try:-");
		try {

			String itReturnFolderPathFetch = ContentStructure.getOtherIncomePathUpdate(request,member.getUserName());
			log.info("Calculation->fetchSalaryIncomeDocument--->itReturnFolderPathTAN:"+itReturnFolderPathFetch);
			OtherSourceIncome	objOtherSourceIncome = (OtherSourceIncome)getObjectBeanManager(request).getObject(itReturnFolderPathFetch);
			log.info("Calculation->fetchSalaryIncomeDocument--->objSalaryIncomeDocument:"+objOtherSourceIncome);
			//arrlOtherIncome.add(objOtherSourceIncome);
			fOtherIncome = Float.parseFloat(objOtherSourceIncome.getTaxable_income());
			log.info("Calculation->fetchSalaryIncomeDocument--->arrlSalaryIncome list:"+fOtherIncome);
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