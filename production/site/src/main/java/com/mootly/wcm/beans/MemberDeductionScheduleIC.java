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
@Node(jcrType = "mootlywcm:MemberDeductionScheduleIC")
public class MemberDeductionScheduleIC extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:MemberDeductionScheduleIC";
	static final public String NODE_NAME = "MemberDeductionScheduleIC";
	
	private String locSikkim;
	private String locHimachalPradesh;
	private String locUttaranchal;
	private String id4;
	private String norestAssam;	
	private String norestArunachal;
	private String norestManipur;
	private String norestMizoram;
	private String norestMeghalaya;
	private String norestTripura;
	private String norestNagaland;
	private String totalnorest;
	private String total;
	
    public String getLocSikkim() {
    	if (locSikkim == null) locSikkim = getProperty("mootlywcm:locSikkim");
    	return locSikkim;
    }
    public String getLocHimachalPradesh() {
    	if (locHimachalPradesh == null) locHimachalPradesh = getProperty("mootlywcm:locHimachalPradesh");
    	return locHimachalPradesh;
    }

    public String getLocUttaranchal() {
    	if (locUttaranchal == null) locUttaranchal = getProperty("mootlywcm:locUttaranchal");
    	return locUttaranchal;
    }

    public String getID4() {
    	if (id4 == null) id4 = getProperty("mootlywcm:id4");
    	return id4;
    }

    public String getNorestAssam() {
    	if (norestAssam == null) norestAssam = getProperty("mootlywcm:norestAssam");
    	return norestAssam;
    }

    public String getNorestArunachal() {
    	if (norestArunachal == null) norestArunachal = getProperty("mootlywcm:norestArunachal");
    	return norestArunachal;
    }
    public String getNorestManipur() {
    	if (norestManipur == null) norestManipur = getProperty("mootlywcm:norestManipur");
    	return norestManipur;
    }
    public String getNorestMizoram() {
    	if (norestMizoram == null) norestMizoram = getProperty("mootlywcm:norestMizoram");
    	return norestMizoram;
    }
    public String getNorestMeghalaya() {
    	if (norestMeghalaya == null) norestMeghalaya = getProperty("mootlywcm:norestMeghalaya");
    	return norestMeghalaya;
    }
    public String getNorestTripura() {
    	if (norestTripura == null) norestTripura = getProperty("mootlywcm:norestTripura");
    	return norestTripura;
    }
    public String getNorestNagaland() {
    	if (norestNagaland == null) norestNagaland = getProperty("mootlywcm:norestNagaland");
    	return norestNagaland;
    }
    public String getTotalnorest() {
    	if (totalnorest == null) totalnorest = getProperty("mootlywcm:totalnorest");
    	return totalnorest;
    }
    public String getTotal() {
    	if (total == null) total = getProperty("mootlywcm:total");
    	return total;
    }
    public final void setLocSikkim(String locSikkim) {
    	this.locSikkim = locSikkim;
    }
    public final void setLocHimachalPradesh(String locHimachalPradesh) {
    	this.locHimachalPradesh = locHimachalPradesh;
    }

    public final void setLocUttaranchal(String locUttaranchal) {
    	this.locUttaranchal = locUttaranchal;
    }

    public final void setID4(String id4) {
    	this.id4 = id4;
    }

    public final void setNorestAssam(String norestAssam) {
    	this.norestAssam = norestAssam;
    }
    
    public final void setNorestArunachal(String norestArunachal) {
    	this.norestArunachal = norestArunachal;
    }
    public final void setNorestManipur(String norestManipur) {
    	this.norestManipur = norestManipur;
    }
    public final void setNorestMizoram(String norestMizoram) {
    	this.norestMizoram = norestMizoram;
    }
    public final void setNorestMeghalaya(String norestMeghalaya) {
    	this.norestMeghalaya = norestMeghalaya;
    }
    public final void setNorestTripura(String norestTripura) {
    	this.norestTripura = norestTripura;
    }
    public final void setNorestNagaland(String norestNagaland) {
    	this.norestNagaland = norestNagaland;
    }
    public final void setTotalnorest(String totalnorest) {
    	this.totalnorest = totalnorest;
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
			MemberDeductionScheduleIC schedule80GG = (MemberDeductionScheduleIC) content;
			node.setProperty("mootlywcm:locSikkim", schedule80GG.getLocSikkim());
	    	node.setProperty("mootlywcm:locHimachalPradesh", schedule80GG.getLocHimachalPradesh());
	    	node.setProperty("mootlywcm:locUttaranchal", schedule80GG.getLocUttaranchal());
	    	node.setProperty("mootlywcm:id4", schedule80GG.getID4());
	    	node.setProperty("mootlywcm:norestAssam", schedule80GG.getNorestAssam());
	    	node.setProperty("mootlywcm:norestArunachal", schedule80GG.getNorestArunachal());
	    	node.setProperty("mootlywcm:norestManipur", schedule80GG.getNorestManipur());
	    	node.setProperty("mootlywcm:norestMizoram", schedule80GG.getNorestMizoram());
	    	node.setProperty("mootlywcm:norestMeghalaya", schedule80GG.getNorestMeghalaya());
	    	node.setProperty("mootlywcm:norestTripura", schedule80GG.getNorestTripura());
	    	node.setProperty("mootlywcm:norestNagaland", schedule80GG.getNorestNagaland());
	    	node.setProperty("mootlywcm:totalnorest", schedule80GG.getTotalnorest());
	    	node.setProperty("mootlywcm:total", schedule80GG.getTotal());
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
