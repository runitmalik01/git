package com.mootly.wcm.components.cms;

import java.util.List;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.SORT_DIRECTION;

public class WebsiteComponent extends ITReturnComponent {
	
	public static final Logger log = LoggerFactory.getLogger(WebsiteComponent.class);
	public static final String BASE_PATH_OF_PAGE_DOC = "cms/pages";
	public static final String BASE_PATH_OF_WEB_COMP = "cms";
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean hippoBeanScope = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		if(hippoBeanScope == null){
			if (log.isInfoEnabled()) {
				log.info("Scope of Bean for Reseller is { } null.Not able to fetch BeanScopes");
				return;
			}
		}
		List<HippoDocumentBean> documentsList = null; //new ArrayList<HippoDocumentBean>();
		documentsList = getITRInitData(request).loadAllBeansUnderTheFolder(request, BASE_PATH_OF_PAGE_DOC, null, SORT_DIRECTION.ASC);
		request.setAttribute("pageDocumentsList", documentsList);
		WebsiteInfo websiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
		request.setAttribute("resellerInfo", websiteInfo);
	}

}
