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
package com.mootly.wcm.jaxrs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.xml.bind.annotation.XmlRootElement;

import org.hippoecm.hst.core.request.HstRequestContext;

import com.mootly.wcm.beans.HippoLogItem;

/**
 * @version $Id: ProductLinkRepresentation.java 26695 2011-01-27 12:00:31Z  $
 *  * [hippolog:item] > nt:base
  - hippolog:eventUser (string) mandatory
  - hippolog:eventClass (string) mandatory
  - hippolog:eventReturnValue (string)
  - hippolog:eventReturnType (string)
  - hippolog:eventDocument (string)
  - hippolog:eventArguments (string) multiple
  - hippolog:eventMethod (string) mandatory
  - hippolog:timestamp (long) mandatory
 */
@XmlRootElement(name = "hippologitem")
public class HippoLogItemRepresentation extends BaseDocumentRepresentation {

    private String eventUser;
    private String eventClass;
    private String eventReturnValue;
    private String eventReturnType;
    private String eventDocument;
    private String eventMethod;
    private String timestamp;
    private List<String> eventArguments;
    
    private Map<String,String> properties = new HashMap<String,String>();
    

    protected HstRequestContext requestContext;

    public HippoLogItemRepresentation() {}
    
    public HippoLogItemRepresentation(HstRequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public HippoLogItemRepresentation represent(HippoLogItem bean) throws RepositoryException {
        super.represent(bean);
        
        /*
        this.productLink = this.requestContext.getHstLinkCreator().create(bean.getNode(), this.requestContext,
                "restapi").toUrlForm(this.requestContext, true);

        this.price = bean.getPrice();
        this.rating = bean.getRating();
        this.smallThumbnail = buildImageLinkUrl(bean, "mootlywcmgallery:smallthumbnail");
			*/
        this.eventUser = bean.getEventUser();
        return this;
    }

	public String getEventUser() {
		return eventUser;
	}

	public void setEventUser(String eventUser) {
		this.eventUser = eventUser;
	}

	public String getEventClass() {
		return eventClass;
	}

	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}
	
	
	public String getEventReturnValue() {
		return eventReturnValue;
	}

	public void setEventReturnValue(String eventReturnValue) {
		this.eventReturnValue = eventReturnValue;
	}

	public String getEventReturnType() {
		return eventReturnType;
	}

	public void setEventReturnType(String eventReturnType) {
		this.eventReturnType = eventReturnType;
	}

	public String getEventDocument() {
		return eventDocument;
	}

	public void setEventDocument(String eventDocument) {
		this.eventDocument = eventDocument;
	}

	public String getEventMethod() {
		return eventMethod;
	}

	public void setEventMethod(String eventMethod) {
		this.eventMethod = eventMethod;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public List<String> getEventArguments() {
		return eventArguments;
	}

	public void setEventArguments(List<String> eventArguments) {
		this.eventArguments = eventArguments;
	}
}
