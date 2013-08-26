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
import com.mootly.wcm.beans.compound.ManufactureFinishedGoodsDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:manufacturefinishedproductsdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class ManufactureFinishedProductsDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:manufacturefinishedproductsdocument";
	static final public String NODE_NAME = "manufacturefinishedproductsdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:manufacturefinishedgoodsdetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	private final static Logger log = LoggerFactory.getLogger(ManufactureFinishedProductsDocument.class); 
	private List<ManufactureFinishedGoodsDetail> ManFinishedGoodsDetailList;
	public final List<ManufactureFinishedGoodsDetail> getManufactureFinishedGoodsDetailList() {
		if (ManFinishedGoodsDetailList == null) ManFinishedGoodsDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return ManFinishedGoodsDetailList;
	}
	public final void setManufactureFinishedGoodsDetailList(List<ManufactureFinishedGoodsDetail> quantUnitList) {
		this.ManFinishedGoodsDetailList = quantUnitList;
	}
	
	public final void addManufactureFinishedGoodsDetail(ManufactureFinishedGoodsDetail FinishedGoods) {
		getManufactureFinishedGoodsDetailList();
		if (ManFinishedGoodsDetailList == null) ManFinishedGoodsDetailList = new ArrayList<ManufactureFinishedGoodsDetail>();
		ManFinishedGoodsDetailList.add(FinishedGoods);
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
			ManufactureFinishedProductsDocument objManufactureFinishedProductsDocument = (ManufactureFinishedProductsDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	if ( objManufactureFinishedProductsDocument.getManufactureFinishedGoodsDetailList() != null &&  objManufactureFinishedProductsDocument.getManufactureFinishedGoodsDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ objManufactureFinishedProductsDocument.getManufactureFinishedGoodsDetailList().size());
        		for (ManufactureFinishedGoodsDetail objFinishedGoods:objManufactureFinishedProductsDocument.getManufactureFinishedGoodsDetailList()) {
        		    
        			if (!objFinishedGoods.isMarkedForDeletion()) {
        				 javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
        				 objFinishedGoods.bindToNode(html); 
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
		ManufactureFinishedProductsDocument salaryIncomeDocument = (ManufactureFinishedProductsDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			ManufactureFinishedGoodsDetail source =(ManufactureFinishedGoodsDetail) child;
			addManufactureFinishedGoodsDetail(source);
		}
		boolean found = false;
		List<ManufactureFinishedGoodsDetail> listOfChildren = getManufactureFinishedGoodsDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				ManufactureFinishedGoodsDetail destination =(ManufactureFinishedGoodsDetail) o;
				ManufactureFinishedGoodsDetail source  = (ManufactureFinishedGoodsDetail) child;
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
		ManufactureFinishedGoodsDetail source =(ManufactureFinishedGoodsDetail) child;
		addManufactureFinishedGoodsDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<ManufactureFinishedGoodsDetail> listOfChildren = getManufactureFinishedGoodsDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				ManufactureFinishedGoodsDetail destination =(ManufactureFinishedGoodsDetail) o;
				ManufactureFinishedGoodsDetail source  = (ManufactureFinishedGoodsDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			ManufactureFinishedGoodsDetail source =(ManufactureFinishedGoodsDetail) child;
			addManufactureFinishedGoodsDetail(source);
		}		
	}
}
