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
import java.util.List;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.compound.SalaryIncomeDetail;

/**
 * Used for Source Of Income module to save their values in SourceOfIncomeDocument.
 * Author: Kusumlata
 * Date: March 13, 2013
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:SourceOfIncomeDocument")
public class SourceOfIncomeDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:SourceOfIncomeDocument";
	static final public String NODE_NAME = "SourceOfIncomeDocument";

	Boolean salaryincome;
	Boolean houseincome;
	Boolean capitalasset;
	Boolean otherincome;
	
	
	
	public Boolean getsalaryincome() {
		if (salaryincome == null) salaryincome = getProperty("mootlywcm:salaryincome");
		return salaryincome;
	}
	public Boolean gethouseincome() {
		if (houseincome == null) houseincome = getProperty("mootlywcm:houseincome");
		return houseincome;
	}
	public Boolean getcapitalasset() {
		if (capitalasset == null) capitalasset = getProperty("mootlywcm:capitalasset");
		return capitalasset;
	}
	public Boolean getotherincome() {
		if (otherincome == null) otherincome = getProperty("mootlywcm:otherincome");
		return otherincome;
	}
	
	
	public void setsalaryincome(Boolean salaryincome) {
		this.salaryincome = salaryincome;
	}
	public void sethouseincome(Boolean houseincome) {
		this.houseincome = houseincome;
	}
	public void setcapitalasset(Boolean capitalasset) {
		this.capitalasset = capitalasset;
	}
	public void setotherincome(Boolean otherincome) {
		this.otherincome = otherincome;
	}
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is source of income bean");
			SourceOfIncomeDocument sourceincome = (SourceOfIncomeDocument) content;
			node.setProperty("mootlywcm:salaryincome",sourceincome.getsalaryincome());
			node.setProperty("mootlywcm:houseincome", sourceincome.gethouseincome());
			node.setProperty("mootlywcm:capitalasset", sourceincome.getcapitalasset());
			node.setProperty("mootlywcm:otherincome", sourceincome.getotherincome());
			
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	
}
