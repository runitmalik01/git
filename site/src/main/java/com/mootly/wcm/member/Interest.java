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
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.ContentStructure;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
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

	Member member = null;
	String financialYear = null;
	String modusername= null;
	String pan = null;
	Session persistableSession = null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

		member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		modusername=username.replaceAll("@", "-at-").trim();
		financialYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		//itReturnType = request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType"); //original versus amend
		pan = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); //original versus amend

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

		log.info("inside fetchSalaryIncomeDocument--->member:-"+member);
		log.info("inside fetchSalaryIncomeDocument--->member:-"+financialYear);
		log.info("inside fetchSalaryIncomeDocument--->member:-"+pan);

		if(member!=null){
			double dtotalamount=0.0d;
			double dsum1=0.0d;
			double dsum2=0.0d;
			double dsum3=0.0d;
			double dsum4=0.0d;
			double dsum12=0.0d;

			log.info("inside fetchtcsDocument--->before try:-");
			try {

				String path=ContentStructure.getAdvanceTaxcPath(pan,financialYear, modusername);
				log.info("advance tax path--------------------------------------------"+path);
				AdvanceTaxDocument advancetaxdocument =(AdvanceTaxDocument)getObjectBeanManager(request).getObject(path);
				log.info("bean objectttttttttt---------------"+advancetaxdocument);
				request.setAttribute("advancetaxdocument", advancetaxdocument);
				if(advancetaxdocument!= null){
					log.info("inside if-----------------------------------------");
					dtotalamount = advancetaxdocument.getTotal_Amount();
					dsum1=advancetaxdocument.getTotal_Sum1();
					dsum2=advancetaxdocument.getTotal_Sum2();
					dsum3=advancetaxdocument.getTotal_Sum3();
					dsum4=advancetaxdocument.getTotal_Sum4();
					dsum12=dsum1+dsum2;

					log.warn("total amount object is"+advancetaxdocument.getTotal_Amount());
					log.info("total amount is  isssssssss"+dtotalamount);
					request.setAttribute("totaltax", dtotalamount);
					request.setAttribute("dsum12",dsum12);
					request.setAttribute("dsum3",dsum3);
					request.setAttribute("dsum4",dsum4);
				}else{
					log.info("inside else---------------------------------------------");
					request.setAttribute("totaltax", "0");
					request.setAttribute("dsum12","0");
					request.setAttribute("dsum3","0");
					request.setAttribute("dsum4","0");
				}

			}catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
