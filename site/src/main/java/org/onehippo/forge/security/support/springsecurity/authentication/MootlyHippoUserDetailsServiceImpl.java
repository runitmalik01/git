package org.onehippo.forge.security.support.springsecurity.authentication;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.jcr.Credentials;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;

import org.hippoecm.hst.site.HstServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mootly.wcm.services.SecureHashGeneration;
/**
 * https://forge.onehippo.org/svn/hst-springsec/hst-springsec/trunk/src/main/java/org/onehippo/forge/security/support/springsecurity/authentication/HippoUserDetailsServiceImpl.java
 * @author admin
 *
 */
public class MootlyHippoUserDetailsServiceImpl implements HippoUserDetailsService {
	 static final Logger log = LoggerFactory.getLogger(HippoUserDetailsServiceImpl.class);
	 private final static String SELECT_PASSWORD_QUERY = "SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:password='pwd'";
	  //private static final String DEFAULT_USER_QUERY = "//hippo:configuration/hippo:users/{0}";
	  private static final String DEFAULT_USER_QUERY = "//{0}/membersignupdocument/membersignupdocument";
	  
	  private static final String DEFAULT_VENDOR_USER_QUERY = "//element(*,mootlywcm:vendorsignupdocument)[@mootlywcm:members=''{0}'']";
	  
	  /*
	  private static final String DEFAULT_GROUPS_OF_USER_QUERY =
	      "//element(*, hipposys:group)[(@hipposys:members = ''{0}'' or @hipposys:members = ''*'') and @hipposys:securityprovider = ''internal'']";
	  */
	  private static final String DEFAULT_GROUPS_OF_USER_QUERY =
		      "//element(*, hipposys:group)[(@hipposys:members = ''{0}'' or @hipposys:members = ''*'') and @hipposys:securityprovider = ''internal'']";
	  
	  private static final String DEFAULT_ROLES_OF_USER_AND_GROUP_QUERY =
	      "//hippo:configuration/hippo:domains/{0}/element(*, hipposys:authrole)[ @hipposys:users = ''{1}'' {2}]";

	  private Repository systemRepository;

	  private Credentials systemCreds;

	  private String queryLanguage = Query.XPATH;

	  private String userQuery = DEFAULT_USER_QUERY;

	  private String groupsOfUserQuery = DEFAULT_GROUPS_OF_USER_QUERY;

	  private String roleDomainName = "everywhere";

	  private String rolesOfUserAndGroupQuery = DEFAULT_ROLES_OF_USER_AND_GROUP_QUERY;

	  private String defaultRoleName = "everybody";

	  private String rolePrefix = "ROLE_";
	  
	  private String PASS_PREFIX="$SHA-256$";

	  public MootlyHippoUserDetailsServiceImpl() {
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
	      systemCreds = HstServices.getComponentManager().getComponent(Credentials.class.getName() + ".hstconfigreader");
	    }

	    return systemCreds;
	  }

	  public void setQueryLanguage(String queryLanguage) {
	    this.queryLanguage = queryLanguage;
	  }

	  public String getQueryLanguage() {
	    return queryLanguage;
	  }

	  public String getUserQuery() {
	    return userQuery;
	  }

	  public void setUserQuery(String userQuery) {
	    this.userQuery = userQuery;
	  }

	  public void setGroupsOfUserQuery(String groupsOfUserQuery) {
	    this.groupsOfUserQuery = groupsOfUserQuery;
	  }

	  public String getGroupsOfUserQuery() {
	    return groupsOfUserQuery;
	  }

	  public void setRoleDomainName(String roleDomainName) {
	    this.roleDomainName = roleDomainName;
	  }

	  public String getRoleDomainName() {
	    return roleDomainName;
	  }

	  public void setRolesOfUserAndGroupQuery(String rolesOfUserAndGroupQuery) {
	    this.rolesOfUserAndGroupQuery = rolesOfUserAndGroupQuery;
	  }

	  public String getRolesOfUserAndGroupQuery() {
	    return rolesOfUserAndGroupQuery;
	  }

	  public void setDefaultRoleName(String defaultRoleName) {
	    this.defaultRoleName = defaultRoleName;
	  }

	  public String getDefaultRoleName() {
	    return defaultRoleName;
	  }

	  public String getRolePrefix() {
	    return rolePrefix;
	  }

	  public void setRolePrefix(String rolePrefix) {
	    this.rolePrefix = rolePrefix;
	  }

	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
	    return loadUserByUsernameAndPassword(username, null);
	  }

	  public UserDetails loadUserByUsernameAndPassword(String username, String password) throws UsernameNotFoundException, DataAccessException {
	    User user = null;
	    Session session = null;

	    try {
	      if (getSystemCredentials() != null) {
	        session = getSystemRepository().login(getSystemCredentials());
	      } else {
	        session = getSystemRepository().login();
	      }

	      String statement = MessageFormat.format(getUserQuery(), username.replaceAll("@", "-at-"));

	      if (log.isDebugEnabled()) {
	        log.debug("Searching user with query: " + statement);
	      }

	      Query q = session.getWorkspace().getQueryManager().createQuery(statement, getQueryLanguage());
	      QueryResult result = q.execute();
	      NodeIterator nodeIt = result.getNodes();
	      Node userNode = (nodeIt.hasNext() ? userNode = nodeIt.nextNode() : null);
	      if (userNode == null) {
	    	  if (log.isInfoEnabled()) {
	    		  log.info("User node not found");	
	    	  }
	    	  throw new UsernameNotFoundException("user.not.found");
	      }
	      String passwordProp = null;
	      //changes by priyank
	      //check for both type of Password in SHA-256 or String 
	      if (userNode.hasProperty("mootlywcm:password")) {
		      passwordProp = userNode.getProperty("mootlywcm:password").getString();
		      if (!password.equals(passwordProp)) {
		    	  if(passwordProp.contains(PASS_PREFIX)){
		    		  String newPrefixSHA=SecureHashGeneration.passSHAdigest(password);
		    		  if(!newPrefixSHA.equalsIgnoreCase(passwordProp)){
		    			  throw new UsernameNotFoundException("password.mismatch");
		    		  }
		    	  }else{
		    		  throw new UsernameNotFoundException("password.mismatch");  
		    	  }
		      }
	      }
	      else {
	    	  throw new UsernameNotFoundException("password.mismatch");
	      }
	      
	      boolean enabled = false;
	      if (userNode.hasProperty("mootlywcm:isActive")) {
		      enabled = userNode.getProperty("mootlywcm:isActive").getBoolean();
		      if (!enabled) {
		    	  throw new UsernameNotFoundException("user.account.inactive");
		      }
	      }
	      else {
	    	  throw new UsernameNotFoundException("user.account.inactive");
	      }
	      

	      
	      boolean isVendor = false;
	      try {
		      Node theParentHardDoc = userNode.getParent();
		      //find if there is a vendor signup for this uuid
		      String parentHardDocUUID = theParentHardDoc.getIdentifier();
		      String statementForVendor = MessageFormat.format(DEFAULT_VENDOR_USER_QUERY, parentHardDocUUID);
		      Query qVendor = session.getWorkspace().getQueryManager().createQuery(statementForVendor, getQueryLanguage());
		      QueryResult resultVendor = qVendor.execute();
		      NodeIterator nodeItVendor = resultVendor.getNodes();
		      Node vendorNode = (nodeItVendor.hasNext() ? vendorNode = nodeItVendor.nextNode() : null);
		      if (vendorNode != null) {
		    	  isVendor = true;
		      }
	      }catch (Exception ex) {
	    	  ex.printStackTrace();
	      }
	      
	      boolean accountNonExpired = true;
	      boolean credentialsNonExpired = true;
	      boolean accountNonLocked = true;
	      Collection<? extends GrantedAuthority> authorities = getGrantedAuthoritiesOfUser(username,isVendor);

	      user = new User(username, password != null ? password : passwordProp, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
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

	    return user;
	  }

	  protected Collection<? extends GrantedAuthority> getGrantedAuthoritiesOfUser(String username,boolean isVendor) throws LoginException, RepositoryException {
	    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	    Session session = null;
	    //Amit Patkar for now lets give member and everybody to all logged in users
	    //lets check if this user 	    
	    authorities.add(new GrantedAuthorityImpl("ROLE_everybody"));
	    authorities.add(new GrantedAuthorityImpl("ROLE_member"));
	    if (isVendor)authorities.add(new GrantedAuthorityImpl("ROLE_vendor")); 
	    /*
	    try {
	      if (getSystemCredentials() != null) {
	        session = getSystemRepository().login(getSystemCredentials());
	      } else {
	        session = getSystemRepository().login();
	      }

	      String statement = MessageFormat.format(getGroupsOfUserQuery(), username);

	      if (log.isDebugEnabled()) {
	        log.debug("Searching groups of user with query: " + statement);
	      }

	      Query q = session.getWorkspace().getQueryManager().createQuery(statement, getQueryLanguage());
	      QueryResult result = q.execute();
	      NodeIterator nodeIt = result.getNodes();

	      StringBuilder groupsConstraintsBuilder = new StringBuilder(100);

	      while (nodeIt.hasNext()) {
	        String groupName = nodeIt.nextNode().getName();
	        groupsConstraintsBuilder.append("or @hipposys:groups = '").append(groupName).append("' ");
	      }

	      statement = MessageFormat.format(getRolesOfUserAndGroupQuery(), getRoleDomainName(), username, groupsConstraintsBuilder.toString());

	      q = session.getWorkspace().getQueryManager().createQuery(statement, getQueryLanguage());
	      result = q.execute();
	      nodeIt = result.getNodes();

	      boolean defaultRoleAdded = false;

	      while (nodeIt.hasNext()) {
	        String roleName = nodeIt.nextNode().getProperty("hipposys:role").getString();
	        String prefixedRoleName = (rolePrefix != null ? rolePrefix + roleName : roleName);
	        authorities.add(new GrantedAuthorityImpl(prefixedRoleName));

	        if (defaultRoleName != null && !defaultRoleAdded && roleName.equals(defaultRoleName)) {
	          defaultRoleAdded = true;
	        }
	      }

	      if (defaultRoleName != null && !defaultRoleAdded) {
	        String prefixedRoleName = (rolePrefix != null ? rolePrefix + defaultRoleName : defaultRoleName);
	        authorities.add(new GrantedAuthorityImpl(prefixedRoleName));
	      }
	    } finally {
	      if (session != null) {
	        try {
	          session.logout();
	        } catch (Exception ignore) {
	        }
	      }
	    }
	    */
	    return authorities;
	  }
	  
	  public static Node getUserNodePass(Session session,String mpassword) throws RepositoryException {
			String selectUserStatement = SELECT_PASSWORD_QUERY.replace("pwd", mpassword);
			@SuppressWarnings("deprecation")
			Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
			NodeIterator usersIterator = selectUserQuery.execute().getNodes();
			if (usersIterator.hasNext()) {
				return usersIterator.nextNode();
			}
			return null;
		}
}
