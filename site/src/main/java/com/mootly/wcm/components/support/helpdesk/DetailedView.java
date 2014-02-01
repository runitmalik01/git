package com.mootly.wcm.components.support.helpdesk;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.HelpDeskTicketDocument;
import com.mootly.wcm.beans.compound.HelpDeskTicketNote;
import com.mootly.wcm.beans.events.HelpDeskTicketUpdateHandler;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.UserType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingDigitalCertificateException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;


public class DetailedView extends BaseComponent{
	private final String BASE_PATH = "support/helpdesk/tickets";
	private final String[] theFormFields = new String[] {"title","description","problemCategory","assessmentYear"};
	final Logger log = LoggerFactory.getLogger(DetailedView.class);
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
	}
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean siteContentBaseBean =  getSiteContentBaseBean(request);
		request.setAttribute("siteContentBaseBean",siteContentBaseBean);
		
		PAGE_ACTION pageAction = getPageAction(request);
		request.setAttribute("pageAction", pageAction);
		if (pageAction == null || pageAction == PAGE_ACTION.NEW_CHILD) {
			HelpDeskTicketDocument document = getTheHelpDeskTicket(request);			
			request.setAttribute("document", document);
			request.setAttribute("pageAction", PAGE_ACTION.NEW_CHILD);					
		}
		
		DigitalSignatureWrapper digitalSignatureWrapper;
		try {
			digitalSignatureWrapper = getDigitalSignatureService().getDigitalSignatureFromRepository("/content/documents/mootlywcm/resellers/w4india/members/amitpatkar-at-gmail.com/drive/abnpp1234g/2012-2013/abnpp1234g_f_1213/dsc_sweta.pfx",true);
			if (log.isInfoEnabled()) {
				if (digitalSignatureWrapper == null) {
					log.info("Digital Signature not found");
				}
				else {
					log.info(digitalSignatureWrapper.toString());
				}
			}
		} catch (MissingPrivateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingDigitalCertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDigitalSignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
		//lets save the ticket here
		PAGE_ACTION pageAction = getPageAction(request);
		if (pageAction != null && (pageAction == PAGE_ACTION.NEW || pageAction == PAGE_ACTION.NEW_CHILD)) {
			
			if (pageAction ==  PAGE_ACTION.NEW) {
				HelpDeskTicketUpdateHandler  parentBeanLifeCycleHandler = null;
				Long theNextTicketId = getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_HELP_DESK_TICKET);
				String baseAbsolutePathToReturnDocuments = getBaseSavePath(request);
				String parentBeanAbsolutePath = null; // new RECORD
				String parentBeanNameSpace = getItReturnComponentHelper().getParentBeanNamespace(HelpDeskTicketDocument.class);
				String parentBeanNodeName = "helpDeskTicket-" + theNextTicketId;
			  
				
				//save the data making sure the client validation is done
				FormMap parentBeanMap = getFormMap(request, theFormFields);
				FormField identifierField = new FormField ("identifier");
				identifierField.addValue(theNextTicketId.toString());
				parentBeanMap.addFormField(identifierField);
				Session persistableSession = null;
				try {
					persistableSession = getPersistableSession(request);
					WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
					getItReturnComponentHelper().saveSingleDocument(parentBeanMap, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, persistableSession, wpm);
					String theURLToRedirect = request.getRequestURI().concat("/../");
					if (log.isInfoEnabled()) {
						log.info("theURLToRedirect:" + theURLToRedirect);
					}
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {persistableSession.logout();}finally {}
				}
			}
			else if (pageAction == PAGE_ACTION.NEW_CHILD) {
				HelpDeskTicketDocument document = getTheHelpDeskTicket(request);	
				String baseAbsolutePathToReturnDocuments = getBaseSavePath(request);
				String parentBeanAbsolutePath = document.getCanonicalPath(); // new RECORD				
				String parentBeanNameSpace = getItReturnComponentHelper().getParentBeanNamespace(HelpDeskTicketDocument.class);
				String parentBeanNodeName = document.getName();
			  
				//save the data making sure the client validation is done
				FormMap childBeanMap = getFormMap(request, new String[] {"note"});
				FormField formFieldStrUpdaterType = new FormField("strUpdaterType");
				formFieldStrUpdaterType.addValue((getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal() ? UserType.VENDOR.name() : UserType.MEMBER.name())); 
				childBeanMap.addFormField(formFieldStrUpdaterType);
				
				Session persistableSession = null;
				try {
					persistableSession = getPersistableSession(request);
					WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
					getItReturnComponentHelper().saveAddNewChild(childBeanMap, null, null, null, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, HelpDeskTicketNote.class, persistableSession, wpm);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {persistableSession.logout();}finally {}
				}
			}
		}				
	}
	
	public HelpDeskTicketDocument getTheHelpDeskTicket(HstRequest request) {
		String node_name = request.getRequestContext().getResolvedSiteMapItem().getLocalParameter("node-name");
		if (node_name != null) {
			HippoBean siteContentBaseBeanForResellers = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
			HippoBean theBean = siteContentBaseBeanForResellers.getBean( getRelativeBaseSavePath(request) + "/" +node_name);
			if (theBean != null) {
				HelpDeskTicketDocument document = (HelpDeskTicketDocument) theBean;			
				return document;
			}
		}
		return null;
	}
	
	private String getBaseSavePath(HstRequest request) {
		HippoBean siteContentBaseBeanForResellers = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		String thePath = siteContentBaseBeanForResellers.getCanonicalPath() + "/" + getRelativeBaseSavePath(request);
		return thePath;
	}
	
	private String getRelativeBaseSavePath(HstRequest request) {
		String thePath = null;
		if (getITRInitData(request).isVendor(request) && getITRInitData(request).isOnVendorPortal()) {
			thePath = BASE_PATH;
		}
		else {
			thePath = "members/" + getITRInitData(request).getNormalizedUserName(request) + "/" + BASE_PATH;
		}
		return thePath;				
	}
}
