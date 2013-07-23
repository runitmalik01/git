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

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@Node(jcrType ="mootlywcm:incometaxformselectiondocument")
public class IncomeTaxFormSelectionDocument extends BaseDocument implements ContentNodeBinder, FormMapFiller{
	static final public String NAMESPACE = "mootlywcm:incometaxformselectiondocument";
	static final public String NODE_NAME = "FormSelection";
	
	private String income_tax_form_selection;
    
	
	public final String getIncome_tax_form_selection() {
		if (income_tax_form_selection == null) income_tax_form_selection = getProperty("mootlywcm:incometaxformselection");
		return income_tax_form_selection;
	}
	public final void setIncome_tax_form_selection(String income_tax_form_selection) {
		this.income_tax_form_selection = income_tax_form_selection;
	}
@Override
public boolean bind(Object content, javax.jcr.Node node)
		throws ContentNodeBindingException {
	// TODO Auto-generated method stub
	try {

		IncomeTaxFormSelectionDocument incometaxformselection = (IncomeTaxFormSelectionDocument) content;

		node.setProperty("mootlywcm:incometaxformselection", incometaxformselection.getIncome_tax_form_selection());


	} catch (RepositoryException rex) {
		log.error("Repository Exception while binding",rex);
	}
	return true;
}
public void fill(FormMap formMap) {
	// TODO Auto-generated method stub
	if (formMap == null) return;
	if (formMap.getField("income_tax_form_selection") != null){
		setIncome_tax_form_selection(formMap.getField("income_tax_form_selection").getValue());
	}
}


@Override
public <T extends HippoBean> void cloneBean(T sourceBean) {
	// TODO Auto-generated method stub

}
}
