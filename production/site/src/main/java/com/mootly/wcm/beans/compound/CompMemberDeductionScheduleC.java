/**
 * Copyright (C) twotenoneten Hippo B.V.
 *
 * Licensed under the Apache License, Version two.ten (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-two.ten
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans.compound;
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
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.utils.GoGreenUtil;

/**
 * User: 
 * Date: 
 * Time: 
 */

@SuppressWarnings("unused")

public class CompMemberDeductionScheduleC extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleC";
	static final public String NODE_NAME = "MemberDeductionScheduleC";
	private final static Logger log = LoggerFactory.getLogger(CompMemberDeductionScheduleC.class); 
	private String dpone;
	private String dptwo;
	private String dpthree;
	private String dpfour;
	private String dpfive;	
	private String dpsix;
	private String dpseven;
	private String dpeight;
	private String dpnine;
	private String dpten;
	private String scheduleCone;
	private String scheduleCtwo;
	private String scheduleCthree;
	private String scheduleCfour;
	private String scheduleCfive;
	private String scheduleCsix;
	private String scheduleCseven;
	private String scheduleCeight;
	private String scheduleCnine;
	private String scheduleCten;
	private String total;
	
	
    public String getDpone() {
    	if (dpone == null) dpone = getProperty("mootlywcm:dpone");
    	return dpone;
    }
    public String getDptwo() {
    	if (dptwo == null) dptwo = getProperty("mootlywcm:dptwo");
    	return dptwo;
    }

    public String getDpthree() {
    	if (dpthree == null) dpthree = getProperty("mootlywcm:dpthree");
    	return dpthree;
    }

    public String getDpfour() {
    	if (dpfour == null) dpfour = getProperty("mootlywcm:dpfour");
    	return dpfour;
    }

    public String getDpfive() {
    	if (dpfive == null) dpfive = getProperty("mootlywcm:dpfive");
    	return dpfive;
    }

    public String getDpsix() {
    	if (dpsix == null) dpsix = getProperty("mootlywcm:dpsix");
    	return dpsix;
    }
    public String getDpseven() {
    	if (dpseven == null) dpseven = getProperty("mootlywcm:dpseven");
    	return dpseven;
    }
    public String getDpeight() {
    	if (dpeight == null) dpeight = getProperty("mootlywcm:dpeight");
    	return dpeight;
    }
    public String getDpnine() {
    	if (dpnine == null) dpnine = getProperty("mootlywcm:dpnine");
    	return dpnine;
    }
    public String getDpten() {
    	if (dpten == null) dpten = getProperty("mootlywcm:dpten");
    	return dpten;
    }
    public String getScheduleCone() {
    	if (scheduleCone == null) scheduleCone = getProperty("mootlywcm:scheduleCone");
    	return scheduleCone;
    }
    public String getScheduleCtwo() {
    	if (scheduleCtwo == null) scheduleCtwo = getProperty("mootlywcm:scheduleCtwo");
    	return scheduleCtwo;
    }
    
    public String getScheduleCthree() {
    	if (scheduleCthree == null) scheduleCthree = getProperty("mootlywcm:scheduleCthree");
    	return scheduleCthree;
    }
    
    public String getScheduleCfour() {
    	if (scheduleCfour == null) scheduleCfour = getProperty("mootlywcm:scheduleCfour");
    	return scheduleCfour;
    }
    
    public String getScheduleCfive() {
    	if (scheduleCfive == null) scheduleCfive = getProperty("mootlywcm:scheduleCfive");
    	return scheduleCfive;
    }
    
    public String getScheduleCsix() {
    	if (scheduleCsix == null) scheduleCsix = getProperty("mootlywcm:scheduleCsix");
    	return scheduleCsix;
    }
    
    public String getScheduleCseven() {
    	if (scheduleCseven == null) scheduleCseven = getProperty("mootlywcm:scheduleCseven");
    	return scheduleCseven;
    }
    
    public String getScheduleCeight() {
    	if (scheduleCeight == null) scheduleCeight = getProperty("mootlywcm:scheduleCeight");
    	return scheduleCeight;
    }
    
    public String getScheduleCnine() {
    	if (scheduleCnine == null) scheduleCnine = getProperty("mootlywcm:scheduleCnine");
    	return scheduleCnine;
    }
    
    public String getScheduleCten() {
    	if (scheduleCten == null) scheduleCten = getProperty("mootlywcm:scheduleCten");
    	return scheduleCten;
    }
    public String getTotal() {
    	if (total == null) total = getProperty("mootlywcm:total");
    	return total;
    }
    
   
    public final void setDpone(String dpone) {
    	this.dpone = dpone;
    }
    public final void setDptwo(String dptwo) {
    	this.dptwo = dptwo;
    }

    public final void setDpthree(String dpthree) {
    	this.dpthree = dpthree;
    }

    public final void setDpfour(String dpfour) {
    	this.dpfour = dpfour;
    }

    public final void setDpfive(String dpfive) {
    	this.dpfive = dpfive;
    }
    
    public final void setDpsix(String dpsix) {
    	this.dpsix = dpsix;
    }
    public final void setDpseven(String dpseven) {
    	this.dpseven = dpseven;
    }
    public final void setDpeight(String dpeight) {
    	this.dpeight = dpeight;
    }
    public final void setDpnine(String dpnine) {
    	this.dpnine = dpnine;
    }
    public final void setDpten(String dpten) {
    	this.dpten = dpten;
    }
    public final void setScheduleCone(String scheduleCone) {
    	this.scheduleCone = scheduleCone;
    }
    public final void setScheduleCtwo(String scheduleCtwo) {
    	this.scheduleCtwo = scheduleCtwo;
    }
    public final void setScheduleCthree(String scheduleCthree) {
    	this.scheduleCthree = scheduleCthree;
    }
    public final void setScheduleCfour(String scheduleCfour) {
    	this.scheduleCfour = scheduleCfour;
    }
    public final void setScheduleCfive(String scheduleCfive) {
    	this.scheduleCfive = scheduleCfive;
    }
    public final void setScheduleCsix(String scheduleCsix) {
    	this.scheduleCsix = scheduleCsix;
    }
    public final void setScheduleCseven(String scheduleCseven) {
    	this.scheduleCseven = scheduleCseven;
    }
    public final void setScheduleCeight(String scheduleCeight) {
    	this.scheduleCeight = scheduleCeight;
    }
    public final void setScheduleCnine(String scheduleCnine) {
    	this.scheduleCnine = scheduleCnine;
    }
    public final void setScheduleCten(String scheduleCten) {
    	this.scheduleCten = scheduleCten;
    }
    public final void setTotal(String total) {
    	this.total = total;
    }

   
//for personal information
	
    
	
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is Contact bean");
			node.setProperty("mootlywcm:dpone", getDpone());
	    	node.setProperty("mootlywcm:dptwo", getDptwo());
	    	node.setProperty("mootlywcm:dpthree", getDpthree());
	    	node.setProperty("mootlywcm:dpfour", getDpfour());
	    	node.setProperty("mootlywcm:dpfive", getDpfive());
	    	node.setProperty("mootlywcm:dpsix", getDpsix());
	    	node.setProperty("mootlywcm:dpseven", getDpseven());
	    	node.setProperty("mootlywcm:dpeight", getDpeight());
	    	node.setProperty("mootlywcm:dpnine", getDpnine());
	    	node.setProperty("mootlywcm:dpten", getDpten());
	    	node.setProperty("mootlywcm:scheduleCone", getScheduleCone());
	    	node.setProperty("mootlywcm:scheduleCtwo", getScheduleCtwo());
	    	node.setProperty("mootlywcm:scheduleCthree", getScheduleCthree());
	    	node.setProperty("mootlywcm:scheduleCfour", getScheduleCfour());
	    	node.setProperty("mootlywcm:scheduleCfive", getScheduleCfive());
	    	node.setProperty("mootlywcm:scheduleCsix", getScheduleCsix());
	    	node.setProperty("mootlywcm:scheduleCseven", getScheduleCseven());
	    	node.setProperty("mootlywcm:scheduleCeight", getScheduleCeight());
	    	node.setProperty("mootlywcm:scheduleCnine", getScheduleCnine());
	    	node.setProperty("mootlywcm:scheduleCten", getScheduleCten());
	    	node.setProperty("mootlywcm:total", getTotal());
	    	
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", getPersonalInfoUuid());
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
		if ( formMap.getField("dp1") != null) setDpone(formMap.getField("dp1").getValue());		
		if ( formMap.getField("dp2") != null) setDptwo(formMap.getField("dp2").getValue());		
		if ( formMap.getField("dp3") != null) 	setDpthree(formMap.getField("dp3").getValue());		
		if ( formMap.getField("dp4") != null) setDpfour(formMap.getField("dp4").getValue());	
		if ( formMap.getField("dp5") != null) setDpfive(formMap.getField("dp5").getValue());		
		if ( formMap.getField("dp6") != null) setDpsix(formMap.getField("dp6").getValue());		
		if ( formMap.getField("dp7") != null) setDpseven( formMap.getField("dp7").getValue());			
		if ( formMap.getField("dp8") != null) setDpeight( formMap.getField("dp8").getValue());		
		if ( formMap.getField("dp9") != null) setDpnine( formMap.getField("dp9").getValue());		
		if ( formMap.getField("dp10") != null) setDpten( formMap.getField("dp10").getValue());		
		if ( formMap.getField("schedule80C1") != null) setScheduleCtwo( formMap.getField("schedule80C1").getValue());		
		if ( formMap.getField("schedule80C2") != null) setScheduleCthree( formMap.getField("schedule80C2").getValue());		
		if ( formMap.getField("schedule80C3") != null) setScheduleCfour( formMap.getField("schedule80C3").getValue());		
		if ( formMap.getField("schedule80C4") != null) setScheduleCfive( formMap.getField("schedule80C4").getValue());		
		if ( formMap.getField("schedule80C5") != null) setScheduleCsix( formMap.getField("schedule80C5").getValue());	
		if ( formMap.getField("schedule80C6") != null) setScheduleCseven( formMap.getField("schedule80C6").getValue());		
		if ( formMap.getField("schedule80C7") != null) setScheduleCeight( formMap.getField("schedule80C7").getValue());		
		if ( formMap.getField("schedule80C8") != null) setScheduleCnine( formMap.getField("schedule80C8").getValue());	
		if ( formMap.getField("schedule80C9") != null) setScheduleCten( formMap.getField("schedule80C9").getValue());
		if ( formMap.getField("schedule80C10") != null) setScheduleCten( formMap.getField("schedule80C10").getValue());
		if ( formMap.getField("setTotal") != null) setTotal( formMap.getField("setTotal").getValue());			
	}	
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
