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

package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.SalaryIncomeDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:houseincomedetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class HouseIncomeDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:houseincomedetail";
	static final public String NODE_NAME = HouseIncomeDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(HouseIncomeDetail.class); 
	private String grossAnnualIncome;
	private String unrealisedRent;
	private String localTaxes;
	private String totalIncome;
	private String interestBorrowed1;
	private String interestBorrowed2;
	private String incomeHproperty;
	private String letout;
	private String personalInfoUuid;


	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	public final String getGrossAnnualIncome() {
		if (grossAnnualIncome == null) grossAnnualIncome = getProperty("mootlywcm:grossAnnualIncome");
		return grossAnnualIncome;
	}
	public final String getUnrealisedRent() {
		if (unrealisedRent == null) unrealisedRent = getProperty("mootlywcm:unrealisedRent");
		return unrealisedRent;
	}
	public final String getLocalTaxes() {
		if (localTaxes == null) localTaxes = getProperty("mootlywcm:localTaxes");
		return localTaxes;
	}
	public final String getTotalIncome() {
		if (totalIncome == null) totalIncome = getProperty("mootlywcm:totalIncome");
		return totalIncome;
	}
	public final String getInterestBorrowed1() {
		if (interestBorrowed1 == null) interestBorrowed1 = getProperty("mootlywcm:interestBorrowed1");
		return interestBorrowed1;
	}
	public final String getInterestBorrowed2() {
		if (interestBorrowed2 == null) interestBorrowed2 = getProperty("mootlywcm:interestBorrowed2");
		return interestBorrowed2;
	}
	public final String getIncomeHproperty() {
		if (incomeHproperty == null) incomeHproperty = getProperty("mootlywcm:incomeHproperty");
		return incomeHproperty;
	}

	public final void setGrossAnnualIncome(String  GrossAnnualIncome) {
		this. grossAnnualIncome =  GrossAnnualIncome;
	}

	public final void setUnrealisedRent(String UnrealisedRent) {
		this.unrealisedRent = UnrealisedRent;
	}

	public final void setLocalTaxes(String LocalTaxes) {
		this.localTaxes = LocalTaxes;
	}

	public final void setTotalIncome(String TotalIncome) {
		this.totalIncome = TotalIncome;
	}
	public final void setInterestBorrowed1(String InterestBorrowed1) {
		this.interestBorrowed1 = InterestBorrowed1;
	}
	public final void setInterestBorrowed2(String InterestBorrowed2) {
		this.interestBorrowed2 = InterestBorrowed2;
	}
	public final void setIncomeHproperty(String IncomeHproperty) {
		this.incomeHproperty = IncomeHproperty;
	}
	public final String getLetOut() {
		if (letout == null) letout = getProperty("mootlywcm:letout");
		return letout;
	}

	public final void setLetOut(String LetOut) {
		this.letout = LetOut;
	}


	//for personal information
	public final String getPersonalInfoUuid() {
		return personalInfoUuid;
	}

	public final void setPersonalInfoUuid(String personalInfoUuid) {
		this.personalInfoUuid = personalInfoUuid;
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

	public boolean bindToNode(javax.jcr.Node node)

			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is bean");
			//HouseProperty memberSignup = (HouseProperty) ;
			node.setProperty("mootlywcm:grossAnnualIncome",getGrossAnnualIncome());
			node.setProperty("mootlywcm:unrealisedRent",getUnrealisedRent());
			node.setProperty("mootlywcm:localTaxes", getLocalTaxes());
			node.setProperty("mootlywcm:totalIncome", getTotalIncome());
			node.setProperty("mootlywcm:interestBorrowed1", getInterestBorrowed1());
			node.setProperty("mootlywcm:interestBorrowed2", getInterestBorrowed2());
			node.setProperty("mootlywcm:incomeHproperty", getIncomeHproperty());
			node.setProperty("mootlywcm:letout", getLetOut());	

		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (formMap == null) return;
		if (formMap.getField("Gross_Annual_Income") != null){
			setGrossAnnualIncome(formMap.getField("Gross_Annual_Income").getValue());
		}
		if (formMap.getField("Unrealised_Rent") != null){
			setUnrealisedRent(formMap.getField("Unrealised_Rent").getValue());
		}
		if (formMap.getField("Local_Taxes") != null){
			setLocalTaxes(formMap.getField("Local_Taxes").getValue());
		}

		if (formMap.getField("Interest_Borrowed2") != null) {
			setInterestBorrowed2(formMap.getField("Interest_Borrowed2").getValue());
		}
		if (formMap.getField("Interest_Borrowed1") != null){
			setInterestBorrowed1(formMap.getField("Interest_Borrowed1").getValue());
		}
		if (formMap.getField("Total_Income") != null){
			setTotalIncome(formMap.getField("Total_Income").getValue());
		}
		if (formMap.getField("Income_Hproperty") != null) {
			setIncomeHproperty(formMap.getField("Income_Hproperty").getValue());
		}
		if (formMap.getField("Let_Out") != null){
			log.info("value"+formMap.getField("Let_Out").getValue());
			setLetOut(formMap.getField("Let_Out").getValue());
		}
	}


	public <T extends HippoBean> void cloneBean(T sourceBean) {
		HouseIncomeDetail objhouseIncomeDetail = (HouseIncomeDetail) sourceBean;

		setGrossAnnualIncome(objhouseIncomeDetail.getGrossAnnualIncome());
		setUnrealisedRent(objhouseIncomeDetail.getUnrealisedRent());
		setLocalTaxes(objhouseIncomeDetail.getLocalTaxes());
		setInterestBorrowed2(objhouseIncomeDetail.getInterestBorrowed2());
		setInterestBorrowed1(objhouseIncomeDetail.getInterestBorrowed1());
		setTotalIncome(objhouseIncomeDetail.getTotalIncome());
		setIncomeHproperty(objhouseIncomeDetail.getIncomeHproperty());
		setIncomeHproperty(objhouseIncomeDetail.getLetOut());
	};
}
