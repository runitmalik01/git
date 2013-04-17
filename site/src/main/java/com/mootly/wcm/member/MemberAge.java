package com.mootly.wcm.member;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MemberAge {

	private static final Logger log = LoggerFactory.getLogger(MemberAge.class);

	@SuppressWarnings("deprecation")
	public static int MemberAgeCalculate(Calendar dob){
		int age = 0;
		try {
			Date currDate =new Date();
			int year=currDate.getYear()+1900;
			String currentDate="31-03-"+String.valueOf(year);
			Calendar cal2 = new GregorianCalendar();
			int factor = 0; 
			Date date2 = new SimpleDateFormat("MM-dd-yyyy").parse(currentDate);
			cal2.setTime(date2);
			if(cal2.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
				factor = -1; 
			}
			age = cal2.get(Calendar.YEAR) - dob.get(Calendar.YEAR) + factor;		

		} catch (ParseException e) {
			log.error("Error by Date Parser"+e);
		}
		return age;
	}
	@SuppressWarnings("deprecation")
	public static int getAge(Calendar birthDate) {
		int age = 0;
		try {       
			Calendar today = Calendar.getInstance();

			Date currDate =new Date();

			int year=currDate.getYear()+1900;
			String currentDate="31-03-"+String.valueOf(year);

			Date date2 = new SimpleDateFormat("MM-dd-yyyy").parse(currentDate);

			if (birthDate.after(today)) {
				throw new IllegalArgumentException("Can't be born in the future");
			}
			today.setTime(date2);
			age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

			// If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
			if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
					(birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
				age--;

				// If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
			}else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
					(birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
				age--;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return age;
	}
}
