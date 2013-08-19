package com.mootly.wcm.services.ditws.model;

public class Twenty26ASTaxPayment {
	
	//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
	//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
	//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
	//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}
	
	String Amt;
	String SrlNoOfChaln;
	String BSRCode;
	String DateDep;
	
	public final String getAmt() {
		return Amt;
	}
	public final void setAmt(String amt) {
		Amt = amt;
	}
	public final String getSrlNoOfChaln() {
		return SrlNoOfChaln;
	}
	public final void setSrlNoOfChaln(String srlNoOfChaln) {
		SrlNoOfChaln = srlNoOfChaln;
	}
	public final String getBSRCode() {
		return BSRCode;
	}
	public final void setBSRCode(String bSRCode) {
		BSRCode = bSRCode;
	}
	public final String getDateDep() {
		return DateDep;
	}
	public final void setDateDep(String dateDep) {
		DateDep = dateDep;
	}
	
	
}
