/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.components.common;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.exceptions.BeanTypeException;
import com.mootly.wcm.model.ITRForm;
@ParametersInfo(type = ServicePriceParamsInfo.class)
public class ServicePrice extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(ServicePrice.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		//HippoBean bean = getContentBean(request);
		String pricingRelativeContentPath = request.getRequestContext().getResolvedSiteMapItem().getRelativeContentPath();
		String excludePricingNames = null;
		//log.info("Lets see Relavtive Content Path::"+pricingRelativeContentPath);
		/* Changes made for Catalog Item of PRICING. **/
		ServicePriceParamsInfo paramsInfo = getParametersInfo(request);
		if(paramsInfo!=null){
			pricingRelativeContentPath = paramsInfo.getPricingPlanLocation();
			excludePricingNames = paramsInfo.getExcludePricings();
		}

		HippoBean bean = getSiteContentBaseBeanForReseller(request).getBean(pricingRelativeContentPath);//Reseller Module Implementation.
		//log.info("Content Bean as :::"+getSiteContentBaseBeanForReseller(request).getName());
		if (bean == null) {
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			log.warn("Cannot create document list: content bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
					resolvedSiteMapItem.getHstSiteMapItem().getId(),
					resolvedSiteMapItem.getRelativeContentPath());
			return;
		} else if (bean instanceof HippoFolderBean) {
			HippoFolderBean folder = (HippoFolderBean) bean;
			List<HippoDocumentBean> documents = folder.getDocuments();
			if(!StringUtils.isBlank(excludePricingNames)){
				if(StringUtils.contains(excludePricingNames, ',')){
					for(String exPricingNam:excludePricingNames.split(",")){
						getReStructureList(documents, exPricingNam);
					}
				} else{
					getReStructureList(documents, excludePricingNames);
				}
			}
			request.setAttribute("documents", documents);
		} else {
			throw new BeanTypeException("Cannot create document list: " + bean.getPath() + " is not a folder");
		}
		//"who can not" choose package
		Map<String,String> WhoCanNot = new HashMap<String, String>();
		ResourceBundle rsbundle=ResourceBundle.getBundle("messages");
		for(ITRForm itr:ITRForm.values()){
			if(itr!=ITRForm.UNKNOWN){
				String packNameKey=itr.getDisplayName().replaceAll("-", "")+".packageName";  
				String whoCannotKey=itr.getDisplayName().replaceAll("-", "")+".whoCannot";   
				if(rsbundle.containsKey(packNameKey) && rsbundle.containsKey(whoCannotKey)){
					WhoCanNot.put(rsbundle.getString(packNameKey).toUpperCase(),whoCannotKey);
				}
			}
		}
		request.setAttribute("whoCannot", WhoCanNot);
		//"who can" choose package 
		Map<String,String> WhoCan = new HashMap<String, String>();
		for(ITRForm itr:ITRForm.values()){
			if(itr!=ITRForm.UNKNOWN){
				String packNameKey=itr.getDisplayName().replaceAll("-", "")+".packageName";  
				String whoCanKey=itr.getDisplayName().replaceAll("-", "")+".whoCan";   
				if(rsbundle.containsKey(packNameKey) && rsbundle.containsKey(whoCanKey)){
					WhoCan.put(rsbundle.getString(packNameKey).toUpperCase(),whoCanKey);
				}
			}
		}
		request.setAttribute("whoCan", WhoCan);
	} 
	/**
	 * This method is used to exclude the {@link HippoDocumentBean} of Name excludeDocName from {@link List} 
	 * 
	 * @param documents {@link HippoDocumentBean}
	 * @param excludeDocName {@link String}
	 * 
	 * @return {@link HippoDocumentBean}
	 * */
	public List<HippoDocumentBean> getReStructureList(List<HippoDocumentBean> documents ,String excludeDocName){
		for(HippoDocumentBean documentBean:documents){
			if(!StringUtils.isBlank(excludeDocName)){
				if(documentBean.getName().equalsIgnoreCase(excludeDocName)){
					log.info("Have the Docuemnt Bean to Exclude::");
					documents.remove(documentBean);
				}
			}
		}
		return documents;
	} 

} 

