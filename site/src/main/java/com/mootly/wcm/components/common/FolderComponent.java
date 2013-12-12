package com.mootly.wcm.components.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowCallbackHandler;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.content.beans.standard.HippoFolderBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.repository.reviewedactions.FullReviewedActionsWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.RegExValidationFields;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.components.BaseComponent;

@FormFields(fieldNames={"folderName","parentFolderName"})
@RequiredFields(fieldNames={"folderName","parentFolderName"})
public class FolderComponent extends BaseComponent{

	public static final Logger log = LoggerFactory.getLogger(FolderComponent.class);
	public static final String MIXIN_HIPPO_TRANSLATED = "hippotranslation:translated";
	public static final String MIXIN_HIPPO_HARD_DOCUMENT = "hippo:harddocument";
	public static final String MIXIN_HIPPO_TRANSLATION = "hippo:translated";
	public static final String PROP_HIPPO_TARNSLATION_LOCALE = "hippotranslation:locale";
	public static final String PROP_HIPPO_TARNSLATION_ID = "hippotranslation:id";
	public static final String FOLDER_JCR_PRIMARY = "hippostd:folder";
	public static final String LOCALE = "en";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		request.setAttribute("error", request.getParameter("error"));
		request.setAttribute("formError", request.getParameter("formError"));
		request.setAttribute("alError", request.getParameter("al.error"));
		request.setAttribute("success", request.getParameter("success"));
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		HippoBean siteContentBean = getSiteContentBaseBeanForReseller(request);
		FormFields formFields = this.getClass().getAnnotation(FormFields.class);
		String[] theFieldsArray = formFields.fieldNames();
		FormMap formMap = new FormMap(request,theFieldsArray);
		boolean isValid = validate(request,response,formMap);
		if (!isValid) {
			log.info("Lets check result of validation:"+isValid);
			//this action is save
			List<String> errorList = new ArrayList<String>();
			for(String key:formMap.getMessage().keySet()){
				errorList.add(formMap.getMessage().get(key));
			}
			response.setRenderParameter("formError", errorList.toArray(new String[errorList.size()]));
			return;
		}
		if(formMap!=null){
			String parentFolderName = formMap.getField("parentFolderName").getValue();
			String folderName = formMap.getField("folderName").getValue();
			HippoBean parentBean = siteContentBean.getBean(parentFolderName);
			if(parentBean == null){
				if(log.isInfoEnabled()){
					log.info("Parent Bean Scope is { null } .Not able to create folder in parent.");
					response.setRenderParameter("error", "error.parent.folder.name");
					return;
				}
			}
			if(parentBean instanceof HippoFolder){
				if(log.isInfoEnabled()){
					log.info("Lets create the folder in parentFolder:::");
				}
				HippoFolder parentHippoFolder = (HippoFolder) parentBean;
				for(HippoFolderBean hippoFolderBean:parentHippoFolder.getFolders()){
					if(hippoFolderBean.getName().equalsIgnoreCase(folderName)){
						response.setRenderParameter("al.error", "already.exist.folder");
						return;
					}
				}
				createFolderNodeInRepository(request, parentHippoFolder, folderName);
				response.setRenderParameter("success", "success.create.folder");
				return;
			}
		}
	}
	/**
	 * This method is used to create the {@link HippoFolder} in Specified parent Folder.
	 * 
	 * @param parentHippoFolder {@link HippoFolder}
	 * @param newFolderName {@link String} name of new Folder
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public void createFolderNodeInRepository(HstRequest request,HippoFolder parentHippoFolder,String newFolderName){
		//Node parentFolderNode = parentHippoFolder.getNode();
		String parentFolderUUID = parentHippoFolder.getCanonicalUUID();
		try{
			Session persistableSession = getPersistableSession(request);
			WorkflowPersistenceManager wpm = getWorkflowPersistenceManager(persistableSession);
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			Object object = wpm.getObjectByUuid(parentFolderUUID);
			if(object != null){
				if(object instanceof HippoFolder){
					Node parentFolderNode = ( (HippoFolder) object).getNode();
					if(!parentFolderNode.isCheckedOut()){
						parentFolderNode.checkout();
					}
					Node chidFolderNode = parentFolderNode.addNode(newFolderName, FOLDER_JCR_PRIMARY);
					chidFolderNode.addMixin(MIXIN_HIPPO_TRANSLATION);
					chidFolderNode.addMixin(MIXIN_HIPPO_HARD_DOCUMENT);
					chidFolderNode.addMixin(MIXIN_HIPPO_TRANSLATED);
					chidFolderNode.setProperty(PROP_HIPPO_TARNSLATION_ID, "");
					chidFolderNode.setProperty(PROP_HIPPO_TARNSLATION_LOCALE, LOCALE);

					parentFolderNode.save();
					parentFolderNode.refresh(true);
				}
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get the Object from Repository or operation on Repository Node",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static class FullReviewedWorkflowCallbackHandler implements WorkflowCallbackHandler<FullReviewedActionsWorkflow> {
		public void processWorkflow(FullReviewedActionsWorkflow wf) throws Exception {
			wf.publish();
		}
	}
	protected boolean validate(HstRequest request,HstResponse response,FormMap formMap) {
		//validate required fields first
		if (this.getClass().isAnnotationPresent(RequiredFields.class)) {
			RequiredFields requiredFieldsAnnotations = this.getClass().getAnnotation(RequiredFields.class);
			String[] fieldNames = requiredFieldsAnnotations.fieldNames();
			/*String[] additionalFieldNames = getRequiredFields();
			if (additionalFieldNames != null) {
				 List<String> both = new ArrayList<String>(fieldNames.length + additionalFieldNames.length);
				 Collections.addAll(both, fieldNames);
				 Collections.addAll(both, additionalFieldNames);
				 fieldNames = both.toArray(new String[both.size()]);
			}*/
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

		if (this.getClass().isAnnotationPresent(RegExValidationFields.class)) {
			RegExValidationFields regExValidationFields = this.getClass().getAnnotation(RegExValidationFields.class);
			String[] fieldNames = regExValidationFields.fieldNames();
			String[] regExPattern = regExValidationFields.patterns();
			for (int i=0;i<fieldNames.length;i++) {
				String whatToMatch = formMap.getField(fieldNames[i]).getValue();
				String pattern = regExPattern[i];
				if (log.isInfoEnabled()) {
					log.info("Will now try to match:" + whatToMatch + " with pattern:" + pattern);
				}
				if (whatToMatch != null) {
					try {
						Pattern p = Pattern.compile(regExPattern[i]);
						boolean isAMatch = p.matcher(whatToMatch).matches();
						if (!isAMatch) {
							formMap.getField(fieldNames[i]).addMessage("err.pattern." + fieldNames[i]);
						}
					}
					catch (PatternSyntaxException pse) {
						log.warn("Pattern Syntax Exception",pse);
					}
					finally {

					}
				}
			}
		}

		//
		if (this.getClass().isAnnotationPresent(DataTypeValidationFields.class)) {
			DataTypeValidationFields dataTypeValidationFields = this.getClass().getAnnotation(DataTypeValidationFields.class);
			String[] fieldNames = dataTypeValidationFields.fieldNames();
			DataTypeValidationType[] dataTypes = dataTypeValidationFields.dataTypes();
			for (int i=0;i<fieldNames.length;i++) {
				if (formMap.getField(fieldNames[i]) == null) {
					log.warn("Empty field??Invalid Annotation",fieldNames[i]);
					continue;
				}
				String whatToMatch = formMap.getField(fieldNames[i]).getValue();
				if (StringUtils.isEmpty(whatToMatch)) {
					log.warn("Cannot check format for an empty field "+ fieldNames[i] + " was found empty");
					continue;
				}
				DataTypeValidationType dataType = dataTypes[i];
				if (log.isInfoEnabled()) {
					log.info("Will now try to match:" + whatToMatch + " with pattern:" + dataType);
				}
				if (whatToMatch != null) {
					try {
						boolean isValid = DataTypeValidationHelper.isOfType(whatToMatch, dataType);
						if (!isValid) {
							formMap.getField(fieldNames[i]).addMessage("err.datatype." + fieldNames[i]);
						}
					}
					catch (PatternSyntaxException pse) {
						log.warn("Pattern Syntax Exception",pse);
					}
					finally {

					}
				}
			}
		}
		
		if (formMap.getMessage() != null && formMap.getMessage().size() > 0) {
			log.info("size of message"+formMap.getMessage().size());
			FormUtils.persistFormMap(request, response, formMap, null);
			return false;
		}
		else {
			log.info("could not possible");
			return true;
		}
	}


}
