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

import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;

import javax.jcr.Binary;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFactory;

import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoResource;

import com.mootly.wcm.model.PERMISSION;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:memberdrivedocument")
public class MemberDriveDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:memberdrivedocument";
	static final public String NODE_NAME = "MemberDrive";

	private InputStream memberFileResource;
	private String contentType;
	private String description;
	private String docPassword;
	private String docAdditionalNotes;
	private String memberFileName;
	private String accessPermission;
	private String MEMBER_DOCS ="mootlywcm:memberDocs";
	private String DESCRIPTION ="mootlywcm:description";
	private String DOCUMENT_PASSWORD ="mootlywcm:docPassword";
	private String DOCUMENT_ADDITIONAL_NOTES ="mootlywcm:additionalNotes";
	private String MEMBER_FILE_NAME ="mootlywcm:memberFileName";
	private String ACCESS_PERMISSION="mootlywcm:accessPermission";
	/**
	 * @return the memberFileResource
	 */
	public HippoResource getMemberFileResource() {
		return getBean(MEMBER_DOCS);
	}

	public HippoResource getMemberFileResourceWithFileName() {
		return getBean(getMemberFileName());
	}
	public InputStream getMemberFile(){
		return memberFileResource;
	}
	/**
	 * @param memberFileResource the memberFileResource to set
	 */
	public void setMemberFile(InputStream memberFileResource) {
		this.memberFileResource = memberFileResource;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		if(description==null)
			description=getProperty(DESCRIPTION);
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the docPassword
	 */
	public String getDocPassword() {
		if(docPassword==null)
			docPassword=getProperty(DOCUMENT_PASSWORD);
		return docPassword;
	}
	/**
	 * @param docPassword the docPassword to set
	 */
	public void setDocPassword(String docPassword) {
		this.docPassword = docPassword;
	}

	public String getDocAdditionalNotes() {
		if (docAdditionalNotes == null) docAdditionalNotes = getProperty(DOCUMENT_ADDITIONAL_NOTES);
		return docAdditionalNotes;
	}

	public void setDocAdditionalNotes(String docAdditionalNotes) {
		this.docAdditionalNotes = docAdditionalNotes;
	}

	public String getMemberFileName() {
		if(memberFileName == null) memberFileName = getProperty(MEMBER_FILE_NAME);
		return memberFileName;
	}
	public void setMemberFileName(String memberFileName) {
		this.memberFileName = memberFileName;
	}
	public String getAccessPermissionStr() {
		if(accessPermission == null) accessPermission = getProperty(ACCESS_PERMISSION);
		//If still have null from document then we can set default value for access Permission
		if(accessPermission == null) accessPermission = PERMISSION.WRITE.name().toString();
		return accessPermission;
	}
	public PERMISSION getAccessPermission(){
		if(getAccessPermissionStr() != null){
			for(PERMISSION permission:PERMISSION.values()){
				if(permission.name().toString().equalsIgnoreCase(getAccessPermissionStr())){
					return permission;
				}
			}
			return PERMISSION.WRITE;
		} else {
			//If still have null from document then we can set default value for access Permission
			return PERMISSION.WRITE;
		}
	}

	public void setAccessPermission(String accessPermission) {
		this.accessPermission = accessPermission;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		MemberDriveDocument bean = (MemberDriveDocument) content;        
		try {
			if (log.isInfoEnabled()) {
				log.info("this is bean File");
			}
			ValueFactory vf = ValueFactoryImpl.getInstance();
			if(node.hasNode(MEMBER_DOCS)){
				if (log.isInfoEnabled()) {
					log.info("document contain node");
				}
				javax.jcr.Node resourceNode= node.getNode(MEMBER_DOCS);
				if(resourceNode!=null){
					Binary binaryValue = vf.createBinary(bean.getMemberFile());
					resourceNode.setProperty(JcrConstants.JCR_DATA,binaryValue);
					resourceNode.setProperty(JcrConstants.JCR_MIMETYPE, bean.getContentType());
					resourceNode.setProperty(JcrConstants.JCR_LASTMODIFIED, Calendar.getInstance(TimeZone.getTimeZone("GMT+05:30")));
				}
			}
			//here we are adding node directly in document with name of file.We are not using MEMBER_DOCS node to save the binary data.
			//Purpose of doing this to download the file with same name of file.Not with changed name as name of MEMBER_DOCS node.
			/*if(getMemberFileName()!=null){
				//ValueFactory vfmemberFile = ValueFactoryImpl.getInstance();
				javax.jcr.Node fileNameResourceNode = node.addNode(bean.getMemberFileName(), HippoResource.class.getAnnotation(Node.class).jcrType());
				if(fileNameResourceNode !=null){
					Binary binaryValue = vf.createBinary(bean.getMemberFile());
					fileNameResourceNode.setProperty(JcrConstants.JCR_DATA,binaryValue);
					fileNameResourceNode.setProperty(JcrConstants.JCR_ENCODING, "UTF-8");
					fileNameResourceNode.setProperty(JcrConstants.JCR_MIMETYPE, bean.getContentType());
					fileNameResourceNode.setProperty(JcrConstants.JCR_LASTMODIFIED, Calendar.getInstance(TimeZone.getTimeZone("GMT+05:30")));
				}
			}*/	
			node.setProperty(DESCRIPTION, bean.getDescription());
			node.setProperty(DOCUMENT_PASSWORD, bean.getDocPassword());
			node.setProperty(DOCUMENT_ADDITIONAL_NOTES, bean.getDocPassword());
			node.setProperty(MEMBER_FILE_NAME, getMemberFileName());
			node.setProperty(ACCESS_PERMISSION, bean.getAccessPermissionStr());
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
		if(formMap.getField("description")!=null){
			setDescription(formMap.getField("description").getValue());
		}
		if(formMap.getField("protected") != null){
			setDocPassword(formMap.getField("protected").getValue());
		}
		if(formMap.getField("additionalnotes") != null){
			setDocAdditionalNotes(formMap.getField("additionalnotes").getValue());
		}
		if(formMap.getField("accesspermission") != null){
			setDocAdditionalNotes(formMap.getField("accesspermission").getValue());
		} else{
			//set a default permission on  PERMISSION.WRITE.
			setDocAdditionalNotes(PERMISSION.WRITE.name());
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

}
