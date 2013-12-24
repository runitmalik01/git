/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans;

import static com.mootly.wcm.utils.Constants.PROP_DESCRIPTION;

import javax.jcr.ItemExistsException;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

import com.mootly.wcm.annotations.AutoCreateFormField;
import com.mootly.wcm.beans.compound.Copyright;
import com.mootly.wcm.components.cms.view.AbstractFormField.FORM_FILED_TYPE;
import com.mootly.wcm.utils.Constants;

@Node(jcrType = "mootlywcm:document")
public class Document extends BaseDocument implements ContentNodeBinder {

	
    private String title;
    private String summary;
    private HippoHtml description;
    private String descriptionContent;


    @AutoCreateFormField(fieldType=FORM_FILED_TYPE.TEXT,name="title",label="Title",valueListName="",title="",placeHolder="",isMultiple=false)
    public String getTitle() {
        return (title == null) ? (String) getProperty("mootlywcm:title") : title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    @AutoCreateFormField(fieldType=FORM_FILED_TYPE.TEXT,name="summary",label="Summary",valueListName="",title="",placeHolder="",isMultiple=false)
    public String getSummary() {
        return (summary == null) ? (String) getProperty("mootlywcm:summary") : summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    @AutoCreateFormField(fieldType=FORM_FILED_TYPE.TEXT_ARERA,name="description",label="Description",valueListName="",title="",placeHolder="",isMultiple=false)
    public HippoHtml getDescription() {
        if(description==null){
            description =  getBean(PROP_DESCRIPTION);
        }
        return description;
    }

    public void setDescriptionContent(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }
    
    public String getDescriptionContent() {
        if (descriptionContent == null) {
            if (getDescription() != null) {
                descriptionContent = getDescription().getContent();
            }
        }
        return descriptionContent;
    }

    public Copyright getCopyright() {
        return getBean(Constants.PROP_COPYRIGHT);
    }

    public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
        try {
            Document bean = (Document) content;
            node.setProperty("mootlywcm:title", bean.getTitle());
            node.setProperty("mootlywcm:summary", bean.getSummary());
            
            if (getDescriptionContent() != null) {
                if (node.hasNode(PROP_DESCRIPTION)) {
                    javax.jcr.Node htmlNode = node.getNode(PROP_DESCRIPTION);
                    if (!htmlNode.isNodeType("hippostd:html")) {
                        throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
                    }
                    htmlNode.setProperty("hippostd:content", getDescriptionContent());
                } else {
                    javax.jcr.Node html = node.addNode(PROP_DESCRIPTION, "hippostd:html");
                    html.setProperty("hippostd:content", html);
                }
            }
        } catch (PathNotFoundException e) {
            log.error("Error binding object, Ppath not found", e);
        } catch (ItemExistsException e) {
            log.error("Error binding object, item doesn't exist", e);
        } catch (NoSuchNodeTypeException e) {
            log.error("Error binding object, Node not found", e);
        } catch (ValueFormatException e) {
            log.error("Error binding object, formatting exception", e);
        } catch (VersionException e) {
            log.error("Error binding object, version exc", e);
        } catch (ConstraintViolationException e) {
            log.error("Error binding object", e);
        } catch (LockException e) {
            log.error("Error binding object, locking exception", e);
        } catch (RepositoryException e) {
            log.error("Error binding object", e);
        }
        return true;
    }
}
