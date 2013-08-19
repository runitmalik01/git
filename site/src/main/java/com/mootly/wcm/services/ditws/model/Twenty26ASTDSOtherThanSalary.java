package com.mootly.wcm.services.ditws.model;

public class Twenty26ASTDSOtherThanSalary {
	//{ScheduleTCS={AmtTCSClaimedThisYear=[0], EmployerOrDeductorOrCollecterName=[?], TAN=[3000], TotalTCS=[0]}, 
	//TDSonOthThanSals={DeductedYr=[2015, 2001], UniqueTDSCerNo=[2, 1], EmployerOrDeductorOrCollecterName=[?, IBM], TotTDSOnAmtPaid=[10, 110], TAN=[2000, 2001], ClaimOutOfTotTDSOnAmtPaid=[20, 220]}, 
	//TDSonSalaries={EmployerOrDeductorOrCollecterName=[?], TotalTDSSal=[0], IncChrgSal=[0], TAN=[1000]}, 
	//TaxPayments={Amt=[0], SrlNoOfChaln=[?], BSRCode=[?], DateDep=[?]}}
	
	String DeductedYr;
	String UniqueTDSCerNo;
	String EmployerOrDeductorOrCollecterName;
	String TotTDSOnAmtPaid;
	String TAN;
	String ClaimOutOfTotTDSOnAmtPaid;
	public String getDeductedYr() {
		return DeductedYr;
	}
	public void setDeductedYr(String deductedYr) {
		DeductedYr = deductedYr;
	}
	public String getUniqueTDSCerNo() {
		return UniqueTDSCerNo;
	}
	public void setUniqueTDSCerNo(String uniqueTDSCerNo) {
		UniqueTDSCerNo = uniqueTDSCerNo;
	}
	public String getEmployerOrDeductorOrCollecterName() {
		return EmployerOrDeductorOrCollecterName;
	}
	public void setEmployerOrDeductorOrCollecterName(
			String employerOrDeductorOrCollecterName) {
		EmployerOrDeductorOrCollecterName = employerOrDeductorOrCollecterName;
	}
	public String getTotTDSOnAmtPaid() {
		return TotTDSOnAmtPaid;
	}
	public void setTotTDSOnAmtPaid(String totTDSOnAmtPaid) {
		TotTDSOnAmtPaid = totTDSOnAmtPaid;
	}
	public String getTAN() {
		return TAN;
	}
	public void setTAN(String tAN) {
		TAN = tAN;
	}
	public String getClaimOutOfTotTDSOnAmtPaid() {
		return ClaimOutOfTotTDSOnAmtPaid;
	}
	public void setClaimOutOfTotTDSOnAmtPaid(String claimOutOfTotTDSOnAmtPaid) {
		ClaimOutOfTotTDSOnAmtPaid = claimOutOfTotTDSOnAmtPaid;
	}
	
	
	
}
