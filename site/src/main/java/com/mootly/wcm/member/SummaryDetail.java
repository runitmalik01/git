/*
 * In this class we are creating a document for showing detailed summary for his/her return
 * @author abhishek
 * 27/11/2013
 *
 */
package com.mootly.wcm.member;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.InterestDoc;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPayment;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.RebateSec90Document;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.events.MemberPersonalInfoUpdateHandler;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.IndianCurrencyHelper;

@PrimaryBean(primaryBeanClass=MemberPersonalInformation.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,SelfAssesmentTaxDetail.class,SalaryIncomeDetail.class,DeductionDocument.class,
		DeductionDocumentDetail.class,InterestDoc.class,FormSixteenDocument.class,FormSixteenDetail.class,RebateSec90Document.class,AdjustmentOfLossesCom.class,
		AdjustmentOfLossesDoc.class,MemberPayment.class})
public class SummaryDetail extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(SummaryDetail.class);
	FormMap savedValuesFormMap=null;
	String memberName = null;
	MemberPersonalInformation parentBean=null;
	HouseProperty hpBean=null;
	MemberPersonalInfoUpdateHandler memberPersonalInfoUpdateHandler = null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		//being member return of getMemberPersonalInformation() of ITReturnComponent it return previous entered and viewed value.
		parentBean =  (MemberPersonalInformation)request.getAttribute("parentBean"); //getMemberPersonalInformation();
		String assYear= getITRInitData(request).getAssessmentYear();
		if(null!=assYear){
			request.setAttribute("assYear", assYear);
		}
		// here setting for fetching value in detailed summary
		if(null!=parentBean){
			request.setAttribute("parentBean", parentBean);
		}
		FinancialYear financialYear =  (FinancialYear) request.getAttribute("financialYear");
		Map<String,HippoBean> inputBeans = new HashMap<String, HippoBean>();
		Enumeration<String> enmAttrNames = request.getAttributeNames();
		while (enmAttrNames.hasMoreElements()) {
			String attrName = enmAttrNames.nextElement();
			Object anObj = request.getAttribute(attrName);
			if (anObj instanceof HippoBean) {
				inputBeans.put(anObj.getClass().getSimpleName().toLowerCase(), (HippoBean) anObj);
			}
		}
		Map<String, Object> outputMap = null;
		try {
			outputMap = getBeanMap(financialYear, inputBeans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("inside map");
		if (outputMap != null) {
			for (String aKey:outputMap.keySet()) {
				Object anObj = outputMap.get(aKey);
				request.setAttribute(aKey, anObj);
			}
		}
	}

	/*
	 * In this class we are creating a document for showing detailed summary for his/her return
	 * @author 
	 * @param financial year
	 * @param input beans
	 * @return map
	 * 27/11/2013
	 *
	 */
	public  Map<String,Object> getBeanMap(FinancialYear financialYear,Map<String,HippoBean> inputBeans) throws Exception {
		log.info("inside main method");
		Map<String,Object> outputMap = new HashMap<String, Object>();
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) inputBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) inputBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) inputBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) inputBeans.get(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) inputBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
		TdsFromSalaryDocument tdsFromSalaryDocument = (TdsFromSalaryDocument) inputBeans.get(TdsFromSalaryDocument.class.getSimpleName().toLowerCase());
		TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) inputBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
		SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) inputBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
		DeductionDocument deductionDocument = (DeductionDocument) inputBeans.get(DeductionDocument.class.getSimpleName().toLowerCase());
		InterestDoc interestDoc = (InterestDoc) inputBeans.get(InterestDoc.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) inputBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
		RebateSec90Document rebateSec90Document = (RebateSec90Document) inputBeans.get(RebateSec90Document.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) inputBeans.get(CapitalAssetDocument.class.getSimpleName().toLowerCase());

		//starting for employer
		if( formSixteenDocument!=null){
			double totaltdssal=0.0d;
			outputMap.put("formSixteenDocument", formSixteenDocument);
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			outputMap.put("listOfFormSixteenDetail", listOfFormSixteenDetail);
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					double amt1=0.0d;
					double amt2=0.0d;
					if(formSixteenDetail.getDed_ent_1()!=null)
					{
						amt1 =formSixteenDetail.getDed_ent_1();
					}
					if(formSixteenDetail.getDed_ent_3()!=null)
					{
						amt2=formSixteenDetail.getDed_ent_3();
					}
					totaltdssal=amt1+amt2;
					outputMap.put("totaltdssal",totaltdssal);

				}
			}
		}
		// interest 234 calculation
		IndianCurrencyHelper indianCurrencyHelper= new IndianCurrencyHelper();
		/*IndianCurrencyHelper indianCurrencyHelper= new IndianCurrencyHelper();
		XmlCalculation xmlCalculation = new XmlCalculation();
		Map<String,Object> resultMapINTEREST = xmlCalculation.interestCalc(financialYear, inputBeans, itr1TaxComputation.getNetTaxLiability());
		BigInteger Interest234A = new BigInteger("0");
		BigInteger Interest234B = new BigInteger("0");
		BigInteger Interest234C = new BigInteger("0");
		BigInteger TotalInterest = new BigInteger("0");
		Interest234A = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intA").toString()));
		//request.setAttribute("Interest234A", Interest234A);
		outputMap.put("Interest234A", Interest234A);
		Interest234B = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intB").toString()));
		//request.setAttribute("Interest234B", Interest234B);
		outputMap.put("Interest234B", Interest234B);
		Interest234C = indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("ic").toString()));
		//request.setAttribute("Interest234C", Interest234C);
		outputMap.put("Interest234C", Interest234C);*/



		if( houseProperty!=null){
			outputMap.put("houseProperty", houseProperty);

		}
		// for advance tax
		if(advanceTaxDocument!=null){
			double totaladvtax=0.0d;
			outputMap.put("advncTaxDoc", advanceTaxDocument);
			List<AdvanceTaxDetail> listAdvanceTaxDetail = advanceTaxDocument.getAdvanceTaxDetailList();
			outputMap.put("listAdvanceTaxDetail", listAdvanceTaxDetail);
			if ( listAdvanceTaxDetail != null && listAdvanceTaxDetail.size() > 0 ){
				for(AdvanceTaxDetail advanceTaxDetail:listAdvanceTaxDetail){
					double amt=advanceTaxDetail.getP_Amount();
					totaladvtax=totaladvtax+amt;
					outputMap.put("totaladvtax",totaladvtax);

				}
			}
		}
		// code for finding number of month

		int diffInMonths = 0;
		DateFormat formatter ;
		Date currentDate = null;
		Date fixedDueDate = null;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			currentDate = formatter.parse(ITRXmlGeneratorServiceCommon.getCurrentDateInIndiaAsString());
			fixedDueDate = indianCurrencyHelper.parsedate("31/07/"+financialYear.getEndYear());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date varDueDate = financialYear.getDueDate(memberPersonalInformation.getSelectedITRForm(), memberPersonalInformation.getState()).getTime();

		if(currentDate.after(varDueDate)){
			diffInMonths = indianCurrencyHelper.getDiffInMonths(fixedDueDate, currentDate);
		}
		outputMap.put("diffInMonths", diffInMonths);


		// for finding tds from pension
		double bigTdsPension=0.0d;
		int rate=1;
		outputMap.put("rate", rate+"%");

		if( salaryIncomeDocument!=null){
			List<SalaryIncomeDetail> listOfSalaryIncomeDetail = salaryIncomeDocument.getSalaryIncomeDetailList();
			if ( listOfSalaryIncomeDetail != null && listOfSalaryIncomeDetail.size() > 0 ){
				for(SalaryIncomeDetail salaryIncomeDetail:listOfSalaryIncomeDetail){
					if(salaryIncomeDetail.getTdsPension()!=null){
						bigTdsPension=salaryIncomeDetail.getTdsPension();
						outputMap.put("bigTdsPension", bigTdsPension);
					}
				}
			}
		}
		// for deduction document
		if(deductionDocument!=null){
			double totaldeductions=0.0d;
			outputMap.put("deductionDocument", deductionDocument);
			List<DeductionDocumentDetail> listDeductionDocumentDetail = deductionDocument.getDeductionDocumentDetailList();
			outputMap.put("listdedctDoc", listDeductionDocumentDetail);
			if ( listDeductionDocumentDetail != null && listDeductionDocumentDetail.size() > 0 ){
				for(DeductionDocumentDetail deductionDocumentDetail:listDeductionDocumentDetail){
					/*double amt=advanceTaxDetail.getP_Amount();
					totaladvtax=totaladvtax+amt;
					outputMap.put("totaladvtax",totaladvtax);*/

				}
			}
		}
		//for other income doc
		if(null!=otherSourcesDocument){
			outputMap.put("osDoc", otherSourcesDocument);
		}
		//for house property doc
		if(null!=houseProperty){
			outputMap.put("hpDoc", houseProperty);
		}
		if(null!=capitalAssetDocument)
		{
			outputMap.put("cpDoc", capitalAssetDocument);
		}
		//for pension doc
		if(null!=salaryIncomeDocument){
			outputMap.put("salDoc", salaryIncomeDocument);
		}
		if(null!=tdsFromSalaryDocument){
			outputMap.put("tdsfrmsal", tdsFromSalaryDocument);
		}
		if(null!=selfAssesmetTaxDocument){
			outputMap.put("selfassess", selfAssesmetTaxDocument);
			double totalself=0.0d;
			Date selfDate = null;
			List<SelfAssesmentTaxDetail> listSelfAssesmentTaxDetail=selfAssesmetTaxDocument.getSelfAssesmentDetailList();
			if ( listSelfAssesmentTaxDetail != null && listSelfAssesmentTaxDetail.size() > 0 ){
				for(SelfAssesmentTaxDetail selfAssesmentTaxDetail:listSelfAssesmentTaxDetail){
					double amt=0.0d;

					if(selfAssesmentTaxDetail.getP_Amount()!=null){
						amt=selfAssesmentTaxDetail.getP_Amount();
						selfDate = indianCurrencyHelper.parsedate(selfAssesmentTaxDetail.getDateStr());
					}
					totalself=totalself+amt;
					outputMap.put("totalself",totalself);
					outputMap.put("selfDate",selfDate);
					if(currentDate.after(varDueDate)){
						diffInMonths = indianCurrencyHelper.getDiffInMonths(fixedDueDate, selfDate);
					}
					outputMap.put("selfassDiff", diffInMonths);


				}
			}
		}
		if(null!=tdsFromothersDocument){
			double totalTDS=0.0d;
			outputMap.put("tdsOther", tdsFromothersDocument);
			List<TdsOthersDetail> listTdsFromSalaryDetail = tdsFromothersDocument.getTdsSalaryDetailList();
			outputMap.put("listTdsFromSalaryDetail", listTdsFromSalaryDetail);
			if ( listTdsFromSalaryDetail != null && listTdsFromSalaryDetail.size() > 0 ){
				for(TdsOthersDetail tdsOthersDetail:listTdsFromSalaryDetail){
					double amt=tdsOthersDetail.getP_Amount();
					totalTDS=totalTDS+amt;
					log.info("value is"+totalTDS);
					outputMap.put("totalTDS",totalTDS);

				}
			}
		}
		return outputMap;
	}

}
