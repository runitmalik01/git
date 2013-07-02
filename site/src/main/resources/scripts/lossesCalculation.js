
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