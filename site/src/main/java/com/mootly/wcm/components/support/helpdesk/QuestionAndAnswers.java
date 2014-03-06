package com.mootly.wcm.components.support.helpdesk;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryManager;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.component.HstURL;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.HelpDeskTicketDocument;
import com.mootly.wcm.beans.compound.HelpDeskTicketNote;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.components.ITReturnInitData;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.UserType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.utils.PageableCollection;

@PrimaryBean (primaryBeanClass=HelpDeskTicketDocument.class)
@ChildBean (childBeanClass=HelpDeskTicketNote.class)
@FormFields(fieldNames={"scriptName","fileName","question"},fieldNamesVendorOnly={"answer","answered"})

public class QuestionAndAnswers extends ITReturnComponent {
	final Logger log = LoggerFactory.getLogger(QuestionAndAnswers.class);
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
	}

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		PAGE_ACTION pageAction = getITRInitData(request).getPageAction();
		if (pageAction != null && pageAction == PAGE_ACTION.NEW_CHILD ) {
			//we should also try to find help articles based on the script name
			String fileName = getPublicRequestParameter(request, "fileName");
			if (fileName != null && fileName.contains("/")) {
				String[] partsOfScriptName = fileName.split("[/]");
				fileName = partsOfScriptName[partsOfScriptName.length - 1];
				
			}
			if (fileName != null && fileName.contains(".")) {
				fileName = fileName.substring(0,fileName.indexOf("."));
			}
			
			HippoBean scope = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
			scope =  scope.getBean("documents");
	        
	        try {
	            HstQueryManager manager = getQueryManager(request);
	            @SuppressWarnings("unchecked")            
	            HstQuery hstQuery = null;                    
	            if (hstQuery == null) { 
	            	hstQuery = manager.createQuery(scope);
	            	Filter excludeFolders = hstQuery.createFilter();
	            	excludeFolders.addNotEqualTo("jcr:primaryType", "hippostd:folder");
	            	hstQuery.setFilter(excludeFolders);
	            }
	            //hstQuery = manager.createQuery(scope);
	
	            //HippoBean assetScope = getAssetBaseBean(request);
	            //hstQuery.addScopes(Collections.singletonList(assetScope));
	
	            if (!StringUtils.isEmpty(fileName)) {
	                Filter filter = hstQuery.createFilter();
	                hstQuery.setFilter(filter);
	                
	                
	                Filter excludeFolders = hstQuery.createFilter();
	            	excludeFolders.addNotEqualTo("jcr:primaryType", "hippostd:folder");
	            	filter.addAndFilter(excludeFolders);
	                                
	                // title field
	                Filter fileNameFilter = hstQuery.createFilter();
	                filter.addAndFilter(fileNameFilter);
	                
	                
	                Filter fileNameFilterName =  hstQuery.createFilter();
	                fileNameFilterName.addEqualTo("@mootlywcm:categories", fileName);
	                Filter fileNameAllFilter = hstQuery.createFilter();
	                fileNameAllFilter.addEqualTo("@mootlywcm:categories", "All");
	                
	                fileNameFilter.addOrFilter(fileNameFilterName);
	                fileNameFilter.addOrFilter(fileNameAllFilter);
	                
	                // summary field
	                
	                
	                //https://issues.onehippo.com/browse/mootlywcm-254
	                hstQuery.addOrderByAscending("mootlywcm:title");
	            }
	            HstQueryResult result = hstQuery.execute();
	            int getSize = result.getSize();
	            
	            HippoBeanIterator beans = result.getHippoBeans();
	            int pageSize = 5;
	            int currentPage = 1;
	
	            PageableCollection<HippoBean> results = new PageableCollection<HippoBean>(beans, pageSize, currentPage);
	            if (results != null && results.getItems() != null && results.getItems().size() > 0) {
	            	HippoBean firstBean = results.getItems().get(0);
	            	request.setAttribute("firstBean", firstBean);
	            }
	            request.setAttribute("searchResult", results);
	        } catch (QueryException e) {
	            if(log.isDebugEnabled()) {
	                log.warn("Error during search: ", e);
	            } else {
	                log.warn("Error during search: ", e.getMessage());
	            }
	        }
		}
		else if (pageAction != null && pageAction == PAGE_ACTION.EDIT_CHILD) {
			HstURL hstURL = response.createActionURL();
			request.setAttribute("hstURL", hstURL.toString());
		}
        
		/*
		DigitalSignatureWrapper digitalSignatureWrapper;
		try {
			digitalSignatureWrapper = getDigitalSignatureService().getDigitalSignatureFromRepository("/content/documents/mootlywcm/resellers/w4india/members/amitpatkar-at-gmail.com/drive/abnpp1234g/2012-2013/abnpp1234g_f_1213/dsc_sweta.pfx",true);
			if (log.isInfoEnabled()) {
				if (digitalSignatureWrapper == null) {
					log.info("Digital Signature not found");
				}
				else {
					log.info(digitalSignatureWrapper.toString());
				}
			}
		} catch (MissingPrivateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingDigitalCertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDigitalSignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 */
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}				

	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler(HstRequest request) {
		return new ChildBeanLifeCycleHandler(request,getITRInitData(request));
	}
	protected BeanLifecycle<HippoBean> getParentBeanLifeCycleHandler(HstRequest request) {
		return new ParentBeanLifeCycleHandler(request,getSequenceGenerator());

	}
	
	@Override
	protected String[] modifiedFieldsArray(HstRequest request,
			String[] fieldsArray) {
		// TODO Auto-generated method stub
		//if a vendor is replying we just wnt answer and answered to be passed
		if ( getITRInitData(request).getPageAction() != null && getITRInitData(request).getPageAction() == PAGE_ACTION.EDIT_CHILD && getITRInitData(request).isOnVendorPortal()) {
			return new String[] {"answer","uuid"};
		}
		else {
			return super.modifiedFieldsArray(request,fieldsArray);
		}
	}
}
/**
 * 
 * @author Amit
 *
 */
class ChildBeanLifeCycleHandler implements BeanLifecycle<HippoBean> {
	final HstRequest request;
	final ITReturnInitData itReturnInitData;
	public ChildBeanLifeCycleHandler(final HstRequest request, final ITReturnInitData itReturnInitData) {
		this.request = request;
		this.itReturnInitData = itReturnInitData;
	}
	@Override
	public void afterFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean beforeSaveNewBean(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterSaveNewBean(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		HelpDeskTicketNote helpDeskTicketNote = (HelpDeskTicketNote) hippoBean;
		String updaterType = (itReturnInitData.isVendor(request) && itReturnInitData.isOnVendorPortal() ? UserType.VENDOR.name() : UserType.MEMBER.name());
		helpDeskTicketNote.setStrUpdaterType(updaterType);
		
		helpDeskTicketNote.setIsqa(Boolean.TRUE);
		
		if (itReturnInitData.isVendor(request) && itReturnInitData.isOnVendorPortal()) {
			helpDeskTicketNote.setAnswered(Boolean.TRUE);
		}
		
		
	}

	@Override
	public boolean validateChildBean(HippoBean hippoBean,
			boolean isNew, List<String> errors,
			List<String> warnings) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateParentBean(HippoBean hippoBean,
			boolean isNew, List<String> errors,
			List<String> warnings) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean beforeUpdate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterUpdate(HippoBean beanBeforeUpdate,
			HippoBean beanAfterUpdate,
			WorkflowPersistenceManager wpm,
			String baseAbsolutePathToReturnDocuments,
			ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterUpdateChild(HippoBean parentBeanBeforeUpdate,
			HippoBean parentBeanAfterUpdate,
			HippoBean childBeanBeforeUpdate,
			HippoBean childBeanAfterUpdate,
			WorkflowPersistenceManager wpm,
			ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub

	}
}




class ParentBeanLifeCycleHandler implements BeanLifecycle<HippoBean> {
	final HstRequest request;
	final SequenceGenerator sequenceGenerator;
	public ParentBeanLifeCycleHandler(final HstRequest request,final SequenceGenerator sequenceGenerator) {
		this.request = request;
		this.sequenceGenerator = sequenceGenerator;
	}
	@Override
	public void beforeCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean beforeSaveNewBean(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterSaveNewBean(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		HelpDeskTicketDocument helpDeskDocument = (HelpDeskTicketDocument) hippoBean;
		if (helpDeskDocument != null && ( helpDeskDocument.getIdentifier() == null || "".equals(helpDeskDocument.getIdentifier()))  ) {
			Long theNextTicketId = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_HELP_DESK_TICKET);
			helpDeskDocument.setIdentifier(theNextTicketId.toString());
		}
	}

	@Override
	public void afterFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateChildBean(HippoBean hippoBean,
			boolean isNew, List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateParentBean(HippoBean hippoBean,
			boolean isNew, List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean beforeUpdate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterUpdate(HippoBean beanBeforeUpdate,
			HippoBean beanAfterUpdate, WorkflowPersistenceManager wpm,
			String baseAbsolutePathToReturnDocuments,
			ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterUpdateChild(HippoBean parentBeanBeforeUpdate,
			HippoBean parentBeanAfterUpdate,
			HippoBean childBeanBeforeUpdate,
			HippoBean childBeanAfterUpdate,
			WorkflowPersistenceManager wpm,
			ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub

	}

}
