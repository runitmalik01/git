package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.Collection;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

public final class Member {
    
    private String firstname = "";
    private String lastname = "";
    private String email = "";
    private String password ="";
    private Boolean active =false ;
    private String username="";
    private Boolean value=false;
    private String activationcode="";
    private String change ="";
    private Collection<String> groups;
    private Collection<String> pan;
    
    public Member(Node userNode) throws RepositoryException {
    	 if (userNode.hasProperty("mootlywcm:userName")) {
             username = userNode.getProperty("mootlywcm:userName").getString();
         }  	
        if (userNode.hasProperty("mootlywcm:email")) {
            email = userNode.getProperty("mootlywcm:email").getString();
        }
        if (userNode.hasProperty("mootlywcm:lastName")) {
            lastname = userNode.getProperty("mootlywcm:lastName").getString();
        }
        if (userNode.hasProperty("mootlywcm:firstName")) {
            firstname = userNode.getProperty("mootlywcm:firstName").getString();
        }
        if(userNode.hasProperty("mootlywcm:password")){
        	password=userNode.getProperty("mootlywcm:password").getString();
        }
        if(userNode.hasProperty("mootlywcm:isActive")){
        	active=userNode.getProperty("mootlywcm:isActive").getBoolean();
        }
        if(userNode.hasProperty("mootlywcm:activationCode")){
        	activationcode=userNode.getProperty("mootlywcm:activationCode").getString();
        }
        if(userNode.hasProperty("mootlywcm:isActive")){
        	Property change =userNode.setProperty("mootlywcm:isActive", value);
        }
        if (userNode.hasProperty("mootlywcm:roles")) {
        	Value[] values = userNode.getProperty("mootlywcm:roles").getValues();
        	groups = new ArrayList<String>(values.length);
        	for (Value value:values) {
        		groups.add(value.getString());
        	}
        }
        if (userNode.hasProperty("mootlywcm:pan")) {
        	Value[] values = userNode.getProperty("mootlywcm:pan").getValues();
        	pan = new ArrayList<String>(values.length);
        	for (Value value:values) {
        		pan.add(value.getString());
        	}
        }
    }
    
    
    public String getFirstname() {
        return firstname;
    }
    public String getUserName() {
        return username;
    }
    public String getNormalizedUserName() {
        return (username != null ? username.replaceAll("@", "-at-") : null);
    }
    public String getActivationCode(){
    	return activationcode;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword(){
    	return password;
    }
    public Boolean getIsActive(){
    	return active;
    }
    public void setIsActive(Boolean isActive) {
		this.value = isActive;
	}
    public Collection<String> getPAN() {
        return pan;
    }
    public Collection<String> getGroups() {
        return groups;
    }
    
    public boolean isMember(String group) {
        return groups.contains(group);
    }


}