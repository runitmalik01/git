package com.mootly.wcm.member.service;


import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.BaseFilter;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.query.filter.PrimaryNodeTypeFilterImpl;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.content.beans.standard.HippoDocumentIterator;
import org.hippoecm.hst.content.beans.standard.HippoFacetChildNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoResultSetBean;
import org.hippoecm.hst.content.beans.standard.facetnavigation.HippoFacetNavigation;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.hippoecm.hst.util.SearchInputParsingUtils;
import org.hippoecm.hst.utils.BeanUtils;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ComponentUtil;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.PageableCollection;



public class Services extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Services.class);
    private static final int DEFAULT_PAGE_SIZE = 5;
    private static final String PARAM_CURRENT_PAGE = "pageNumber";
    private static final int DEFAULT_CURRENT_PAGE = 1;
    
    @Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.warn("This is Contact Information Right Nav Page");
		final HippoBean scope = getContentBean(request);
		request.setAttribute("scope", scope);
        if (scope == null) {
            ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
            log.warn("Scope bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
                    resolvedSiteMapItem.getHstSiteMapItem().getId(),
                    resolvedSiteMapItem.getRelativeContentPath());
            return;
        }
		log.info("this is source bean"+scope.toString());
        int pageSize = GoGreenUtil.getIntConfigurationParameter(request, Constants.PAGE_SIZE, DEFAULT_PAGE_SIZE);
        log.info("this is source bean"+pageSize);
        String currentPageParam = getPublicRequestParameter(request, PARAM_CURRENT_PAGE);
        int currentPage = ComponentUtil.parseIntParameter(PARAM_CURRENT_PAGE, currentPageParam, DEFAULT_CURRENT_PAGE, log);
        log.info("this is source bean"+currentPage);
        String query = this.getPublicRequestParameter(request, "query");
        query = SearchInputParsingUtils.parse(query, false);
        request.setAttribute("query", StringEscapeUtils.escapeHtml(query));

        try {
            final PageableCollection<com.mootly.wcm.beans.Service> services = getServices(request, scope, pageSize, currentPage, query);
    		log.info("Page collection"+services.toString()+"now next don't know"+services.getStartPage());
            request.setAttribute("services", services);

        } catch (QueryException e) {
            throw new HstComponentException("Query error while getting services: " + e.getMessage(), e);
        }
	}
	
    private PageableCollection<com.mootly.wcm.beans.Service> getServices(HstRequest request, HippoBean scope, int pageSize, int currentPage, String query) throws QueryException {

        final HstQuery hstQuery = getQueryManager(request).createQuery(scope);
        log.info("this is source bean"+hstQuery.toString()+hstQuery.getLimit());
        final BaseFilter filter = new PrimaryNodeTypeFilterImpl("mootlywcm:Service");
        hstQuery.setFilter(filter);
        hstQuery.addOrderByAscending("mootlywcm:serviceCode");

        if (!StringUtils.isEmpty(query)) {
            final Filter f = hstQuery.createFilter();
            final Filter f1 = hstQuery.createFilter();
            f1.addContains(".", query);
            final Filter f2 = hstQuery.createFilter();
            f2.addContains("mootlywcm:name", query);
            f.addOrFilter(f2);
            hstQuery.setFilter(f);
        }

        if (scope instanceof HippoFacetChildNavigationBean || scope instanceof HippoFacetNavigation) {
            log.info("Now going to get HippoFacet Bean"+scope.toString());
            // only show faceted services items
            final HippoFacetNavigationBean facetBean = BeanUtils.getFacetNavigationBean(request, hstQuery, objectConverter);

            if (facetBean == null) {
                final List<HippoBean> noResults = Collections.emptyList();
                return new PageableCollection(0, noResults);
            } else {
                final HippoResultSetBean resultSet = facetBean.getResultSet();
                final HippoDocumentIterator<com.mootly.wcm.beans.Service> facetIt = resultSet.getDocumentIterator(com.mootly.wcm.beans.Service.class);
                if (hstQuery.getOffset() > 0) {
                    facetIt.skip(hstQuery.getOffset());
                }
                final int facetCount = facetBean.getCount().intValue();
                return new PageableCollection(facetIt, facetCount, pageSize, currentPage);
            }
        }
        log.info("Now going to get HippoFacet Bean"+scope.toString());
        // show all services items
        final HstQueryResult result = hstQuery.execute();
        log.info("Now going to get HippoFacet Bean"+result.toString()+"Now aboutr sixe"+result.getSize());
        final HippoBeanIterator iterator = result.getHippoBeans();
        log.info("Now going to get HippoFacet Bean"+iterator.toString()+"Now aboutr sixe"+iterator.getSize());
        return new PageableCollection<com.mootly.wcm.beans.Service>(iterator, pageSize, currentPage);
    }
    
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.warn("test page at do action method");
		
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
