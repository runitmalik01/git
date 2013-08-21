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
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.SalaryIncomeDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:securityquestionanswer")
public class SecurityQuestionAnswerValueList extends HippoItem implements FormMapFiller {
	private final static Logger log = LoggerFactory.getLogger(SecurityQuestionAnswerValueList.class);
	public final static String NAME_SPACE = "mootlywcm:securityquestionanswer";
	private String question;
	private String answer;
	
	private final String prop_question ="mootlywcm:secQuestion";
	private final String prop_answer ="mootlywcm:secAnswer";
	
	private boolean markedForDeletion;
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information
	public final String getQuestion() {
		if (question == null) question = getProperty(prop_question);
		return question;
	}
	public final String getAnswer() {
		if (answer == null) answer = getProperty(prop_answer);
		return answer;
	}
	
	public final void setQuestion(String question) {
		this.question = question;
	}
	
	public final void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			node.setProperty(prop_question, getQuestion());
			node.setProperty(prop_answer, getAnswer());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		if (formMap == null) return;

		if ( formMap.getField("securityQuestion") != null) {
			setQuestion(formMap.getField("securityQuestion").getValue());
		}
		if ( formMap.getField("securityAnswer") != null) {
			setAnswer(formMap.getField("securityAnswer").getValue());
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		SecurityQuestionAnswerValueList secQuestionAns = (SecurityQuestionAnswerValueList) sourceBean;
		setQuestion(secQuestionAns.getQuestion());
		setAnswer(secQuestionAns.getAnswer());
	}

}
