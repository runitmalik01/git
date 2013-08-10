package com.mootly.wcm;

import java.security.CodeSource;
import java.security.ProtectionDomain;

public class TestForNodeClass {
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.version"));
	    ProtectionDomain domain = org.w3c.dom.Node.class.getProtectionDomain();
	    System.out.println("domain: " + domain);
	    CodeSource codeSource = domain.getCodeSource();
	    if(codeSource != null) {
	       System.out.println("location: " + codeSource.getLocation());
	    } else {
	        System.out.println("null location, probably JRE class");
	    }
	}
}
