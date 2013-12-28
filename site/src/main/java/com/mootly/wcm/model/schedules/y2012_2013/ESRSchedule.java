package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.DeductUs35;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.Section351I;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.Section351Ii;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.Section351Iii;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.Section351Iv;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.Section352AA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.Section352AB;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleESR.DeductionUs35.TotUs35;

import java.lang.reflect.Field;

import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ESRSchedule {

	ScheduleESRDocument scheduleESRDocument = null;

	public ESRSchedule(ScheduleESRDocument scheduleESRDocument){
		this.scheduleESRDocument = scheduleESRDocument;
	}

	public ScheduleESR getScheduleESR(ITR itr){

		ScheduleESR scheduleESR = new ScheduleESR();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		//To set Dummy if Document is null
		if(scheduleESRDocument == null){
			ScheduleESRDocument scheduleESRDocumentDummy = new ScheduleESRDocument();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(scheduleESRDocumentDummy);
			Field[] fields =  ScheduleESRDocument.class.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().getSimpleName().equals(Double.class.getSimpleName())){
					directFieldAccessor.setPropertyValue(field.getName(), 0d);
				}
			}
			this.scheduleESRDocument = scheduleESRDocumentDummy;
		}

		DeductionUs35 deductionUs35 = new DeductionUs35();

		Section351I section351I = new Section351I();
		DeductUs35  deductUs35I = new DeductUs35();
		deductUs35I.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDebit1()));
		deductUs35I.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDeduct1()));
		deductUs35I.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtExcess1()));
		section351I.setDeductUs35(deductUs35I);
		deductionUs35.setSection351I(section351I);

		Section351Ii section351Ii = new Section351Ii();
		DeductUs35  deductUs35Ii = new DeductUs35();
		deductUs35Ii.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDebit2()));
		deductUs35Ii.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDeduct2()));
		deductUs35Ii.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtExcess2()));
		section351Ii.setDeductUs35(deductUs35Ii);
		deductionUs35.setSection351Ii(section351Ii);

		Section351Iii section351Iii = new Section351Iii();
		DeductUs35  deductUs35Iii = new DeductUs35();
		deductUs35Iii.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDebit3()));
		deductUs35Iii.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDeduct3()));
		deductUs35Iii.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtExcess3()));
		section351Iii.setDeductUs35(deductUs35Iii);
		deductionUs35.setSection351Iii(section351Iii);

		Section351Iv section351Iv = new Section351Iv();
		DeductUs35  deductUs35Iv = new DeductUs35();
		deductUs35Iv.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDebit4()));
		deductUs35Iv.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDeduct4()));
		deductUs35Iv.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtExcess4()));
		section351Iv.setDeductUs35(deductUs35Iv);
		deductionUs35.setSection351Iv(section351Iv);

		Section352AA section352AA = new Section352AA();
		DeductUs35  deductUs35AA = new DeductUs35();
		deductUs35AA.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDebit2AA()));
		deductUs35AA.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDeduct2AA()));
		deductUs35AA.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtExcess2AA()));
		section352AA.setDeductUs35(deductUs35AA);
		deductionUs35.setSection352AA(section352AA);

		Section352AB section352AB = new Section352AB();
		DeductUs35  deductUs35AB = new DeductUs35();
		deductUs35AB.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDebit2AB()));
		deductUs35AB.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtDeduct2AB()));
		deductUs35AB.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getAmtExcess2AB()));
		section352AB.setDeductUs35(deductUs35AB);
		deductionUs35.setSection352AB(section352AB);

		TotUs35 totUs35 = new TotUs35();
		DeductUs35  deductUs35tot = new DeductUs35();
		deductUs35tot.setAmtDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getTotalDebit()));
		deductUs35tot.setAmtUs35Allowable(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getTotalDeduct()));
		deductUs35tot.setExcessAmtOverDebPL(indianCurrencyHelper.bigIntegerRound(scheduleESRDocument.getTotalExcess()));
		totUs35.setDeductUs35(deductUs35tot);
		deductionUs35.setTotUs35(totUs35);

		scheduleESR.setDeductionUs35(deductionUs35);

		return scheduleESR;
	}
}
