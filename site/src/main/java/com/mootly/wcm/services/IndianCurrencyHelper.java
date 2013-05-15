package com.mootly.wcm.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class IndianCurrencyHelper {
	public static Double round(Double in) {
		BigDecimal bd = new BigDecimal(in).setScale(2, RoundingMode.HALF_EVEN);
		Double d = bd.doubleValue();
		return d;
	}
}
