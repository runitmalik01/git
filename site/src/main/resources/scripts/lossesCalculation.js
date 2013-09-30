
out_adjustedSalaryIncome = 0;
out_adjustedHouseIncome = 0;
out_balancedHouseIncome = 0;
out_balancedOtherIncome = 0;
out_balancedOtherIncomeAftHI = 0;
out_balancedHouseIncomeAftSTC = 0;
out_balancedOtherIncomeAftSTC = 0;
out_adjustedSTCGain = 0;
out_adjustedLTCGain = 0;
out_balancedHouseIncomeAftLTC = 0;
out_balancedOtherIncomeAftLTC = 0;
out_balancedHouseIncomeAftOI = 0;
out_adjustedOtherIncome = 0;
out_adjustedmaintainingRaceHorseIncome=0;
out_balancedOtherIncomeAftHR =0;
out_balancedHouseIncomeAftRH=0;
out_totalHPLossSetoff = 0;
out_totalOILossSetoff = 0;
//out_balancedSTCLoss = 0;
//added for ITR4
out_balancedBusinessIncomeAftHI = 0;
out_totalBILossSetoff = 0;
out_balancedBusinessIncomeAftSTC = 0;
out_balancedBusinessIncomeAftLTC = 0;
out_balancedBusinessIncomeAftOI = 0;
out_balancedBusinessIncomeAftHR = 0;
out_balancedHouseIncomeAftBI = 0;
out_balancedOtherIncomeAftBI = 0;
out_adjustedBusinessIncome = 0;
out_balancedHouseIncomeAftSI = 0;
out_balancedOtherIncomeAftSI = 0;
out_adjustedSpeculativeIncome = 0;
out_balancedHouseIncomeAftSPI = 0;
out_balancedOtherIncomeAftSPI = 0;
out_adjustedSpecifiedIncome = 0;

/*
 * Calculation for CYLA(Adjustment of losses) begins
 */
if(salaryIncome>0){
	if(houseIncome<0){
		salaryIncome = salaryIncome-(houseIncome*(-1));
		if(salaryIncome>0){
			out_balancedHouseIncome = houseIncome*(-1);
			houseIncome = 0;
		}
		if(salaryIncome<=0){
			out_balancedHouseIncome =  salaryIncome + (houseIncome*(-1));
			houseIncome = salaryIncome;
			salaryIncome = 0;
		}
		out_totalHPLossSetoff = out_balancedHouseIncome;
	}
	if(otherIncome<0){
		salaryIncome = salaryIncome - (otherIncome*(-1));
		if(salaryIncome>0){
			out_balancedOtherIncome = otherIncome*(-1);
			otherIncome = 0;
		}
		if(salaryIncome<=0){
			out_balancedOtherIncome = salaryIncome + (otherIncome*(-1));
			otherIncome = salaryIncome;
			salaryIncome = 0;
		}
		out_totalOILossSetoff = out_balancedOtherIncome;
	}
	out_adjustedSalaryIncome = salaryIncome;
}

if(houseIncome>0){
	//added for ITR4 to set Business Income loss with House Income
	if(businessIncome<0){
		houseIncome = houseIncome - (businessIncome*(-1));
		if(houseIncome>0){
			out_balancedBusinessIncomeAftHI = businessIncome*(-1);
			businessIncome = 0;
		}
		if(houseIncome<=0){
			out_balancedBusinessIncomeAftHI = houseIncome + (businessIncome*(-1));
			businessIncome = houseIncome;
			houseIncome = 0;
		}
		out_totalBILossSetoff = out_totalBILossSetoff + out_balancedBusinessIncomeAftHI;
	}
	//end
	if(otherIncome<0){
		houseIncome = houseIncome - (otherIncome*(-1));
		if(houseIncome>0){
			out_balancedOtherIncomeAftHI = otherIncome*(-1);
			otherIncome = 0;
		}
		if(houseIncome<=0){
			out_balancedOtherIncomeAftHI = houseIncome + (otherIncome*(-1));
			otherIncome = houseIncome;
			houseIncome = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftHI;
	}
	out_adjustedHouseIncome = houseIncome;
}

//added for ITR4 to adjust losses with Business Income
if(businessIncome>0){
	if(houseIncome<0){
		businessIncome = businessIncome - (houseIncome*(-1));
		if(businessIncome>0){
			out_balancedHouseIncomeAftBI = houseIncome*(-1);
			houseIncome = 0;
		}
		if(businessIncome<=0){
			out_balancedHouseIncomeAftBI =  businessIncome + (houseIncome*(-1));
			houseIncome = businessIncome;
			businessIncome = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftBI;
	}
	if(otherIncome<0){
		businessIncome = businessIncome - (otherIncome*(-1));
		if(businessIncome>0){
			out_balancedOtherIncomeAftBI = otherIncome*(-1);
			otherIncome = 0;
		}
		if(businessIncome<=0){
			out_balancedOtherIncomeAftBI = businessIncome + (otherIncome*(-1));
			otherIncome = businessIncome;
			businessIncome = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftBI;
	}
	out_adjustedBusinessIncome = businessIncome;
}
//end
//added for ITR4 to adjust losses with Speculative Income
if(speculativeIncome>0){
	if(houseIncome<0){
		speculativeIncome = speculativeIncome - (houseIncome*(-1));
		if(speculativeIncome>0){
			out_balancedHouseIncomeAftSI = houseIncome*(-1);
			houseIncome = 0;
		}
		if(speculativeIncome<=0){
			out_balancedHouseIncomeAftSI =  speculativeIncome + (houseIncome*(-1));
			houseIncome = speculativeIncome;
			speculativeIncome = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftSI;
	}
	if(otherIncome<0){
		speculativeIncome = speculativeIncome - (otherIncome*(-1));
		if(speculativeIncome>0){
			out_balancedOtherIncomeAftSI = otherIncome*(-1);
			otherIncome = 0;
		}
		if(speculativeIncome<=0){
			out_balancedOtherIncomeAftSI = speculativeIncome + (otherIncome*(-1));
			otherIncome = speculativeIncome;
			speculativeIncome = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftSI;
	}
	out_adjustedSpeculativeIncome = speculativeIncome;
}
//end
//added for ITR4 to adjust losses with Specified Income
if(specifiedIncome>0){
	if(houseIncome<0){
		specifiedIncome = specifiedIncome - (houseIncome*(-1));
		if(specifiedIncome>0){
			out_balancedHouseIncomeAftSPI = houseIncome*(-1);
			houseIncome = 0;
		}
		if(specifiedIncome<=0){
			out_balancedHouseIncomeAftSPI =  specifiedIncome + (houseIncome*(-1));
			houseIncome = specifiedIncome;
			specifiedIncome = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftSPI;
	}
	if(otherIncome<0){
		specifiedIncome = specifiedIncome - (otherIncome*(-1));
		if(specifiedIncome>0){
			out_balancedOtherIncomeAftSPI = otherIncome*(-1);
			otherIncome = 0;
		}
		if(specifiedIncome<=0){
			out_balancedOtherIncomeAftSPI = specifiedIncome + (otherIncome*(-1));
			otherIncome = specifiedIncome;
			specifiedIncome = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftSPI;
	}
	out_adjustedSpecifiedIncome = specifiedIncome;
}
//end

if(STCGain>0){
	if(houseIncome<0){
		STCGain = STCGain - (houseIncome*(-1));
		if(STCGain>0){
			out_balancedHouseIncomeAftSTC = houseIncome*(-1);
			houseIncome = 0;
		}
		if(STCGain<=0){
			out_balancedHouseIncomeAftSTC =  STCGain + (houseIncome*(-1));
			houseIncome = STCGain;
			STCGain = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftSTC;
	}
	//added for ITR4 to adjust Business Income loss with STCG
	if(businessIncome<0){
		STCGain = STCGain - (businessIncome*(-1));
		if(STCGain>0){
			out_balancedBusinessIncomeAftSTC = businessIncome*(-1);
			businessIncome = 0;
		}
		if(STCGain<=0){
			out_balancedBusinessIncomeAftSTC = STCGain + (businessIncome*(-1));
			businessIncome = STCGain;
			STCGain = 0;
		}
		out_totalBILossSetoff = out_totalBILossSetoff + out_balancedBusinessIncomeAftSTC;
	}
	//end
	if(otherIncome<0){
		STCGain = STCGain - (otherIncome*(-1));
		if(STCGain>0){
			out_balancedOtherIncomeAftSTC = otherIncome*(-1);
			otherIncome = 0;
		}
		if(STCGain<=0){
			out_balancedOtherIncomeAftSTC = STCGain + (otherIncome*(-1));
			otherIncome = STCGain;
			STCGain = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftSTC;
	}
	out_adjustedSTCGain = STCGain;
}

if(LTCGain>0){
	if(houseIncome<0){
		LTCGain = LTCGain - (houseIncome*(-1));
		if(LTCGain>0){
			out_balancedHouseIncomeAftLTC = houseIncome*(-1);
			houseIncome = 0;
		}
		if(LTCGain<=0){
			out_balancedHouseIncomeAftLTC =  LTCGain + (houseIncome*(-1));
			houseIncome = LTCGain;
			LTCGain = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftLTC;
	}
	//added for ITR4 to adjust Business Income loss with LTGC
	if(businessIncome<0){
		LTCGain = LTCGain - (businessIncome*(-1));
		if(LTCGain>0){
			out_balancedBusinessIncomeAftLTC = businessIncome*(-1);
			businessIncome = 0;
		}
		if(LTCGain<=0){
			out_balancedBusinessIncomeAftLTC = LTCGain + (businessIncome*(-1));
			businessIncome = LTCGain;
			LTCGain = 0;
		}
		out_totalBILossSetoff = out_totalBILossSetoff + out_balancedBusinessIncomeAftLTC;
	}
	//end
	if(otherIncome<0){
		LTCGain = LTCGain - (otherIncome*(-1));
		if(LTCGain>0){
			out_balancedOtherIncomeAftLTC = otherIncome*(-1);
			otherIncome = 0;
		}
		if(LTCGain<=0){
			out_balancedOtherIncomeAftLTC = LTCGain + (otherIncome*(-1));
			otherIncome = LTCGain;
			LTCGain = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftLTC;
	}
	/*
	if(STCGain<0){
		LTCGain = LTCGain - (STCGain*(-1));
		if(LTCGain>0){
			out_balancedSTCLoss = STCGain*(-1);
		}
		if(LTCGain<=0){
			out_balancedSTCLoss = LTCGain + (STCGain*(-1));
			STCGain = LTCGain;
			LTCGain = 0;
		}
	}
	*/
	out_adjustedLTCGain = LTCGain;
}

if(otherIncome>0){
	if(houseIncome<0){
		otherIncome = otherIncome-(houseIncome*(-1));
		if(otherIncome>0){
			out_balancedHouseIncomeAftOI = houseIncome*(-1);
			houseIncome = 0;
		}
		if(otherIncome<=0){
			out_balancedHouseIncomeAftOI =  otherIncome + (houseIncome*(-1));
			houseIncome = otherIncome;
			otherIncome = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftOI;
	}
	//added for ITR4 to adjust Business Income Loss with Other Income
	if(businessIncome<0){
		otherIncome = otherIncome-(businessIncome*(-1));
		if(otherIncome>0){
			out_balancedBusinessIncomeAftOI = businessIncome*(-1);
			businessIncome = 0;
		}
		if(otherIncome<=0){
			out_balancedBusinessIncomeAftOI =  otherIncome + (businessIncome*(-1));
			businessIncome = otherIncome;
			otherIncome = 0;
		}
		out_totalBILossSetoff = out_totalBILossSetoff + out_balancedBusinessIncomeAftOI;
	}
	//end
	out_adjustedOtherIncome = otherIncome;
}

if(maintainingRaceHorseIncome>0){
	if(houseIncome<0){
		maintainingRaceHorseIncome = maintainingRaceHorseIncome-(houseIncome*(-1));
		if(maintainingRaceHorseIncome>0){
			out_balancedHouseIncomeAftRH = houseIncome*(-1);
			houseIncome = 0;
		}
		if(maintainingRaceHorseIncome<=0){
			out_balancedHouseIncomeAftRH =  maintainingRaceHorseIncome + (houseIncome*(-1));
			houseIncome = maintainingRaceHorseIncome;
			maintainingRaceHorseIncome = 0;
		}
		out_totalHPLossSetoff = out_totalHPLossSetoff + out_balancedHouseIncomeAftRH;
	}
	//added for ITR4 to adjust Business Income Loss with Maintaining Race Horse Income
	if(businessIncome<0){
		maintainingRaceHorseIncome = maintainingRaceHorseIncome - (businessIncome*(-1));
		if(maintainingRaceHorseIncome>0){
			out_balancedBusinessIncomeAftHR = businessIncome*(-1);
			businessIncome = 0;
		}
		if(maintainingRaceHorseIncome<=0){
			out_balancedBusinessIncomeAftHR = maintainingRaceHorseIncome + (businessIncome*(-1));
			businessIncome = maintainingRaceHorseIncome;
			maintainingRaceHorseIncome = 0;
		}
		out_totalBILossSetoff = out_totalBILossSetoff + out_balancedBusinessIncomeAftHR;
	}
	//end
	if(otherIncome<0){
		maintainingRaceHorseIncome = maintainingRaceHorseIncome - (otherIncome*(-1));
		if(maintainingRaceHorseIncome>0){
			out_balancedOtherIncomeAftHR = otherIncome*(-1);
			otherIncome = 0;
		}
		if(maintainingRaceHorseIncome<=0){
			out_balancedOtherIncomeAftHR = maintainingRaceHorseIncome + (otherIncome*(-1));
			otherIncome = maintainingRaceHorseIncome;
			maintainingRaceHorseIncome = 0;
		}
		out_totalOILossSetoff = out_totalOILossSetoff + out_balancedOtherIncomeAftHR;
	}
	out_adjustedmaintainingRaceHorseIncome = maintainingRaceHorseIncome;
}

/*
 * Calculation for BFLA(Adjustment of losses) begins
 */
out_HouseIncomeAftBFLA = 0;
out_balancedHouseLoss = 0;
out_totalBFLossSetOff = 0;
out_totalIncomeAftBFLoss = 0;
if(out_adjustedHouseIncome>0){
	out_HouseIncomeAftBFLA =out_adjustedHouseIncome-houseIncomeLoss;
	if(out_HouseIncomeAftBFLA>0){
		out_balancedHouseLoss = houseIncomeLoss;
		houseIncomeLoss = 0;
	}
	if(out_HouseIncomeAftBFLA<=0){
		out_balancedHouseLoss = out_adjustedHouseIncome;
		houseIncomeLoss = out_HouseIncomeAftBFLA*(-1);
		out_HouseIncomeAftBFLA = 0;
	}
	out_totalBFLossSetOff = out_balancedHouseLoss;
	out_totalIncomeAftBFLoss = out_HouseIncomeAftBFLA;
}

out_STCGainAftBFLA = 0;
out_balancedSTCLoss = 0;
if(out_adjustedSTCGain>0){
	out_STCGainAftBFLA = out_adjustedSTCGain - STCLoss;
	if(out_STCGainAftBFLA>0){
		out_balancedSTCLoss = STCLoss;
		STCLoss = 0;
	}
	if(out_STCGainAftBFLA<=0){
		out_balancedSTCLoss = out_adjustedSTCGain;
		STCLoss = out_STCGainAftBFLA*(-1);
		out_STCGainAftBFLA = 0;
	}
	out_totalBFLossSetOff = out_totalBFLossSetOff + out_balancedSTCLoss;
	out_totalIncomeAftBFLoss = out_totalIncomeAftBFLoss + out_STCGainAftBFLA;
}

out_LTCGainAftBFLA = 0;
out_balancedLTCLoss = 0;
if(out_adjustedLTCGain>0){
	out_LTCGainAftBFLA  = out_adjustedLTCGain  - LTCLoss;
	if(out_LTCGainAftBFLA>0){
		out_balancedLTCLoss = LTCLoss;
		LTCLoss = 0;
	}
	if(out_LTCGainAftBFLA<=0){
		out_balancedLTCLoss = out_adjustedLTCGain;
		LTCLoss = out_LTCGainAftBFLA*(-1);
		out_LTCGainAftBFLA=0;
	}
	out_totalBFLossSetOff = out_totalBFLossSetOff + out_balancedLTCLoss;
	out_totalIncomeAftBFLoss = out_totalIncomeAftBFLoss + out_LTCGainAftBFLA;
}

out_RaceHorseIncomeAftBFLA = 0;
out_balancedRaceHorseLoss = 0;
if(out_adjustedmaintainingRaceHorseIncome>0){
	out_RaceHorseIncomeAftBFLA = out_adjustedmaintainingRaceHorseIncome - MaintainingRaceHorseLoss;
	if(out_RaceHorseIncomeAftBFLA>0){
		out_balancedRaceHorseLoss = out_adjustedmaintainingRaceHorseIncome;
		MaintainingRaceHorseLoss = 0;
	}
	if(out_RaceHorseIncomeAftBFLA<=0){
		out_balancedRaceHorseLoss = out_adjustedmaintainingRaceHorseIncome;
		MaintainingRaceHorseLoss = out_RaceHorseIncomeAftBFLA*(-1);
		out_RaceHorseIncomeAftBFLA = 0;
	}
	out_totalBFLossSetOff = out_totalBFLossSetOff + out_balancedRaceHorseLoss;
	out_totalIncomeAftBFLoss = out_totalIncomeAftBFLoss + out_RaceHorseIncomeAftBFLA;
}

/*
 * Calculation for CFL(Adjustment of losses) begins
 */

out_currYearHouseIncomeLoss=0;
out_currYearLTCLoss=0;
out_currYearSTCLoss=0;
out_currYearRaceHorseLoss=0;

if(houseIncome<0)
out_currYearHouseIncomeLoss = houseIncome*(-1);
if(LTCGain<0)
out_currYearLTCLoss = LTCGain*(-1);
if(STCGain<0)
out_currYearSTCLoss = STCGain*(-1);
if(maintainingRaceHorseIncome<0)
out_currYearRaceHorseLoss = maintainingRaceHorseIncome*(-1);

out_cryFwdHouseIncomeLoss = houseIncomeLoss + out_currYearHouseIncomeLoss;
out_cryFwdLTCLoss = LTCLoss + out_currYearLTCLoss;
out_cryFwdSTCLoss = STCLoss + out_currYearSTCLoss;
out_cryFwdRaceHorseLoss = MaintainingRaceHorseLoss + out_currYearRaceHorseLoss;




/*

if(houseIncomeLoss>houseIncome){
	out_houseIncomeLossCF = houseIncomeLoss - houseIncome;
}else
out_houseIncomeLossCF = 0;
LTCLoss
STCLoss
LTCGain
STCGain
MaintainingRaceHorseLoss
salaryIncome
otherIncome
maintainingRaceHorseIncome
 */