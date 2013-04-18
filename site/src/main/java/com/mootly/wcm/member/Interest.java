/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.InterestDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=InterestDocument.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"section234A","section234B","section234C"})
public class Interest extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(Interest.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		

		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		// calculation for Section234a

		//getting Current Date
		final Date currentdate=cal.getTime();
		System.out.println("currentdateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+currentdate);

		//setting harcoded value of Due Date i.e 31-July-2013
		cal.set(Calendar.YEAR, 2013);
		cal.set(Calendar.MONTH, 06);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		final Date duedate = cal.getTime();
		System.out.println("enddateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+duedate);

		//calculating difference between current and due date in months
		int currentdatemonth = currentdate.getYear()* 12 + currentdate.getMonth();
		int duedatemonth = duedate.getYear() * 12 + duedate.getMonth();
		int monthdiff= currentdatemonth - duedatemonth;
		System.out.println("monthdifferenceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+monthdiff);
        
		if(monthdiff>0){
		//calculating interest according to section 234a
		int incometaxpayble=100000;
		int interest234=incometaxpayble*monthdiff;
		int interest234a=interest234/100;
		System.out.println("interesttttttttttttttttttttttttttttttttttt"+interest234a);

		request.setAttribute("section234a", interest234a);
		}else{
			request.setAttribute("section234a", "0");
		}
			
		// Calculation for Section234b

		//Setting hardcoded value of financial date i.e 01-April-2012			
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, 03);
		cal.set(Calendar.DAY_OF_MONTH, 01);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		final Date financialdate = cal.getTime();
		System.out.println("financialdateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+financialdate);

		//Setting hardcoded value of first advance tax payment date i.e 15-September-2012            
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		final Date advancedate = cal.getTime();
		System.out.println("advancedateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+advancedate);
		int amount=75000;

		//calculating difference between financial date and date of first advance tax payment in months         
		int financialdatemonth = financialdate.getYear()* 12 + financialdate.getMonth();
		int advancedatemonth = advancedate.getYear() * 12 + advancedate.getMonth();
		int monthdiff1= advancedatemonth - financialdatemonth;
		System.out.println("monthdifferenceeeeeeeeeeeeeeeeeeeeedelay1------------------------"+monthdiff1);

		// Hardcoded value of taxableincome,tds and advancetax
		int taxableincome=300000;
		int tds=50000;
		int advancetax=135000;

		//calculating interest according to section 234b
		int assessedtax=taxableincome-tds;
		int assessedtaxper=assessedtax*90;
		int ninteyassessed=assessedtaxper/100;

		if(advancetax < ninteyassessed){
			int shortfall=assessedtax-advancetax;
			int interest2344=shortfall*monthdiff1;
			int interest234b=interest2344/100;
			System.out.println("interset234bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+interest234b);
			request.setAttribute("section234b", interest234b);
		}else{
			request.setAttribute("section234b", "0");
		}

		// Calculation for Section234c

		//Setting hardcoded value of second advance tax payment date i.e 12-December-2012            
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 12);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		final Date advancedate1 = cal.getTime();
		System.out.println("advancedateeeeeeeeeeeeeeeee111111111111111-----------------------------"+advancedate1);
		int amount1=125000;

		//Setting haedcoded value of third advance tax payment date i.e 15-March-2013            
		cal.set(Calendar.YEAR, 2013);
		cal.set(Calendar.MONTH, 02);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		final Date advancedate2 = cal.getTime();
		System.out.println("advancedateeeeeeeeeeeeeeee22222222222222222222----------------------"+advancedate2);
		int amount2=200000;

		// calculating interest according to section234c
		int assessedtax1=assessedtax*30;
		int amountpayable=assessedtax1/100;
		int difference=amountpayable-amount;
		int interestcharged=difference*3;
		int interestcharged1=interestcharged/100;

		int assessedtax2=assessedtax*60;
		int amountpayable1=assessedtax2/100;
		int difference1=amountpayable1-amount1;
		int interestcharged2=difference1*3;
		int interestcharged3=interestcharged2/100;

		int assessedtax3=assessedtax*100;
		int amountpayable2=assessedtax3/100;
		int difference2=amountpayable2-amount2;
		int interestcharged4=difference2*1;
		int interestcharged5=interestcharged4/100;

		int interest234c=interestcharged1+interestcharged3+interestcharged5;
		System.out.println("section234ccccccccccccccccccccccccccccc"+interest234c);

		request.setAttribute("section234c", interest234c);

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
