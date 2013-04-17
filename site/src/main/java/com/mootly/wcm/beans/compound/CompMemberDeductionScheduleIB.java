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
@Node(jcrType = "mootlywcm:MemberDeductionScheduleIB")
public class CompMemberDeductionScheduleIB extends HippoItem {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleIB";
	static final public String NODE_NAME = "MemberDeductionScheduleIB";
	private final static Logger log = LoggerFactory.getLogger(CompMemberDeductionScheduleIB.class);
	private String indUndtk;
	private String locJammu;
	private String locIndBackState;
	private String locIndBackDisct;
	private String mulTheater;	
	private String convCenter;
	private String scientRes;
	private String engProdOil;
	private String devHouseProject;
	private String opColdChain;
	private String fruit;
	private String foodGrains;
	private String ruralHos;
	private String total;
	
    public String getIndUndtk() {
    	if (indUndtk == null) indUndtk = getProperty("mootlywcm:indUndtk");
    	return indUndtk;
    }
    public String getLocJammu() {
    	if (locJammu == null) locJammu = getProperty("mootlywcm:locJammu");
    	return locJammu;
    }

    public String getLocIndBackState() {
    	if (locIndBackState == null) locIndBackState = getProperty("mootlywcm:locIndBackState");
    	return locIndBackState;
    }

    public String getLocIndBackDisct() {
    	if (locIndBackDisct == null) locIndBackDisct = getProperty("mootlywcm:locIndBackDisct");
    	return locIndBackDisct;
    }

    public String getMulTheater() {
    	if (mulTheater == null) mulTheater = getProperty("mootlywcm:mulTheater");
    	return mulTheater;
    }

    public String getConvCenter() {
    	if (convCenter == null) convCenter = getProperty("mootlywcm:convCenter");
    	return convCenter;
    }
    public String getScientRes() {
    	if (scientRes == null) scientRes = getProperty("mootlywcm:scientRes");
    	return scientRes;
    }
    public String getEngProdOil() {
    	if (engProdOil == null) engProdOil = getProperty("mootlywcm:engProdOil");
    	return engProdOil;
    }
    public String getDevHouseProject() {
    	if (devHouseProject == null) devHouseProject = getProperty("mootlywcm:devHouseProject");
    	return devHouseProject;
    }
    public String getOpColdChain() {
    	if (opColdChain == null) opColdChain = getProperty("mootlywcm:opColdChain");
    	return opColdChain;
    }
    public String getFruit() {
    	if (fruit == null) fruit = getProperty("mootlywcm:fruit");
    	return fruit;
    }
    public String getFoodGrains() {
    	if (foodGrains == null) foodGrains = getProperty("mootlywcm:foodGrains");
    	return foodGrains;
    }
    public String getRuralHos() {
    	if (ruralHos == null) ruralHos = getProperty("mootlywcm:ruralHos");
    	return ruralHos;
    }
    public String getTotal() {
    	if (total == null) total = getProperty("mootlywcm:total");
    	return total;
    }
    public final void setIndUndtk(String indUndtk) {
    	this.indUndtk = indUndtk;
    }
    public final void setLocJammu(String locJammu) {
    	this.locJammu = locJammu;
    }

    public final void setLocIndBackState(String locIndBackState) {
    	this.locIndBackState = locIndBackState;
    }

    public final void setLocIndBackDisct(String locIndBackDisct) {
    	this.locIndBackDisct = locIndBackDisct;
    }

    public final void setMulTheater(String mulTheater) {
    	this.mulTheater = mulTheater;
    }
    
    public final void setConvCenter(String convCenter) {
    	this.convCenter = convCenter;
    }
    public final void setScientRes(String scientRes) {
    	this.scientRes = scientRes;
    }
    public final void setEngProdOil(String engProdOil) {
    	this.engProdOil = engProdOil;
    }
    public final void setDevHouseProject(String devHouseProject) {
    	this.devHouseProject = devHouseProject;
    }
    public final void setOpColdChain(String opColdChain) {
    	this.opColdChain = opColdChain;
    }
    public final void setFruit(String fruit) {
    	this.fruit = fruit;
    }
    public final void setFoodGrains(String foodGrains) {
    	this.foodGrains = foodGrains;
    }
    public final void setRuralHos(String ruralHos) {
    	this.ruralHos = ruralHos;
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

			node.setProperty("mootlywcm:indUndtk",getIndUndtk());
	    	node.setProperty("mootlywcm:locJammu",getLocJammu());
	    	node.setProperty("mootlywcm:locIndBackState",getLocIndBackState());
	    	node.setProperty("mootlywcm:locIndBackDisct",getLocIndBackDisct());
	    	node.setProperty("mootlywcm:mulTheater",getMulTheater());
	    	node.setProperty("mootlywcm:convCenter",getConvCenter());
	    	node.setProperty("mootlywcm:scientRes",getScientRes());
	    	node.setProperty("mootlywcm:engProdOil",getEngProdOil());
	    	node.setProperty("mootlywcm:devHouseProject",getDevHouseProject());
	    	node.setProperty("mootlywcm:opColdChain",getOpColdChain());
	    	node.setProperty("mootlywcm:fruit",getFruit());
	    	node.setProperty("mootlywcm:foodGrains",getFoodGrains());
	    	node.setProperty("mootlywcm:ruralHos",getRuralHos());
	    	node.setProperty("mootlywcm:total",getTotal());
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase",getPersonalInfoUuid());
	       */
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
}
