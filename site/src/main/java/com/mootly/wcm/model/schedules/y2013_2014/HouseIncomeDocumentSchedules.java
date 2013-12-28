package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.AddressDetail;
import in.gov.incometaxindiaefiling.y2013_2014.CoOwners;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.PropertyDetails;
import in.gov.incometaxindiaefiling.y2013_2014.Rentdetails;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleHP;

import java.math.BigInteger;
import java.util.List;

import com.mootly.wcm.beans.HouseProperty;
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

		if(document != null){
			List<HouseIncomeDetail> houseIncomeDetails = document.getHouseIncomeDetailList();
			if (houseIncomeDetails!= null && houseIncomeDetails.size() > 0 ){
				int i=1;
				long totalHP = 0;
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
						if(!(houseIncomeDetail.getCoownername1().isEmpty())){
							CoOwners coOwners = new CoOwners();
							coOwners.setCoOwnersSNo(1);
							coOwners.setNameCoOwner(houseIncomeDetail.getCoownername1());
							if(!(houseIncomeDetail.getCoownerpan1().isEmpty()))
								coOwners.setPANCoOwner(houseIncomeDetail.getCoownerpan1());
							if(!(houseIncomeDetail.getShare1().isEmpty()))
								coOwners.setPercentShareProperty(Double.parseDouble(houseIncomeDetail.getShare1()));
							propertyDetails.getCoOwners().add(coOwners);
						}
						if(!(houseIncomeDetail.getCoownername2().isEmpty())){
							CoOwners coOwners = new CoOwners();
							coOwners.setCoOwnersSNo(2);
							coOwners.setNameCoOwner(houseIncomeDetail.getCoownername2());
							if(!(houseIncomeDetail.getCoownerpan2().isEmpty()))
								coOwners.setPANCoOwner(houseIncomeDetail.getCoownerpan2());
							if(!(houseIncomeDetail.getShare2().isEmpty()))
								coOwners.setPercentShareProperty(Double.parseDouble(houseIncomeDetail.getShare2()));
							propertyDetails.getCoOwners().add(coOwners);
						}
						if(!(houseIncomeDetail.getCoownername3().isEmpty())){
							CoOwners coOwners = new CoOwners();
							coOwners.setCoOwnersSNo(3);
							coOwners.setNameCoOwner(houseIncomeDetail.getCoownername3());
							if(!(houseIncomeDetail.getCoownerpan3().isEmpty()))
								coOwners.setPANCoOwner(houseIncomeDetail.getCoownerpan3());
							if(!(houseIncomeDetail.getShare3().isEmpty()))
								coOwners.setPercentShareProperty(Double.parseDouble(houseIncomeDetail.getShare3()));
							propertyDetails.getCoOwners().add(coOwners);
						}
						if(!(houseIncomeDetail.getCoownername4().isEmpty())){
							CoOwners coOwners = new CoOwners();
							coOwners.setCoOwnersSNo(4);
							coOwners.setNameCoOwner(houseIncomeDetail.getCoownername4());
							if(!(houseIncomeDetail.getCoownerpan4().isEmpty()))
								coOwners.setPANCoOwner(houseIncomeDetail.getCoownerpan4());
							if(!(houseIncomeDetail.getShare4().isEmpty()))
								coOwners.setPercentShareProperty(Double.parseDouble(houseIncomeDetail.getShare4()));
							propertyDetails.getCoOwners().add(coOwners);
						}
						if(!(houseIncomeDetail.getCoownername5().isEmpty())){
							CoOwners coOwners = new CoOwners();
							coOwners.setCoOwnersSNo(5);
							coOwners.setNameCoOwner(houseIncomeDetail.getCoownername5());
							if(!(houseIncomeDetail.getCoownerpan5().isEmpty()))
								coOwners.setPANCoOwner(houseIncomeDetail.getCoownerpan5());
							if(!(houseIncomeDetail.getShare5().isEmpty()))
								coOwners.setPercentShareProperty(Double.parseDouble(houseIncomeDetail.getShare5()));
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

					if(!(houseIncomeDetail.getTenant_name().isEmpty())){
						propertyDetails.setNameofTenant(houseIncomeDetail.getTenant_name());
					}
					if(!(houseIncomeDetail.getTenant_pan().isEmpty())){
						propertyDetails.setPANofTenant(houseIncomeDetail.getTenant_pan());
					}
					scheduleHP.getPropertyDetails().add(propertyDetails);

					totalHP = totalHP + propertyDetails.getRentdetails().getIncomeOfHP();

					i++;
				}
				scheduleHP.setRentArearsSec25BAfter30PcDeduct(indianCurrencyHelper.bigIntegerRound(document.getRentSec25A()));
				scheduleHP.setRentOfEarlierYrSec25AandAA(indianCurrencyHelper.bigIntegerRound(document.getArrearRentSec25B()));
				scheduleHP.setTotalIncomeChargeableUnHP(indianCurrencyHelper.longRound(document.getTotal_HouseIncome()));

				return scheduleHP;
			}else
				return null;
		}else
			return null;
	}

}
