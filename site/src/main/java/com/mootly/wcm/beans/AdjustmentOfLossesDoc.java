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

import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.util.ArrayList;
import java.util.List;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.PersonalInformation;

@Node(jcrType = "mootlywcm:adjustmentoflossesdoc")
public class AdjustmentOfLossesDoc extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:adjustmentoflossesdoc";            
	static final public String NODE_NAME = "adjustmentoflossesdoc";
	private String itFolderUuid;

	private List<AdjustmentOfLossesCom> adjustmentoflossescomlist;
	public final List<AdjustmentOfLossesCom> getAdjustmentOfLossesList(){
		if (adjustmentoflossescomlist == null) adjustmentoflossescomlist= getChildBeans("mootlywcm:adjustmentoflossescom");
		return adjustmentoflossescomlist;
	}
	public final void setAdjustmentOfLossesList(List<AdjustmentOfLossesCom> adjustmentoflossescomlist) {
		this.adjustmentoflossescomlist = adjustmentoflossescomlist;
	}

	public final void addAdjustmentOfLossesCom(AdjustmentOfLossesCom adjustmentoflossescom) {
		getAdjustmentOfLossesList();
		if (adjustmentoflossescomlist == null) adjustmentoflossescomlist = new ArrayList<AdjustmentOfLossesCom>();
		adjustmentoflossescomlist.add(adjustmentoflossescom);
	}

	public final String getItFolderUuid() {
		return itFolderUuid;
	}

	public final void setItFolderUuid(String itFolderUuid) {
		this.itFolderUuid = itFolderUuid;
	}

	public PersonalInformation getPersonalInformation() {
		HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
		if (!(bean instanceof HippoMirror)) {
			return null;
		}
		PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();
		if (prdBean == null) {
			return null;
		}
		return prdBean;
	}

	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {

		try {
			AdjustmentOfLossesDoc bean = (AdjustmentOfLossesDoc) content;
			NodeIterator nodeIterator = node.getNodes("mootlywcm:adjustmentoflossescom");
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			if (bean.getAdjustmentOfLossesList() != null && bean.getAdjustmentOfLossesList().size() > 0 ){  
				for (AdjustmentOfLossesCom adjustmentoflossescom:bean.getAdjustmentOfLossesList()) {
					if(adjustmentoflossescom.equals(null)){
						log.info("this is null child bean");
					}
					if(adjustmentoflossescom.getAmount()!=null){
						if (!adjustmentoflossescom.isMarkedForDeletion()) {
							javax.jcr.Node html = node.addNode("mootlywcm:adjustmentoflossescom", "mootlywcm:adjustmentoflossescom");
							adjustmentoflossescom.bindToNode(html); 
						}
					}
				}
			}
			/*
				javax.jcr.Node prdLinkNode;
				if (node.hasNode(NT_PERSONAL_INFO_LINK)) {
					prdLinkNode = node.getNode(NT_PERSONAL_INFO_LINK);
				} else {
					prdLinkNode = node.addNode(NT_PERSONAL_INFO_LINK, "hippo:mirror");
				}
				prdLinkNode.setProperty("hippo:docbase", salaryincome.getPersonalInfoUuid());
			 */

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;

	}	   

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap != null) {

		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		//we know the source bean will be SalaryIncomeDocument but doesn't hurt to check
		AdjustmentOfLossesDoc adjustmentoflosses = (AdjustmentOfLossesDoc) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			AdjustmentOfLossesCom source =(AdjustmentOfLossesCom) child;
			addAdjustmentOfLossesCom(source);
		}
		boolean found = false;
		List<AdjustmentOfLossesCom> listOfChildren = getAdjustmentOfLossesList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				AdjustmentOfLossesCom destination =(AdjustmentOfLossesCom) o;
				AdjustmentOfLossesCom source  = (AdjustmentOfLossesCom) child;
				destination.cloneBean(source);
				found = true;
				break;
			}
		}		
	}

	@Override
	public void add(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		AdjustmentOfLossesCom source =(AdjustmentOfLossesCom) child;
		addAdjustmentOfLossesCom(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<AdjustmentOfLossesCom> listOfChildren = getAdjustmentOfLossesList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				AdjustmentOfLossesCom destination =(AdjustmentOfLossesCom) o;
				AdjustmentOfLossesCom source  = (AdjustmentOfLossesCom) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			AdjustmentOfLossesCom source =(AdjustmentOfLossesCom) child;
			addAdjustmentOfLossesCom(source);
		}		
	}
}

