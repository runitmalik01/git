/**
 * 
 */
package com.mootly.wcm.member.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.IndianGregorianCalendar;

/**
 * @author admin
 *
 */
public class ServiceRequestManager {
	
	public static final Logger log = LoggerFactory.getLogger(ServiceRequestManager.class);
	
	HstRequest request;
	
	public ServiceRequestManager(HstRequest request) {
		// TODO Auto-generated constructor stub
		this.request = request;
	}

	protected Boolean CanServiceRequestFullfill(){
		Boolean canServiceRequestFullfill = true;
		Service service = (Service) request.getRequestContext().getAttribute("document");
		Long serviceLeadTime = service.getServiceLeadTime(); 
		MemberPersonalInformation pi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(pi != null) {
			String stateCode = pi.getState();
			ITRForm itrForm = pi.getSelectedITRForm();
			GregorianCalendar filingDate = IndianGregorianCalendar.getCurrentDateInIndiaAsDate();
			String strfy = pi.getFinancialYear();
			FinancialYear fy = FinancialYear.getByDisplayName(strfy);
			filingDate.add(Calendar.DAY_OF_MONTH, serviceLeadTime.intValue());
			canServiceRequestFullfill = fy.isPastDue(itrForm, filingDate, stateCode);
		}
		return canServiceRequestFullfill;
	} 
}
