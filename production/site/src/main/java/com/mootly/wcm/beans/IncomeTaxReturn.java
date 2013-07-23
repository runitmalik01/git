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

import static com.mootly.wcm.utils.Constants.PROP_PERSONAL_INFORMATION;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

import com.mootly.wcm.beans.compound.PersonalInformation;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:incometaxreturn")
public class IncomeTaxReturn extends Document {

	private PersonalInformation personalInformation;

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

	public PersonalInformation getPersonalInformation() {
		if (personalInformation == null) personalInformation = getBean(PROP_PERSONAL_INFORMATION);
		return personalInformation;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		super.bind(content, node);
		IncomeTaxReturn bean = (IncomeTaxReturn) content;
		try {
			if (bean.getPersonalInformation() != null) {
				if (node.hasNode(PROP_PERSONAL_INFORMATION)) {
					javax.jcr.Node htmlNode = node.getNode(PROP_PERSONAL_INFORMATION);
					if (!htmlNode.isNodeType(PROP_PERSONAL_INFORMATION)) {
						throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
					}
					bean.getPersonalInformation().bindToNode(htmlNode);
				} else {					
					javax.jcr.Node html = node.addNode(PROP_PERSONAL_INFORMATION, PROP_PERSONAL_INFORMATION);
					bean.getPersonalInformation().bindToNode(html); 
				}
			}
		} catch (RepositoryException e) {
			throw new ContentNodeBindingException(e);
		}
		return true;
	}
}
