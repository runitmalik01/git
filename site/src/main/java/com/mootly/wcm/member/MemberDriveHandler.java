package com.mootly.wcm.member;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.ITReturnType;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.MootlyFormUtils;
import com.mootly.wcm.utils.VelocityUtils;

@FormFields(fieldNames={"member_file","description","protected","additionalnotes"})
public class MemberDriveHandler {

	private static final Logger log = LoggerFactory.getLogger(MemberDriveHandler.class);
	private static final String MEMBER_DRIVE_FOLDER_NAME="members";
	private static final long MEMBER_FILE_SIZE= 1024 * 1024;
	private static final String FILE_DATA="fileData";
	private static final String CONTENT_TYPE="ContentType";
	private static final String FILE_NAME="fileName";

	HstRequest request;
	FormMap formMap;
	String pan;
	String financialYear;
	ITReturnType returnType;
	String userName;
	String normalisedUserName;
	boolean isReseller;
	String resellerID;
	MemberPersonalInformation memberPersonalInformation;
	//HippoBean siteResellerBeanScope;

	public MemberDriveHandler(HstRequest request) {
		// TODO Auto-generated constructor stub
		this(request,new FormMap(request, MemberDriveHandler.class.getAnnotation(FormFields.class).fieldNames()));			
	}
	
	public MemberDriveHandler(HstRequest request,FormMap formMap) {
		// TODO Auto-generated constructor stub
		ITReturnComponentHelper helper = new ITReturnComponentHelper();
		//BaseComponent baseComponent = new BaseComponent();
		this.request = request;
		this.formMap = formMap;
		this.memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(memberPersonalInformation != null){
			this.returnType = ITReturnType.getByXmlStatus(memberPersonalInformation.getReturnType());
		}else{
			this.returnType = ITReturnType.UNKNOWN;
		}
		this.financialYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear");
		this.pan = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan");
		this.userName = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : null;
		this.normalisedUserName = MootlyFormUtils.getNormalizedString(userName);
		this.isReseller = helper.isReSeller(request);
		this.resellerID = helper.getResellerId(request);
	}
	/**
	 * This method is being used to save the any file uploaded by user in {@link MemberDriveDocument} with name of file Name.<br/>
	 * You can give your location of to save the file in {@link HippoFolder} of Name "Drive" then followed by SubDriveName
	 * 
	 * @param basePathForMemberFile Provide the base path where you want to save the File.<br/>&nbsp;&nbsp; <b>If this Parameter will be null then Method will create the path to save File in Members of Reseller</b>
	 * @param SubDriveName Provide name of SubDrive in Drive {@link HippoFolder}<br/>&nbsp;&nbsp;<b>This could be null then it will save the file in ITRetunDocument Structure e.g. "pan/financialYear/returnType"</b>
	 * @param wpm {@link WorkflowPersistenceManager}
	 * @param sendEmailToVendor 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public boolean SaveFileInMemberDrive(String basePathForMemberFile,String SubDriveName,WorkflowPersistenceManager wpm,boolean sendEmailToVendor){
		boolean successInSaveFile = false;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			try {
				ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
				String str_max_size = request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize");
				if(str_max_size != null){
					long maxsize = Long.parseLong(request.getRequestContext().getResolvedSiteMapItem().getParameter("maxsize"));
					fileUpload.setSizeMax(MEMBER_FILE_SIZE * maxsize);
				}
				List<FileItem> items = fileUpload.parseRequest(request);
				successInSaveFile = SaveFileInMemberDrive(basePathForMemberFile, SubDriveName, items, wpm, sendEmailToVendor);				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				log.error("Error while Parsing the request of MultiPart Type",e);
			}
		}
		return successInSaveFile;
	}
	/**
	 * This method is being used to save the any file uploaded by user in {@link MemberDriveDocument} with name of file Name.<br/>
	 * Important -- Use this method id you already Parsed the request.
	 * 
	 * @param basePathForMemberFile Provide the base path where you want to save the File.<br/>&nbsp;&nbsp; <b>If this Parameter will be null then Method will create the path to save File in Members of Reseller</b>
	 * @param SubDriveName Provide name of SubDrive in Drive {@link HippoFolder}<br/>&nbsp;&nbsp;<b>This could be null then it will save the file in ITRetunDocument Structure e.g. "pan/financialYear/returnType"</b>
	 * @param wpm {@link WorkflowPersistenceManager}
	 * @param sendEmailToVendor 
	 * 
	 * */
	public boolean SaveFileInMemberDrive(String basePathForMemberFile,String SubDriveName,List<FileItem> items,WorkflowPersistenceManager wpm,boolean sendEmailToVendor){
		boolean successInSaveFile = false;
		String primaryPath = null;
		String memberDriveDocPath = null;
		Map<String, byte[]> files = new HashMap<String, byte[]>();
		Map<String,String> fileDetails = new HashMap<String, String>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			try {
				Iterator<FileItem> iter = items.iterator();				
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						if(formMap.getField(item.getFieldName())!=null) {
							formMap.getField(item.getFieldName()).addValue(item.getString());
						}
					} else {
						InputStream inputStream = item.getInputStream();							
						byte[] data = IOUtils.toByteArray(inputStream);
						files.put(FILE_DATA, data);
						fileDetails.put(FILE_NAME, item.getName());
						fileDetails.put(CONTENT_TYPE, item.getContentType());
					}
				}
				primaryPath = getMemberDriveDocPathHandler(basePathForMemberFile, SubDriveName); 
				if(log.isInfoEnabled()){
					log.info("Lets analyse primaryPath for Save of uploaded File:::"+primaryPath);
				}
				memberDriveDocPath = wpm.createAndReturn(primaryPath, MemberDriveDocument.NAMESPACE, fileDetails.get(FILE_NAME), true);
				MemberDriveDocument memberDriveDoc = (MemberDriveDocument) wpm.getObject(memberDriveDocPath);
				if(memberDriveDoc != null){
					memberDriveDoc.setMemberFile(new ByteArrayInputStream(files.get(FILE_DATA)));
					memberDriveDoc.setContentType(fileDetails.get(CONTENT_TYPE));
					memberDriveDoc.setMemberFileName(fileDetails.get(FILE_NAME));
					memberDriveDoc.fill(formMap);
					wpm.update(memberDriveDoc);
					successInSaveFile = true;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Error while get input of File Item",e);
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				log.error("Error to Save MemberDrive Doc at " +memberDriveDocPath + " path!!"+e);
			}
		}
		//response.setRenderParameter("FileUpload", "Success");
		//send an email right here to our administrators and tell them about an availability
		//String[] to = new String[] {"info@wealth4india.com","amit@mootly.com"};
		if(sendEmailToVendor){
			Map<String,Object> velocityContext = new HashMap<String, Object>();
			velocityContext.put("userName",userName);
			velocityContext.put("userNameNormalized", normalisedUserName);
			//now lets put the document detail
			velocityContext.put("fileName",fileDetails.get(FILE_NAME));
			velocityContext.put("protected",formMap.getField("protected").getValue());
			velocityContext.put("additionalnotes",formMap.getField("additionalnotes").getValue());

			if (fileDetails.get(CONTENT_TYPE) != null) {
				velocityContext.put("contentType",fileDetails.get(CONTENT_TYPE));
			}
			velocityContext.put("PAN",pan);
			velocityContext.put("financialYear",financialYear);
			velocityContext.put("itReturnType",returnType);

			if (memberPersonalInformation != null ) {
				velocityContext.put("memberPersonalInformation",memberPersonalInformation);
				velocityContext.put("memberPersonalInformationString",memberPersonalInformation.toString());
			}

			sendEmail(request, null, null, null, "memberuploadedadoc", velocityContext,wpm);
		}
		return successInSaveFile;
	}

	public String getMemberDriveDocPathHandler(String basePathForMemberFile,String SubDriveName) {
		StringBuilder builder = new StringBuilder();
		if(StringUtils.isNotBlank(basePathForMemberFile)) {
			builder.append(basePathForMemberFile);
		} else {
			builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
			if(isReseller && resellerID != null){
				builder.append('/').append("resellers").append('/').append(resellerID);
			}
			if(request.getUserPrincipal() != null){
				builder.append('/').append(MEMBER_DRIVE_FOLDER_NAME);
				builder.append('/').append(normalisedUserName);
			}		
		}
		builder.append('/').append("drive");
		if(StringUtils.isNotBlank(SubDriveName)) {
			builder.append('/').append(SubDriveName.toLowerCase());
		} else {
			if(request.getUserPrincipal() != null){
				builder.append('/').append(pan).append('/').append(financialYear).append('/').append(returnType);
			}
		}
		return builder.toString();
	}

	public void sendEmail(HstRequest request, String[] to,String attachmentList,String defaultMessage,String templateKey,Map<String,Object> velocityContext,WorkflowPersistenceManager wpm) {
		try {
			final Map<String,Object> finalVelocityContext = new HashMap<String, Object>();
			if (velocityContext != null) {
				finalVelocityContext.putAll(velocityContext);
			}

			WebsiteInfo websiteInfo = request.getRequestContext().getResolvedMount().getMount().getChannelInfo();
			if (websiteInfo.getEmailFrom() != null) {
				finalVelocityContext.put("resellerName", websiteInfo.getPageTitlePrefix() );
			}
			if (websiteInfo.getEmailFrom() != null) {
				finalVelocityContext.put("emailFrom", websiteInfo.getEmailFrom() );
			}
			if (websiteInfo.getEmailFromName() != null) {
				finalVelocityContext.put("emailFromName", websiteInfo.getEmailFromName() );
			}
			if (websiteInfo.getEmailSignature() != null) {
				finalVelocityContext.put("emailSignature", websiteInfo.getEmailSignature() );
			}
			if (websiteInfo.getEmailCustomerService() != null) {
				finalVelocityContext.put("emailCustomerService", websiteInfo.getEmailCustomerService() );
			}
			//here we do the VEOCITY MAGIC
			//todo - megha
			//if (subject == null) return;
			if (templateKey == null) return;

			String basePathToSiteContentBean =  getCanonicalBasePathForWrite(request);

			String pathToEmail = "";
			if (normalisedUserName == null) {
				pathToEmail = basePathToSiteContentBean + "/members/emails";
			}
			else {
				pathToEmail = basePathToSiteContentBean + "/members/" + normalisedUserName + "/emails";
			}
			EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/"+templateKey);

			if (to == null) {
				to = emailTemplate.getTo();
				if (to == null) to = new String[]{"info@wealth4india.com"}; //stupid logic what the hack
			}	
			final String pathToParentBean = wpm.createAndReturn(pathToEmail,"mootlywcm:emailmessage",templateKey, true);
			EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToParentBean);

			for (int i=0;i < to.length;i++) {
				String theParseTo = VelocityUtils.parseVelocity(to[i], finalVelocityContext);
				to[i] = theParseTo;
			}

			emailMessage.setTo(to);
			/*if (cc != null) emailMessage.setCc(cc);
    		if (bcc != null) emailMessage.setBcc(bcc);*/
			StringBuffer sbHostName = new StringBuffer();
			sbHostName.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath());

			if (isReseller && resellerID != null) {
				sbHostName.append("/r/").append(resellerID);
			}
			//if (velocityContext == null) {
			//	velocityContext = new HashMap<String, Object>(1);
			//}
			finalVelocityContext.put("memberHostName", sbHostName.toString());

			String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), finalVelocityContext);
			//String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), velocityContext);
			String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), finalVelocityContext);

			if (emailTemplate.getCc() != null) emailMessage.setCc(emailTemplate.getCc());
			if (emailTemplate.getBcc() != null) emailMessage.setBcc(emailTemplate.getBcc());
			emailMessage.setSubject(subject);
			emailMessage.setAttachmentList(attachmentList);
			emailMessage.setTemplateKey(templateKey);
			emailMessage.setHtmlBody(htmlBody);
			wpm.update(emailMessage);
		}
		catch (Exception ex) {
			log.error("Error in sending email",ex);
		}
	}

	public String getCanonicalBasePathForWrite(HstRequest request){
		StringBuilder pathBuilder = new StringBuilder();
		pathBuilder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		if(isReseller && resellerID != null) {
			pathBuilder.append('/').append("resellers").append('/').append(resellerID);
		}
		return pathBuilder.toString();
	}
}
