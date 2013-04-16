/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.components.common;

import java.util.Iterator;
import java.util.List;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.sitemenu.EditableMenu;
import org.hippoecm.hst.core.sitemenu.HstSiteMenu;
import org.hippoecm.hst.core.sitemenu.HstSiteMenuItem;
import org.hippoecm.hst.core.sitemenu.HstSiteMenus;

import com.mootly.wcm.beans.Document;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.utils.GoGreenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteMenu extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(SiteMenu.class);
	

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        
        String siteMenuName = GoGreenUtil.getSiteMenuName(this, request);
        HstSiteMenu menu = request.getRequestContext().getHstSiteMenus().getSiteMenu(siteMenuName);
        menu = new WrappedSiteMenu(menu, request.isUserInRole("reseller"));
        request.setAttribute("menu", menu);

        HippoBean bean = getContentBean(request);
        boolean detailPage = false;
        if (bean instanceof Document) {
            detailPage = true;
        }
        request.setAttribute("detailPage", detailPage);
        
        Member member=(Member)request.getSession().getAttribute("user");
  		if(member!=null){
  			
  			String email = member.getEmail();
  			request.setAttribute("email", email);
  			
  			}
  			
    }

    public class WrappedSiteMenu implements HstSiteMenu {

        private final HstSiteMenu siteMenu;
        private final boolean isReseller;
        
        private WrappedSiteMenu(HstSiteMenu siteMenu, boolean isReseller) {
            this.siteMenu = siteMenu;
            this.isReseller = isReseller;
        }
        
        @Override
        public String getName() {
            return siteMenu.getName();
        }

        @Override
        public boolean isExpanded() {
            return siteMenu.isExpanded();
        }

        @Override
        public HstSiteMenuItem getSelectSiteMenuItem() {
            return siteMenu.getSelectSiteMenuItem();
        }

        @Override
        public List<HstSiteMenuItem> getSiteMenuItems() {
            List<HstSiteMenuItem> items = siteMenu.getSiteMenuItems();
            if (!isReseller) {
                Iterator<HstSiteMenuItem> iter = items.iterator();
                while (iter.hasNext()) {
                    HstSiteMenuItem item = iter.next();
                    if (item.getParameter("reselleronly") != null) {
                        iter.remove();
                    }
                }
            }
            return items;
        }

        @Override
        public HstSiteMenus getHstSiteMenus() {
            return siteMenu.getHstSiteMenus();
        }

        @Override
        public HstSiteMenuItem getDeepestExpandedItem() {
            return siteMenu.getDeepestExpandedItem();
        }

        @Override
        public EditableMenu getEditableMenu() {
            return siteMenu.getEditableMenu();
        }
        
    }
}
