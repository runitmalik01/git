/*
 * In this class we are creating a document for storing value of Rebate U/S 89 details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberRebateSectionEightyNine;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.PreviousYearsSalaryInfo;
import com.mootly.wcm.components.ITReturnComponent;

@PrimaryBean(primaryBeanClass=MemberRebateSectionEightyNine.class)
@ChildBean(childBeanClass=PreviousYearsSalaryInfo.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,SalaryIncomeDocument.class,HouseProperty.class,CapitalAssetDocument.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"prevyear","previncome","prevarrears","prevtotal","prevtaxontotal","prevtaxincome","prevtaxdiffer","salaryincome",
		"totalArrears","totalincomewarrears","taxsalaryincome","taxarrears","diff","taxRelief","computedtabletotal"})
@RequiredFields(fieldNames={"prevyear","previncome","prevarrears"})
public class RebateSection89 extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(RebateSection89.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
		log.info("Member Rebate Section 89 page");
		}
   		/*request.getAttribute("salaryincomedocument");
   		int decimalPlace = 2;
   		Calculations cal=new Calculations();
	    float fSalaryIncome = cal.fetchSalaryIncomeValue(request,response);
		// fetching OtherIncome value
		float fOtherIncome = cal.fetchOtherIncomeValue(request,response);
		//fetching house property values
		float fHouseProperty = cal.fetchHousePropertyValue(request,response);
		//fetching capital gain values
		float fCapitalGain = cal.fetchCapitalGainValue(request,response);
		// fetching Deduction  value
		float fDeduction = cal.fetchDeductionsValue(request,response);
		// fetching Losses value
		float fAdjustLosses = cal.fetchLossesValue(request,response);
		// fetching Securities value
		float fSecurities = cal.fetchSecurityValue(request,response);

		float fTotal= fSalaryIncome + fOtherIncome + fHouseProperty + fCapitalGain + fSecurities;
		if(log.isInfoEnabled()){
		log.info("Total of all"+fTotal);
		log.info("big decimal"+BigDecimal.valueOf(fTotal).toPlainString());
		}
		float fGrossTotal = fTotal-fAdjustLosses;
		float fTaxableIncome= fGrossTotal-fDeduction;
		request.setAttribute("Taxable", BigDecimal.valueOf(fTaxableIncome).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());
		//float fIncomeTax=(float)Math.round(fTaxableIncome*(0.1f));
		// for fetching income tax according to slab rates
		float fIncomeTax= cal.fetchIncomeTaxValue(request,response,fTaxableIncome);
		float fEduCess=(float) Math.round(fIncomeTax*0.03f);
		float fIncomeTaxEduCess=fIncomeTax + fEduCess ;
		request.setAttribute("IncomeTaxEduCess", BigDecimal.valueOf(fIncomeTaxEduCess).setScale(decimalPlace,BigDecimal.ROUND_UP).toPlainString());*/
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}



	/*public void doBeforeRenderOld(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Rebate Section 89 Page");
		String pan=(String)request.getSession().getAttribute("pan");
		String filing_year=(String)request.getSession().getAttribute("filing_year");	
		Member member=(Member)request.getSession().getAttribute("user");
		if(member!=null){
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			try {
				if(pan!=null){
					String path=ContentStructure.getRebateSection89(pan, filing_year, modusername);
					MemberRebateSectionEightyNine document=(MemberRebateSectionEightyNine)getObjectBeanManager(request).getObject(path);
					request.setAttribute("document", document);
					List<PreviousYearsSalaryInfo> previnfo=document.getPrevSalaryInfoList();
					if(previnfo!=null){
						if(previnfo.size()!=0){
							for(int i=0;i<previnfo.size();i++){
								String strprev="prev"+i;
								log.info(strprev);
								PreviousYearsSalaryInfo objprev=(PreviousYearsSalaryInfo)previnfo.get(i);
								request.setAttribute(strprev, objprev);
							}
						}
					}
					String spersoanlpath=ContentStructure.getPersonalDocumentPath(pan, filing_year, modusername);
					MemberPersonalInformation objpersonal=(MemberPersonalInformation)getObjectBeanManager(request).getObject(spersoanlpath);
					/*int age=MemberAge.MemberAgeCalculate(objpersonal.getDOB());
					log.info("this is age of member"+age);
					request.setAttribute("age",age);*/
					/*request.setAttribute("gender",objpersonal.getSex());
					request.setAttribute("resistatus",objpersonal.getResident());
					request.setAttribute("payer",objpersonal.getFilingStatus());
					request.setAttribute("cbassyear", filing_year);*/
					/*SalaryIncome objsalincom=new SalaryIncome();
					ArrayList<SalaryIncomeDocument> arrLSalaryIncomeDocument =  objsalincom.fetchSalaryIncomeDocument(request, response);
					if(null != arrLSalaryIncomeDocument){
						float sumsal=0.0f;
						for(int i=0;i<arrLSalaryIncomeDocument.size();i++){
							SalaryIncomeDocument objsaldoc=arrLSalaryIncomeDocument.get(i);
							sumsal=sumsal+Float.parseFloat(objsaldoc.getGross_salary());
						}
					}*/
					/*request.setAttribute("salaryincome", "230000");
					String path3=ContentStructure.getOtherIncomePathUpdate(request, modusername);
					OtherSourceIncome objotherincome=(OtherSourceIncome)getObjectBeanManager(request).getObject(path3);
					if(objotherincome!=null){
						request.setAttribute("otherincome",objotherincome.getTaxable_income());	
					}else{
						request.setAttribute("otherincome","30000");
					}
				}
			}catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void doActionOld(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.info("test page at do action method");
		String salaryincome=GoGreenUtil.getEscapedParameter(request, "salaryincome");
		String otherincome=GoGreenUtil.getEscapedParameter(request, "otherincome");
		String arrears=GoGreenUtil.getEscapedParameter(request, "arrears");
		String totalincomearrears=GoGreenUtil.getEscapedParameter(request, "totalincomearrears");
		String taxsalaryincome=GoGreenUtil.getEscapedParameter(request, "taxsalaryincome");
		String taxarrears=GoGreenUtil.getEscapedParameter(request, "taxarrears");
		String diff=GoGreenUtil.getEscapedParameter(request, "diff");

		String prevyear1=GoGreenUtil.getEscapedParameter(request, "prevyear1");
		String income1=GoGreenUtil.getEscapedParameter(request, "income1");
		String arrears1=GoGreenUtil.getEscapedParameter(request, "arrears1");
		String total1=GoGreenUtil.getEscapedParameter(request, "total1");
		String taxontotal1=GoGreenUtil.getEscapedParameter(request, "taxontotal1");
		String taxincome1=GoGreenUtil.getEscapedParameter(request, "taxincome1");
		String taxdiff1=GoGreenUtil.getEscapedParameter(request, "taxdiff1");

		String prevyear2=GoGreenUtil.getEscapedParameter(request, "prevyear2");
		String income2=GoGreenUtil.getEscapedParameter(request, "income2");
		String arrears2=GoGreenUtil.getEscapedParameter(request, "arrears2");
		String total2=GoGreenUtil.getEscapedParameter(request, "total2");
		String taxontotal2=GoGreenUtil.getEscapedParameter(request, "taxontotal2");
		String taxincome2=GoGreenUtil.getEscapedParameter(request, "taxincome2");
		String taxdiff2=GoGreenUtil.getEscapedParameter(request, "taxdiff2");

		String prevyear3=GoGreenUtil.getEscapedParameter(request, "prevyear3");
		String income3=GoGreenUtil.getEscapedParameter(request, "income3");
		String arrears3=GoGreenUtil.getEscapedParameter(request, "arrears3");
		String total3=GoGreenUtil.getEscapedParameter(request, "total3");
		String taxontotal3=GoGreenUtil.getEscapedParameter(request, "taxontotal3");
		String taxincome3=GoGreenUtil.getEscapedParameter(request, "taxincome3");
		String taxdiff3=GoGreenUtil.getEscapedParameter(request, "taxdiff3");

		String computedtabletotal=GoGreenUtil.getEscapedParameter(request, "computedtabletotal");
		String taxpaid=GoGreenUtil.getEscapedParameter(request, "taxpaid");

		List<PreviousYearsSalaryInfo> previnfo = new ArrayList<PreviousYearsSalaryInfo>();

		PreviousYearsSalaryInfo objprevinfo1=new PreviousYearsSalaryInfo();
		objprevinfo1.setPrevArrears(arrears1);
		objprevinfo1.setPrevIncome(income1);
		objprevinfo1.setPrevTaxDiff(taxdiff1);
		objprevinfo1.setPrevTaxIncome(taxincome1);
		objprevinfo1.setPrevTaxTotalIncome(taxontotal1);
		objprevinfo1.setPrevTotalIncome(total1);
		objprevinfo1.setPrevYear(prevyear1);
		previnfo.add(objprevinfo1);

		PreviousYearsSalaryInfo objprevinfo2=new PreviousYearsSalaryInfo();
		objprevinfo2.setPrevArrears(arrears2);
		objprevinfo2.setPrevIncome(income2);
		objprevinfo2.setPrevTaxDiff(taxdiff2);
		objprevinfo2.setPrevTaxIncome(taxincome2);
		objprevinfo2.setPrevTaxTotalIncome(taxontotal2);
		objprevinfo2.setPrevTotalIncome(total2);
		objprevinfo2.setPrevYear(prevyear2);
		previnfo.add(objprevinfo2);

		PreviousYearsSalaryInfo objprevinfo3=new PreviousYearsSalaryInfo();
		objprevinfo3.setPrevArrears(arrears3);
		objprevinfo3.setPrevIncome(income3);
		objprevinfo3.setPrevTaxDiff(taxdiff3);
		objprevinfo3.setPrevTaxIncome(taxincome3);
		objprevinfo3.setPrevTaxTotalIncome(taxontotal3);
		objprevinfo3.setPrevTotalIncome(total3);
		objprevinfo3.setPrevYear(prevyear3);
		previnfo.add(objprevinfo3);

		MemberRebateSectionEightyNine reb89=new MemberRebateSectionEightyNine();
		reb89.setSalaryIncome(salaryincome);
		reb89.setOtherIncome(otherincome);
		reb89.setArrears(arrears);
		reb89.setTotalIncomeArrears(totalincomearrears);
		reb89.setTaxSalaryIncome(taxsalaryincome);
		reb89.setTaxArrears(taxarrears);
		reb89.setDiff(diff);
		reb89.setComputedTableTotal(computedtabletotal);
		reb89.setTaxRelief(taxpaid);
		reb89.setPrevSalaryInfoList(previnfo);
		createMemberRebateSection89(request,reb89);
		try{
			response.sendRedirect(UrlUtility.RebateSection90);
		}catch(IOException e){
			log.warn("This is redirection to Rebate u/s 90",e);
		}		
	}
	/**
	 * Method to Create & Update the Member Rebate Section U/S 89 Document
	 * @param HstRequest
	 * @param String
	 * @return String returns the form to create method.
	 * @throws 
	 * @author Priyank
	 */
	/*public void createMemberRebateSection89(HstRequest request,MemberRebateSectionEightyNine reb89){
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			String pan=(String)request.getSession().getAttribute("pan");
			String filing_year=(String)request.getSession().getAttribute("filing_year");
			log.info("filing_year"+filing_year);
			log.info("pan"+pan);
			Member member=(Member)request.getSession().getAttribute("user");
			String username=member.getUserName().trim();
			String modusername=username.replaceAll("@", "-at-").trim();
			/*Create the path to Save Document in the Repository
			 * */
			/*log.info("this is user"+username);
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request, pan, filing_year, modusername);
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */
		/*	String updatePersonalReturnPath=ContentStructure.getRebateSection89(pan,filing_year,modusername);
			MemberRebateSectionEightyNine updaterebateSection89 = (MemberRebateSectionEightyNine) wpm.getObject(updatePersonalReturnPath);
			if(updaterebateSection89==null){
				final String personalReturnPath = wpm.createAndReturn(itReturnFolderPath,MemberRebateSectionEightyNine.NAMESPACE ,  MemberRebateSectionEightyNine.NODE_NAME, true);
				/*
		HippoFolder hippoFolder = (HippoFolder) wpm.getObject(itReturnFolderPath);
		List<HippoTranslation> hippoTranslations = hippoFolder.getChildBeansByName("hippo:translation");
		if (hippoTranslations != null && hippoTranslations.size() > 0) {
			for (HippoTranslation translation:hippoTranslations) {
				if (translation.getProperty("locale","").equals("en")) {
				}
			}
		}
				 */	
				/*MemberRebateSectionEightyNine
				 *getObject method get the object at passed path in Repository.
				 * */
			/*	MemberRebateSectionEightyNine rebateSection89 = (MemberRebateSectionEightyNine) wpm.getObject(personalReturnPath);

				// update content properties
				if (rebateSection89 != null) {
					log.info("PAN NUKMBER"+pan);
					rebateSection89.setArrears(reb89.getArrears());
					rebateSection89.setComputedTableTotal(reb89.getComputedTableTotal());
					rebateSection89.setDiff(reb89.getDiff());
					rebateSection89.setOtherIncome(reb89.getOtherIncome());
					rebateSection89.setSalaryIncome(reb89.getSalaryIncome());
					rebateSection89.setTaxArrears(reb89.getTaxArrears());
					rebateSection89.setTaxRelief(reb89.getTaxRelief());
					rebateSection89.setTaxSalaryIncome(reb89.getTaxSalaryIncome());
					rebateSection89.setTotalIncomeArrears(reb89.getTotalIncomeArrears());
					rebateSection89.setPrevSalaryInfoList(reb89.getPrevSalaryInfoList());
					// update now  
					wpm.update(rebateSection89);


				} else {
					log.info("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", MemberRebateSectionEightyNine.NODE_NAME, personalReturnPath);
					GoGreenUtil.refreshWorkflowManager(wpm);

				}
			}else{
				updaterebateSection89.setArrears(reb89.getArrears());
				updaterebateSection89.setComputedTableTotal(reb89.getComputedTableTotal());
				updaterebateSection89.setDiff(reb89.getDiff());
				updaterebateSection89.setOtherIncome(reb89.getOtherIncome());
				updaterebateSection89.setSalaryIncome(reb89.getSalaryIncome());
				updaterebateSection89.setTaxArrears(reb89.getTaxArrears());
				updaterebateSection89.setTaxRelief(reb89.getTaxRelief());
				updaterebateSection89.setTaxSalaryIncome(reb89.getTaxSalaryIncome());
				updaterebateSection89.setTotalIncomeArrears(reb89.getTotalIncomeArrears());
				updaterebateSection89.setPrevSalaryInfoList(reb89.getPrevSalaryInfoList());
				wpm.update(updaterebateSection89);


			}
		} catch (ObjectBeanPersistenceException e) {
			log.error("Failed to create a review for personal '" + "----- IT RETURN ------" + "'", e);

		} catch (ObjectBeanManagerException e) {
			log.error("Failed to create a review for personal'" + "----- IT RETURN ------" + "'", e);

		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {

			wf.publish();
		}
	}*/

}
