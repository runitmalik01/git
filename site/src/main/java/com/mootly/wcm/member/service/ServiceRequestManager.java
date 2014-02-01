/**
 * 
 */
package com.mootly.wcm.member.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberDriveDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.ServiceRequestDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.utils.MootlyFormUtils;

/**
 * @author admin
 *
 */
public class ServiceRequestManager {

	public static final Logger log = LoggerFactory.getLogger(ServiceRequestManager.class);

	HstRequest request;
	String normalisedUserName;
	BaseComponent component;
	HippoBean resellerBeanScope;
	boolean isLoggedIn;

	public ServiceRequestManager(HstRequest request,HippoBean resellerBeanScope) {
		// TODO Auto-generated constructor stub
		this.component = new BaseComponent();
		this.request = request;
		this.normalisedUserName = MootlyFormUtils.getNormalizedString(request.getUserPrincipal().getName());
		this.resellerBeanScope = resellerBeanScope;
		this.isLoggedIn = request.getUserPrincipal() != null ? true : false;
	}

	public Boolean CanServiceRequestFullfill(Service service,MemberPersonalInformation pi){
		Boolean canServiceRequestFullfill = true;
		//Service service = (Service) request.getRequestContext().getAttribute("document");
		Long serviceLeadTime = service.getServiceLeadTime(); 
		//MemberPersonalInformation pi = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(pi != null) {
			String stateCode = pi.getState();
			ITRForm itrForm = pi.getSelectedITRForm();
			GregorianCalendar filingDate = IndianGregorianCalendar.getCurrentDateInIndiaAsDate();
			String strfy = pi.getFinancialYear();
			FinancialYear fy = FinancialYear.getByDisplayName(strfy);
			filingDate.add(Calendar.DAY_OF_MONTH, serviceLeadTime.intValue());
			canServiceRequestFullfill = fy.isPastDue(itrForm, filingDate, stateCode);
		}
		return canServiceRequestFullfill;
	} 

	public List<ServiceRequestDocument> getAllMemberServiceRequestDocument() {
		List<ServiceRequestDocument> requestDocuments = new ArrayList<ServiceRequestDocument>();
		HippoBean serviceRequestBean = null;
		if(resellerBeanScope != null){
			if(isLoggedIn){
				serviceRequestBean = resellerBeanScope.getBean("members/"+ normalisedUserName +"/"+ "servicerequest");
			} else {
				serviceRequestBean = resellerBeanScope.getBean("servicerequest");
			}
			if(serviceRequestBean instanceof HippoFolder){
				HippoFolder serviceRequestFolder = (HippoFolder) serviceRequestBean;
				if(serviceRequestFolder != null){
					requestDocuments = serviceRequestFolder.getDocuments(ServiceRequestDocument.class);
				}
			}
		}
		return requestDocuments;
	}

	public ServiceRequestDocument getSRDocumentToUpdate(String srNameOrsrCodeOrRqNumber) {
		ServiceRequestDocument requestDocument = null;
		for(ServiceRequestDocument document:getAllMemberServiceRequestDocument()){
			if(document.getServiceCode().equalsIgnoreCase(srNameOrsrCodeOrRqNumber) 
					|| document.getServiceName().equalsIgnoreCase(srNameOrsrCodeOrRqNumber)|| 
					document.getServiceRequestNumber().compareTo(Long.valueOf(srNameOrsrCodeOrRqNumber)) == 0){
				requestDocument = document;
			}
		}
		return requestDocument;
	}
	public boolean UdateTheServiceRequestWithMemberDrive(WorkflowPersistenceManager wpm, String subDriveName,String serviceRequestNumber){
		boolean isServiceDocumentUpdated = false;
		ServiceRequestDocument requestDocument = getSRDocumentToUpdate(serviceRequestNumber);
		String requestDocumentPath = requestDocument.getCanonicalPath();
		List<String> mdCanonicalHandleUUID = new ArrayList<String>();
		try {
			if(log.isInfoEnabled()){
				log.info("Lets see path for request document to update ::" + requestDocumentPath);
			}
			ServiceRequestDocument serviceDocumentToUpdate = (ServiceRequestDocument) wpm.getObject(requestDocumentPath);
			if(serviceDocumentToUpdate != null){
				for(MemberDriveDocument driveDocument:getAllDocumentForServiceProcess(subDriveName, serviceRequestNumber)){
					mdCanonicalHandleUUID.add(driveDocument.getCanonicalHandleUUID());
				}
			}
			serviceDocumentToUpdate.setMdCanonicalHandleUUID(mdCanonicalHandleUUID);
			serviceDocumentToUpdate.setDocumentUploaded(true);
			wpm.update(serviceDocumentToUpdate);
			isServiceDocumentUpdated = true;
		} catch (ObjectBeanPersistenceException e) {
			// TODO Auto-generated catch block
			log.warn("Error while Updating the Document in Repository",e);
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isServiceDocumentUpdated;
	}

	public Service getServiceForServiceRequest(String serviceRequestNumber){
		Service service = null;
		for(ServiceRequestDocument srDocument:getAllMemberServiceRequestDocument()){
			if(srDocument.getServiceRequestNumber().compareTo(Long.valueOf(serviceRequestNumber)) == 0){
				service = srDocument.getServiceDocument();
			}
		}
		return service;
	}
	public List<MemberDriveDocument> getAllDocumentForServiceProcess(String subDriveName, String serviceRequestNumber){
		List<MemberDriveDocument> driveDocuments = new ArrayList<MemberDriveDocument>();
		HippoBean driveBeanScope;
		StringBuilder relDriveBeanScopePath = new StringBuilder();
		if(isLoggedIn){
			relDriveBeanScopePath.append("members").append('/').append(normalisedUserName).append('/').append("drive");
		} else {
			relDriveBeanScopePath.append("drive");
		}
		if(StringUtils.isNotBlank(subDriveName)){
			relDriveBeanScopePath.append('/').append(subDriveName);
		} 
		driveBeanScope = resellerBeanScope.getBean(relDriveBeanScopePath.toString());
		if(driveBeanScope != null){
			if(driveBeanScope instanceof HippoFolder){
				for(MemberDriveDocument mdDocument: ((HippoFolder) driveBeanScope).getDocuments(MemberDriveDocument.class)){
					for(String documentType:getServiceForServiceRequest(serviceRequestNumber).getDocumentNames()){
						if(documentType.equalsIgnoreCase(mdDocument.getDescription())){
							driveDocuments.add(mdDocument);
						}
					}
				}
			}
		}
		return driveDocuments;
	}
}
