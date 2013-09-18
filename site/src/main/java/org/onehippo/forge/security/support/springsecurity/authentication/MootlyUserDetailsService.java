
package org.onehippo.forge.security.support.springsecurity.authentication;

import org.onehippo.forge.security.support.springsecurity.authentication.HippoUserDetailsService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface MootlyUserDetailsService extends HippoUserDetailsService {
	UserDetails loadUserByUsernameAndPassword(String username, String password,String mountIdentifier) throws UsernameNotFoundException, DataAccessException;
}