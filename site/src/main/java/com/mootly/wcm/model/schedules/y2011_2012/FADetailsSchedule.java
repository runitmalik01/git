package com.mootly.wcm.model.schedules.y2011_2012;

import in.gov.incometaxindiaefiling.y2011_2012.DetailsFinancialInterest;
import in.gov.incometaxindiaefiling.y2011_2012.DetailsForiegnBank;
import in.gov.incometaxindiaefiling.y2011_2012.DetailsImmovableProperty;
import in.gov.incometaxindiaefiling.y2011_2012.DetailsOfAccntsHvngSigningAuth;
import in.gov.incometaxindiaefiling.y2011_2012.DetailsOthAssets;
import in.gov.incometaxindiaefiling.y2011_2012.ITR;
import in.gov.incometaxindiaefiling.y2011_2012.ScheduleFA;

import java.util.List;

import com.mootly.wcm.beans.DetailOfTrustDocument;
import com.mootly.wcm.beans.FinancialInterestDocument;
import com.mootly.wcm.beans.ForeignBankAccountDocument;
import com.mootly.wcm.beans.ImmovablePropertyDocument;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.compound.DetailOfTrustDetail;
import com.mootly.wcm.beans.compound.FinancialInterestDetail;
import com.mootly.wcm.beans.compound.ForeignBankAccountDetail;
import com.mootly.wcm.beans.compound.ImmovablePropertyDetail;
import com.mootly.wcm.beans.compound.NatureInvestmentDetail;
import com.mootly.wcm.beans.compound.SigningAuthorityAccountsDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;
/*
 * author:- Pankaj Singh
 * Date:- 25/07/2013
 */
public class FADetailsSchedule {
	ImmovablePropertyDocument immovablePropertyDocument = null;
	NatureInvestmentDocument natureInvestmentDocument= null;
	SigningAuthorityAccountsDocument signingAuthorityAccountsDocument = null;
	DetailOfTrustDocument detailOfTrustDocument = null;
	ForeignBankAccountDocument foreignBankAccountDocument = null;
	FinancialInterestDocument financialInterestDocument = null;

	public FADetailsSchedule(ImmovablePropertyDocument immovablePropertyDocument,NatureInvestmentDocument natureInvestmentDocument,
								SigningAuthorityAccountsDocument signingAuthorityAccountsDocument,DetailOfTrustDocument detailOfTrustDocument,
								ForeignBankAccountDocument foreignBankAccountDocument,FinancialInterestDocument financialInterestDocument){
		this.immovablePropertyDocument = immovablePropertyDocument;
		this.natureInvestmentDocument = natureInvestmentDocument;
		this.signingAuthorityAccountsDocument= signingAuthorityAccountsDocument;
		this.detailOfTrustDocument=detailOfTrustDocument;
		this.foreignBankAccountDocument=foreignBankAccountDocument;
		this.financialInterestDocument=financialInterestDocument;

	}
	public ScheduleFA getScheduleFA (ITR itr){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleFA scheduleFA = new ScheduleFA();
		List<ForeignBankAccountDetail> foreignBankAccountDetails =  foreignBankAccountDocument.getForeignBankAccountDetailList();
		List<FinancialInterestDetail> financialInterestDetails =  financialInterestDocument.getFinancialInterestDetailList();
		List<ImmovablePropertyDetail> immovablePropertyDetails = immovablePropertyDocument.getImmovablePropertyDetailList();
		List<NatureInvestmentDetail>  natureInvestmentDetails  = natureInvestmentDocument.getNatureInvestmentDetailList();
		List<SigningAuthorityAccountsDetail> signingAuthorityAccountsDetails = signingAuthorityAccountsDocument.getSigningAuthorityAccountsDetailList();
		List<DetailOfTrustDetail> detailOfTrustDetails = detailOfTrustDocument.getDetailofTrustDetailList();
		for(ForeignBankAccountDetail foreignBankAccountDetail:foreignBankAccountDetails){
			DetailsForiegnBank detailsForiegnBank = new DetailsForiegnBank();
			detailsForiegnBank.setCountryCode(foreignBankAccountDetail.getCountry_Code());
			detailsForiegnBank.setCountryName(foreignBankAccountDetail.getCountry_Name());
			detailsForiegnBank.setBankname(foreignBankAccountDetail.getName_Bank());
			detailsForiegnBank.setAddressOfBank(foreignBankAccountDetail.getAddress_Bank());
			detailsForiegnBank.setNameAsInAccount(foreignBankAccountDetail.getName_Account());
			detailsForiegnBank.setPeakBalanceDuringYear(indianCurrencyHelper.bigIntegerRound(foreignBankAccountDetail.getPeak_Balance()));
			//detailsForiegnBank.setForeignAccountNumber(foreignBankAccountDetail.getAccount_No());
		}
		for(FinancialInterestDetail financialInterestDetail :financialInterestDetails ){
			DetailsFinancialInterest detailsFinancialInterest = new DetailsFinancialInterest();
			detailsFinancialInterest.setCountryCode(financialInterestDetail.getCountry_Code());
			detailsFinancialInterest.setCountryName(financialInterestDetail.getCountry_Name());
			detailsFinancialInterest.setNatureOfEntity(financialInterestDetail.getNature_Entity());
			detailsFinancialInterest.setNameOfEntity(financialInterestDetail.getName_Entity());
			detailsFinancialInterest.setAddressOfEntity(financialInterestDetail.getAddress_Entity());
			detailsFinancialInterest.setTotalInvestment(indianCurrencyHelper.bigIntegerRound(financialInterestDetail.getTotal_Investment()));
			}
		for(ImmovablePropertyDetail ImmovablePropertyDetail:immovablePropertyDetails){
			DetailsImmovableProperty detailsImmovableProperty = new DetailsImmovableProperty();
			detailsImmovableProperty.setCountryCode(ImmovablePropertyDetail.getCountry_Code());
			detailsImmovableProperty.setCountryName(ImmovablePropertyDetail.getCountry_Name());
			detailsImmovableProperty.setAddressOfProperty(ImmovablePropertyDetail.getAddress_Property());
			detailsImmovableProperty.setTotalInvestment(indianCurrencyHelper.bigIntegerRound(ImmovablePropertyDetail.getTotal_Investment()));
		}
		for(NatureInvestmentDetail natureInvestmentDetail:natureInvestmentDetails){
			DetailsOthAssets detailsOthAssets = new DetailsOthAssets();
			detailsOthAssets.setCountryCode(natureInvestmentDetail.getCountry_Code());
			detailsOthAssets.setCountryName(natureInvestmentDetail.getCountry_Name());
			detailsOthAssets.setNatureOfAsset(natureInvestmentDetail.getNature_Asset());
			detailsOthAssets.setTotalInvestment(indianCurrencyHelper.bigIntegerRound(natureInvestmentDetail.getTotal_Investment()));

		}
		for(SigningAuthorityAccountsDetail signingAuthorityAccountsDetail:signingAuthorityAccountsDetails){
			DetailsOfAccntsHvngSigningAuth detailsOfAccntsHvngSigningAuth= new DetailsOfAccntsHvngSigningAuth();
			detailsOfAccntsHvngSigningAuth.setNameOfInstitution(signingAuthorityAccountsDetail.getName_Institution());
			detailsOfAccntsHvngSigningAuth.setAddressOfInstitution(signingAuthorityAccountsDetail.getAddress_Institution());
			//detailsOfAccntsHvngSigningAuth.setInstitutionAccountNumber(signingAuthorityAccountsDetail.getAccount_Number());
			detailsOfAccntsHvngSigningAuth.setNameMentionedInAccnt(signingAuthorityAccountsDetail.getName_Accountholder());
			detailsOfAccntsHvngSigningAuth.setPeakBalanceOrInvestment(indianCurrencyHelper.bigIntegerRound(signingAuthorityAccountsDetail.getPeak_Balance()));
		}
		/*
		for(DetailOfTrustDetail detailOfTrustDetail:detailOfTrustDetails){
			DetailsOfTrustOutIndiaTrustee detailsOfTrustOutIndiaTrustee = new DetailsOfTrustOutIndiaTrustee();
			detailsOfTrustOutIndiaTrustee.setCountryCode(detailOfTrustDetail.getCountry_Code());
			detailsOfTrustOutIndiaTrustee.setCountryName(detailOfTrustDetail.getCountry_Name());
			detailsOfTrustOutIndiaTrustee.setNameOfTrust(detailOfTrustDetail.getName_Trust());
			detailsOfTrustOutIndiaTrustee.setAddressOfTrust(detailOfTrustDetail.getAddress_Trust());
			detailsOfTrustOutIndiaTrustee.setNameOfOtherTrustees(detailOfTrustDetail.getName_Othertrust());
			detailsOfTrustOutIndiaTrustee.setAddressOfOtherTrustees(detailOfTrustDetail.getAddress_Othertrust());
			detailsOfTrustOutIndiaTrustee.setNameOfSettlor(detailOfTrustDetail.getName_Settlor());
			detailsOfTrustOutIndiaTrustee.setAddressOfSettlor(detailOfTrustDetail.getAddress_Settlor());
			detailsOfTrustOutIndiaTrustee.setNameOfBeneficiaries(detailOfTrustDetail.getName_Beneficiaries());
			detailsOfTrustOutIndiaTrustee.setAddressOfBeneficiaries(detailOfTrustDetail.getAddress_Beneficiaries());
		}
		*/
		return scheduleFA;
	}

}

