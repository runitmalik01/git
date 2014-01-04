
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

public enum PackageForReseller {

	trialPeriod("Trail Period",0,1,true,true),
	singleuser("Single User",10000,1,true,true),
	multipleuser("Multiple User",40000,1,true,true);

	String displayName;//name of Package
	int amount;// Package cost
	int vadilityOfLicense;// in years
	boolean allowAccess;// downloadXML , Eamil XML and Summary etc
	boolean multipleSignup;//How many users can signup 
	

	PackageForReseller(String displayName, int amount, int vadilityOfLicense, boolean allowAccess, boolean multipleSignup) {
		this.displayName = displayName;
		this.amount = amount;
		this.vadilityOfLicense = vadilityOfLicense;
		this.allowAccess = allowAccess;
		this.multipleSignup = multipleSignup;
	}

	public String getDisplayName() {
		return displayName;
	}
	public int getAmount() {
		return amount;
	}
	public int getVadilityOfLicense() {
		return vadilityOfLicense;
	}
	public boolean getAllowAccess(){
		return allowAccess;
	}
	public boolean getMultipleSignup(){
		return multipleSignup;
	}

	public static List<PackageForReseller> getResellerPackage(){
		List<PackageForReseller> resellerPackage = new ArrayList<PackageForReseller>();
		for(PackageForReseller rp:PackageForReseller.values()){
			resellerPackage.add(rp);
		}
		return resellerPackage;
	}
}
