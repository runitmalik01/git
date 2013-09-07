/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.member;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;

import com.mootly.wcm.components.itreturns.AbstractITReturnHomePage;

public class ITReturnHomePage extends AbstractITReturnHomePage {
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);
		String reqFormJson=getPublicRequestParameter(request, "data");
		String validation=getPublicRequestParameter(request, "validation");
		if(reqFormJson!=null&&validation!=null){
			try {
				JSONObject formJson=new JSONObject(reqFormJson);
					if( formJson.getString("pan").length()!=0 && formJson.getString("pi_last_name").length()!=0 ){
						char pan5thChar=formJson.getString("pan").toLowerCase().charAt(4);
						char lastName1stChar=formJson.getString("pi_last_name").toLowerCase().charAt(0);
						if(pan5thChar!=lastName1stChar){
							response.setHeader("myHeader", "error");
						}else{
							response.setHeader("myHeader", "success");
						}
					}
					/*char tanpanChar=' ';
					Iterator<String> itr= formJson.keys();
					List<String> fieldlist=new ArrayList<String>();
					while(itr.hasNext()) fieldlist.add(itr.next());
					if(fieldlist.size()==2){
						if(formJson.getString(fieldlist.get(0))!=null&&formJson.getString(fieldlist.get(1))!=null){
							if(validation.matches("pan")) tanpanChar =formJson.getString(fieldlist.get(0)).toLowerCase().charAt(4);
							else tanpanChar =formJson.getString(fieldlist.get(0)).toLowerCase().charAt(3);
							char name1stChar=formJson.getString(fieldlist.get(1)).toLowerCase().charAt(0);
							if(tanpanChar!=name1stChar){
								response.setHeader("myHeader", "error");
							}else{
								response.setHeader("myHeader","success");
							}
						}						
					}**/
			}catch (JSONException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public HippoBean getScope(HstRequest request) {
		// TODO Auto-generated method stub
		return getPanFolder();
	}
	
}
