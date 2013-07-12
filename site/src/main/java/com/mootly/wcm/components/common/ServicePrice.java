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

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.exceptions.BeanTypeException;
import com.mootly.wcm.model.ITRForm;
public class ServicePrice extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(ServicePrice.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		HippoBean bean = getContentBean(request);

		if (bean == null) {
			ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
			log.warn("Cannot create document list: content bean not found; please check the relative content path for sitemap item: {}. Relative content path: {}.", 
					resolvedSiteMapItem.getHstSiteMapItem().getId(),
					resolvedSiteMapItem.getRelativeContentPath());
			return;
		} else if (bean instanceof HippoFolderBean) {
			HippoFolderBean folder = (HippoFolderBean) bean;
			List<HippoDocumentBean> documents = folder.getDocuments();
			request.setAttribute("documents", documents);
		} else {
			throw new BeanTypeException("Cannot create document list: " + bean.getPath() + " is not a folder");
		}
		Map<String,String> WhoCanNot = new HashMap<String, String>();
		/**
		 * 
		 * 
		 * To take value of "Who Can not File given ITRs" from message.properties  (not form CMS)
		 * 
		 * */
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
	} 

}
