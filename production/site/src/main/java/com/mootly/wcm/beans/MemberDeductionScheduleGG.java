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
import java.util.Calendar;
import java.util.Date;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import static com.mootly.wcm.utils.Constants.NT_PRODUCTLINK;
import static com.mootly.wcm.utils.Constants.PROP_PI_PERSONALINFO_LINK;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.utils.GoGreenUtil;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberDeductionScheduleGG")
public class MemberDeductionScheduleGG extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleGG";
	static final public String NODE_NAME = "MemberDeductionScheduleGG";
	
	private String drop;
	private String grossincome;
	private String rentpaid;
	private String minexemption;
	private String grosstotal;
	private String rentpaidgross;
	private String deductionallow;
	

    public String getDrop() {
    	if (drop == null) drop = getProperty("mootlywcm:drop");
    	return drop;
    }
    public String getGrossIncome() {
    	if (grossincome == null) grossincome = getProperty("mootlywcm:grossincome");
    	return grossincome;
    }

    public String getRentPaid() {
    	if (rentpaid == null) rentpaid = getProperty("mootlywcm:rentpaid");
    	return rentpaid;
    }

    public String getMinExemption() {
    	if (minexemption == null) minexemption = getProperty("mootlywcm:minexemption");
    	return minexemption;
    }

    public String getGrossTotal() {
    	if (grosstotal == null) grosstotal = getProperty("mootlywcm:grosstotal");
    	return grosstotal;
    }

    public String getRentPaidGross() {
    	if (rentpaidgross == null) rentpaidgross = getProperty("mootlywcm:rentpaidgross");
    	return rentpaidgross;
    }

    public String getDeductionAllow() {
    	if (deductionallow == null) deductionallow = getProperty("mootlywcm:deductionallow");
    	return deductionallow;
    }

    public final void setDrop(String drop) {
    	this.drop = drop;
    }
    public final void setGrossIncome(String grossincome) {
    	this.grossincome = grossincome;
    }

    public final void setRentPaid(String rentpaid) {
    	this.rentpaid = rentpaid;
    }

    public final void setMinExemption(String minexemption) {
    	this.minexemption = minexemption;
    }

    public final void setGrossTotal(String grosstotal) {
    	this.grosstotal = grosstotal;
    }

    public final void setRentPaidGross(String rentpaidgross) {
    	this.rentpaidgross = rentpaidgross;
    }

    public final void setDeductionAllow(String deductionallow) {
    	this.deductionallow = deductionallow;
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
			MemberDeductionScheduleGG schedule80GG = (MemberDeductionScheduleGG) content;
			node.setProperty("mootlywcm:drop", schedule80GG.getDrop());
	    	node.setProperty("mootlywcm:grossincome", schedule80GG.getGrossIncome());
	    	node.setProperty("mootlywcm:rentpaid", schedule80GG.getRentPaid());
	    	node.setProperty("mootlywcm:minexemption", schedule80GG.getMinExemption());
	    	node.setProperty("mootlywcm:grosstotal", schedule80GG.getGrossTotal());
	    	node.setProperty("mootlywcm:rentpaidgross", schedule80GG.getRentPaidGross());
	    	node.setProperty("mootlywcm:deductionallow", schedule80GG.getDeductionAllow());	
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", schedule80GG.getPersonalInfoUuid());
	       */
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
}
