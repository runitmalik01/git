package com.mootly.wcm.services.ditws.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.NotWritablePropertyException;

import com.mootly.wcm.services.ditws.soap.SOAPCallWrapperHelper;

public class Twenty26ASResponse {
	public final static String MAP_KEY_TDSonSalaries = "TDSonSalaries";
	public final static String MAP_KEY_TDSonOthThanSals = "TDSonOthThanSals";
	public final static String MAP_KEY_ScheduleTCS = "ScheduleTCS";
	public final static String MAP_KEY_TaxPayments = "TaxPayments";
	
	private static Logger logger = LoggerFactory.getLogger(Twenty26ASResponse.class);
	
	List<Twenty26ASTDSOnSalary> twenty26astdsOnSalaries;
	List<Twenty26ASTDSOtherThanSalary> twenty26astdsOtherThanSalaries;
	List<Twenty26ASTCS> twenty26astcs;
	List<Twenty26ASTaxPayment> twenty26asTaxPayments;
	
	
	/*
	 *     	       <value>TDSonSalaries</value>
    	       <value>TDSonOthThanSals</value>
    	       <value>ScheduleTCS</value>
    	       <value>TaxPayments</value>
	 */
	//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
	//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
	//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
	//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}

	public final List<Twenty26ASTDSOnSalary> getTwenty26astdsOnSalaries() {
		return twenty26astdsOnSalaries;
	}

	public final void setTwenty26astdsOnSalaries(
			List<Twenty26ASTDSOnSalary> twenty26astdsOnSalaries) {
		this.twenty26astdsOnSalaries = twenty26astdsOnSalaries;
	}

	public final List<Twenty26ASTDSOtherThanSalary> getTwenty26astdsOtherThanSalaries() {
		return twenty26astdsOtherThanSalaries;
	}

	public final void setTwenty26astdsOtherThanSalaries(
			List<Twenty26ASTDSOtherThanSalary> twenty26astdsOtherThanSalaries) {
		this.twenty26astdsOtherThanSalaries = twenty26astdsOtherThanSalaries;
	}

	public final List<Twenty26ASTCS> getTwenty26astcs() {
		return twenty26astcs;
	}

	public final void setTwenty26astcs(List<Twenty26ASTCS> twenty26astcs) {
		this.twenty26astcs = twenty26astcs;
	}

	public final List<Twenty26ASTaxPayment> getTwenty26asTaxPayments() {
		return twenty26asTaxPayments;
	}

	public final void setTwenty26asTaxPayments(
			List<Twenty26ASTaxPayment> twenty26asTaxPayments) {
		this.twenty26asTaxPayments = twenty26asTaxPayments;
	}

	public static Twenty26ASResponse createFromSOAPResponse(Map<String,Object> soapResponseMap) {
		Twenty26ASResponse ret = new Twenty26ASResponse();
		
		Map<String,List<String>> scheduleTCSMap = (Map<String,List<String>>) soapResponseMap.get(MAP_KEY_ScheduleTCS);		
		Map<String,List<String>> tdsOnOthThanSals = (Map<String,List<String>>) soapResponseMap.get(MAP_KEY_TDSonOthThanSals);
		Map<String,List<String>> tdsOnSals = (Map<String,List<String>>) soapResponseMap.get(MAP_KEY_TDSonSalaries);
		Map<String,List<String>> taxPayments = (Map<String,List<String>>) soapResponseMap.get(MAP_KEY_TaxPayments);
		
		try {
			ret.setTwenty26astdsOnSalaries( SOAPCallWrapperHelper.getInstanceFromSOAPMap(Twenty26ASTDSOnSalary.class,tdsOnSals) );
			ret.setTwenty26astdsOtherThanSalaries( SOAPCallWrapperHelper.getInstanceFromSOAPMap(Twenty26ASTDSOtherThanSalary.class,tdsOnOthThanSals) );
			ret.setTwenty26astcs(  SOAPCallWrapperHelper.getInstanceFromSOAPMap(Twenty26ASTCS.class,scheduleTCSMap) );
			ret.setTwenty26asTaxPayments( SOAPCallWrapperHelper.getInstanceFromSOAPMap(Twenty26ASTaxPayment.class,taxPayments) );					
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
		
	
}
