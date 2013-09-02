package com.mootly.wcm.components;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.ObjectBeanPersistenceException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.CompoundChildUpdate;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.components.ITReturnComponent.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.components.ITReturnScreen.PAGE_OUTPUT_FORMAT;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.model.FilingStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRTab;
import com.mootly.wcm.model.ITReturnPackage;
import com.mootly.wcm.model.ITReturnType;

public final class ITReturnComponentHelper {
	private static final Logger log = LoggerFactory.getLogger(ITReturnComponentHelper.class);
	public Member getMember(HstRequest request) {
		Member member = null;
		if (request.getSession() != null && request.getSession().getAttribute("user") != null) {
			member = (Member)request.getSession().getAttribute("user");
		}
		return member;
	}
	
	public String getStrFinancialYear(HstRequest request,HstResponse response) {
		String strFinancialYear = request.getRequestContext().getResolvedSiteMapItem().getParameter("financialYear"); 
		return strFinancialYear;
	}
	
	public FinancialYear getFinancialYear(String strFinancialYear,HstRequest request,HstResponse response) {
		FinancialYear financialYear = FinancialYear.getByDisplayName(strFinancialYear);
		return financialYear;
	}
	
	public String getAssessmentYear(FinancialYear financialYear) {
		String assessmentYear = null;
		if (financialYear != null && !financialYear.equals(FinancialYear.UNKNOWN)) {
			assessmentYear = financialYear.getDisplayAssessmentYear();
		}
		return assessmentYear;
	}
	
	public String getTheFolderContainingITRDocuments(HstRequest request,HstResponse response) {
		return request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnType");
	}
	
	public String getITRFolderSuffix (String theFolderContainingITRDocuments) {
		String itrFolderSuffix = null;
		if ( theFolderContainingITRDocuments != null) {
			itrFolderSuffix = ITReturnType.getByFolderSuffix( theFolderContainingITRDocuments );
		}
		return itrFolderSuffix;
	}
	
	public String getPANFromRequestContext(HstRequest request) {
		String PAN = request.getRequestContext().getResolvedSiteMapItem().getParameter("pan"); 
		return PAN;
	}
	
	public ITReturnPackage getITReturnPackage(HstRequest request) {
		String strItReturnPackage = getParamValueFromRequestContext(request, "itReturnPackage");//request.getRequestContext().getResolvedSiteMapItem().getParameter("itReturnPackage");
		ITReturnPackage itReturnPackage = ITReturnPackage.basic;
		if (strItReturnPackage == null)
			itReturnPackage = ITReturnPackage.basic;
		else {
			try {
				itReturnPackage = ITReturnPackage.valueOf(strItReturnPackage);
			}catch (IllegalArgumentException ie) {
				itReturnPackage = ITReturnPackage.basic;
			}
		}
		return itReturnPackage;
	}
	
	public FilingStatus getFilingStatus(String PAN) {
		FilingStatus filingStatus = FilingStatus.UNKNOWN;
		if (!StringUtils.isEmpty(PAN)) {
			char filingStatusChar = PAN.charAt(3);
			filingStatus = FilingStatus.getEnumByFourthChar(filingStatusChar);
		}
		return filingStatus;
	}
	
	public PAGE_OUTPUT_FORMAT getPageOutputFormat(HstRequest request) {
		String strPageOutputFormat = getParamValueFromRequestContext(request, "outputFormat");
		PAGE_OUTPUT_FORMAT pageOutputFormat = PAGE_OUTPUT_FORMAT.HTML;
		if (strPageOutputFormat != null) {
			try {
				pageOutputFormat = PAGE_OUTPUT_FORMAT.valueOf(strPageOutputFormat);
			}catch(IllegalArgumentException ie) {
				pageOutputFormat = PAGE_OUTPUT_FORMAT.HTML;
			}
		}
		return pageOutputFormat;
	}
	/**
	 * baseRelPathToReturnDocuments = "members/" + getMemberFolderPath(request) + "/pans/" + getPAN() + "/" + getFinancialYear() + "/" + theFolderContainingITRDocuments; // getITReturnType();
		hippoBeanBaseITReturnDocuments = siteContentBaseBean.getBean(baseRelPathToReturnDocuments);
		baseAbsolutePathToReturnDocuments = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;
	 */
	
	public String getBaseRelPathToReturnDocuments(String memberFolderPath,String PAN,FinancialYear financialYear,String theFolderContainingITRDocuments) {
		String retValue = "members/" + memberFolderPath + "/pans/" + PAN + "/" + financialYear + "/" + theFolderContainingITRDocuments;
		return retValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBaseAbsolutePathToReturnDocuments(HstRequest request, String baseRelPathToReturnDocuments) {
		String baseAbsolutePathToReturnDocuments = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath() + "/" + baseRelPathToReturnDocuments;
		return baseAbsolutePathToReturnDocuments;
	}
	
	/**
	 * parentBeanPath = baseRelPathToReturnDocuments + "/" + getParentBeanNodeName();
			parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + getParentBeanNodeName();
	 * @param parentBeanClass
	 * @return
	 */
	public String getParentBeanNamespace(Class<? extends HippoBean> parentBeanClass) {
		org.hippoecm.hst.content.beans.Node node = parentBeanClass.getAnnotation(org.hippoecm.hst.content.beans.Node.class);
		if (node != null) {
			String parentBeanNameSpace	= node.jcrType();
			return parentBeanNameSpace;
		}
		return null;
	}
	
	public String getParentBeanPath(String baseRelPathToReturnDocuments,String parentNodeName) {
		String parentBeanPath =  baseRelPathToReturnDocuments + "/" + parentNodeName;
		return parentBeanPath;
	}
	
	/**
	 * parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + getParentBeanNodeName();
	 * @param request
	 * @param paramName
	 * @return
	 */
	public String getParentBeanAbsolutePath(String baseAbsolutePathToReturnDocuments, String parentBeanNodeName) {
		String parentBeanAbsolutePath = baseAbsolutePathToReturnDocuments + "/" + parentBeanNodeName;
		return parentBeanAbsolutePath;
	}
	
	public String getParentBeanNodeName(Class<? extends HippoBean> parentBeanClass) {
		// TODO Auto-generated method stub
		return parentBeanClass.getSimpleName().toLowerCase();
	}
	
	public String getParamValueFromRequestContext(HstRequest request,String paramName) {
		String theValue = request.getRequestContext().getResolvedSiteMapItem().getParameter(paramName);
		return theValue;
	}
	
	public String getScriptName(HstRequest request,String selectedItrTabAttr,String selectedItrTabParam) {
		String pathInfo = request.getRequestContext().getResolvedSiteMapItem().getPathInfo();
		String scriptName = null;
		if (pathInfo != null && pathInfo.contains(".html")) {
			String[] parts = pathInfo.split("[/]");
			StringBuilder sb = new StringBuilder(request.getContextPath()).append("/");
			int depth = 1;
			for (String aPart:parts) {
				if (aPart.endsWith(".html")) {
					scriptName= aPart;
					break;
				}
				else {
					sb.append(aPart).append("/");
				}
				depth++;
			}
			sb.append(scriptName);
			//int remainderOFDepth = parts.length - depth;
			//String basePath = "./";
			//for (int ctr =0;ctr<remainderOFDepth;ctr++) {
			//	basePath += "../";
			//}
			//scriptName = basePath + scriptName;
			scriptName = sb.toString();
			if (scriptName.endsWith("/")) scriptName = scriptName.substring(0, scriptName.length()-2);

			//one more loop just to capture the parts after the URL
			List<String> urlParts = new ArrayList<String>();
			boolean startCapturing = false;
			for (String aPart:parts) {
				if (startCapturing) {
					urlParts.add(aPart);
				}
				if (aPart.endsWith(".html")) {
					startCapturing = true;
				}

			}
			if (urlParts != null && urlParts.size() > 0) {
				String[] strParts = urlParts.toArray(new String[urlParts.size()]);
				ITRTab itrTab = ITRTab.getByAka(strParts);
				request.setAttribute("urlParts", urlParts);
				if (itrTab != null) request.setAttribute("selectedItrTab", itrTab);
			}
		}
		if (selectedItrTabAttr == null && selectedItrTabParam != null) {
			ITRTab itrTab = null;
			try {
				itrTab= ITRTab.valueOf(selectedItrTabParam);
				request.setAttribute("selectedItrTab", itrTab);
			}catch (IllegalArgumentException ie) {

			}
		}
		return scriptName;
		//Old Code
		/*
		if (request.getAttribute("selectedItrTab") == null && getPublicRequestParameter(request, "selectedItrTab") != null) {
			ITRTab itrTab = null;
			try {
				itrTab= ITRTab.valueOf(getPublicRequestParameter(request, "selectedItrTab"));
				request.setAttribute("selectedItrTab", itrTab);
			}catch (IllegalArgumentException ie) {

			}
		}
		*/
	}
	

	/*
	 * The ultimate goal here is to save the parent bean and if it didn't exist then it should have been created in the first place
	 * a child cannot exist without a parent
	 */
	public void save(HstRequest request,FormMap formMap,PAGE_ACTION pageAction, String baseAbsolutePathToReturnDocuments, String parentBeanAbsolutePath, String parentBeanNameSpace,String parentBeanNodeName, String uuid, HippoBean parentBean, HippoBean childBean,Session persistableSession,WorkflowPersistenceManager wpm) {
		//what are we supposed to do??
		if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && childBean != null) {
			//we are updating a child node here
		}
		else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && childBean != null) {
			//we are deleting a child node here
		}
		else if (pageAction.equals(PAGE_ACTION.NEW_CHILD)){
			//this is fun, now we should ensure that parentBeanExists and if not create it
			//also a new childNode will be added to this parentBean
		}
		try {
			if (pageAction.equals(PAGE_ACTION.EDIT_CHILD) && childBean != null) {
				try {
					//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
					HippoBean childBeanInSession = (HippoBean) wpm.getObjectByUuid(uuid);
					HippoBean parentBeanInSession = childBeanInSession.getParentBean();
					//now set the value we received from the form submission
					if (childBeanInSession instanceof FormMapFiller) {
						FormMapFiller formMapFiller = (FormMapFiller) childBeanInSession;
						formMapFiller.fill(formMap);
					}
					if (parentBeanInSession instanceof CompoundChildUpdate) {
						CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
						compoundChildUpdate.update(childBeanInSession);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBean != null && childBean != null) {
						try {
							//if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);
						} catch (ObjectBeanPersistenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.error("Error in Save",e);
						}
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
			else if (pageAction.equals(PAGE_ACTION.NEW_CHILD)) {
				try {
					//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
					HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
					if (parentBeanInSession == null) {
						//gotta create this damn thing
						if (log.isInfoEnabled()) {
							log.info("Parent Bean is missing, we will need to recreate it");
						}
						//final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
						final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,parentBeanNameSpace,parentBeanNodeName, true);
						parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
					}
					//now set the value we received from the form submission
					ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
					//HippoBean newChildBeanInstance = null;
					try {
						childBean = childBeanLocal.childBeanClass().newInstance();
						if (childBean instanceof FormMapFiller) {
							FormMapFiller formMapFiller = (FormMapFiller) childBean;
							formMapFiller.fill(formMap);
						}
						if (parentBeanInSession instanceof CompoundChildUpdate) {
							CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
							compoundChildUpdate.add(childBean);
						}
						wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
						if (parentBeanInSession != null) {
							try {
								//if (!beforeSave(request)) return; // don't save if this method returns false
								wpm.update(parentBeanInSession);
							} catch (ObjectBeanPersistenceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								log.error("Error in Save",e);
							}
						}
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
			else if (pageAction.equals(PAGE_ACTION.DELETE_CHILD) && childBean != null) {
				try {
					HippoBean childBeanInSession = (HippoBean) wpm.getObjectByUuid(uuid);
					HippoBean parentBeanInSession = childBeanInSession.getParentBean();
					if (parentBeanInSession instanceof CompoundChildUpdate) {
						CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
						compoundChildUpdate.delete(childBeanInSession);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBeanInSession != null && childBean != null) {
						try {
							//if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);
						} catch (ObjectBeanPersistenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.error("Error in Save",e);
						}
					}

				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
			else if (pageAction.equals(PAGE_ACTION.EDIT)) {
				try {
					//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
					HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
					if (parentBeanInSession == null) {
						//gotta create this damn thing
						if (log.isInfoEnabled()) {
							log.info("Parent Bean is missing, we will need to recreate it");
						}
						final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,parentBeanNameSpace,parentBeanNodeName, true);
						parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
					}
					//now set the value we received from the form submission
					if (parentBeanInSession instanceof FormMapFiller) {
						FormMapFiller formMapFiller = (FormMapFiller) parentBeanInSession;
						formMapFiller.fill(formMap);
					}
					wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
					if (parentBeanInSession != null) {
						try {
							//if (!beforeSave(request)) return; // don't save if this method returns false
							wpm.update(parentBeanInSession);
						} catch (ObjectBeanPersistenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.error("Error in Save",e);
						}
					}
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					log.error("Error saving document",e);
					e.printStackTrace();
				}
			}
		}
		finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}
	
	/**
	 * Action to Save Add New Child
	 * @param request
	 * @param formMap
	 * @param baseAbsolutePathToReturnDocuments
	 * @param parentBeanAbsolutePath
	 * @param parentBeanNameSpace
	 * @param parentBeanNodeName
	 * @param childBeanClass
	 * @param persistableSession
	 * @param wpm
	 */
	public void saveAddNewChild (FormMap childBeanMap,FormMap parentBeanMap, String baseAbsolutePathToReturnDocuments, String parentBeanAbsolutePath, String parentBeanNameSpace,String parentBeanNodeName,  Class<? extends HippoBean> childBeanClass,Session persistableSession,WorkflowPersistenceManager wpm) {
		try {
			//Object parentBeanInSession = wpm.getObject(parentBean.getCanonicalUUID());
			HippoBean parentBeanInSession = (HippoBean) wpm.getObject(parentBeanAbsolutePath);
			if (parentBeanInSession == null) {
				//gotta create this damn thing
				if (log.isInfoEnabled()) {
					log.info("Parent Bean is missing, we will need to recreate it");
				}
				//final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,getParentBeanNameSpace(),getParentBeanNodeName(), true);
				final String pathToParentBean = wpm.createAndReturn(baseAbsolutePathToReturnDocuments,parentBeanNameSpace,parentBeanNodeName, true);
				parentBeanInSession = (HippoBean) wpm .getObject(pathToParentBean);
				if (parentBeanInSession instanceof FormMapFiller && parentBeanMap != null){
					FormMapFiller formMapFiller = (FormMapFiller) parentBeanInSession;
					formMapFiller.fill(parentBeanMap);
				}
			}
			//now set the value we received from the form submission
			//ChildBean childBeanLocal = getClass().getAnnotation(ChildBean.class);
			//HippoBean newChildBeanInstance = null;
			try {
				HippoBean childBean = childBeanClass.newInstance();
				if (childBean instanceof FormMapFiller) {
					FormMapFiller formMapFiller = (FormMapFiller) childBean;
					formMapFiller.fill(childBeanMap);
				}
				if (parentBeanInSession instanceof CompoundChildUpdate) {
					CompoundChildUpdate compoundChildUpdate = (CompoundChildUpdate) parentBeanInSession;
					compoundChildUpdate.add(childBean);
				}
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				if (parentBeanInSession != null) {
					try {
						//if (!beforeSave(request)) return; // don't save if this method returns false
						wpm.update(parentBeanInSession);
					} catch (ObjectBeanPersistenceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Error in Save",e);
					}
				}
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error saving document",e);
			e.printStackTrace();
		}
	}

}
