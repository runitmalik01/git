/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.jcr.Session;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PrimaryBean(primaryBeanClass=InterestDoc.class)
@AdditionalBeans(additionalBeansToLoad=MemberPersonalInformation.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"section234A","section234B","section234C","section234ABC"})

public class Interest extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Interest.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		
		//current date
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		final Date currentdate=cal.getTime();
		//conversion of date into string
		String strDate=new Date().toString();
		//current month
		@SuppressWarnings("deprecation")
		int currentdatemonth =currentdate.getMonth()+1;
	    request.setAttribute("intmonth", currentdatemonth);
	    //conversion of month into string
	    String strmonth=strDate.substring(4,7);
	    request.setAttribute("strmonth", strmonth);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
