/**
 * 
 */
package com.mootly.wcm.components;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 *
 */
public class PrivacyPolicyComponent extends ITReturnComponent {
	
	public static final Logger log = LoggerFactory.getLogger(PrivacyPolicyComponent.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean ppContentBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		
		if(ppContentBean == null){
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			log.warn("Scope bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
					resolvedSiteMapItem.getHstSiteMapItem().getId(),
					resolvedSiteMapItem.getRelativeContentPath());
			return;
		}
		if(ppContentBean!=null){
			String relativePPcontentPath = request.getRequestContext().getResolvedSiteMapItem().getRelativeContentPath();
			HippoBean privacyPolicyDoc = ppContentBean.getBean(relativePPcontentPath);
			request.setAttribute("privacyPolicyDoc", privacyPolicyDoc);
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
