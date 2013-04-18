package com.mootly.wcm.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.SecuritiesDocument;
import com.mootly.wcm.beans.SecuritiesInformation;
import com.mootly.wcm.beans.compound.SecuritiesDetail;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.UrlUtility;
/**

 * @author:Pankaj Singh
 * Date: 3/6/2013
 * Description: This take data from the form of capital asset and put it into bean
 *
 */
@PrimaryBean(primaryBeanClass=SecuritiesDocument.class)
@ChildBean(childBeanClass=SecuritiesDetail.class)
@FormFields(fieldNames={"hidDateAcquisition","cost_acquisition","hidDateSale","sale_consideration","inflation_acquisition","inflation_consideration","capital_gain"})
public class Securities extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(Securities.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		log.info("this is do before render of securities");
		super.doBeforeRender(request, response);
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method 
		log.info("this is do action of securities");
		super.doAction(request, response);
	}
}
