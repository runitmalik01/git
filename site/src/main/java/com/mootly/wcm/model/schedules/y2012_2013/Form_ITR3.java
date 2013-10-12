package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.FormITR3;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;

public class Form_ITR3 {

	public FormITR3 getFormITR3(ITR itr){

		FormITR3 formITR3 = new FormITR3();
		formITR3.setFormName("ITR-3");
		formITR3.setDescription("For Indls and HUFs partners in firms and not having any proprietorship");
		formITR3.setAssessmentYear("2013");
		formITR3.setSchemaVer("Ver1.0");
		formITR3.setFormVer("Ver1.0");
		return formITR3;
	}
}
