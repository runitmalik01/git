package com.mootly.wcm.member;

import java.util.GregorianCalendar;

import com.mootly.wcm.model.IndianGregorianCalendar;

public class TestChapter6 {
	
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		
		GregorianCalendar gcByTimeZone = new GregorianCalendar(IndianGregorianCalendar.indianTimeZone);
		
		System.out.println(gc);
		System.out.println(gcByTimeZone);
		//System.out.println(IndianGregorianCalendar.indianInstance);
		//screenCalculatorService.getScreenCalculations("Chapter6Calc.js", requestParameterMap, additionalBindings)
	}
}
