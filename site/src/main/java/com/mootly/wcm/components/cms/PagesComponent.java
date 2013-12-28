/**
 * 
 */
package com.mootly.wcm.components.cms;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.cms.PageDocument;
import com.mootly.wcm.beans.cms.compound.PageRowDetail;
import com.mootly.wcm.components.WebSiteBuilderComponent;

/**
 * @author admin
 *
 */
@PrimaryBean(primaryBeanClass=PageDocument.class)
@ChildBean(childBeanClass=PageRowDetail.class)
@FormFields(fieldNames={"blockDocCanonicalUUIDs"})
public class PagesComponent extends WebSiteBuilderComponent{
	
	public static final Logger log = LoggerFactory.getLogger(PagesComponent.class);
	
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
	}
}
