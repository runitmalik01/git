/**
 * 
 */
package com.mootly.wcm.components.cms;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.cms.EventLogDocument;
import com.mootly.wcm.components.ITReturnComponent;

/**
 * @author admin
 *
 */
public class DashboardComponent extends ITReturnComponent{
	
	public static final Logger log = LoggerFactory.getLogger(DashboardComponent.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean resellerHippoBeanScope = getSiteContentBaseBeanForReseller(request);
		if(resellerHippoBeanScope != null) {
			HippoBean eventLogBean = resellerHippoBeanScope.getBean("admin/log");
			if(eventLogBean != null) {
				if(log.isInfoEnabled()) {
					log.info("Have the log information document");
				}
				if(eventLogBean instanceof HippoFolder){
					HippoFolder eventLogFolder = (HippoFolder) eventLogBean;
					request.setAttribute("eventLogDocument", eventLogFolder.getDocuments(EventLogDocument.class));
				}				
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
