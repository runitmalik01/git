/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.components.vendor;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.ITReturnComponent;

public class BulkXMLDownload extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(BulkXMLDownload.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);			
		
		
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		super.doAction(request, response);
	}

	
}
