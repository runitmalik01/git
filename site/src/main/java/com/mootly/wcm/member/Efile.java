package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.components.ITReturnComponent;

/**
 * eFile Tax on behalf of ERI Sub User
 * @author admin
 *
 */
public class Efile extends ITReturnComponent {
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//plan is to do all in DO ACTION instead of doRender but any ways lets isolate the entire logic in a separate method
		
	}
	
	protected void eFileITR(HstRequest request, HstResponse response) {
		
	}
	
}
