package com.mootly.wcm.model;

public enum TaxStatus {
	TR,
	TP,
	NT,
	UNKNOWN;
	
	
	TaxStatus() {
	}
	
	/**
	 * This will be negative for taxRefund
	 * @param taxOwed
	 */
	public static TaxStatus getByIncomeTaxOwed(double taxOwed) {
		if (taxOwed > 0D) {
			return TR;
		}
		else if (taxOwed == 0) {
			return NT;
		}
		else {
			return TP;
		}
	}
}
