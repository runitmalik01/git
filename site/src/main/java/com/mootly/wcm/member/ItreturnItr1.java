package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRTab;
import com.mootly.wcm.view.ITR1SummaryPage;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * 
 */

public class ItreturnItr1 extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of ItreturnItr1");
		}
		String Tab=getPublicRequestParameter(request, "tab");
		if(Tab!=null){
			request.setAttribute("Tab", Tab);
		}else {
			request.setAttribute("Tab","summary");
		}
		
		if (request.getAttribute("selectedItrTab") == null) {
			request.setAttribute("selectedItrTab", ITRTab.ITR1SUMMARY);
		}
		ITR1SummaryPage itr1Summary = new ITR1SummaryPage();
		request.setAttribute("view", itr1Summary);
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of ItreturnItr1");
		}
		
	} 

}




