package com.mootly.wcm.components.itreturns;

import java.io.IOException;
import java.util.List;

import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.PackageSelectorDetails;
import com.mootly.wcm.components.FormSaveResult;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.exceptions.BeanTypeException;


@PrimaryBean(primaryBeanClass=PackageSelectorDetails.class)
@FormFields(fieldNames={"package","financialyear","filingstatus","pan"})
@RequiredFields(fieldNames={"package"})

public class PackageSelector extends ITReturnComponent{
	private static final Logger log = LoggerFactory.getLogger(PackageSelector.class);
	String publicParameterUUID = null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("This is pageselector page");
		}
		publicParameterUUID = getPublicRequestParameter(request, "uuid");
		if (publicParameterUUID != null) { 
			try {
				FormUtils.validateId(publicParameterUUID);
				//response.setRenderParameter("uuid", publicPar
				//response.sendRedirect(request.getRequestURL().toString());
				//return;
			}catch (IllegalArgumentException ie) {
				publicParameterUUID = null;
			}
		}
		request.setAttribute("selectionUUID", publicParameterUUID);
		//  From ServicePrice.java to make list for all packages..
		HippoBean bean = getContentBean(request);

		if (bean == null) {
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			log.warn("Cannot create document list: content bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
					resolvedSiteMapItem.getHstSiteMapItem().getId(),
					resolvedSiteMapItem.getRelativeContentPath());
			return;
		} else if (bean instanceof HippoFolderBean) {
			HippoFolderBean folder = (HippoFolderBean) bean;
			List<HippoDocumentBean> documents = folder.getDocuments();
			request.setAttribute("documents", documents);
		} else {
			throw new BeanTypeException("Cannot create document list: " + bean.getPath() + " is not a folder");
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if (log.isInfoEnabled()) {
			log.info("Entering Package Selector");
		}		
		String publicUUID = getPublicRequestParameter(request, "uuid");
		String returnURL = getRedirectURLForSiteMapItem(request, response, FormSaveResult.SUCCESS,"start-application", getITRInitData(request).getFinancialYear(),getITRInitData(request).getTheFolderContainingITRDocuments(), getITRInitData(request).getPAN());
		if (publicUUID != null) {
			try {
				FormUtils.validateId(publicUUID);
				returnURL +="?uuid=" +publicUUID;
				request.getSession().setAttribute("uuid",publicUUID);
				if(log.isInfoEnabled()){
					log.info("setted value in session");
				}
			}catch (IllegalArgumentException ie) {

			}
		} 
		try {
			response.sendRedirect(response.encodeURL(returnURL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} 
} 
