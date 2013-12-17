package com.mootly.wcm.services;

import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;

import org.hippoecm.hst.site.HstServices;
import org.onehippo.forge.security.support.springsecurity.authentication.HippoUserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceGeneratorImpl implements SequenceGenerator {
	static final Logger log = LoggerFactory.getLogger(HippoUserDetailsServiceImpl.class);
	private Repository systemRepository;

	private Credentials systemCreds;

	/**
	 * 
	 */
	public SequenceGeneratorImpl() {

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
	public synchronized Long getNextId(String sequenceName) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			if (getSystemCredentials() != null) {
				session = getSystemRepository().login(getSystemCredentials());
			} else {
				session = getSystemRepository().login();
			}
			///content/documents/mootlywcm/sequences/folderSequence
			///content/documents/mootlywcm/sequences/folderSequence
			String queryForSequenceNode = "/content/documents/mootlywcm/sequences/" + sequenceName;
			Node sequenceNode = session.getNode(queryForSequenceNode);
			//Query q = session.getWorkspace().getQueryManager().createQuery(queryForSequenceNode,Query.XPATH);
			//QueryResult result = q.execute();
			//NodeIterator nodeIt = result.getNodes();
			//Node sequenceNode = (nodeIt.hasNext() ? sequenceNode = nodeIt.nextNode() : null);
			Property property = sequenceNode.getProperty("mootlywcm:nextId");
			long nextId  = property.getLong() + 1;
			
			sequenceNode.setProperty("mootlywcm:nextId", nextId  );
			session.save();
			return nextId;
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
		return Long.valueOf(0L);
	}

}
