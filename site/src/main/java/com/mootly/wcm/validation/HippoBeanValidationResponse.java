package com.mootly.wcm.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author admin
 *
 */
public class HippoBeanValidationResponse {
	
	List<HippoBeanValidationWarning> warnings;
	List<HippoBeanValidationError> errors;
	
	public List<HippoBeanValidationWarning> getWarnings() {
		return warnings;
	}

	public List<HippoBeanValidationError> getErrors() {
		return errors;
	}

	public int getTotalErrors() {
		if (errors != null && errors.size() > 0){
			return errors.size();
		}
		return 0;
	}
	
	public int getTotalWarnings() {
		if (warnings != null && warnings.size() > 0){
			return warnings.size();
		}
		return 0;
	}
	
	public boolean getHasErrors() {
		int totalErrors = getTotalErrors();
		if (totalErrors > 0) {
			return true;
		}
		return false;
	}
	
	public boolean getHasWarnings() {
		int totalWarnings = getTotalWarnings();
		if (totalWarnings > 0) {
			return true;
		}
		return false;
	}
	
	public boolean addError(HippoBeanValidationError error) {
		if (errors == null) errors = new ArrayList<HippoBeanValidationError>();
		boolean ret = errors.add(error);
		return ret;
	}
	
	public boolean addWarning(HippoBeanValidationWarning warning) {
		if (warnings == null) warnings = new ArrayList<HippoBeanValidationWarning>();
		boolean ret = warnings.add(warning);
		return ret;
	}
}
