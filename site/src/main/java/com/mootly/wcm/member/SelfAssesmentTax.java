package com.mootly.wcm.member;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will taje value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass = SelfAssesmetTaxDocument.class)
@ChildBean(childBeanClass = SelfAssesmentTaxDetail.class)
@FormFields(fieldNames = { "bsr_codeself", "date_creditself",
		"Serial_challanself", "amountself", "isImportedFromDIT" })
@RequiredFields(fieldNames = { "bsr_codeself", "date_creditself",
		"Serial_challanself", "amountself" })
@DataTypeValidationFields(fieldNames = { "bsr_codeself", "Serial_challanself",
		"amountself", "date_creditself" }, dataTypes = {
		DataTypeValidationType.BSR, DataTypeValidationType.CHALLANNO,
		DataTypeValidationType.DECIMAL, DataTypeValidationType.INDIANDATE })
public class SelfAssesmentTax extends ITReturnComponent {

	private static final Logger log = LoggerFactory
			.getLogger(TdsFromSalary.class);

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if (log.isInfoEnabled()) {
			log.info("this is do before render of self assesment tax");
		}

		DateFormat formatter;
		Date currentDate = null;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			currentDate = formatter.parse(ITRXmlGeneratorServiceCommon
					.getCurrentDateInIndiaAsString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		formatter = new SimpleDateFormat("dd/MM/yyy");
		String currentDateStr = formatter.format(currentDate);
		FinancialYear financialYear = (FinancialYear) request
				.getAttribute("financialYear");
		int endYear = financialYear.getEndYear();
		request.setAttribute("endYear", endYear);
		request.setAttribute("currDate", currentDateStr);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
		if (log.isInfoEnabled()) {
			log.info("this is do Action of self assesment tax");
		}
	}
}
