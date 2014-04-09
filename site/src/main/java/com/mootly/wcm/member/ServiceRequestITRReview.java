

package com.mootly.wcm.member;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.compound.CostModel;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.CostModelName;
import com.mootly.wcm.model.SORT_DIRECTION;

@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"packageValue"})
public class ServiceRequestITRReview extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ServiceRequestITRReview.class);

	@SuppressWarnings("deprecation")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);

		Map<String, String> mapForCostModelName = CostModelName.getDisplayNameWithKey();
		request.setAttribute("mapForCostModelName", mapForCostModelName);

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());

		if(memberPersonalInformation != null){
			//ITRForm selectedITRForm = memberPersonalInformation.getSelectedITRForm();
			//ITRServiceDelivery selectedITRServiceDelivery = memberPersonalInformation.getSelectedServiceDeliveryOption();
			String selectedITRForm =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
			String selectedITRServiceDelivery = memberPersonalInformation.getFlexField("flex_string_ITRServiceDelivery", "");

			request.setAttribute("selectedITRServiceDelivery", selectedITRServiceDelivery);

			List<HippoDocumentBean> listOfITRServices = getITRInitData(request).loadAllBeansUnderTheFolder(request,  "documents/services/incometaxreturn", "mootlywcm:Name",SORT_DIRECTION.ASC);
			List<CostModel> listOfCostModel = new ArrayList<CostModel>();

			if(listOfITRServices!=null){
				for (HippoBean aBean:listOfITRServices) {
					Service theService = (Service) aBean;
					if(StringUtils.isNotBlank(theService.getName()) && theService.getName().equals(selectedITRForm)){
						for (CostModel theCostModel:theService.getCostModel()) {
							if(theCostModel.getIsAvailableForUser()){
								if(StringUtils.isNotBlank(theCostModel.getOfferingMode()) && theCostModel.getOfferingMode().equals(selectedITRServiceDelivery)){
									if(theCostModel.getExpertReview()){
										request.setAttribute("expertReviewAvail", theCostModel.getExpertReview());
									}
								}
								listOfCostModel.add(theCostModel);
							}
						}
					}
				}
			}
			request.setAttribute("listOfCostModel", listOfCostModel);
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}

