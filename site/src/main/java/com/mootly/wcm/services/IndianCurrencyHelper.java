package com.mootly.wcm.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	 * @author Dhananjay
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
	 * @author Dhananjay
	 * */
	public Long longRound(Double in){
		BigDecimal bd = new BigDecimal(in).setScale(0, RoundingMode.HALF_EVEN);
		return bd.longValue();
	}

	/**
	 * This Method is used to convert String into BigIngteger
	 * @return BigInteger
	 * @param String
	 * @author Dhananjay
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
	 * @author Dhananjay
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
	 * @author Dhananjay
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
	 * Added on 17-08-2013
	 * @author Dhananjay
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

	public double getYearIndexValue(String Calldate) throws ParseException{
		ResourceBundle rb = ResourceBundle.getBundle("valueList_Infla" +
				"tionIndex");
		String expDate= Calldate;
		Date dNew= parsedate(Calldate);
		String[] getDate= expDate.split("/");
		String  year= getDate[2];
		if(rb.containsKey("valueList."+year)){
			log.info("it contains");
			String[] newString=rb.getString("valueList."+year+"").split("-");
			String fromDate=newString[0];
			Date frm= parsedate(fromDate);
			String toDate=newString[1];
			Date to= parsedate(toDate);
			boolean comapreResult= between(dNew, frm, to);
			if(comapreResult){
				log.info("success");
				return Double.parseDouble(rb.getString("valueList."+year+".cii"));
			}if(!comapreResult) {
				double year1= Double.parseDouble(year);
				double yearnew = (year1-1.0d);
				 int ss = (int)yearnew;
				return Double.parseDouble(rb.getString("valueList."+ss+".cii"));
			}	
		}
		log.info("here is the value in outer loopsss"+Double.parseDouble(rb.getString("valueList.2012.cii")));
		return Double.parseDouble(rb.getString("valueList.2012.cii"));
	}


	

	/**
	 * this method for converting a string to Date

	@param string date,
	@author abhishek
	 * @return  Date
	 * @throws ParseException 

	 **/
	public static Date parsedate(String dateparse)throws ParseException{
		DateFormat formatter ; 
		@SuppressWarnings("unused")
		Date date ; 
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		log.info("changed date is"+formatter.parse(dateparse));
		return date = formatter.parse(dateparse);

	}

	/**
	 * this method for checking whether date lies between two dates, or not

	@param current date, from Date and to Date
	@author abhishek
    @return

	 **/
	public static boolean between(Date date, Date dateStart, Date dateEnd) {
		if (date != null && dateStart != null && dateEnd != null) {
			if ((date.after(dateStart)||date.equals(dateStart)) && (date.before(dateEnd)||date.equals(dateEnd))) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	
	
	
/*	public int IsDateBetween(String dd, String Ndate, String Odate) {
		log.info("inside case"+dd);
		long from=Date.parse(Ndate);  // From some date
		log.info("from"+from);
		long to=Date.parse(Odate);     // To Some Date
		log.info("to"+to);
		long check=Date.parse(dd);
		log.info("now"+check);
		int x=0;
		//c <= e && c >= s))
		if((check-from)>=0 && (to-check)>=0)

		{
			x=1;
			return x;
		}
		return 0;

	}  

	//try to send default value so that no NullPointer Exception
	public double getYearIndexValue(String year){
		ResourceBundle rb = ResourceBundle.getBundle("valueList_Infla" +
				"tionIndex");
		if(rb.containsKey("valueList."+year+".cii")){
			log.info("it contains");
			return Double.parseDouble(rb.getString("valueList."+year+".cii"));
		}
		return Double.parseDouble(rb.getString("valueList.1990.cii"));//try to send default value so that no NullPointer Exception
	}*/

	/**
	 * This Method is used to round off to its nearest tenth
	 * @return Double
	 * @param Double
	 * Added on 27-08-2013
	 * @author Dhananjay
	 * */

	public long roundOffNearestTenth(long in){

		if(in < 0){
			in = in * (-1);
			long roundedValue = in%10 >= 5 ? ((in/10)*10)+10 : (in/10)*10;
			return roundedValue*(-1);
		}else if(in > 0){
			long roundedValue = in%10 >= 5 ? ((in/10)*10)+10 : (in/10)*10;
			return roundedValue;
		}else
			return 0;

	}

}
