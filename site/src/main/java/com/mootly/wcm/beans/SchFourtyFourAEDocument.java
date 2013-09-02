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
import com.mootly.wcm.beans.compound.SchFourtyFourAEDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:schfourtyfouraedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class SchFourtyFourAEDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:schfourtyfouraedocument";
	static final public String NODE_NAME = "schfourtyfouraedocument";
	final String PROP_DETAIL_BEAN="mootlywcm:schfourtyfouraedetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	private Double total_deemedIncome_Heavy;
	private Double total_deemedIncome_Light;
	private final static Logger log = LoggerFactory.getLogger(SchFourtyFourAEDocument.class); 

	private List<SchFourtyFourAEDetail> schFourtyFourDetailList;

	public final List<SchFourtyFourAEDetail> getSchFourtyFourDetailList() {
		if (schFourtyFourDetailList == null) schFourtyFourDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return schFourtyFourDetailList;
	}

	public final void setSchFourtyFourDetailList(List<SchFourtyFourAEDetail> SchFourtyFourAEDetailList) {
		this.schFourtyFourDetailList = SchFourtyFourAEDetailList;
	}
	
	public final void addSchFourtyFourAEDetail(SchFourtyFourAEDetail SchFourtyFourAEDetail) {
		getSchFourtyFourDetailList();
		if (schFourtyFourDetailList == null) schFourtyFourDetailList = new ArrayList<SchFourtyFourAEDetail>();
		schFourtyFourDetailList.add(SchFourtyFourAEDetail);
	}
	   public Double getTotal_deemedIncome_Heavy() {
	    	if (total_deemedIncome_Heavy == null) total_deemedIncome_Heavy = getProperty("mootlywcm:total_deemedIncome_Heavy");
	    	return total_deemedIncome_Heavy;
	 }
	   
	   public final void setTotal_deemedIncome_Heavy(Double total_deemedIncome_Heavy) {
			this.total_deemedIncome_Heavy = total_deemedIncome_Heavy;
		}
	   public Double getTotal_deemedIncome_Light() {
	    	if (total_deemedIncome_Light == null) total_deemedIncome_Light = getProperty("mootlywcm:total_deemedIncome_Light");
	    	return total_deemedIncome_Light;
	 }
	   
	   public final void setTotal_deemedIncome_Light(Double total_deemedIncome_Light) {
			this.total_deemedIncome_Light = total_deemedIncome_Light;
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
			SchFourtyFourAEDocument ofourtyFour = (SchFourtyFourAEDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	 Double sum_deemedIncome_Light=0.0;
        	 Double sum_deemedIncome_Heavy=0.0d;
        	if ( ofourtyFour.getSchFourtyFourDetailList() != null &&  ofourtyFour.getSchFourtyFourDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ ofourtyFour.getSchFourtyFourDetailList().size());
        		
        		for (SchFourtyFourAEDetail objSchFourtyFour:ofourtyFour.getSchFourtyFourDetailList()) {
        		    
        			if (!objSchFourtyFour.isMarkedForDeletion()) {
        				Double val_deemedIncome_Heavy = objSchFourtyFour.getDeemedIncome_Heavy();
        				Double val_deemedIncome_Light = objSchFourtyFour.getDeemedIncome_Light();
        				
        				sum_deemedIncome_Light = sum_deemedIncome_Light + val_deemedIncome_Light;
        				sum_deemedIncome_Heavy = sum_deemedIncome_Heavy + val_deemedIncome_Heavy;
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                objSchFourtyFour.bindToNode(html); 
        			}
        		}
        		setTotal_deemedIncome_Heavy(sum_deemedIncome_Heavy);
        		setTotal_deemedIncome_Light(sum_deemedIncome_Light);
        		
        	}
        	node.setProperty("mootlywcm:total_deemedIncome_Heavy", getTotal_deemedIncome_Heavy());
        	node.setProperty("mootlywcm:total_deemedIncome_Light", getTotal_deemedIncome_Light());
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
		SchFourtyFourAEDocument salaryIncomeDocument = (SchFourtyFourAEDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			SchFourtyFourAEDetail source =(SchFourtyFourAEDetail) child;
			addSchFourtyFourAEDetail(source);
		}
		boolean found = false;
		List<SchFourtyFourAEDetail> listOfChildren = getSchFourtyFourDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				SchFourtyFourAEDetail destination =(SchFourtyFourAEDetail) o;
				SchFourtyFourAEDetail source  = (SchFourtyFourAEDetail) child;
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
		SchFourtyFourAEDetail source =(SchFourtyFourAEDetail) child;
		addSchFourtyFourAEDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<SchFourtyFourAEDetail> listOfChildren = getSchFourtyFourDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				SchFourtyFourAEDetail destination =(SchFourtyFourAEDetail) o;
				SchFourtyFourAEDetail source  = (SchFourtyFourAEDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			SchFourtyFourAEDetail source =(SchFourtyFourAEDetail) child;
			addSchFourtyFourAEDetail(source);
		}		
	}
}
