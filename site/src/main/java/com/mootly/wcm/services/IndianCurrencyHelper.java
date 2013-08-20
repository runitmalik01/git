package com.mootly.wcm.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;

public final class IndianCurrencyHelper {

	private static Logger log = LoggerFactory.getLogger(IndianCurrencyHelper.class);

	/**
	 * This Method is used to Round the Decimal Values and convert it into BigIngteger
	 * @return BigInteger
	 * @param double
	 *
	 * */
	public BigInteger bigIntegerRound(Double in) {
		if(in!=null){
			BigDecimal bd = new BigDecimal(in).setScale(0, RoundingMode.HALF_EVEN);
			DecimalFormat decimalFormat=new DecimalFormat("#.#");
			BigInteger bigTotal=null;
			if(bd!=null && bd.toString().length()>0){
				bigTotal = new BigInteger(decimalFormat.format(bd));
				return bigTotal;
			}else
				return null;
		}else
			return null;
	}

	/**
	 * This Method is used to Round the Decimal Values Upto
	 * two decimal places
	 *
	 * @return double
	 * @param double
	 *
	 * ****/

	public double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	/**
	 * This Method is used to Round the Decimal Values and convert it into Long
	 * @return Long
	 * @param double
	 *
	 * */
	public Long longRound(Double in){
		BigDecimal bd = new BigDecimal(in).setScale(0, RoundingMode.HALF_EVEN);
		return bd.longValue();
	}

	/**
	 * This Method is used to convert String into BigIngteger
	 * @return BigInteger
	 * @param String
	 *
	 * */
	public BigInteger bigIntegerRoundStr(String in){

		BigInteger bigStr=null;
		if(in!=null && in.length()>0){
			bigStr = new BigInteger(in);
			return bigStr;
		}else
			return null;
	}

	/**
	 * This Method is used to convert long into BigInteger
	 * @return BigInteger
	 * @param Long
	 *
	 * */

	public BigInteger longToBigInteger(long in){

		BigInteger bigStr=null;
		if(in!=0 && in>0){
			bigStr = BigInteger.valueOf(in);
			return bigStr;
		}else if(in!=0 && in<0){
			in = in*(-1);
			bigStr = BigInteger.valueOf(in);
			return bigStr;
		}else
			if(in==0){
				bigStr = new BigInteger("0");
				return bigStr;
			}
		return null;
	}


	/**
	 * This Method is used to convert GregorianCalend into XMLGregorianCalendar
	 * @return GregorianCalendar
	 * @param Calendar
	 *
	 * */

	public XMLGregorianCalendar gregorianCalendar(GregorianCalendar val_Date){

		XMLGregorianCalendar date2=null;
		try {
			//date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dobStr);
			//date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(val_Date);
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(val_Date.get(Calendar.YEAR),val_Date.get(Calendar.MONTH)+1,val_Date.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
	}

	/**
	 * This Method is used to find difference between Assessment Years for Losses Calculation
	 * @return Financial Year, String
	 * @param Integer
	 * Added by Dhananjay on 17-08-2013
	 * */
	public int diffBtwAssessmentYear(FinancialYear financialYear,String AssessmentYear){

		String CurrAssessmentYear = financialYear.getDisplayAssessmentYear();
		String subStrCurrAssessmentYear = CurrAssessmentYear.substring(5,9);
		int intCurrAssessmentYear = Integer.parseInt(subStrCurrAssessmentYear);

		String subStrAssessmentYear = AssessmentYear.substring(5,9);
		int intAssessmentYear = Integer.parseInt(subStrAssessmentYear);

		int Difference = intCurrAssessmentYear - intAssessmentYear;

		return Difference;
	}

	/**
	 * This method is used to Round Off the value
	 *
	 * @param o {@link Object}
	 * @return
	 * */
	public Object roundOff(Object o){
		DecimalFormat df2 = new DecimalFormat("###");
		return df2.format(o);
	}
	public double getYearIndexValue(String year){
		ResourceBundle rb = ResourceBundle.getBundle("valueList_InflationIndex");
		if(rb.containsKey("valueList."+year+".cii")){
			log.info("it contains");
			return Double.parseDouble(rb.getString("valueList."+year+".cii"));
		}
		return Double.parseDouble(rb.getString("valueList.1990.cii"));//try to send default value so that no NullPointer Exception
	}
}
