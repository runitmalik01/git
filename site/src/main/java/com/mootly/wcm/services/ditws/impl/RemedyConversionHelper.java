package com.mootly.wcm.services.ditws.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class RemedyConversionHelper {
	public static long remedyDateToLong(String remedyDate) {		
		String remedyDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //2011-10-05T21:49:34Z
		try {
			return new SimpleDateFormat(remedyDatePattern).parse(remedyDate).getTime();
		}catch (Exception ex) {
			return new Date().getTime();
		}
	}
}
