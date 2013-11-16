package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.FormITR4;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;

public class Form_ITR4 {

	public FormITR4 getFormITR4(ITR itr){

		FormITR4 formITR4 = new FormITR4();
		formITR4.setFormName("ITR-4");
		formITR4.setDescription("For indls and HUFs having income from  a proprietory business or profession");
		formITR4.setAssessmentYear("2014");
		formITR4.setSchemaVer("Ver1.0");
		formITR4.setFormVer("Ver1.0");
		return formITR4;
	}
}
