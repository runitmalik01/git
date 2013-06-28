/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 *
 *
 */

package com.mootly.wcm.member;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;

@PrimaryBean(primaryBeanClass=AdjustmentOfLossesDoc.class)
@ChildBean(childBeanClass=AdjustmentOfLossesCom.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,AdjustmentOfLossesDoc.class,HouseIncomeDetail.class,HouseProperty.class,
		AdjustmentOfLossesCom.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"AssessmentYear","NameOfHead","Amount","DateOfFilingYear","DueDate"})
public class AdjustmentOfLosses extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(AdjustmentOfLosses.class);

	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);

	}
	/*
	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		super.beforeSave(request);
		boolean check = true;
		String uuid;

		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) request.getAttribute(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		String currAssessmentYear=getFormMap().getField("AssessmentYear").getValue();
		String currNameofHead=getFormMap().getField("NameOfHead").getValue();
		uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");

		if (getPageAction().equals(PAGE_ACTION.NEW_CHILD)) {
		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
			if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
				for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
					if(adjustmentOfLossesCom.getNameOfHead().equals(currNameofHead) && adjustmentOfLossesCom.getAssessmentYear().equals(currAssessmentYear)){
                       getFormMap().addMessage("checkentry", "Warning! You have already selected "+adjustmentOfLossesCom.getNameOfHead()+" for "+adjustmentOfLossesCom.getAssessmentYear());
                       check = false;
					}
				}
			}
		}
	}
		if(getPageAction().equals(PAGE_ACTION.EDIT_CHILD)){
			if(adjustmentOfLossesDoc != null){
				List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
				if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
					for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
						if(adjustmentOfLossesCom.getNameOfHead().equals(currNameofHead) && adjustmentOfLossesCom.getAssessmentYear().equals(currAssessmentYear) && uuid.equals(adjustmentOfLossesCom.getCanonicalUUID())){
	                       getFormMap().addMessage("checkentry", "Warning! You have already selected "+adjustmentOfLossesCom.getNameOfHead()+" for "+adjustmentOfLossesCom.getAssessmentYear());
	                       check = false;
						}
					}
				}
			}
		}
		return check;
	}
	*/

	}

