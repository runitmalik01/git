package com.mootly.wcm.services.ditws;

import java.util.GregorianCalendar;

import javax.xml.ws.soap.SOAPFaultException;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.AddClientDetailsResponse;


public interface AddClientDetails {	
	public static enum AddClientOption {
		tdsOption,advanceTaxOption,TaxNotFiledForLastTwoYears
	}
	public AddClientDetailsResponse addClientDetails(String userName,String password,String certChain, String signature, String PAN,GregorianCalendar DOB,String email,AddClientOption addClientOption,String TAN,FinancialYear financialYear)  throws SOAPFaultException, MissingInformationException,DataMismatchException,InvalidFormatException;
}
