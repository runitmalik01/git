package com.mootly.wcm.services.ditws.model;

//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}
public class Twenty26ASTCS {
	
	String AmtTCSClaimedThisYear;
	String EmployerOrDeductorOrCollecterName;
	String TAN;
	String TotalTCS;
	
	public final String getAmtTCSClaimedThisYear() {
		return AmtTCSClaimedThisYear;
	}
	public final void setAmtTCSClaimedThisYear(String amtTCSClaimedThisYear) {
		AmtTCSClaimedThisYear = amtTCSClaimedThisYear;
	}
	public final String getEmployerOrDeductorOrCollecterName() {
		return EmployerOrDeductorOrCollecterName;
	}
	public final void setEmployerOrDeductorOrCollecterName(
			String employerOrDeductorOrCollecterName) {
		EmployerOrDeductorOrCollecterName = employerOrDeductorOrCollecterName;
	}
	public final String getTAN() {
		return TAN;
	}
	public final void setTAN(String tAN) {
		TAN = tAN;
	}
	public final String getTotalTCS() {
		return TotalTCS;
	}
	public final void setTotalTCS(String totalTCS) {
		TotalTCS = totalTCS;
	}
}
