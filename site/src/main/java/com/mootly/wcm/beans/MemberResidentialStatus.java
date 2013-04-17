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
import static com.mootly.wcm.utils.Constants.PROP_PI_PERSONALINFO_LINK;
import static com.mootly.wcm.utils.Constants.Rsstatus_q;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes_yes_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes_yes_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes_yes_yes;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */


@Node(jcrType = "mootlywcm:MemberResidentialStatus")
public class MemberResidentialStatus extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberResidentialStatus";
	static final public String NODE_NAME = "MemberResidentialStatus";

	private String rsstatus_q;
	private String rsstatus_q_yes;
	private String rsstatus_q_yes_yes;
	private String rsstatus_q_yes_yes_yes;
	private String rsstatus_q_yes_no;
	private String rsstatus_q_yes_yes_no;
	private String rsstatus_q_no;
	private String rsstatus_q_no_yes;
	private String rsstatus_q_no_yes_no;
	private String rsstatus_q_no_yes_yes;
	private String rsstatus_q_no_no;
	private String rsstatus_q_no_no_no;
	private String rsstatus_q_no_no_yes;
	private String rsstatus_q_no_no_yes_yes;
	private String rsstatus_q_no_no_yes_yes_yes;
	private String rsstatus_q_no_yes_yes_yes;
	private String rsstatus_q_no_yes_yes_yes_yes;
	private String rsstatus_q_no_yes_yes_yes_no;
	private String PIUUID;

	public String getRsstatusQ() {
		if (rsstatus_q == null) rsstatus_q = getProperty(Rsstatus_q);
		return rsstatus_q;
	}
	public String getRsstatusQNoNoYes() {
		if (rsstatus_q_no_no_yes == null) rsstatus_q_no_no_yes = getProperty(Rsstatus_q_no_no_yes);
		return rsstatus_q_no_no_yes;
	}
	public String getRsstatusQNoNoYesYes() {
		if (rsstatus_q_no_no_yes_yes == null) rsstatus_q_no_no_yes_yes = getProperty(Rsstatus_q_no_no_yes_yes);
		return rsstatus_q_no_no_yes_yes;
	}
	public String getRsstatusQNoYesYesYes() {
		if (rsstatus_q_no_yes_yes_yes == null) rsstatus_q_no_yes_yes_yes = getProperty(Rsstatus_q_no_yes_yes_yes);
		return rsstatus_q_no_yes_yes_yes;
	}
	public String getRsstatusQNoYesYesYesYes() {
		if (rsstatus_q_no_yes_yes_yes_yes == null) rsstatus_q_no_yes_yes_yes_yes = getProperty(Rsstatus_q_no_yes_yes_yes_yes);
		return rsstatus_q_no_yes_yes_yes_yes;
	}
	public String getRsstatusQNoYesYesYesNo() {
		if (rsstatus_q_no_yes_yes_yes_no == null) rsstatus_q_no_yes_yes_yes_no = getProperty(Rsstatus_q_no_yes_yes_yes_no);
		return rsstatus_q_no_yes_yes_yes_no;
	}
	public String getRsstatusQNoNoYesYesYes() {
		if (rsstatus_q_no_no_yes_yes_yes == null) rsstatus_q_no_no_yes_yes_yes = getProperty(Rsstatus_q_no_no_yes_yes_yes);
		return rsstatus_q_no_no_yes_yes_yes;
	}
	public String getRsstatusQYes() {
		if (rsstatus_q_yes == null) rsstatus_q_yes = getProperty(Rsstatus_q_yes);
		return rsstatus_q_yes;
	}
	public String getRsstatusQYesYes() {
		if (rsstatus_q_yes_yes == null) rsstatus_q_yes_yes = getProperty(Rsstatus_q_yes_yes);
		return rsstatus_q_yes_yes;
	}

	public String getRsstatusQYesYesYes() {
		if (rsstatus_q_yes_yes_yes == null) rsstatus_q_yes_yes_yes = getProperty(Rsstatus_q_yes_yes_yes);
		return rsstatus_q_yes_yes_yes;
	}

	public String getRsstatusQYesNo() {
		if (rsstatus_q_yes_no == null) rsstatus_q_yes_no = getProperty(Rsstatus_q_yes_no);
		return rsstatus_q_yes_no;
	}

	public String getRsstatusQYesYesNo() {
		if (rsstatus_q_yes_yes_no == null) rsstatus_q_yes_yes_no = getProperty(Rsstatus_q_yes_yes_no);
		return rsstatus_q_yes_yes_no;
	}

	public String getRsstatusQNo() {
		if (rsstatus_q_no == null) rsstatus_q_no = getProperty(Rsstatus_q_no);
		return rsstatus_q_no;
	}

	public String getRsstatusQNoYes() {
		if (rsstatus_q_no_yes == null) rsstatus_q_no_yes = getProperty(Rsstatus_q_no_yes);
		return rsstatus_q_no_yes;
	}


	public String getRsstatusQNoYesNo() {
		if (rsstatus_q_no_yes_no == null) rsstatus_q_no_yes_no =  getProperty(Rsstatus_q_no_yes_no);
		return rsstatus_q_no_yes_no;
	}

	public String getRsstatusQNoYesYes() {
		if (rsstatus_q_no_yes_yes == null) rsstatus_q_no_yes_yes =  getProperty(Rsstatus_q_no_yes_yes);
		return rsstatus_q_no_yes_yes;
	}

	public String getRsstatusQNoNo() {
		if (rsstatus_q_no_no == null) rsstatus_q_no_no = getProperty(Rsstatus_q_no_no);
		return rsstatus_q_no_no;
	}

	public String getRsstatusQNoNoNo() {
		if (rsstatus_q_no_no_no == null) rsstatus_q_no_no_no = getProperty(Rsstatus_q_no_no_no);
		return rsstatus_q_no_no_no;
	}
	public String getPersonalInfoUuid() {
		return PIUUID;
	}

	public final void setRsstatusQ(String rsstatus_q) {
		this.rsstatus_q = rsstatus_q;
	}

	public final void setRsstatusQNoNoYes(String rsstatus_q_no_no_yes) {
		this.rsstatus_q_no_no_yes=rsstatus_q_no_no_yes;
	}

	public final void setRsstatusQNoNoYesYes(String rsstatus_q_no_no_yes_yes) {
		this.rsstatus_q_no_no_yes_yes=rsstatus_q_no_no_yes_yes;
	}

	public final void setRsstatusQNoYesYesYes(String rsstatus_q_no_yes_yes_yes) {
		this.rsstatus_q_no_yes_yes_yes=rsstatus_q_no_yes_yes_yes;
	}

	public final void setRsstatusQNoYesYesYesYes(String rsstatus_q_no_yes_yes_yes_yes) {
		this.rsstatus_q_no_yes_yes_yes_yes=rsstatus_q_no_yes_yes_yes_yes;
	}

	public final void setRsstatusQNoYesYesYesNo(String rsstatus_q_no_yes_yes_yes_no) {
		this.rsstatus_q_no_yes_yes_yes_no=rsstatus_q_no_yes_yes_yes_no;
	}

	public final void setRsstatusQNoNoYesYesYes(String rsstatus_q_no_yes_yes_yes_no) {
		this.rsstatus_q_no_no_yes_yes_yes=rsstatus_q_no_yes_yes_yes_no;
	}

	public final void setRsstatusQYes(String rsstatus_q_yes) {
		this.rsstatus_q_yes = rsstatus_q_yes;
	}

	public final void setRsstatusQYesYes(String rsstatus_q_yes_yes) {
		this.rsstatus_q_yes_yes = rsstatus_q_yes_yes;
	}

	public final void setRsstatusQYesYesYes(String rsstatus_q_yes_yes_yes) {
		this.rsstatus_q_yes_yes_yes = rsstatus_q_yes_yes_yes;
	}

	public final void setRsstatusQYesNo(String rsstatus_q_yes_no) {
		this.rsstatus_q_yes_no = rsstatus_q_yes_no;
	}

	public final void setRsstatusQYesYesNo(String rsstatus_q_yes_yes_no) {
		this.rsstatus_q_yes_yes_no = rsstatus_q_yes_yes_no;
	}

	public final void setRsstatusQNo(String rsstatus_q_no) {
		this.rsstatus_q_no = rsstatus_q_no;
	}

	public final void setRsstatusQNoYes(String rsstatus_q_no_yes) {
		this.rsstatus_q_no_yes = rsstatus_q_no_yes;
	}
	public final void setRsstatusQNoYesNo(String rsstatus_q_no_yes_no) {
		this.rsstatus_q_no_yes_no = rsstatus_q_no_yes_no;
	}

	public final void setRsstatusQNoYesYes(String rsstatus_q_no_yes_yes) {
		this.rsstatus_q_no_yes_yes = rsstatus_q_no_yes_yes;
	}

	public final void setRsstatusQNoNo(String rsstatus_q_no_no) {
		this.rsstatus_q_no_no = rsstatus_q_no_no;
	}

	public final void setRsstatusQNoNoNo(String rsstatus_q_no_no_no) {
		this.rsstatus_q_no_no_no = rsstatus_q_no_no_no;
	}
	public void setPersonalInforUuid(String piuuid) {
		this.PIUUID = piuuid;
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
			log.info("this is residential bean");
			MemberResidentialStatus residential_stat = (MemberResidentialStatus) content;
			node.setProperty(Rsstatus_q, residential_stat.getRsstatusQ());
			node.setProperty(Rsstatus_q_yes, residential_stat.getRsstatusQYes());
			node.setProperty(Rsstatus_q_yes_yes, residential_stat.getRsstatusQYesYes());
			node.setProperty(Rsstatus_q_yes_yes_yes, residential_stat.getRsstatusQYesYesYes());
			node.setProperty(Rsstatus_q_yes_no, residential_stat.getRsstatusQYesNo());
			node.setProperty(Rsstatus_q_yes_yes_no, residential_stat.getRsstatusQYesYesNo());
			node.setProperty(Rsstatus_q_no, residential_stat.getRsstatusQNo());
			node.setProperty(Rsstatus_q_no_yes, residential_stat.getRsstatusQNoYes());
			node.setProperty(Rsstatus_q_no_yes_no, residential_stat.getRsstatusQNoYesNo());
			node.setProperty(Rsstatus_q_no_yes_yes, residential_stat.getRsstatusQNoYesYes());
			node.setProperty(Rsstatus_q_no_no, residential_stat.getRsstatusQNoNo());	    	
			node.setProperty(Rsstatus_q_no_no_no, residential_stat.getRsstatusQNoNoNo());

			node.setProperty(Rsstatus_q_no_no_yes, residential_stat.getRsstatusQNoNoYes());
			node.setProperty(Rsstatus_q_no_no_yes_yes, residential_stat.getRsstatusQNoNoYesYes());
			node.setProperty(Rsstatus_q_no_yes_yes_yes, residential_stat.getRsstatusQNoYesYesYes());
			node.setProperty(Rsstatus_q_no_yes_yes_yes_yes, residential_stat.getRsstatusQNoYesYesYesYes());
			node.setProperty(Rsstatus_q_no_yes_yes_yes_no, residential_stat.getRsstatusQNoYesYesYesNo());
			node.setProperty(Rsstatus_q_no_no_yes_yes_yes, residential_stat.getRsstatusQNoNoYesYesYes());

			/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", residential_stat.getPersonalInfoUuid());
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
		if (formMap.getField("rsstatus_q") != null) setRsstatusQ(formMap.getField("rsstatus_q").getValue());
		if (formMap.getField("rsstatus_q_yes") != null) setRsstatusQYes(formMap.getField("rsstatus_q_yes").getValue());
		if (formMap.getField("rsstatus_q_yes_yes") != null) setRsstatusQYesYes(formMap.getField("rsstatus_q_yes_yes").getValue());
		if (formMap.getField("rsstatus_q_yes_yes_yes") != null) setRsstatusQYesYesYes(formMap.getField("rsstatus_q_yes_yes_yes").getValue());
		if (formMap.getField("rsstatus_q_yes_no") != null) setRsstatusQYesNo(formMap.getField("rsstatus_q_yes_no").getValue());
		if (formMap.getField("rsstatus_q_yes_yes_no") != null) setRsstatusQYesYesNo(formMap.getField("rsstatus_q_yes_yes_no").getValue());
		if (formMap.getField("rsstatus_q_no") != null) setRsstatusQNo(formMap.getField("rsstatus_q_no").getValue());
		if (formMap.getField("rsstatus_q_no_yes") != null) setRsstatusQNoYes(formMap.getField("rsstatus_q_no_yes").getValue());
		if (formMap.getField("rsstatus_q_no_yes_no") != null) setRsstatusQNoYesNo(formMap.getField("rsstatus_q_no_yes_no").getValue());
		if (formMap.getField("rsstatus_q_no_yes_yes") != null) setRsstatusQNoYesYes(formMap.getField("rsstatus_q_no_yes_yes").getValue());
		if (formMap.getField("rsstatus_q_no_no") != null) setRsstatusQNoNo(formMap.getField("rsstatus_q_no_no").getValue());
		if (formMap.getField("rsstatus_q_no_no_no") != null) setRsstatusQNoNoNo(formMap.getField("rsstatus_q_no_no_no").getValue());

		if (formMap.getField("rsstatus_q_no_no_yes") != null) setRsstatusQNoNoYes(formMap.getField("rsstatus_q_no_no_yes").getValue());
		if (formMap.getField("rsstatus_q_no_no_yes_yes") != null) setRsstatusQNoNoYesYes(formMap.getField("rsstatus_q_no_no_yes_yes").getValue());
		if (formMap.getField("rsstatus_q_no_yes_yes_yes") != null) setRsstatusQNoYesYesYes(formMap.getField("rsstatus_q_no_yes_yes_yes").getValue());
		if (formMap.getField("rsstatus_q_no_yes_yes_yes_yes") != null) setRsstatusQNoYesYesYesYes(formMap.getField("rsstatus_q_no_yes_yes_yes_yes").getValue());
		if (formMap.getField("rsstatus_q_no_yes_yes_yes_no") != null) setRsstatusQNoYesYesYesNo(formMap.getField("rsstatus_q_no_yes_yes_yes_no").getValue());
		if (formMap.getField("rsstatus_q_no_no_yes_yes_yes") != null) setRsstatusQNoNoYesYesYes(formMap.getField("rsstatus_q_no_no_yes_yes_yes").getValue());
	}

	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
}
