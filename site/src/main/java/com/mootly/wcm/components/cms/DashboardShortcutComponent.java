/**
 * 
 */
package com.mootly.wcm.components.cms;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.cms.DashboardShortcutDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.IndianGregorianCalendar;

/**
 * @author BEN-10
 *
 */
@FormFields(fieldNames={"documentName","documentType","contentFolder"})
@RequiredFields(fieldNames={"documentName","documentType","contentFolder"})

public class DashboardShortcutComponent extends ITReturnComponent {

	public static final Logger log = LoggerFactory.getLogger(DashboardShortcutComponent.class);
	public static final String DASHBOARD = "dashboard";
	public static final String CONTENT_FOLDER = "contentFolder";
	public static final String DOCUMENT_TYPE = "documentType";
	public static final String DOCUMENT_NAME = "documentName";
	public static final String REDIRECT_REF_ID = "global-document-editor";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean siteContentBean = getSiteContentBaseBean(request);
		HippoBean dashboardContentBean = siteContentBean.getBean(DASHBOARD);
		if(dashboardContentBean == null){
			if(log.isInfoEnabled()){
				log.info("Scope of dashboard content Bean is { } null or not able to fetched.");
			}
			return;
		}
		if(dashboardContentBean instanceof HippoFolder){
			HippoFolder dashboardFolder = (HippoFolder) dashboardContentBean;
			List<DashboardShortcutDocument> documents = dashboardFolder.getDocuments(DashboardShortcutDocument.class);
			if(log.isInfoEnabled()){
				log.info("Lets ceck the Dashboard Document in list"+documents.size());
			}
			request.setAttribute("documents", documents);
		} 
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		HippoBean resellerSiteHippoBean = getSiteContentBaseBeanForReseller(request);
		HstLink hstLink = request.getRequestContext().getHstLinkCreator().createByRefId(REDIRECT_REF_ID, request.getRequestContext().getResolvedMount().getMount());
		String redirectURL = hstLink.toUrlForm(request.getRequestContext(), true);
		String basePathForDocument = resellerSiteHippoBean.getCanonicalPath();
		FormMap dashboardFormMap = getITRInitData(request).getFormMap();
		if(dashboardFormMap != null){
			String contentFolder = dashboardFormMap.getField(CONTENT_FOLDER).getValue();
			String documentType = dashboardFormMap.getField(DOCUMENT_TYPE).getValue();
			String documentName = dashboardFormMap.getField(DOCUMENT_NAME).getValue();
			Session persistabSession = null;
			WorkflowPersistenceManager wpm = null;
			try {
				persistabSession = getPersistableSession(request);
				wpm = getWorkflowPersistenceManager(persistabSession);
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				String absolutePathForDocument = CreateAbsolutePathForDocument(request, basePathForDocument, contentFolder);
				if(log.isInfoEnabled()){
					log.info("Lets check path for Document::"+absolutePathForDocument);
				}
				String absolutePathOfCreated = wpm.createAndReturn(absolutePathForDocument, documentType, documentName, true);
				Object object = wpm.getObject(absolutePathOfCreated);
				if(object instanceof HippoBean){
					//HippoBean documentBean = (HippoBean) object;
					if(log.isInfoEnabled()){
						log.info("Lets check path for Redirect::"+redirectURL);
					}
					//wpm.update(object);
					response.sendRedirect(redirectURL+absolutePathOfCreated+".html");
				}
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ObjectBeanPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * This method is used to create the Absolute Path for Document.
	 * 
	 * @param request {@link HstRequest}
	 * @param basePathForDocument {@link String}
	 * @param contentFolder {@link String}
	 * */

	@SuppressWarnings("deprecation")
	public String CreateAbsolutePathForDocument(HstRequest request, String basePathForDocument, String contentFolder){
		StringBuilder stringBuilderForPath = new StringBuilder();
		stringBuilderForPath.append(basePathForDocument).append('/').append(contentFolder);
		GregorianCalendar indianCalendar = IndianGregorianCalendar.getCurrentDateInIndiaAsDate();
		stringBuilderForPath.append('/').append(indianCalendar.getTime().getYear()+1990).append('/').append(indianCalendar.getTime().getMonth()+1);
		return stringBuilderForPath.toString();
	}

	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
}
