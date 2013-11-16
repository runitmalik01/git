package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.FormITR2;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;

public class Form_ITR2 {

	public FormITR2 getFormITR2(ITR itr){

		FormITR2 formITR2 = new FormITR2();
		formITR2.setFormName("ITR-2");
		formITR2.setDescription("For Indls and  HUFs not having Income from Business or Profession");
		formITR2.setAssessmentYear("2013");
		formITR2.setSchemaVer("Ver1.0");
		formITR2.setFormVer("Ver1.1");
		return formITR2;
	}
}
