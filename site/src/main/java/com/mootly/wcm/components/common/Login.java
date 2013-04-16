package com.mootly.wcm.components.common;

import java.util.Collection;
import java.util.HashSet;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.member.MemberService;

public class Login extends BaseComponent {

    private final static Logger log = LoggerFactory.getLogger(Login.class);
    
    private final static String SELECT_USER_QUERY = "SELECT * FROM hipposys:user WHERE fn:name()='{}'";
    
    private final static String SELECT_GROUPS_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' AND hipposys:members='{}'";
    
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        Boolean loggedin = request.getUserPrincipal() != null;
        request.setAttribute("loggedin", loggedin);
        
        if (loggedin) {
            User user = (User) request.getSession().getAttribute("userw4india");
            if (user == null) {
                Session session = null;
                try {
                    session = request.getRequestContext().getSession();
                    Node userNode = getUserNode(session, request);
                    if (userNode != null) {
                        user = new User(userNode, getGroupNodes(session, request));
                        request.getSession().setAttribute("userw4india", user);
                        Member member=MemberService.getMember(request, request.getUserPrincipal().getName().toLowerCase());
                        if (member != null) {
                        	request.getSession().setAttribute("user", member);
                        }
                    }
                }
                catch (RepositoryException e) {
                    log.error("Failed to retrieve user from repository", e);
                }
                finally {
                    if (session != null) {
                        session.logout();
                    }
                }
            }
            if (user != null) {
                request.setAttribute("userw4india", user);
            }
        }
        
        Boolean login = getPublicRequestParameter(request, "login") != null && getPublicRequestParameter(request, "login").equals("true");
        request.setAttribute("login", login);
        
        Boolean error = getPublicRequestParameter(request, "error") != null && getPublicRequestParameter(request, "error").equals("true");
        request.setAttribute("error", error);

    }
    
    private static Node getUserNode(Session session, HstRequest request) throws RepositoryException {
    	try {
    		Node userNode = session.getNode("/hippo:configuration/hippo:users/" + request.getUserPrincipal().getName());
    		return userNode;
    	}catch (PathNotFoundException pne) {
    		log.warn("Error getting user node",pne);
    	}
        return null;
    }
    
    private static NodeIterator getGroupNodes(Session session, HstRequest request) throws RepositoryException {
        String selectGroupsStatement = SELECT_GROUPS_QUERY.replace("{}", request.getUserPrincipal().getName());
        @SuppressWarnings("deprecation")
        Query selectGroupsQuery = session.getWorkspace().getQueryManager().createQuery(selectGroupsStatement, Query.SQL);
        return selectGroupsQuery.execute().getNodes();
    }
    
    public static final class User {
        
        private String firstname = "";
        private String lastname = "";
        private Collection<String> groups;
        
        private User(Node userNode, NodeIterator groupNodes) throws RepositoryException {
            if (userNode.hasProperty("hipposys:firstname")) {
                firstname = userNode.getProperty("hipposys:firstname").getString();
            }
            if (userNode.hasProperty("hipposys:lastname")) {
                lastname = userNode.getProperty("hipposys:lastname").getString();
            }
            groups = new HashSet<String>();
            while (groupNodes.hasNext()) {
                groups.add(groupNodes.nextNode().getName());
            }
        }
        
        public String getFirstname() {
            return firstname;
        }
        
        public String getLastname() {
            return lastname;
        }
        
        public Collection<String> getGroups() {
            return groups;
        }
        
        public boolean isMember(String group) {
            return groups.contains(group);
        }
    }
}
