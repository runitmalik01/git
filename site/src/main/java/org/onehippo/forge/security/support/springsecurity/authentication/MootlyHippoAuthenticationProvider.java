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
package org.onehippo.forge.security.support.springsecurity.authentication;

import javax.jcr.Repository;
import javax.jcr.Session;

import org.hippoecm.hst.site.HstServices;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MootlyHippoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

  private Repository systemRepository;

  private MootlyUserDetailsService hippoUserDetailsService;
  

  public MootlyHippoAuthenticationProvider() {
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

  public void setHippoUserDetailsService(MootlyUserDetailsService hippoUserDetailsService) {
    this.hippoUserDetailsService = hippoUserDetailsService;
  }

  protected MootlyUserDetailsService getHippoUserDetailsService() {
    if (hippoUserDetailsService == null) {
      hippoUserDetailsService = new MootlyHippoUserDetailsServiceImpl();
      ((HippoUserDetailsServiceImpl) hippoUserDetailsService).setDefaultRoleName("everybody");
    }
    return hippoUserDetailsService;
  }

  @Override
  protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    if (authentication.getCredentials() == null) {
      //logger.debug("Authentication failed: no credentials provided");

      throw new BadCredentialsException(messages.getMessage(
          "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
          null);
    }
  }

  @Override
  protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
      throws AuthenticationException {

    Repository sysRepo = getSystemRepository();
    String mountIdentifier = null;

    if (sysRepo == null) {
      throw new ProviderNotFoundException("Hippo Repository is not available now.");
    }
    
    Session session = null;
    String password = authentication.getCredentials().toString();
    if (password == null || password.trim().equals("")) {
    	throw new AuthenticationServiceException("password.mismatch");
    }
    if (authentication != null) {
    	Object oDetails = authentication.getDetails();
    	if (oDetails != null && oDetails instanceof MootlyWebAuthenticationDetails) {
    		MootlyWebAuthenticationDetails moa = (MootlyWebAuthenticationDetails) oDetails;
    		mountIdentifier = moa.getMountIdentifier();
    		//moa.getRemoteAddress()
    	}
    }
    //There is no need to do this as all user's who have the membershipsignupdocument should be allowed to login
    /*
    try {
      session = sysRepo.login(new SimpleCredentials(username, password.toCharArray()));
    } catch (LoginException e) {
      throw new BadCredentialsException(e.getMessage());
    } catch (RepositoryException e) {
      throw new ProviderNotFoundException(e.getMessage());
    } finally {
      try {
        session.logout();
      } catch (Exception ignore) {
      }
    }
	*/
    UserDetails loadedUser = null;

    try {
      loadedUser = getHippoUserDetailsService().loadUserByUsernameAndPassword(username, password,mountIdentifier);
    }catch (UsernameNotFoundException usernameNotFoundException) {
    	if (usernameNotFoundException.getMessage() != null && usernameNotFoundException.getMessage().equals("password.mismatch")) {
    		throw new AuthenticationServiceException(usernameNotFoundException.getMessage());
    	}
    	else {
    		throw new AuthenticationServiceException(usernameNotFoundException.getMessage());
    	}
    }
    catch (DataAccessException repositoryProblem) {
      throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
    }

    if (loadedUser == null) {
      throw new AuthenticationServiceException(
          "UserDetailsService returned null, which is an interface contract violation");
    }

    return loadedUser;
  }

}