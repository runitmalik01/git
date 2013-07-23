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
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import static com.mootly.wcm.utils.Constants.NT_PRODUCTLINK;
import static com.mootly.wcm.utils.Constants.PROP_PI_PERSONALINFO_LINK;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.utils.GoGreenUtil;

/**
 * User: 
 * Date: 
 * Time: 
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberDeductionScheduleVIA")
public class MemberDeductionScheduleVIA extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleVIA";
	static final public String NODE_NAME = "MemberDeductionScheduleVIA";
	
	private String scheduleC;
	private String scheduleGGC;
	private String scheduleCCC;
	private String scheduleQQB;
	private String scheduleCCD;	
	private String scheduleRRB;
	private String scheduleD;
	private String scheduleU;
	private String scheduleDD;
	private String scheduleIA;
	private String scheduleDDB;
	private String scheduleIB;
	private String scheduleE;
	private String scheduleIC;
	private String scheduleG;
	private String scheduleJJA;
	private String scheduleGG;
	private String scheduleID;
	private String scheduleGGA;
	private String scheduleIAB;
	private String scheduleCCF;
	private String total;
	
	
    public String getScheduleC() {
    	if (scheduleC == null) scheduleC = getProperty("mootlywcm:scheduleC");
    	return scheduleC;
    }
    public String getScheduleGGC() {
    	if (scheduleGGC == null) scheduleGGC = getProperty("mootlywcm:scheduleGGC");
    	return scheduleGGC;
    }

    public String getScheduleCCC() {
    	if (scheduleCCC == null) scheduleCCC = getProperty("mootlywcm:scheduleCCC");
    	return scheduleCCC;
    }

    public String getScheduleQQB() {
    	if (scheduleQQB == null) scheduleQQB = getProperty("mootlywcm:scheduleQQB");
    	return scheduleQQB;
    }

    public String getScheduleCCD() {
    	if (scheduleCCD == null) scheduleCCD = getProperty("mootlywcm:scheduleCCD");
    	return scheduleCCD;
    }

    public String getScheduleRRB() {
    	if (scheduleRRB == null) scheduleRRB = getProperty("mootlywcm:scheduleRRB");
    	return scheduleRRB;
    }
    public String getScheduleD() {
    	if (scheduleD == null) scheduleD = getProperty("mootlywcm:scheduleD");
    	return scheduleD;
    }
    public String getScheduleU() {
    	if (scheduleU == null) scheduleU = getProperty("mootlywcm:scheduleU");
    	return scheduleU;
    }
    public String getScheduleDD() {
    	if (scheduleDD == null) scheduleDD = getProperty("mootlywcm:scheduleDD");
    	return scheduleDD;
    }
    public String getScheduleIA() {
    	if (scheduleIA == null) scheduleIA = getProperty("mootlywcm:scheduleIA");
    	return scheduleIA;
    }
    public String getScheduleDDB() {
    	if (scheduleDDB == null) scheduleDDB = getProperty("mootlywcm:scheduleDDB");
    	return scheduleDDB;
    }
    public String getScheduleIB() {
    	if (scheduleIB == null) scheduleIB = getProperty("mootlywcm:scheduleIB");
    	return scheduleIB;
    }
    
    public String getScheduleE() {
    	if (scheduleE == null) scheduleE = getProperty("mootlywcm:scheduleE");
    	return scheduleE;
    }
    
    public String getScheduleIC() {
    	if (scheduleIC == null) scheduleIC = getProperty("mootlywcm:scheduleIC");
    	return scheduleIC;
    }
    
    public String getScheduleG() {
    	if (scheduleG == null) scheduleG = getProperty("mootlywcm:scheduleG");
    	return scheduleG;
    }
    
    public String getScheduleJJA() {
    	if (scheduleJJA == null) scheduleJJA = getProperty("mootlywcm:scheduleJJA");
    	return scheduleJJA;
    }
    
    public String getScheduleGG() {
    	if (scheduleGG == null) scheduleGG = getProperty("mootlywcm:scheduleGG");
    	return scheduleGG;
    }
    
    public String getScheduleID() {
    	if (scheduleID == null) scheduleID = getProperty("mootlywcm:scheduleID");
    	return scheduleID;
    }
    
    public String getScheduleGGA() {
    	if (scheduleGGA == null) scheduleGGA = getProperty("mootlywcm:scheduleGGA");
    	return scheduleGGA;
    }
    
    public String getScheduleIAB() {
    	if (scheduleIAB == null) scheduleIAB = getProperty("mootlywcm:scheduleIAB");
    	return scheduleIAB;
    }
    public String getScheduleCCF() {
    	if (scheduleCCF == null) scheduleCCF = getProperty("mootlywcm:scheduleCCF");
    	return scheduleCCF;
    }
    public String getTotal() {
    	if (total == null) total = getProperty("mootlywcm:total");
    	return total;
    }
    
   
    public final void setScheduleC(String scheduleC) {
    	this.scheduleC = scheduleC;
    }
    public final void setScheduleGGC(String scheduleGGC) {
    	this.scheduleGGC = scheduleGGC;
    }

    public final void setScheduleCCC(String scheduleCCC) {
    	this.scheduleCCC = scheduleCCC;
    }

    public final void setScheduleQQB(String scheduleQQB) {
    	this.scheduleQQB = scheduleQQB;
    }

    public final void setScheduleCCD(String scheduleCCD) {
    	this.scheduleCCD = scheduleCCD;
    }
    
    public final void setScheduleRRB(String scheduleRRB) {
    	this.scheduleRRB = scheduleRRB;
    }
    public final void setScheduleD(String scheduleD) {
    	this.scheduleD = scheduleD;
    }
    public final void setScheduleU(String scheduleU) {
    	this.scheduleU = scheduleU;
    }
    public final void setScheduleDD(String scheduleDD) {
    	this.scheduleDD = scheduleDD;
    }
    public final void setScheduleIA(String scheduleIA) {
    	this.scheduleIA = scheduleIA;
    }
    public final void setScheduleDDB(String scheduleDDB) {
    	this.scheduleDDB = scheduleDDB;
    }
    public final void setScheduleIB(String scheduleIB) {
    	this.scheduleIB = scheduleIB;
    }
    public final void setScheduleE(String scheduleE) {
    	this.scheduleE = scheduleE;
    }
    public final void setScheduleIC(String scheduleIC) {
    	this.scheduleIC = scheduleIC;
    }
    public final void setScheduleG(String scheduleG) {
    	this.scheduleG = scheduleG;
    }
    public final void setScheduleJJA(String scheduleJJA) {
    	this.scheduleJJA = scheduleJJA;
    }
    public final void setScheduleGG(String scheduleGG) {
    	this.scheduleGG = scheduleGG;
    }
    public final void setScheduleID(String scheduleID) {
    	this.scheduleID = scheduleID;
    }
    public final void setScheduleGGA(String scheduleGGA) {
    	this.scheduleGGA = scheduleGGA;
    }
    public final void setScheduleIAB(String scheduleIAB) {
    	this.scheduleIAB = scheduleIAB;
    }
    public final void setScheduleCCF(String scheduleCCF) {
    	this.scheduleCCF = scheduleCCF;
    }
    public final void setTotal(String total) {
    	this.total = total;
    }

    public MemberPersonalInformation getMemberPersoanlInformation() {
    	HippoBean bean = getBean(PROP_PI_PERSONALINFO_LINK);
    	if (!(bean instanceof HippoMirror)) {
    		return null;
    	}
    	MemberPersonalInformation prdBean = (MemberPersonalInformation) ((HippoMirror) bean).getReferencedBean();
    	if (prdBean == null) {
    		return null;
    	}
    	return prdBean;
    }
//for personal information
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is Contact bean");
			MemberDeductionScheduleVIA schedule = (MemberDeductionScheduleVIA) content;
			node.setProperty("mootlywcm:scheduleC", schedule.getScheduleC());
	    	node.setProperty("mootlywcm:scheduleGGC", schedule.getScheduleGGC());
	    	node.setProperty("mootlywcm:scheduleCCC", schedule.getScheduleCCC());
	    	node.setProperty("mootlywcm:scheduleQQB", schedule.getScheduleQQB());
	    	node.setProperty("mootlywcm:scheduleCCD", schedule.getScheduleCCD());
	    	node.setProperty("mootlywcm:scheduleRRB", schedule.getScheduleRRB());
	    	node.setProperty("mootlywcm:scheduleD", schedule.getScheduleD());
	    	node.setProperty("mootlywcm:scheduleU", schedule.getScheduleU());
	    	node.setProperty("mootlywcm:scheduleDD", schedule.getScheduleDD());
	    	node.setProperty("mootlywcm:scheduleIA", schedule.getScheduleIA());
	    	node.setProperty("mootlywcm:scheduleDDB", schedule.getScheduleDDB());
	    	node.setProperty("mootlywcm:scheduleIB", schedule.getScheduleIB());
	    	node.setProperty("mootlywcm:scheduleE", schedule.getScheduleE());
	    	node.setProperty("mootlywcm:scheduleIC", schedule.getScheduleIC());
	    	node.setProperty("mootlywcm:scheduleG", schedule.getScheduleG());
	    	node.setProperty("mootlywcm:scheduleJJA", schedule.getScheduleJJA());
	    	node.setProperty("mootlywcm:scheduleGG", schedule.getScheduleGG());
	    	node.setProperty("mootlywcm:scheduleID", schedule.getScheduleID());
	    	node.setProperty("mootlywcm:scheduleGGA", schedule.getScheduleGGA());
	    	node.setProperty("mootlywcm:scheduleIAB", schedule.getScheduleIAB());
	    	node.setProperty("mootlywcm:scheduleCCF", schedule.getScheduleCCF());
	    	node.setProperty("mootlywcm:total", schedule.getTotal());
	    	
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", schedule.getPersonalInfoUuid());
	       */
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		if ( formMap.getField("scheduleC") != null) setScheduleC(formMap.getField("scheduleC").getValue());		
		if ( formMap.getField("scheduleCCC") != null) setScheduleCCC(formMap.getField("scheduleCCC").getValue());		
		if ( formMap.getField("scheduleCCD") != null) 	setScheduleCCD(formMap.getField("scheduleCCD").getValue());		
		if ( formMap.getField("scheduleCCF") != null) setScheduleCCF(formMap.getField("scheduleCCF").getValue());	
		if ( formMap.getField("scheduleD") != null) setScheduleD(formMap.getField("scheduleD").getValue());		
		if ( formMap.getField("scheduleDD") != null) setScheduleDD(formMap.getField("scheduleDD").getValue());		
		if ( formMap.getField("scheduleDDB") != null) setScheduleDDB( formMap.getField("scheduleDDB").getValue());			
		if ( formMap.getField("scheduleE") != null) setScheduleE( formMap.getField("scheduleE").getValue());		
		if ( formMap.getField("scheduleG") != null) setScheduleG( formMap.getField("scheduleG").getValue());		
		if ( formMap.getField("scheduleGG") != null) setScheduleGG( formMap.getField("scheduleGG").getValue());		
		if ( formMap.getField("scheduleGGA") != null) setScheduleGGA( formMap.getField("scheduleGGA").getValue());		
		if ( formMap.getField("scheduleGGC") != null) setScheduleGGC( formMap.getField("scheduleGGC").getValue());		
		if ( formMap.getField("scheduleIA") != null) setScheduleIA( formMap.getField("scheduleIA").getValue());		
		if ( formMap.getField("scheduleIAB") != null) setScheduleIAB( formMap.getField("scheduleIAB").getValue());		
		if ( formMap.getField("scheduleIB") != null) setScheduleIB( formMap.getField("scheduleIB").getValue());	
		if ( formMap.getField("scheduleIC") != null) setScheduleIC( formMap.getField("scheduleIC").getValue());		
		if ( formMap.getField("scheduleID") != null) setScheduleID( formMap.getField("scheduleID").getValue());		
		if ( formMap.getField("scheduleJJA") != null) setScheduleJJA( formMap.getField("scheduleJJA").getValue());	
		if ( formMap.getField("scheduleQQB") != null) setScheduleQQB( formMap.getField("scheduleQQB").getValue());	
		if ( formMap.getField("scheduleRRB") != null) setScheduleRRB( formMap.getField("scheduleRRB").getValue());		
		if ( formMap.getField("scheduleU") != null) setScheduleU( formMap.getField("scheduleU").getValue());
		
	}	
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
