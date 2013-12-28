/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans;


import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

/**
 * author: Pankaj Singh
 * Date: 30/03/2013
 * 
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:rebatedocumentninety")
public class RebateSec90Document extends BaseDocument implements ContentNodeBinder,FormMapFiller {

	static final public String NAMESPACE = "mootlywcm:rebatedocumentninety";
	static final public String NODE_NAME = "rebatedocumentninety";



	private Double section90;
	private Double section91;
	private Double section89; 
	private String userCountry;
	private Double taxPaidForeignCountry;
	private Double incomeForeignCountry;
	
	public Double getSection90() {
    	if (section90 == null) section90 = getProperty("mootlywcm:section90");
    	return section90;
    }

    public Double getSection91() {
    	if (section91== null) section91= getProperty("mootlywcm:section91");
    	return section91;
    }
    public Double getSection89(){
    	if(section89== null) section89=getProperty("mootlywcm:section89");
    	return section89;
    }
    public String getUserCountry() {
    	if (userCountry== null) userCountry= getProperty("mootlywcm:userCountry");
    	return userCountry;
    }
    public Double getTaxPaidForeignCountry() {
    	if (taxPaidForeignCountry == null) taxPaidForeignCountry= getProperty("mootlywcm:taxPaidForeignCountry");
    	return taxPaidForeignCountry;
    }
    public Double getIncomeForeignCountry() {
    	if (incomeForeignCountry == null) incomeForeignCountry= getProperty("mootlywcm:incomeForeignCountry");
    	return incomeForeignCountry;
    }


	public final void setSection90(Double totaltaxninety) {
		this.section90 = totaltaxninety;
	}

	public final void setSection91(Double Section91) {
		this.section91 = Section91;
	}
	public final void setSection89(Double Section89){
		this.section89=Section89;
	}
	public final void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public final void setTaxPaidForeignCountry(Double taxPaidForeignCountry) {
		this.taxPaidForeignCountry = taxPaidForeignCountry;
	}
	public final void setIncomeForeignCountry(Double incomeForeignCountry) {
		this.incomeForeignCountry = incomeForeignCountry;
	}
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if(log.isInfoEnabled()){
			log.info("this is Contact bean");
			}
			RebateSec90Document rebate = (RebateSec90Document) content;
			node.setProperty("mootlywcm:section90", rebate.getSection90());
	    	node.setProperty("mootlywcm:section91", rebate.getSection91());
	    	node.setProperty("mootlywcm:userCountry", rebate.getUserCountry());
	    	node.setProperty("mootlywcm:taxPaidForeignCountry", rebate.getTaxPaidForeignCountry());
	    	node.setProperty("mootlywcm:incomeForeignCountry", rebate.getIncomeForeignCountry());
	    	node.setProperty("mootlywcm:section89", rebate.getSection89());
	    	
	    	
	    		
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", contact_info.getPersonalInfoUuid());
	       */
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		String strTaxpaid=null;
		String strIncomeForeign=null;
		String strTotaltax90= null;
		String strTotaltax91= null;
		Double Totaltaxninety=0.0;
		Double TotalTaxEightyNine=0.0;
		 String strTotaltax89= null;
		Double TotalTaxninetyOne=0.0;
		if (formMap.getField("userCountry") != null) setUserCountry(formMap.getField("userCountry").getValue());
		if (formMap.getField("taxPaidForeignCountry") != null) 
			strTaxpaid=formMap.getField("taxPaidForeignCountry").getValue();
			double TaxpaidInForeignCountry=Double.parseDouble(strTaxpaid);
			setTaxPaidForeignCountry(TaxpaidInForeignCountry);
		if (formMap.getField("incomeForeignCountry") != null) {
			strIncomeForeign=formMap.getField("incomeForeignCountry").getValue();
		double IncomeForeign=Double.parseDouble(strIncomeForeign);
				setIncomeForeignCountry(IncomeForeign);
		}
		if (formMap.getField("txttotaltax") != null) {
			strTotaltax90=formMap.getField("txttotaltax").getValue();
			if(!(strTotaltax90.isEmpty())){
				 Totaltaxninety=Double.parseDouble(strTotaltax90);
			}else{
				Totaltaxninety=0.0;
			}
			setSection90(Totaltaxninety);
		}
			if(formMap.getField("section91") != null){
					strTotaltax91=formMap.getField("section91").getValue();
					if(!(strTotaltax91.isEmpty())){
					 TotalTaxninetyOne=Double.parseDouble(strTotaltax91);
					}
				 else{
					TotalTaxninetyOne=0.0;
				 }
			setSection91(TotalTaxninetyOne);
				}
			if(formMap.getField("section89") != null){
				strTotaltax89=formMap.getField("section89").getValue();
				
				if(!(strTotaltax89.isEmpty())){
				 TotalTaxEightyNine=Double.parseDouble(strTotaltax89);
				
				}
			 else{
				 TotalTaxEightyNine=0.0;
			 }
		setSection89(TotalTaxEightyNine);
			}
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}

	
	
}
