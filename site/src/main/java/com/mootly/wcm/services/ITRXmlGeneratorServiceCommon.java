package com.mootly.wcm.services;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.ValidationResponse;

public class ITRXmlGeneratorServiceCommon implements XmlGeneratorService {

	@Override
	public String generateXml(HstRequest request, HstResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidationResponse validateXml(String xml) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidationResponse validateXml(InputStream inputStream)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> generateXml(FinancialYear financialYear,
			Map<String, HippoBean> inputBeans) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConsolidateReturnsToBulk(List<Object> listOfItrForms) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * creationInfo.setIntermediaryCity("New Delhi");
		creationInfo.setSWCreatedBy("Wealth4India");
		creationInfo.setXMLCreatedBy("Wealth4India");
	 */
	public static String getIntermediaryCity() {
		return "New Delhi";
	}

	public static String getSWCreatedBy() {
		return "Wealth4India";
	}

	public static String getXMLCreatedBy() {
		return "Wealth4India";
	}

	public static String getCurrentDateTimeInIndiaAsString1() {
		Calendar currentdate = IndianGregorianCalendar.getIndianInstance();
		String strdate = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		strdate = formatter.format(currentdate);
		System.out.println("strdate=>" + strdate);
		//TimeZone obj = TimeZone.getTimeZone("GMT + 5:30");

		//formatter.setTimeZone(obj);
		String strDate = formatter.format(currentdate.getTime());
		return strDate;
	}

	public static String getCurrentDateInIndiaAsString() {
		Calendar currentdate = Calendar.getInstance();
		String strdate = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		strdate = formatter.format(currentdate.getTime());
		System.out.println("strdate=>" + strdate);
		TimeZone obj = TimeZone.getTimeZone("GMT + 5:30");

		formatter.setTimeZone(obj);
		String strDate = formatter.format(currentdate.getTime());
		return strDate;
	}

	public static GregorianCalendar getCurrentDateInIndiaAsDate() {
		Calendar currentdate =  GregorianCalendar.getInstance();
		String strdate = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		strdate = formatter.format(currentdate.getTime());
		System.out.println("strdate=>" + strdate);
		TimeZone obj = TimeZone.getTimeZone("GMT+5:30");

		formatter.setTimeZone(obj);
		String strDate = formatter.format(currentdate.getTime());
		try {
			Date theResult = formatter.parse(strDate);
			GregorianCalendar theNewOne = new GregorianCalendar();
			theNewOne.setTimeZone(obj);
			theNewOne.setTime(theResult);
			return theNewOne;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GregorianCalendar theNewOne = new GregorianCalendar();
			theNewOne.setTimeZone(obj);
			theNewOne.setTime(currentdate.getTime());
			return theNewOne;
		}
	}

	/**
	 * This Method is used to compare due date and current date
	 * @return boolean
	 * Added on 31/07/2013 by Dhananjay
	 * */

	public static boolean getDueDate(){
		boolean isDueDate = false;
		String currentDate = getCurrentDateInIndiaAsString();
		String dueDate = "2013-08-05";
		if (currentDate.compareTo(dueDate)<0 || currentDate.compareTo(dueDate)==0){
			isDueDate = true;
		}
		return isDueDate;
	}

	public static void main(String[] args) {
		ITRXmlGeneratorServiceCommon c = new ITRXmlGeneratorServiceCommon();
		String theString = c.getCurrentDateInIndiaAsString();
		System.out.println(theString);
	}
}
