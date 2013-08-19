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
 * User: Pankaj
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */




package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

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
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.member.ITRScheduleSI;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.services.ITRAdditionalScheduleService;
import com.mootly.wcm.utils.ValueListService;
import com.mootly.wcm.utils.ValueListServiceImpl;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:capitalassetdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class CapitalAssetDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate,ITRAdditionalScheduleService {
	static final public String NAMESPACE = "mootlywcm:capitalassetdocument";
	static final public String NODE_NAME = "capitalassetdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:capitalassetdetail";
	private String itFolderUuid;

	public String getGross_salary() {
		return "0";
	}

	private final static Logger log = LoggerFactory.getLogger(CapitalAssetDocument.class); 

	private List<CapitalAssetDetail> capitalassetDetailList;
	String capital_gain;

	public final List<CapitalAssetDetail> getCapitalAssetDetailList() {
		if (capitalassetDetailList == null) capitalassetDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return capitalassetDetailList;
	}

	public final void setCapitalAssetDetailList(List<CapitalAssetDetail> capitalassetDetailList) {
		this.capitalassetDetailList = capitalassetDetailList;
	}

	public final void addCapitalAssetDetail(CapitalAssetDetail capitalAssetDetail) {
		getCapitalAssetDetailList();
		if (capitalassetDetailList == null) capitalassetDetailList = new ArrayList<CapitalAssetDetail>();
		capitalassetDetailList.add(capitalAssetDetail);
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
			CapitalAssetDocument capitalasset = (CapitalAssetDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			if (capitalasset.getCapitalAssetDetailList() != null && capitalasset.getCapitalAssetDetailList().size() > 0 ){ 
			for (CapitalAssetDetail capitalAssetDetail:capitalasset.getCapitalAssetDetailList()) {
				if (!capitalAssetDetail.isMarkedForDeletion()) {
					javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
					capitalAssetDetail.bindToNode(html); 
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
			prdLinkNode.setProperty("hippo:docbase", capitalasset.getPersonalInfoUuid());
		 */

		catch (RepositoryException rex) {
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
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			CapitalAssetDetail source =(CapitalAssetDetail) child;
			addCapitalAssetDetail(source);
		}
		boolean found = false;
		List<CapitalAssetDetail> listOfChildren = getCapitalAssetDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				log.info("UUID:::"+o.getCanonicalUUID());
				CapitalAssetDetail destination =(CapitalAssetDetail) o;
				CapitalAssetDetail source  = (CapitalAssetDetail) child;
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
		CapitalAssetDetail source =(CapitalAssetDetail) child;
		addCapitalAssetDetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<CapitalAssetDetail> listOfChildren = getCapitalAssetDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				CapitalAssetDetail destination =(CapitalAssetDetail) o;
				CapitalAssetDetail source  = (CapitalAssetDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			CapitalAssetDetail source =(CapitalAssetDetail) child;
			addCapitalAssetDetail(source);
		}		
	}

	@Override
	public Map<String, Map<String, Object>> getScheduleSIService(FinancialYear financialYear, Map<String ,HippoBean> inputBean) {
		// TODO Auto-generated method stub
		Map<String, Map<String, Object>> resultScheduleSISection = new HashMap<String, Map<String, Object>>();
		List<ITRScheduleSISections> scheduleSISection = new ArrayList<ITRScheduleSISections>();
		scheduleSISection = ITRScheduleSISections.getListOfSISection(CapitalAssetDocument.class.getSimpleName());
		for(ITRScheduleSISections si:scheduleSISection){
			Map<String, Object> resultMap = ITRScheduleSI.updateScheduleSI(financialYear, si, inputBean);
			resultScheduleSISection.put(si.getXmlCode(), resultMap);
		}
		return resultScheduleSISection;
	}
}
