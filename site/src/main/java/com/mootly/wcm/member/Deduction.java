/*
 * In this class we are creating a document for storing value of Deduction details of user
 * according to form 16.
 * @author
 * 04/03/2013
 *
 *
 */
package com.mootly.wcm.member;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.ItemNotFoundException;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.annotations.ValueListBeans;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.MemberDeductionScheduleC;
import com.mootly.wcm.beans.MemberDeductionScheduleG;
import com.mootly.wcm.beans.MemberDeductionScheduleGG;
import com.mootly.wcm.beans.MemberDeductionScheduleIA;
import com.mootly.wcm.beans.MemberDeductionScheduleIB;
import com.mootly.wcm.beans.MemberDeductionScheduleIC;
import com.mootly.wcm.beans.MemberDeductionScheduleVIA;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.DoneeWithPan;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ResidentStatus;
import com.mootly.wcm.model.deduction.DeductionHead;
import com.mootly.wcm.model.deduction.DeductionSection;
import com.mootly.wcm.model.schedules.y2012_2013.DeductionVIASchedules;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TI;
import com.mootly.wcm.services.DeductionListService;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

@PrimaryBean(primaryBeanClass=DeductionDocument.class)
@ChildBean(childBeanClass=DeductionDocumentDetail.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,SalaryIncomeDocument.class,HouseProperty.class,OtherSourcesDocument.class,FormSixteenDocument.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@ValueListBeans(paths={"deduction-sections-${financialYear}","deduction-section-heads-${financialYear}","deduction-section-maxallowed-${financialYear}"},
accessKey={"deduction_sections","deduction_section_heads","deduction_section_maxallowed"})
@FormFields(fieldNames={"head","investment","decuuidform16","flex_string_doneeName","flex_string_doneePAN","flex_string_doneeFlatFloorBuilding","flex_string_doneePAN","flex_string_doneeRoadStreet","flex_string_doneeAreaLocality","flex_string_doneeCityTownDistrict","flex_string_doneeState","flex_string_doneePostalCode"})
@RequiredFields(fieldNames={"head","investment"})
@DataTypeValidationFields(fieldNames={"investment"},dataTypes={DataTypeValidationType.DECIMAL})
public class Deduction extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(Deduction.class);
	String deduction_section = null;

	DeductionListService deductionListService = null;

	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		deductionListService = context.getBean(DeductionListService.class);
		//deductionListService
	}

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		ResidentStatus residentStatus = null;
		Map<String,DeductionSection> deductionSectionMap = null; //listOfDeductionSections = null;
		Map<String, Double> totalOfSavedData = new HashMap<String, Double>();
		Map<String, Double> totalOfSavedDataPerHead = new HashMap<String, Double>();
		super.doBeforeRender(request, response);
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		OtherSourcesDocument othersourcesdoc=(OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		//String a = getComponentConfiguration().getParameter("ischildofform16", request.getRequestContext().getResolvedSiteMapItem());
		//String ischildofform16 = getLocalParameter("ischildofform16", request);
		//getParameter("ischildofform16", request)
		String ischildofform16 =  getParameter("ischildofform16", request);
		request.setAttribute("ischildofform16",ischildofform16);
		Boolean form16InEditMode = Boolean.FALSE;
		String form16UniqueUUID = null;
		form16InEditMode = (Boolean) request.getRequestContext().getAttribute("form16InEditMode");
		form16UniqueUUID = (String) request.getRequestContext().getAttribute("form16UniqueUUID");
		if (request.getRequestContext().getResolvedSiteMapItem().getParameter("uuidform_16") != null) {
			request.setAttribute("uuidform_16", request.getRequestContext().getResolvedSiteMapItem().getParameter("uuidform_16"));
		}
		if ( form16InEditMode == null ) form16InEditMode = Boolean.FALSE;

		request.setAttribute("deductionListService", deductionListService);
		if (deductionListService != null && deductionListService.getDeductionSectionMap() != null &&  deductionListService.getDeductionSectionMap().containsKey(getFinancialYear())) {
			deductionSectionMap = deductionListService.getDeductionSectionMap().get(getFinancialYear());
			request.setAttribute("deductionSectionMap", deductionSectionMap);
		}

		//Amit Patkar Hack for Section 80tta which is a derived section and NOT a REAL deduction
		List<DeductionDocumentDetail> listOfDerivedDeductionDocuments = new ArrayList<DeductionDocumentDetail>();
		if (othersourcesdoc != null && othersourcesdoc.getBank_detail_saving() != null) {
			DeductionDocumentDetail bankSavingDetail = new DeductionDocumentDetail();
			bankSavingDetail.setSection("80tta");
			bankSavingDetail.setInvestment(othersourcesdoc.getBank_detail_saving());
			listOfDerivedDeductionDocuments.add(bankSavingDetail);
			//bankSavingDetail.se
		}
		//Amit Patkar Hack for Section 80tta which is a derived section and NOT a REAL deduction
		if (getParentBean()!= null || listOfDerivedDeductionDocuments.size() > 0) {
			DeductionDocument deductionDocument = (DeductionDocument) getParentBean();
			List<DeductionDocumentDetail> deductionDocumentDetailList = null;
			if (deductionDocument != null) {
				deductionDocumentDetailList = deductionDocument.getDeductionDocumentDetailList();
			}

			if (listOfDerivedDeductionDocuments != null && listOfDerivedDeductionDocuments.size() > 0) {
				if (deductionDocumentDetailList == null) {
					deductionDocumentDetailList = listOfDerivedDeductionDocuments;
				}
				else {
					deductionDocumentDetailList.addAll (listOfDerivedDeductionDocuments);
				}
			}

			Double grandTotal = 0D;
			if (deductionDocumentDetailList != null && deductionDocumentDetailList.size() > 0){
				Map<String, List<DeductionDocumentDetail>> savedData = new HashMap<String, List<DeductionDocumentDetail>>();

				for (DeductionDocumentDetail deductionDocumentDetail:deductionDocumentDetailList) {
					if (form16InEditMode && form16UniqueUUID != null) {
						if (deductionDocumentDetail.getForm16Uuid() != null && !deductionDocumentDetail.getForm16Uuid().equals(form16UniqueUUID)) {
							continue;
						}
					}
					if (!savedData.containsKey(deductionDocumentDetail.getSection())) {
						savedData.put(deductionDocumentDetail.getSection(), new ArrayList<DeductionDocumentDetail>());
					}
					savedData.get(deductionDocumentDetail.getSection()).add(deductionDocumentDetail);
					if (getPageAction() == PAGE_ACTION.EDIT_CHILD && getUuid() != null && getUuid().equals(deductionDocumentDetail.getCanonicalUUID())) {
						request.setAttribute("editingSection", deductionDocumentDetail);
					}
					if (!totalOfSavedData.containsKey(deductionDocumentDetail.getSection())){
						totalOfSavedData.put(deductionDocumentDetail.getSection(), 0D);
					}
					if (!totalOfSavedDataPerHead.containsKey(deductionDocumentDetail.getHead())) {
						totalOfSavedDataPerHead.put(deductionDocumentDetail.getHead(), 0D);
					}
					totalOfSavedDataPerHead.put(deductionDocumentDetail.getHead(), totalOfSavedDataPerHead.get(deductionDocumentDetail.getHead()) + deductionDocumentDetail.getInvestment());
					totalOfSavedData.put( deductionDocumentDetail.getSection(),  totalOfSavedData.get(deductionDocumentDetail.getSection()).doubleValue() + deductionDocumentDetail.getInvestment().doubleValue());
				}
				if (savedData != null && savedData.size() > 0) request.setAttribute("savedData",savedData);
				if (totalOfSavedData != null && totalOfSavedData.size() > 0){
					for (String aSection:totalOfSavedData.keySet()) {
						grandTotal += totalOfSavedData.get(aSection);
					}
					request.setAttribute("grandTotal",grandTotal);
					request.setAttribute("totalOfSavedDataPerHead",totalOfSavedDataPerHead);
					request.setAttribute("totalOfSavedData",totalOfSavedData);
				}

			}
		}

		if (getPageAction() == PAGE_ACTION.EDIT_CHILD && getUuid() != null && getChildBean() != null) {
			DeductionDocumentDetail dDetail = (DeductionDocumentDetail) getChildBean();
			DoneeWithPan doneeWithPAN = DoneeWithPan.getInstanceFromChildBean(dDetail);
			request.setAttribute("doneeWithPAN", doneeWithPAN);
			if (deductionSectionMap != null && dDetail != null && dDetail.getSection() != null && deductionSectionMap.containsKey(dDetail.getSection())) {
				request.setAttribute("deductionSection", deductionSectionMap.get(dDetail.getSection()));
			}
		}
		else {
			DeductionDocumentDetail dDetail = (DeductionDocumentDetail) getChildBean();
			DoneeWithPan doneeWithPAN = DoneeWithPan.getInstanceFromFormMap(getFormMap());
			if (doneeWithPAN != null)request.setAttribute("doneeWithPAN", doneeWithPAN);
			String deduction_section = request.getRequestContext().getResolvedSiteMapItem().getParameter("deduction_section");
			if (deduction_section != null) {
				request.setAttribute("deduction_section", deduction_section);
				if (deductionSectionMap != null && deductionSectionMap.containsKey(deduction_section)) {
					request.setAttribute("deductionSection", deductionSectionMap.get(deduction_section));
				}
			}
		}

		//time to calculate
		if (getParentBean() != null  || listOfDerivedDeductionDocuments.size() > 0 ) {
			//hashmap for javascript
			Map<String,Object> totalMapForJS = new HashMap<String, Object>();
			for (String deductionSectionKey:deductionSectionMap.keySet()){
				String sanitizedKey =  "total_" +  deductionSectionKey.replaceAll("-", "_");
				DeductionSection deductionSection = deductionSectionMap.get(deductionSectionKey);
				if (deductionSection.getListOfDeductionHead() != null) {
					for (DeductionHead aDeductionHead:deductionSection.getListOfDeductionHead()) {
						String sanitizedKey2 =  "total_" +  aDeductionHead.getName().replaceAll("-", "_");
						if (totalOfSavedDataPerHead != null && totalOfSavedDataPerHead.containsKey(aDeductionHead.getName())) {
							totalMapForJS.put(sanitizedKey2,totalOfSavedDataPerHead.get(aDeductionHead.getName()));
						}
						else {
							totalMapForJS.put(sanitizedKey2,0D);
						}
					}
				}
				if (totalOfSavedData != null && totalOfSavedData.containsKey(deductionSectionKey)) {
					totalMapForJS.put(sanitizedKey,totalOfSavedData.get(deductionSectionKey));
				}
				else {
					totalMapForJS.put(sanitizedKey,0D);
				}
			}
			/*
			for (String savedDataPerHead:totalOfSavedDataPerHead.keySet()){
				String sanitizedKey =  "total_" +  savedDataPerHead.replaceAll("-", "_");
				Double totalForSectionHead = totalOfSavedDataPerHead.get(savedDataPerHead);
				totalMapForJS.put(sanitizedKey,totalForSectionHead);
			}
			 */
			//ALSO WE NEED to have the following variables for calculation
			// AGI == Adjusted Gross Income
			// totalSalaryIncome
			// totalIncomeFromProperty
			// totaIncomeFromOtherSourcesIncludingTaxFreeIncome
			// totalIncomeFromOtherSourcesExcludingTaxFreeIncome

			if (memberPersonalInformation != null) {
				int ageInYears = getFinancialYear().getAgeInYears(memberPersonalInformation.getDOB().getTime());
				boolean isSeniorCitizen = getFinancialYear().isSeniorCitizen(memberPersonalInformation.getDOB().getTime());
				totalMapForJS.put("ageInYears",ageInYears);
				totalMapForJS.put("isSeniorCitizen",isSeniorCitizen);
				residentStatus = ResidentStatus.valueOf(memberPersonalInformation.getResidentCategory());
			}
			double salarypension=0D;double othersources=0D;double houseproperty=0D;
			SalaryIncomeDocument salaryincome=(SalaryIncomeDocument)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
			FormSixteenDocument objFormSixteen=(FormSixteenDocument)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
			if(objFormSixteen != null && objFormSixteen.getFormSixteenDetailList() != null && objFormSixteen.getFormSixteenDetailList().size() >0){
				for(FormSixteenDetail formsixteendetail:objFormSixteen.getFormSixteenDetailList()){
					salarypension=salarypension+formsixteendetail.getIncome_chargable_tax();
				}
			}else{
				if(salaryincome!=null)
					salarypension=salaryincome.getTotal();
			}
			totalMapForJS.put("salarypension", salarypension);
			//added Business Income for ITR4
			totalMapForJS.put("businessIncome", getBusinessIncome(request));
			
			if(othersourcesdoc!=null)
				othersources=othersourcesdoc.getTaxable_income();
			totalMapForJS.put("othersources", othersources);
			HouseProperty housprop=(HouseProperty)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
			if (housprop != null && housprop.getHouseIncomeDetailList() != null && housprop.getHouseIncomeDetailList().size() > 0 ){
				for (HouseIncomeDetail houseincomeDetail:housprop.getHouseIncomeDetailList()) {
					houseproperty=houseproperty+houseincomeDetail.getIncome_hproperty();
				}
			}
			totalMapForJS.put("houseproperty", houseproperty);
			//totalMapForJS.put("total_eligiblededuction", 0D);
			Map<String,Object> resultMap = ScreenCalculatorService.getScreenCalculations("Chapter6Calc.js", request.getParameterMap(), totalMapForJS);
			if (resultMap != null && resultMap.size() > 0 ) {
				totalMapForJS.putAll(resultMap);
				request.setAttribute("totalMapForJS", totalMapForJS);
				request.setAttribute("finaltotalEligibleDeduction",resultMap.get("total_eligiblededuction").toString());
				// remove session
				//request.getSession().setAttribute("dedTotalOnForm16", resultMap.get("total_eligiblededuction").toString());
			}
		}
	}
	public Double getBusinessIncome(HstRequest request){
		Double businessIncome = 0d;
		MemberPersonalInformation pi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		ITRForm selectedITR = pi.getSelectedITRForm();
		if(selectedITR.equals(ITRForm.ITR4)){
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
			inputBeans.put(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase(), (IncomeFromFirmsDocument)request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase()));

			DeductionDocument deductionDocument = (DeductionDocument) request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase());
			ITR itr = new ITR();
			PartB_TI partB_TI = new	PartB_TI((FormSixteenDocument)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()),
					(SalaryIncomeDocument)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()),
					(HouseProperty)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()),
					(OtherSourcesDocument)(OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()),
					deductionDocument, (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()),
					(ScheduleSIDocument)request.getAttribute(ScheduleSIDocument.class.getSimpleName().toLowerCase()), (CapitalAssetDocument)request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase()),
					(IncBusinessProfessionDoc)request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase()),(ProfitAndLossDocument)request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase()),
					(OtherInformationDocument)request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase()),(ScheduleDPMDocument)request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase()),
					(ScheduleDOADocument)request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase()),(ScheduleESRDocument)request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase()),
					(DeductionSchedTenADocumemt)request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase()), (IncomeFromFirmsDocument)request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase()));
			PartBTI partBTI = partB_TI.getPartBTI(itr, getFinancialYear(), inputBeans);
			businessIncome = partBTI.getProfBusGain().getTotProfBusGain().doubleValue();
		}
		return businessIncome;
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		String aa = getParameter("ischildofform16", request);
		String a = getComponentConfiguration().getParameter("ischildofform16", request.getRequestContext().getResolvedSiteMapItem());
		String ischildofform16 = getLocalParameter("ischildofform16", request);
		ischildofform16 =  getParameter("ischildofform16", request);
		super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		//super.beforeSave(request);
		//we need to change the child bean in case of new child to ensure correct section is saved
		String deduction_section = request.getRequestContext().getResolvedSiteMapItem().getParameter("deduction_section");
		if (getPageAction().equals(PAGE_ACTION.NEW_CHILD) && deduction_section != null) {
			if (getChildBean() != null) {
				DeductionDocumentDetail dd = (DeductionDocumentDetail) getChildBean();
				dd.setSection(deduction_section);
				String uuidform_16 = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuidform_16");
				//String form16UniqueUUID = (String) request.getRequestContext().getAttribute("form16UniqueUUID");
				String ischildofform16 =  getParameter("ischildofform16", request);
				//if (dd.getForm16Uuid())
				//form16InEditMode = (Boolean) request.getRequestContext().getAttribute("form16InEditMode");
				if (ischildofform16 != null && ischildofform16.equals("true")) {
					try {
						Node theForm16Node = request.getRequestContext().getSession().getNodeByIdentifier(uuidform_16);
						if (theForm16Node != null) {
							Property p = theForm16Node.getProperty("mootlywcm:formsixteenuuid");
							if (p != null) {
								dd.setForm16Uuid(p.getString());
							}
						}
					} catch (ItemNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (LoginException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RepositoryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//dd.setForm16Uuid();
				}
			}
		}
		String uuidform16=request.getRequestContext().getResolvedSiteMapItem().getParameter("uuidform-16");
		return true;
	}

	public void doBeforeRenderOld(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Deduction Page");
		String pan=(String)request.getSession().getAttribute("pan");
		String filing_year=(String)request.getSession().getAttribute("filing_year");
		Member member=(Member)request.getSession().getAttribute("user");
		String username=member.getUserName().trim();
		String modusername=username.replaceAll("@", "-at-").trim();
		try {
			log.info("hello in try");
			String path2=ContentStructure.getSchedule80IADocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIA documentia=(MemberDeductionScheduleIA)getObjectBeanManager(request).getObject(path2);
			request.setAttribute("documentia", documentia);
			if(documentia!=null){
				log.info("document ia");
			}
			String path3=ContentStructure.getSchedule80IBDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIB documentib=(MemberDeductionScheduleIB)getObjectBeanManager(request).getObject(path3);
			request.setAttribute("documentib", documentib);
			if(documentib!=null){
				log.info("document ib");
			}
			String path1=ContentStructure.getSchedule80GGDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleGG documentgg=(MemberDeductionScheduleGG)getObjectBeanManager(request).getObject(path1);
			request.setAttribute("documentgg", documentgg);
			if(documentgg!=null){
				log.info("document gg");
			}

			String path4=ContentStructure.getSchedule80ICDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleIC documentic=(MemberDeductionScheduleIC)getObjectBeanManager(request).getObject(path4);
			request.setAttribute("documentic", documentic);

			String path5=ContentStructure.getSchedule80CDocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleC documentc=(MemberDeductionScheduleC)getObjectBeanManager(request).getObject(path5);
			request.setAttribute("documentc", documentc);
			if(documentc!=null){
				log.info("document c");
			}
			String path6=ContentStructure.getSchedule80GDocumentPath(pan, filing_year, modusername);
			MemberDeductionScheduleG documentg=(MemberDeductionScheduleG)getObjectBeanManager(request).getObject(path6);
			request.setAttribute("documentg", documentg);
			if(documentg!=null){
				log.info("document g");
			}
			String path7=ContentStructure.getScheduleVIADocumentPath(pan,filing_year,modusername);
			MemberDeductionScheduleVIA documentvia=(MemberDeductionScheduleVIA)getObjectBeanManager(request).getObject(path7);
			request.setAttribute("documentvia", documentvia);
			if(documentvia!=null){
				log.info("document via");
			}
		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doActionOld(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.info("This is Deduction Page:doAction");

		String next=GoGreenUtil.getEscapedParameter(request,"next");
		String basic80C=GoGreenUtil.getEscapedParameter(request, "basic80C");
		String basic80GG=GoGreenUtil.getEscapedParameter(request, "basic80GG");
		String basic80G=GoGreenUtil.getEscapedParameter(request, "basic80G");
		String basic80IA=GoGreenUtil.getEscapedParameter(request, "basic80IA");
		String basic80IB=GoGreenUtil.getEscapedParameter(request, "basic80IB");
		String basic80IC=GoGreenUtil.getEscapedParameter(request,"basic80IC");
		String uuid=getPublicRequestParameter(request,"uuid");
		log.info("basic80C"+basic80C);
		if(basic80C!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80C);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80GG"+basic80GG);
		if(basic80GG!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80GG);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80G"+basic80G);
		if(basic80G!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80G);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80IA"+basic80IA);
		if(basic80IA!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80IA);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80IB"+basic80IB);
		if(basic80IB!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80IB);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("basic80IC"+basic80IC);
		if(basic80IC!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.Schedule80IC);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
		log.info("next"+next);
		if(next!=null){
			try{
				callofDeduction(request);
				response.sendRedirect(UrlUtility.RebateSection89);
			}catch(IOException e){
				log.warn("this is error in Redirection",e);
			}
		}
	}
	/**
	 * Method to Save all entries of Deduction page
	 * @param HstRequest
	 * @throws
	 * @author Priyank
	 */
	public void callofDeduction(HstRequest request){
		String Section80C=GoGreenUtil.getEscapedParameter(request,"Section80C");
		String Section80GGC=GoGreenUtil.getEscapedParameter(request,"Section80GGC");
		String Section80CCC=GoGreenUtil.getEscapedParameter(request,"Section80CCC");
		String Section80QQB=GoGreenUtil.getEscapedParameter(request,"Section80QQB");
		String Section80CCD=GoGreenUtil.getEscapedParameter(request,"Section80CCD");
		String Section80CCG=GoGreenUtil.getEscapedParameter(request,"Section80CCG");
		String Section80RRB=GoGreenUtil.getEscapedParameter(request,"Section80RRB");
		String Section80D=GoGreenUtil.getEscapedParameter(request,"Section80D");
		String Section80U=GoGreenUtil.getEscapedParameter(request,"Section80U");
		String Section80DD=GoGreenUtil.getEscapedParameter(request,"Section80DD");
		String Section80IA=GoGreenUtil.getEscapedParameter(request,"Section80IA");
		String Section80DDB=GoGreenUtil.getEscapedParameter(request,"Section80DDB");
		String Section80IB=GoGreenUtil.getEscapedParameter(request,"Section80IB");
		String Section80E=GoGreenUtil.getEscapedParameter(request,"Section80E");
		String Section80IC=GoGreenUtil.getEscapedParameter(request,"Section80IC");
		String Section80G=GoGreenUtil.getEscapedParameter(request,"Section80G");
		String Section80JJA=GoGreenUtil.getEscapedParameter(request,"Section80JJA");
		String Section80TTA=GoGreenUtil.getEscapedParameter(request,"Section80TTA");
		String Section80GG=GoGreenUtil.getEscapedParameter(request,"Section80GG");
		String Section80ID=GoGreenUtil.getEscapedParameter(request,"Section80ID");
		String Section80GGA=GoGreenUtil.getEscapedParameter(request,"Section80GGA");
		String Section80IAB=GoGreenUtil.getEscapedParameter(request,"Section80IAB");
		String Section80CCF=GoGreenUtil.getEscapedParameter(request,"Section80CCF");
		String Total=GoGreenUtil.getEscapedParameter(request,"total");

		MemberDeductionScheduleVIA schvia=new MemberDeductionScheduleVIA();
		schvia.setScheduleC(Section80C);
		schvia.setScheduleGGC(Section80GGC);
		schvia.setScheduleCCC(Section80CCC);
		schvia.setScheduleQQB(Section80QQB);
		schvia.setScheduleCCD(Section80CCD);
		schvia.setScheduleRRB(Section80RRB);
		schvia.setScheduleD(Section80D);
		schvia.setScheduleU(Section80U);
		schvia.setScheduleDD(Section80DD);
		schvia.setScheduleIA(Section80IA);
		schvia.setScheduleDDB(Section80DDB);
		schvia.setScheduleIB(Section80IB);
		schvia.setScheduleE(Section80E);
		schvia.setScheduleIC(Section80IC);
		schvia.setScheduleG(Section80G);
		schvia.setScheduleJJA(Section80JJA);
		schvia.setScheduleGG(Section80GG);
		schvia.setScheduleID(Section80ID);
		schvia.setScheduleGGA(Section80GGA);
		schvia.setScheduleIAB(Section80IAB);
		schvia.setScheduleCCF(Section80CCF);
		schvia.setTotal(Total);
		createMemberDeductionScheduleVIA(request,schvia);
	}

	/**
	 * Method to Create & Update the Member Deduction ScheduleVIA Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws
	 * @author
	 */
	public MemberDeductionScheduleVIA createMemberDeductionScheduleVIA(HstRequest request,MemberDeductionScheduleVIA schvia){

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String pan=(String)request.getSession().getAttribute("pan");
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			/*Create the path to Save Document in the Repository
			 * */
			log.warn("this is user"+username);
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request,pan,filing_year,username);
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
			String updatePersonalReturnPath=ContentStructure.getScheduleVIADocumentPath(pan,filing_year,modusername);
			log.info("updatePersonalReturnPath"+updatePersonalReturnPath);
			MemberDeductionScheduleVIA updatepersonalInformation = (MemberDeductionScheduleVIA) wpm.getObject(updatePersonalReturnPath);
			if(updatepersonalInformation==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberDeductionScheduleVIA.NAMESPACE ,  MemberDeductionScheduleVIA.NODE_NAME, true);
				/*MemberDeductionScheduleVIA
				 *getObject method get the object at passed path in Repository.
				 * */
				MemberDeductionScheduleVIA personalInformation = (MemberDeductionScheduleVIA) wpm.getObject(personalReturnPath);

				// update content properties
				if (personalInformation != null) {
					log.info("PAN NUMBER");
					personalInformation.setScheduleC(schvia.getScheduleC());
					personalInformation.setScheduleGGC(schvia.getScheduleGGC());
					personalInformation.setScheduleCCC(schvia.getScheduleCCC());
					personalInformation.setScheduleQQB(schvia.getScheduleQQB());
					personalInformation.setScheduleCCD(schvia.getScheduleCCD());
					personalInformation.setScheduleRRB(schvia.getScheduleRRB());
					personalInformation.setScheduleD(schvia.getScheduleD());
					personalInformation.setScheduleU(schvia.getScheduleU());
					personalInformation.setScheduleDD(schvia.getScheduleDD());
					personalInformation.setScheduleIA(schvia.getScheduleIA());
					personalInformation.setScheduleDDB(schvia.getScheduleDDB());
					personalInformation.setScheduleIB(schvia.getScheduleIB());
					personalInformation.setScheduleE(schvia.getScheduleE());
					personalInformation.setScheduleIC(schvia.getScheduleIC());
					personalInformation.setScheduleG(schvia.getScheduleG());
					personalInformation.setScheduleJJA(schvia.getScheduleJJA());
					personalInformation.setScheduleGG(schvia.getScheduleGG());
					personalInformation.setScheduleID(schvia.getScheduleID());
					personalInformation.setScheduleGGA(schvia.getScheduleGGA());
					personalInformation.setScheduleIAB(schvia.getScheduleIAB());
					personalInformation.setScheduleCCF(schvia.getScheduleCCF());
					personalInformation.setTotal(schvia.getTotal());
					// update now
					wpm.update(personalInformation);
					return personalInformation;
				} else {
					log.warn("Failed to add Deduction Document '{}': could not retrieve Deduction bean for node '{}'.", MemberDeductionScheduleVIA.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);
					return personalInformation;
				}
			}else{
				log.info("update");
				updatepersonalInformation.setScheduleC(schvia.getScheduleC());
				updatepersonalInformation.setScheduleGGC(schvia.getScheduleGGC());
				updatepersonalInformation.setScheduleCCC(schvia.getScheduleCCC());
				updatepersonalInformation.setScheduleQQB(schvia.getScheduleQQB());
				updatepersonalInformation.setScheduleCCD(schvia.getScheduleCCD());
				updatepersonalInformation.setScheduleRRB(schvia.getScheduleRRB());
				updatepersonalInformation.setScheduleD(schvia.getScheduleD());
				updatepersonalInformation.setScheduleU(schvia.getScheduleU());
				updatepersonalInformation.setScheduleDD(schvia.getScheduleDD());
				updatepersonalInformation.setScheduleIA(schvia.getScheduleIA());
				updatepersonalInformation.setScheduleDDB(schvia.getScheduleDDB());
				updatepersonalInformation.setScheduleIB(schvia.getScheduleIB());
				updatepersonalInformation.setScheduleE(schvia.getScheduleE());
				updatepersonalInformation.setScheduleIC(schvia.getScheduleIC());
				updatepersonalInformation.setScheduleG(schvia.getScheduleG());
				updatepersonalInformation.setScheduleJJA(schvia.getScheduleJJA());
				updatepersonalInformation.setScheduleGG(schvia.getScheduleGG());
				updatepersonalInformation.setScheduleID(schvia.getScheduleID());
				updatepersonalInformation.setScheduleGGA(schvia.getScheduleGGA());
				updatepersonalInformation.setScheduleIAB(schvia.getScheduleIAB());
				updatepersonalInformation.setScheduleCCF(schvia.getScheduleCCF());
				updatepersonalInformation.setTotal(schvia.getTotal());
				wpm.update(updatepersonalInformation);
				return updatepersonalInformation;
			}
		} catch (ObjectBeanPersistenceException e) {
			log.warn("Failed to create a review for Deduction '" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (ObjectBeanManagerException e) {
			log.warn("Failed to create a review for Deduction'" + "----- IT RETURN ------" + "'", e);
			return null;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}

	}

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}

	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}

}