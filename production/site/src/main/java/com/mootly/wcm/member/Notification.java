

/*
 @Author Dhananjay


    28/02/2013

    With the help of this JAVA  file we are showing NOTIFICATION 

 */

package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NotificationItem;
import com.mootly.wcm.components.ComponentUtil;
import com.mootly.wcm.components.TagComponent;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.PageableCollection;

/**
 * <p>
 * Fetches matching notification items within the scope of the current content bean, ordered descending by date. The notification items
 * are put into a {@link PageableCollection} that is available on the request as attribute 'notification'.
 * </p>
 * <p>
 * The following notification items are fetched:
 * </p>
 * <ol>
 * <li>If a tag is selected, the notification items related to that tag.</li>
 * <li>If one or more facets are selected, all notification items matching these facets. The facets are combined
 * with the free text search in the public request parameter 'query'.</li>
 * <li>Otherwise, all available notification items.</li>
 * </ol>
 * <ul>
 * <li>pageSize: the number of notification items per page</li>
 * <li>
 * <em>Public request parameters:</em>
 * <ul>
 * <li>pageNumber: the page to show</li>
 *<li>query: the free text to combine with the facets to limit the fetched notification items.</li>
 * </ul>
 */

public class Notification extends TagComponent {

	public static final Logger log = LoggerFactory.getLogger(Notification.class);

	private static final int DEFAULT_PAGE_SIZE = 2;
	private static final String PARAM_CURRENT_PAGE = "pageNumber";
	private static final int DEFAULT_CURRENT_PAGE = 1;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int year = date.getYear();
		request.setAttribute("filingyear", year);
		request.getSession().setAttribute("filing_year","2012-2013");
		String filing_year=(String) request.getSession().getAttribute("filing_year");
		//Checking for login user
		Member member=(Member)request.getSession().getAttribute("user");
		if(member!=null){
			String username = member.getUserName();
			request.getSession().setAttribute("username", username);
			Collection<String> oldpan= member.getPAN();
			if(!oldpan.isEmpty()){
				request.setAttribute("oldpan", oldpan.toArray(new String[oldpan.size()]));

			}
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			// String test=  getContentBean(request).getPath();
			//log.warn("path"+test);
			//making an array list of member personal information and member contact information
			List<MemberPersonalInformation> mpersonalinfo = new ArrayList<MemberPersonalInformation>();
			List<MemberContactInformation> mcontactinfo = new ArrayList<MemberContactInformation>();
			for(String t:oldpan){	
				try {
					if(StringUtils.isNotEmpty(t)){
						String contactpath=ContentStructure.getContactDocumentPath(t.toLowerCase(),filing_year,username.toLowerCase().replaceAll("@","-at-"));
						String personalpath=ContentStructure.getPersonalDocumentPath(t.toLowerCase(),filing_year,username.toLowerCase().replaceAll("@","-at-"));
						//creating objects of member personal information and member contact information
						MemberPersonalInformation document2=(MemberPersonalInformation) getObjectBeanManager(request).getObject(personalpath);
						MemberContactInformation document3=(MemberContactInformation) getObjectBeanManager(request).getObject(contactpath);
						mpersonalinfo.add(document2);
						mcontactinfo.add(document3);

					}
				}catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//}
				}
			}
			request.setAttribute("mpersonalinfo", mpersonalinfo);
			request.setAttribute("mcontactinfo", mcontactinfo);

		}else{

			try {
				response.sendRedirect("/site/memberLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//checking for notification

		final HippoBean scope = getContentBean(request);
		if (scope == null) {
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			log.warn("Scope bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
					resolvedSiteMapItem.getHstSiteMapItem().getId(),
					resolvedSiteMapItem.getRelativeContentPath());

		}

		int pageSize = GoGreenUtil.getIntConfigurationParameter(request, Constants.PAGE_SIZE, DEFAULT_PAGE_SIZE);

		String currentPageParam = getPublicRequestParameter(request, PARAM_CURRENT_PAGE);
		int currentPage = ComponentUtil.parseIntParameter(PARAM_CURRENT_PAGE, currentPageParam, DEFAULT_CURRENT_PAGE, log);

		String query = this.getPublicRequestParameter(request, "query");
		query = SearchInputParsingUtils.parse(query, false);
		request.setAttribute("query", StringEscapeUtils.escapeHtml(query));

		try {
			final PageableCollection notification = getNotification(request, scope, pageSize, currentPage, query);
			request.setAttribute("notification", notification);


		} catch (QueryException e) {
			throw new HstComponentException("Query error while getting notification: " + e.getMessage(), e);
		}


	}
@Override
public void doAction(HstRequest request, HstResponse response)
		throws HstComponentException {
	// TODO Auto-generated method stub
	super.doAction(request, response);
	
	}

	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);

	}

	private PageableCollection getNotification(HstRequest request, HippoBean scope, int pageSize, int currentPage, String query) throws QueryException {
		List<? extends HippoBean> relatedBeans = getRelatedBeans(request);

		if (!relatedBeans.isEmpty()) {
			// only show tagged notification items
			return new PageableCollection((List<HippoBean>) relatedBeans, pageSize, currentPage);
		}

		final HstQuery hstQuery = getQueryManager(request).createQuery(scope);
		final BaseFilter filter = new PrimaryNodeTypeFilterImpl("mootlywcm:notificationitems");
		hstQuery.setFilter(filter);
		hstQuery.addOrderByDescending("mootlywcm:date");

		if (!StringUtils.isEmpty(query)) {
			final Filter f = hstQuery.createFilter();
			final Filter f1 = hstQuery.createFilter();
			f1.addContains(".", query);
			final Filter f2 = hstQuery.createFilter();
			f2.addContains("mootlywcm:title", query);
			f.addOrFilter(f2);
			hstQuery.setFilter(f);
		}

		if (scope instanceof HippoFacetChildNavigationBean || scope instanceof HippoFacetNavigation) {
			// only show faceted notification items
			final HippoFacetNavigationBean facetBean = BeanUtils.getFacetNavigationBean(request, hstQuery, objectConverter);

			if (facetBean == null) {
				final List<HippoBean> noResults = Collections.emptyList();
				return new PageableCollection(0, noResults);
			} else {
				final HippoResultSetBean resultSet = facetBean.getResultSet();
				final HippoDocumentIterator<NotificationItem> facetIt = resultSet.getDocumentIterator(NotificationItem.class);
				if (hstQuery.getOffset() > 0) {
					facetIt.skip(hstQuery.getOffset());
				}
				final int facetCount = facetBean.getCount().intValue();
				return new PageableCollection(facetIt, facetCount, pageSize, currentPage);
			}
		}

		// show all notification items
		final HstQueryResult result = hstQuery.execute();
		final HippoBeanIterator iterator = result.getHippoBeans();
		return new PageableCollection<NotificationItem>(iterator, pageSize, currentPage);
	}

}