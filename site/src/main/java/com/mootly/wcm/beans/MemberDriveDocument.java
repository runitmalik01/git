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

import javax.jcr.Binary;
import javax.jcr.RepositoryException;

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

		MemberDriveDocument bean = (MemberDriveDocument) content;        
		try {
			log.info("this is bean File");
			if(node.hasNode(MEMBER_DOCS)){
				log.info("document contain node");
				javax.jcr.Node resourceNode= node.getNode(MEMBER_DOCS);
				if(resourceNode!=null){
					log.info("thi sos jcr type"+((Node) resourceNode).jcrType());
					resourceNode.setProperty("jcr:data",(Binary) bean.getMemberFile());
				}
			}
			node.setProperty(MEMBER_DOCS, (Binary)bean.getMemberFile());

		} catch (RepositoryException e) {
			throw new ContentNodeBindingException(e);
		}
		return true;
	}

}
