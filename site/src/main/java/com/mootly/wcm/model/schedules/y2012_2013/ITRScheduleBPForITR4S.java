/**
 * 
 */
package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2011_2012.ITR4S;
import in.gov.incometaxindiaefiling.y2012_2013.NoBooksOfAccBS;
import in.gov.incometaxindiaefiling.y2012_2013.PersumptiveInc44AD;
import in.gov.incometaxindiaefiling.y2012_2013.PersumptiveInc44AE;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBPForITR4S;

import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.SchFourtyFourAEDocument;
import com.mootly.wcm.services.IndianCurrencyHelper;

/**
 * @author admin
 *
 */
public class ITRScheduleBPForITR4S {

	BusinessProfessionDocument businessProfessionDocument = null;
	SchFourtyFourAEDocument schFourtyFourAEDocument = null;
	
	public ITRScheduleBPForITR4S(BusinessProfessionDocument businessProfessionDocument, SchFourtyFourAEDocument schFourtyFourAEDocument) {
		// TODO Auto-generated constructor stub
		this.businessProfessionDocument = businessProfessionDocument;
		this.schFourtyFourAEDocument = schFourtyFourAEDocument;
	}
	/**
	 * This method is used to create ScheduleBP for {@link ITR4S}.<br/>
	 * Before using this method we need to create the instance of {@link ITRScheduleBPForITR4S} using it's defined Constructor.
	 * 
	 * @return {@link ScheduleBPForITR4S}
	 * */
	public ScheduleBPForITR4S getScheduleBPForITR4S(){
		Long incChargUnderBusiness = 0l;
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleBPForITR4S scheduleBPForITR4S = new ScheduleBPForITR4S();
		
		PersumptiveInc44AD persumptiveInc44AD = new PersumptiveInc44AD();
		NoBooksOfAccBS noBooksOfAccBS = new NoBooksOfAccBS();
		if(businessProfessionDocument!=null){
			persumptiveInc44AD.setGrsTrnOverOrReceipt(indianCurrencyHelper.bigIntegerRound(businessProfessionDocument.getGrossTurnOver()));
			persumptiveInc44AD.setTotPersumptiveInc44AD(indianCurrencyHelper.bigIntegerRound(businessProfessionDocument.getGrossPresumptIncome()));
			incChargUnderBusiness = incChargUnderBusiness + indianCurrencyHelper.longRound(businessProfessionDocument.getGrossPresumptIncome()) +
					indianCurrencyHelper.longRound(businessProfessionDocument.getGrossPresumptIncome())	;
			noBooksOfAccBS.setTotStkInTradAmt(indianCurrencyHelper.bigIntegerRound(businessProfessionDocument.getGrossStockTrade()));
			noBooksOfAccBS.setTotSundryCrdAmt(indianCurrencyHelper.bigIntegerRound(businessProfessionDocument.getGrossSundryCredit()));
			noBooksOfAccBS.setTotSundryDbtAmt(indianCurrencyHelper.bigIntegerRound(businessProfessionDocument.getGrossSundryDebt()));
		}
		PersumptiveInc44AE persumptiveInc44AE = new PersumptiveInc44AE();
		if(schFourtyFourAEDocument!=null){
			persumptiveInc44AE.setPersumptiveIncHeavyVehicle(indianCurrencyHelper.bigIntegerRound(schFourtyFourAEDocument.getTotal_deemedIncome_Heavy()));
			persumptiveInc44AE.setPersumptiveIncHeavyVehicle(indianCurrencyHelper.bigIntegerRound(schFourtyFourAEDocument.getTotal_deemedIncome_Light()));
			incChargUnderBusiness = incChargUnderBusiness + indianCurrencyHelper.longRound(schFourtyFourAEDocument.getTotal_deemedIncome_Heavy()) + 
			               indianCurrencyHelper.longRound(schFourtyFourAEDocument.getTotal_deemedIncome_Light());
		}
	
		scheduleBPForITR4S.setPersumptiveInc44AD(persumptiveInc44AD);
		scheduleBPForITR4S.setPersumptiveInc44AE(persumptiveInc44AE);
		scheduleBPForITR4S.setIncChargeableUnderBus(incChargUnderBusiness);
		scheduleBPForITR4S.setNoBooksOfAccBS(noBooksOfAccBS);	
		return scheduleBPForITR4S;
	}
}
