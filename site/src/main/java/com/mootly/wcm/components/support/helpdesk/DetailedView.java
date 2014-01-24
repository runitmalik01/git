package com.mootly.wcm.components.support.helpdesk;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentIterator;
import org.hippoecm.hst.content.beans.standard.HippoFacetChildNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoResultSetBean;
import org.hippoecm.hst.content.beans.standard.facetnavigation.HippoFacetNavigation;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.util.SearchInputParsingUtils;
import org.hippoecm.hst.utils.BeanUtils;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.EventDocument;
import com.mootly.wcm.beans.HelpDeskTicketDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.beans.Product;
import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.beans.compound.HelpDeskTicketNote;
import com.mootly.wcm.beans.events.HelpDeskTicketUpdateHandler;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ComponentUtil;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.exceptions.BeanNotFoundException;
import com.mootly.wcm.member.service.ServiceRequestManager;
import com.mootly.wcm.model.UserType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingDigitalCertificateException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.PageableCollection;

public class DetailedView extends BaseComponent{
	private final String BASE_PATH = "support/helpdesk/tickets";
	private final String[] theFormFields = new String[] {"title","description","problemCategory","assessmentYear","memberFileName"};
	private static final String FILE_DATA="fileData";
	private static final String CONTENT_TYPE="ContentType";
	private static final String FILE_NAME="fileName";
	private static final String PARAM_PAGE_SIZE = "pageSize";
	private static final int DEFAULT_PAGE_SIZE = 25;
	private static final String PARAM_CURRENT_PAGE = "pageNumber";
	private static final int DEFAULT_CURRENT_PAGE = 1;
	private static final int DEFAULT_SHOW_MORE = 25;	
	private static final String PARAM_ORDER_BY = "orderBy";
	private static final String DEFAULT_ORDER_BY = "hippostdpubwf:lastModificationDate";
	
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
		//HippoBean eventsOverviewBean = this.getContentBean(request);
		HippoBean contentBean = getSiteContentBaseBean(request);
		//HippoBean contentBean1 = getSiteContentBaseBean(request).getBean("events");
		PAGE_ACTION pageAction = getPageAction(request);
		request.setAttribute("pageAction", pageAction);
		
		if (pageAction == null || pageAction == PAGE_ACTION.NEW_CHILD) {
			HelpDeskTicketDocument document = getTheHelpDeskTicket(request);			
			request.setAttribute("document", document);
			request.setAttribute("pageAction", PAGE_ACTION.NEW_CHILD);					
		}

		String order = this.getPublicRequestParameter(request, "order");
		request.setAttribute("order", StringEscapeUtils.escapeHtml(order));

		String orderBy = getParameter(PARAM_ORDER_BY, request);
		if (orderBy == null || "".equals(orderBy)) {
			orderBy = DEFAULT_ORDER_BY;
		}
		
		if(log.isInfoEnabled()){
		}

		// by abhishek



		if (siteContentBaseBean == null) {
			throw new BeanNotFoundException("Needed eventsOverviewBean bean not found. Cannot proceed");
		}
		String pageSizeParam = getParameter(PARAM_PAGE_SIZE, request);
		int pageSize = ComponentUtil.parseIntParameter(PARAM_PAGE_SIZE, pageSizeParam, DEFAULT_PAGE_SIZE, log);

		String currentPageParam = getPublicRequestParameter(request, PARAM_CURRENT_PAGE);
		int currentPage = ComponentUtil.parseIntParameter(PARAM_CURRENT_PAGE, currentPageParam, DEFAULT_CURRENT_PAGE, log);
		if (!(siteContentBaseBean instanceof HippoFacetChildNavigationBean)) {
			try {
				
				HstQuery query = this.getQueryManager(request).createQuery(siteContentBaseBean, HelpDeskTicketDocument.class);
				//query.addOrderByDescending("mootlywcm:date");
				HstQueryResult result = query.execute();
				request.setAttribute("documents", new PageableCollection<HippoBean>(
						result.getHippoBeans(), pageSize, currentPage));

			} catch (QueryException qe) {
				log.error("Error while getting the documents " + qe.getMessage(), qe);
			}
		} else {
			HippoFacetChildNavigationBean facetBean = (HippoFacetChildNavigationBean) siteContentBaseBean;
			request.setAttribute("documents", new PageableCollection(facetBean.getResultSet().getDocumentIterator(EventDocument.class), facetBean.getCount().intValue(), GoGreenUtil.getIntConfigurationParameter(request,
					Constants.PAGE_SIZE, pageSize), currentPage));
		}
		
		
		
		
		/*HippoBean siteContentBaseBean =  getSiteContentBaseBean(request);
		//String getDocumentForHelpdesk = getCanonicalBasePathForWrite(request)+"/members/"+ getITRInitData(request).getNormalizedUserName(request)+ "/support/helpdesk/tickets/"+get 
		
		request.setAttribute("siteContentBaseBean",siteContentBaseBean);
		
		PAGE_ACTION pageAction = getPageAction(request);
		request.setAttribute("pageAction", pageAction);
		//HelpDeskTicketDocument document1 = getTheHelpDeskTicket(request);			
		//request.setAttribute("document", document);
		if (pageAction == null || pageAction == PAGE_ACTION.NEW_CHILD) {
			HelpDeskTicketDocument document = getTheHelpDeskTicket(request);			
			request.setAttribute("document", document);
			request.setAttribute("pageAction", PAGE_ACTION.NEW_CHILD);					
		}
		String pageSizeParam = getPublicRequestParameter(request, PARAM_PAGE_SIZE);
		if (pageSizeParam == null || "".equals(pageSizeParam)) {
			pageSizeParam = getParameter(PARAM_PAGE_SIZE, request);
		}
		int pageSize = ComponentUtil.parseIntParameter(PARAM_PAGE_SIZE, pageSizeParam, DEFAULT_PAGE_SIZE, log);
		request.setAttribute("pageSize", pageSize);
		
		String query = this.getPublicRequestParameter(request, "query");
		query = SearchInputParsingUtils.parse(query, false);
		request.setAttribute("query", StringEscapeUtils.escapeHtml(query));

		String order = this.getPublicRequestParameter(request, "order");
		request.setAttribute("order", StringEscapeUtils.escapeHtml(order));

		String currentPageParam = getPublicRequestParameter(request, PARAM_CURRENT_PAGE);
		int currentPage = ComponentUtil.parseIntParameter(PARAM_CURRENT_PAGE, currentPageParam, DEFAULT_CURRENT_PAGE, log);

		String orderBy = getParameter(PARAM_ORDER_BY, request);
		if (orderBy == null || "".equals(orderBy)) {
			orderBy = DEFAULT_ORDER_BY;
		}
		HstQuery hstQuery = createMemberHomePageHstQuery(request, query, order, orderBy, null, null);
		HippoBean currentBean = getSiteContentBaseBeanForReseller(request);
		log.info("CURRENT BEAN qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqQQQQQQQQQQQQQQQQQQQQQQQQQ"+currentBean);
		PageableCollection pages = generatePageCollectionResultOfHstQuery(request, currentBean, hstQuery, pageSize, currentPage);
		request.setAttribute("pages", pages);*/
		//PageableCollection pages=(PageableCollection) hstQueryResulSettMap.get("pages");
		
		
	/*	DigitalSignatureWrapper digitalSignatureWrapper;
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
		}	*/	
	
	
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
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					boolean isMultipart = ServletFileUpload.isMultipartContent(request);
					if(log.isInfoEnabled()){
						log.info("Lets analyse the request so that we can seprate::" + isMultipart);
					}
					Map<String, byte[]> files = new HashMap<String, byte[]>();
					Map<String,String> fileDetails = new HashMap<String, String>();
					ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());					
					List<FileItem> items = fileUpload.parseRequest(request);
					Iterator<FileItem> iter = items.iterator();
					while (iter.hasNext()) {
						FileItem item = iter.next();
						if (item.isFormField()) {
							for(String fieldname : parentBeanMap.getFieldNames() ){
								if(item.getFieldName().equals(fieldname)){
									parentBeanMap.getField(fieldname).addValue(item.getString());
								}
							}
						} else {
							InputStream inputStream = item.getInputStream();							
							byte[] data = IOUtils.toByteArray(inputStream);
							files.put(FILE_DATA, data);
							fileDetails.put(FILE_NAME, item.getName());
							fileDetails.put(CONTENT_TYPE, item.getContentType());
						}
					}	
					//getItReturnComponentHelper().saveSingleDocument(parentBeanMap, parentBeanLifeCycleHandler, baseAbsolutePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, persistableSession, wpm);					
					String returnDocPath = wpm.createAndReturn(baseAbsolutePathToReturnDocuments, parentBeanNameSpace, parentBeanNodeName, true);
					Object object = wpm.getObject(returnDocPath);
					if(object != null){
						if(object instanceof HelpDeskTicketDocument){
							HelpDeskTicketDocument ticketDocument = (HelpDeskTicketDocument) object;
							ticketDocument.fill(parentBeanMap);
							ticketDocument.setContentType(fileDetails.get(CONTENT_TYPE));																									
							ticketDocument.setMemberFile(new ByteArrayInputStream(files.get(FILE_DATA)));
							wpm.update(ticketDocument);
						}
					}
					String email = null;
					if(request.getUserPrincipal() != null){
					email = getITRInitData(request).getNormalizedUserName(request).replaceAll("-at-","@").toLowerCase();
					//.replaceAll("@","-at-").toLowerCase()
					} 
					HelpDeskTicketDocument publishedHelpDeskTicketDocument = (HelpDeskTicketDocument) wpm.getObject(returnDocPath);
					Map<String,Object> contextMap = new HashMap<String, Object>();
					contextMap.put("identifier",publishedHelpDeskTicketDocument.getIdentifier());
					contextMap.put("title", publishedHelpDeskTicketDocument.getTitle());
					contextMap.put("description", publishedHelpDeskTicketDocument.getDescription());
					contextMap.put("problemCategory", publishedHelpDeskTicketDocument.getProblemCategory());
					contextMap.put("userName", email);
					contextMap.put("ticketDocument", publishedHelpDeskTicketDocument);
					//new String[]{email}
					sendEmail(request, new String[]{email}, null, "", "helpdesk_request", contextMap);
					sendEmail(request, null, null, "", "helpdesk_vendor", contextMap);
					String theURLToRedirect = request.getRequestURI().concat("/../");
					if (log.isInfoEnabled()) {
						log.info("theURLToRedirect:" + theURLToRedirect);
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {persistableSession.logout();}
					finally {
						
					}
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
	
	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	
	
	public HelpDeskTicketDocument getTheHelpDeskTicket(HstRequest request) {
		String node_name = request.getRequestContext().getResolvedSiteMapItem().getLocalParameter("node-name");
		//if (node_name != null) {
			HippoBean siteContentBaseBeanForResellers = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
			HippoBean theBean = siteContentBaseBeanForResellers.getBean( getRelativeBaseSavePath(request) + "/" +node_name);
			if (theBean != null) {
				HelpDeskTicketDocument document = (HelpDeskTicketDocument) theBean;	
				return document;
			}
		//}
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
	
	@SuppressWarnings("unchecked")
	public HstQuery createMemberHomePageHstQuery(HstRequest request,String query,String order,String orderBy,String from,String jsEnabled){
		HstQuery hstQuery=null;
		try {
		//HippoBean theScopeBean = getSiteContentBaseBeanForReseller(request).;
			HippoBean siteContentBaseBeanForResellers = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
			HippoBean theScopeBean = siteContentBaseBeanForResellers.getBean( getRelativeBaseSavePath(request));
			if (log.isInfoEnabled()) {
				log.info("theScopeBean:" + theScopeBean.getName());
			}
			hstQuery = getQueryManager(request).createQuery(theScopeBean, HelpDeskTicketDocument.class);
			if (!StringUtils.isEmpty(query)) {
				//BaseFilter baseFilter=new PrimaryNodeTypeFilterImpl(new String[]{"mootlywcm:MemberPersonalInformation","mootlywcm:payment"});
				Filter f = hstQuery.createFilter();
				Filter f1 = hstQuery.createFilter();
				f1.addContains(".", query);
				Filter f2 = hstQuery.createFilter();
				f2.addContains("mootlywcm:title", query);
				f.addOrFilter(f1);
				f.addOrFilter(f2);
				hstQuery.setFilter(f);
				hstQuery.addOrderByDescending("hippostdpubwf:lastModificationDate");
			} else {
				if (!StringUtils.isEmpty(order) && !"relevance".equals(order)) {
					if ("-lastModificationDate".equals(order)) {
						hstQuery.addOrderByDescending("hippostdpubwf:lastModificationDate");
					} else if (order.startsWith("-")) {
						hstQuery.addOrderByDescending("mootlywcm:" + order.substring(1));
					} else {
						hstQuery.addOrderByAscending("mootlywcm:" + order);
					}
				} else {
					hstQuery.addOrderByDescending(orderBy);
				}
			}
			if (from != null && Boolean.parseBoolean(jsEnabled)) {
				hstQuery.setOffset(Integer.valueOf(from));
			}
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			log.error("Error while creating HSTQuery",e);
		}			
		return hstQuery;
	}
	@SuppressWarnings("unchecked")
	public PageableCollection generatePageCollectionResultOfHstQuery(HstRequest request,HippoBean currentBean,HstQuery hstQuery,int pageSize,int currentPage){
		Map<String ,Object> resultOFHstQuery = new HashMap<String, Object>();
		PageableCollection pages=null;
		long resultCount = 0;
		if (currentBean == null || !(currentBean instanceof HippoFacetChildNavigationBean || currentBean instanceof HippoFacetNavigation)) {
			HstQueryResult result;
			try {
				result = hstQuery.execute();
				pages = new PageableCollection<HippoBean>(result.getHippoBeans(), pageSize, currentPage);
				resultCount = result.getSize();
			} catch (QueryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			final HippoFacetNavigationBean facNavBean = BeanUtils.getFacetNavigationBean(request, hstQuery, objectConverter);
			if (facNavBean == null) {
				final List<HippoBean> noResults = Collections.emptyList();
				pages = new PageableCollection(0, noResults);
				resultCount = 0;
			} else {
				final HippoResultSetBean result = facNavBean.getResultSet();
				final HippoDocumentIterator<Product> beans = result.getDocumentIterator(Product.class);
				if (hstQuery.getOffset() > 0) {
					beans.skip(hstQuery.getOffset());
				}
				pages = new PageableCollection(beans, facNavBean.getCount().intValue(), GoGreenUtil.getIntConfigurationParameter(request,
						Constants.PAGE_SIZE, pageSize), currentPage);
				resultCount = result.getCount();
			}
		}
		resultOFHstQuery.put("pages", pages);
		resultOFHstQuery.put("resultCount", resultCount);
		return pages;
	}
}
