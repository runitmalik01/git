package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.BroughtFwdLossesDocument;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Dhananjay Panwar
 * Date:09-oct-2013
 * Description
 */
@PrimaryBean(primaryBeanClass=BroughtFwdLossesDocument.class)
@FormFields(fieldNames={"salariesincomesetoff","salariescurrentsetoff","hpincomesetoff","hpbflasetoff","hpbfdsetoff",
		"hpbflus35setoff","hpcurrentsetoff","businessincomesetoff","businessbflasetoff","businessbfdsetoff",
		"businessbflus35setoff","businesscurrentsetoff","speculativeincomesetoff","speculativebflasetoff","speculativebfdsetoff",
		"speculativebflus35setoff","speculativecurrentsetoff","specifiedincomesetoff","specifiedbflasetoff","specifiedbfdsetoff",
		"specifiedbflus35setoff","specifiedcurrentsetoff","stgcincomesetoff","stgcbflasetoff","stgcbfdsetoff",
		"stgcbflus35setoff","stgccurrentsetoff","ltgcincomesetoff","ltgcbflasetoff","ltgcbfdsetoff",
		"ltgcbflus35setoff","ltgccurrentsetoff","otherincomesetoff","otherbflasetoff","otherbfdsetoff",
		"otherbflus35setoff","othercurrentsetoff","horseincomesetoff","horsebflasetoff","horsebfdsetoff",
		"horsebflus35setoff","horsecurrentsetoff","totalbflasetoff","totalbfdsetoff","totalbflus35setoff","currentsetoff"})

public class BroughtFwdLosses extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(BroughtFwdLosses.class);

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}




