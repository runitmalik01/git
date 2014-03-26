package com.mootly.wcm.services.ditws.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormField;



//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}
public class Twenty26ASTDSOnSalary extends Twenty26ASGenericRecord{
	
	String empCategory;
	String EmployerOrDeductorOrCollecterName;
	String TotalTDSSal;
	String IncChrgSal; //THIS is what we GET from DIT
	String IncChrgSalToBeCopied = "0"; //THIS is what WE COPY to FORM 16 and it will be ALWAYS 0 as there is a confusion between number we get from DIT versus the original 
	String TAN;
	
	String pan_employee;
	String employee;
	String gross_b = "0";
	String gross_c = "0";
	String gross_total;
	String less_total_2 = "0";
	String balance;
	
	String deductions_entertainment = "0";
	String deductions_tax = "0";
	String deductions_total = "0";
	
	String income_chargable_total;
	String relief_2 = "0";
	String ded_ent3 = "0";
	
	String addressdetail;
	String city;
	String state;
	String pin;
	
	String hashOfUniqueKeys;
	
	boolean isPension = false;
	
	
	
	Boolean isImportedFromDIT = true;
	
	static final Logger logger = LoggerFactory.getLogger(Twenty26ASTDSOnSalary.class);

	@FormField(name="Employe_category",propertyName="empCategory",dataTypeValidationTypes={})
	public final String getEmpCategory() {
		return empCategory;
	}

	public final void setEmpCategory(String empCategory) {
		this.empCategory = empCategory;
	}

	@FormField(name="employee",propertyName="employee",dataTypeValidationTypes={})
	public final String getEmployee() {
		return employee;
	}

	public final void setEmployee(String employee) {
		this.employee = employee;
	}

	@FormField(name="employer",propertyName="EmployerOrDeductorOrCollecterName",dataTypeValidationTypes={})
	public final String getEmployerOrDeductorOrCollecterName() {
		return EmployerOrDeductorOrCollecterName;
	}
	
	public final void setEmployerOrDeductorOrCollecterName(
			String employerOrDeductorOrCollecterName) {
		EmployerOrDeductorOrCollecterName = employerOrDeductorOrCollecterName;
	}
	
	@FormField(name="ded_ent1",propertyName="TotalTDSSal",dataTypeValidationTypes={})
	public final String getTotalTDSSal() {
		return TotalTDSSal;
	}
	public final void setTotalTDSSal(String totalTDSSal) {
		TotalTDSSal = totalTDSSal;
	}
	
	
	public final String getIncChrgSal() {
		return IncChrgSal;
	}
	
	@FormField(name="gross_a",propertyName="IncChrgSalToBeCopied",dataTypeValidationTypes={})
	public String getIncChrgSalToBeCopied() {
		return IncChrgSalToBeCopied;
	}
	
	public final void setIncChrgSal(String incChrgSal) {
		IncChrgSal = incChrgSal;
	}
	
	@FormField(name="tan_deductor",propertyName="TAN",dataTypeValidationTypes={})
	public final String getTAN() {
		return TAN;
	}
	public final void setTAN(String tAN) {
		TAN = tAN;
	}
	
	@FormField(name="isImportedFromDIT",propertyName="isImportedFromDIT",dataTypeValidationTypes={})
	public final Boolean getIsImportedFromDIT() {
		return isImportedFromDIT;
	}
	
	public final void setIsImportedFromDIT(Boolean isImportedFromDIT) {
		this.isImportedFromDIT = isImportedFromDIT;
	}

	@FormField(name="pan_employee",propertyName="pan_employee",dataTypeValidationTypes={})
	public final String getPan_employee() {
		return pan_employee;
	}

	@FormField(name="gross_b",propertyName="gross_b",dataTypeValidationTypes={})
	public final String getGross_b() {
		return gross_b;
	}

	@FormField(name="gross_c",propertyName="gross_c",dataTypeValidationTypes={})
	public final String getGross_c() {
		return gross_c;
	}

	@FormField(name="gross_total",propertyName="gross_total",dataTypeValidationTypes={})
	public final String getGross_total() {
		return gross_total;
	}

	@FormField(name="less_total_2",propertyName="less_total_2",dataTypeValidationTypes={})
	public final String getLess_total_2() {
		return less_total_2;
	}
	
	@FormField(name="balance",propertyName="balance",dataTypeValidationTypes={})
	public final String getBalance() {
		return balance;
	}

	@FormField(name="deductions_entertainment",propertyName="deductions_entertainment",dataTypeValidationTypes={})
	public final String getDeductions_entertainment() {
		return deductions_entertainment;
	}

	@FormField(name="deductions_tax",propertyName="deductions_tax",dataTypeValidationTypes={})
	public final String getDeductions_tax() {
		return deductions_tax;
	}

	@FormField(name="deductions_total",propertyName="deductions_total",dataTypeValidationTypes={})
	public final String getDeductions_total() {
		return deductions_total;
	}

	@FormField(name="income_chargable_total",propertyName="income_chargable_total",dataTypeValidationTypes={})
	public final String getIncome_chargable_total() {
		return income_chargable_total;
	}

	@FormField(name="relief_2",propertyName="relief_2",dataTypeValidationTypes={})
	public final String getRelief_2() {
		return relief_2;
	}

	@FormField(name="ded_ent3",propertyName="ded_ent3",dataTypeValidationTypes={})
	public final String getDed_ent3() {
		return ded_ent3;
	}

	@FormField(name="addressdetail",propertyName="addressdetail",dataTypeValidationTypes={})
	public  String getAddressdetail() {
		return addressdetail;
	}
	
	@FormField(name="city",propertyName="city",dataTypeValidationTypes={})
	public  String getCity() {
		return city;
	}
	
	@FormField(name="state",propertyName="state",dataTypeValidationTypes={})
	public  String getState() {
		return state;
	}
	
	@FormField(name="pin",propertyName="pin",dataTypeValidationTypes={})
	public  String getPin() {
		return pin;
	}
	
	public boolean isPension() {
		return isPension;
	}

	public final void setPan_employee(String pan_employee) {
		this.pan_employee = pan_employee;
	}

	public final void setGross_b(String gross_b) {
		this.gross_b = gross_b;
	}

	public final void setGross_c(String gross_c) {
		this.gross_c = gross_c;
	}

	public final void setGross_total(String gross_total) {
		this.gross_total = gross_total;
	}

	public final void setLess_total_2(String less_total_2) {
		this.less_total_2 = less_total_2;
	}

	public final void setBalance(String balance) {
		this.balance = balance;
	}

	public final void setDeductions_entertainment(String deductions_entertainment) {
		this.deductions_entertainment = deductions_entertainment;
	}

	public final void setDeductions_tax(String deductions_tax) {
		this.deductions_tax = deductions_tax;
	}

	public final void setDeductions_total(String deductions_total) {
		this.deductions_total = deductions_total;
	}

	public final void setIncome_chargable_total(String income_chargable_total) {
		this.income_chargable_total = income_chargable_total;
	}

	public final void setRelief_2(String relief_2) {
		this.relief_2 = relief_2;
	}

	public final void setDed_ent3(String ded_ent3) {
		this.ded_ent3 = ded_ent3;
	}

	public void setIncChrgSalToBeCopied(String incChrgSalToBeCopied) {
		IncChrgSalToBeCopied = incChrgSalToBeCopied;
		//this is where we set all other variables
		balance = incChrgSalToBeCopied;
		income_chargable_total = incChrgSalToBeCopied;
		gross_total = incChrgSalToBeCopied;
	}

	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getHashOfUniqueKeys() {
		String input = getTAN() + getEmployerOrDeductorOrCollecterName() + getIncChrgSal() + getTotalTDSSal();
		try {
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	        //Converts message digest value in base 16 (hex) 
	        hashOfUniqueKeys = new BigInteger(1, digest.digest()).toString(16);
	    } 
		catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	     }
		return hashOfUniqueKeys;
	}

	public void setHashOfUniqueKeys(String hashOfUniqueKeys) {
		this.hashOfUniqueKeys = hashOfUniqueKeys;
	}
	
	public void setPension(boolean isPension) {
		this.isPension = isPension;
	}
	
}
