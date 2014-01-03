package com.mootly.wcm.components.cms;

import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;

public class ITReturnAnalysisComponent extends ITReturnComponent{

	public static final Logger log = LoggerFactory.getLogger(ITReturnAnalysisComponent.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		//super.doBeforeRender(request, response);
		HippoBean resellerBeanScope = getSiteContentBaseBeanForReseller(request);
		String primaryNodeTypes = null;
		if(MemberPersonalInformation.class.isAnnotationPresent(org.hippoecm.hst.content.beans.Node.class)){
			primaryNodeTypes = MemberPersonalInformation.class.getAnnotation(org.hippoecm.hst.content.beans.Node.class).jcrType();
		}
		try {
			List<String[]> itrFormsList = new ArrayList<String[]>();
			for(ITRForm itrForm:ITRForm.values()) {
				if(!itrForm.equals(ITRForm.UNKNOWN)) {
					String[] itrInfo = new String[2];
					itrInfo[0] = itrForm.name();
					HstQuery hstQuery = getQueryManager(request).createQuery(resellerBeanScope, primaryNodeTypes);
					Filter filter = hstQuery.createFilter();
					filter.addEqualTo("flex_string_ITRForm", itrForm.name());
					hstQuery.setFilter(filter);
					itrInfo[1] = String.valueOf(hstQuery.execute().getTotalSize());
					itrFormsList.add(itrInfo);
				}
			}
			request.setAttribute("itrFormsList", itrFormsList.toArray());
			if(log.isInfoEnabled()) {
				log.info("Lets see itr forms analysis result::" + itrFormsList);	
			}
			List<String> fyBasedNoOfReturns = new ArrayList<String>();
			for(FinancialYear fy:FinancialYear.values()){
				if(!fy.equals(FinancialYear.UNKNOWN)){
					if(fy.isActive()){
						HstQuery hstQuery = getQueryManager(request).createQuery(resellerBeanScope, primaryNodeTypes);
						Filter filter = hstQuery.createFilter();
						filter.addEqualTo("mootlywcm:financialYear", fy.getDisplayName());
						hstQuery.setFilter(filter);
						fyBasedNoOfReturns.add(String.valueOf(hstQuery.execute().getTotalSize()));
					}
				}
			}
			request.setAttribute("fyBasedNoOfReturns", fyBasedNoOfReturns.toArray());
			if(log.isInfoEnabled()) {
				log.info("Lets see itr forms analysis result::" + fyBasedNoOfReturns);	
			}
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
