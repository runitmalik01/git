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

package com.mootly.wcm.beans;

import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.hippoecm.hst.content.beans.standard.HippoMirrorBean;

import com.mootly.wcm.utils.Constants;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:servicerequestdocument")
public class ServiceRequestDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	final public static String NAMESPACE = "mootlywcm:servicerequestdocument";
	static final public String NODE_NAME = "ServiceRequestDocument";

	private Long serviceRequestNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String email;
	private String address;
	private String serviceCode;
	private String serviceName;
	private String offeringMode;
	private GregorianCalendar requestDate;
	private Boolean documentUploaded;
	private List<MemberDriveDocument> memberDriveDocumentList;
	private List<String>  mdCanonicalHandleUUID;
	private String serviceCanonicalHandleUUID;
	
	public Long getServiceRequestNumber() {
		if(serviceRequestNumber == null) serviceRequestNumber = getProperty("mootlywcm:serviceRequestNumber");
		return serviceRequestNumber;
	}
	public void setServiceRequestNumber(Long serviceRequestNumber) {
		this.serviceRequestNumber = serviceRequestNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		if(firstName==null) firstName=getProperty(PROP_PI_FIRST_NAME);
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		if(middleName==null) middleName=getProperty(PROP_PI_MIDDLE_NAME);
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lasttName
	 */
	public String getLastName() {
		if(lastName==null) lastName=getProperty(PROP_PI_LAST_NAME);
		return lastName;
	}
	/**
	 * @param lasttName the lasttName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		if(mobile==null) mobile=getProperty(PROP_PI_MOBILE);
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		if(email==null) email=getProperty(PROP_PI_EMAIL);
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		if(address==null) address=getProperty("mootlywcm:address");
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		if(serviceCode==null) serviceCode=getProperty("mootlywcm:serviceCode");
		return serviceCode;
	}
	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		if(serviceName == null) serviceName = getProperty("mootlywcm:serviceName");
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the offeringMode
	 */
	public String getOfferingMode() {
		if(offeringMode==null) offeringMode=getProperty("mootlywcm:offeringMode");
		return offeringMode;
	}
	/**
	 * @param offeringMode the offeringMode to set
	 */
	public void setOfferingMode(String offeringMode) {
		this.offeringMode = offeringMode;
	}
	/**
	 * @return the requestDate
	 */
	public GregorianCalendar getRequestDate() {
		if(offeringMode==null) offeringMode=getProperty("mootlywcm:requestDate");
		return requestDate;
	}
	public String getDOBStr() {
		if (requestDate == null) requestDate = getProperty("mootlywcm:requestDate");
		if (requestDate != null) {
			String dobStr = getIndianDateFormatter().format(requestDate.getTime());
			return dobStr;
		}
		return null;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(GregorianCalendar requestDate) {
		this.requestDate = requestDate;
	}
	public Boolean getDocumentUploaded() {
		if(documentUploaded == null) documentUploaded = getProperty("mootlywcm:documentUploaded");
		return documentUploaded;
	}
	public void setDocumentUploaded(Boolean documentUploaded) {
		this.documentUploaded = documentUploaded;
	}
	public List<String> getMdCanonicalHandleUUID() {
		if(mdCanonicalHandleUUID == null){
			mdCanonicalHandleUUID = new ArrayList<String>();
			List<String> uuidsArray = new ArrayList<String>();
			if(getServiceProcessDocuemnts()!= null){
				for(MemberDriveDocument thebean:getServiceProcessDocuemnts()){
					uuidsArray.add(thebean.getCanonicalHandleUUID());
				}
			}
			mdCanonicalHandleUUID.addAll(uuidsArray);
		}
		return mdCanonicalHandleUUID;
	}
	public void setMdCanonicalHandleUUID(List<String> mdCanonicalHandleUUID) {
		this.mdCanonicalHandleUUID = mdCanonicalHandleUUID;
	}
	public final List<MemberDriveDocument> getServiceProcessDocuemnts() {
		if (memberDriveDocumentList == null) {
			List<HippoMirrorBean> theMirrorBeans = getChildBeansByName("mootlywcm:serviceProcessDcouments");
			if (theMirrorBeans != null && theMirrorBeans.size() > 0 ) {
				memberDriveDocumentList = new ArrayList<MemberDriveDocument>();
				for (HippoMirrorBean theMirrorBean: theMirrorBeans) {
					HippoBean theRefBean = ( (HippoMirror) theMirrorBean ).getReferencedBean();
					if (theRefBean != null && theRefBean instanceof MemberDriveDocument) {
						memberDriveDocumentList.add((MemberDriveDocument) theRefBean);
					}
				}	
			}
		}
		return memberDriveDocumentList;
	}
	public Service getServiceDocument(){
		HippoBean hippoBean = getBean("mootlywcm:serviceDocument");
		if(hippoBean instanceof HippoMirror){
			HippoBean hippoDocumentBean = ((HippoMirror) hippoBean).getReferencedBean();
			if(hippoDocumentBean instanceof Service){
				Service service = (Service) hippoDocumentBean;
				return service;
			}
		}
		return null;
	}
	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		ServiceRequestDocument bean = (ServiceRequestDocument) content;        
		try {
			NodeIterator nodeIterator = node.getNodes("mootlywcm:serviceProcessDcouments");
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			node.setProperty(PROP_PI_FIRST_NAME,bean.getFirstName());
			node.setProperty(PROP_PI_MIDDLE_NAME,bean.getMiddleName());
			node.setProperty(PROP_PI_LAST_NAME, bean.getLastName());
			node.setProperty(PROP_PI_EMAIL, bean.getEmail());
			node.setProperty(PROP_PI_MOBILE, bean.getMobile());
			node.setProperty("mootlywcm:address", bean.getAddress());
			node.setProperty("mootlywcm:serviceCode", bean.getServiceCode());
			node.setProperty("mootlywcm:serviceName", bean.getServiceName());
			node.setProperty("mootlywcm:offeringMode", bean.getOfferingMode());
			node.setProperty("mootlywcm:requestDate", GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT+05:30")));
			node.setProperty("mootlywcm:documentuploaded", bean.getDocumentUploaded());
			node.setProperty("mootlywcm:serviceRequestNumber", bean.getServiceRequestNumber());
			for(String canonicalHandleUUID:getMdCanonicalHandleUUID()){
				javax.jcr.Node prdLinkNode;
				try {
					//prdLinkNode = node.getNode(PROP_COLUMN_BEAN);
					prdLinkNode = node.addNode("mootlywcm:serviceProcessDcouments", "hippo:mirror");
					prdLinkNode.setProperty(Constants.PROP_HIPPO_DOCBASE, canonicalHandleUUID);
				}  catch (RepositoryException e) {
					// TODO Auto-generated catch block
					log.error("Error in Repository",e);
				}	
			}
			javax.jcr.Node serviceNode;
			if(node.hasNode("mootlywcm:serviceDocument")){
				serviceNode = node.getNode("mootlywcm:serviceDocument");
				serviceNode.setProperty(Constants.PROP_HIPPO_DOCBASE, bean.getServiceCanonicalHandleUUID());
			} else {
				serviceNode = node.addNode("mootlywcm:serviceDocument", "hippo:mirror");
				serviceNode.setProperty(Constants.PROP_HIPPO_DOCBASE, bean.getServiceCanonicalHandleUUID());
			}
		} 
		catch (RepositoryException e) {
			log.error("Repository Exception",e);
			throw new ContentNodeBindingException(e);
		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if(formMap == null){
			if(log.isInfoEnabled()){
				log.info("formMap is NUll { } .Not able to Mapped Values");
			}
			return;
		}
		if(formMap.getField("firstName") != null){
			setFirstName(formMap.getField("firstName").getValue());
		}
		if(formMap.getField("middleName") != null){
			setMiddleName(formMap.getField("middleName").getValue());
		}
		if(formMap.getField("lastName") != null) {
			setLastName(formMap.getField("lastName").getValue());
		}
		if(formMap.getField("address") != null) {
			setAddress(formMap.getField("address").getValue());
		}
		if(formMap.getField("mobile") != null) {
			setMobile(formMap.getField("mobile").getValue());
		}
		if(formMap.getField("email") != null) {
			setEmail(formMap.getField("email").getValue());
		}
		if(formMap.getField("serviceCode") != null) {
			setServiceCode(formMap.getField("serviceCode").getValue());
		}
		if(formMap.getField("serviceName") != null) {
			setServiceName(formMap.getField("serviceName").getValue());
		}
		if(formMap.getField("serviceCanonicalHandleUUID") != null) {
			setServiceCanonicalHandleUUID(formMap.getField("serviceCanonicalHandleUUID").getValue());
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	public String getServiceCanonicalHandleUUID() {
		if(serviceCanonicalHandleUUID == null){
			if(getServiceDocument() != null){
				serviceCanonicalHandleUUID = getServiceDocument().getCanonicalHandleUUID();
			}
		}
		return serviceCanonicalHandleUUID;
	}
	public void setServiceCanonicalHandleUUID(String serviceCanonicalHandleUUID) {
		this.serviceCanonicalHandleUUID = serviceCanonicalHandleUUID;
	}

}
