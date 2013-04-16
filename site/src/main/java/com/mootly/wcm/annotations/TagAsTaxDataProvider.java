package com.mootly.wcm.annotations;

public @interface TagAsTaxDataProvider {
	public enum TaxDataProviderType {INCOME,DEDUCTION,ADVANCETAX};
	TaxDataProviderType type();
}
