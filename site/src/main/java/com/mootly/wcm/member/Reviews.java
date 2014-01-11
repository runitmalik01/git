/**
 * Here we are getting comments whether it is good or bad from users
 * @author Dhananjay Panwar
 * 24-05-2013
 */

package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.util.ContentBeanUtils;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.Review;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.products.ProductDetailParamInfo;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;

@ParametersInfo(type = ProductDetailParamInfo.class)
public class Reviews extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(Reviews.class);

	private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss.SSS";
	private static final String NAME = "name";
	private static final String COMMENT = "comment";
	private static final String EMAIL = "email";
	private static final String SUCCESS = "success";
	private static final String ERRORS = "errors";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {

		super.doBeforeRender(request, response);

		String reviewsFolderName ="wealth4indiareviews";
		Review document = (Review) getContentBean(request);

		request.setAttribute("document", document);
		log.info("document",document);

		HippoBean siteContentBase = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		HippoFolder reviewsFolder = siteContentBase.getBean("wealth4indiareviews");
		if (reviewsFolder == null) {
			log.warn("Product reviews folder not found: '{}/{}'. No product reviews will be shown.", siteContentBase.getPath(), reviewsFolderName);
		} else {
			try {
				List<Review> reviews = new ArrayList<Review>();

				log.info("inside if loop");
				final HstQuery incomingBeansQuery = ContentBeanUtils.createIncomingBeansQuery(document, reviewsFolder, 1, getObjectConverter(), Review.class, false);
				final HstQueryResult result = incomingBeansQuery.execute();
				final HippoBeanIterator beanIterator = result.getHippoBeans();
				int count = 0;
				while (beanIterator.hasNext()) {
					log.info("inside while loop");
					Review review = (Review) beanIterator.nextHippoBean();
					reviews.add(review);
					count++;
				}
				request.setAttribute("reviews", reviews);
				log.info("got a review"+reviews);
				request.setAttribute("votes", count);
				log.info("got votes"+count);
			} catch (QueryException e) {
				log.error("Unable to execute query to get the reviews :" + e.getMessage(), e);
			}
		}
		request.setAttribute(ERRORS, request.getParameterValues(ERRORS));
		request.setAttribute(COMMENT, request.getParameter(COMMENT));
		request.setAttribute(NAME, request.getParameter(NAME));
		request.setAttribute(EMAIL, request.getParameter(EMAIL));
		request.setAttribute(SUCCESS, request.getParameter(SUCCESS));

		Boolean isReseller = request.isUserInRole("reseller");
		request.setAttribute("reseller", isReseller);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		String name = GoGreenUtil.getEscapedParameter(request, NAME);
		String email = GoGreenUtil.getEscapedParameter(request, EMAIL);
		String comment = GoGreenUtil.getEscapedParameter(request, COMMENT);

		Long rating = Long.valueOf(request.getParameter("rating"));

		Session persistableSession = null;
		WorkflowPersistenceManager wpm;

		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());

			final String reviewFolderPath = createReviewFolderPath(request);

			String username=request.getUserPrincipal().getName();
			String reviewFolderName = "Review given by "+username; 

			final String reviewPath = wpm.createAndReturn(reviewFolderPath, Constants.NT_REVIEW ,reviewFolderName, true);

			Review review = (Review) wpm.getObject(reviewPath);
			// update content properties
			if (review != null) {
				review.setName(name);
				review.setComment(comment);
				review.setRating(rating);
				review.setEmail(email);

				// update now           `
				wpm.update(review);
				response.setRenderParameter(SUCCESS, SUCCESS);
			} else {
				log.warn("Failed to add review for product '{}': could not retrieve Review bean for node '{}'.", reviewPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
			}
		} catch (Exception e) {
			log.warn("Failed to create a review for product '" + "'", e);
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	private String createReviewFolderPath(HstRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/wealth4indiareviews");
		return builder.toString();
	}


	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response) throws HstComponentException {

		super.doBeforeServeResource(request, response);

		boolean succeeded = true;
		String errorMessage = "";

		String workflowAction = request.getParameter("workflowAction");

		String field = request.getParameter("field");

		final boolean requestPublication = "requestPublication".equals(workflowAction);
		final boolean saveDocument = ("save".equals(workflowAction) || requestPublication);

		if (saveDocument || requestPublication) {
			String documentPath = getContentBean(request).getPath();
			Session persistableSession = null;
			WorkflowPersistenceManager cpm = null;

			try {
				//NOTE: Don't need to use writable session here; use subject based session instead.
				//persistableSession = getPersistableSession(request);
				persistableSession = request.getRequestContext().getSession();

				cpm = getWorkflowPersistenceManager(persistableSession);
				cpm.setWorkflowCallbackHandler(new WorkflowCallbackHandler<FullReviewedActionsWorkflow>() {
					public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
						if (requestPublication) {
							FullReviewedActionsWorkflow fraw = (FullReviewedActionsWorkflow) wf;
							fraw.requestPublication();
						}
					}
				});


			} catch (Exception e) {
				log.warn("Failed to create a comment: ", e);

				if (cpm != null) {
					try {
						cpm.refresh();
					} catch (ObjectBeanPersistenceException e1) {
						log.warn("Failed to refresh: ", e);
					}
				}
			}
			// NOTE: no need to close the persistable session here because subject based session was retrieved from rc.
		}

		request.setAttribute("payload", "{\"success\": " + succeeded + ", \"message\": \"" + errorMessage + "\"}");
	}

	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.requestPublication();
		}
	}
}
