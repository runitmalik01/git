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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
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
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.compound.UnabsorbedDepreciationDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:unabsorbeddepreciationdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class UnabsorbedDepreciationDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:unabsorbeddepreciationdocument";
	static final public String NODE_NAME = "unabsorbeddepreciationdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:unabsorbeddepreciationdetail";
	private String itFolderUuid;

	public String getGross_salary() {
		return "0";
	}
	private Double total_amount;
	private Double total2;
	private Double total3;
	private final static Logger log = LoggerFactory.getLogger(UnabsorbedDepreciationDocument.class); 

	private List<UnabsorbedDepreciationDetail> unabsorbedDepreciationDetailList;

	public final List<UnabsorbedDepreciationDetail> getUnabsorbedDepreciationDetailList() {
		if (unabsorbedDepreciationDetailList == null) unabsorbedDepreciationDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return unabsorbedDepreciationDetailList;
	}

	public final void setUnabsorbedDepreciationDetailList(List<UnabsorbedDepreciationDetail> unabsorbedDepreciationDetailList) {
		this.unabsorbedDepreciationDetailList = unabsorbedDepreciationDetailList;
	}

	public final void addUnabsorbedDepreciationDetail(UnabsorbedDepreciationDetail unabsorbedDepreciationDetail) {
		getUnabsorbedDepreciationDetailList();
		if (unabsorbedDepreciationDetailList == null) unabsorbedDepreciationDetailList = new ArrayList<UnabsorbedDepreciationDetail>();
		unabsorbedDepreciationDetailList.add(unabsorbedDepreciationDetail);
	}
	public Double getTotal_Amount() {
		if (total_amount == null) total_amount = getProperty("mootlywcm:total1");
		return total_amount;
	}

	public final void setTotal_Amount(Double totalamount) {
		this.total_amount = totalamount;
	}

	//new
	public Double getTotal2() {
		if (total2 == null) total2 = getProperty("mootlywcm:total2");
		return total2;
	}

	public final void setTotal2(Double total2) {
		this.total2 = total2;
	}
	public Double getTotal3() {
		if (total3 == null) total3 = getProperty("mootlywcm:total3");
		return total3;
	}

	public final void setTotal3(Double total3) {
		this.total3 = total3;
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
			UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = (UnabsorbedDepreciationDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			double sum=0.0;
			double sum2=0.0d;
			double sum3=0.0d;
			String strSum="";
			if ( unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList() != null &&  unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList().size() > 0 ){ 
				log.info("checking size in salary income bean:::"+ unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList().size());

				for (UnabsorbedDepreciationDetail unabsorbedDepreciationDetail:unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList()) {

					if (!unabsorbedDepreciationDetail.isMarkedForDeletion()) {
						double amount=unabsorbedDepreciationDetail.getAmtUADepreciation();
						double amount2=unabsorbedDepreciationDetail.getAmtDepCurrYear();
						double amount3=unabsorbedDepreciationDetail.getBalanceCarry();
						log.info("value of amount after fetching from compound bean"+amount);
						sum=sum+ amount;
						sum2=sum2+amount2;
						sum3=sum3+amount3;
						// Double sum1= (double) sum;
						//  strSum= BigDecimal.valueOf(sum1).toPlainString();
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						unabsorbedDepreciationDetail.bindToNode(html); 
					}
				}
				setTotal_Amount(sum);
				setTotal2(sum2);
				setTotal3(sum3);
				log.info("value of sum"+strSum);
			}
			node.setProperty("mootlywcm:total1", getTotal_Amount());
			node.setProperty("mootlywcm:total2", getTotal2());
			node.setProperty("mootlywcm:total3", getTotal3());
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
		UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = (UnabsorbedDepreciationDocument) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			UnabsorbedDepreciationDetail source =(UnabsorbedDepreciationDetail) child;
			addUnabsorbedDepreciationDetail(source);
		}
		boolean found = false;
		List<UnabsorbedDepreciationDetail> listOfChildren = getUnabsorbedDepreciationDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				UnabsorbedDepreciationDetail destination =(UnabsorbedDepreciationDetail) o;
				UnabsorbedDepreciationDetail source  = (UnabsorbedDepreciationDetail) child;
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
		UnabsorbedDepreciationDetail source =(UnabsorbedDepreciationDetail) child;
		addUnabsorbedDepreciationDetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<UnabsorbedDepreciationDetail> listOfChildren = getUnabsorbedDepreciationDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				UnabsorbedDepreciationDetail destination =(UnabsorbedDepreciationDetail) o;
				UnabsorbedDepreciationDetail source  = (UnabsorbedDepreciationDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			UnabsorbedDepreciationDetail source =(UnabsorbedDepreciationDetail) child;
			addUnabsorbedDepreciationDetail(source);
		}		
	}
}
