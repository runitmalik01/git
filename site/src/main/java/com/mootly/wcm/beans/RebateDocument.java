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
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:rebatedocument")
public class RebateDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:rebatedocument";
	static final public String NODE_NAME = "rebatedocument";
	private String section89;
	private String section90;
	private String section91;
	
	
	
	//for personal information
	public String getSection89() {
        if (section89 == null) section89 = getProperty("mootlywcm:section89");
        return section89;
    }

    public String getSection90() {
    	if (section90 == null) section90 = getProperty("mootlywcm:section90");
    	return section90;
    }

    public String getSection91() {
    	if (section91== null) section91= getProperty("mootlywcm:section91");
    	return section91;
    }

    
    public final void setSection89(String Section89) {
		this. section89 =  Section89;
	}

	public final void setSection90(String Section90) {
		this.section90 = Section90;
	}

	public final void setSection91(String Section91) {
		this.section91 = Section91;
	}
 
	
	
//for rebate
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is bean");
			RebateDocument memberSignup = (RebateDocument) content;
			node.setProperty("mootlywcm:section89",memberSignup.getSection89());
	    	node.setProperty("mootlywcm:section90",memberSignup.getSection90());
	    	node.setProperty("mootlywcm:section91", memberSignup.getSection91());
	    	
	    	 	
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
}
