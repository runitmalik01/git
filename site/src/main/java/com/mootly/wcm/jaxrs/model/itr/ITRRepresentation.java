/*
 *  Copyright 2010 Hippo.
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
package com.mootly.wcm.jaxrs.model.itr;

import java.util.List;

import javax.jcr.RepositoryException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.rewriter.ContentRewriter;
import org.hippoecm.hst.core.request.HstRequestContext;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.jaxrs.model.DocumentRepresentation;

/**
 * @version $Id$
 */
@XmlRootElement(name = "itr")
public class ITRRepresentation extends DocumentRepresentation {
    
	final MemberPersonalInformation memberPersonalInformation;
	
	public ITRRepresentation(MemberPersonalInformation memberPersonalInformation,HstRequestContext requestContext, ContentRewriter<String> contentRewriter){
		super(requestContext, contentRewriter);
		this.memberPersonalInformation = memberPersonalInformation;
	}
    
	@XmlTransient
    public ITRRepresentation represent(List<HippoBean> listOfBeans) throws RepositoryException {
    	if (memberPersonalInformation != null) {
    		System.out.println("Testing");
    	}
    	//Its WRONG that there is jcr code here
        return this;
    }

	@XmlElement
    public MemberPersonalInformation getMemberPersonalInformation(){
    	return memberPersonalInformation;
    }
    
    @SuppressWarnings("unchecked")
	protected <T extends HippoBean> T getBean (Class<T> theClass,List<HippoBean> listOfBeans) {
    	for (HippoBean hippoBean:listOfBeans) {    		
    		if (hippoBean.getLocalizedName().toLowerCase().equals(theClass.getSimpleName().toLowerCase())) {
    			return (T) hippoBean;
    		}
    	}
    	return null;
    }
}
