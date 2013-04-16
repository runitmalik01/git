package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.BaseComponent;

public class Home extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(Home.class);
	  private static final int DEFAULT_PAGE_SIZE = 5;
	    private static final String PARAM_CURRENT_PAGE = "pageNumber";
	    private static final int DEFAULT_CURRENT_PAGE = 1;

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		log.error("This is Member Home Page");
		String status=getPublicRequestParameter(request, "status");
		if(status!=null&&status.equals("success")){
		request.setAttribute("status","You have successfully submit the Personal &Contact Information");
		}
		String error=getPublicRequestParameter(request,"error");
		if(error!=null&&error.equals("assessyear")){
			request.setAttribute("assess_year_error","Please Enter the assessment year");
		}
		Member member=(Member)request.getSession().getAttribute("user");
		Collection<String> oldpan= member.getPAN();
		if(!oldpan.isEmpty()){
			request.setAttribute("oldpan", oldpan.toArray(new String[oldpan.size()]));
		}
		ResolvedSiteMapItem resolvedSiteMapItem = request.getRequestContext().getResolvedSiteMapItem();
	
		log.error("resolvedSiteMapItem.getRelativeContentPath():" + resolvedSiteMapItem.getRelativeContentPath());
		log.error("resolvedSiteMapItem.getRelativeContentPath():" + resolvedSiteMapItem.getHstSiteMapItem().getRelativeContentPath());
		     // String test=  getContentBean(request).getPath();
		      //log.warn("path"+test);
		      List<MemberPersonalInformation> mperinfo = new ArrayList<MemberPersonalInformation>();
		      List<MemberContactInformation> mconinfo = new ArrayList<MemberContactInformation>();
		      for(String t:oldpan){	
				try {
					log.warn("in try");
					MemberPersonalInformation pidocument=(MemberPersonalInformation) getObjectBeanManager(request).getObject("/content/documents/mootlywcm/members/pans/"+t+"/personalinformation/personalinformation");
					MemberContactInformation cidocument=(MemberContactInformation) getObjectBeanManager(request).getObject("/content/documents/mootlywcm/members/pans/"+t+"/contactinformation/contactinformation");
					mperinfo.add(pidocument);
					mconinfo.add(cidocument);
				   }catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		    request.setAttribute("mperinfo", mconinfo);
		    request.setAttribute("mconinfo", mconinfo);
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		
	}
	
	@Override
	public void doBeforeServeResource(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doBeforeServeResource(request, response);
	}
}
