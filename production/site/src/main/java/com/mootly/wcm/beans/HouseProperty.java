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
 * User: Megha
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
import com.mootly.wcm.beans.compound.HouseIncomeDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:houseproperty")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class HouseProperty extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:houseproperty";
	static final public String NODE_NAME = "houseproperty";
	final String PROP_DETAIL_BEAN="mootlywcm:houseincomedetail";
	private String itFolderUuid;


	private final static Logger log = LoggerFactory.getLogger(HouseProperty.class); 

	private List<HouseIncomeDetail> houseincomeDetailList;



	public final List<HouseIncomeDetail> getHouseIncomeDetailList() {
		if (houseincomeDetailList == null) houseincomeDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return houseincomeDetailList;
	}

	public final void setHouseIncomeDetailList(List<HouseIncomeDetail> houseincomeDetailList) {
		this.houseincomeDetailList = houseincomeDetailList;
	}

	public final void addHouseIncomeDetail(HouseIncomeDetail houseincomeDetail) {
		getHouseIncomeDetailList();
		if (houseincomeDetailList == null) houseincomeDetailList = new ArrayList<HouseIncomeDetail>();
		houseincomeDetailList.add(houseincomeDetail);
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
			HouseProperty houseincome = (HouseProperty) content;

			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			if (houseincome.getHouseIncomeDetailList() != null && houseincome.getHouseIncomeDetailList().size() > 0 ){ 
				for (HouseIncomeDetail houseincomeDetail:houseincome.getHouseIncomeDetailList()) {
					if (!houseincomeDetail.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						houseincomeDetail.bindToNode(html); 
					}
				}
			}


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
		//we know the source bean will be CapitalAssetDocument but doesn't hurt to check
		HouseProperty housePropertyDocument = (HouseProperty) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			HouseIncomeDetail source =(HouseIncomeDetail) child;
			addHouseIncomeDetail(source);
		}
		boolean found = false;
		List<HouseIncomeDetail> listOfChildren = getHouseIncomeDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				HouseIncomeDetail destination =(HouseIncomeDetail) o;
				HouseIncomeDetail source  = (HouseIncomeDetail) child;
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
		HouseIncomeDetail source =(HouseIncomeDetail) child;
		addHouseIncomeDetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<HouseIncomeDetail> listOfChildren = getHouseIncomeDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				HouseIncomeDetail destination =(HouseIncomeDetail) o;
				HouseIncomeDetail source  = (HouseIncomeDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			HouseIncomeDetail source =(HouseIncomeDetail) child;
			addHouseIncomeDetail(source);
		}		
	}
}
