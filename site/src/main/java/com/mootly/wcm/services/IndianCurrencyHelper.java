package com.mootly.wcm.services;

import static com.mootly.wcm.utils.Constants.DATE;
import static com.mootly.wcm.utils.Constants.SERIAL;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public final class IndianCurrencyHelper {


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
	 * This Method is used to GregorianCalend into XMLGregorianCalendar
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

}
