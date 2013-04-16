
/**
 * used for creating and updating  interest document from repository 
 * @author Dhananjay
 * 30/03/2013
 */

package com.mootly.wcm.member;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.InterestDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

public class Interest extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Interest.class);
	public static final String SECTION234A= "section234A";
	public static final String SECTION234B="section234B";
	public static final String SECTION234C = "section234C";

	@SuppressWarnings("deprecation")
	@Override

	/**
	 * 
	 * This method is used to calculate interest according to section234a,section234b,section234c
	 * @param request HstRequest,HstResponse 
	 * @author Dhananjay
	 * 
	 */
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

		request.setAttribute(SECTION234A, request.getParameterValues(SECTION234A));
		request.setAttribute(SECTION234B, request.getParameterValues(SECTION234B));
		request.setAttribute(SECTION234C, request.getParameterValues(SECTION234C));

	}

	/**
	 * 
	 * This method is used to set values of section234a,section234b,section234c
	 * @param request HstRequest   
	 * @author Dhananjay
	 * 
	 */
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		super.doAction(request, response);

		String section234A=GoGreenUtil.getEscapedParameter(request, "section234A");
		String section234B=GoGreenUtil.getEscapedParameter(request, "section234B");
		String section234C=GoGreenUtil.getEscapedParameter(request, "section234C");

		InterestDocument in= new InterestDocument();

		in.setSection234A(section234A);
		in.setSection234B(section234B);
		in.setSection234C(section234C);

		createInterestUpdateform(request,in);

		try {
			response.sendRedirect(UrlUtility.Tcs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * This method is used to create interest document and to  update interest document
	 * from Repository for existing user
	 * @param request HstRequest   
	 * @author Dhananjay
	 * 
	 */
	private InterestDocument createInterestUpdateform(HstRequest request, InterestDocument in) {

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			//getting values of pan,filing year,username from session
			String filing_year=(String) request.getSession().getAttribute("filing_year");
			String username=(String) request.getSession().getAttribute("username");
			String pan=(String) request.getSession().getAttribute("pan");

			//Method to create the interest Document 
			final String itreturnFolderPath = ContentStructure.getinterestdocumentpath(pan,filing_year,username);

			String updateitReturnPath=ContentStructure.getinterestdocumentfetch(pan,filing_year,username);

			//Method to fetch the interest Document values 
			InterestDocument updateinterest = (InterestDocument) wpm.getObject(updateitReturnPath);
			if(updateinterest==null){

				final String itReturnPath = wpm.createAndReturn(itreturnFolderPath, InterestDocument.NAMESPACE ,  InterestDocument.NODE_NAME, true);

				InterestDocument interestdocument= (InterestDocument) wpm.getObject(itReturnPath);
				// update content properties
				if (interestdocument != null) {
					interestdocument.setSection234A(in.getSection234A());
					interestdocument.setSection234B(in.getSection234B());
					interestdocument.setSection234C(in.getSection234C());
					// update now           `
					wpm.update(interestdocument);
					return interestdocument;
				}
				else {
					log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", InterestDocument.NODE_NAME, itReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return interestdocument;
				}
			}
			else{
				updateinterest.setSection234A(in.getSection234A());
				updateinterest.setSection234B(in.getSection234B());
				updateinterest.setSection234C(in.getSection234C());

				wpm.update(updateinterest);

				return updateinterest;

			}
		}
		catch (Exception e) {
			log.warn("Failed to signup member ", e);
			return null;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}

	}

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {

		super.doBeforeServeResource(request, response);
	}
	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}






