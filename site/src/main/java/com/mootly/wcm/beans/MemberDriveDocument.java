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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.jcr.Binary;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoResource;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:memberdrivedocument")
public class MemberDriveDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:memberdrivedocument";
	static final public String NODE_NAME = "MemberDrive";

	private File memberFileResource;
	private String MEMBER_DOCS="mootlywcm:memberDocs";
	/**
	 * @return the memberFileResource
	 */
	public HippoResource getMemberFileResource() {
		return getBean(MEMBER_DOCS);
	}
	public File getMemberFile(){
		return memberFileResource;
	}
	/**
	 * @param memberFileResource the memberFileResource to set
	 */
	public void setMemberFile(File memberFileResource) {
		this.memberFileResource = memberFileResource;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		InputStream is = null;
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
					if (log.isInfoEnabled()) { //BE CAREFUL this can cause exception 
						try {
						log.info("thi sos jcr type"+((Node) resourceNode).jcrType());
						}catch (Exception ex) {
							log.warn("Error while logging ",ex);
						}
					}
					is = new FileInputStream( bean.getMemberFile() );
					Binary binaryValue = vf.createBinary(is);
					resourceNode.setProperty(JcrConstants.JCR_DATA,binaryValue);
				}
			}
		} 
		catch (FileNotFoundException e) {
			log.error("File was not found ", e);
			throw new ContentNodeBindingException(e);
		}
		catch (RepositoryException e) {
			log.error("Repository Exception",e);
			throw new ContentNodeBindingException(e);
		}
		finally {
			if (is != null) try { is.close(); } catch (Exception ex) {}
		}
		return true;
	}

}
