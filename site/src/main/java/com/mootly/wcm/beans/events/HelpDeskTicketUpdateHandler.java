package com.mootly.wcm.beans.events;

import java.util.List;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.component.support.forms.FormUtils;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HelpDeskTicketDocument;
import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.Service;
import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.CostModel;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail.DITSOAPOperation;
import com.mootly.wcm.channels.ChannelInfoWrapper;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRServiceDelivery;
import com.mootly.wcm.services.SequenceGenerator;
import com.mootly.wcm.services.ditws.AddClientDetails;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;

public class HelpDeskTicketUpdateHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean>{
	Logger logger = LoggerFactory.getLogger(HelpDeskTicketUpdateHandler.class);
	final SequenceGenerator sequenceGenerator;
	boolean isNew = false;
	
	public HelpDeskTicketUpdateHandler( SequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}
	
	@Override
	public boolean validateParentBean(HippoBean hippoBean, boolean isNew,
			List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		this.isNew = isNew; 
		return true;
	}
	
	@Override
	public void afterFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		super.afterFillParentBeanMap(hippoBean);
		if (hippoBean != null && hippoBean instanceof HelpDeskTicketDocument) {
			HelpDeskTicketDocument helpDeskTicketDocument = (HelpDeskTicketDocument) hippoBean;
			if (helpDeskTicketDocument.getIdentifier() == null) {
				String nextTicketId = sequenceGenerator.getNextId(SequenceGenerator.SEQUENCE_HELP_DESK_TICKET).toString();
				helpDeskTicketDocument.setIdentifier(nextTicketId);
			}
		}
	}	
}
