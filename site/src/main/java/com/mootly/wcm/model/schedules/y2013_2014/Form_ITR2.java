package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.FormITR2;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;

public class Form_ITR2 {

	public FormITR2 getFormITR2(ITR itr){

		FormITR2 formITR2 = new FormITR2();
		formITR2.setFormName("ITR-2");
		formITR2.setDescription("For Indls and  HUFs not having Income from Business or Profession");
		formITR2.setAssessmentYear("2014");
		formITR2.setSchemaVer("Ver1.0");
		formITR2.setFormVer("Ver1.1");
		return formITR2;
	}
}
