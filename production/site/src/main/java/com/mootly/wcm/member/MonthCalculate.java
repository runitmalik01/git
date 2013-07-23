package com.mootly.wcm.member;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class MonthCalculate {
  /* public static void main(String[] args) {
        //creation of calendar object to call the method
        //new GregorianCalendar(yyyy, mm, dd) here month 0 is for January
	  // String date1= "01/02/2012";
	  // String date2= "01/02/2013";
	   //SimpleDateFormat sdf = new SimpleDateFormat(date1);
	   Calendar calendarDate = Calendar.getInstance();

	   // strdate = sdf.format(calendarDate.getTime());
        Calendar date1 = new GregorianCalendar(2012,0,1);
        Calendar date2 = new GregorianCalendar(2013,1,22);
        double monthsBetween = monthsBetween(date1, date2);
        System.out.println("Number of months between two date is "+monthsBetween);
        System.out.println("Number of months between two date is "+(int)monthsBetween);
   }*/
    public static double monthsBetween(Calendar date1, Calendar date2 ){
        double monthsBetween = 0;
        //difference in month for years
        monthsBetween = (date1.get(Calendar.YEAR)-date2.get(Calendar.YEAR))*12;
        //difference in month for months
        monthsBetween += date1.get(Calendar.MONTH)-date2.get(Calendar.MONTH);
        //difference in month for days
        if(date1.get(Calendar.DAY_OF_MONTH)!=date1.getActualMaximum(Calendar.DAY_OF_MONTH)
                && date1.get(Calendar.DAY_OF_MONTH)!=date1.getActualMaximum(Calendar.DAY_OF_MONTH) ){
            monthsBetween += ((date1.get(Calendar.DAY_OF_MONTH)-date2.get(Calendar.DAY_OF_MONTH))/31d);
        }
        return monthsBetween;
    }
   

   }


