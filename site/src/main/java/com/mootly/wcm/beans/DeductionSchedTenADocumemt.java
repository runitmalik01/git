/**
 * Copyright (C) 20Ten Hippo B.V.
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
import com.mootly.wcm.beans.compound.DeductionSchedTenADetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:deductionschedtenadocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class DeductionSchedTenADocumemt extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:deductionschedtenadocument";
	static final public String NODE_NAME = "deductionschedtenadocument";
	final String PROP_DETAIL_BEAN="mootlywcm:deductionschedtenadetail";
	private final static Logger log = LoggerFactory.getLogger(DeductionSchedTenADocumemt.class); 

	private List<DeductionSchedTenADetail> scheduleTenADetailList;
	private String itFolderUuid;
	private Double grossDedSchedTenA;
	private Double grossDedSchedTenAA;

	public final List<DeductionSchedTenADetail> getScheduleTenADetailList() {
		if (scheduleTenADetailList == null) scheduleTenADetailList= getChildBeans(PROP_DETAIL_BEAN);
		return scheduleTenADetailList;
	}

	public final void setScheduleTenADetailList(List<DeductionSchedTenADetail> tdsothersDetailList) {
		this.scheduleTenADetailList = tdsothersDetailList;
	}

	public final void addDeductionSchedTenADetail(DeductionSchedTenADetail financialInterestdetail) {
		getScheduleTenADetailList();
		if (scheduleTenADetailList == null) scheduleTenADetailList = new ArrayList<DeductionSchedTenADetail>();
		scheduleTenADetailList.add(financialInterestdetail);
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
			DeductionSchedTenADocumemt scheduleSiDocument = (DeductionSchedTenADocumemt) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			Double gross10a=0d;
			Double gross10aa=0d;
			if ( scheduleSiDocument.getScheduleTenADetailList() != null &&  scheduleSiDocument.getScheduleTenADetailList().size() > 0 ){ 
				log.info("checking size in schedule si bean:::"+ scheduleSiDocument.getScheduleTenADetailList().size());        		
				for (DeductionSchedTenADetail objfinancialinterest:scheduleSiDocument.getScheduleTenADetailList()) {       		    
					if (!objfinancialinterest.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						if(objfinancialinterest.getScheduleName().equals("10a")){
							gross10a = gross10a + objfinancialinterest.getAmount();
						}
						if(objfinancialinterest.getScheduleName().equals("10aa")){
							gross10aa = gross10aa + objfinancialinterest.getAmount();
						}
						objfinancialinterest.bindToNode(html); 
					}
				}      
			}
			setGrossDedSchedTenA(gross10a);
			setGrossDedSchedTenAA(gross10aa);
			node.setProperty("mootlywcm:grossDedSchedTenA", getGrossDedSchedTenA());
			node.setProperty("mootlywcm:grossDedSchedTenAA", getGrossDedSchedTenAA());
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
		DeductionSchedTenADocumemt scheduleTenADocument = (DeductionSchedTenADocumemt) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			DeductionSchedTenADetail source =(DeductionSchedTenADetail) child;
			addDeductionSchedTenADetail(source);
		}
		boolean found = false;
		List<DeductionSchedTenADetail> listOfChildren = getScheduleTenADetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				DeductionSchedTenADetail destination =(DeductionSchedTenADetail) o;
				DeductionSchedTenADetail source  = (DeductionSchedTenADetail) child;
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
		DeductionSchedTenADetail source =(DeductionSchedTenADetail) child;
		addDeductionSchedTenADetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<DeductionSchedTenADetail> listOfChildren = getScheduleTenADetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				DeductionSchedTenADetail destination =(DeductionSchedTenADetail) o;
				DeductionSchedTenADetail source  = (DeductionSchedTenADetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			DeductionSchedTenADetail source =(DeductionSchedTenADetail) child;
			addDeductionSchedTenADetail(source);
		}		
	}

	public Double getGrossDedSchedTenA() {
		if(grossDedSchedTenA == null) grossDedSchedTenA = getProperty("mootlywcm:grossDedSchedTenA");
		return grossDedSchedTenA;
	}

	public void setGrossDedSchedTenA(Double grossDedSchedTenA) {
		this.grossDedSchedTenA = grossDedSchedTenA;
	}

	public Double getGrossDedSchedTenAA() {
		if(grossDedSchedTenAA == null) grossDedSchedTenAA = getProperty("mootlywcm:grossDedSchedTenAA");
		return grossDedSchedTenAA;
	}

	public void setGrossDedSchedTenAA(Double grossDedSchedTenAA) {
		this.grossDedSchedTenAA = grossDedSchedTenAA;
	}
}
