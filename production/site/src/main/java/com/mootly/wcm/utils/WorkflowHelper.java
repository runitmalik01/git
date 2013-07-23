package com.mootly.wcm.utils;

import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.hippoecm.hst.site.HstServices;

public final class WorkflowHelper {
	
	public static Session getPersistableSession(HstRequest request) throws RepositoryException {
        HstRequestContext requestContext = request.getRequestContext();
        Credentials credentials = requestContext.getContextCredentialsProvider().getWritableCredentials(requestContext);
        return getPersistableSession(request, credentials);
    }
	
	/**
     * Creates a persistable JCR session with provided credentials.
     * <P>
     * <EM>Note: The client should invoke <CODE>logout()</CODE> method on the session after use.</EM>
     * </P>
     * <P>
     * Internally, {@link javax.jcr.Session#impersonate(Credentials)} method will be used to create a
     * persistable JCR session. The method is invoked on the session from the session pooling repository.
     * </P>
     * @param request
     * @return
     */
    protected static Session getPersistableSession(HstRequest request, Credentials credentials) throws RepositoryException {
        Repository repository = HstServices.getComponentManager().getComponent(Repository.class.getName());
        return repository.login(credentials);
    }
    
}
