/**
 * 
 */
package com.mootly.wcm.member;

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
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.ScheduleSIDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.InvalidNavigationException;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.model.ResidentStatus;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.utils.XmlCalculation;

/**
 * @author BEN-10
 *
 */
@PrimaryBean(primaryBeanClass=ScheduleSIDocument.class)
@ChildBean(childBeanClass=ScheduleSIDocumentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@AdditionalBeans(additionalBeansToLoad={OtherSourcesDocument.class,CapitalAssetDocument.class,SalaryIncomeDocument.class,FormSixteenDocument.class,HouseProperty.class})
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
		request.setAttribute("scheduleSIList", scheduleSIList);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

	@Override
	public void afterSave(HstRequest request, FormMap map,
			PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		super.afterSave(request, map, pageAction);
		//Schedule SI section depends upon Capital Gain and Other Sources if some one not does not Request for this section doc then we can create SI doc by call method
		log.info("create schedule SI Document");
		createInActiveScheduleSISection(request, map); 
	}
	/**
	 * This method is used to create all inactive schedule SI sections.
	 * 
	 * @param request {@link HstRequest}
	 * @param formMap {@link FormMap}
	 * 
	 * @return void
	 * */
	public void createInActiveScheduleSISection(HstRequest request, FormMap formMap){
		try {
			Session persistableSession = getPersistableSession(request);
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			ScheduleSIDocument siDoc = (ScheduleSIDocument) wpm.getObject(getAbsoluteBasePathToReturnDocuments()+"/"+ScheduleSIDocument.class.getSimpleName().toLowerCase());
			if(siDoc==null){
				log.info("Dont have Schedule SI Document:Creating it");
				String createdDocPath = wpm.createAndReturn(getAbsoluteBasePathToReturnDocuments(), ScheduleSIDocument.NAMESPACE, ScheduleSIDocument.NODE_NAME, true);
				siDoc = (ScheduleSIDocument) wpm.getObject(createdDocPath);
			}
			List<ITRScheduleSISections> scheduleSIList = createInActiveScheduleSIList(request);
			if(!scheduleSIList.isEmpty()){
				for(ITRScheduleSISections siSection:scheduleSIList){
					log.info("create si section");
					Map<String, Object> resultMap = updateScheduleSI(request, siSection);
					String sectionChildUUID = findPresentOfScheduleSI(request, siDoc, siSection);
					if(StringUtils.isNotBlank(sectionChildUUID)){
						log.info("create si section:update child");
						ScheduleSIDocumentDetail siDetailUp = (ScheduleSIDocumentDetail) wpm.getObjectByUuid(sectionChildUUID);
						invokeScheduleSIDetailDocMeth(siDetailUp, siSection, resultMap);
						siDoc.update(siDetailUp);
					}else{					
						log.info("create si section:add child");
						ScheduleSIDocumentDetail childDoc = new ScheduleSIDocumentDetail();
						invokeScheduleSIDetailDocMeth(childDoc, siSection, resultMap);
						siDoc.add(childDoc);
					} 
				}
				wpm.update(siDoc);
			}

		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get JCR Repository Session",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Object at specified path",e);
		} catch (InvalidNavigationException e) {
			// TODO Auto-generated catch block
			log.error("Error while create base path to get document",e);
		}
	}
	/**
	 * This method is used to find child of {@link ScheduleSIDocument} by their xmlCode.
	 * 
	 * @param request {@link HstRequest}
	 * @param parentBean {@link HippoBean} Bean document of {@link ScheduleSIDocument}
	 * @param siSection {@link ITRScheduleSISections} InActive Schedule SI Section
	 * 
	 * @return {@link String} return UUID of child Doc to update.
	 * 
	 * */
	public static String findPresentOfScheduleSI(HstRequest request,HippoBean parentBean,ITRScheduleSISections siSection){
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
	 * This method is used to create List of all inactive Schedule SI Section.
	 * 
	 * @param request {@link HstRequest}
	 * 
	 * @return {@link List} List<ITRScheduleSISection> of all schedule SI section 
	 * 
	 * */
	public static List<ITRScheduleSISections> createInActiveScheduleSIList(HstRequest request){
		MemberPersonalInformation o = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections schSISection:ITRScheduleSISections.values()){
			if(!schSISection.isActive() && schSISection != ITRScheduleSISections.UNKNOWN){
				for(ResidentStatus rs:schSISection.getResidentialStatus()){
					if(rs.toString().equalsIgnoreCase(o.getResidentCategory())){
						scheduleSIList.add(schSISection);
					}
				}							
			}
		}
		return scheduleSIList;
	}
	/**
	 * This method is used to create Schedule SI section.
	 * 
	 * @param request {@link HstRequest}
	 * @param siSection {@link ITRScheduleSISections}
	 * 
	 * @return {@link Map} Result Map having values for schedule SI section.
	 * 
	 * */
	public static Map<String, Object> updateScheduleSI(HstRequest request,ITRScheduleSISections siSection){
		log.info("create si section:start");
		OtherSourcesDocument Osd=(OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		CapitalAssetDocument CapDoc = (CapitalAssetDocument) request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		Map<String, HippoBean> inputBean = new HashMap<String, HippoBean>();
		inputBean.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(FormSixteenDocument.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()));
		inputBean.put(HouseProperty.class.getSimpleName().toLowerCase(), (HippoBean)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()));
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
			log.info("create si section:set para");
			if(CapDoc!=null){
				totalMapForJS.put("CapDoc", CapDoc);
			}else{
				log.info("create si section:capDoc null");
				totalMapForJS.put("CapDoc", "CapDoc");
			}
			totalMapForJS.put("userAmount", null);
			XmlCalculation xmlCal = new XmlCalculation();
			long grossTotal = xmlCal.grossTotal((FinancialYear)request.getAttribute("financialYear"), inputBean);
			log.info("create si section:call slab");
			Double slabValue = findSlabOfGrossIncome(request, grossTotal);
			totalMapForJS.put("grossTotal", grossTotal);
			totalMapForJS.put("slabValue", slabValue);
			totalMapForJS.put("xmlCode", siSection.getXmlCode());
		}
		resultMap = ScreenCalculatorService.getScreenCalculations("ScheduleSI.js", request.getParameterMap(), totalMapForJS);
		return resultMap;
	}
	/**
	 * This method is used to Find slab Rate if there is no tax on Gross Income.
	 * 
	 * @param request {@link HstRequest}
	 * @param grossTotal {@link Long}
	 * 
	 * @return {@link Double} Value of Slab Rate.
	 * */
	public static Double findSlabOfGrossIncome(HstRequest request, long grossTotal){
		log.info("create si section:find slab");
		MemberPersonalInformation o = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		FinancialYear fy=(FinancialYear)request.getAttribute("financialYear");
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
		Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("xmlCalculation.js", request.getParameterMap(), totalMapForJS);
		if(Double.parseDouble(resultMap.get("txtTax").toString())==0d){
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
