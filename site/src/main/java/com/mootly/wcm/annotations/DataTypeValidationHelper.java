package com.mootly.wcm.annotations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public  final class DataTypeValidationHelper {
	public static enum DataTypeValidationType {DECIMAL,INDIANDATE,ITRETURNTYPE,PAN,TAN,BSR,Maxlength}
	final static public boolean isOfType(String inStr,DataTypeValidationType inType) {
		switch (inType) {
			case INDIANDATE:
				if (inType.equals(DataTypeValidationType.INDIANDATE)) {
					return isOfTypeIndianDate(inStr);
				}
			case ITRETURNTYPE:
				if (inStr == null || (!inStr.equals("original") && !inStr.equals("revised"))) {
					return false;
				}
				else {
					return true;
				}
			case PAN:
				if (inStr != null && inStr.matches("^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}")) {
					return true;
				}
				else {
					return false;
				}

			case TAN:
				if (inStr != null && inStr.matches("^([a-zA-Z]){4}([0-9]){5}([a-zA-Z]){1}")) {
					return true;
				}
				else {
					return false;
				}

			case BSR:
				if (inStr != null && inStr.matches("^[0-9]{7}")) {
					return true;
				}
				else {
					return false;
				}
			case Maxlength:
				if (inStr != null && inStr.matches("^[0-9]{14}")) {
					return true;
				}
				else {
					return false;
				}
		}
			
		return true;
	}
	
	final static  public boolean isOfTypeIndianDate(String inStr) {
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		try {
			df.parse(inStr);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
