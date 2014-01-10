package com.mootly.wcm.services.memberaudit;

import com.mootly.wcm.services.memberaudit.model.EfileStatus;

public interface MemberAuditService {
	
	/**
	 * Did our service made an attemp to eFile the return to DIT
	 * @return
	 */
	public EfileStatus getEfileStatus();
	
	
	
}
