package com.mootly.wcm.member;

import javax.servlet.http.HttpSession;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;


public class MemberLogout extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(MemberLogout.class);
	

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response)  {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		
		
			Member member=(Member)request.getSession().getAttribute("user");
			if(member!=null){
			HttpSession session = request.getSession(false);
			log.warn("member session");
			if (session != null) {
				log.warn("sessionlogout");
				session.invalidate();
				//((HttpSession) session).invalidate();
                System.out.println("sessionssssssrequest.getSession(false)ssssssssssssssssss:-"+request.getSession(false));
                                            
				try {
					response.sendRedirect("/site");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.warn("Unable to redirect",e);
				}
			}	
					
			}
		}

       
 
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException{
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
	
}
}