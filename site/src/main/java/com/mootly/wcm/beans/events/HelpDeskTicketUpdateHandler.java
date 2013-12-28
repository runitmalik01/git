package com.mootly.wcm.beans.events;

import java.util.List;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.HelpDeskTicketDocument;
import com.mootly.wcm.services.SequenceGenerator;

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
