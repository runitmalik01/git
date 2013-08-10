package com.mootly.wcm.services.ditws;

import java.util.Hashtable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author amit.patkar
 *
 */
public abstract class UpdateCaseService{
	static Logger logger = LoggerFactory.getLogger(UpdateCaseService.class);
	Map<String,String> staticInputMap;
				
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
		
	public Map<String, String> getStaticInputMap() {
		return staticInputMap;
	}
	
	public void setStaticInputMap(Map<String, String> staticInputMap) {
		this.staticInputMap = staticInputMap;
	}
		
	
	
	public abstract void saveToCRM(Hashtable activityHt,String activityXml,String caseId,String agentId,UpdateCaseType type)  throws Exception;  
	/**
	 * 
	 */
	public void updateCase (Hashtable activityHt) throws UpdateCaseException {
		try {
			UpdateCaseType type =  UpdateCaseType.valueOf((String) activityHt.get("Type"));
			String agentId = "admin";
			if (activityHt.contains("AgentId")) {
				agentId = (String) activityHt.get("AgentId");
			}
			String activityXml = (String) activityHt.get("ActivityXml");
			String caseId = (String) activityHt.get("CaseId");
			
			if (logger.isDebugEnabled()) {
				
				//content of the hashtable
				logger.debug("Parsing the Activity HT Object");
				for (Object key:activityHt.keySet()) {
					logger.debug("\tKey:" + key);
					logger.debug("\tValue:" + activityHt.get(key));
				}				
				//logger.debug(activityXml);
				//logger.debug(type);
				//logger.debug(agentId);
				//logger.debug(caseId);
			}	
			//parseCaseActivityXml(activityHt);
			saveToCRM(activityHt,activityXml, caseId,agentId,type);
		}catch (Exception ex) {
			throw new UpdateCaseException(ex);
		}
	}
		
}