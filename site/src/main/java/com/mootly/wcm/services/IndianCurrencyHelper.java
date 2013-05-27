package com.mootly.wcm.services;

import static com.mootly.wcm.utils.Constants.SERIAL;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class IndianCurrencyHelper {

	//method to convert double value into Biginteger
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



	// method to convert double value into Long
	public Long longRound(Double in){
		BigDecimal bd = new BigDecimal(in).setScale(0, RoundingMode.HALF_EVEN);
		return bd.longValue();
	}

	// method to convert String value into Biginteger
	public BigInteger bigIntegerRoundStr(String in){

		BigInteger bigStr=null;
		if(in!=null && in.length()>0){
			bigStr = new BigInteger(in);
			return bigStr;
		}else
			return null;
	}
	
	

}
