/**
 * 
 */
package com.mootly.wcm.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.linking.HstLink;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.beans.compound.SecurityQuestionAnswerValueList;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.SecurityQuestion;
import com.mootly.wcm.services.SecureHashGeneration;
import com.mootly.wcm.utils.ContentStructure;

@FormFields(fieldNames = {"securityQuestion","securityAnswer"})
@RequiredFields(fieldNames = {"securityQuestion","securityAnswer"})
/**
 * @author BEN-10
 *
 */
public class MemberSecurity extends BaseComponent {

	private final static Logger log = LoggerFactory.getLogger(MemberSecurity.class);
	private static final String MEMBER_HOME_REF_ID="itreturnhome";
	private static String targetPath="";
	private static String memberPath="";
	private static String uuid;
	private static PAGE_ACTION pageAction;
	private static FormMap formMap;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		handleRequestParameter(request);
		if(getFormMap()!=null && getPageAction().equals(PAGE_ACTION.DELETE_CHILD)){
			updateMemberSignUpDocument(request, response, getFormMap());
		}
		targetPath=getTargerPath(request,MEMBER_HOME_REF_ID);
		String enableSecurityQuestion = request.getRequestContext().getResolvedSiteMapItem().getParameter("enableSecurityQuestion");
		enableSecurityQuestion = StringUtils.isNotBlank(enableSecurityQuestion) ? enableSecurityQuestion : "false";
		String sec_param_sitemMap = request.getRequestContext().getResolvedSiteMapItem().getParameter("security");
		String sec_param_url = getPublicRequestParameter(request, "security");
		MemberSignupDocument memberSignupDoc=null;
		try {
			if(enableSecurityQuestion.equalsIgnoreCase("true")){
				memberPath=ContentStructure.getSignUpDocumentPath(getNormalizedUserName(request)).toLowerCase();
				memberSignupDoc=(MemberSignupDocument)getObjectBeanManager(request).getObject(memberPath);
				if(memberSignupDoc!=null){
					boolean hexValue=SecureHashGeneration.isHexFormat(memberSignupDoc.getPassword().toString());
					log.info("is Password in SHA-256 or hexValue:"+hexValue);
					if(memberSignupDoc.getSecurityQuestions() && StringUtils.isBlank(sec_param_sitemMap) && StringUtils.isBlank(sec_param_url)){							
						response.sendRedirect(targetPath);
					}else{
						request.setAttribute("securityQues", "true");
						request.setAttribute("parentBean", memberSignupDoc);
					}
				}else{
					response.sendRedirect(targetPath);
				}
			}else{
				response.sendRedirect(targetPath);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error while redirect to target Url",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Object at path "+memberPath+" in repository",e);
		}
		Map<String, Map<String, String>> questionsMap=new HashMap<String, Map<String,String>>();
		ResourceBundle sqRB= ResourceBundle.getBundle("security_question");
		for(SecurityQuestion sq:SecurityQuestion.values()){
			if(sq.isActive()){
				Map<String, String> securityQuesMap=new HashMap<String, String>();
				for(int i=1;i<=sq.getSize();i++){
					if(sqRB.containsKey(sq.getKey()+".value."+i)){
						securityQuesMap.put("sq.ques"+i, sqRB.getString(sq.getKey()+".value."+i));
					}
				}
				questionsMap.put(sq.getDisplayName(), securityQuesMap);
			}
		}
		if(questionsMap!=null){
			request.setAttribute("questionsMap", questionsMap);
		}
		uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");
		String action = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		pageAction = action !=null ? PAGE_ACTION.DEFAULT : PAGE_ACTION.valueOf(action);
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		log.info("this is new era of development");
		handleRequestParameter(request);
		if(getFormMap()!=null){
			boolean isValid = validateFormMap(request, response, getFormMap());
			if(!isValid){
				return;
			}
			updateMemberSignUpDocument(request, response, getFormMap());
		}
	}
	/**
	 * This method is used to update {@link MemberSignupDocument} so that we can Save Security Questions.
	 * 
	 *  @param request {@link HstRequest}
	 *  @param response {@link HstResponse}
	 *  @param formMap {@link FormMap}
	 *  
	 *  @return {@link Void}
	 * 
	 * **/
	public void updateMemberSignUpDocument(HstRequest request,HstResponse response,FormMap formMap){
		Session persistableSession=null;
		WorkflowPersistenceManager wpm=null;
		String memberDocPath=null;
		targetPath=getTargerPath(request,MEMBER_HOME_REF_ID);
		try {
			persistableSession=getPersistableSession(request);
			wpm=getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			memberDocPath = ContentStructure.getMemberFolder(request, getNormalizedUserName(request));
			MemberSignupDocument memberSignUpDocument=(MemberSignupDocument) wpm.getObject(memberDocPath+"/"+MemberSignupDocument.NODE_NAME);
			if(memberSignUpDocument!=null){
				memberSignUpDocument.setSecurityQuestions(true);
				if(getPageAction().equals(PAGE_ACTION.NEW_CHILD)){
					SecurityQuestionAnswerValueList securityQuestionAnswerValueList = new SecurityQuestionAnswerValueList();
					securityQuestionAnswerValueList.fill(formMap);
					memberSignUpDocument.add(securityQuestionAnswerValueList);
				}
				if(getPageAction().equals(PAGE_ACTION.EDIT_CHILD) && StringUtils.isNotBlank(getUuid())){
					SecurityQuestionAnswerValueList securityQuestionAnswerValueList = (SecurityQuestionAnswerValueList) wpm.getObjectByUuid(getUuid());
					if(securityQuestionAnswerValueList != null){
						securityQuestionAnswerValueList.fill(formMap);
						memberSignUpDocument.update(securityQuestionAnswerValueList);
					}
				}
				if(getPageAction().equals(PAGE_ACTION.DELETE_CHILD) && StringUtils.isNotBlank(getUuid())){
					SecurityQuestionAnswerValueList securityQuestionAnswerValueList = (SecurityQuestionAnswerValueList) wpm.getObjectByUuid(getUuid());
					if(securityQuestionAnswerValueList != null){
						memberSignUpDocument.delete(securityQuestionAnswerValueList);
					}
					targetPath = request.getAttribute("scriptName")+"?security=true";
				}
				wpm.update(memberSignUpDocument);
				response.sendRedirect(targetPath);
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Persistable Session from Repository",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error while get Object at path "+memberDocPath+" in repository",e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error while redirect to target Url",e);
		} finally{
			if(persistableSession != null){
				persistableSession.logout();
			}
		}
	}
	private static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	/**
	 * This method is used to create the Target Url 
	 * 
	 * @param request {@link HstRequest}
	 * @param memberHomeRefID {@link String} Reference ID of siteMapItem.
	 * 
	 * @return {@String} Target Path based on Ref ID of siteMapItem
	 * */
	public static String getTargerPath(HstRequest request,String memberHomeRefID){
		HstLink link=request.getRequestContext().getHstLinkCreator().createByRefId(memberHomeRefID, request.getRequestContext().getResolvedMount().getMount());
		String targetPath=link.toUrlForm(request.getRequestContext(), true);
		return targetPath;
	}

	public String getUuid(){
		return uuid;
	}

	public PAGE_ACTION getPageAction(){
		return pageAction;
	}

	public FormMap getFormMap(){
		return formMap;
	}

	public void handleRequestParameter(HstRequest request){
		FormFields formFields = this.getClass().getAnnotation(FormFields.class);
		formMap= new FormMap(request, formFields.fieldNames());
		uuid = request.getRequestContext().getResolvedSiteMapItem().getParameter("uuid");
		String action = request.getRequestContext().getResolvedSiteMapItem().getParameter("action");
		if(action !=null){
			pageAction = PAGE_ACTION.valueOf(action);
		}else{
			pageAction = PAGE_ACTION.DEFAULT ;
		}		
		String mainSiteMapItemRefId = request.getRequestContext().getResolvedSiteMapItem().getParameter("mainSiteMapItemRefId");
		String scriptName = getTargerPath(request, mainSiteMapItemRefId);
		request.setAttribute("uuid", getUuid());
		request.setAttribute("pageAction", getPageAction());
		request.setAttribute("scriptName", scriptName);
		request.setAttribute("formMap", getFormMap());
	}
	public boolean validateFormMap(HstRequest request, HstResponse response, FormMap formMap){

		if (this.getClass().isAnnotationPresent(RequiredFields.class)) {
			RequiredFields requiredFieldsAnnotations = this.getClass().getAnnotation(RequiredFields.class);
			String[] fieldNames = requiredFieldsAnnotations.fieldNames();
			if (fieldNames != null && fieldNames.length > 0 ) {
				for (String aRequiredField:fieldNames) {
					if (formMap.getField(aRequiredField) == null) {
						formMap.addMessage(aRequiredField, "err.required." + aRequiredField);
						continue;
					}
					if (StringUtils.isEmpty( formMap.getField(aRequiredField).getValue().trim() ) ) {
						formMap.getField(aRequiredField).addMessage("err.required." + aRequiredField);
						continue;
					}
				}
			}
		}
		if (formMap.getMessage() != null && formMap.getMessage().size() > 0) {
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			return true;
		}
	}

}
