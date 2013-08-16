/**
 * 
 */
package com.mootly.wcm.model;

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
	int size;//No of Question to be shown on Question DropDown
	boolean isActive;//Question should be shown or not

	SecurityQuestion(){

	}
	
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
}
