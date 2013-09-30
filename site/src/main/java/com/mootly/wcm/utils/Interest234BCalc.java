package com.mootly.wcm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class Interest234BCalc {

	public Double getInterest235B(FinancialYear financialYear, Double nettaxLiability , Double taxLiability, SelfAssesmetTaxDocument selfAssesmetTaxDocument){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Map<Date,Double> totalMapFor234B = new TreeMap<Date, Double>();

		Double intB = 0d;

		DateFormat formatter ;
		Date currentDate = null;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		//Here my logic is to make due date dependent on Financial Year
		String dueDatefor234Bstr = "31/03/"+financialYear.getEndYear();
		Date dueDatefor234B = null;
		try {
			currentDate = formatter.parse(ITRXmlGeneratorServiceCommon.getCurrentDateInIndiaAsString());
			dueDatefor234B  = indianCurrencyHelper.parsedate(dueDatefor234Bstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalMapFor234B.put(dueDatefor234B, nettaxLiability);
		totalMapFor234B.put(currentDate, 0d);

		//Here i am getting Amount with corresponding date and putting into Tree MAP
		if( selfAssesmetTaxDocument!=null){
			List<SelfAssesmentTaxDetail> listOfSelfAssesmentTaxDetail = selfAssesmetTaxDocument.getSelfAssesmentDetailList() ;
			if (listOfSelfAssesmentTaxDetail != null && listOfSelfAssesmentTaxDetail.size() > 0 ){
				for(SelfAssesmentTaxDetail selfAssesmentTaxDetail:listOfSelfAssesmentTaxDetail){
					double amount = selfAssesmentTaxDetail.getP_Amount();
					String selfAssessmentDatestr = selfAssesmentTaxDetail.getDateStr();
					//calculating difference between due date and selfassessment date
					Date selfAssessmentDate = null;
					try {
						selfAssessmentDate = indianCurrencyHelper.parsedate(selfAssessmentDatestr);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(!totalMapFor234B.isEmpty()){
						Date savedKey = null;
						for(Date key : totalMapFor234B.keySet()){
							if(key.getMonth() == selfAssessmentDate.getMonth() && key.getYear() == selfAssessmentDate.getYear()){
								amount = amount + totalMapFor234B.get(key);
								savedKey = key;
							}
						}
						if(savedKey != null){
							totalMapFor234B.remove(savedKey);
						}
						totalMapFor234B.put(selfAssessmentDate, amount);
					}else{
						totalMapFor234B.put(selfAssessmentDate, amount);
					}
				}
			}
		}

		double preAmount = 0d;double currAmount = 0d;

        //Here i am calculating Interest for Section 234B if Tax Liability is greater than 10000
		if(taxLiability > 10000){
			for(int i=0;i<totalMapFor234B.keySet().toArray().length;i++){
				Date startDate = (Date) totalMapFor234B.keySet().toArray()[i];
				try{
					Date endDate = (Date) totalMapFor234B.keySet().toArray()[i+1];
					int diffInMonths = indianCurrencyHelper.getDiffInMonths(startDate, endDate);
					if(i==1){
						preAmount = totalMapFor234B.get(totalMapFor234B.keySet().toArray()[i-1]);
					}
					currAmount = totalMapFor234B.get(totalMapFor234B.keySet().toArray()[i]);
					if(preAmount !=0){
						currAmount = (preAmount - currAmount) > 0 ? (preAmount - currAmount):0;
						preAmount = currAmount;
					}
					intB = intB + Math.round(currAmount*diffInMonths/100);
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Error in index"+e);
					break;
				}
			}
		}

		return intB;
	}

}
