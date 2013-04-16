package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;
import javax.transaction.SystemException;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.OtherSourceIncome;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

public class OtherIncome extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(OtherIncome.class);
	private static final String GOV_INCOME = "Gov_income";
	private static final String KISSAN_PATRA = "Kissan_patra";
	private static final String BANK_DATAIL = "Bank_detail";
	private static final String IDIRA_PATRA= "Indira_patra";
	private static final String ERRORS = "errors";
	private static final String INT_NSC = "Int_nsc";
	private static final String OTHER_INTEREST = "Other_interest";
	private static final String TOTAL_INTEREST = "Total_interest";
	private static final String FAMILY_PENSION = "Family_pension";
	private static final String DIVIDENDS = "Dividends";
	private static final String LOTTERY_HORSE_INCOME = "Lottery_horse_income";
	private static final String INCOME_RENT_MACHINE = "Income_rent_machine";
	private static final String OTHER_INCOME = "Other_income";
	private static final String DEDUCTION_57 = "Deduction_57";
	private static final String TOTALOTHER_INCOME = "TotalOther_income";
	private static final String FAMILYPENSION_DEDUCTION = "Familypension_deduction";
	private static final String DEPRECIATION = "Depreciation";
	private static final String TOTAL_EXPENSES = "Total_expenses";
	private static final String DIVIDENDS_UTI = "Dividends_uti";
	private static final String INTEREST_INCOME = "Interest_income";
	private static final String DIVIDENDS_MUTUALFUND = "Dividends_mutualfund";
	private static final String AGRICULTURE_INCOME = "Agriculture_income";
	private static final String DIVIDENDS_INDIAN_COMPANIES = "Dividends_indian_companies";
	private static final String TOTAL_TAXFREE_INCOME = "Total_taxfree_income";
	private static final String TAXABLE_INCOME = "Taxable_income";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Start otherincome Page");
		ArrayList arrLOtherIncomeDocument = fetchOtherIncomeDocument(request,response);

		if(null != arrLOtherIncomeDocument){

			if(arrLOtherIncomeDocument.size()>= 1){
				log.info("doBeforeRenderinside i0000000000000000000000000000000000000000f");
				request.setAttribute("arrLOtherIncomeDocument", arrLOtherIncomeDocument);

			}
		}



		request.setAttribute("pageName", "startotherincome");	
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(GOV_INCOME, request.getParameterValues(GOV_INCOME));
		request.setAttribute(KISSAN_PATRA, request.getParameterValues(KISSAN_PATRA));
		request.setAttribute(BANK_DATAIL, request.getParameterValues(BANK_DATAIL));
		request.setAttribute(TOTAL_INTEREST, request.getParameterValues(TOTAL_INTEREST));
		request.setAttribute(OTHER_INTEREST, request.getParameterValues(OTHER_INTEREST));
		request.setAttribute(LOTTERY_HORSE_INCOME, request.getParameterValues(LOTTERY_HORSE_INCOME));
		request.setAttribute(INT_NSC, request.getParameterValues(INT_NSC));
		request.setAttribute(FAMILY_PENSION, request.getParameterValues(FAMILY_PENSION));
		request.setAttribute(INCOME_RENT_MACHINE, request.getParameterValues(INCOME_RENT_MACHINE));
		request.setAttribute(DEDUCTION_57, request.getParameterValues(DEDUCTION_57));
		request.setAttribute(OTHER_INCOME, request.getParameterValues(OTHER_INCOME));
		request.setAttribute(TOTALOTHER_INCOME, request.getParameterValues(TOTALOTHER_INCOME));
		request.setAttribute(IDIRA_PATRA, request.getParameterValues(IDIRA_PATRA));
		request.setAttribute(DIVIDENDS, request.getParameterValues(DIVIDENDS));
		request.setAttribute(TOTAL_EXPENSES, request.getParameterValues(TOTAL_EXPENSES));
		request.setAttribute(DEPRECIATION, request.getParameterValues(DEPRECIATION));
		request.setAttribute(TAXABLE_INCOME, request.getParameterValues(TAXABLE_INCOME));
		request.setAttribute(DIVIDENDS_UTI, request.getParameterValues(DIVIDENDS_UTI));
		request.setAttribute(INTEREST_INCOME, request.getParameterValues(INTEREST_INCOME));
		request.setAttribute(TOTAL_TAXFREE_INCOME, request.getParameterValues(TOTAL_TAXFREE_INCOME));
		request.setAttribute(DIVIDENDS_INDIAN_COMPANIES, request.getParameterValues(DIVIDENDS_INDIAN_COMPANIES));
		request.setAttribute(AGRICULTURE_INCOME, request.getParameterValues(AGRICULTURE_INCOME));
		request.setAttribute(DIVIDENDS_MUTUALFUND, request.getParameterValues(DIVIDENDS_MUTUALFUND));
		request.setAttribute(FAMILYPENSION_DEDUCTION, request.getParameterValues(FAMILYPENSION_DEDUCTION));
		log.info("This is Start otherincome Page###############################%%%%%%%%%%%%");
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

		/*	String Screen_Mode=GoGreenUtil.getEscapedParameter(request, "screenMode");
		// redirect to next page when user clicks on "next" button
		   if(Screen_Mode.equals("NEXTSCREEN")){
			   log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxx nextscreen modeeeeeeeeeeeee");
				try {
					String sNextScreen = GoGreenUtil.getNextScreen(request, UrlUtility.OtherIncome); 
					log.info("SalaryIncome-doAsNextScreenction()-->sNextScreen:"+sNextScreen);
					response.sendRedirect(sNextScreen);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					   log.warn("SalaryIncome-doAction()-->error in redirection:-"+e);
				} 	
			}
		 */
		//get all parameter of form

		String Gov_income=GoGreenUtil.getEscapedParameter(request,"Gov_income");
		String Kissan_patra=GoGreenUtil.getEscapedParameter(request, "Kissan_patra");
		String Total_interest=getPublicRequestParameter(request, "Total_interest");
		String Other_interest=GoGreenUtil.getEscapedParameter(request,"Other_interest");
		String Lottery_horse_income=GoGreenUtil.getEscapedParameter(request,"Lottery_horse_income" );
		String Int_nsc=GoGreenUtil.getEscapedParameter(request, "Int_nsc");
		String Family_pension=GoGreenUtil.getEscapedParameter(request, "Family_pension");
		String Indira_patra=GoGreenUtil.getEscapedParameter(request, "Indira_patra");
		String Income_rent_machine=GoGreenUtil.getEscapedParameter(request,"Income_rent_machine");
		String Deduction_57=GoGreenUtil.getEscapedParameter(request, "Deduction_57");
		String Other_income=GoGreenUtil.getEscapedParameter(request, "Other_income");
		String TotalOther_income=GoGreenUtil.getEscapedParameter(request, "TotalOther_income");
		String Bank_detail=GoGreenUtil.getEscapedParameter(request, "Bank_detail");
		String Dividends=GoGreenUtil.getEscapedParameter(request, "Dividends");
		String Familypension_deduction=GoGreenUtil.getEscapedParameter(request, "Familypension_deduction");
		String Depreciation = GoGreenUtil.getEscapedParameter(request, "Depreciation");
		String Total_expenses=GoGreenUtil.getEscapedParameter(request, "Total_expenses");
		String Dividends_uti =GoGreenUtil.getEscapedParameter(request, "Dividends_uti");
		String Interest_income =GoGreenUtil.getEscapedParameter(request, "Interest_income");
		String Dividends_mutualfund =GoGreenUtil.getEscapedParameter(request, "Dividends_mutualfund");
		String Agriculture_income =GoGreenUtil.getEscapedParameter(request, "Agriculture_income");
		String Dividends_indian_companies =GoGreenUtil.getEscapedParameter(request, "Dividends_indian_companies");
		String Total_taxfree_income =GoGreenUtil.getEscapedParameter(request, "Total_taxfree_income");
		String Taxable_income =GoGreenUtil.getEscapedParameter(request, "Taxable_income");


		/*get the Member object
		 * To fetch the Login User details
		 * */ 
		Member member=(Member)request.getSession().getAttribute("user");
		log.info("i have member");
		if(member!=null){	
			//check for validation
			List<String> errors = new ArrayList<String>();
			System.out.print("size"+errors.size());
			if (errors.size()!=0){
				response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
				response.setRenderParameter(Kissan_patra, Kissan_patra);
				response.setRenderParameter(Gov_income, Gov_income);    
				response.setRenderParameter(Dividends,Dividends );
				response.setRenderParameter(Bank_detail, Bank_detail);

				log.warn("i am at error size.............");
				return;
			}
			if (errors == null || errors.size() == 0) 
			{
				/*Create the MemberPersoanlInformation Document Object
				 * Set the Values get Int_nsc Form
				 * */
				OtherSourceIncome objotherincome = new OtherSourceIncome();
				log.warn("No errors");
				objotherincome.setTotal_interest(Total_interest);
				objotherincome.setDeduction_57(Deduction_57);
				objotherincome.setOther_interest(Other_interest);
				objotherincome.setIndira_patra(Indira_patra);
				objotherincome.setIncome_rent_machine(Income_rent_machine);
				objotherincome.setGov_income(Gov_income);
				objotherincome.setOther_income(Other_income);
				objotherincome.setDividends(Dividends);
				objotherincome.setLottery_horse_income(Lottery_horse_income);
				objotherincome.setBank_detail(Bank_detail);
				objotherincome.setFamily_pension(Family_pension);
				objotherincome.setFamilypension_deduction(Familypension_deduction);
				objotherincome.setInt_nsc(Int_nsc);
				objotherincome.setKissan_patra(Kissan_patra);
				objotherincome.setTaxable_income(Taxable_income);
				objotherincome.setTotalOther_income(TotalOther_income);
				objotherincome.setDepreciation(Depreciation);
				objotherincome.setTotal_taxfree_income(Total_taxfree_income);
				objotherincome.setDividends_indian_companies(Dividends_indian_companies);
				objotherincome.setAgriculture_income(Agriculture_income);
				objotherincome.setDividends_mutualfund(Dividends_mutualfund);
				objotherincome.setInterest_income(Interest_income);
				objotherincome.setDividends_uti(Dividends_uti);
				objotherincome.setTotal_expenses(Total_expenses);

				createotherincomeform(request,objotherincome);
			}
			try {

				// after creating document it redirect the page to otherincome

				response.sendRedirect(UrlUtility.Adjustmentoflosses);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				log.warn("can't redirect");
			}
		}
	}
	/**
	 * here we are setting a path for updating salary income of employer in original/salaryincome/tan# 
	 * 
	 * @param HstRequest
	 * @param String
	 * @return String returns otherincomeform
	 * @throws 
	 * @author Abhishek
	 * */
	private OtherSourceIncome createotherincomeform(HstRequest request,OtherSourceIncome objotherincome) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			Member member=(Member)request.getSession().getAttribute("user");
			/*Create the path to Save Document in the Repository
			 * */
			final String itReturnFolderPath = ContentStructure.getMemberotherincomepath(request,member.getUserName());
			/*CreateAndReturn method is used to Create the Document(Node) Of name NODE_NAME
			 * NAMESPACE determine the Type of Node with Document Template
			 * Also return the path of that Document
			 * */ 
			System.out.println("i am creating path for"+itReturnFolderPath);
			final String itReturnPath = wpm.createAndReturn(itReturnFolderPath,OtherSourceIncome.NAMESPACE ,  OtherSourceIncome.NODE_NAME, true);
			System.out.println("i am creating path for return>>>>>>>>>>>>>"+itReturnPath);

			log.error("this is path of create and return method"+itReturnPath);
			log.warn("Updation of memberPersoanldocuemnt");
			//MemberPersoanlInformation
			//getObject method get the object at passed path in Repository.
			OtherSourceIncome otherincome = (OtherSourceIncome) wpm.getObject(itReturnPath);
			// update content properties
			if (otherincome != null) {

				otherincome.setKissan_patra(objotherincome.getKissan_patra());
				otherincome.setTotal_interest(objotherincome.getTotal_interest());
				otherincome.setDeduction_57(objotherincome.getDeduction_57());
				otherincome.setOther_interest(objotherincome.getOther_interest());
				otherincome.setBank_detail(objotherincome.getBank_detail());
				otherincome.setInt_nsc(objotherincome.getInt_nsc());
				otherincome.setIndira_patra(objotherincome.getIndira_patra());
				otherincome.setGov_income(objotherincome.getGov_income());
				otherincome.setFamily_pension(objotherincome.getFamily_pension());
				otherincome.setDividends(objotherincome.getDividends());
				otherincome.setLottery_horse_income(objotherincome.getLottery_horse_income());
				otherincome.setIncome_rent_machine(objotherincome.getIncome_rent_machine());
				otherincome.setOther_income(objotherincome.getOther_income());
				otherincome.setDepreciation(objotherincome.getDepreciation());
				otherincome.setTotal_expenses(objotherincome.getTotal_expenses());
				otherincome.setTaxable_income(objotherincome.getTaxable_income());
				otherincome.setTotalOther_income(objotherincome.getTotalOther_income());
				otherincome.setFamilypension_deduction(objotherincome.getFamilypension_deduction());
				otherincome.setDividends_uti(objotherincome.getDividends_uti());
				otherincome.setTotal_taxfree_income(objotherincome.getTotal_taxfree_income());
				otherincome.setInterest_income(objotherincome.getInterest_income());
				otherincome.setDividends_mutualfund(objotherincome.getDividends_mutualfund());
				otherincome.setAgriculture_income(objotherincome.getAgriculture_income());
				otherincome.setDividends_indian_companies(objotherincome.getDividends_indian_companies());
				// update now           `
				wpm.update(otherincome);

				//Member otherincome Document
				return otherincome;

			} else {
				log.info("Failed to add document '{}': could not retrieve Review bean for node '{}'.", OtherSourceIncome.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return otherincome;
			}
		} catch (Exception e) {
			log.warn("Failed to create document for otherincome '" + "----- IT RETURN ------" + "'", e);
			return null;
		} finally {
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


	/**
	 * This method is used to fetch Other Income  Document from Repository
	 * when page is loaded
	 * @param HstRequest 
	 * @param con Connection object required for transaction. If value of the connection 
	 * object is null the method will create a new connection object. 
	 * @return fetched data from repository
	 * @throws SystemException System Exception thrown by the system
	 * @author Abhishek
	 */
	@SuppressWarnings({ "deprecation", "unused" })

	private ArrayList<OtherSourceIncome>  fetchOtherIncomeDocument(HstRequest request,HstResponse response) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		ArrayList<OtherSourceIncome> arrlOtherIncome = null;
		WorkflowPersistenceManager wpm;
		log.info("inside fetchSalaryIncomeDocument--->before try:-");
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());

			Member member=(Member)request.getSession().getAttribute("user");
			//SalaryIncomeDocument sid1=(SalaryIncomeDocument)request.getSession().getAttribute("user");
			// SalaryIncomeDocument sid = new SalaryIncomeDocument();
			log.info("inside fetchSalaryIncomeDocument--->member:-"+member);
			if(member!=null){

				log.info("fetchhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
				final String itReturnFolderPath = ContentStructure.getotherincomePathFetch(request,member.getUserName());
				log.info("tttttttttttttttttttttttttttttttttttttttttttttttttttttt");

				log.info("inside fetchSalaryIncomeDocument---> itReturnFolderPath:-"+itReturnFolderPath);
				arrlOtherIncome = new ArrayList<OtherSourceIncome>();
				log.info("after array listttttttttttt");
				OtherSourceIncome objOtherIncomeDocument = null;
				log.info("after objjjjjjjjjjjjsalaryincome documenttttttttttttttttt");
				String itReturnFolderPathTAN = null;
				String sTAN = null;
				log.info("after objjjjjjjjjjjjsalaryincome documenttttttttttttttttt");
				Session session = request.getRequestContext().getSession();
				log.info("after taking session........................");
				Node node = (Node)session.getNode(itReturnFolderPath);
				log.info("gggggggggggggggggg"+node);
				log.warn(node.getName());
				log.info("inside session of fetch");
				NodeIterator nodeiterator=(NodeIterator)node.getNodes();
				log.info("after node iteratorooooooooooooooooooo");
				log.info("SalaryIncome-fetchOtherIncomeDocument number of nodes##############################S:"+nodeiterator.getSize()); 
				//     NodeIterator nodeiterator2=(NodeIterator)node.getNodes("^[A-Z]{5}\\d{4}[A-Z]$");
				if(null == nodeiterator){  								    	
					response.sendRedirect("/site/otherincome");
				}else{
					try {     
						log.info("OtherIncome-fetchotherIncomeDocument-->TAN Available");

						while(nodeiterator.hasNext()){ 
							// while(nodeiterator.nextNode() != null){
							log.warn("in while");
							// log.warn(nodeiterator.nextNode().getName());
							sTAN = (String) nodeiterator.nextNode().getName();
							itReturnFolderPathTAN = ContentStructure.getOtherIncomePathUpdate(request,member.getUserName());
							log.info("in fetching after fetching tan:----%%%%%%%%%%"+itReturnFolderPathTAN);

							// arrlTAN.add(nodeiterator.nextNode().getName().toString().toLowerCase());
							objOtherIncomeDocument = (OtherSourceIncome)getObjectBeanManager(request).getObject(itReturnFolderPathTAN);
							log.info("in fetching after fetching tan:----%%%%%%%%%%"+objOtherIncomeDocument);
							arrlOtherIncome.add(objOtherIncomeDocument);
							log.info("OtherIncome-fetchOtherIncomeDocument111111111-->TAN list:"+arrlOtherIncome.toString());


						}//end of while
					}

					catch (ObjectBeanManagerException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						//}
					}
				}
			}else{
				log.info("OtherIncome-fetchOtherIncomeDocument-->Member not available");
				try {
					response.sendRedirect("/site/memberLogin");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return arrlOtherIncome;
		} 
		catch (Exception e) {
			log.warn("Failed to create a review for product '" + "----- IT RETURN ------" + "'", e);
			return null;
		}
		finally
		{
			if (persistableSession != null)
			{
				persistableSession.logout();
			}
		}
	}
}