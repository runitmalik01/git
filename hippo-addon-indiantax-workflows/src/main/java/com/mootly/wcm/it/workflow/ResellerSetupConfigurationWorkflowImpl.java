/*
 *  Copyright 2011 Hippo.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mootly.wcm.it.workflow;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.hippoecm.repository.standardworkflow.WorkflowEventWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PersistenceCapable
public class ResellerSetupConfigurationWorkflowImpl extends WorkflowImpl implements WorkflowEventWorkflow {
	//	private final Logger logger = LoggerFactory.getLogger(ResellerSetupConfigurationWorkflowImpl.class);

	private static final long serialVersionUID = 1L;
	
	private final static String SELECT_GROUP_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' AND fn:name='{}'";

	@SuppressWarnings("unused")
	private final static String SVN_ID = "$Id: WorkflowEventsWorkflowImpl.java 29256 2011-08-01 14:36:36Z bvanhalderen $";

	@Persistent(column="mootlywcm:email")
	String email;
	@Persistent(column="mootlywcm:isActive")
	Boolean active;
	@Persistent(column="mootlywcm:resellerID")
	String resellerID;
	@Persistent(column="mootlywcm:emailCustomerService")
	String emailCustomerService;
	@Persistent(column="mootlywcm:emailFrom")
	String emailFrom;
	@Persistent(column="mootlywcm:emailFromName")
	String emailFromName;
	@Persistent(column="mootlywcm:emailSignature")
	String emailSignature;
	@Persistent(column="mootlywcm:eriEnable26ASImport")
	Boolean eriEnable26ASImport;
	@Persistent(column="mootlywcm:eriEnabled")
	Boolean eriEnabled;
	@Persistent(column="mootlywcm:eriPassword")
	String eriPassword;
	@Persistent(column="mootlywcm:eriUserId")
	String eriUserId;
	@Persistent(column="mootlywcm:isReseller")
	Boolean isReseller;
	@Persistent(column="mootlywcm:pageTitlePrefix")
	String pageTitlePrefix;
	@Persistent(column="mootlywcm:paymentAvailableTypes")
	String[] paymentAvailableTypes;
	@Persistent(column="mootlywcm:paymentEnabled")
	Boolean paymentEnabled;
	@Persistent(column="mootlywcm:resellerName")
	String resellerName;
	@Persistent(column="mootlywcm:phoneCustomerService")
	String phoneCustomerService;
	@Persistent(column="mootlywcm:startDate")
	String startDate;
	@Persistent(column="mootlywcm:endDate")
	String endDate;
	@Persistent(column="mootlywcm:resellerPackage")
	String resellerPackage;
	@Persistent(column="mootlywcm:numberOfLicensedUsers")
	String numberOfLicensedUsers;
	


	public ResellerSetupConfigurationWorkflowImpl() throws RemoteException {

	}

	public void fire() throws WorkflowException, MappingException {
		try{
			System.out.println("i m here");
			if(active){
				
				Session rootSession = getWorkflowContext().getInternalWorkflowSession();
				Node hstHostNode = getWorkflowContext().getInternalWorkflowSession().getNode("/hst:hst/hst:hosts/etaxfilestation-w4india/in/etaxfilestation/hst:root/r");
				System.out.println("Start of Creation of Channel::");

				if (hstHostNode != null) {	
					Node resellerHostNode = hstHostNode.addNode(resellerID, "hst:mount");
					resellerHostNode.setProperty("hst:alias", resellerID);
					resellerHostNode.setProperty("hst:channelpath", "/hst:hst/hst:channels/"+resellerID);
					resellerHostNode.setProperty("hst:mountpoint", "/hst:hst/hst:sites/mootlywcm");
					resellerHostNode.setProperty("hst:showport", true);
				}

				Node hstChannelNode = getWorkflowContext().getInternalWorkflowSession().getNode("/hst:hst/hst:channels");
				Node resellerChannel = hstChannelNode.addNode(resellerID, "hst:channel");
				resellerChannel.setProperty("hst:channelinfoclass", "com.mootly.wcm.channels.WebsiteInfo");
				resellerChannel.setProperty("hst:name", resellerID);
				resellerChannel.setProperty("hst:type", "website");

				Node resellerChannelInfoNode = resellerChannel.addNode("hst:channelinfo","hst:channelinfo");
				resellerChannelInfoNode.setProperty("emailCustomerService", emailCustomerService);
				resellerChannelInfoNode.setProperty("emailFrom", emailFrom);
				resellerChannelInfoNode.setProperty("emailFromName", emailFromName);
				resellerChannelInfoNode.setProperty("emailSignature", emailSignature);
				resellerChannelInfoNode.setProperty("eriEnable26ASImport", eriEnable26ASImport.toString());
				resellerChannelInfoNode.setProperty("eriEnabled", eriEnabled.toString());
				resellerChannelInfoNode.setProperty("eriPassword", eriPassword);
				resellerChannelInfoNode.setProperty("eriUserId", eriUserId );
				resellerChannelInfoNode.setProperty("isReseller", isReseller.toString());
				resellerChannelInfoNode.setProperty("logo", "/content/gallery/logos/w4ilogo_v2.png");
				resellerChannelInfoNode.setProperty("pageTitlePrefix", pageTitlePrefix);
				String payments = "";
				for(String paymentTypes : paymentAvailableTypes){
					if(payments.equals("")){
						payments = paymentTypes;
					}else
						payments = payments+","+paymentTypes;
				}
				resellerChannelInfoNode.setProperty("paymentAvailableTypes", payments);
				resellerChannelInfoNode.setProperty("paymentEnabled", paymentEnabled.toString());
				resellerChannelInfoNode.setProperty("phoneCustomerService", phoneCustomerService);
				resellerChannelInfoNode.setProperty("resellerId", resellerID);
				resellerChannelInfoNode.setProperty("resellerName", resellerName);
				resellerChannelInfoNode.setProperty("themeCss", "/content/assets/themes/css/white.css");
				resellerChannelInfoNode.setProperty("startDate", startDate);
				resellerChannelInfoNode.setProperty("endDate", endDate);
				resellerChannelInfoNode.setProperty("numberOfLicensedUsers", numberOfLicensedUsers);
				resellerChannelInfoNode.setProperty("resellerPackage", resellerPackage);

				System.out.println(":: End of Channel creation");
			}
		}catch(Exception e){
			System.out.println("this is exception in member "+e);
		} 	
	}

	public void fire(Document document) throws WorkflowException, MappingException {
		System.err.println("document "+document.getIdentity()+" has published");

		System.err.println("FIRE DOCUMENT ---- Reseller ID:" + resellerID + " GOT PUBLISHED");
	}

	public void fire(Iterator<Document> documentIterator) throws WorkflowException, MappingException {
		while(documentIterator.hasNext()) {
			Document document = documentIterator.next();
			System.err.println("documents "+document.getIdentity()+" has published");
		}
	}
}
