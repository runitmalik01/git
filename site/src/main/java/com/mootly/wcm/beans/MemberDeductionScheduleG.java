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

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

import com.mootly.wcm.beans.compound.DeductionScheduleGTableA;
import com.mootly.wcm.beans.compound.DeductionScheduleGTableB;
import com.mootly.wcm.beans.compound.DeductionScheduleGTableC;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberDeductionScheduleG")
public class MemberDeductionScheduleG extends Document {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleG";
	static final public String NODE_NAME = "MemberDeductionScheduleG";
	
	private DeductionScheduleGTableA deductionScheduleGTableA;
	private DeductionScheduleGTableB deductionScheduleGTableB;
	private DeductionScheduleGTableC deductionScheduleGTableC;
	private String total;
	private String totalA;
	private String totalB;
	private String totalC;
	
	
	public void setDeductionScheduleGTableA(DeductionScheduleGTableA deductionScheduleGTableA) {
		this.deductionScheduleGTableA = deductionScheduleGTableA;
	}
	public void setDeductionScheduleGTableB(DeductionScheduleGTableB deductionScheduleGTableB) {
		this.deductionScheduleGTableB = deductionScheduleGTableB;
	}
	public void setDeductionScheduleGTableC(DeductionScheduleGTableC deductionScheduleGTableC) {
		this.deductionScheduleGTableC = deductionScheduleGTableC;
	}
	public void setTotal(String total){
    	this.total=total;
    }
    public void setTotalA(String totalA){
    	this.totalA=totalA;
    }
    public void setTotalB(String totalB){
    	this.totalB=totalB;
    }
    public void setTotalC(String totalC){
    	this.totalC=totalC;
    }
	public DeductionScheduleGTableA getDeductionScheduleGTableA() {
		if (deductionScheduleGTableA == null) deductionScheduleGTableA = getBean("mootlywcm:DeductionScheduleGTableA");
		return deductionScheduleGTableA;
	}
	public DeductionScheduleGTableB getDeductionScheduleGTableB() {
		if (deductionScheduleGTableB == null) deductionScheduleGTableB = getBean("mootlywcm:DeductionScheduleGTableB");
		return deductionScheduleGTableB;
	}
	public DeductionScheduleGTableC getDeductionScheduleGTableC() {
		if (deductionScheduleGTableC == null) deductionScheduleGTableC = getBean("mootlywcm:DeductionScheduleGTableC");
		return deductionScheduleGTableC;
	}
   public String getTotal(){
	   if(total==null)total=getProperty("mootlywcm:total");
	   return total;
   }
   public String getTotalA(){
	   if(totalA==null)totalA=getProperty("mootlywcm:totalA");
	   return totalA;
   } 
   public String getTotalB(){
	   if(totalB==null)totalB=getProperty("mootlywcm:totalB");
	   return totalB;
   } 
   public String getTotalC(){
	   if(totalC==null)totalC=getProperty("mootlywcm:totalC");
	   return totalC;
   } 
//for personal information
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		super.bind(content, node);
		MemberDeductionScheduleG bean = (MemberDeductionScheduleG) content;
		try {
			if (bean.getDeductionScheduleGTableA() != null) {
				if (node.hasNode("mootlywcm:DeductionScheduleGTableA")) {
					javax.jcr.Node htmlNode = node.getNode("mootlywcm:DeductionScheduleGTableA");
					if (!htmlNode.isNodeType("mootlywcm:DeductionScheduleGTableA")) {
						throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
					}
					bean.getDeductionScheduleGTableA().bindToNode(htmlNode);
				} else {					
					javax.jcr.Node html = node.addNode("mootlywcm:DeductionScheduleGTableA", "mootlywcm:DeductionScheduleGTableA");
					bean.getDeductionScheduleGTableA().bindToNode(html); 
				}
			}
			if (bean.getDeductionScheduleGTableB() != null) {
				if (node.hasNode("mootlywcm:DeductionScheduleGTableB")) {
					javax.jcr.Node htmlNode = node.getNode("mootlywcm:DeductionScheduleGTableB");
					if (!htmlNode.isNodeType("mootlywcm:DeductionScheduleGTableB")) {
						throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
					}
					bean.getDeductionScheduleGTableB().bindToNode(htmlNode);
				} else {					
					javax.jcr.Node html = node.addNode("mootlywcm:DeductionScheduleGTableB", "mootlywcm:DeductionScheduleGTableB");
					bean.getDeductionScheduleGTableB().bindToNode(html); 
				}
			}
			if (bean.getDeductionScheduleGTableC() != null) {
				if (node.hasNode("mootlywcm:DeductionScheduleGTableC")) {
					javax.jcr.Node htmlNode = node.getNode("mootlywcm:DeductionScheduleGTableC");
					if (!htmlNode.isNodeType("mootlywcm:DeductionScheduleGTableC")) {
						throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
					}
					bean.getDeductionScheduleGTableC().bindToNode(htmlNode);
				} else {					
					javax.jcr.Node html = node.addNode("mootlywcm:DeductionScheduleGTableC", "mootlywcm:DeductionScheduleGTableC");
					bean.getDeductionScheduleGTableC().bindToNode(html); 
				}
			}
			node.setProperty("mootlywcm:total", bean.getTotal());
			node.setProperty("mootlywcm:totalA", bean.getTotalA());
			node.setProperty("mootlywcm:totalB", bean.getTotalB());
			node.setProperty("mootlywcm:totalC", bean.getTotalC());
		} catch (RepositoryException e) {
			throw new ContentNodeBindingException(e);
		}
		return true;
	}
}
