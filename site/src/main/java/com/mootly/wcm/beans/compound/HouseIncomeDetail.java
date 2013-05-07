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
 * User: megha
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


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:houseincomedetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class HouseIncomeDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:houseincomedetail";
	static final public String NODE_NAME = HouseIncomeDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(HouseIncomeDetail.class); 
	private String Address;
	private String Tenant_pan;
	private String Pin;
	private String Tenant_name;
	private String share1;
	private String share2;
	private String share3;
	private String share4;
	private String share5;
	private String coownerpan1;
	private String coownername1;
	private String coownerpan2;
	private String coownername2;
	private String coownerpan3;
	private String coownername3;
	private String coownerpan4;
	private String coownername4;
	private String coownerpan5;
	private String coownername5;
	private String City;
	private String states;
	private String Coowned;
	private String letout;
	private Double Letable_value;
	private Double Unrealised_rent;
	private Double Local_tax;
	private Double Total;
	private Double Balance;
	private Double Interest_borrowed;
	private Double Income_hproperty;
	private String personalInfoUuid;
	private String Property_share;

	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	public final String getAddress() {
		if (Address == null) Address = getProperty("mootlywcm:Address");
		return Address;
	}
	public final String getTenant_pan() {
		if (Tenant_pan == null) Tenant_pan = getProperty("mootlywcm:Tenant_pan");
		return Tenant_pan;
	}
	public final String getPin() {
		if (Pin == null) Pin = getProperty("mootlywcm:Pin");
		return Pin;
	}
	public final String getTenant_name() {
		if (Tenant_name == null) Tenant_name = getProperty("mootlywcm:Tenant_name");
		return Tenant_name;
	}
	public final String getShare1() {
		if (share1 == null) share1 = getProperty("mootlywcm:Share1");
		return share1;
	}
	public final String getCoownerpan1() {
		if (coownerpan1 == null) coownerpan1 = getProperty("mootlywcm:Coowner_pan1");
		return coownerpan1;
	}
	public final String getCoownername1() {
		if (coownername1 == null) coownername1 = getProperty("mootlywcm:Coowner_name1");
		return coownername1;
	}
	public final String getShare2() {
		if (share1 == null) share1 = getProperty("mootlywcm:Share1");
		return share1;
	}
	public final String getCoownerpan2() {
		if (coownerpan1 == null) coownerpan1 = getProperty("mootlywcm:Coowner_pan1");
		return coownerpan1;
	}
	public final String getCoownername2() {
		if (coownername1 == null) coownername1 = getProperty("mootlywcm:Coowner_name1");
		return coownername1;
	}
	public final String getShare3() {
		if (share1 == null) share1 = getProperty("mootlywcm:Share1");
		return share1;
	}
	public final String getCoownerpan3() {
		if (coownerpan1 == null) coownerpan1 = getProperty("mootlywcm:Coowner_pan1");
		return coownerpan1;
	}
	public final String getCoownername3() {
		if (coownername1 == null) coownername1 = getProperty("mootlywcm:Coowner_name1");
		return coownername1;
	}
	public final String getShare4() {
		if (share1 == null) share1 = getProperty("mootlywcm:Share1");
		return share1;
	}
	public final String getCoownerpan4() {
		if (coownerpan1 == null) coownerpan1 = getProperty("mootlywcm:Coowner_pan1");
		return coownerpan1;
	}
	public final String getCoownername4() {
		if (coownername1 == null) coownername1 = getProperty("mootlywcm:Coowner_name1");
		return coownername1;
	}
	public final String getShare5() {
		if (share1 == null) share1 = getProperty("mootlywcm:Share1");
		return share1;
	}
	public final String getCoownerpan5() {
		if (coownerpan1 == null) coownerpan1 = getProperty("mootlywcm:Coowner_pan1");
		return coownerpan1;
	}
	public final String getCoownername5() {
		if (coownername1 == null) coownername1 = getProperty("mootlywcm:Coowner_name1");
		return coownername1;
	}
	public final String getCity() {
		if (City == null) City = getProperty("mootlywcm:City");
		return City;
	}
	public final String getStates() {
		if (states == null) states = getProperty("mootlywcm:State");
		return states;
	}
	public final String getCoowned() {
		if (Coowned == null) Coowned = getProperty("mootlywcm:Coowned");
		return Coowned;
	}
	public final Double getLetable_value() {
		if (Letable_value == null) Letable_value = getProperty("mootlywcm:Letable_value");
		return Letable_value;
	}
	public final Double getUnrealised_rent() {
		if (Unrealised_rent == null) Unrealised_rent = getProperty("mootlywcm:Unrealised_rent");
		return Unrealised_rent;
	}
	public final Double getLocal_tax() {
		if (Local_tax == null) Local_tax = getProperty("mootlywcm:Local_tax");
		return Local_tax;
	}
	public final Double getTotal() {
		if (Total == null) Total = getProperty("mootlywcm:Total");
		return Total;
	}
	public final Double getBalance() {
		if (Balance == null) Balance = getProperty("mootlywcm:Balance");
		return Balance;
	}
	public final Double getInterest_borrowed() {
		if (Interest_borrowed == null) Interest_borrowed = getProperty("mootlywcm:Interest_borrowed");
		return Interest_borrowed;
	}
	public final Double getIncome_hproperty() {
		if (Income_hproperty == null) Income_hproperty = getProperty("mootlywcm:Income_hproperty");
		return Income_hproperty;
	}
	public final String getProperty_share() {
		if (Property_share == null) Property_share = getProperty("mootlywcm:Property_share");
		return Property_share;
	}


	public final void setAddress(String  Address) {
		this.Address =  Address;
	}

	public final void setTenant_pan(String Tenant_pan) {
		this.Tenant_pan = Tenant_pan;
	}

	public final void setPin(String Pin) {
		this.Pin = Pin;
	}

	public final void setTenant_name(String Tenant_name) {
		this.Tenant_name = Tenant_name;
	}
	public final void setShare1(String share1) {
		this.share1 = share1;
	}
	public final void setCoownerpan1(String coownerpan1) {
		this.coownerpan1 = coownerpan1;
	}
	public final void setCoownername1(String coownername1) {
		this.coownername1 = coownername1;
	}
	public final void setShare2(String share2) {
		this.share2 = share2;
	}
	public final void setCoownerpan2(String coownerpan2) {
		this.coownerpan2 = coownerpan2;
	}
	public final void setCoownername2(String coownername2) {
		this.coownername2 = coownername2;
	}
	public final void setShare3(String share3) {
		this.share3 = share3;
	}
	public final void setCoownerpan3(String coownerpan3) {
		this.coownerpan3 = coownerpan3;
	}
	public final void setCoownername3(String coownername3) {
		this.coownername3 = coownername3;
	}
	public final void setShare4(String share4) {
		this.share4 = share4;
	}
	public final void setCoownerpan4(String coownerpan4) {
		this.coownerpan4 = coownerpan4;
	}
	public final void setCoownername4(String coownername4) {
		this.coownername4 = coownername4;
	}
	public final void setShare5(String share5) {
		this.share5 = share5;
	}
	public final void setCoownerpan5(String coownerpan5) {
		this.coownerpan5 = coownerpan5;
	}
	public final void setCoownername5(String coownername5) {
		this.coownername5 = coownername5;
	}
	public final void setCity(String City) {
		this.City = City;
	}
	public final void setStates(String states) {
		this.states = states;
	}
	public final void setCoowned(String Coowned) {
		this.Coowned = Coowned;
	}
	public final void setLetable_value(Double Letable_value) {
		this.Letable_value = Letable_value;
	}
	public final void setUnrealised_rent(Double Unrealised_rent) {
		this.Unrealised_rent = Unrealised_rent;
	}
	public final void setLocal_tax(Double Local_tax) {
		this.Local_tax = Local_tax;
	}
	public final void setTotal(Double Total) {
		this.Total = Total;
	}
	public final void setBalance(Double Balance) {
		this.Balance = Balance;
	}
	public final void setInterest_borrowed(Double Interest_borrowed) {
		this.Interest_borrowed = Interest_borrowed;
	}
	public final void setIncome_hproperty(Double Income_hproperty) {
		this.Income_hproperty = Income_hproperty;
	}
	public final void setProperty_share(String Property_share) {
		this.Property_share = Property_share;
	}

	public final String getLetOut() {
		if (letout == null) letout = getProperty("mootlywcm:letout");
		return letout;
	}

	public final void setLetOut(String letout) {
		this.letout = letout;
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
			node.setProperty("mootlywcm:Address",getAddress());
			node.setProperty("mootlywcm:Tenant_pan",getTenant_pan());
			node.setProperty("mootlywcm:Pin", getPin());
			node.setProperty("mootlywcm:Tenant_name", getTenant_name());
			node.setProperty("mootlywcm:Share1", getShare1());
			node.setProperty("mootlywcm:Coowner_pan1", getCoownerpan1());
			node.setProperty("mootlywcm:Coowner_name1", getCoownername1());
			node.setProperty("mootlywcm:Share2", getShare2());
			node.setProperty("mootlywcm:Coowner_pan2", getCoownerpan2());
			node.setProperty("mootlywcm:Coowner_name2", getCoownername2());
			node.setProperty("mootlywcm:Share3", getShare3());
			node.setProperty("mootlywcm:Coowner_pan3", getCoownerpan3());
			node.setProperty("mootlywcm:Coowner_name3", getCoownername3());
			node.setProperty("mootlywcm:Share4", getShare4());
			node.setProperty("mootlywcm:Coowner_pan4", getCoownerpan4());
			node.setProperty("mootlywcm:Coowner_name4", getCoownername4());
			node.setProperty("mootlywcm:Share5", getShare5());
			node.setProperty("mootlywcm:Coowner_pan5", getCoownerpan5());
			node.setProperty("mootlywcm:Coowner_name5", getCoownername5());
			node.setProperty("mootlywcm:City", getCity());
			node.setProperty("mootlywcm:State", getStates());	
			node.setProperty("mootlywcm:Coowned", getCoowned());	
			node.setProperty("mootlywcm:letout", getLetOut());	
			node.setProperty("mootlywcm:Letable_value", getLetable_value());	
			node.setProperty("mootlywcm:Unrealised_rent", getUnrealised_rent());	
			node.setProperty("mootlywcm:Local_tax", getLocal_tax());	
			node.setProperty("mootlywcm:Total", getTotal());
			node.setProperty("mootlywcm:Balance", getBalance());
			node.setProperty("mootlywcm:Interest_borrowed", getInterest_borrowed());
			node.setProperty("mootlywcm:Income_hproperty", getIncome_hproperty());	
			node.setProperty("mootlywcm:Property_share", getProperty_share());	

		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		Double amt=0.0;
		Double amt1=0.0;
		Double amt2=0.0;
		Double amt3=0.0;
		Double amt4=0.0;
		Double amt5=0.0;
		Double amt6=0.0;
		if (formMap.getField("Address") != null){
			setAddress(formMap.getField("Address").getValue());
			log.info("valuye of add"+formMap.getField("Address").getValue());
		}
		if (formMap.getField("Tenant_pan") != null){
			setTenant_pan(formMap.getField("Tenant_pan").getValue());
			log.info("valuye of tepan"+formMap.getField("Tenant_pan").getValue());
		}
		if (formMap.getField("Pin") != null){
			setPin(formMap.getField("Pin").getValue());
		}

		if (formMap.getField("Tenant_name") != null) {
			setTenant_name(formMap.getField("Tenant_name").getValue());
			log.info("valuye of tename"+formMap.getField("Tenant_name").getValue());
		}
		if (formMap.getField("share1") != null){
			setShare1(formMap.getField("share1").getValue());
			log.info("valuye of share1"+formMap.getField("share1").getValue());
		}
		if (formMap.getField("coownerpan1") != null){
			setCoownerpan1(formMap.getField("coownerpan1").getValue());
			log.info("valuye of copan1"+formMap.getField("coownerpan1").getValue());
		}
		if (formMap.getField("coownername1") != null){
			setCoownername1(formMap.getField("coownername1").getValue());
			log.info("valuye of coname1"+formMap.getField("coownername1").getValue());
		}
		if (formMap.getField("share2") != null){
			setShare2(formMap.getField("share2").getValue());
		}
		if (formMap.getField("coownerpan2") != null){
			setCoownerpan2(formMap.getField("coownerpan2").getValue());
		}
		if (formMap.getField("coownername2") != null){
			setCoownername2(formMap.getField("coownername2").getValue());
		}
		if (formMap.getField("share3") != null){
			setShare3(formMap.getField("share3").getValue());
		}
		if (formMap.getField("coownerpan3") != null){
			setCoownerpan3(formMap.getField("coownerpan3").getValue());
		}
		if (formMap.getField("coownername3") != null){
			setCoownername3(formMap.getField("coownername3").getValue());
		}
		if (formMap.getField("share4") != null){
			setShare4(formMap.getField("share4").getValue());
		}
		if (formMap.getField("coownerpan4") != null){
			setCoownerpan4(formMap.getField("coownerpan4").getValue());
		}
		if (formMap.getField("coownername4") != null){
			setCoownername4(formMap.getField("coownername4").getValue());
		}
		if (formMap.getField("share5") != null){
			setShare5(formMap.getField("share5").getValue());
		}
		if (formMap.getField("coownerpan5") != null){
			setCoownerpan5(formMap.getField("coownerpan5").getValue());
			log.info("valuye of copan5"+formMap.getField("coownerpan5").getValue());
		}
		if (formMap.getField("coownername5") != null){
			setCoownername5(formMap.getField("coownername5").getValue());
			log.info("valuye of coownername5"+formMap.getField("coownername5").getValue());
		}
		if (formMap.getField("City") != null) {
			setCity(formMap.getField("City").getValue());
			log.info("valuye of city"+formMap.getField("City").getValue());
		}
		if (formMap.getField("states") != null) {
			setStates(formMap.getField("states").getValue());
			log.info("valuye of state"+formMap.getField("states").getValue());
		}
		if (formMap.getField("Coowned") != null) {
			setCoowned(formMap.getField("Coowned").getValue());
			log.info("valuye of coown"+formMap.getField("Coowned").getValue());
		}
		if (formMap.getField("Letable_value") != null) {
			String strlet_val= formMap.getField("Letable_value").getValue();
			if(!(strlet_val.isEmpty())){
				amt=Double.parseDouble(strlet_val);
				log.info("amt inside if loop "+amt);
			}else {
				amt=0.0;
				log.info("amt inside else loop "+amt);
			}
			log.info("value after all is"+amt);
			setLetable_value(amt);
		}
		if (formMap.getField("Unrealised_rent") != null) {
			String strunreal_rent=(formMap.getField("Unrealised_rent").getValue());
			if(!(strunreal_rent.isEmpty())){
				amt1=Double.parseDouble(strunreal_rent);
				log.info("value of amt1 is"+amt1);
			}
			else {
				amt1=0.0;
				log.info("amt inside else loop "+amt1);

			}setUnrealised_rent(amt1);
		}


		if (formMap.getField("Local_tax")!= null) {
			String strloc_tax=(formMap.getField("Local_tax").getValue());
			if(!(strloc_tax.isEmpty())){
				amt2=Double.parseDouble(strloc_tax);
				log.info("value of amt2 is"+amt2);
			}else {

				amt2=0.0;
			}log.info("value after all is"+amt2);
			setLocal_tax(amt2);
		} 

		if (formMap.getField("Total")!= null) {
			String strtot=(formMap.getField("Total").getValue());
			if(!(strtot.isEmpty())){
				amt3=Double.parseDouble(strtot);
				log.info("value of amt3 is"+amt3);
			}
			else {
				amt3=0.0;
			}log.info("value after all is"+amt3);
			setTotal(amt3);

		}
		if (formMap.getField("Balance")!= null) {
			String strbal=(formMap.getField("Balance").getValue());
			if(!(strbal.isEmpty())){
				amt4=Double.parseDouble(strbal);
				log.info("value of amt4 is"+amt4);
			}
			else {
				amt4=0.0;
			}log.info("value after all is"+amt4);
			setBalance(amt4);

		}
		if (formMap.getField("Interest_borrowed")!= null) {
			String strintb=(formMap.getField("Interest_borrowed").getValue());
			if(!(strintb.isEmpty())){
				amt5=Double.parseDouble(strintb);
				log.info("value of amt5 is"+amt5);
			}
			else {
				amt5=0.0;
			}log.info("value after all is"+amt5);
			setInterest_borrowed(amt5);

		}
		if (formMap.getField("Income_hproperty")!= null) {
			String strincome=(formMap.getField("Income_hproperty").getValue());
			if(!(strincome.isEmpty())){
				amt6=Double.parseDouble(strincome);
				log.info("value of amt6 is"+amt6);
			}else {
				amt6=0.0;
			}log.info("value after all is"+amt6);
			setIncome_hproperty(amt6);
		} 

		if (formMap.getField("Property_share") != null) {
			setProperty_share(formMap.getField("Property_share").getValue());
		}
		if (formMap.getField("letout") != null){
			log.info("value"+formMap.getField("letout").getValue());
			setLetOut(formMap.getField("letout").getValue());
		}
	}


	public <T extends HippoBean> void cloneBean(T sourceBean) {
		HouseIncomeDetail objhouseIncomeDetail = (HouseIncomeDetail) sourceBean;

		setAddress(objhouseIncomeDetail.getAddress());
		setTenant_pan(objhouseIncomeDetail.getTenant_pan());
		setPin(objhouseIncomeDetail.getPin());
		setTenant_name(objhouseIncomeDetail.getTenant_name());
		setShare1(objhouseIncomeDetail.getShare1());
		setCoownerpan1(objhouseIncomeDetail.getCoownerpan1());
		setCoownername1(objhouseIncomeDetail.getCoownername1());
		setShare2(objhouseIncomeDetail.getShare2());
		setCoownerpan2(objhouseIncomeDetail.getCoownerpan2());
		setCoownername2(objhouseIncomeDetail.getCoownername2());
		setShare3(objhouseIncomeDetail.getShare3());
		setCoownerpan3(objhouseIncomeDetail.getCoownerpan3());
		setCoownername3(objhouseIncomeDetail.getCoownername3());
		setShare4(objhouseIncomeDetail.getShare4());
		setCoownerpan4(objhouseIncomeDetail.getCoownerpan4());
		setCoownername4(objhouseIncomeDetail.getCoownername4());
		setShare5(objhouseIncomeDetail.getShare5());
		setCoownerpan5(objhouseIncomeDetail.getCoownerpan5());
		setCoownername5(objhouseIncomeDetail.getCoownername5());
		setCity(objhouseIncomeDetail.getCity());
		setLetOut(objhouseIncomeDetail.getLetOut());
		setStates(objhouseIncomeDetail.getStates());
		setCoowned(objhouseIncomeDetail.getCoowned());
		setLetable_value(objhouseIncomeDetail.getLetable_value());
		setUnrealised_rent(objhouseIncomeDetail.getUnrealised_rent());
		setLocal_tax(objhouseIncomeDetail.getLocal_tax());
		setTotal(objhouseIncomeDetail.getTotal());
		setBalance(objhouseIncomeDetail.getBalance());
		setInterest_borrowed(objhouseIncomeDetail.getInterest_borrowed());
		setIncome_hproperty(objhouseIncomeDetail.getIncome_hproperty());
		setProperty_share(objhouseIncomeDetail.getProperty_share());
		
	};
}
