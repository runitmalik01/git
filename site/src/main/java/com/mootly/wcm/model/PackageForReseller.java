
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

public enum PackageForReseller {

	paid_singleuser("Single User"),
	paid_multipleuser("Multiple User");

	String displayName;//name of question 

	PackageForReseller(String displayName) {
		this.displayName= displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static List<PackageForReseller> getResellerPackage(){
		List<PackageForReseller> resellerPackage = new ArrayList<PackageForReseller>();
		for(PackageForReseller rp:PackageForReseller.values()){
			resellerPackage.add(rp);
		}
		return resellerPackage;
	}
}
