/**
 * 
 */
package com.mootly.wcm.services;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRXmlValidation;
import com.mootly.wcm.model.ValidateProperty;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TI;

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
												//return redirectURLForSiteMapItem;
											}
										}
									}
									break;
								case VALIDATE2:
									if(getValidateType(itrXmlValidation, parentFolder, 0)){
										if(redirectURLForSiteMapItem != null){
											response.setRenderParameter("itr.require.screen", "itr.require.screen");
											response.sendRedirect(redirectURLForSiteMapItem);
											//return redirectURLForSiteMapItem;
										}
									}
									break;
								case VALIDATE3:
									if(getValidateType(itrXmlValidation, parentFolder, 1)){
										if(redirectURLForSiteMapItem != null){
											response.setRenderParameter("itr.require.screen", "itr.require.screen");
											response.sendRedirect(redirectURLForSiteMapItem);
											//return redirectURLForSiteMapItem;
										}
									}
									break;
								case VALIDATE4:
									if(getValidateType(itrXmlValidation, parentFolder)){
										if(redirectURLForSiteMapItem != null){
											response.setRenderParameter("itr.require.screen", "itr.require.screen");
											response.sendRedirect(redirectURLForSiteMapItem);
											//return redirectURLForSiteMapItem;
										}
									}else{
										if(getValidateWithTotalIncome(request, financialYear, itrXmlValidation, parentFolder)){
											if(redirectURLForSiteMapItem != null){
												response.setRenderParameter("itr.require.screen", "itr.require.screen");
												response.sendRedirect(redirectURLForSiteMapItem);
												//return redirectURLForSiteMapItem;
											}
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
		//return null;
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
	/**
	 * This method will Validate that Screen has been Reviewed by User or not .<br/>
	 * We will check for Document for that particular Screen If Found the return false otherwise return true.
	 * 
	 * @param VALIDATE {@link ITRXmlValidation}
	 * @param parentFolder {@link HippoFolder}
	 * 
	 * @return {@link Boolean}
	 * **/
	public boolean getValidateType(ITRXmlValidation VALIDATE,
			HippoFolder parentFolder) {
		// TODO Auto-generated method stub
		boolean invalid = true;//check for valid of xml is false
		boolean unCheckDoc = true;//no need to check document in parentBeanFolder
		if(VALIDATE.getValidateProperty().length > 0){
			for(HippoDocumentBean documentBean:parentFolder.getDocuments()){
				for(ValidateProperty propertyName: VALIDATE.getValidateProperty()){
					if(propertyName.getDocumentName().equalsIgnoreCase(documentBean.getName())){
						Object object = documentBean.getProperty(propertyName.getPropertyName());
						if(object != null){
							switch(propertyName.getValidateType()){
							case MAX_ALLOWED:
								unCheckDoc = getMaxPropertyValidate(object, propertyName);
								break;
							case MIN_ALLOWED:
								unCheckDoc = getMinPropertyValidate(object, propertyName);
								break;
							case EQUALITY:
								unCheckDoc = getEqualPropertyValidate(object, propertyName);
								break;
							default:
								break;
							}
						}
					} 
				}
			}
		}
		if(!unCheckDoc){
			for(HippoDocumentBean documentBean:parentFolder.getDocuments()){
				if(documentBean.getName().equalsIgnoreCase(VALIDATE.getDocumentName())){
					invalid = false;
				}
			}
			return invalid;
		}
		return false;
	}
	/**
	 * Validate the Object according to it's type {@link Double} or {@link Long} with Equality.
	 * 
	 * @param object {@link Object}
	 * @param propertyName {@link ValidateProperty}
	 * 
	 * @return {@link Boolean}
	 * **/
	public boolean getMaxPropertyValidate(Object object,ValidateProperty propertyName){
		boolean unCheckDoc = true;
		if(object instanceof Double){
			if(Double.parseDouble(object.toString()) > Double.parseDouble(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}
		if(object instanceof Long){
			if(Long.parseLong(object.toString()) > Long.parseLong(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}

		return unCheckDoc;
	}
	/**
	 * Validate the Object according to it's type {@link Double} or {@link Long} with Equality.
	 * 
	 * @param object {@link Object}
	 * @param propertyName {@link ValidateProperty}
	 * 
	 * @return {@link Boolean}
	 * **/
	public boolean getMinPropertyValidate(Object object,ValidateProperty propertyName){
		boolean unCheckDoc = true;
		if(object instanceof Double){
			if(Double.parseDouble(object.toString()) < Double.parseDouble(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}
		if(object instanceof Long){
			if(Long.parseLong(object.toString()) < Long.parseLong(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}

		return unCheckDoc;
	}
	/**
	 * Validate the Object according to it's type {@link Double} or {@link Long} or {@link String} or {@link Boolean} with Equality.
	 * 
	 * @param object {@link Object}
	 * @param propertyName {@link ValidateProperty}
	 * 
	 * @return {@link Boolean}
	 * **/
	public boolean getEqualPropertyValidate(Object object,ValidateProperty propertyName){
		boolean unCheckDoc = true;
		if(object instanceof Double){
			if(Double.parseDouble(object.toString()) == Double.parseDouble(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}
		if(object instanceof Long){
			if(Long.parseLong(object.toString()) == Long.parseLong(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}
		if(object instanceof String){
			if(object.toString().equalsIgnoreCase(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}
		if(object instanceof Boolean){
			if(object.toString().equalsIgnoreCase(propertyName.getValueToValidate())){
				unCheckDoc = false;
			}
		}
		return unCheckDoc;
	}

	public boolean getValidateWithTotalIncome(HstRequest request, FinancialYear financialYear, ITRXmlValidation VALIDATE, HippoFolder parentFolder){
		boolean inValid = true;
		DeductionDocument deductionDocument = (DeductionDocument) request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase());
		ITR itr = new ITR(); 
		Map<String, HippoBean> inputBeans = new HashMap<String, HippoBean>();
		inputBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(), (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()));
		inputBeans.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(), (OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(HouseProperty.class.getSimpleName().toLowerCase(), (HouseProperty)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()));
		inputBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(), (FormSixteenDocument)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(), (SalaryIncomeDocument)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase(), (IncBusinessProfessionDoc)request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase()));
		inputBeans.put(ProfitAndLossDocument.class.getSimpleName().toLowerCase(), (ProfitAndLossDocument)request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(OtherInformationDocument.class.getSimpleName().toLowerCase(), (OtherInformationDocument)request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(ScheduleDPMDocument.class.getSimpleName().toLowerCase(), (ScheduleDPMDocument)request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(ScheduleDOADocument.class.getSimpleName().toLowerCase(), (ScheduleDOADocument)request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(ScheduleESRDocument.class.getSimpleName().toLowerCase(), (ScheduleESRDocument)request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase(), (DeductionSchedTenADocumemt)request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase()));
		
		PartB_TI partB_TI = new PartB_TI((FormSixteenDocument)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()),
				(SalaryIncomeDocument)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()),
				(HouseProperty)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()),
				(OtherSourcesDocument)(OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()),
				deductionDocument, (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()),
				(ScheduleSIDocument)request.getAttribute(ScheduleSIDocument.class.getSimpleName().toLowerCase()), (CapitalAssetDocument)request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase()),
				(IncBusinessProfessionDoc)request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase()),(ProfitAndLossDocument)request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase()),
				(OtherInformationDocument)request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase()),(ScheduleDPMDocument)request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase()),
				(ScheduleDOADocument)request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase()),(ScheduleESRDocument)request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase()),
				(DeductionSchedTenADocumemt)request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase()),(IncomeFromFirmsDocument)request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase()));
		PartBTI partBTI = partB_TI.getPartBTI(itr, financialYear, inputBeans);
		Double totalIncome = partBTI.getTotalIncome().doubleValue();
		if(totalIncome > 2500000d){
			for(HippoDocumentBean documentBean:parentFolder.getDocuments()){
				if(documentBean.getName().equalsIgnoreCase(VALIDATE.getDocumentName())){
					inValid = false;
				}
			}
			return inValid;
		}
		return false;
	}
}
