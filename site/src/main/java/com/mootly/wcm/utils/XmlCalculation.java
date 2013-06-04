package com.mootly.wcm.utils;


import java.io.StringWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import in.gov.incometaxindiaefiling.y2012_2013.itr1.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.itr1.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address.Phone;
import in.gov.incometaxindiaefiling.y2012_2013.master.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.master.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.master.ITR1TaxComputation;
import in.gov.incometaxindiaefiling.y2012_2013.master.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address;
import in.gov.incometaxindiaefiling.y2012_2013.master.FilingStatus;
import in.gov.incometaxindiaefiling.y2012_2013.master.ITR1IncomeDeductions;
import in.gov.incometaxindiaefiling.y2012_2013.master.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.master.Refund;
import in.gov.incometaxindiaefiling.y2012_2013.master.Refund.DepositToBankAccount;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonOthThanSal;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonOthThanSals;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonSalaries;
import in.gov.incometaxindiaefiling.y2012_2013.master.TDSonSalary;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxPaid;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxPayment;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxPayments;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxesPaid;
import in.gov.incometaxindiaefiling.y2012_2013.master.Verification;
import in.gov.incometaxindiaefiling.y2012_2013.master.Verification.Declaration;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TdsFromSalaryDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.TdsFromSalaryDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.services.IndianCurrencyHelper;


@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class,
		HouseIncomeDetail.class,HouseProperty.class,OtherSourcesDocument.class,AdvanceTaxDocument.class,AdvanceTaxDetail.class,TdsFromSalaryDocument.class,
		TdsFromSalaryDetail.class,TdsFromothersDocument.class,SelfAssesmetTaxDocument.class,FormSixteenDocument.class,FormSixteenDetail.class})

public class XmlCalculation {

	//method to calculate gross total
	public long grossTotal(HstRequest request,HstResponse response){
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		//HouseIncomeDetail houseIncomeDetail = (HouseIncomeDetail) request.getAttribute(HouseIncomeDetail.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		//BigInteger salarytotal=new BigInteger("0");
		long longsalarytotal=0;
		long houseIncome=0;
		long houseIncomeTotal=0;
		long grosstotal=0;
		long otherincome=0;
		BigInteger GrossIncome=new BigInteger("0");
		BigInteger GrossIncomeTotal=new BigInteger("0");

		if( formSixteenDocument!=null){
			if ( formSixteenDocument.getFormSixteenDetailList() != null && formSixteenDocument.getFormSixteenDetailList().size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:formSixteenDocument.getFormSixteenDetailList()){
					if(formSixteenDetail.getIncome_chargable_tax()!=null){
					GrossIncome=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax());
					GrossIncomeTotal=GrossIncomeTotal.add(GrossIncome);
					}
				}
			}
		}
		BigInteger Penson=new BigInteger("0");
		if(salaryIncomeDocument!=null){
			Penson = indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal());
		}
		BigInteger TotalSalaryIncome=new BigInteger("0");
		TotalSalaryIncome = GrossIncomeTotal.add(Penson);
		longsalarytotal = TotalSalaryIncome.longValue();

		if(houseProperty!=null){
			if (houseProperty.getHouseIncomeDetailList() != null && houseProperty.getHouseIncomeDetailList().size() > 0 ){
				for(HouseIncomeDetail houseIncomeDetail: houseProperty.getHouseIncomeDetailList()){
					houseIncome = indianCurrencyHelper.longRound(houseIncomeDetail.getIncome_hproperty());
					houseIncomeTotal = houseIncomeTotal+houseIncome;
				}
			}
		}

		if(otherSourcesDocument!=null){
			otherincome = indianCurrencyHelper.longRound(otherSourcesDocument.getTaxable_income());
		}
		grosstotal = longsalarytotal+houseIncomeTotal+otherincome;

		return grosstotal;
	}

}
