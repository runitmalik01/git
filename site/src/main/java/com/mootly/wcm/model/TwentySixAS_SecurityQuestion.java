/**
 * 
 */
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

public enum TwentySixAS_SecurityQuestion {

	Question1("question1","security.question",4,true);

	String displayName;//name of question 
	String key;//key name from which we find message property in resource bundle
	int size;//No of Question to be shown on Question DropDown.Also make sure that question should be in "security_question.properties".
	boolean isActive;//Question should be shown or not
	
	TwentySixAS_SecurityQuestion(String displayName,String key,int size,boolean isActive) {
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
	
	public static List<TwentySixAS_SecurityQuestion> getActiveQuestions(){
		List<TwentySixAS_SecurityQuestion> secQuestion = new ArrayList<TwentySixAS_SecurityQuestion>();
		for(TwentySixAS_SecurityQuestion sq:TwentySixAS_SecurityQuestion.values()){
			if(sq.isActive()){
				secQuestion.add(sq);
			}
		}
		return secQuestion;
	}
}
