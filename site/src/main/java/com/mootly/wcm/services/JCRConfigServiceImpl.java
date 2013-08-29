package com.mootly.wcm.services;

import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.site.HstServices;
import org.onehippo.forge.security.support.springsecurity.authentication.HippoUserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an environment based service
 * based on java argument -Dw4indiaenv 
 * @author admin
 *
 */
public class JCRConfigServiceImpl implements ConfigService{
	static final Logger log = LoggerFactory.getLogger(JCRConfigServiceImpl.class);
	private Repository systemRepository;

	private Credentials systemCreds;
	
	private String pathToDocument; 
	
	/**
	 * We will invoke this method using Spring Services, this should setup the proper configuration and load all into a map
	 */
	public void init() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			if (getSystemCredentials() != null) {
				session = getSystemRepository().login(getSystemCredentials());
			} else {
				session = getSystemRepository().login();
			}
			String w4indiaenv = System.getProperty("w4indiaenv");
			if (w4indiaenv == null) w4indiaenv = "default";
			///content/documents/mootlywcm/sequences/folderSequence
			///content/documents/mootlywcm/sequences/folderSequence
			String queryForSequenceNode = "/content/documents/mootlywcm/sequences/" + w4indiaenv;
			Node sequenceNode = session.getNode(queryForSequenceNode);
			//Query q = session.getWorkspace().getQueryManager().createQuery(queryForSequenceNode,Query.XPATH);
			//QueryResult result = q.execute();
			//NodeIterator nodeIt = result.getNodes();
			//Node sequenceNode = (nodeIt.hasNext() ? sequenceNode = nodeIt.nextNode() : null);
			Property property = sequenceNode.getProperty("mootlywcm:nextId");
			long nextId  = property.getLong() + 1;
			
			
			session.save();
			//return nextId;
		} catch (RepositoryException e) {
			log.warn("Failed to load user.", e);
		} finally {
			if (session != null) {
				try {
					session.logout();
				} catch (Exception ignore) {
				}
			}
		} 
	}
	
	public String getPathToDocument() {
		return pathToDocument;
	}
	
	public void setPathToDocument(String pathToDocument) {
		this.pathToDocument = pathToDocument;
	}
	
	public void setSystemRepository(Repository systemRepository) {
		this.systemRepository = systemRepository;
	}

	public Repository getSystemRepository() {
		if (systemRepository == null) {
			systemRepository = HstServices.getComponentManager().getComponent(Repository.class.getName());
		}

		return systemRepository;
	}

	public void setSystemCredentials(Credentials systemCreds) {
		this.systemCreds = systemCreds;
	}

	public Credentials getSystemCredentials() {
		if (systemCreds == null) {
			systemCreds = HstServices.getComponentManager().getComponent(Credentials.class.getName() + ".writable");
		}

		return systemCreds;
	}
	@Override
	public String[] getArray(String propertyKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString(String propertyKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString(String propertyKey, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getBoolean(String propertyKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getBoolean(String propertyKey, Boolean defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getInteger(String propertyKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(String propertyKey, T propertyType) {
		// TODO Auto-generated method stub
		return null;
	}

}
