/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.components.itreturns;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.component.support.forms.StoreFormResult;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentIterator;
import org.hippoecm.hst.content.beans.standard.HippoFacetChildNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetNavigationBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.content.beans.standard.HippoResultSetBean;
import org.hippoecm.hst.content.beans.standard.facetnavigation.HippoFacetNavigation;
import org.hippoecm.hst.content.beans.standard.facetnavigation.HippoFacetsAvailableNavigation;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.util.SearchInputParsingUtils;
import org.hippoecm.hst.utils.BeanUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Product;
import com.mootly.wcm.components.ComponentUtil;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.products.OverviewParamInfo;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnHomePageView;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.SequenceGeneratorImpl;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.PageableCollection;
//@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
@FormFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","StartApp_Mobile"})
@RequiredFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","StartApp_Mobile"})
abstract public class AbstractITReturnHomePage extends ITReturnComponent {

	private static final String PARAM_PAGE_SIZE = "pageSize";
	private static final int DEFAULT_PAGE_SIZE = 25;
	private static final String PARAM_CURRENT_PAGE = "pageNumber";
	private static final int DEFAULT_CURRENT_PAGE = 1;
	private static final int DEFAULT_SHOW_MORE = 25;	
	private static final String PARAM_ORDER_BY = "orderBy";
	private static final String DEFAULT_ORDER_BY = "hippostdpubwf:lastModificationDate";


	private static final Logger log = LoggerFactory.getLogger(AbstractITReturnHomePage.class);
	
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {

		super.doBeforeRender(request, response);			
		List<HippoFolderBean> pansForMember = getPanFolder().getFolders(); 
		HippoBean currentBean = pansForMember.get(0); //this.getContentBean(request);
		if (currentBean == null) {
			return;
		}
		request.setAttribute("defaultShowMore", DEFAULT_SHOW_MORE);

		String pageSizeParam = getPublicRequestParameter(request, PARAM_PAGE_SIZE);
		if (pageSizeParam == null || "".equals(pageSizeParam)) {
			pageSizeParam = getParameter(PARAM_PAGE_SIZE, request);
		}
		int pageSize = ComponentUtil.parseIntParameter(PARAM_PAGE_SIZE, pageSizeParam, DEFAULT_PAGE_SIZE, log);
		request.setAttribute("pageSize", pageSize);

		String currentPageParam = getPublicRequestParameter(request, PARAM_CURRENT_PAGE);
		int currentPage = ComponentUtil.parseIntParameter(PARAM_CURRENT_PAGE, currentPageParam, DEFAULT_CURRENT_PAGE, log);

		String orderBy = getParameter(PARAM_ORDER_BY, request);
		if (orderBy == null || "".equals(orderBy)) {
			orderBy = DEFAULT_ORDER_BY;
		}

		String query = this.getPublicRequestParameter(request, "query");
		query = SearchInputParsingUtils.parse(query, false);
		request.setAttribute("query", StringEscapeUtils.escapeHtml(query));

		String order = this.getPublicRequestParameter(request, "order");
		request.setAttribute("order", StringEscapeUtils.escapeHtml(order));

		String from = this.getPublicRequestParameter(request, "from");
		String jsEnabled = getPublicRequestParameter(request, "jsEnabled");

		try {
			HippoBean theScopeBean = getScope(request);
			if (log.isInfoEnabled()) {
				log.info("theScopeBean:" + theScopeBean.getName());
			}
			HstQuery hstQuery = this.getQueryManager(request).createQuery(theScopeBean, MemberPersonalInformation.class);
			if (!StringUtils.isEmpty(query)) {
				Filter f = hstQuery.createFilter();
				Filter f1 = hstQuery.createFilter();
				f1.addContains(".", query);
				Filter f2 = hstQuery.createFilter();
				f2.addContains("mootlywcm:title", query);
				f.addOrFilter(f1);
				f.addOrFilter(f2);
				hstQuery.setFilter(f);
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

			PageableCollection pages;
			long resultCount = 0;

			if (!(currentBean instanceof HippoFacetChildNavigationBean || currentBean instanceof HippoFacetNavigation)) {
				final HstQueryResult result = hstQuery.execute();
				pages = new PageableCollection<HippoBean>(result.getHippoBeans(), pageSize, currentPage);
				resultCount = result.getSize();
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
			request.setAttribute("docs", pages);
			List<ITReturnHomePageView> listOfITReturnHomePageView = new ArrayList<ITReturnHomePageView>();
			if (pages != null) {
				for (Object o:pages.getItems()) {
					try {
						MemberPersonalInformation m = (MemberPersonalInformation) o;
						String thePath = m.getNode().getPath();
						String theParentFolder = m.getParentBean().getName();
						
						log.info(thePath);
						HippoFolder theMemberFolderBean = (HippoFolder) m.getParentBean().getParentBean().getParentBean().getParentBean().getParentBean();
						log.info(theMemberFolderBean.getNode().getPath());
						
						ITReturnHomePageView itReturnHomePageView = new ITReturnHomePageView();
						
						itReturnHomePageView.setTheParentFolder(theParentFolder);

						itReturnHomePageView.setPan(m.getPAN());
						FinancialYear fy = FinancialYear.getByDisplayName(m.getFinancialYear());
						itReturnHomePageView.setFinancialYear(fy);
						
						FilingSection filingSection = FilingSection.getByXmlCode(m.getReturnSection());
						itReturnHomePageView.setFilingSection(filingSection);
						
						String itrFolderSuffix = ITReturnType.getByFolderSuffix(theParentFolder);
						itReturnHomePageView.setItrFolderSuffix(itrFolderSuffix);
						
						ITReturnType itReturnType = ITReturnType.getByXmlStatus(m.getReturnType());
						itReturnHomePageView.setItReturnType(itReturnType);
						
						FilingStatus filingStatus = FilingStatus.getByXmlCode( m.getFilingStatus() );
						itReturnHomePageView.setFilingStatus(filingStatus);
						itReturnHomePageView.setLastOrOrgName(m.getLastName());
						itReturnHomePageView.setITRForm(m.getSelectedITRForm());
						itReturnHomePageView.setITRFormMode(m.getSelectedServiceDeliveryOption());
						itReturnHomePageView.setEmail(m.getEmail());
						itReturnHomePageView.setDOB(m.getDOBStr());
						itReturnHomePageView.setFullName(m.getName());
						
						String stringUUID= theMemberFolderBean.getCanonicalUUID();
						itReturnHomePageView.setCanonicalUUID(stringUUID);
						
						itReturnHomePageView.setPathToItr(theMemberFolderBean.getPath()); //the Path
						//can we find the member name who filed it?
						
						
						listOfITReturnHomePageView.add(itReturnHomePageView);
						
						
					}catch (Exception ex) {
						log.warn("Error",ex);
					}
				}
				request.setAttribute("listOfITReturnHomePageView", listOfITReturnHomePageView);		
			}
			String facetLocation= "vendors/faceteditreturns";
			HippoBean vendorFolder = getSiteContentBaseBean(request).getBean("vendors");
			HippoBean theFacet = vendorFolder.getBean("itreturnsfacetnav");
			HippoFacetsAvailableNavigation facetNavigation = getSiteContentBaseBean(request).getBean(facetLocation, HippoFacetsAvailableNavigation.class);
	        if (facetNavigation != null) {
	            request.setAttribute("facets", facetNavigation.getFolders());
	        }
			
			request.setAttribute("count", resultCount);
			Boolean isReseller = request.isUserInRole("reseller");
			request.setAttribute("reseller", isReseller);
		}
		catch (QueryException qe) {
			log.error("Error while getting the documents " + qe.getMessage(), qe);
		}
	
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		//super.doAction(request, response);
		//FormMap map = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy","ack_no","ack_date","defective","notice_no","notice_date"});
		FormMap map = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","StartApp_Mobile"});
		//FormUtils.persistFormMap(request, response, getFormMap(), null);
		//try {
		String pan =map.getField("pan").getValue().toLowerCase();
		//String strItReturnType =  map.getField("pi_return_type").getValue();
		//ITReturnType itReturnType = ITReturnType.getByDisplayName(strItReturnType);
		String strFinancialYear =  map.getField("fy").getValue();
		FinancialYear financialYear = FinancialYear.getByDisplayName(strFinancialYear);
		//FilingSection filingSection =  FilingSection.getByXmlCode(map.getField("ReturnSection").getValue());

		if (StringUtils.isEmpty(pan) || StringUtils.isEmpty(strFinancialYear)){
			return;
		}

		if (financialYear == null || financialYear.equals(FinancialYear.UNKNOWN)){
			return;
		}
		/*
		if (filingSection == null || filingSection == FilingSection.UNKNOWN) {
			return;
		}
		*/
		
		if (!DataTypeValidationHelper.isOfType(pan, DataTypeValidationType.PAN)) {
			return;
		}

		StoreFormResult sfr = new StoreFormResult();				
		FormUtils.persistFormMap(request, response, map, sfr);
		//FormUtils.persistFormMap(request, response, getFormMap(), sfr);
		Long nextId = getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_FOLDER_NAME);
		if (nextId == 0) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		// sending email to admin of wealth4india :- by Pankaj Singh
		
		String StartApp_Mobile = map.getField("StartApp_Mobile").getValue();
		Map<String,Object> velocityContext = new HashMap<String, Object>();
		velocityContext.put("userName",getUserName());
		velocityContext.put("StartApp_Mobile", StartApp_Mobile);
		sendEmail(request, null, null, null, "memberstartapptemplate", velocityContext);
		// end of code for sending email
		String returnURL =  request.getContextPath() +"/member/itreturn/" + financialYear.getDisplayName() + "/" + pan.toLowerCase() + "_f_"  + nextId  + "/" + pan.toLowerCase() + "/servicerequest-itr.html?uuid=" +  sfr.getUuid(); //getRedirectURL(request, response, FormSaveResult.SUCCESS,"packageselector",financialYear,itReturnType,pan);
		//returnURL +="?uuid=" + 
		try {
			response.sendRedirect(returnURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//} catch (IOException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	
	abstract public HippoBean getScope(HstRequest request);
	
}
