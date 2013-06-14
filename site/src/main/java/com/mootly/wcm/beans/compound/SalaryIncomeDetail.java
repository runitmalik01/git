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
import com.mootly.wcm.beans.SalaryIncomeDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:salaryincomedetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class SalaryIncomeDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:salaryincomedetail";
	static final public String NODE_NAME = SalaryIncomeDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(SalaryIncomeDocument.class); 
	private String Name_employer;
	private String Name_employee;
	private String Pan_employer;
	private String Pan_employee;
	private String Tan_employer;
	private String Address;
	private String City;
	private String State;
	private Double Gross_salary;
	private Double Allowance;
	private Double Perquisite;
	private Double profit;
	private String Employe_category;
	private Double Taxable_earning;
	private String from;
	private String To;
	private String From;
	private String state;
	private String Pin;
	private String personalInfoUuid;

	private boolean markedForDeletion;

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information
	public final String getName_employer() {
		if (Name_employer == null) Name_employer = getProperty("mootlywcm:Name_employer");
		return Name_employer;
	}
	public final String getName_employee() {
		if (Name_employee == null) Name_employee = getProperty("mootlywcm:Name_employee");
		return Name_employee;
	}
	public final String getPan_employer() {
		if (Pan_employer == null) Pan_employer = getProperty("mootlywcm:Pan_employer");
		return Pan_employer;
	}
	public final String getTan_employer() {
		if (Tan_employer == null) Tan_employer = getProperty("mootlywcm:Tan_employer");
		return Tan_employer;
	}
	public final String getPan_employee() {
		if (Pan_employee == null) Pan_employee = getProperty("mootlywcm:Pan_employee");
		return Pan_employee;
	}
	public final String getAddress() {
		if (Address == null) Address = getProperty("mootlywcm:Address");
		return Address;
	}
	public final String getCity() {
		if (City == null) City = getProperty("mootlywcm:City");
		return City;
	}
	public final String getState() {
		if (State == null) State = getProperty("mootlywcm:State");
		return State;
	}
	public final Double getProfit() {
		if (profit == null) profit = getProperty("mootlywcm:Profit");
		return profit;
	}
	public Double getPerquisite() {
		if (Perquisite == null) Perquisite = getProperty("mootlywcm:Perquisite");
		return Perquisite;
	}

	public final Double getAllowance() {
		if (Allowance== null) Allowance = getProperty("mootlywcm:Allowance");
		return Allowance;
	}
	public final Double getGross_salary() {
		if (Gross_salary== null) Gross_salary = getProperty("mootlywcm:Gross_salary");
		return Gross_salary;
	}
	public final String getTo() {
		if (To== null) To = getProperty("mootlywcm:To");
		return To;
	}
	public final Double getTaxable_earning() {
		if (Taxable_earning== null) Taxable_earning = getProperty("mootlywcm:Taxable_earning");
		return Taxable_earning;
	}
	public final String getFrom() {
		if (From== null) From = getProperty("mootlywcm:From");
		return From;
	}
	public final String getPin() {
		if (Pin== null) Pin = getProperty("mootlywcm:Pin");
		return Pin;
	}
	public final String getEmploye_category() {
		if (Employe_category== null) Employe_category = getProperty("mootlywcm:Employe_category");
		return Employe_category;
	}


	public final void setName_employer(String Name_employer) {
		this.Name_employer = Name_employer;
	}
	public final void setName_employee(String Name_employee) {
		this.Name_employee = Name_employee;
	}
	public final void setPan_employer(String Pan_employer) {
		this.Pan_employer = Pan_employer;
	}
	public final void setTan_employer(String Tan_employer) {
		this.Tan_employer = Tan_employer;
	}
	public final void setPan_employee(String Pan_employee) {
		this.Pan_employee = Pan_employee;
	}
	public final void setCity(String City) {
		this.City = City;
	}
	public final void setAddress(String Address) {
		this.Address = Address;
	}
	public final void setState(String State) {
		this.State = State;
	}
	public final void setPin(String Pin) {
		this.Pin = Pin;
	}
	public void setFrom(String From) {
		this.From = From;
	}
	public void setTo(String To) {
		this.To = To;
	}
	public void setEmploye_category(String Employe_category) {
		this.Employe_category = Employe_category;
	}
	public final void setGross_salary(Double Gross_salary) {
		this.Gross_salary = Gross_salary;
	}
	public final void setAllowance(Double Allowance) {
		this.Allowance = Allowance;
	}
	public void setPerquisite(Double Perquisite) {
		this.Perquisite = Perquisite;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	public void setTaxable_earning(Double Taxable_earning) {
		this.Taxable_earning = Taxable_earning;
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
			node.setProperty("mootlywcm:Name_employer", getName_employer());
			node.setProperty("mootlywcm:Name_employee", getName_employee());
			node.setProperty("mootlywcm:Address", getAddress());
			if (getProfit()!=null) {
				node.setProperty("mootlywcm:Profit", getProfit());
			}
			if(getPerquisite()!=null){
				node.setProperty("mootlywcm:Perquisite", getPerquisite());
			}
			if (getPan_employer() != null) {
				node.setProperty("mootlywcm:Pan_employer", getPan_employer());
			}
			if (getPan_employee() != null) {
				node.setProperty("mootlywcm:Pan_employee", getPan_employee());
			}
			if (getTan_employer() != null) {
				node.setProperty("mootlywcm:Tan_employer", getTan_employer());
			}
			node.setProperty("mootlywcm:City", getCity());
			node.setProperty("mootlywcm:State", getState());
			if(getTaxable_earning()!=null){
				node.setProperty("mootlywcm:Taxable_earning", getTaxable_earning());
			}
			node.setProperty("mootlywcm:To", getTo());
			node.setProperty("mootlywcm:From", getFrom());
			node.setProperty("mootlywcm:Employe_category", getEmploye_category());
			node.setProperty("mootlywcm:Pin", getPin());
			if(getGross_salary()!=null){
				node.setProperty("mootlywcm:Gross_salary", getGross_salary());
			}
			if(getAllowance()!=null){
				node.setProperty("mootlywcm:Allowance", getAllowance());
			}

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;

		if ( formMap.getField("Employe_category") != null) {
			setEmploye_category(formMap.getField("Employe_category").getValue());
		}
		if ( formMap.getField("Name_employer") != null) {
			setName_employer(formMap.getField("Name_employer").getValue());
		}
		if ( formMap.getField("Name_employee") != null) {
			setName_employee(formMap.getField("Name_employee").getValue());
		}
		if ( formMap.getField("Pan_employer") != null) {
			setPan_employer(formMap.getField("Pan_employer").getValue());
		}
		if ( formMap.getField("Tan_employer") != null) {
			setTan_employer(formMap.getField("Tan_employer").getValue());
		}
		if ( formMap.getField("Pan_employee") != null) {
			setPan_employee(formMap.getField("Pan_employee").getValue());
		}
		if ( formMap.getField("Addressslry") != null) {
			setAddress(formMap.getField("Addressslry").getValue());
		}
		if ( formMap.getField("Cityslry") != null) {
			setCity(formMap.getField("Cityslry").getValue());
		}
		if ( formMap.getField("Stateslry") != null) {
			setState(formMap.getField("Stateslry").getValue());
		}
		if ( formMap.getField("Taxable_earning").getValue().isEmpty()) {}
		else{
			String strEarning=formMap.getField("Taxable_earning").getValue();
			double taxableEarning = Double.parseDouble(strEarning);
			setTaxable_earning(taxableEarning);

		}
		if ( formMap.getField("Pinslry") != null) {
			setPin(formMap.getField("Pinslry").getValue());
		}
		if ( formMap.getField("From") != null) {
			setFrom(formMap.getField("From").getValue());
		}
		if ( formMap.getField("To") != null) {
			setTo(formMap.getField("To").getValue());
		}
		if ( formMap.getField("Gross_salary").getValue().isEmpty()) {}
		else{
			String strGross_salary = formMap.getField("Gross_salary").getValue();
			double amt = Double.parseDouble(strGross_salary);
			setGross_salary(amt);
		}
		if ( formMap.getField("Allowance").getValue().isEmpty()) {}
		else{
			String strAllowance = formMap.getField("Allowance").getValue();
			double amt = Double.parseDouble(strAllowance);
			setAllowance(amt);
		}
		if ( formMap.getField("Perquisite").getValue().isEmpty()) {}
		else{
			String strPerquisite = formMap.getField("Perquisite").getValue();
			double amt = Double.parseDouble(strPerquisite);
			setPerquisite(amt);
		}
		if ( formMap.getField("profit").getValue().isEmpty()) {}
		else{
			String strProfit = formMap.getField("profit").getValue();
			double amt = Double.parseDouble(strProfit);
			setProfit(amt);
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		SalaryIncomeDetail salaryIncomeDetail = (SalaryIncomeDetail) sourceBean;
		setEmploye_category(salaryIncomeDetail.getEmploye_category());
		setName_employer(salaryIncomeDetail.getName_employer());
		setName_employee(salaryIncomeDetail.getName_employee());
		setPan_employer(salaryIncomeDetail.getPan_employer());
		setPan_employee(salaryIncomeDetail.getPan_employee());
		setTan_employer(salaryIncomeDetail.getTan_employer());
		setAddress(salaryIncomeDetail.getAddress());
		setCity(salaryIncomeDetail.getCity());
		setState(salaryIncomeDetail.getState());
		setPin(salaryIncomeDetail.getPin());
		setFrom(salaryIncomeDetail.getFrom());
		setTo(salaryIncomeDetail.getTo());
		setGross_salary(salaryIncomeDetail.getGross_salary());
		setAllowance(salaryIncomeDetail.getAllowance());
		setPerquisite(salaryIncomeDetail.getPerquisite());
		setProfit(salaryIncomeDetail.getProfit());
		setTaxable_earning(salaryIncomeDetail.getTaxable_earning());
	};
}
