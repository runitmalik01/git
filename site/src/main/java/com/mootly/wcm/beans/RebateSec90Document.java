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
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;
import javax.jcr.Value;


import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * author: Pankaj Singh
 * Date: 30/03/2013
 * 
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:rebatedocumentninety")
public class RebateSec90Document extends BaseDocument implements ContentNodeBinder {

	static final public String NAMESPACE = "mootlywcm:rebatedocumentninety";
	static final public String NODE_NAME = "rebatedocumentninety";



	private String section90;
	private String section91;
	
	public String getSection90() {
    	if (section90 == null) section90 = getProperty("mootlywcm:section90");
    	return section90;
    }

    public String getSection91() {
    	if (section91== null) section91= getProperty("mootlywcm:section91");
    	return section91;
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
			RebateSec90Document memberSignup = (RebateSec90Document) content;
			node.setProperty("mootlywcm:section90",memberSignup.getSection90());
	    	node.setProperty("mootlywcm:section91", memberSignup.getSection91());
	    
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
}
