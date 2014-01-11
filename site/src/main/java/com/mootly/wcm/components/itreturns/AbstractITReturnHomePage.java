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
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
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
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.hippoecm.hst.util.SearchInputParsingUtils;
import org.hippoecm.hst.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Product;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.components.ComponentUtil;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnHomePageView;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.FreeTextSearchSreviceImpl;
import com.mootly.wcm.services.MasterConfigService;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.StartApplicationValidationService;
import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;
import com.mootly.wcm.utils.Constants;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.PageableCollection;
//@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
@FormFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","pi_mobile"})
@RequiredFields(fieldNames={"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","pi_mobile"})
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
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		//set Parameter if on call of DIT service PAN Match Not Found
		request.setAttribute("noPanMatchFound", request.getParameter("noPanMatchFound"));
		//set parameter if Last name does not Match with PAN
		request.setAttribute("valiPanWithLastNameError", request.getParameter("valiPanWithLastNameError"));
		HippoFolder hippoFolder = getITRInitData(request).getPanFolder();
		List<HippoFolderBean> pansForMember = null;
		HippoBean currentBean = null;
		if (hippoFolder != null) {
			pansForMember = hippoFolder.getFolders(); 
			if (pansForMember != null) currentBean = pansForMember.get(0);
		}
		//if (currentBean == null) {
		//	return;
		//}
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
		try{
			String createValueListPath = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath()+"/common/valuelists/";
			ValueListDocument valueListDocument = (ValueListDocument) getObjectBeanManager(request).getObject(createValueListPath+"freetextsearchvaluelist");
			request.setAttribute("valueListDocument", valueListDocument);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error While get the Object at path in repository",e);
		}
		//hack on search.not use query search.empty query so that we have all page collection which have PersonalInformation(serviceRequest)
		String PAYMENT_QUERY = null;
		if(StringUtils.isNotBlank(query) && getITRInitData(request).isOnVendorPortal()){ 
			PAYMENT_QUERY=query;
			query="";
		}

		HstQuery hstQuery = createMemberHomePageHstQuery(request, query, order, orderBy, from, jsEnabled);

		Map<String, Object> hstQueryResulSettMap = generatePageCollectionResultOfHstQuery(request, currentBean, hstQuery, pageSize, currentPage);

		PageableCollection pages=(PageableCollection) hstQueryResulSettMap.get("pages");
		long resultCount = (Long) hstQueryResulSettMap.get("resultCount");

		request.setAttribute("docs", pages);
		List<ITReturnHomePageView> listOfITReturnHomePageView = new ArrayList<ITReturnHomePageView>();
		if (pages != null) {
			for (Object o:pages.getItems()) {
				try {
					MemberPersonalInformation m = (MemberPersonalInformation) o;
					HippoFolder theParentofPersonalInfo=(HippoFolder) m.getParentBean();
					MemberPayment memberPaymentDocs = theParentofPersonalInfo.getBean("memberpayment", MemberPayment.class);
					if(PAYMENT_QUERY!=null && getITRInitData(request).isOnVendorPortal()){
						FreeTextSearchSreviceImpl freeTextSearchSreviceImpl = new FreeTextSearchSreviceImpl();
						if(freeTextSearchSreviceImpl.getFreeTextResultOnMember(m, PAYMENT_QUERY, memberPaymentDocs)){
							listOfITReturnHomePageView.add(createITReturnPageView(m, request));
						}
					}else{
						listOfITReturnHomePageView.add(createITReturnPageView(m, request));
					}
				}catch (Exception ex) {
					log.warn("Error",ex);
				}
			}
			//at above we have only 25 element due to limit page size so not some time not have in query 
			//to overcome this we will regenrate page collection and now find query in this.
			if(listOfITReturnHomePageView.isEmpty() && getITRInitData(request).isOnVendorPortal()){
				Long RepageSize = pages.getTotal();
				Map<String, Object> RehstQueryResulSettMap = generatePageCollectionResultOfHstQuery(request, currentBean, hstQuery, RepageSize.intValue(), currentPage);
				PageableCollection Repages=(PageableCollection) RehstQueryResulSettMap.get("pages");
				if(Repages!=null){
					for (Object o:Repages.getItems()) {
						MemberPersonalInformation m = (MemberPersonalInformation) o;
						FreeTextSearchSreviceImpl freeTextSearchSreviceImpl = new FreeTextSearchSreviceImpl();
						if(freeTextSearchSreviceImpl.getFreeTextResultOnMember(m, PAYMENT_QUERY, m)){
							listOfITReturnHomePageView.add(createITReturnPageView(m, request));
						}
					}
				}
			}
			request.setAttribute("listOfITReturnHomePageView", listOfITReturnHomePageView);		
		}
		/*
		String facetLocation= "vendors/faceteditreturns";
		HippoBean vendorFolder = getSiteContentBaseBeanForReseller(request).getBean("vendors");
		HippoBean theFacet = vendorFolder.getBean("itreturnsfacetnav");
		HippoFacetsAvailableNavigation facetNavigation = getSiteContentBaseBean(request).getBean(facetLocation, HippoFacetsAvailableNavigation.class);
		if (facetNavigation != null) {
			request.setAttribute("facets", facetNavigation.getFolders());
		}
		*/
		request.setAttribute("count", resultCount);
		Boolean isReseller = request.isUserInRole("reseller");
		request.setAttribute("reseller", isReseller);

	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		//super.doAction(request, response);
		//FormMap map = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy","ack_no","ack_date","defective","notice_no","notice_date"});
		FormMap map = new FormMap(request,new String[]{"pan","pi_last_name","pi_dob","pi_return_type","fy","ReturnSection","pi_mobile"});
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
		//validate pan's 5thCahr with LastName's 1stChar
		StartApplicationValidationService applicationValidationService = new StartApplicationValidationService();
		applicationValidationService.validLastName(map);
		if (map.getMessage() != null && map.getMessage().size() > 0) {
			response.setRenderParameter("valiPanWithLastNameError", "true");
			return;
		}
		/*
		if(shouldValidatePANWithDIT()){
			RetrievePANInformation retrievePANInformation =  getRetrievePANInformationService();
			//Boolean defContinueInvalidPAN = Boolean.valueOf(map.getField("invalidSubmit").getValue());
			MasterConfigService configService = MasterConfigService.getInstance();
			Boolean defContinueInvalidPAN = configService.shouldContinueWithInvalidPAN();
			try {
				RetrievePANResponse retrievePANResponse = retrievePANInformation.retrievePANInformation(pan);
				if(retrievePANResponse != null && StringUtils.isNotBlank(retrievePANResponse.getError()) && !defContinueInvalidPAN){
					log.warn("Error while Match Pan with DIT"+retrievePANResponse.getError());
					response.setRenderParameter("noPanMatchFound", "true");
					return;
				}
			} catch (MissingInformationException e) {
				// TODO Auto-generated catch block
				log.error("Error while Calling Dit Mock Service due to lack of Information",e);
			} catch (DataMismatchException e) {
				// TODO Auto-generated catch block
				log.error("Error while Mocking Dit Service for Pan Information due to Data Missed",e);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				log.error("Error while Mocking Dit Service for Pan Information due to Invalid Format of Inputs",e);
			}
		}
		*/

		StoreFormResult sfr = new StoreFormResult();				
		FormUtils.persistFormMap(request, response, map, sfr);
		//FormUtils.persistFormMap(request, response, getFormMap(), sfr);
		Long nextId = getSequenceGenerator().getNextId(SequenceGenerator.SEQUENCE_FOLDER_NAME);
		if (nextId == 0) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		// sending email to admin of wealth4india :- by Pankaj Singh
		String StartApp_Mobile = map.getField("pi_mobile").getValue();
		Map<String,Object> velocityContext = new HashMap<String, Object>();
		velocityContext.put("userName",getITRInitData(request).getUserName());
		velocityContext.put("pi_mobile", StartApp_Mobile);
		velocityContext.put("StartApp_Mobile", StartApp_Mobile);
		sendEmail(request, null, null, null, "memberstartapptemplate", velocityContext);
		// end of code for sending email
		String returnURL =  getHippoRequestURL(request, true, true) + "/member/itreturn/" + financialYear.getDisplayName() + "/" + pan.toLowerCase() + "_f_"  + nextId  + "/" + pan.toLowerCase() + "/servicerequest-itr.html?uuid=" +  sfr.getUuid(); //getRedirectURL(request, response, FormSaveResult.SUCCESS,"packageselector",financialYear,itReturnType,pan);
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

	public static ITReturnHomePageView createITReturnPageView(MemberPersonalInformation m,HstRequest request){
		String paymentStatus = "";String paymentType = "None";

		String theParentFolder = m.getParentBean().getName();
		HippoFolder theMemberFolderBean = (HippoFolder) m.getParentBean().getParentBean().getParentBean().getParentBean().getParentBean();

		ITReturnHomePageView itReturnHomePageView = new ITReturnHomePageView();

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
		itReturnHomePageView.setPathToItr(theMemberFolderBean.getPath()); //the Path can we find the member name who filed it?
		itReturnHomePageView.setTheParentFolder(theParentFolder);//itReturnHomePageView.getPan().toLowerCase()+itReturnHomePageView.getItrFolderSuffix());
		//logic for Payment Status
		List<MemberPayment> listOfMemberPaymentDocs = new ArrayList<MemberPayment>();
		HippoFolder theParentofPersonalInfo=(HippoFolder) m.getParentBean();
		listOfMemberPaymentDocs=theParentofPersonalInfo.getChildBeans(MemberPayment.class);
		if(listOfMemberPaymentDocs.size()>0){
			for(MemberPayment py:listOfMemberPaymentDocs){
				if(py.getPaymentVerificationStatus()!=null){
					if(py.getPaymentVerificationStatus().equals(PaymentVerificationStatus.VERIFIED)){
						paymentStatus ="VERIFIED";
						paymentType = py.getPaymentType().name();
					}
					if(py.getPaymentVerificationStatus().equals(PaymentVerificationStatus.UNVERIFIED)){
						paymentStatus="UNVERIFIED";
						paymentType = py.getPaymentType().name();
					}
				}
			}
		}else{
			paymentStatus="DUE";
		}
		itReturnHomePageView.setPaymentStatus(paymentStatus);
		itReturnHomePageView.setPaymentType(paymentType);
		return itReturnHomePageView;
	}
	/**
	 * This method is used to create the HST Query.
	 * 
	 * @param request {@link HstRequest}
	 * @param query {@link String} Query issued by user as free text search
	 * @param order {@link String} Order of result in Asc/Desc
	 * @param orderBy {@link String} OrderBy from which property respect Order content
	 * @param from {@link String}
	 * @param jsEnabled {@link String}
	 * 
	 * @return {@link HstQuery} Created Query to get Results
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public HstQuery createMemberHomePageHstQuery(HstRequest request,String query,String order,String orderBy,String from,String jsEnabled){
		HstQuery hstQuery=null;
		try {
			HippoBean theScopeBean = getScope(request);
			if (log.isInfoEnabled()) {
				log.info("theScopeBean:" + theScopeBean.getName());
			}
			hstQuery = getQueryManager(request).createQuery(theScopeBean, MemberPersonalInformation.class);
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
	/**
	 * This method is used to create {@link PageableCollection} based on requested {@link HstQuery}
	 * 
	 * @param request {@link HstRequest}
	 * @param currentBean {@link HippoBean}
	 * @param hstQuery {@link HstQuery} requested hstQuery 
	 * @param pageSize size of page 
	 * @param currentPage Page Number of requested Page.
	 * 
	 * @return {@link PageableCollection} result of {@link HstQuery} 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String ,Object> generatePageCollectionResultOfHstQuery(HstRequest request,HippoBean currentBean,HstQuery hstQuery,int pageSize,int currentPage){
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
		return resultOFHstQuery;
	}
}
