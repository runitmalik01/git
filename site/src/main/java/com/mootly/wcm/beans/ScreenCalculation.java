/**
 * 
 */
package com.mootly.wcm.beans;

import org.hippoecm.hst.content.beans.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BEN-10
 *
 */
@Node(jcrType="mootlywcm:screencalculation")
public class ScreenCalculation extends BaseDocument {

	private final static Logger log = LoggerFactory.getLogger(ScreenCalculation.class);
	private String title;
	private String[] inputTypeFields;
	private String[] radioDropTypeFields;
	private String script;
	/**
	 * @return the title
	 */
	public String getTitle() {
		if (title == null) title = getProperty("mootlywcm:title");
		return title;
	}
	/**
	 * @return the inputTypeFields
	 */
	public String[] getInputTypeFields() {
		if (inputTypeFields == null) inputTypeFields = getProperty("mootlywcm:input");
		return inputTypeFields;
	}
	/**
	 * @return the radioDropTypeFields
	 */
	public String[] getRadioDropTypeFields() {
		if (radioDropTypeFields == null) radioDropTypeFields = getProperty("mootlywcm:dropRadio");
		return radioDropTypeFields;
	}
	/**
	 * @return the script
	 */
	public String getScript() {
		if(log.isInfoEnabled()) log.info("Screen Calculation Doucment");
		if (script == null) script = getProperty("mootlywcm:script");
		return script;
	}
	
}
