/**
 * 
 */
package com.mootly.wcm.services;

import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.model.FinancialYear;

/**
 * @author BEN-10
 *
 */
public interface ITRAdditionalScheduleService {
	
	public Map<String, Map<String, Object>> getScheduleSIService(FinancialYear financialYear, Map<String, HippoBean> inputBean);
}
