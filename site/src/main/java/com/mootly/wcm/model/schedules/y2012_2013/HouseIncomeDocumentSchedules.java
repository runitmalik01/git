package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;
import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.CoOwners;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PropertyDetails;
import in.gov.incometaxindiaefiling.y2012_2013.Rentdetails;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleHP;
import in.gov.incometaxindiaefiling.y2012_2013.Salaries.Salarys;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class HouseIncomeDocumentSchedules {

	HouseProperty document = null;

	public HouseIncomeDocumentSchedules(HouseProperty document) {
		this.document = document;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public ScheduleHP getScheduleHP(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleHP scheduleHP = new ScheduleHP();

		List<HouseIncomeDetail> houseIncomeDetails = document.getHouseIncomeDetailList();
		int i=1;
		for (HouseIncomeDetail houseIncomeDetail:houseIncomeDetails)  {
			PropertyDetails propertyDetails = new PropertyDetails();
			propertyDetails.setHPSNo(i);

			AddressDetail addressDetail = new AddressDetail();
			addressDetail.setAddrDetail(houseIncomeDetail.getAddress());
			addressDetail.setCityOrTownOrDistrict(houseIncomeDetail.getCity());
			addressDetail.setStateCode(houseIncomeDetail.getStates());
			addressDetail.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(houseIncomeDetail.getPin()));
			propertyDetails.setAddressDetail(addressDetail);
			propertyDetails.setPropCoOwnedFlg(houseIncomeDetail.getCoowned().toUpperCase());
			if(propertyDetails.getPropCoOwnedFlg().equals("NO")){
				propertyDetails.setAsseseeShareProperty(100);
			}
			if(propertyDetails.getPropCoOwnedFlg().equals("YES")){
				propertyDetails.setAsseseeShareProperty(Double.parseDouble(houseIncomeDetail.getProperty_share()));
				for(int j=1; j<6; j++){
					CoOwners coOwners = new CoOwners();
					String replaceNumericValue = ""+j;
					if(houseIncomeDetail.getCoownername1().replaceAll("1", replaceNumericValue)!=null){
						coOwners.setCoOwnersSNo(j);
						coOwners.setNameCoOwner(houseIncomeDetail.getCoownername1().replaceAll("1", replaceNumericValue));
						coOwners.setPANCoOwner(houseIncomeDetail.getCoownerpan1().replaceAll("1", replaceNumericValue));
						coOwners.setPercentShareProperty(Double.parseDouble(houseIncomeDetail.getShare1().replaceAll("1", replaceNumericValue)));
					}
					propertyDetails.getCoOwners().add(coOwners);
				}
			}
			//If the House Property is LETOUT
			if(houseIncomeDetail.getLetOut().equals("L")){
				propertyDetails.setIfLetOut("Y");

				Rentdetails rentdetails = new Rentdetails();
				rentdetails.setAnnualLetableValue(indianCurrencyHelper.bigIntegerRound(houseIncomeDetail.getLetable_value()));
				rentdetails.setLocalTaxes(indianCurrencyHelper.bigIntegerRound(houseIncomeDetail.getLocal_tax()));
				rentdetails.setRentNotRealized(indianCurrencyHelper.bigIntegerRound(houseIncomeDetail.getUnrealised_rent()));
				rentdetails.setTotalUnrealizedAndTax(rentdetails.getLocalTaxes().add(rentdetails.getRentNotRealized()));
				rentdetails.setBalanceALV(houseIncomeDetail.getTotal().longValue());
				rentdetails.setThirtyPercentOfBalance(indianCurrencyHelper.bigIntegerRound(houseIncomeDetail.getBalance()));
				rentdetails.setIntOnBorwCap(indianCurrencyHelper.bigIntegerRound(houseIncomeDetail.getInterest_borrowed()));
				rentdetails.setTotalDeduct(rentdetails.getIntOnBorwCap().add(rentdetails.getThirtyPercentOfBalance()));
				rentdetails.setIncomeOfHP(houseIncomeDetail.getIncome_hproperty().longValue());

				propertyDetails.setRentdetails(rentdetails);
			}
			// If the House Property is Self Occupied
			if(houseIncomeDetail.getLetOut().equals("S")){
				propertyDetails.setIfLetOut("N");

				Rentdetails rentdetails = new Rentdetails();
				rentdetails.setAnnualLetableValue(new BigInteger("0"));
				rentdetails.setLocalTaxes(new BigInteger("0"));
				rentdetails.setRentNotRealized(new BigInteger("0"));
				rentdetails.setTotalUnrealizedAndTax(new BigInteger("0"));
				rentdetails.setBalanceALV(0);
				rentdetails.setThirtyPercentOfBalance(new BigInteger("0"));
				rentdetails.setIntOnBorwCap(indianCurrencyHelper.bigIntegerRound(houseIncomeDetail.getInterest_borrowed()));
				rentdetails.setTotalDeduct(rentdetails.getIntOnBorwCap().add(rentdetails.getThirtyPercentOfBalance()));
				rentdetails.setIncomeOfHP(houseIncomeDetail.getIncome_hproperty().longValue());

				propertyDetails.setRentdetails(rentdetails);
			}

			if(houseIncomeDetail.getTenant_name()!=null)
				propertyDetails.setNameofTenant(houseIncomeDetail.getTenant_name());
			if(houseIncomeDetail.getTenant_pan()!=null)
				propertyDetails.setPANofTenant(houseIncomeDetail.getTenant_pan());

			scheduleHP.getPropertyDetails().add(propertyDetails);

			//scheduleHP.setRentArearsSec25BAfter30PcDeduct(value); need to consult with Alok Sir Team
			//scheduleHP.setRentOfEarlierYrSec25AandAA(value); need to consult with Alok Sir Team
			//scheduleHP.setTotalIncomeChargeableUnHP(value); need to consult with Alok Sir Team


			i++;
		}
		return scheduleHP;

	}

}
