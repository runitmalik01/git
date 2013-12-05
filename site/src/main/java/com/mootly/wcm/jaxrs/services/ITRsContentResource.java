/*
 *  Copyright 2010 Hippo.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mootly.wcm.jaxrs.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryManager;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.rewriter.ContentRewriter;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.hippoecm.hst.jaxrs.services.AbstractResource;
import org.hippoecm.hst.jaxrs.services.content.AbstractContentResource;
import org.hippoecm.hst.util.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.jaxrs.model.itr.ITRRepresentation;
import com.mootly.wcm.model.SORT_DIRECTION;


/**
 * @version $Id$
 */

@Path("/itrs/")
public class ITRsContentResource extends AbstractResource {


	private static Logger log = LoggerFactory.getLogger(ITRsContentResource.class);

	@GET
	@Path("/")
	public List<ITRRepresentation> getITRs(@Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse, @Context UriInfo uriInfo,
			@QueryParam("sortby") @DefaultValue("mootlywcm:rating") String sortBy, 
			@QueryParam("sortdir") @DefaultValue("descending") String sortDirection,
			@QueryParam("max") @DefaultValue("10") String maxParam) {

		List<ITRRepresentation> itrRepList = new ArrayList<ITRRepresentation>();
		HstRequestContext requestContext = getRequestContext(servletRequest);

		try {
			String mountContentPath = requestContext.getResolvedMount().getMount().getContentPath();
			Node mountContentNode = requestContext.getSession().getRootNode().getNode(PathUtils.normalizePath(mountContentPath));

			HstQueryManager manager = getHstQueryManager(requestContext.getSession(), requestContext);
			HstQuery hstQuery = manager.createQuery(mountContentNode, MemberPersonalInformation.class, true);
			
			//the resellers
			mountContentPath = mountContentPath + "/resellers/w4india/members/itreturns/2012-2013";

			if (!StringUtils.isBlank(sortBy)) {
				if (StringUtils.equals("descending", sortDirection)) {
					hstQuery.addOrderByDescending(sortBy);
				} else {
					hstQuery.addOrderByAscending(sortBy);
				}
			}

			hstQuery.setLimit(NumberUtils.toInt(maxParam, 10));

			HstQueryResult result = hstQuery.execute();
			HippoBeanIterator iterator = result.getHippoBeans();
			ContentRewriter<String> contentRewriter = getContentRewriter();

			while (iterator.hasNext()) {
				MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) iterator.nextHippoBean();
				if (memberPersonalInformation != null && memberPersonalInformation.getLastName() != null && !"".equals(memberPersonalInformation.getLastName().trim())) {
					List<HippoBean> listOfBeans = loadAllBeansUnderTheFolder(requestContext, memberPersonalInformation.getParentBean(), null, null);
					if (listOfBeans != null && listOfBeans.size() > 0 ) {
						try {
							memberPersonalInformation.getSex();
							ITRRepresentation productRep = new ITRRepresentation(memberPersonalInformation,requestContext,contentRewriter).represent(listOfBeans);
							itrRepList.add(productRep);
						}catch (Exception ex) {
							log.error("Error",ex);
						}
						
					}
				}
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.warn("Failed to retrieve top products.", e);
			} else {
				log.warn("Failed to retrieve top products. {}", e.toString());
			}

			throw new WebApplicationException(e);
		}

		return itrRepList;
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param pathToTheItReturn
	 * @throws ObjectBeanManagerException 
	 * @throws RepositoryException 
	 * @throws LoginException 
	 * @throws QueryException 
	 */
	protected List<HippoBean> loadAllBeansUnderTheFolder(final HstRequestContext requestContext,HippoBean scopeForAllBeans,String sortByAttribute,SORT_DIRECTION sortDirection) throws ObjectBeanManagerException, LoginException, RepositoryException, QueryException {
		//HippoBean theBean =  getMountContentBaseBean(requestContext);
		//WebsiteInfo webSiteInfo = requestContext.getResolvedMount().getMount().getChannelInfo();

		//if (theBean == null) {
		//	return null;
		//}
		//HippoBean scopeForAllBeans =  theBean.getBean(baseRelPathToReturnDocuments);
		HstQuery hstQuery;
		List<HippoBean> theLocalBeansUnderMemberFolder = null;
		if (scopeForAllBeans == null)  return null;
		theLocalBeansUnderMemberFolder = new ArrayList<HippoBean>();
		HstQueryManager manager = getHstQueryManager(requestContext.getSession(), requestContext);
		hstQuery = manager.createQuery( scopeForAllBeans );
		if (sortDirection == null) sortDirection = SORT_DIRECTION.ASC;
		if (sortByAttribute != null) {
			switch (sortDirection) {
			case ASC:
				hstQuery.addOrderByAscending(sortByAttribute);
				break;
			case DESC:
				hstQuery.addOrderByAscending(sortByAttribute);
				break;
			}
		}
		final HstQueryResult result = hstQuery.execute();
		Iterator<HippoBean> itResults = result.getHippoBeans();
		if (log.isInfoEnabled()) {
			log.info("Now will look into all HippoDocuments under the same folder and make a copy of each");
		}
		for (;itResults.hasNext();) {
			HippoBean hippoBean = itResults.next();
			if (hippoBean instanceof HippoDocumentBean) {
				theLocalBeansUnderMemberFolder.add(hippoBean);
				//request.setAttribute(hippoBean.getClass().getSimpleName().toLowerCase(), hippoBean);
				//if (hippoBean instanceof MemberPersonalInformation) {
				//memberPersonalInformation = (MemberPersonalInformation) hippoBean;
				//}
			}
		}
		return theLocalBeansUnderMemberFolder;
	}
}
