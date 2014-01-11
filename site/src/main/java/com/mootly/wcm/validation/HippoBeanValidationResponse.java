package com.mootly.wcm.validation;

import java.util.ArrayList;
import java.util.List;

import com.mootly.wcm.validation.HippoBeanValidationGeneric.ACTION;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.ACTION_REASON;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.TYPE;

/**
 * 
 * @author admin
 *
 */
public class HippoBeanValidationResponse {
	//List<HippoBeanValidationWarning> warnings;
	//List<HippoBeanValidationError> errors;
	List<HippoBeanValidationGeneric> messages;
	List<RepositoryUpdateRequest> repositoryUpdateRequests;
	
	
	public List<HippoBeanValidationGeneric> getActions() {
		return getMessages(TYPE.ACTION);
	}
	
	public List<HippoBeanValidationGeneric> getWarnings() {
		return getMessages(TYPE.WARNING);
	}

	public List<HippoBeanValidationGeneric> getErrors() {
		return getMessages(TYPE.ERROR);
	}
	
	public List<HippoBeanValidationGeneric> getMessages() {
		return messages;
	}
	
	public List<RepositoryUpdateRequest> getRepositoryUpdateRequests() {
		return repositoryUpdateRequests;
	}

	public void setRepositoryUpdateRequests(
			List<RepositoryUpdateRequest> repositoryUpdateRequests) {
		this.repositoryUpdateRequests = repositoryUpdateRequests;
	}

	public void setMessages(List<HippoBeanValidationGeneric> messages) {
		this.messages = messages;
	}

	public List<HippoBeanValidationGeneric> getMessages(TYPE type) {
		List<HippoBeanValidationGeneric> filteredList = null; 
		if (messages != null && messages.size() > 0) {
			filteredList = new ArrayList<HippoBeanValidationGeneric>();
			for (HippoBeanValidationGeneric hippoBeanValidationGeneric:messages) {
				if (hippoBeanValidationGeneric.getType() == type) {
					filteredList.add(hippoBeanValidationGeneric);
				}
			}
		}
		return filteredList;
	}
	
	public int getTotalMessages() {
		if (messages != null && messages.size() > 0){
			return messages.size();
		}
		return 0;
	}
	
	public int getTotalMessages(TYPE type) {
		int total = 0;
		if (messages == null) return total;
		for (HippoBeanValidationGeneric hippoBeanValidationGeneric:messages) {
			if (hippoBeanValidationGeneric.getType() == type) {
				total++;
			}
		}
		return total;
	}
	
	public int getTotalErrors() {
		return getTotalMessages(TYPE.ERROR);
	}
	
	public int getTotalWarnings() {
		return getTotalMessages(TYPE.WARNING);
	}
	
	public int getTotalInformations() {
		return getTotalMessages(TYPE.INFORMATION);
	}
	
	public int getTotalPromotions() {
		return getTotalMessages(TYPE.PROMOTION);
	}
	
	public int getTotalActions() {
		return getTotalMessages(TYPE.ACTION);
	}
	
	public boolean getHasMessages() {
		int totalMessages = getTotalMessages();
		if (totalMessages > 0) {
			return true;
		}
		return false;
	}
	
	public boolean getHasErrors() {
		int totalErrors = getTotalErrors();
		if (totalErrors > 0) {
			return true;
		}
		return false;
	}
	
	public boolean getHasWarnings() {
		int totalWarnings = getTotalWarnings();
		if (totalWarnings > 0) {
			return true;
		}
		return false;
	}
	
	public boolean getHasActions() {
		int totalActions = getTotalActions();
		if (totalActions > 0) {
			return true;
		}
		return false;
	}
	
	public HippoBeanValidationGeneric getActionByName(String actionName) {
		List<HippoBeanValidationGeneric> actions = getActions();
		if (actions != null) {
			for (HippoBeanValidationGeneric anAction:actions) {
				if (anAction.getAction() != null && anAction.getAction().name().equals(actionName)) {
					return anAction;
				}
			}
		}
		return null;
	}
	
	public HippoBeanValidationGeneric getAction(ACTION action) {
		List<HippoBeanValidationGeneric> actions = getActions();
		if (actions != null) {
			for (HippoBeanValidationGeneric anAction:actions) {
				if (anAction.getAction() != null && anAction.getAction() == action) {
					return anAction;
				}
			}
		}
		return null;
	}
	
	
	public HippoBeanValidationGeneric getMessageByKey(String key,TYPE type) {
		List<HippoBeanValidationGeneric> messagesByType = getMessages(type);
		if (messagesByType != null) {
			for (HippoBeanValidationGeneric hippoBeanValidationGeneric:messagesByType) {
				if (hippoBeanValidationGeneric.getMessageKey() != null && key.equals(hippoBeanValidationGeneric.getMessageKey() )) {
					return hippoBeanValidationGeneric;
				}
			}
		}
		
		return null;
	}
	
	
	public boolean addError(HippoBeanValidationGeneric error) {
		if (messages == null) messages = new ArrayList<HippoBeanValidationGeneric>();
		error.setType(TYPE.ERROR);
		boolean ret = messages.add(error);
		return ret;
	}
	
	public boolean addWarning(HippoBeanValidationGeneric warning) {
		if (messages == null) messages = new ArrayList<HippoBeanValidationGeneric>();
		warning.setType(TYPE.ERROR);
		boolean ret = messages.add(warning);
		return ret;
	}
	
	public boolean addMessage(HippoBeanValidationGeneric message) {
		if (messages == null) messages = new ArrayList<HippoBeanValidationGeneric>();
		message.setType(TYPE.INFORMATION);
		boolean ret = messages.add(message);
		return ret;
	}
	
	public boolean addAction(ACTION action,ACTION_REASON actionReason) {
		if (messages == null) messages = new ArrayList<HippoBeanValidationGeneric>();
		if (getAction(action) != null) {
			return true;
		}
		HippoBeanValidationGeneric newAction = new HippoBeanValidationGeneric(TYPE.ACTION,"");
		newAction.setAction(action);
		newAction.setType(TYPE.ACTION);
		boolean ret = messages.add(newAction);
		return ret;
	}
	
	public boolean addRepositoryUpdateRequest(RepositoryUpdateRequest repositoryUpdateRequest) {
		if (repositoryUpdateRequests == null) repositoryUpdateRequests = new ArrayList<RepositoryUpdateRequest>();
		boolean ret = repositoryUpdateRequests.add(repositoryUpdateRequest);
		return ret;
	}
}
