/**
 * 
 */
package com.mootly.wcm.member;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.TwentySixASSecQuesDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.TwentySixASSecQuesDocument;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponent.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.TwentySixAS_SecurityQuestion;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASAdvanceTaxPayment;
import com.mootly.wcm.services.ditws.model.Twenty26ASGenericRecord;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
import com.mootly.wcm.services.ditws.model.Twenty26ASTDSOnSalary;
import com.mootly.wcm.services.ditws.model.Twenty26ASTDSOtherThanSalary;
import com.mootly.wcm.services.ditws.model.Twenty26ASTaxPayment;

@PrimaryBean(primaryBeanClass=TwentySixASSecQuesDocument.class)
@RequiredBeans (requiredBeans={MemberPersonalInformation.class}) 
@FormFields(fieldNames = {"securityQuestion","securityAnswer","securityCheck", "totalAttemptsLeft"})

public class SyncTDSSecurity extends ITReturnComponent {

	private final static Logger log = LoggerFactory.getLogger(SyncTDSSecurity.class);
	private Twenty26ASResponse twenty26asResponse = null;
	private List<Twenty26ASTaxPayment> selfAssessmentList = null;
	List<Twenty26ASAdvanceTaxPayment> advTaxList = null;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		TwentySixASSecQuesDocument parentBean =  (TwentySixASSecQuesDocument)request.getAttribute("parentBean");
		if(parentBean != null){
			if(parentBean.getSecurityCheck() == true){
				String urlToImport26AS = getTargerPath(request, "servicerequest-itr-sync-tds-from-dit.html");
				try {
					response.sendRedirect(urlToImport26AS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int totAttemptsLeft = parentBean.getTotalAttemptsLeft().intValue();
			request.setAttribute("totAttemptsLeft", totAttemptsLeft);
			if(parentBean.getTotalAttemptsLeft() == 0d && parentBean.getSecurityCheck() == false){
				MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
				Map<String,Object> contextMap = new HashMap<String, Object>();
				contextMap.put("pan", memberPersonalInformation.getPAN());
				contextMap.put("mobile", memberPersonalInformation.getMobile());
				contextMap.put("userName", getITRInitData(request).getUserName());
				contextMap.put("emailID", memberPersonalInformation.getEmail());
				sendEmail(request, null, null, "", "twentysixas_security", contextMap);
				response.setRenderPath("jsp/errorpages/attemptsOver.jsp");
				return;
			}
		}

		String error = getPublicRequestParameter(request, "error");
		if(null != error){
			request.setAttribute("error", error);
		}

		Map<String, Map<String, String>> questionsMap=new HashMap<String, Map<String,String>>();
		ResourceBundle secQues= ResourceBundle.getBundle("26AS_securityquestion");
		for(TwentySixAS_SecurityQuestion sq:TwentySixAS_SecurityQuestion.values()){
			if(sq.isActive()){
				Map<String, String> securityQuesMap=new HashMap<String, String>();
				for(int i=1;i<=sq.getSize();i++){
					if(secQues.containsKey(sq.getKey()+".value."+i)){
						securityQuesMap.put("sq.ques"+i, secQues.getString(sq.getKey()+".value."+i));
					}
				}
				questionsMap.put(sq.getDisplayName(), securityQuesMap);
			}
		}
		if(questionsMap!=null){
			request.setAttribute("questionsMap", questionsMap);
		}

		String enableImportData = getITRInitData(request).getWebSiteInfo().getEriEnable26ASImport();
		if (!getITRInitData(request).getChannelInfoWrapper().getIsEriEnabled() || enableImportData == null || enableImportData.equalsIgnoreCase("false")) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Reseller is not authorized to run the import");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Integer totalGetTDSDetail = 0;
		DITResponseDocument ditResponseDocument = (DITResponseDocument) request.getAttribute(DITResponseDocument.class.getSimpleName().toLowerCase());
		if ( ditResponseDocument != null) {
			totalGetTDSDetail = ditResponseDocument.getTotalCountOfOperation("getTDSDetails");
		}
		request.setAttribute("totalGetTDSDetail", totalGetTDSDetail);

		Retrieve26ASInformation retrieve26asInformation = getRetrieve26ASService();
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if (memberPersonalInformation == null) {
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Reseller is not authorized to run the import");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(getITRInitData(request).getWebSiteInfo().getEriUserId(),getITRInitData(request).getWebSiteInfo().getEriPassword(),getITRInitData(request).getWebSiteInfo().getEriCertChain(),getITRInitData(request).getWebSiteInfo().getEriSignature(), memberPersonalInformation.getPAN(), memberPersonalInformation.getDOB() , getITRInitData(request).getFinancialYear().getAssessmentYearForDITSOAPCall(), null ,null);
			selfAssessmentList = new ArrayList<Twenty26ASTaxPayment>();
			advTaxList = new ArrayList<Twenty26ASAdvanceTaxPayment>();
			splitTaxPayment(request,twenty26asResponse, selfAssessmentList, advTaxList);
			setIfIsAlreadyImported(request,twenty26asResponse,selfAssessmentList,advTaxList);
			int totalToBeImported = totalToBeImported(twenty26asResponse,selfAssessmentList,advTaxList);
			boolean isInfoAvail = isInfoAvailable(twenty26asResponse,selfAssessmentList,advTaxList);
			request.setAttribute("twenty26asResponse", twenty26asResponse);
			request.setAttribute("selfAssessmentList", selfAssessmentList);
			request.setAttribute("advTaxList", advTaxList);
			request.setAttribute("totalToBeImported", totalToBeImported);
			request.setAttribute("isInfoAvail", isInfoAvail);
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			log.error("Missing Information",e);
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			log.error("DataMismatchException",e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			log.error("InvalidFormatException",e);
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

	}

	@Override
	public void afterSave(HstRequest request,HstResponse response, FormMap formMap,PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		super.afterSave(request,response,formMap,pageAction);

		String securityQues = null;
		String securityAns = null;
		boolean hasValidAnswer = false;

		if(formMap.getField("securityQuestion") != null){
			securityQues = formMap.getField("securityQuestion").getValue();
		}
		if(formMap.getField("securityAnswer") != null){
			securityAns = formMap.getField("securityAnswer").getValue();
		}

		if(twenty26asResponse != null){
			if(twenty26asResponse.getTwenty26astdsOnSalaries() != null && twenty26asResponse.getTwenty26astdsOnSalaries().size() > 0){
				List<Twenty26ASTDSOnSalary> tdsSalariesDetails = twenty26asResponse.getTwenty26astdsOnSalaries();
				for(Twenty26ASTDSOnSalary twenty26ASTDSOnSalary : tdsSalariesDetails){
					if(StringUtils.isNotBlank(securityQues) && securityQues.equals("What is your TAN?")){
						if(StringUtils.isNotBlank(twenty26ASTDSOnSalary.getTAN()) && securityAns.equals(twenty26ASTDSOnSalary.getTAN())){
							hasValidAnswer = true;
						}
					}
					if(StringUtils.isNotBlank(securityQues) && securityQues.equals("What is name of your deductor?")){
						if(StringUtils.isNotBlank(twenty26ASTDSOnSalary.getEmployerOrDeductorOrCollecterName()) && securityAns.equals(twenty26ASTDSOnSalary.getEmployerOrDeductorOrCollecterName())){
							hasValidAnswer = true;
						}
					}
					if(StringUtils.isNotBlank(securityQues) && securityQues.equals("How much amount is deducted by your employer?")){
						if(StringUtils.isNotBlank(twenty26ASTDSOnSalary.getTotalTDSSal()) && securityAns.equals(twenty26ASTDSOnSalary.getTotalTDSSal())){
							hasValidAnswer = true;
						}
					}
					if(StringUtils.isNotBlank(securityQues) && securityQues.equals("How much amount is credited?")){
						if(StringUtils.isNotBlank(twenty26ASTDSOnSalary.getIncome_chargable_total()) && securityAns.equals(twenty26ASTDSOnSalary.getIncome_chargable_total())){
							hasValidAnswer = true;
						}
					}
				}
			}
		}
		if(hasValidAnswer){
			String urlToImport26AS = getTargerPath(request, "servicerequest-itr-sync-tds-from-dit.html");
			updateDoc(request, hasValidAnswer);
			try {
				response.sendRedirect(urlToImport26AS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!hasValidAnswer){
			String urlToImport26AS = getTargerPath(request, "servicerequest-itr-sync-tds-security.html");
			String urlWithParam = urlToImport26AS+"?error=error.wrong.ans";
			updateDoc(request, hasValidAnswer);
			try {
				response.sendRedirect(urlWithParam);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to create the Target Url 
	 * 
	 * @param request {@link HstRequest}
	 * @param memberHomeRefID {@link String} Reference ID of siteMapItem.
	 * 
	 * @return {@String} Target Path based on Ref ID of siteMapItem
	 * */
	public static String getTargerPath(HstRequest request,String memberHomeRefID){
		//HstLink link=request.getRequestContext().getHstLinkCreator().createByRefId(memberHomeRefID, request.getRequestContext().getResolvedMount().getMount());
		String targetPath=(String) request.getAttribute("scriptName");	
		return targetPath.replaceAll("servicerequest-itr-sync-tds-security.html", memberHomeRefID);
	}

	/**
	 * This method is used to put a check if security question is correct
	 * 
	 * @param request
	 */
	public void updateDoc(HstRequest request, Boolean hasValidAns){

		String path = null;
		Session persistenceSession;
		try {
			persistenceSession = getPersistableSession(request);
			WorkflowPersistenceManager wpm=getWorkflowPersistenceManager(persistenceSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			path=getITRInitData(request).getAbsoluteBasePathToReturnDocuments()+"/"+TwentySixASSecQuesDocument.class.getSimpleName().toLowerCase();
			TwentySixASSecQuesDocument twentySixASSecQuesDocument = (TwentySixASSecQuesDocument) wpm.getObject(path);
			if(hasValidAns){
				twentySixASSecQuesDocument.setSecurityCheck(true);	
			}
			if(twentySixASSecQuesDocument.getTotalAttemptsLeft() != null){
				Double totAttemptsLeft = twentySixASSecQuesDocument.getTotalAttemptsLeft();
				Double nextValue = totAttemptsLeft-1d;
				twentySixASSecQuesDocument.setTotalAttemptsLeft(nextValue);
			}else{
				twentySixASSecQuesDocument.setTotalAttemptsLeft(4d);
			}
			wpm.update(twentySixASSecQuesDocument);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Persistable Session of JCR Repository",e);
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			log.error("Error while updating Document",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get the object at path"+path,e);
		} 
	}

	/**
	 * Split the payments into advanced or self assessment based on date of deposit
	 * List<Twenty26ASTaxPayment> selfAssessmentList = new ArrayList<Twenty26ASTaxPayment>();
			List<Twenty26ASAdvanceTaxPayment> advTaxList = new ArrayList<Twenty26ASAdvanceTaxPayment>();
	 */
	protected void splitTaxPayment(HstRequest request, Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList) {
		if (twenty26asResponse != null && twenty26asResponse.getTwenty26asTaxPayments() != null && twenty26asResponse.getTwenty26asTaxPayments().size() > 0 ) {
			for (Twenty26ASTaxPayment twenty26ASTaxPayment : twenty26asResponse.getTwenty26asTaxPayments()){
				String strDate = twenty26ASTaxPayment.getDateDep();
				Date date = null ;
				DateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd"); 
				GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
				try{
					date = (Date)formatter.parse(strDate);
					cal.setTime(date);
					String newFormattedDateStr = IndianGregorianCalendar.formatDateAsString(cal,IndianGregorianCalendar.indianLocalDateFormStr2);
					if ( cal.after( getITRInitData(request).getFinancialYear().getDateEndFinancialYear()) ) {
						twenty26ASTaxPayment.setDateDep(newFormattedDateStr);
						selfAssessmentList.add(twenty26ASTaxPayment);							
					}
					else {
						Twenty26ASAdvanceTaxPayment twenty26asAdvanceTaxPayment = new Twenty26ASAdvanceTaxPayment(twenty26ASTaxPayment.getAmt(),twenty26ASTaxPayment.getSrlNoOfChaln(),twenty26ASTaxPayment.getBSRCode(),twenty26ASTaxPayment.getDateDep());
						twenty26asAdvanceTaxPayment.setDateDep(newFormattedDateStr);
						advTaxList.add(twenty26asAdvanceTaxPayment);
					}
				}
				catch(Exception e){
					log.info("calendar error"+e);
				}
			}
		}
	}

	protected void setIfIsAlreadyImported(HstRequest request,Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList) {
		int totalForImport = 0;
		//FORM 16
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());		
		if (formSixteenDocument != null && formSixteenDocument.getFormSixteenDetailList() != null) {
			for (FormSixteenDetail formSixteenDetail:formSixteenDocument.getFormSixteenDetailList()) {
				if (!formSixteenDetail.isImportedFromDIT() || formSixteenDetail.getEmploye_category() == null || formSixteenDetail.getGross_a() == null || formSixteenDetail.getDed_ent_1() == null) continue;
				for (Twenty26ASTDSOnSalary twenty26astdsOnSalary:twenty26asResponse.getTwenty26astdsOnSalaries()) {
					if (Double.valueOf(twenty26astdsOnSalary.getIncChrgSal()).equals(formSixteenDetail.getGross_a()) && Double.valueOf(twenty26astdsOnSalary.getTotalTDSSal()).equals(formSixteenDetail.getDed_ent_1()) ) {
						twenty26astdsOnSalary.setHasAlreadyBeenImported(true);
						break;
					}
				}
			}
		}		

		//TDS from Others
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) request.getAttribute(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		if (tdsFromothersDocument != null && tdsFromothersDocument.getTdsSalaryDetailList() != null) {
			for (TdsOthersDetail tdsOthersDetail:tdsFromothersDocument.getTdsSalaryDetailList()) {
				if (!tdsOthersDetail.isImportedFromDIT() || tdsOthersDetail.getTan_Deductor() == null || tdsOthersDetail.getP_Amount() == null) continue;
				for (Twenty26ASTDSOtherThanSalary twenty26astdsOtherThanSalary:twenty26asResponse.getTwenty26astdsOtherThanSalaries()) {
					if (twenty26astdsOtherThanSalary.getTAN().equals(tdsOthersDetail.getTan_Deductor()) && Double.valueOf(twenty26astdsOtherThanSalary.getTotTDSOnAmtPaid()).equals(tdsOthersDetail.getP_Amount()) ) {
						twenty26astdsOtherThanSalary.setHasAlreadyBeenImported(true);
						break;
					}
				}
			}
		}	
		// END //TDS from Others

		//Now for Advance Tax and Self Assessment Tax
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) request.getAttribute(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());		
		if (selfAssesmetTaxDocument != null && selfAssesmetTaxDocument.getSelfAssesmentDetailList() != null) {
			for (SelfAssesmentTaxDetail selfAssesmentTaxDetail:selfAssesmetTaxDocument.getSelfAssesmentDetailList()) {
				if (selfAssesmentTaxDetail.isImportedFromDIT() == null && !selfAssesmentTaxDetail.isImportedFromDIT() || selfAssesmentTaxDetail.getP_Amount() == null || selfAssesmentTaxDetail.getP_Date() == null) continue;
				for (Twenty26ASTaxPayment selfAssessmentPayment: selfAssessmentList) {
					//check if this is after the financial year thenits self ass before its adv		
					String strDateToCompare = IndianGregorianCalendar.formatDateAsString(selfAssesmentTaxDetail.getP_Date(), IndianGregorianCalendar.indianLocalDateFormStr2);
					if ( Double.valueOf(selfAssessmentPayment.getAmt()).equals(selfAssesmentTaxDetail.getP_Amount()) && selfAssessmentPayment.getDateDep().equals(strDateToCompare) ) {
						selfAssessmentPayment.setHasAlreadyBeenImported(true);
						break;
					}
				}	
			}
		}


		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) request.getAttribute(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		if (advanceTaxDocument != null && advanceTaxDocument.getAdvanceTaxDetailList() != null) {
			for (AdvanceTaxDetail advanceTaxDetail:advanceTaxDocument.getAdvanceTaxDetailList()) {
				if (advanceTaxDetail.isImportedFromDIT() == null && !advanceTaxDetail.isImportedFromDIT() || advanceTaxDetail.getP_Amount() == null || advanceTaxDetail.getP_Date() == null) continue;
				for (Twenty26ASAdvanceTaxPayment advanceTaxPayment : advTaxList) {
					//check if this is after the financial year thenits self ass before its adv		
					String strDateToCompare = IndianGregorianCalendar.formatDateAsString(advanceTaxDetail.getP_Date(), IndianGregorianCalendar.indianLocalDateFormStr2);
					if ( Double.valueOf(advanceTaxPayment.getAmt()).equals(advanceTaxDetail.getP_Amount()) && advanceTaxPayment.getDateDep().equals(strDateToCompare) ) {
						advanceTaxPayment.setHasAlreadyBeenImported(true);
						break;
					}
				}	
			}
		}		
	}

	protected int totalToBeImported(Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList) {
		int totalToBeImported = 0 ;
		if (twenty26asResponse == null) return 0;

		if (twenty26asResponse.getTwenty26astdsOnSalaries() != null ) {
			for (Twenty26ASGenericRecord tGenericRecord:twenty26asResponse.getTwenty26astdsOnSalaries()) {
				if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
			}
		}

		if (twenty26asResponse.getTwenty26astdsOtherThanSalaries() != null ) {
			for (Twenty26ASGenericRecord tGenericRecord:twenty26asResponse.getTwenty26astdsOtherThanSalaries()) {
				if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
			}
		}

		if (selfAssessmentList != null ) {
			for (Twenty26ASGenericRecord tGenericRecord: selfAssessmentList) {
				if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
			}
		}

		if (advTaxList != null ) {
			for (Twenty26ASGenericRecord tGenericRecord : advTaxList) {
				if (!tGenericRecord.getHasAlreadyBeenImported()) totalToBeImported++;
			}
		}

		return totalToBeImported;
	}

	protected boolean isInfoAvailable(Twenty26ASResponse twenty26asResponse,List<Twenty26ASTaxPayment> selfAssessmentList,List<Twenty26ASAdvanceTaxPayment> advTaxList){	
		boolean isInfoAvail = false;	

		if (twenty26asResponse == null) return false;

		if (twenty26asResponse.getTwenty26astdsOnSalaries() != null ) {
			isInfoAvail = true;
		}	
		if (twenty26asResponse.getTwenty26astdsOtherThanSalaries() != null ) {
			isInfoAvail = true;
		}	
		if (selfAssessmentList != null ) {
			isInfoAvail = true;
		}		
		if (advTaxList != null ) {
			isInfoAvail = true;
		}
		return isInfoAvail;
	}
}

