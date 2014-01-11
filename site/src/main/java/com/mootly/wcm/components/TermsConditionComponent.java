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
public class TermsConditionComponent extends ITReturnComponent {

	public static final Logger log = LoggerFactory.getLogger(TermsConditionComponent.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean tcContentBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		if(tcContentBean == null){
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			log.warn("Scope bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
					resolvedSiteMapItem.getHstSiteMapItem().getId(),
					resolvedSiteMapItem.getRelativeContentPath());
			return;
		}
		String relativeTCcontentPath = request.getRequestContext().getResolvedSiteMapItem().getRelativeContentPath();
		HippoBean termsConditionDoc = tcContentBean.getBean(relativeTCcontentPath);
		request.setAttribute("termsConditionDoc", termsConditionDoc);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
