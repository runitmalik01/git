package com.mootly.wcm.services.ditws.model;

import com.mootly.wcm.annotations.FormField;

public class Twenty26ASAdvanceTaxPayment extends Twenty26ASGenericRecord{
	
	//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
	//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
	//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
	//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}
	
	String Amt;
	String SrlNoOfChaln;
	String BSRCode;
	String DateDep;
	String isImported = "true";	
	Boolean isImportedFromDIT = true;
	
	public Twenty26ASAdvanceTaxPayment() {
		
	}
	
	public Twenty26ASAdvanceTaxPayment(String Amt,String SrlNoOfChaln,String BSRCode,String DateDep) {
		this.Amt = Amt;
		this.SrlNoOfChaln = SrlNoOfChaln;
		this.BSRCode = BSRCode;
		this.DateDep = DateDep;
	}
	
	@FormField(name="amountadv",propertyName="Amt", dataTypeValidationTypes={})
	public final String getAmt() {
		return Amt;
	}
	public final void setAmt(String amt) {
		Amt = amt;
	}
	
	@FormField(name="Serial_challanadv",propertyName="SrlNoOfChaln",dataTypeValidationTypes={})
	public final String getSrlNoOfChaln() {
		return SrlNoOfChaln;
	}
	public final void setSrlNoOfChaln(String srlNoOfChaln) {
		SrlNoOfChaln = srlNoOfChaln;
	}
	
	@FormField(name="bsr_codeadv",propertyName="BSRCode",dataTypeValidationTypes={})
	public final String getBSRCode() {
		return BSRCode;
	}
	public final void setBSRCode(String bSRCode) {
		BSRCode = bSRCode;
	}
	@FormField(name="date_creditadv",propertyName="DateDep", dataTypeValidationTypes={})
	public final String getDateDep() {
		return DateDep;
	}
	public final void setDateDep(String dateDep) {
		DateDep = dateDep;
	}
	
	@FormField(name="flex_string_isImported",propertyName="isImported",dataTypeValidationTypes={})
	public String getIsImported() {
		return isImported;
	}
	
	@FormField(name="isImportedFromDIT",propertyName="isImportedFromDIT",dataTypeValidationTypes={})
	public final Boolean getIsImportedFromDIT() {
		return isImportedFromDIT;
	}
	
	public final void setIsImportedFromDIT(Boolean isImportedFromDIT) {
		this.isImportedFromDIT = isImportedFromDIT;
	}
	
	public final void setIsImported(String isImported) {
		this.isImported = isImported;
	}
	
}
