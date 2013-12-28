package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleSPI;
import in.gov.incometaxindiaefiling.y2012_2013.SpecifiedPerson;

import java.util.List;

import com.mootly.wcm.beans.ClubIncomeDocument;
import com.mootly.wcm.beans.compound.ClubIncomeDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ClubbingOfIncome {

	ClubIncomeDocument clubIncomeDocument = null;

	public ClubbingOfIncome(ClubIncomeDocument clubIncomeDocument){
		this.clubIncomeDocument = clubIncomeDocument;
	}

	public ScheduleSPI getScheduleSPI(ITR itr){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleSPI scheduleSPI = new ScheduleSPI();
		boolean hasAValidInc = false;
		if(clubIncomeDocument != null){
			List<ClubIncomeDetail> clubIncomeDetails = clubIncomeDocument.getClubIncomeDetailList();
			if ( clubIncomeDetails != null && clubIncomeDetails.size() > 0 ){
				for (ClubIncomeDetail ClubIncomeDetail:clubIncomeDetails)  {
					SpecifiedPerson specifiedPerson = new SpecifiedPerson();
					specifiedPerson.setSpecifiedPersonName(ClubIncomeDetail.getName_Person());
					if(!(ClubIncomeDetail.getPan_person().isEmpty()))
						specifiedPerson.setPANofSpecPerson(ClubIncomeDetail.getPan_person());
					specifiedPerson.setReltnShip(ClubIncomeDetail.getRelationship());
					specifiedPerson.setNatureOfInc(ClubIncomeDetail.getNature_income());
					specifiedPerson.setAmtIncluded(indianCurrencyHelper.longRound(ClubIncomeDetail.getAmountclub()));
					scheduleSPI.getSpecifiedPerson().add(specifiedPerson);
					if(!hasAValidInc) hasAValidInc = true;
				}
			}
		}
		if(hasAValidInc){
			return scheduleSPI;
		}else
			return null;

	}
}
