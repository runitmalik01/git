package com.mootly.wcm.components.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.TrackingDefinition;
import com.mootly.wcm.services.ITRScreenXmlValidateServiceImpl;

/**
 * Track component for Documents
 */
//@TrackingBeans(trackBeanClass={Review.class},propertyName={""},scope={"reviews"})
//@ParametersInfo(type = TrackComponentParamsInfo.class)
public class TrackComponent extends ITReturnComponent {

	public static final Logger log = LoggerFactory.getLogger(TrackComponent.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		HippoBean targetBeanScope = null;
		//TrackComponentParamsInfo paramsInfo = getParametersInfo(request);
		HippoBean siteContentBaseBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request);//getSiteContentBaseBean(request);//
		if(siteContentBaseBean == null){
			if(log.isInfoEnabled()){
				log.info("Site content Bean is { } null.Not able to proceed.");
			}
		}
		targetBeanScope = siteContentBaseBean;
		Map<String,List<HippoBean>> listfetchDocuments = new HashMap<String,List<HippoBean>>();
		/*TrackingBeans trackingBeans = getClass().getAnnotation(TrackingBeans.class);
		Class<? extends HippoBean>[] trackBeanClass = trackingBeans.trackBeanClass();
		String[] beanScopes = trackingBeans.scope();
		Map<String,List<HippoBean>> listfetchDocuments = new HashMap<String,List<HippoBean>>();
		if(trackBeanClass != null){
			for(int i=0;i < trackBeanClass.length;i++){
				List<HippoBean> theLocalBeansUnderFolder = new ArrayList<HippoBean>(); 
				String jcrNode = trackBeanClass[i].getAnnotation(org.hippoecm.hst.content.beans.Node.class).jcrType();
				if(beanScopes!=null){
					if(siteContentBaseBean.getBean(beanScopes[i]) != null){
						targetBeanScope = siteContentBaseBean.getBean(beanScopes[i]);
					}
				}
				try {
					HstQuery hstQuery = getQueryManager(request).createQuery(targetBeanScope, jcrNode);
					Filter hstFilter = hstQuery.createFilter();
					hstFilter.addEqualTo("hippostd:state", "unpublished");
					final HstQueryResult result = hstQuery.execute();
					Iterator<HippoBean> itResults = result.getHippoBeans();
					if (log.isInfoEnabled()) {
						log.info("Now will look into all HippoDocuments under the same folder and make a copy of each"+result.getSize());
					}
					for (;itResults.hasNext();) {
						HippoBean hippoBean = itResults.next();
						if (hippoBean instanceof HippoDocumentBean) {
							theLocalBeansUnderFolder.add(hippoBean);
						}
					}
					listfetchDocuments.put(String.valueOf(i), theLocalBeansUnderFolder);
				} catch (QueryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				targetBeanScope = siteContentBaseBean;
			}
			request.setAttribute("listfetchDocuments", listfetchDocuments);
		}*/
		List<TrackingDefinition> trackingDefs = TrackingDefinition.getOnTrakers();
		if(!trackingDefs.isEmpty()){
			for(TrackingDefinition trackingDef:trackingDefs){
				List<HippoBean> theLocalBeansUnderFolder = new ArrayList<HippoBean>();
				String jcrNode = trackingDef.getDocumentBean().getAnnotation(org.hippoecm.hst.content.beans.Node.class).jcrType();
				if(StringUtils.isNotBlank(trackingDef.getScope())){
					targetBeanScope = siteContentBaseBean.getBean(trackingDef.getScope());
				}
				//trail for the reviews.
				if(targetBeanScope == null){
					//HippoBean trialBeanScope = getSiteContentBaseBean(request);
					//targetBeanScope = trialBeanScope.getBean(trackingDef.getScope());
					listfetchDocuments.put(trackingDef.getTrackerName(), theLocalBeansUnderFolder);
					continue;
				}
				try {
					HstQuery hstQuery = getQueryManager(request).createQuery(targetBeanScope, jcrNode);
					Filter hstFilter = hstQuery.createFilter();
					if(!trackingDef.isHaveChild()){
						switch(trackingDef.getProperty().getValidateType()){
						case EQUALITY: 
							hstFilter.addEqualTo(trackingDef.getProperty().getPropertyName(), trackingDef.getProperty().getValueToValidate());
							break;
						case MAX_ALLOWED:
							hstFilter.addLessOrEqualThan(trackingDef.getProperty().getPropertyName(), trackingDef.getProperty().getValueToValidate());
							break;
						case MIN_ALLOWED:
							hstFilter.addGreaterOrEqualThan(trackingDef.getProperty().getPropertyName(), trackingDef.getProperty().getValueToValidate());
							break;
						default: 
							break;
						}	
					}
					if (log.isInfoEnabled()) {
						log.info("Lets Observe Query :::"+hstQuery.getQueryAsString(true));
					}
					final HstQueryResult result = hstQuery.execute();
					Iterator<HippoBean> itResults = result.getHippoBeans();
					if (log.isInfoEnabled()) {
						log.info("Now will look into all HippoDocuments under the same folder and make a copy of each"+result.getSize());
					}
					for (;itResults.hasNext();) {
						HippoBean hippoBean = itResults.next();
						if (hippoBean instanceof HippoDocumentBean) {
							theLocalBeansUnderFolder.add(hippoBean);
						}
					}
					if(trackingDef.isHaveChild()){
						OperateOnChildBean(theLocalBeansUnderFolder,trackingDef);
					}
					listfetchDocuments.put(trackingDef.getTrackerName(), theLocalBeansUnderFolder);
				} catch (QueryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("listfetchDocuments", listfetchDocuments);
		}
	}
	public void OperateOnChildBean(List<HippoBean> theLocalBeansUnderFolder, TrackingDefinition trackingDef){
		ITRScreenXmlValidateServiceImpl serviceImpl = new ITRScreenXmlValidateServiceImpl();
		if(!theLocalBeansUnderFolder.isEmpty()){
			List<HippoBean> dummyHippoBeanList = new ArrayList<HippoBean>();
			dummyHippoBeanList.addAll(theLocalBeansUnderFolder);
			for(HippoBean thehippoBean:dummyHippoBeanList){
				boolean excludeDoc = true;
				if(trackingDef.getProperty().getDocumentBean() != null){
					String jcrNode = null;
					org.hippoecm.hst.content.beans.Node node;
					node = trackingDef.getProperty().getDocumentBean().getAnnotation(org.hippoecm.hst.content.beans.Node.class);
					if(node != null){
						jcrNode = node.jcrType();
					}
					List<HippoBean> listOfChildBeans = thehippoBean.getChildBeans(jcrNode);
					if(!listOfChildBeans.isEmpty()){
						for(HippoBean childBean:listOfChildBeans){
							Object object = childBean.getProperty(trackingDef.getProperty().getPropertyName());
							if(object != null){
								switch(trackingDef.getProperty().getValidateType()){
								case MAX_ALLOWED:
									excludeDoc = serviceImpl.getMaxPropertyValidate(object, trackingDef.getProperty());//false
									break;
								case MIN_ALLOWED:
									excludeDoc = serviceImpl.getMinPropertyValidate(object, trackingDef.getProperty());
									break;
								case EQUALITY:
									excludeDoc = serviceImpl.getEqualPropertyValidate(object, trackingDef.getProperty());
									break;
								default:
									break;
								}
							}
						}
					}
					if(excludeDoc){
						if(theLocalBeansUnderFolder.contains(thehippoBean)){
							theLocalBeansUnderFolder.remove(thehippoBean);	
						}
					}
					if (log.isInfoEnabled()) {
						log.info("Lets see the result of operate Bean"+excludeDoc);
					}
				}
			}
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}
