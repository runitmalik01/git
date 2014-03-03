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
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFormatException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
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
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryManager;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.hippoecm.hst.jaxrs.services.AbstractResource;
import org.hippoecm.hst.util.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.HippoLogItem;
import com.mootly.wcm.beans.Product;
import com.mootly.wcm.jaxrs.model.HippoLogItemRepresentation;
import com.mootly.wcm.jaxrs.model.ProductLinkRepresentation;

/**
 * @version $Id$
 */
@Path("/topproducts/")
public class TopProductsResource extends AbstractResource {
    
    private static Logger log = LoggerFactory.getLogger(TopProductsResource.class);
    
    @GET
    @Path("/")
    public List<HippoLogItemRepresentation> getProductResources(@Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse, @Context UriInfo uriInfo,
            @QueryParam("sortby") @DefaultValue("mootlywcm:rating") String sortBy, 
            @QueryParam("sortdir") @DefaultValue("descending") String sortDirection,
            @QueryParam("max") @DefaultValue("10") String maxParam) {
        
        List<HippoLogItemRepresentation> productRepList = new ArrayList<HippoLogItemRepresentation>();
        HstRequestContext requestContext = getRequestContext(servletRequest);
        
        try {
            String mountContentPath = requestContext.getResolvedMount().getMount().getContentPath();
            Node mountContentNode = requestContext.getSession().getRootNode().getNode("hippo:log");//.getNode(PathUtils.normalizePath(mountContentPath));
            HstQueryManager manager = getHstQueryManager(requestContext.getSession(), requestContext);
            
            HstQuery hstQuery = manager.createQuery(mountContentNode, "hippolog:item");
            String QUERY = "//element(*,hippolog:item)";
            String LANGUAGE = Query.XPATH;
            QueryManager queryManager = requestContext.getSession().getWorkspace().getQueryManager();
            Query query = queryManager.createQuery(QUERY, LANGUAGE);
            QueryResult queryResult = query.execute();
            NodeIterator nodeIterator = queryResult.getNodes();
			
			while ( nodeIterator.hasNext() ) {
			    javax.jcr.Node node = nodeIterator.nextNode();
			    System.out.println(node.getIdentifier());
			    
			    HippoLogItemRepresentation productRep = new HippoLogItemRepresentation(requestContext);
			    
			    productRep.setEventUser( getPropertyValue(node, "hippolog:eventUser") );
			    productRep.setEventClass(getPropertyValue(node, "hippolog:eventClass") );
			    productRep.setEventReturnValue( getPropertyValue(node, "hippolog:eventReturnValue") );
			    productRep.setEventReturnType( getPropertyValue(node, "hippolog:eventReturnType") );
			    productRep.setEventDocument( getPropertyValue(node, "hippolog:eventDocument") );
			    productRep.setEventMethod( getPropertyValue(node, "hippolog:eventMethod") );
			    productRep.setTimestamp( getPropertyValue(node, "hippolog:timestamp") );
			    
			    
			    if ( node.hasProperty("hippolog:eventArguments") ) {
			    	Property property = node.getProperty("hippolog:eventArguments");
			    	List<String> vals = new ArrayList<String>();
			    	if (property.isMultiple()) {
			    		for ( Value aValue: property.getValues() ) {
			    			vals.add( aValue.getString() );
			    		}
			    	}else {
			    		vals.add (property.getString());
			    	}
			    	productRep.setEventArguments(vals);
			    }
			    
			    productRepList.add(productRep);
			    
			}
			
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.warn("Failed to retrieve top products.", e);
            } else {
                log.warn("Failed to retrieve top products. {}", e.toString());
            }
            
            throw new WebApplicationException(e);
        }
        
        return productRepList;
    }
    
    protected String getPropertyValue(Node node,String propertyName) throws ValueFormatException, IllegalStateException, PathNotFoundException, RepositoryException {
    	if (node != null && node.hasProperty(propertyName)) {
    		return node.getProperty(propertyName).getValue().getString();
    	}
    	return null;
    }

}
