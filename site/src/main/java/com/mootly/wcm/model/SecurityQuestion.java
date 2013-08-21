/**
 * 
 */
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BEN-10
 *
 */
public enum SecurityQuestion {

	Question1("question1","security.question.1",8,true),
	Question2("question2","security.question.2",8,true),
	Question3("question3","security.question.3",8,true);

	String displayName;//name of question 
	String key;//key name from which we find message property in resource bundle
	int size;//No of Question to be shown on Question DropDown.Also make sure that question should be in "security_question.properties".
	boolean isActive;//Question should be shown or not
	
	SecurityQuestion(String displayName,String key,int size,boolean isActive) {
		this.displayName= displayName;
		this.key = key;
		this.size = size;
		this.isActive= isActive;
	}

	public String getKey() {
		return key;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public static List<SecurityQuestion> getActiveQuestions(){
		List<SecurityQuestion> secQuestion = new ArrayList<SecurityQuestion>();
		for(SecurityQuestion sq:SecurityQuestion.values()){
			if(sq.isActive()){
				secQuestion.add(sq);
			}
		}
		return secQuestion;
	}
}
