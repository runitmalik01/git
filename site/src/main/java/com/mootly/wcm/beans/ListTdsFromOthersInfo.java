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

import static com.mootly.wcm.utils.Constants.COMPTDS_OTHERS;

import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

import com.mootly.wcm.beans.compound.CompTdsothers;


@Node(jcrType = "mootlywcm:ListTdsFromOthers")
public class ListTdsFromOthersInfo extends Document {
	private String total_value;
	static final public String NAMESPACE = "mootlywcm:ListTdsFromOthers";            
	static final public String NODE_NAME = "ListTdsFromOthers";

	private List<CompTdsothers> listTdsothers;
	//public void setTestTdsOthers(testTdsothers testTdsOthers) {
		//this.testtdsothers = testTdsOthers;
	//}
	public final List<CompTdsothers> getTestTdsOthers() {
		if (listTdsothers == null) listTdsothers= getChildBeans(COMPTDS_OTHERS);
		return listTdsothers;
	}
	public final void setTdsSalaryList(List<CompTdsothers> tdsSalaryList) {
		this.listTdsothers = tdsSalaryList;
	}
	 public String getTotal_Value() {
	    	if (total_value == null) total_value = getProperty("mootlywcm:totaloftaxdeducted");
	    	return total_value;
	 }
	 public final void setTotal_Value(String totalvalue) {
			this.total_value = totalvalue;
		}
	//public testTdsothers getTestTdsOthers() {
		//if (testtdsothers == null) testtdsothers = getBean(TEST_TDSOTHERS);
		//return testtdsothers;
	//}

/**
 
 
	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		super.bind(content, node);
		tesTdsDocOther bean = (tesTdsDocOther) content;
		try {
			if (bean.getTestTdsOthers() != null) {
				if (node.hasNode(TEST_TDSOTHERS)) {
					javax.jcr.Node htmlNode = node.getNode(TEST_TDSOTHERS);
					if (!htmlNode.isNodeType(TEST_TDSOTHERS)) {
						throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
					}
					bean.getTestTdsOthers().bindToNode(htmlNode);
					
				
				} else {					
					javax.jcr.Node html = node.addNode(TEST_TDSOTHERS, TEST_TDSOTHERS);
					bean.getTestTdsOthers().bindToNode(html); 
					
				}
			}
		} catch (RepositoryException e) {
			throw new ContentNodeBindingException(e);
		}
		return true;
	}
	* 
 */
 
	
	 
	  
	   public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
	        super.bind(content, node);
	        ListTdsFromOthersInfo bean = (ListTdsFromOthersInfo) content;
	       
	        try {
	        	node.setProperty("mootlywcm:totaloftaxdeducted", bean.getTotal_Value());
	        	NodeIterator nodeIterator = node.getNodes(COMPTDS_OTHERS);
	        	if (nodeIterator != null) {
		        	while (nodeIterator.hasNext()) {
		        		javax.jcr.Node aNode = nodeIterator.nextNode();
		        		aNode.remove();
		        	}
	        	}
	        	if (bean.getTestTdsOthers() != null && bean.getTestTdsOthers().size() > 0 ){ 
	        		for (CompTdsothers tdsSalary:bean.getTestTdsOthers()) {
		                javax.jcr.Node html = node.addNode(COMPTDS_OTHERS, COMPTDS_OTHERS);
		                tdsSalary.bindToNode(html); 
	        		}
	        	}
	        } catch (RepositoryException e) {
	            throw new ContentNodeBindingException(e);
	        }

	        return true;
	    }
	  
}
