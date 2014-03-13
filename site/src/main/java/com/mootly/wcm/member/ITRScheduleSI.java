/**
 * 
 */
package com.mootly.wcm.member;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.ScheduleSIDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.model.ResidentStatus;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;

/**
 * @author BEN-10
 *
 */
@PrimaryBean(primaryBeanClass=ScheduleSIDocument.class)
@ChildBean(childBeanClass=ScheduleSIDocumentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@AdditionalBeans(additionalBeansToLoad={OtherSourcesDocument.class,CapitalAssetDocument.class,SalaryIncomeDocument.class,FormSixteenDocument.class,HouseProperty.class,DeductionDocument.class})
@FormFields(fieldNames={"schedulesiSection","amount","specialRate"})
@RequiredFields(fieldNames={"schedulesiSection","amount"})
@DataTypeValidationFields(fieldNames={"amount"},dataTypes={DataTypeValidationType.DECIMAL})
public class ITRScheduleSI extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ITRScheduleSI.class);
	

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		MemberPersonalInformation o = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections schSISection:ITRScheduleSISections.values()){
			if(schSISection.isActive()){
				ResidentStatus[] siResident=schSISection.getResidentialStatus();
				for(ResidentStatus rs:siResident){
					if(rs.toString().equalsIgnoreCase(o.getResidentCategory())){
						scheduleSIList.add(schSISection);		
					}	
				}
			}
		}
		log.info("scheduleSIList::"+scheduleSIList);
		request.setAttribute("scheduleSIList", scheduleSIList);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

	@Override
	public void afterSave(HstRequest request, HstResponse response, FormMap map,
			PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		Map<String,String[]> requestParameterMap=new HashMap<String,String[]>();
		super.afterSave(request,response, map, pageAction);
		Session persistableSession = null;
		FinancialYear fy=(FinancialYear)request.getAttribute("financialYear");
		Map<String, HippoBean> inputBean = new HashMap<String, HippoBean>();
		inputBean.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()));
		inputBean.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(FormSixteenDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(HouseProperty.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()));
		inputBean.put(CapitalAssetDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(DeductionDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase()));
		
		try {
			persistableSession = getPersistableSession(request);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get JCR Repository Session",e);
		}
		//Schedule SI section depends upon Capital Gain and Other Sources if some one not does not Request for this section doc then we can create SI doc by call method
		log.info("Create schedule SI Document:");
		
		createInActiveScheduleSISection(request,persistableSession, inputBean, fy); 
	}
	
	/**
	 * This method is used to create all inactive schedule SI sections.
	 * 
	 * @param persistableSession {@link Session} JCR Session to get WorkFlow.
	 * @param inputBean {@link Map} Map contain all necessary Document Beans.
	 * @param fy {@link FinancialYear} Current Active Financial Year.
	 * 
	 * @return void
	 * */
	public void createInActiveScheduleSISection(HstRequest request, Session persistableSession,Map<String, HippoBean> inputBean,FinancialYear fy){
		try {
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			ScheduleSIDocument siDoc = (ScheduleSIDocument) wpm.getObject(getITRInitData(request).getAbsoluteBasePathToReturnDocuments()+"/"+ScheduleSIDocument.class.getSimpleName().toLowerCase());
			if(siDoc==null){
				String createdDocPath = wpm.createAndReturn(getITRInitData(request).getAbsoluteBasePathToReturnDocuments(), ScheduleSIDocument.NAMESPACE, ScheduleSIDocument.NODE_NAME, true);
				siDoc = (ScheduleSIDocument) wpm.getObject(createdDocPath);
			}
			List<ITRScheduleSISections> scheduleSIList = ITRScheduleSISections.createInActiveScheduleSIList(inputBean);
			if(!scheduleSIList.isEmpty()){
				for(ITRScheduleSISections siSection:scheduleSIList){
					Map<String, Object> resultMap = updateScheduleSI(fy, siSection, inputBean);
					String sectionChildUUID = findPresentOfScheduleSI(siDoc, siSection);
					if(StringUtils.isNotBlank(sectionChildUUID)){
						ScheduleSIDocumentDetail siDetailUp = (ScheduleSIDocumentDetail) wpm.getObjectByUuid(sectionChildUUID);
						invokeScheduleSIDetailDocMeth(siDetailUp, siSection, resultMap);
						siDoc.update(siDetailUp);
					}else{					
						ScheduleSIDocumentDetail childDoc = new ScheduleSIDocumentDetail();
						invokeScheduleSIDetailDocMeth(childDoc, siSection, resultMap);
						siDoc.add(childDoc);
					} 
				}
				wpm.update(siDoc);
			}

		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Object at specified path",e);
		} 
	}
	
	/**
	 * This method is used to find child of {@link ScheduleSIDocument} by their xmlCode.
	 * 
	 * @param parentBean {@link HippoBean} Bean document of {@link ScheduleSIDocument}
	 * @param siSection {@link ITRScheduleSISections} InActive Schedule SI Section
	 * 
	 * @return {@link String} return UUID of child Doc to update.
	 * 
	 * */
	public static String findPresentOfScheduleSI(HippoBean parentBean,ITRScheduleSISections siSection){
		ScheduleSIDocument siDocument = (ScheduleSIDocument) parentBean;
		if(!siDocument.getScheduleSiDetailList().isEmpty()){
			for(ScheduleSIDocumentDetail siDetail:siDocument.getScheduleSiDetailList()){
				if(siDetail.getSchedulesiSection().equalsIgnoreCase(siSection.getXmlCode())){
					return siDetail.getCanonicalUUID();
				}
			}
		}
		return null;
	}
	
	/**
	 * This method is used to create Schedule SI section.
	 * 
	 * @param fy {@link FinancialYear} Current Active Financial Year.
	 * @param siSection {@link ITRScheduleSISections}
	 * @param inputBean {@link Map} Map contain all necessary Document Beans.
	 * 
	 * @return {@link Map} Result Map having values for schedule SI section.
	 * 
	 * */
	public static Map<String, Object> updateScheduleSI(FinancialYear fy,ITRScheduleSISections siSection,Map<String, HippoBean> inputBean){
		OtherSourcesDocument Osd=(OtherSourcesDocument)inputBean.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		CapitalAssetDocument CapDoc = (CapitalAssetDocument) inputBean.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		totalMapForJS.put("spRate", siSection.getPercentRate()[siSection.getPercentRate().length-1]);
		totalMapForJS.put("scheduleSiDocument",null);
		totalMapForJS.put("enable", "enable");
		if(siSection.getXmlCode().equalsIgnoreCase("5BB")){
			if(Osd!=null){
				totalMapForJS.put("userAmount", Osd.getLotteryOrhorse_income());	
			}else{
				totalMapForJS.put("userAmount", 0d);
			}
			totalMapForJS.put("CapDoc", "CapDoc");
		}else{
			if(CapDoc!=null){
				totalMapForJS.put("CapDoc", CapDoc);
			}else{
				totalMapForJS.put("CapDoc", "CapDoc");
			}
			totalMapForJS.put("userAmount", null);
			
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBean.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());		
			DeductionDocument deductionDocument = (DeductionDocument) inputBean.get(DeductionDocument.class.getSimpleName().toLowerCase());
	
			//Changes made to make it run for fy : 2013-2014
			IndianCurrencyHelper currencyHelper = new IndianCurrencyHelper();
			BigInteger deductionChapSix = new BigInteger("0");
			BigInteger exemptFreeGrossTotal = new BigInteger("0");
			Double slabValue = 0d;
			long grossTotal = 0;
			
			if(fy.getDisplayName().equals("2011-2012")){
				com.mootly.wcm.model.schedules.y2011_2012.DeductionVIASchedules deductionVIASchedules = new com.mootly.wcm.model.schedules.y2011_2012.DeductionVIASchedules(deductionDocument, memberPersonalInformation, Osd);
				in.gov.incometaxindiaefiling.y2011_2012.ITR itr = new in.gov.incometaxindiaefiling.y2011_2012.ITR();
				in.gov.incometaxindiaefiling.y2011_2012.ScheduleVIA  scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, fy, inputBean);
				com.mootly.wcm.utils.XmlCalculation xmlCal = new com.mootly.wcm.utils.XmlCalculation();
				
				grossTotal = xmlCal.getGrossTotalOfIncomeWTFlateRate(fy, inputBean);
				deductionChapSix = scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions();
				exemptFreeGrossTotal = currencyHelper.longToBigInteger(grossTotal).subtract(deductionChapSix); 
				slabValue = findSlabOfGrossIncome(fy, inputBean, exemptFreeGrossTotal);
			}else if(fy.getDisplayName().equals("2012-2013")){
				com.mootly.wcm.model.schedules.y2012_2013.DeductionVIASchedules deductionVIASchedules = new com.mootly.wcm.model.schedules.y2012_2013.DeductionVIASchedules(deductionDocument, memberPersonalInformation, Osd);
				in.gov.incometaxindiaefiling.y2012_2013.ITR itr = new in.gov.incometaxindiaefiling.y2012_2013.ITR();
				in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA  scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, fy, inputBean);
				com.mootly.wcm.utils.XmlCalculation xmlCal = new com.mootly.wcm.utils.XmlCalculation();
				
				grossTotal = xmlCal.getGrossTotalOfIncomeWTFlateRate(fy, inputBean);
				deductionChapSix = scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions();
				exemptFreeGrossTotal = currencyHelper.longToBigInteger(grossTotal).subtract(deductionChapSix); 
				slabValue = findSlabOfGrossIncome(fy, inputBean, exemptFreeGrossTotal);
			}else if(fy.getDisplayName().equals("2013-2014")){
				com.mootly.wcm.model.schedules.y2013_2014.DeductionVIASchedules deductionVIASchedules = new com.mootly.wcm.model.schedules.y2013_2014.DeductionVIASchedules(deductionDocument, memberPersonalInformation, Osd);
				in.gov.incometaxindiaefiling.y2013_2014.ITR itr = new in.gov.incometaxindiaefiling.y2013_2014.ITR();
				in.gov.incometaxindiaefiling.y2013_2014.ScheduleVIA  scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, fy, inputBean);		
				com.mootly.wcm.services.y2013_2014.XmlCalculation xmlCal = new com.mootly.wcm.services.y2013_2014.XmlCalculation();
				
				grossTotal = xmlCal.getGrossTotalOfIncomeWTFlateRate(fy, inputBean);
				deductionChapSix = scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions();
				exemptFreeGrossTotal = currencyHelper.longToBigInteger(grossTotal).subtract(deductionChapSix); 
				slabValue = findSlabOfGrossIncome(fy, inputBean, exemptFreeGrossTotal);
			}
			
			totalMapForJS.put("grossTotal", exemptFreeGrossTotal);
			totalMapForJS.put("slabValue", slabValue);
			totalMapForJS.put("xmlCode", siSection.getXmlCode());
		}
		Map<String,String[]> requestParameterMap=new HashMap<String,String[]>();
		resultMap = ScreenCalculatorService.getScreenCalculations("ScheduleSI.js", requestParameterMap, totalMapForJS);
		return resultMap;
	}
	/**
	 * This method is used to Find slab Rate if there is no tax on Gross Income.
	 * 
	 * @param fy {@link FinancialYear} Current Active Financial Year.
	 * @param inputBean {@link Map} Map contain all necessary Document Beans.
	 * @param grossTotal {@link BigInteger}
	 * 
	 * @return {@link Double} Value of Slab Amount.
	 * */
	public static Double findSlabOfGrossIncome(FinancialYear fy,Map<String, HippoBean> inputBean, BigInteger grossTotal){
		MemberPersonalInformation o = (MemberPersonalInformation) inputBean.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		Map<String,Object> totalMapForJS = new HashMap<String, Object>();
		totalMapForJS.put("cbassyear",fy.getDisplayAssessmentYear());
		totalMapForJS.put("cbasstype", o.getFilingStatus());
		totalMapForJS.put("cbresistatus",o.getResidentCategory());
		totalMapForJS.put("txtNetIncome",grossTotal);
		boolean isSeniorCitizen = fy.isSeniorCitizen(o.getDOB().getTime());
		if(isSeniorCitizen){
			boolean isSuperSeniorCitizen = fy.isSuperSeniorCitizen(o.getDOB().getTime());
			if(isSuperSeniorCitizen){
				totalMapForJS.put("cbasscategory","Super Senior Citizen");
			}else
				totalMapForJS.put("cbasscategory","Senior Citizen");
		}else{
			totalMapForJS.put("cbasscategory",o.getSex());
		}
		Map<String,String[]> requestParameterMap=new HashMap<String,String[]>();
		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", requestParameterMap, totalMapForJS);
		//If Except than RES then there will no adjustment in Income of User.
		if(Double.parseDouble(resultMap.get("txtTax").toString())==0d && o.getResidentCategory().equalsIgnoreCase(ResidentStatus.RES.toString())){
			return Double.parseDouble(resultMap.get("slabRate").toString());
		}
		return 0d;
	}
	
	/**
	 * This method is used to invoke the method of {@link ScheduleSIDocument} to save {@link ITRScheduleSISections}.
	 * 
	 * @param siDetailUp {@link ScheduleSIDocumentDetail} 
	 * @param siSection {@link ITRScheduleSISections}
	 * @param resultMap {@link Map}
	 * 
	 * @return {@link Void}
	 * 
	 * */
	public static void invokeScheduleSIDetailDocMeth(ScheduleSIDocumentDetail siDetailUp,ITRScheduleSISections siSection,Map<String ,Object> resultMap){
		siDetailUp.setAmount(Double.parseDouble(resultMap.get("userAmount").toString()));
		siDetailUp.setSchedulesiSection(siSection.getXmlCode());
		siDetailUp.setSpecialRate(siSection.getPercentRate()[siSection.getPercentRate().length-1]);
		siDetailUp.setCalcRateIncome(Double.parseDouble(resultMap.get("taxOnIncome").toString()));
		siDetailUp.setMinChargTaxIncome(Double.parseDouble(resultMap.get("minChargIncome").toString()));
	}
}
