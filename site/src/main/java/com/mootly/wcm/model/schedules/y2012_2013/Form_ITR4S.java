package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.FormITR4S;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;

public class Form_ITR4S {

	public FormITR4S getFormITR4S(ITR itr){

		FormITR4S formITR4S = new FormITR4S();
		formITR4S.setFormName("ITR-4S");
		formITR4S.setDescription("For Indl having Income From Presemptive Business");
		formITR4S.setAssessmentYear("2013");
		formITR4S.setSchemaVer("Ver1.0");
		formITR4S.setFormVer("Ver1.0");
		return formITR4S;
	}
}
