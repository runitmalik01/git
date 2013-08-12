/**
 * 
 */
package com.mootly.wcm.model.schedules.y2012_2013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.ScheduleSIDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.model.ResidentStatus;

/**
 * @author BEN-10
 *
 */
@PrimaryBean(primaryBeanClass=ScheduleSIDocument.class)
@ChildBean(childBeanClass=ScheduleSIDocumentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
@FormFields(fieldNames={"schedulesiSection","amount"})
@RequiredFields(fieldNames={"schedulesiSection","amount"})
@DataTypeValidationFields(fieldNames={"amount"},dataTypes={DataTypeValidationType.DECIMAL})
public class ITRScheduleSI extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ITRScheduleSI.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		MemberPersonalInformation o = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections schSISection:ITRScheduleSISections.values()){
			if(schSISection.isActive()){
				ResidentStatus[] siResident=schSISection.getResidentialStatus();
				for(ResidentStatus rs:siResident){
					if(rs.toString().equalsIgnoreCase(o.getResidentCategory())){
						scheduleSIList.add(schSISection);		
					}	
				}
			}
		}
		request.setAttribute("scheduleSIList", scheduleSIList);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return super.beforeSave(request);
		/*if(getPageAction().equals(PAGE_ACTION.NEW_CHILD)&& getParentBean()==null){
			List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
			for(ITRScheduleSISections schSISection:ITRScheduleSISections.values()){
				if(!schSISection.isActive()){
					scheduleSIList.add(schSISection);		
				}
			}
			if(!scheduleSIList.isEmpty()){
				
			}
		}*/
	}
	
	@Override
	public void afterSave(HstRequest request, FormMap map,
			PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		super.afterSave(request, map, pageAction);
	}
	
	/*public static Map<String , String> createInActiveScheduleSISection(HstRequest request ,List<ITRScheduleSISections> scheduleSIList){
		Map<String , String > InActiveschesuleSI = new HashMap<String, String>();
		
	}*/
	
}
