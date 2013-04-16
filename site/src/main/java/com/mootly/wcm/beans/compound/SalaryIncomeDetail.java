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
	private String Pan_employer;
	private String Tan_employer;
	private String Address;
	private String City;
	private String State;
	private String Gross_salary;
	private String Allowance;
	private String Perquisite;
	private String Profit;
	private String Employe_category;
	private String Taxable_earning;
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
	public final String getPan_employer() {
		if (Pan_employer == null) Pan_employer = getProperty("mootlywcm:Pan_employer");
		return Pan_employer;
	}
	public final String getTan_employer() {
		if (Tan_employer == null) Tan_employer = getProperty("mootlywcm:Tan_employer");
		return Tan_employer;
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
	public final String getProfit() {
		if (Profit == null) Profit = getProperty("mootlywcm:Profit");
		return Profit;
	}
	public String getPerquisite() {
		if (Perquisite == null) Perquisite = getProperty("mootlywcm:Perquisite");
		return Perquisite;
	}
	
	public final String getAllowance() {
		if (Allowance== null) Allowance = getProperty("mootlywcm:Allowance");
		return Allowance;
	}
	public final String getGross_salary() {
		if (Gross_salary== null) Gross_salary = getProperty("mootlywcm:Gross_salary");
		return Gross_salary;
	}
	public final String getTo() {
		if (To== null) To = getProperty("mootlywcm:To");
		return To;
	}
	public final String getTaxable_earning() {
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
	public final void setPan_employer(String Pan_employer) {
		this.Pan_employer = Pan_employer;
	}
	public final void setTan_employer(String Tan_employer) {
		this.Tan_employer = Tan_employer;
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
	public final void setGross_salary(String Gross_salary) {
		this.Gross_salary = Gross_salary;
	}
	public final void setAllowance(String Allowance) {
		this.Allowance = Allowance;
	}
	public void setPerquisite(String Perquisite) {
		this.Perquisite = Perquisite;
	}
	public void setProfit(String Profit) {
		this.Profit = Profit;
	}
	public void setTaxable_earning(String Taxable_earning) {
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
			node.setProperty("mootlywcm:Address", getAddress());
			node.setProperty("mootlywcm:Profit", getProfit());
			node.setProperty("mootlywcm:Perquisite", getPerquisite());
			if (getPan_employer() != null) {
				node.setProperty("mootlywcm:Pan_employer", getPan_employer());
			}
			if (getTan_employer() != null) {
				node.setProperty("mootlywcm:Tan_employer", getTan_employer());
			}
			node.setProperty("mootlywcm:City", getCity());
			node.setProperty("mootlywcm:State", getState());
			node.setProperty("mootlywcm:Taxable_earning", getTaxable_earning());
			node.setProperty("mootlywcm:To", getTo());
			node.setProperty("mootlywcm:From", getFrom());
			node.setProperty("mootlywcm:Employe_category", getEmploye_category());
			node.setProperty("mootlywcm:Pin", getPin());
			node.setProperty("mootlywcm:Gross_salary", getGross_salary());
			node.setProperty("mootlywcm:Allowance", getAllowance());
			
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
		if ( formMap.getField("Pan_employer") != null) {
			setPan_employer(formMap.getField("Pan_employer").getValue());
		}
		if ( formMap.getField("Tan_employer") != null) {
			setTan_employer(formMap.getField("Tan_employer").getValue());
		}
		if ( formMap.getField("Address") != null) {
			setAddress(formMap.getField("Address").getValue());
		}
		if ( formMap.getField("City") != null) {
			setCity(formMap.getField("City").getValue());
		}
		if ( formMap.getField("State") != null) {
			setState(formMap.getField("State").getValue());
		}
		if ( formMap.getField("Pin") != null) {
			setPin(formMap.getField("Pin").getValue());
		}
		if ( formMap.getField("From") != null) {
			setFrom(formMap.getField("From").getValue());
		}
		if ( formMap.getField("To") != null) {
			setTo(formMap.getField("To").getValue());
		}
		if ( formMap.getField("Gross_salary") != null) {
			setGross_salary(formMap.getField("Gross_salary").getValue());
		}
		if ( formMap.getField("Allowance") != null) {
			setAllowance(formMap.getField("Allowance").getValue());
		}
		if ( formMap.getField("Perquisite") != null) {
			setPerquisite(formMap.getField("Perquisite").getValue());
		}
		if ( formMap.getField("Profit") != null) {
			setProfit(formMap.getField("Profit").getValue());
		}
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		SalaryIncomeDetail salaryIncomeDetail = (SalaryIncomeDetail) sourceBean;
		setEmploye_category(salaryIncomeDetail.getEmploye_category());
		setName_employer(salaryIncomeDetail.getName_employer());
		setPan_employer(salaryIncomeDetail.getPan_employer());
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
	};
}
