package com.mootly.wcm.annotations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.bind.Validator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.FloatValidator;
import org.apache.commons.validator.routines.LongValidator;

public  final class DataTypeValidationHelper {

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

		case CHALLANNO:
			if (inStr != null && inStr.matches("^[0-9]{5}")) {
				return true;
			}
			else {
				return false;
			}
		case MAXLENGTH:
			if (inStr != null && inStr.matches("^[0-9]{14}")) {
				return true;
			}
			else {
				return false;
			}
		case TDSCERTIFICATE:
			if (inStr != null && inStr.matches("^[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]")) {
				return true;
			}
			else {
				return false;
			}
		case DECIMAL:
			if (inStr != null && inStr.matches("^[0-9]+\\.?[0-9]{0,2}?$")) {
				return true;
			}
			else {
				return false;
			}
		case ITR:
			if (inStr.matches("-select-")) {
				return false;
			}
			else {
				return true;
			}
		case EMPTYSTRING:
			if (inStr == null || StringUtils.isEmpty(inStr)) {
				return true;
			}
			else {
				return false;
			}
		case PERCENTAGE:			
			return true;
		}
		return true;
	}

	final static  public boolean isOfTypeIndianDate(String inStr) {
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		try {
			df.parse(inStr);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
