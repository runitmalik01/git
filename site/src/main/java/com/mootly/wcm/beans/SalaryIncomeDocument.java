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
/**
 * 
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:salaryincomedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class SalaryIncomeDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:salaryincomedocument";
	static final public String NODE_NAME = "salaryincomedocument";
	final String PROP_DETAIL_BEAN="mootlywcm:salaryincomedetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	
	private final static Logger log = LoggerFactory.getLogger(SalaryIncomeDocument.class); 

	private List<SalaryIncomeDetail> salaryIncomeDetailList;

	public final List<SalaryIncomeDetail> getSalaryIncomeDetailList() {
		if (salaryIncomeDetailList == null) salaryIncomeDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return salaryIncomeDetailList;
	}

	public final void setSalaryIncomeDetailList(List<SalaryIncomeDetail> salaryIncomeDetailList) {
		this.salaryIncomeDetailList = salaryIncomeDetailList;
	}
	
	public final void addSalaryIncomeDetail(SalaryIncomeDetail salaryIncomeDetail) {
		getSalaryIncomeDetailList();
		if (salaryIncomeDetailList == null) salaryIncomeDetailList = new ArrayList<SalaryIncomeDetail>();
		salaryIncomeDetailList.add(salaryIncomeDetail);
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

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			SalaryIncomeDocument salaryincome = (SalaryIncomeDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	if (salaryincome.getSalaryIncomeDetailList() != null && salaryincome.getSalaryIncomeDetailList().size() > 0 ){ 
        		for (SalaryIncomeDetail salaryIncomeDetail:salaryincome.getSalaryIncomeDetailList()) {
        			if (!salaryIncomeDetail.isMarkedForDeletion()) {
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                salaryIncomeDetail.bindToNode(html); 
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
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			SalaryIncomeDetail source =(SalaryIncomeDetail) child;
			addSalaryIncomeDetail(source);
		}
		boolean found = false;
		List<SalaryIncomeDetail> listOfChildren = getSalaryIncomeDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				SalaryIncomeDetail destination =(SalaryIncomeDetail) o;
				SalaryIncomeDetail source  = (SalaryIncomeDetail) child;
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
		SalaryIncomeDetail source =(SalaryIncomeDetail) child;
		addSalaryIncomeDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<SalaryIncomeDetail> listOfChildren = getSalaryIncomeDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				SalaryIncomeDetail destination =(SalaryIncomeDetail) o;
				SalaryIncomeDetail source  = (SalaryIncomeDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			SalaryIncomeDetail source =(SalaryIncomeDetail) child;
			addSalaryIncomeDetail(source);
		}		
	}
}
