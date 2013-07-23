/*
 * In this class we are creating a document for storing value of Residential details of user
 * according to form 16.
 * @author Priyank
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberResidentialStatus;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * @author Priyank
 * This code will work when user click on activation link
 * 06-Mar-2013
 * 
 */
@PrimaryBean(primaryBeanClass=MemberResidentialStatus.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@FormFields(fieldNames={"rsstatus_q","rsstatus_q_yes","rsstatus_q_yes_yes","rsstatus_q_no","rsstatus_q_no_yes","rsstatus_q_no_yes_yes",
		"rsstatus_q_no_no","rsstatus_q_no_no_yes","rsstatus_q_no_no_yes_yes","rsstatus_q_no_yes_yes_yes"})

public class ResidentialStatus extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(ResidentialStatus.class);
	
	public static final String SUCCESS= "success";
	public static final String ERROR= "error";
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		//get the bundle 
		String assessmentYear = getAssessmentYear() == null ? "2012-2013"  : getAssessmentYear();
		ResourceBundle rb = ResourceBundle.getBundle("rstatus_"+assessmentYear);
		
		List<String> keyList = new ArrayList<String>();
		//Enumeration<String> keys = rb.getKeys();		
		for (String aKey: rb.keySet() ) {
			keyList.add(aKey);			
		}
		String memberName = null;
		String keyToFind = MemberPersonalInformation.class.getSimpleName().toLowerCase();
		if (request.getAttribute(keyToFind) != null) {
			MemberPersonalInformation mpi = (MemberPersonalInformation) request.getAttribute(keyToFind);
			memberName = mpi.getName();
		}
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		Collections.sort(keyList, new SortyByDepth());
		for (String aKey:keyList) {
			if (memberName != null) {
				String ke = rb.getString(aKey);
				if (log.isInfoEnabled()) {
					log.info("Now attempting to apply format to " + ke);
				}
				map.put(aKey, MessageFormat.format(ke,memberName));
			}
			else {
				map.put(aKey, rb.getString(aKey));
			}
		}
		Map<String, String> fetchmap = new LinkedHashMap<String, String>();
		if (getParentBean() != null) {
			MemberResidentialStatus memberresi = (MemberResidentialStatus) getParentBean();			
			
			fetchmap.put("rsstatus_q",memberresi.getRsstatusQ());			
			if(!(memberresi.getRsstatusQYes().matches("Select")))
				fetchmap.put("rsstatus_q_yes",memberresi.getRsstatusQYes());			
			if(!(memberresi.getRsstatusQYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_yes_yes",memberresi.getRsstatusQYesYes());									
			if(!(memberresi.getRsstatusQNo().matches("Select")))
				fetchmap.put("rsstatus_q_no",memberresi.getRsstatusQNo());			
			if(!(memberresi.getRsstatusQNoYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_yes",memberresi.getRsstatusQNoYes());					
			if(!(memberresi.getRsstatusQNoYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_yes_yes",memberresi.getRsstatusQNoYesYes());			
			if(!(memberresi.getRsstatusQNoNo().matches("Select")))
				fetchmap.put("rsstatus_q_no_no",memberresi.getRsstatusQNoNo());						
			if(!(memberresi.getRsstatusQNoNoYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_no_yes",memberresi.getRsstatusQNoNoYes());			
			if(!(memberresi.getRsstatusQNoNoYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_no_yes_yes",memberresi.getRsstatusQNoNoYesYes());						
			if(!(memberresi.getRsstatusQNoYesYesYes().matches("Select")))
				fetchmap.put("rsstatus_q_no_yes_yes_yes",memberresi.getRsstatusQNoYesYesYes());			
			
			request.setAttribute("fetchmap", fetchmap);
		}
		//map.put(aKey, rb.getString(aKey));
		JSONObject jsonObject = new JSONObject(map);
		request.setAttribute("jsonObject", jsonObject);
		request.setAttribute("map", map);
		
	}

	//TODO update in the document for user registration
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		if(log.isInfoEnabled()){
		log.info("this is do action of residential status");
		}
		super.doAction(request, response);	
	}
	
	class SortyByDepth implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String[] leftArray = o1.split("[_]");
			String[] rightArray = o2.split("[_]");
			if (leftArray.length < rightArray.length){
				return -1;
			}
			else if (leftArray.length == rightArray.length) {
				return 0;
			}
			else 
				return 1;
		}		
	}
	
}
