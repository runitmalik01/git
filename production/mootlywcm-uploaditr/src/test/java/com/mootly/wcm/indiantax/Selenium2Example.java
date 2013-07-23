package com.mootly.wcm.indiantax;

import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.thoughtworks.selenium.Selenium;


public class Selenium2Example  {
	
	private static Selenium SELENIUM;
    private static FirefoxDriver DRIVER;

    protected Selenium selenium;
    
    static {
    	FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("extensions.checkCompatibility.5.0", false);
        DRIVER = new FirefoxDriver(profile);

        SELENIUM = new WebDriverBackedSelenium(DRIVER, "https://incometaxindiaefiling.gov.in/e-Filing/UserLogin/LoginHome.html?nextPage=efile");
    }

    public static void main(String[] args) {
    	Selenium2Example se = new Selenium2Example();
    	se.runTest();
    }
    
    public void runTest() {
    	retrieveSelenium();
    	String[] allFields = selenium.getAllFields();
    	for (String aField:allFields) {
    		System.out.println("A FIELD:" + aField);
    	}
    }
    
    public void retrieveSelenium() {
        selenium = SELENIUM;
    }
    
    
    
}
