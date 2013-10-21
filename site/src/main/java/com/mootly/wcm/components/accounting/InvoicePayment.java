package com.mootly.wcm.components.accounting;

import java.util.Map;

import javax.servlet.ServletContext;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.citruspay.PaymentService.BANK_ISSUER;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.Transaction.CARD_TYPE;
import com.mootly.wcm.services.citruspay.Transaction.PAYMENT_MODE;

@PrimaryBean(primaryBeanClass=InvoiceDocument.class)
@ChildBean(childBeanClass=InvoicePaymentDetail.class)
@RequiredBeans(requiredBeans={MemberPersonalInformation.class,InvoiceDocument.class})
@FormFields(fieldNames={"paymentMemo","paymentAmount","authCode","preAuthCode","checkNo","checkDate","checkBank","checkBranch","checkLocation","cashAddress","cashContactNumber","cashBestTime","rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime"},
fieldNamesVendorOnly={"paymentVerificationStatus"})
//@RequiredFields(fieldNames={"paymentType"})
@DataTypeValidationFields(fieldNames={"rtgsDate"},dataTypes={DataTypeValidationType.INDIANDATE})
public class InvoicePayment extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(InvoicePayment.class);
	PaymentType paymentType = null;
	Transaction transaction = null;
	String returnSiteMapRefID = "payment-success-";
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
					throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		/*ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		transaction =	context.getBean(Transaction.class);*/
	}
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		super.doBeforeRender(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		String urlPaymentType = getPublicRequestParameter(request, "paymentType");
		if(urlPaymentType!=null){
			for(PaymentType payType:PaymentType.values()){
				if(payType.equals(PaymentType.valueOf(urlPaymentType))){
					paymentType = PaymentType.valueOf(urlPaymentType);
				}
			}
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		super.doAction(request, response);
		String paymentTypeStr = request.getRequestContext().getResolvedSiteMapItem().getParameter("paymentType");
		if (paymentTypeStr != null) {
			paymentType = PaymentType.valueOf(paymentTypeStr);
		}
		String urlPaymentType = getPublicRequestParameter(request, "paymentType");
		if(urlPaymentType!=null){
			for(PaymentType payType:PaymentType.values()){
				if(payType.equals(PaymentType.valueOf(urlPaymentType))){
					paymentType = PaymentType.valueOf(urlPaymentType);
				}
			}
		}
		request.setAttribute("type", "payment");
		request.setAttribute("paymentType", paymentType);
		MemberPersonalInformation personalInformation = (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		InvoiceDocument invDoc = (InvoiceDocument) getParentBean(); 
		returnSiteMapRefID = returnSiteMapRefID + paymentType.name();
		String address = personalInformation.getFlatDoorBuilding()+","+personalInformation.getRoadStreet()+","+personalInformation.getAreaLocality();
		address = address.replaceAll(",,", ",");
		String memberLoginName = getUserName().toLowerCase();
		String email = getUserName().toLowerCase();
		String amount = String.valueOf(invDoc.getAmountDue());
		ITReturnComponent itReturnComponent = new ITReturnComponent();

		String returnUrl = itReturnComponent.getRedirectURLForSiteMapItem(request, response, null, returnSiteMapRefID, getFinancialYear(), getTheFolderContainingITRDocuments(), getPAN());
		//String returnUrl = "http://www.wealth4india/site/blah";
		String notifyUrl = "http://www.wealth4india/site/blah";
		//FinancialYear fy = FinancialYear.getByDisplayName(personalInformation.getFinancialYear());
		if(paymentType.equals(PaymentType.NET_BANKING)){
			Map<String, Object> output = getTransaction().acceptITRPaymentByNetBanking(memberLoginName, getFinancialYear(), getPAN(), 
					returnUrl, notifyUrl, BANK_ISSUER.ICICI_BANK, amount, email, personalInformation.getFirstName(), personalInformation.getLastName(),
					personalInformation.getMobile(), address, personalInformation.getTownCityDistrict(), personalInformation.getState(), personalInformation.getPinCode());
			System.out.println("test output"+output);
		}
		if(paymentType.equals(PaymentType.CREDIT_CARD) || paymentType.equals(PaymentType.DEBIT_CARD)){
			String cardHolderName = getFormMap().getField("cardHolderName").getValue();
			String expiryMonth = getFormMap().getField("expiryMonth").getValue();
			String expiryYear = getFormMap().getField("expiryYear").getValue();
			String cvvNumber = getFormMap().getField("cvvNumber").getValue();
			String cardNumber = getFormMap().getField("cardNumber").getValue();
			String cardType = getFormMap().getField("cardType").getValue();
			Map<String, Object> output = transaction.acceptITRPaymentByDebitOrCreditCard(
					//memberLoginName, financialYear, PAN, 
					// returnURL, notifyURL, paymentNode, 
					// cardHolderName, cardNumber, cardType, cvvNumber, expiryMonth, expiryYear, 
					// amount, email, firstName, lastName, mobile) (
					memberLoginName, getFinancialYear(), getPAN(), 
					returnUrl,notifyUrl,PAYMENT_MODE.valueOf(paymentType.toString()),
					cardHolderName,cardNumber, CARD_TYPE.valueOf(cardType),cvvNumber,expiryMonth,expiryYear,
					amount,email,personalInformation.getFirstName(),personalInformation.getLastName(),personalInformation.getMobile(),
					address, personalInformation.getTownCityDistrict(), personalInformation.getState(), personalInformation.getPinCode());
			System.out.println(output);
		}
	}

	@Override
	protected BeanLifecycle<HippoBean> getChildBeanLifeCycleHandler() {
		// TODO Auto-generated method stub
		return new InvoicePaymentDetailBeanHandler(this.paymentType);
	}


	/**
	 * This class is responsible to inject the invoice number every time an invoice is created
	 * @author admin
	 *
	 */
	class InvoicePaymentDetailBeanHandler implements BeanLifecycle<HippoBean> {

		final PaymentType paymentType;

		public InvoicePaymentDetailBeanHandler(PaymentType paymentType) {
			this.paymentType = paymentType;
		}
		@Override
		public void beforeCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterCreate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			SequenceGenerator sequenceGenerator = getSequenceGenerator();
			Long paymentTransactionId = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_PAYMENT);
			if (hippoBean != null && hippoBean instanceof InvoicePaymentDetail) {
				InvoicePaymentDetail invoicePaymentDetail = (InvoicePaymentDetail) hippoBean;
				invoicePaymentDetail.setPaymentTransactionId(String.valueOf(paymentTransactionId));
				invoicePaymentDetail.setPaymentType(paymentType);
				invoicePaymentDetail.setPaymentDate(IndianGregorianCalendar.getCurrentDateInIndiaAsDate());
			}
		}

		@Override
		public boolean beforeSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterSaveNewBean(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean beforeUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterUpdate(HippoBean hippoBean) {
			// TODO Auto-generated method stub

		}
	}
}
