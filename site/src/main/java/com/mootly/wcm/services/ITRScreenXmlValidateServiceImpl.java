/**
 * 
 */
package com.mootly.wcm.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRXmlValidation;

/**
 * @author admin
 *
 */
public class ITRScreenXmlValidateServiceImpl implements ITRScreenXmlValidateService {

	public static final Logger logger = LoggerFactory.getLogger(ITRScreenXmlValidateServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.mootly.wcm.services.ITRScreenXmlValidateService#getValidateXmlBasedOnReqScreen(org.hippoecm.hst.core.component.HstRequest, org.hippoecm.hst.core.component.HstResponse)
	 */
	@Override
	public void getValidateXmlBasedOnReqScreen(HstRequest request,
			HstResponse response) {
		// TODO Auto-generated method stub
		List<ITRXmlValidation> listOfITRXmlValidate = new ArrayList<ITRXmlValidation>();
		listOfITRXmlValidate = ITRXmlValidation.getListOfXmlValidation();
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		try {
			if(memberPersonalInformation != null){
				HippoFolder parentFolder = (HippoFolder) memberPersonalInformation.getParentBean();
				ITRForm selectedITRForm = memberPersonalInformation.getSelectedITRForm();
				String strFinancialYear = memberPersonalInformation.getFinancialYear();
				String pan = memberPersonalInformation.getPAN().toLowerCase();
				if(logger.isInfoEnabled()){
					logger.info("Parent Folder Bean::"+parentFolder.getName());
				}
				if(!listOfITRXmlValidate.isEmpty() && listOfITRXmlValidate != null){
					for(ITRXmlValidation itrXmlValidation:listOfITRXmlValidate){
						if(itrXmlValidation.getItrForms().length > 0){
							for(ITRForm itrForm:itrXmlValidation.getItrForms()){
								ITReturnComponentHelper iTReturnComponentHelper = new ITReturnComponentHelper();
								FinancialYear financialYear = iTReturnComponentHelper.getFinancialYear(strFinancialYear, request, response);
								String folderContainsITReturnDocuments = iTReturnComponentHelper.getTheFolderContainingITRDocuments(request, response);
								String siteMapReferenceId = itrXmlValidation.getScreenSiteMapRefID();
								ITReturnComponent itReturnComponent = new ITReturnComponent();
								String redirectURLForSiteMapItem = itReturnComponent.getRedirectURLForSiteMapItem(request, response, null, siteMapReferenceId, financialYear, folderContainsITReturnDocuments, pan);
								if(logger.isInfoEnabled()){
									logger.info("Redirect Url to Screen ::"+redirectURLForSiteMapItem);
								}
								if(itrForm.equals(selectedITRForm)){
									switch(itrXmlValidation){
									case VALIDATE1:
										if("Y".equals(memberPersonalInformation.getPortugesecivil())){
											if(getValidateType(itrXmlValidation, parentFolder, 0)){
												if(redirectURLForSiteMapItem != null){
													response.setRenderParameter("itr.require.screen.srreq", "itr.require.screen.srreq");
													response.sendRedirect(redirectURLForSiteMapItem);
												}
											}
										}
										break;
									case VALIDATE2:
										if(getValidateType(itrXmlValidation, parentFolder, 0)){
											if(redirectURLForSiteMapItem != null){
												response.setRenderParameter("itr.require.screen", "itr.require.screen");
												response.sendRedirect(redirectURLForSiteMapItem);
											}
										}
										break;
									case VALIDATE3:
										if(getValidateType(itrXmlValidation, parentFolder, 1)){
											if(redirectURLForSiteMapItem != null){
												response.setRenderParameter("itr.require.screen", "itr.require.screen");
												response.sendRedirect(redirectURLForSiteMapItem);
											}
										}
										break;
									default:
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method will Validate that Screen has been Reviewed by User or not .<br/>
	 * We will check for Document for that particular Screen If Found the return false otherwise return true.
	 * 
	 * @param VALIDATE {@link ITRXmlValidation}
	 * @param parentFolder {@link HippoFolder}
	 * @param checkNoOfChild {@link Integer}
	 * 
	 * @return {@link Boolean}
	 * **/
	@Override
	public boolean getValidateType(ITRXmlValidation VALIDATE,
			HippoFolder parentFolder,int checkNoOfChild) {
		// TODO Auto-generated method stub
		boolean invalid = true;
		for(HippoDocumentBean documentBean:parentFolder.getDocuments()){
			if(documentBean.getName().equalsIgnoreCase(VALIDATE.getDocumentName())){
				invalid = false;
				if(checkNoOfChild > 0){
					try {
						NodeIterator nodeIterator = documentBean.getNode().getNodes();
						if(!(nodeIterator.getSize() > 1)){ //HippoTranslation Bean will be present. 
							if(logger.isInfoEnabled()){
								logger.info("Lets see Number of Nodes::"+nodeIterator.getSize());
							}
							invalid = true;
						}
					} catch (RepositoryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return invalid;
	}
}
