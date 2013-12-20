
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

public enum PackageForReseller {

	singleUser("Single User",10000,"1","1 Year"),
	multipleUser("Multiple User",40000,"unlimited","1 Year");

	String displayName;//name of Package
	int amount;// Package cost
	String numberOfLicensedUsers;//How many users can signup 
	String vadilityOfLicense;

	PackageForReseller(String displayName,int amount,String numberOfLicensedUsers,String vadilityOfLicense) {
		this.displayName = displayName;
		this.amount = amount;
		this.numberOfLicensedUsers = numberOfLicensedUsers;
		this.vadilityOfLicense = vadilityOfLicense;
	}

	public String getDisplayName() {
		return displayName;
	}
	public int getAmount() {
		return amount;
	}
	public String getNumberOfLicensedUsers() {
		return numberOfLicensedUsers;
	}
	public String getVadilityOfLicense() {
		return vadilityOfLicense;
	}

	public static List<PackageForReseller> getResellerPackage(){
		List<PackageForReseller> resellerPackage = new ArrayList<PackageForReseller>();
		for(PackageForReseller rp:PackageForReseller.values()){
			resellerPackage.add(rp);
		}
		return resellerPackage;
	}
}
