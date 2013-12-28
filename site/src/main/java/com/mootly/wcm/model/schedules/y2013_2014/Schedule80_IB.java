package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.Schedule80IB;

import java.math.BigInteger;
import java.util.List;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class Schedule80_IB {

	DeductionDocument deductionDocument = null;

	public Schedule80_IB(DeductionDocument deductionDocument){

		this.deductionDocument = deductionDocument;

	}

	public Schedule80IB getSchedule80IB(ITR itr){

		Schedule80IB schedule80IB = new Schedule80IB();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		BigInteger industrial = new BigInteger("0");
		BigInteger industrialjk = new BigInteger("0");
		BigInteger industrialbs = new BigInteger("0");
		BigInteger industrialbd = new BigInteger("0");
		BigInteger multiplex = new BigInteger("0");
		BigInteger convention = new BigInteger("0");
		BigInteger scientific = new BigInteger("0");
		BigInteger mineral = new BigInteger("0");
		BigInteger housing = new BigInteger("0");
		BigInteger chain = new BigInteger("0");
		BigInteger fruits = new BigInteger("0");
		BigInteger foodgrain = new BigInteger("0");
		BigInteger hospitalexclud = new BigInteger("0");
		BigInteger hospital = new BigInteger("0");
		if(deductionDocument != null){
			List<DeductionDocumentDetail> deductionDocumentDetail =  deductionDocument.getDeductionDocumentDetailList();
			if ( deductionDocumentDetail != null && deductionDocumentDetail.size() > 0 ){
				for(DeductionDocumentDetail deductionDocumentDetails:deductionDocumentDetail){
					if(deductionDocumentDetails.getSection().equals("80ib")){
						if(deductionDocumentDetails.getHead().equals("industrial")){
							industrial = industrial.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialjk")){
							industrialjk = industrialjk.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialbs")){
							industrialbs = industrialbs.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialbd")){
							industrialbd = industrialbd.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("multiplex")){
							multiplex = multiplex.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("convention")){
							convention = convention.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("scientific")){
							scientific = scientific.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("mineral")){
							mineral = mineral.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("housing")){
							housing = housing.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("chain")){
							chain = chain.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("fruits")){
							fruits = fruits.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("foodgrain")){
							foodgrain = foodgrain.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("hospitalexclud")){
							hospitalexclud = hospitalexclud.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("hospital")){
							hospital = hospital.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
					}
				}
			}
		}

		schedule80IB.setDeductSSIUs80IB3(industrial);
		schedule80IB.setDeductJKLocUs80IB4(industrialjk);
		schedule80IB.setDeductBackStatesUs80IB4(industrialbs);
		schedule80IB.setDeductBackDisttUs80IB5(industrialbd);
		schedule80IB.setDeductMultiplexUs80IB7A(multiplex);
		schedule80IB.setDeductConvCentUs80IB7B(convention);
		schedule80IB.setDeductScientificResUs80IB8A(scientific);
		schedule80IB.setDeductMinOilUs80IB9(mineral);
		schedule80IB.setDeductHousUs80IB10(housing);
		schedule80IB.setDeductColdChainUs80IB11(chain);
		schedule80IB.setDeductFruitVegUs80IB11A(fruits);
		schedule80IB.setDeductFoodGrainUs80IB11A(foodgrain);
		schedule80IB.setDeductRurHospUs80IB11B(hospital);
		schedule80IB.setDeductHospAnyAreaUs80IB11C(hospitalexclud);
		schedule80IB.setTotSchedule80IB(schedule80IB.getDeductBackDisttUs80IB5().add(schedule80IB.getDeductBackStatesUs80IB4()).add(schedule80IB.getDeductColdChainUs80IB11()).add(schedule80IB.getDeductConvCentUs80IB7B())
				.add(schedule80IB.getDeductFoodGrainUs80IB11A()).add(schedule80IB.getDeductFruitVegUs80IB11A()).add(schedule80IB.getDeductHospAnyAreaUs80IB11C()).add(schedule80IB.getDeductHousUs80IB10()).add(schedule80IB.getDeductJKLocUs80IB4())
				.add(schedule80IB.getDeductMinOilUs80IB9()).add(schedule80IB.getDeductMultiplexUs80IB7A()).add(schedule80IB.getDeductRurHospUs80IB11B()).add(schedule80IB.getDeductScientificResUs80IB8A())
				.add(schedule80IB.getDeductSSIUs80IB3()));

		return schedule80IB;
	}
}
