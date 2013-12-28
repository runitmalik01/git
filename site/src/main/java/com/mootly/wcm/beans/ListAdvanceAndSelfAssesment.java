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

import static com.mootly.wcm.utils.Constants.ADVANCETAX;
import static com.mootly.wcm.utils.Constants.SELFASSESMENT;

import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

import com.mootly.wcm.beans.compound.AdvanceTaxInfo;
import com.mootly.wcm.beans.compound.SelfAssesmentInfo;



@Node(jcrType = "mootlywcm:listAdvanceAndSelfAssesment")
public class ListAdvanceAndSelfAssesment extends Document {
	static final public String NAMESPACE = "mootlywcm:listAdvanceAndSelfAssesment";            
	static final public String NODE_NAME = "listAdvanceAndSelfAssesment";
	private String total_value;
	private String total_value1;
	private List<SelfAssesmentInfo> selfassesmentinfo ;
	
	public final List<SelfAssesmentInfo> getSelfAssesment() {
		if (selfassesmentinfo == null) selfassesmentinfo= getChildBeans(SELFASSESMENT);
		return selfassesmentinfo;
	}
	public final void setSelfAssesmentList(List<SelfAssesmentInfo> selfassesmentList) {
		this.selfassesmentinfo = selfassesmentList;
	}
	
	private List<AdvanceTaxInfo> advancetax;
	public final List<AdvanceTaxInfo> getAdvanceTax(){
		if (advancetax == null) advancetax= getChildBeans(ADVANCETAX);
		return advancetax;
	}
	public final void setAdvanceTaxList(List<AdvanceTaxInfo> advancetaxList) {
		this.advancetax = advancetaxList;
	}
	
	
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
	        
	        try {
	        	ListAdvanceAndSelfAssesment bean = (ListAdvanceAndSelfAssesment) content;
		        log.info("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO in the list bean");
		      
	        	NodeIterator nodeIterator = node.getNodes(SELFASSESMENT);
	        	if (nodeIterator != null) {
		        	while (nodeIterator.hasNext()) {
		        		javax.jcr.Node aNode = nodeIterator.nextNode();
		        		aNode.remove();
		        	}
	        	}
	        	if (bean.getSelfAssesment() != null && bean.getSelfAssesment().size() > 0 ){ 
	        		for (SelfAssesmentInfo tdsSalary:bean.getSelfAssesment()) {
		                javax.jcr.Node html = node.addNode(SELFASSESMENT, SELFASSESMENT);
		                tdsSalary.bindToNode(html); 
	        		}
	        	}
	        	NodeIterator nodeIteratoradvance = node.getNodes(ADVANCETAX);
	        	log.info("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU at second node iterator");
	        	if (nodeIteratoradvance != null) {
		        	while (nodeIteratoradvance.hasNext()) {
		        		javax.jcr.Node aNode = nodeIteratoradvance.nextNode();
		        		aNode.remove();
		        	}
	        	}
	        	if (bean.getAdvanceTax() != null && bean.getAdvanceTax().size() > 0 ){ 
	        		for (AdvanceTaxInfo advance:bean.getAdvanceTax()) {
		                javax.jcr.Node html = node.addNode(ADVANCETAX, ADVANCETAX);
		                advance.bindToNode(html); 
	        		}
	        	}
	        	
	        	
	        	
	        } catch (RepositoryException e) {
	            throw new ContentNodeBindingException(e);
	        }
			return true;
    
	   }	   
	  
}
