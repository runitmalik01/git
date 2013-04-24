/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.math.BigDecimal;

import javax.jcr.Session;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PrimaryBean(primaryBeanClass=InterestDoc.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"section234A","section234B","section234C","section234ABC","TaxLiability","DueDate","IncomeTax",
		"AmountShortfall","MonthShortfall"})

public class Interest extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Interest.class);

	Member member = null;
	String filing_year = null;
	String modusername= null;
	String pan = null;
	Session persistableSession = null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		//fetching values for calculation

		member=(Member)request.getSession().getAttribute("user");
		/*pan=(String) request.getSession().getAttribute("pan");
		if(null == pan)
		{
			pan ="abcdb1234a";
		}
		filing_year=(String) request.getSession().getAttribute("filing_year");
		if(null == filing_year)
		{
			filing_year ="2012-2013";
		}*/

		String username=member.getUserName().trim();
		modusername=username.replaceAll("@", "-at-").trim();
		filing_year = request.getRequestContext().getResolvedSiteMapItem().getParameter("assessmentYear");
		//itReturnType = request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType"); //original versus amend
		pan = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend
		log.info("inside fetchSalaryIncomeDocument--->member:-"+member);
		log.info("inside fetchSalaryIncomeDocument--->member:-"+filing_year);
		log.info("inside fetchSalaryIncomeDocument--->member:-"+pan);
		if(member!=null){

			Calculations cal=new Calculations();
			// fetching Salary Income value
			double fSalaryIncome = cal.fetchSalaryIncomeValue(request,response);
			// fetching OtherIncome value
			double fOtherIncome = cal.fetchOtherIncomeValue(request,response);
			//fetching house property values
			double fHouseProperty = cal.fetchHousePropertyValue(request,response);
			//fetching capital gain values
			double fCapitalGain = cal.fetchCapitalGainValue(request,response);
			//fetching TCS document values
			double fTcsDoc = cal.fetchTcsDocumentValue(request,response);
			// fetching Deduction  value
			double fDeduction = cal.fetchDeductionsValue(request,response);
			// fetching Losses value
			double fAdjustLosses =cal.fetchLossesValue(request,response);
			// fetching Securities value
			double fSecurities = cal.fetchSecurityValue(request,response);
			// fetching Interest value
			double fInterest = cal.fetchinterestValue(request,response);
			// fetching Rebate89  value
			double fRebate89 = cal.fetchrebate89Value(request,response);
			// fetching Rebate 90-91 value
			double fRebate90_91 = cal.fetchrebate90_91Value(request,response);
			// fetching TDS from salary value
			double ftdsSalary=cal.fetchTdsfromsalaryValue(request,response);

			double flessRebate=fRebate89 + fRebate90_91;
			double ftdsother=cal.fetchTdsOtherValue(request,response);
			double fTotal= fSalaryIncome + fOtherIncome + fHouseProperty + fCapitalGain + fSecurities;
			log.info("Total of all"+fTotal);
			log.info("big decimal"+BigDecimal.valueOf(fTotal).toPlainString());
			double fGrossTotal = fTotal-fAdjustLosses;
			double fTaxableIncome= fGrossTotal-fDeduction;
			//double fIncomeTax=(double)Math.round(fTaxableIncome*(0.1f));
			// for fetching income tax according to slab rates
			double fIncomeTax= cal.fetchIncomeTaxValue(request,response,fTaxableIncome);
			log.info("income tax is"+fIncomeTax);
			double fEduCess=(double) Math.round(fIncomeTax*0.03f);
			double fIncomeTaxEduCess=fIncomeTax + fEduCess ;
			double fTaxafterrebate= fIncomeTaxEduCess - flessRebate;
			double fselfasses =0.0f;
			double fLessPrepaidTax = ftdsother +  ftdsSalary + fTcsDoc+ fselfasses;
			double fTax_Payable =(fTaxafterrebate + fInterest - fLessPrepaidTax);
			double fNormaltax= 0.0f;
			double fSpecialtax= 0.0f;
			double fSurcharge= 0.0f;
			log.info("dhvdhdg################"+fCapitalGain);
			int decimalPlace = 2;

			double fTaxLiability=fTaxafterrebate-fLessPrepaidTax;;
			log.info("tax liabilityyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+fTaxLiability);
			request.setAttribute("taxliability", fTaxLiability);

		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
