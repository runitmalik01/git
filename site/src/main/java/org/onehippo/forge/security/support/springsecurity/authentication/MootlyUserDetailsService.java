
package org.onehippo.forge.security.support.springsecurity.authentication;

import javax.jcr.ItemNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface MootlyUserDetailsService extends HippoUserDetailsService {
	UserDetails loadUserByUsernameAndPassword(String username, String password,String mountIdentifier) throws UsernameNotFoundException, DataAccessException;
	HippoMountDetail loadHippoMountDetail(Session session,String mountIdentifier) throws ItemNotFoundException, RepositoryException;
}
