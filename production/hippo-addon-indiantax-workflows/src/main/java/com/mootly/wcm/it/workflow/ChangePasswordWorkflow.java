/*
 *  Copyright 2011 Hippo.
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
package com.mootly.wcm.it.workflow;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.hippoecm.repository.standardworkflow.WorkflowEventWorkflow;

@PersistenceCapable
public class ChangePasswordWorkflow extends WorkflowImpl implements WorkflowEventWorkflow {
	//private final Logger log = LoggerFactory.getLogger(ChangePasswordWorkflow.class);

	private final static String SELECT_USER_QUERY = "SELECT * FROM hipposys:user WHERE fn:name()='{}'";
	private final static String SELECT_MEMBERSIGNDOC_QUERY = "SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:userName='{}'";
	private final static String SELECT_GROUPS_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' AND hipposys:members='{}'";

	private final static String SELECT_USER_FOR_GROUP_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' and fn:name()= '{groupname}' AND hipposys:members='{}'";

	private final static String SELECT_GROUP_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' AND fn:name='{}'";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final static String SVN_ID = "$Id: WorkflowEventsWorkflowImpl.java 29256 2011-08-01 14:36:36Z bvanhalderen $";


	@Persistent(column="mootlywcm:Old_Password")
	String OldPassword;
	@Persistent(column="mootlywcm:New_Password")
	String NewPassword;
	@Persistent(column="mootlywcm:UserName")
	String userName;
	public ChangePasswordWorkflow() throws RemoteException {
	}

	public void fire() throws WorkflowException, MappingException {


		System.out.print("NEW PASSWARD IS AFTER CHANGING "+NewPassword);
		try{
			//for flag
			Node userNode = getUserNode(getWorkflowContext().getInternalWorkflowSession(),userName);

			if (userNode != null) {
				userNode.setProperty("hipposys:password", NewPassword);
			} else{
				System.out.println("else loop when user node is null...");
			}
		}
		catch(Exception e){
			System.out.println("this is an error from change workflow");        		
		}
	}

	public void fire(Document document) throws WorkflowException, MappingException {
	}

	public void fire(Iterator<Document> documentIterator) throws WorkflowException, MappingException {
		while(documentIterator.hasNext()) {
			Document document = documentIterator.next();
			System.err.println("documents "+document.getIdentity()+" has published");
		}
	}
	private static Node getUserNode(Session session,String userName) throws RepositoryException {
		try {
			Node node = session.getNode("/hippo:configuration/hippo:users/" + userName);
			return node;
		}catch (PathNotFoundException pne) {
			pne.printStackTrace();
		}
		return null;
	}
	
	public static Node getUserNodePass(Session session,String username) throws RepositoryException {
		String selectUserStatement = SELECT_MEMBERSIGNDOC_QUERY.replace("{}", username);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}

	private static Node getGroupByUserName(Session session,String groupName,String userName) throws RepositoryException {
		String selectUserStatement = SELECT_USER_FOR_GROUP_QUERY.replace("{}", userName);
		selectUserStatement = SELECT_USER_FOR_GROUP_QUERY.replace("{groupname}", groupName);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}

	@SuppressWarnings("unused")
	private static NodeIterator getGroupNodes(Session session,String userName) throws RepositoryException {
		String selectGroupsStatement = SELECT_GROUPS_QUERY.replace("{}", userName);
		@SuppressWarnings("deprecation")
		Query selectGroupsQuery = session.getWorkspace().getQueryManager().createQuery(selectGroupsStatement, Query.SQL);
		return selectGroupsQuery.execute().getNodes();
	}

	@SuppressWarnings("unused")
	private static List<Node> getDefaultGroupNodes(Session session,String[] defaultGroups) throws RepositoryException {
		List<Node> defaultGroupNodes = new ArrayList<Node>();
		for (String defaultGroup:defaultGroups) {
			String selectGroupStatement = SELECT_GROUP_QUERY.replace("{}", defaultGroup);
			@SuppressWarnings("deprecation")
			Query selectGroupQuery = session.getWorkspace().getQueryManager().createQuery(selectGroupStatement, Query.SQL);
			NodeIterator groupIterator = selectGroupQuery.execute().getNodes();
			if (groupIterator.hasNext()) {
				defaultGroupNodes.add( groupIterator.nextNode() );
			}
		}
		return defaultGroupNodes;
	}
}
