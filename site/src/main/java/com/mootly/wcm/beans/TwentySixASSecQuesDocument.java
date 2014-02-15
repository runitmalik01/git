
package com.mootly.wcm.beans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:twentysixassecquesdocument")
public class TwentySixASSecQuesDocument extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:twentysixassecquesdocument";
	static final public String NODE_NAME = "twentysixassecquesdocument";
	
	private String securityQuestion;
	private String securityAnswer;
	private Double totalAttemptsLeft;
	private Boolean securityCheck;

	
	//for personal information
	public  String getSecurityQuestion() {
		if (securityQuestion == null) securityQuestion = getProperty("mootlywcm:securityQuestion");
		return securityQuestion;
	}
	public  String getSecurityAnswer() {
		if (securityAnswer == null) securityAnswer = getProperty("mootlywcm:securityAnswer");
		return securityAnswer;
	}
	public  Double getTotalAttemptsLeft() {
		if (totalAttemptsLeft == null) totalAttemptsLeft = getProperty("mootlywcm:totalAttemptsLeft");
		return totalAttemptsLeft;
	}
	public  Boolean getSecurityCheck() {
		if (securityCheck == null) securityCheck = getProperty("mootlywcm:securityCheck");
		return securityCheck;
	}

	public final void  setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public final void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public final void setTotalAttemptsLeft(Double totalAttemptsLeft) {
		this.totalAttemptsLeft = totalAttemptsLeft;
	}
	public final void setSecurityCheck(Boolean securityCheck) {
		this.securityCheck = securityCheck;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {

			TwentySixASSecQuesDocument twentySixASSecurityQues = (TwentySixASSecQuesDocument) content;
			
			node.setProperty("mootlywcm:securityQuestion", twentySixASSecurityQues.getSecurityQuestion());
			node.setProperty("mootlywcm:securityAnswer", twentySixASSecurityQues.getSecurityAnswer());
			node.setProperty("mootlywcm:totalAttemptsLeft", twentySixASSecurityQues.getTotalAttemptsLeft());
			node.setProperty("mootlywcm:securityCheck", twentySixASSecurityQues.getSecurityCheck());
			
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		if (formMap == null) return;

		if ( formMap.getField("securityQuestion") != null) {
			setSecurityQuestion(formMap.getField("securityQuestion").getValue());
		}
		if ( formMap.getField("securityAnswer") != null) {
			setSecurityAnswer(formMap.getField("securityAnswer").getValue());
		}
	//	if ( formMap.getField("totalAttemptsLeft") != null) {
		//	setTotalAttemptsLeft(Double.parseDouble(formMap.getField("totalAttemptsLeft").getValue()));
		//}
		if ( formMap.getField("securityCheck") != null) {
			setSecurityCheck(Boolean.valueOf(formMap.getField("securityCheck").getValue()));
		}
		
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
}
