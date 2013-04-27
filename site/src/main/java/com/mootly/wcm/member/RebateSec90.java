package com.mootly.wcm.member;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SecuritiesDoc;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.member.Calculations;

/**

 * @author:Pankaj Singh
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */
@PrimaryBean(primaryBeanClass=RebateSec90Document.class)
@FormFields(fieldNames= {"userCountry","taxPaidForeignCountry","incomeForeignCountry"})
@AdditionalBeans(additionalBeansToLoad={AdjustmentOfLossesDoc.class,InterestDoc.class} )



public class RebateSec90 extends ITReturnComponent {
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		// to find eithr user lies in section 90 or 91
		
		double fetchHouseProperty=0.0;
		double fetchOtherIncome=0.0;
		double fetchDeduction=0.0;
		double fetchAdjustLosses=0.0;
		double fetchSecurities=0.0;
		double fetchInterest= 0.0;
		double fetchSalaryIncome=0.0;
		// fetching Salary Income value
		/*
		Calculations cal = new Calculations();
		if(request.getAttribute("salaryincomedocument") != null){
		fetchSalaryIncome = cal.fetchSalaryIncomeValue(request,response);
		}
		// fetching OtherIncome value
		//if(request.getAttribute("othersourceincome") !=null){
		 //fetchOtherIncome =cal.fetchOtherIncomeValue(request,response);
		//}
		//if(request.getAttribute("houseproperty") !=null){
			//fetching house property values
			// fetchHouseProperty = cal.fetchHousePropertyValue(request,response);
		//}
		// fetching deductions 
		//if(request.getAttribute("memberdeductionschedulevi") !=null){
		 //fetchDeduction = cal.fetchDeductionsValue(request,response);
		//}
		// fetching Losses value
		if(request.getAttribute("adjustmentoflossesdoc") != null){
		 fetchAdjustLosses = cal.fetchLossesValue(request,response);
		}
		// fetching Securities value
		//if(request.getAttribute("securitiesdoc") !=null){
		// fetchSecurities = cal.fetchSecurityValue(request,response);
		//}
		// fetching Interest value
		if(request.getAttribute("interestdoc") != null){
		 fetchInterest =cal.fetchinterestValue(request,response);
		}
		

		
		
		double fTotal= fetchSalaryIncome + fetchOtherIncome + fetchHouseProperty + fetchSecurities;
		System.out.println("Total of all"+fTotal);
		System.out.println("big decimal"+BigDecimal.valueOf(fTotal).toPlainString());
		double fGrossTotal = fTotal-fetchAdjustLosses;
		double fTaxableIncome= fGrossTotal-fetchDeduction;
		System.out.println("fTaxableIncome"+fTaxableIncome);
		*/
		RebateSec90Document objRebateNinety = (RebateSec90Document)request.getAttribute("parentBean");
		String userCountry=objRebateNinety.getUserCountry();
		System.out.println("userCountry:::::::::::::"+userCountry);
		ResourceBundle rb = ResourceBundle.getBundle("valueList_dtaaCountries");
		for(int n=1;n<=4;n++){
		String listCountry=rb.getString("valueList."+n);
		System.out.println("N IS:::::"+n);
		System.out.println("listCountry"+listCountry);
		if(userCountry.equals(listCountry)){
			System.out.println("this is the case of section 90");
			// following data is hard codeded for calculation
			
			int IncomeOutside=240000;
			int intIncomeIndia=450000;
			int Incometaxable=intIncomeIndia+IncomeOutside;
			int tax = 68000;
			double eduCess=tax*0.03;
			double totalTax=tax+eduCess;
			double Rateoftaxinindia= (totalTax*100)/Incometaxable;
			double avgTaxOnForeignIncome=(Rateoftaxinindia*IncomeOutside)/100;
			double taxPaidInInForeignCountry=objRebateNinety.getTaxPaidForeignCountry();
			System.out.println("avgTaxOnForeignIncome "+avgTaxOnForeignIncome);
			System.out.println("taxPaidInInForeignCountry "+taxPaidInInForeignCountry);
			
			// for finding smallest among two rates to show on jsp page.
			if(taxPaidInInForeignCountry>avgTaxOnForeignIncome){
				String relief=BigDecimal.valueOf(avgTaxOnForeignIncome).toPlainString();
				System.out.println("relief QQQQQQQQQQQQQQ "+relief);
				request.setAttribute("relief", relief);
				System.out.println("if indian rate is less ");
				
			}else{
				System.out.println("if indian rate is more ");
				String reliefForiegn=BigDecimal.valueOf(taxPaidInInForeignCountry).toPlainString();
				request.setAttribute("reliefForiegn", reliefForiegn);
				System.out.println("reliefForiegn OOOOOOOOOOOOOO"+reliefForiegn);
			}
		
		
		}else{
			System.out.println("this is the case of rebate sec 91");
		}
		}
		
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		System.out.println("this is do Action  of rebate sec 90/91");
	}
	
}


