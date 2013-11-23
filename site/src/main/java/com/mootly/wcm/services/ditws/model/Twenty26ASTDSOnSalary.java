package com.mootly.wcm.services.ditws.model;

import com.mootly.wcm.annotations.FormField;



//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}
public class Twenty26ASTDSOnSalary {
	
	String EmployerOrDeductorOrCollecterName;
	String TotalTDSSal;
	String IncChrgSal;
	String TAN;
	Boolean isImportedFromDIT = true;
	
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
	
	@FormField(name="gross_a",propertyName="IncChrgSal",dataTypeValidationTypes={})
	public final String getIncChrgSal() {
		return IncChrgSal;
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

}
