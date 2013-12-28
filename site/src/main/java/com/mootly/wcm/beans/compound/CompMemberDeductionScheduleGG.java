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

package com.mootly.wcm.beans.compound;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */



public class CompMemberDeductionScheduleGG extends HippoItem  {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleGG";
	static final public String NODE_NAME = "MemberDeductionScheduleGG";
	private final static Logger log = LoggerFactory.getLogger(CompMemberDeductionScheduleGG.class); 
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


//for personal information

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is Contact bean");

			node.setProperty("mootlywcm:drop", getDrop());
	    	node.setProperty("mootlywcm:grossincome", getGrossIncome());
	    	node.setProperty("mootlywcm:rentpaid", getRentPaid());
	    	node.setProperty("mootlywcm:minexemption", getMinExemption());
	    	node.setProperty("mootlywcm:grosstotal", getGrossTotal());
	    	node.setProperty("mootlywcm:rentpaidgross", getRentPaidGross());
	    	node.setProperty("mootlywcm:deductionallow", getDeductionAllow());	
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
}
