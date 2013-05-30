/*
 * In this class we are getting values required for the calculation of interest
 * @author Dhananjay
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
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.ContentStructure;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PrimaryBean(primaryBeanClass=InterestDoc.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"intA","intB","ic","intt"})

public class Interest extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Interest.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());

		//current date
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		final Date currentdate=cal.getTime();
		//conversion of date into string
		String strDate=new Date().toString();
		//current month
		@SuppressWarnings("deprecation")
		int year=currentdate.getYear()+1900;

		if(year==2013){
			int currentdatemonth =currentdate.getMonth()+1;
			request.setAttribute("intmonth", currentdatemonth);
		}
		if(year==2014){
			int currentdatemonth =currentdate.getMonth()+1+12;
		}
		//conversion of month into string
		String strmonth=strDate.substring(4,7);
		request.setAttribute("strmonth", strmonth);

		double dtotalamount=0.0d;
		double dsum1=0.0d;
		double dsum2=0.0d;
		double dsum3=0.0d;
		double dsum4=0.0d;
		double dsum12=0.0d;

		if(advanceTaxDocument!= null){

			dtotalamount = advanceTaxDocument.getTotal_Amount();
			dsum1=advanceTaxDocument.getTotal_Sum1();
			dsum2=advanceTaxDocument.getTotal_Sum2();
			dsum3=advanceTaxDocument.getTotal_Sum3();
			dsum4=advanceTaxDocument.getTotal_Sum4();
			dsum12=dsum1+dsum2;

			request.setAttribute("totaltax", dtotalamount);
			request.setAttribute("dsum12",dsum12);
			request.setAttribute("dsum3",dsum3);
			request.setAttribute("dsum4",dsum4);
		}else{
			request.setAttribute("totaltax", "0");
			request.setAttribute("dsum12","0");
			request.setAttribute("dsum3","0");
			request.setAttribute("dsum4","0");
		}
		String TaxLiability = (String) request.getSession().getAttribute("TaxLiability");
		request.setAttribute("TaxLiability", TaxLiability);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
