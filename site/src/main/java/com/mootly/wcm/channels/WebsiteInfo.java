/**
 * Copyright (C) 2011 Hippo B.V.
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
package com.mootly.wcm.channels;

import org.hippoecm.hst.configuration.channel.ChannelInfo;
import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;

import com.mootly.wcm.DocumentTypes;

/**
 * Retrieves the properties of the GoGreen channels.
 */
@FieldGroupList({
	@FieldGroup(
            titleKey = "fields.channel",
            value = { "logo", "pageTitlePrefix", "themeCss","contentFolder","startDate","endDate",
			"isReseller","resellerId", 
			"paymentEnabled","paymentAvailableTypes","numberOfLicensedUsers"}
    ),
    @FieldGroup(
            titleKey = "fields.channel.customerservice",
            value = { 
			"emailFrom","emailFromName","emailSignature","emailCustomerService","phoneCustomerService"}
    ),
    @FieldGroup(
            titleKey = "fields.channel.eri",
            value = { 
			"eriEnabled","eriUserId","eriPassword","eriSignature","eriCertChain","eriEnable26ASImport"}
    ),
	@FieldGroup(
            titleKey = "fields.channel.payment",
            value = { 
			"paymentEnabled","paymentAvailableTypes","citrusUserId","citrusPassword"}
	)
})
public interface WebsiteInfo extends ChannelInfo {

    @Parameter(name = "logo")
    @JcrPath(
            pickerSelectableNodeTypes = { DocumentTypes.IMAGE_SET },
            pickerInitialPath = "/content/gallery/logos"
    )
    String getLogoPath();

    @Parameter(name = "pageTitlePrefix", defaultValue = "Mootly WCM")
    String getPageTitlePrefix();

    @Parameter(name = "themeCss", defaultValue = "/content/assets/themes/css/green.css")
    @JcrPath(
            pickerConfiguration = "cms-pickers/assets",
            pickerSelectableNodeTypes = {"hippogallery:exampleAssetSet"},
            pickerInitialPath = "/content/assets/themes/css"
    )
    String getThemeCss();
    
    @Parameter(name = "contentFolder")
    @JcrPath(
    		
            pickerInitialPath = "/content/mootlywcm"
    )
    String getContentFolder();

    @Parameter(name = "startDate", defaultValue = "")
    String getStartDate();

    @Parameter(name = "endDate", defaultValue = "")
    String getEndDate();
    
    @Parameter(name = "isReseller", defaultValue = "false")
    String isReseller();
    
    @Parameter(name = "resellerId", defaultValue = "", required = true)
    String getResellerId();
    
    @Parameter(name = "resellerName", defaultValue = "", required = true)
    String getResellerName();
    
    @Parameter(name = "emailFrom", defaultValue = "info@wealth4india.com", required = true)
    String getEmailFrom();
    
    @Parameter(name = "emailFromName", defaultValue = "info@wealth4india.com", required = true)
    String getEmailFromName();
    
    @Parameter(name = "emailSignature", defaultValue = "Thank You<br/>Wealth4India Team", required = true)
    String getEmailSignature();
    
    @Parameter(name = "emailCustomerService", defaultValue = "info@wealth4india.com", required = true)
    String getEmailCustomerService();
    
    @Parameter(name = "phoneCustomerService", defaultValue = "", required = false)
    String getPhoneCustomerService();
    
    @Parameter(name = "eriEnabled", defaultValue = "false", required = true)
    String getEriEnabled();
    
    @Parameter(name = "eriUserId", defaultValue = "", required = false)
    String getEriUserId();
    
    @Parameter(name = "eriPassword", defaultValue = "", required = false)
    String getEriPassword();
    
    @Parameter(name = "eriSignature", defaultValue = "", required = false)
    String getEriSignature();
    
    @Parameter(name = "eriCertChain", defaultValue = "", required = false)
    String getEriCertChain();
    
    @Parameter(name = "eriEnable26ASImport", defaultValue = "false", required = false)
    String getEriEnable26ASImport();
    
    
    @Parameter(name = "paymentEnabled", defaultValue = "true", required = true)
    String getPaymentEnabled();
    
    @Parameter(name = "paymentAvailableTypes", defaultValue = "CHECK,CASH,RTGS", required = true)
    String getPaymentAvailableTypes();
    
    @Parameter(name = "citrusUserId", defaultValue = "", required = false)
    String getCitrusUserId();
    
    @Parameter(name = "citrusPassword", defaultValue = "", required = false)
    String getCitrusPassword();
    
    
    @Parameter(name = "numberOfLicensedUsers", defaultValue = "1", required = true)
    String getNumberOfLicensedUsers();
    //other website features
}
