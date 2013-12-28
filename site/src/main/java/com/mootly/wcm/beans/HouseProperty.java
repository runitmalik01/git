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
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:houseproperty")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class HouseProperty extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:houseproperty";
	static final public String NODE_NAME = "houseproperty";
	
	final String PROP_DETAIL_BEAN="mootlywcm:houseincomedetail";
	private String itFolderUuid;
	
	private Double rentSec25A;
	private Double arrearRentSec25B;
	private Double total_houseIncome;
	
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
	 public Double getRentSec25A() {
	    	if (rentSec25A == null) rentSec25A = getProperty("mootlywcm:rentSec25A");
	    	return rentSec25A;
	 }
	 public Double getArrearRentSec25B() {
	    	if (arrearRentSec25B == null) arrearRentSec25B = getProperty("mootlywcm:arrearRentSec25B");
	    	return arrearRentSec25B;
	 }
	 public Double getTotal_HouseIncome() {
	    	if (total_houseIncome == null) total_houseIncome = getProperty("mootlywcm:total_houseIncome");
	    	return total_houseIncome;
	 }
	 public final void setRentSec25A(Double rentSec25A) {
			this.rentSec25A = rentSec25A;
		}
	 public final void setArrearRentSec25B(Double arrearRentSec25B) {
			this.arrearRentSec25B = arrearRentSec25B;
		}
	 public final void setTotal_HouseIncome(Double total_houseIncome) {
			this.total_houseIncome = total_houseIncome;
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
			double sum_rentSec25A=0.0d;
			double sum_arrearRentSec25B=0.0d;
			double sum_total_houseIncome=0.0d;
			if (houseincome.getHouseIncomeDetailList() != null && houseincome.getHouseIncomeDetailList().size() > 0 ){ 
				for (HouseIncomeDetail houseincomeDetail:houseincome.getHouseIncomeDetailList()) {
					if (!houseincomeDetail.isMarkedForDeletion()) {
						double value_rentSec25A=houseincomeDetail.getRentSec25A();
						
						double value_arrearRentSec25B=houseincomeDetail.getArrearRentSec25B();
						double value_total_houseIncome=houseincomeDetail.getTotal_houseIncome();
						
						sum_rentSec25A = sum_rentSec25A+value_rentSec25A;
						sum_arrearRentSec25B = sum_arrearRentSec25B+value_arrearRentSec25B;
						sum_total_houseIncome = sum_total_houseIncome+value_total_houseIncome;
						
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						houseincomeDetail.bindToNode(html); 
					}
				}
				setRentSec25A(sum_rentSec25A);
				setArrearRentSec25B(sum_arrearRentSec25B);
				setTotal_HouseIncome(sum_total_houseIncome);
			}
			if (getRentSec25A() != null) node.setProperty("mootlywcm:rentSec25A", getRentSec25A());
			if (getArrearRentSec25B() != null)  node.setProperty("mootlywcm:arrearRentSec25B", getArrearRentSec25B());
			if (getTotal_HouseIncome() != null)  node.setProperty("mootlywcm:total_houseIncome", getTotal_HouseIncome());

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
