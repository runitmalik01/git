package com.mootly.wcm.utils;

import javax.jcr.ItemNotFoundException;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MootlyFormUtils extends FormUtils {
	 static Logger log = LoggerFactory.getLogger(FormUtils.class);
	/**
     * This method tries to repopulate an earlier posted form that was stored in the repository.
     *
     * Only when there is a request parameter containing the correct uuid, you can re-populate it.
     *
     * @param request the current hstRequest
     * @param formMap the formMap that will be populated
     */
    public static void populate(HstRequest request,String uuid, FormMap formMap) {
        if(formMap == null) {
            log.warn("FormMap is null so can not be populated");
            return;
        }
        if(uuid != null) {
            //String uuid = request.getParameter(DEFAULT_UUID_NAME);
            try {
                validateId(uuid);
                Session session = request.getRequestContext().getSession();
                Node persistedFormData = session.getNodeByIdentifier(uuid);
                // check if form is sealed
                if(persistedFormData.hasProperty(HST_SEALED) && persistedFormData.getProperty(HST_SEALED).getBoolean()){
                    log.debug("From is sealed, not allowed to read data");
                    formMap.setSealed(true);
                    return;
                }

                if(persistedFormData.hasProperty(HST_PREDECESSOR)) {
                    formMap.setPrevious(persistedFormData.getProperty(HST_PREDECESSOR).getString());
                }
                // fetch previously stored form field data (nodes)
                if(persistedFormData.hasNodes()){
                    NodeIterator fieldIterator = persistedFormData.getNodes(HST_FORM_DATA_NODE);
                    while (fieldIterator.hasNext()) {
                        Node fieldNode = fieldIterator.nextNode();
                        if (fieldNode == null) {
                            continue;
                        }

                        // sanity check (property is mandatory)
                        if(fieldNode.hasProperty(HST_FORM_FIELD_NAME)){
                            // create field (even if we do not have values)
                            String fieldName = fieldNode.getProperty(HST_FORM_FIELD_NAME).getString();
                            FormField field = new FormField(fieldName);
                            formMap.addFormField(field);
                            if(fieldNode.hasProperty(HST_FORM_FIELD_DATA)){
                                Value[] values = fieldNode.getProperty(HST_FORM_FIELD_DATA).getValues();
                                for (Value value : values) {
                                    field.addValue(value.getString());
                                }
                            }
                            if(fieldNode.hasProperty(HST_FORM_FIELD_MESSAGES)){
                                Value[] values = fieldNode.getProperty(HST_FORM_FIELD_MESSAGES).getValues();
                                for (Value value : values) {
                                    field.addMessage(value.getString());
                                }
                            }
                        }
                    }
                }

            } catch(IllegalArgumentException e){
                log.warn("Not a valid uuid. Return");
            } catch (LoginException e) {
                log.warn("LoginException '{}'. Return" , e.getMessage());
            } catch (ItemNotFoundException e) {
                log.warn("ItemNotFoundException '{}' while trying to retrieve persisted formdata. Return" , e.getMessage());
            } catch (RepositoryException e) {
                log.warn("RepositoryException '{}'. Return" , e.getMessage());
            }
        } else {
            log.debug("No uuid in request parameter. No form to populate");
        }
    }
}
