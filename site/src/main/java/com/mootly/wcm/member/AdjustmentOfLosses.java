

package com.mootly.wcm.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
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
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleCFLSections;

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

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		FinancialYear financialYear =  (FinancialYear) request.getAttribute("financialYear");
		Map<String, List<String>> resultMapOfCFL = ITRScheduleCFLSections.getDetailListOfSections(financialYear, memberPersonalInformation.getSelectedITRForm());
		request.setAttribute("resultMapOfCFL", resultMapOfCFL);
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
		super.beforeSave(request);
		boolean check = true;
		//String uuid;

		return check;
	}
	public GregorianCalendar ConvDateStringToCalendar(String strDate){
		Date date = null ;
		DateFormat formatter = BaseDocument.getIndianDateFormatter();
		GregorianCalendar cal=null;
		if(StringUtils.isNotEmpty(strDate)){
			cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate);
				cal.setTime(date);
			}
			catch(Exception e){
				log.error("calendar error"+e);
			}
			return cal;
		}else return null;

	}
	@Override
	public void afterSave(HstRequest request,FormMap formMap,PAGE_ACTION pageAction) {
		// TODO Auto-generated method stub
		super.afterSave(request,formMap,pageAction);
		Session persistenceSession;
		List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom=null;
		String path=null;
		try {
			persistenceSession = getPersistableSession(request);
			WorkflowPersistenceManager wpm=getWorkflowPersistenceManager(persistenceSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			path=getAbsoluteBasePathToReturnDocuments()+"/"+AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase();
			AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) wpm.getObject(path);
			String currAssessmentYear=getFormMap().getField("AssessmentYear").getValue();
			String currDate = getFormMap().getField("DateOfFilingYear").getValue();
			if(getPageAction().equals(PAGE_ACTION.EDIT_CHILD)){
				if(adjustmentOfLossesDoc != null){
					listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
					if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
						for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
							if(adjustmentOfLossesCom.getAssessmentYear().equals(currAssessmentYear)){
								adjustmentOfLossesCom.setDateOfFilingYear(ConvDateStringToCalendar(currDate));
							}
						}
					}
				}
				adjustmentOfLossesDoc.setAdjustmentOfLossesList(listofAdjustmentOfLossesCom);
				wpm.update(adjustmentOfLossesDoc);
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Persistable Session of JCR Repository",e);
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			log.error("Error while updating Document",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get the object at path"+path,e);
		} 
	}
}

