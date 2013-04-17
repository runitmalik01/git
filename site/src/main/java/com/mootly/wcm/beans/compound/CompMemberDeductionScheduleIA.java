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
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.utils.GoGreenUtil;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberDeductionScheduleIA")
public class CompMemberDeductionScheduleIA extends HippoItem{
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleIA";
	static final public String NODE_NAME = "MemberDeductionScheduleIA";
	private final static Logger log = LoggerFactory.getLogger(CompMemberDeductionScheduleIA.class); 
	private String infraFac;
	private String teleFac;
	private String indsPark;
	private String powerGen;
	private String engPower;	
	private String total;
	

    public String getInfraFac() {
    	if (infraFac == null) infraFac = getProperty("mootlywcm:infraFac");
    	return infraFac;
    }
    public String getTeleFac() {
    	if (teleFac == null) teleFac = getProperty("mootlywcm:teleFac");
    	return teleFac;
    }

    public String getIndsPark() {
    	if (indsPark == null) indsPark = getProperty("mootlywcm:indsPark");
    	return indsPark;
    }

    public String getPowerGen() {
    	if (powerGen == null) powerGen = getProperty("mootlywcm:powerGen");
    	return powerGen;
    }

    public String getEngPower() {
    	if (engPower == null) engPower = getProperty("mootlywcm:engPower");
    	return engPower;
    }


    public String getTotal() {
    	if (total == null) total = getProperty("mootlywcm:total");
    	return total;
    }

    public final void setInfraFac(String infraFac) {
    	this.infraFac = infraFac;
    }
    public final void setTeleFac(String teleFac) {
    	this.teleFac = teleFac;
    }

    public final void setIndsPark(String indsPark) {
    	this.indsPark = indsPark;
    }

    public final void setPowerGen(String powerGen) {
    	this.powerGen = powerGen;
    }

    public final void setEngPower(String engPower) {
    	this.engPower = engPower;
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

			node.setProperty("mootlywcm:infraFac", getInfraFac());
	    	node.setProperty("mootlywcm:teleFac", getTeleFac());
	    	node.setProperty("mootlywcm:indsPark", getIndsPark());
	    	node.setProperty("mootlywcm:powerGen", getPowerGen());
	    	node.setProperty("mootlywcm:engPower", getEngPower());
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
}
