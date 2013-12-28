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
/**
 * 
 * User: megha
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.compound;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.BaseDocument;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:memberticketdocumentdetail")
public class MemberTicketDocumentDetail extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:memberticketdocumentdetail";
	static final public String NODE_NAME = "memberticket";
	
	// Declaration of variables.
	private String name;
	private String email;
	private String category;
	private String comments;
	private String resolution;
	// To create getter for variables.
	public String getName() {
        if (name == null) name = getProperty("mootlywcm:name");
        return name;
    }
	
	public String getEmail() {
    	if (email == null) email =  getProperty("mootlywcm:email");
    	return email;
    }
	public String getComments() {
    	if (comments == null) comments =  getProperty("mootlywcm:comments");
    	return comments;
    }
	public String getCategory() {
    	if (category == null) category =  getProperty("mootlywcm:category");
    	return category;
    }
	public String getResolution() {
    	if (resolution == null) resolution =  getProperty("mootlywcm:resolution");
    	return resolution;
    }
	// To create setter for variables.
	public final void setName(String name) {
		this.name = name;
	}
	
	public final void setEmail(String email) {
		this.email = email;
	}

	public final void setComments(String comments) {
		this.comments = comments;
	}
	public final void setCategory(String category) {
		this.category = category;
	}
	public final void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			
			MemberTicketDocumentDetail memberticket_doc = (MemberTicketDocumentDetail) content;
			node.setProperty("mootlywcm:name",memberticket_doc.getName());
			node.setProperty("mootlywcm:email",memberticket_doc.getEmail());
			node.setProperty("mootlywcm:comments",memberticket_doc.getComments());
			node.setProperty("category",memberticket_doc.getCategory());
			node.setProperty("mootlywcm:resolution",memberticket_doc.getResolution());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}

	
	
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		
		if (formMap.getField("name") != null){
			setName(formMap.getField("name").getValue());
			log.info("valuye of add"+formMap.getField("name").getValue());
		}
		if (formMap.getField("email") != null){
			setEmail(formMap.getField("email").getValue());
			log.info("valuye of add"+formMap.getField("email").getValue());
		}
		if (formMap.getField("category") != null){
			setCategory(formMap.getField("category").getValue());
			log.info("valuye of coname1"+formMap.getField("category").getValue());
		}
		if (formMap.getField("comments") != null){
			setComments(formMap.getField("comments").getValue());
		}
		if (formMap.getField("resolution") != null){
			setResolution(formMap.getField("resolution").getValue());
		}
		

	}


	public <T extends HippoBean> void cloneBean(T sourceBean) {
		MemberTicketDocumentDetail objmemberTicketDetail = (MemberTicketDocumentDetail) sourceBean;

		setName(objmemberTicketDetail.getName());
		setEmail(objmemberTicketDetail.getEmail());
		setCategory(objmemberTicketDetail.getCategory());
		setComments(objmemberTicketDetail.getComments());
		setResolution(objmemberTicketDetail.getResolution());
		
	}

	public void bindToNode(javax.jcr.Node html) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMarkedForDeletion() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setMarkedForDeletion(boolean b) {
		// TODO Auto-generated method stub
		
	};
}
