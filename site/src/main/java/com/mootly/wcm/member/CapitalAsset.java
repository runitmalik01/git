package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.CapitalAssetInformation;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.SignupDetail.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;

/**

 * @author:Pankaj Singh
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */

public class CapitalAsset extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(CapitalAsset.class);
	private static final String DATEACQUISITION = "hidDateAcquisition";
	private static final String COSTACQUISITION = "cost_acquisition";
	private static final String DATESALE = "hidDateSale";
	private static final String SALECONSIDERATION ="sale_consideration";
	private static final String INFLATIONACQUISITION ="inflation_acquisition";
	private static final String INFLATIONCONSIDERATION ="inflation_consideration";
	private static final String CAPITALGAIN ="capital_gain";

	private static final String ERRORS = "errors";
	private static final String pans = null;


	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.info("This is Start capital gain  Page");
		//request.setAttribute("pageName", "startApplication");	
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(DATEACQUISITION, request.getParameter(DATEACQUISITION));
		request.setAttribute( COSTACQUISITION, request.getParameter( COSTACQUISITION));
		request.setAttribute(  DATESALE, request.getParameter(  DATESALE));
		request.setAttribute(  SALECONSIDERATION, request.getParameter(  SALECONSIDERATION));
		request.setAttribute(  INFLATIONACQUISITION, request.getParameter(  INFLATIONACQUISITION));
		request.setAttribute(  INFLATIONCONSIDERATION, request.getParameter(  INFLATIONCONSIDERATION));
		request.setAttribute(  CAPITALGAIN, request.getParameter(  CAPITALGAIN));

		log.info("This is Start Capitalasset page Page");

		try {
			Member member=(Member)request.getSession().getAttribute("user");
			  String username=member.getUserName().trim();
			  String modusername=username.replaceAll("@", "-at-").trim();
			   String pan=(String) request.getSession().getAttribute("pan");
			   String filing_year=(String) request.getSession().getAttribute("filing_year");
			   if(pan==null || filing_year==null){
				   pan="abcde1234g";
			   }
			String path=ContentStructure.getMemberAssetDocPath(pan,filing_year, modusername);
			log.warn(path);
			CapitalAssetInformation capital =(CapitalAssetInformation)getObjectBeanManager(request).getObject(path);
			request.setAttribute("capital", capital);
			if(capital != null){
				log.warn("hello");
				log.warn("capital object is"+capital);

			}


		}catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		//get all parameter of form


		String dateAcquisition=GoGreenUtil.getEscapedParameter(request, DATEACQUISITION);
		String costAcquisition=GoGreenUtil.getEscapedParameter(request, COSTACQUISITION);
		String dateSale=GoGreenUtil.getEscapedParameter(request, DATESALE);
		String saleConsideration=GoGreenUtil.getEscapedParameter(request, SALECONSIDERATION);
		String inflationAcquision=GoGreenUtil.getEscapedParameter(request, INFLATIONACQUISITION);
		String inflationConsideration=GoGreenUtil.getEscapedParameter(request, INFLATIONCONSIDERATION);
		String capitalgain=GoGreenUtil.getEscapedParameter(request, CAPITALGAIN);
		//check for validation
		List<String> errors = new ArrayList<String>();

		if(StringUtils.isEmpty(dateAcquisition)){
			errors.add("invalid.date-acquisition-label");
		}
		if(StringUtils.isEmpty(costAcquisition)){
			errors.add("invalid.cost-acquisition-label");
		}
		if(StringUtils.isEmpty(dateSale)){
			errors.add("invalid.date-sale-label");
		}

		if(StringUtils.isEmpty(dateSale)){
			errors.add("invalid.date-sale-label");
		}
		if(StringUtils.isEmpty(saleConsideration)){
			errors.add("invalid.sale-consideration-label");
		}
		if(StringUtils.isEmpty(inflationAcquision)){
			errors.add("invalid.cost-inflation-acquision-label");
		}
		if(StringUtils.isEmpty(inflationConsideration)){
			errors.add("invalid.cost-inflation-consideration-label");
		}
		int intdateSale=Integer.parseInt(dateSale);
		int intdateAcquisition=Integer.parseInt(dateAcquisition);
		if(intdateSale < intdateAcquisition){
			errors.add("invalid.datesale.dateaquisition");
		}
		log.info("size"+errors.size());
		if (errors.size()!=0){
			response.setRenderParameter(ERRORS, errors.toArray(new String[errors.size()]));
			response.setRenderParameter(COSTACQUISITION, costAcquisition);
			response.setRenderParameter(DATESALE , dateSale );

			response.setRenderParameter(SALECONSIDERATION, saleConsideration);
			response.setRenderParameter(INFLATIONACQUISITION,inflationAcquision );

			response.setRenderParameter(INFLATIONCONSIDERATION,inflationConsideration);

			response.setRenderParameter(DATEACQUISITION, dateAcquisition);
			response.setRenderParameter(CAPITALGAIN, capitalgain);
			log.info("i am at");
			return;
		}
		else{

			/*Create the CapitalAssetInformation Document Object
			 * Set the Values get from Form
			 * */
			CapitalAssetInformation cg = new CapitalAssetInformation();
			log.warn("No errors");
			cg.setDateAcquisition(dateAcquisition);
			cg.setCostAcquisition(costAcquisition);
			cg.setDateSale(dateSale);
			cg.setSaleConsideration(saleConsideration);
			cg.setCostIndexAcquisition(inflationAcquision);
			cg.setCostIndexConsideration(inflationConsideration);
			cg.setCapitalGain(capitalgain);
			createcapitalgainform(request,cg);
			try{
				response.sendRedirect(UrlUtility.Securities);
			}
			catch(Exception e){
			}
		}
	}


	private CapitalAssetInformation createcapitalgainform(HstRequest request, CapitalAssetInformation capitalgain) {
		// TODO Auto-generated method stub
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//SIMPLE WORKFLOW
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			  Member member=(Member)request.getSession().getAttribute("user");
			  String username=member.getUserName().trim();
			  String modusername=username.replaceAll("@", "-at-").trim();
			   String pan=(String) request.getSession().getAttribute("pan");
			   if(pan==null){
				   pan="abcde1234g";
			   }
			   String filing_year=(String) request.getSession().getAttribute("filing_year");
			   log.warn("check value in session"+filing_year);
			final String itReturnFolderPath = ContentStructure.getMemberOriginalFilingPath(request, pan,filing_year, modusername);
			String updateCapitalReturnPath=ContentStructure.getMemberAssetDocPath(pan,filing_year, modusername);
			CapitalAssetInformation updateCapital = (CapitalAssetInformation) wpm.getObject(updateCapitalReturnPath);
			if(updateCapital==null){
				final String itReturnPath = wpm.createAndReturn(itReturnFolderPath, CapitalAssetInformation.NAMESPACE ,  CapitalAssetInformation.NODE_NAME, true);
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
				CapitalAssetInformation capitaldocument = (CapitalAssetInformation) wpm.getObject(itReturnPath);
				// update content properties
				if (capitaldocument != null) {
					capitaldocument.setDateAcquisition(capitalgain.getDateAcquisition());
					capitaldocument.setCostAcquisition(capitalgain.getCostAcquisition());
					capitaldocument.setDateSale(capitalgain.getDateSale());
					capitaldocument.setSaleConsideration(capitalgain.getSaleConsideration());
					capitaldocument.setCostIndexAcquisition(capitalgain.getCostIndexAcquisition());
					capitaldocument.setCostIndexConsideration(capitalgain.getCostIndexConsideration());
					capitaldocument.setCapitalGain(capitalgain.getCapitalGain());


					// update now           `
					wpm.update(capitaldocument);
				}  
			}
			else{ 
				updateCapital.setDateAcquisition(capitalgain.getDateAcquisition());
				updateCapital.setCostAcquisition(capitalgain.getCostAcquisition());
				updateCapital.setDateSale(capitalgain.getDateSale());
				updateCapital.setSaleConsideration(capitalgain.getSaleConsideration());
				updateCapital.setCostIndexAcquisition(capitalgain.getCostIndexAcquisition());
				updateCapital.setCostIndexConsideration(capitalgain.getCostIndexConsideration());
				updateCapital.setCapitalGain(capitalgain.getCapitalGain());
				wpm.update(updateCapital);
			}



		}catch(Exception e){

		} finally {
			log.info("it is in finally");
		}
		/*Method to Update the MemberpersoanlInformation Document 
		 * */
		return capitalgain;		
	}
}


