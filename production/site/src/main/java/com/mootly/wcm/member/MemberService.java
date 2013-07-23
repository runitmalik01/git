package com.mootly.wcm.member;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;

import org.hippoecm.hst.core.component.HstRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class MemberService {

	private final static Logger log = LoggerFactory.getLogger(MemberService.class);
	private final static String SELECT_EMAIL_QUERY = "SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:email='hurray'";    
	private final static String SELECT_PASSWORD_QUERY = "SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:password='{}'";   
	private final static String SELECT_USER_QUERY = "SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:userName='{}'";
	private final static String SELECT_USER_ACTIVATION="SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:activationCode='{}'";
	private final static String SELECT_USER_LOGIN="SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:userName='{}' AND mootlywcm:password='[]'";
	private final static String UPDATE_USER_ACTIVATION="UPDATE mootlywcm:membersignupdocument SET mootlywcm:isActive='true' WHERE mootlywcm:activationCode='{}'";

	public static Member getMember(HstRequest request, String userName){
		Session session = null;
		Member member = null;
		try {
			session = request.getRequestContext().getSession();
			Node userNode = getUserNode(session, request,userName);
			if (userNode != null) {
				member = new Member(userNode);
				return member;
			}
			return null;
		}
		catch (RepositoryException e) {
			log.error("Failed to retrieve user from repository", e);
		}
		finally {
			if (session != null) {
				session.logout();
			}
		}
		return null;
	}
	public static Member getCurrentPass(HstRequest request, String Old_Password){
		Session session = null;
		Member member = null;
		try {
			session = request.getRequestContext().getSession();
			Node userNode = getUserNodePass(session, request,Old_Password);
			if (userNode != null) {
				member = new Member(userNode);
				return member;
			}
			return null;
		}
		catch (RepositoryException e) {
			log.error("Failed to retrieve password from repository", e);
		}
		finally {
			if (session != null) {
				session.logout();
			}
		}
		return null;
	}

	public static Member getForgotPass(HstRequest request,String email){
		Session session = null;
		Member member = null;
		try{
			session=request.getRequestContext().getSession();
			Node emailNode=getEmailNode(session, request,email);
			if (emailNode != null) {
				member = new Member(emailNode);
				return member;
			}
			return null;
		}
		catch (RepositoryException e) {
			log.error("Failed to retrieve email from repository", e);
		}
		finally {
			if (session != null) {
				session.logout();
			}
		}
		return null;
	}
	// here we are for getting member for that activation code
	public static Member getActiveCode(HstRequest request,String email){
		Session session = null;
		Member member = null;
		try{
			session=request.getRequestContext().getSession();
			Node emailNode=getEmailNode(session, request,email);
			if (emailNode != null) {
				member = new Member(emailNode);
				return member;
			}
			return null;
		}
		catch (RepositoryException e) {
			log.error("Failed to retrieve email from repository", e);
		}
		finally {
			if (session != null) {
				session.logout();
			}
		}
		return null;
	}
	public static Member getActive(HstRequest request,String activationCode){
		Session session = null;
		Member member=null;
		try{
			session=request.getRequestContext().getSession();
			Node userNode=getUserInactive(session,request,activationCode);
			if(userNode !=null){
				member=new Member(userNode);
				return member;
			}
		}
		catch(RepositoryException e){
			log.error("Failed to retrieve user from repository for inactive",e);
		}
		finally {
			if (session != null) {
				session.logout();
			}
		}
		return null;
	}
	public static String getLogin(HstRequest request,String userName,String password){
		Session session=null;
		@SuppressWarnings("unused")
		Member member=null;
		String login="login";
		String notlogin="notlogin";
		try{
			session=request.getRequestContext().getSession();
			Node userNode=getUserNode(session,request,userName);
			if(userNode !=null){
				if(userNode.hasProperty("mootlywcm:password")){
					String pass =(String) userNode.getProperty("mootlywcm:password").getString();
					if(pass.equals(password)){
						return login;
					}
				}
				else 
					return notlogin;
			}

		}
		catch(RepositoryException e){
			log.error("Failed to retrieve user from repository for inactive",e);
		}
		finally {
			if (session != null) {
				session.logout();
			}
		}
		return null;
	}
	public static Node getUserInactive(Session session, HstRequest request,String activationCode) throws RepositoryException {
		String selectUserStatement = SELECT_USER_ACTIVATION.replace("{}",activationCode);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}
	public static Node getUserNode(Session session,HstRequest request,String userName,String password) throws RepositoryException{
		String selectUserStatement = SELECT_USER_LOGIN.replaceFirst("{}", userName);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement.replace("[]",password), Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;       
	}
	public static Node getUserNode(Session session, HstRequest request) throws RepositoryException {
		String selectUserStatement = SELECT_USER_QUERY.replace("{}", request.getUserPrincipal().getName());
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}
	public static Node getUserNode(Session session, HstRequest request,String username) throws RepositoryException {
		String selectUserStatement = SELECT_USER_QUERY.replace("{}",username);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}
	public static void setUserActive(Session session,String activatonCode) throws RepositoryException{
		String updateUserStatement= UPDATE_USER_ACTIVATION.replace("{}", activatonCode);
		@SuppressWarnings("deprecation")
		Query updateUserQuery=session.getWorkspace().getQueryManager().createQuery(updateUserStatement, Query.SQL);
		updateUserQuery.execute();
	}
	public static Node getEmailNode(Session session,HstRequest request,String email) throws RepositoryException{
		String selectUserStatement = SELECT_EMAIL_QUERY.replaceFirst("hurray", email);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;       
	}

	public static Node getUserNodePass(Session session, HstRequest request,String Old_Password) throws RepositoryException {
		String selectUserStatement = SELECT_PASSWORD_QUERY.replace("{}", Old_Password);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}
}