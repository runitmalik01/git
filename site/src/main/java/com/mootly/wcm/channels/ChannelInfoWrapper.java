package com.mootly.wcm.channels;

/**
 * 
 * @author admin
 *
 */
public final class ChannelInfoWrapper {
	
	final WebsiteInfo webSiteInfo; 
	
	public ChannelInfoWrapper(WebsiteInfo webSiteInfo) {
		this.webSiteInfo = webSiteInfo;
	}
	
	
	public boolean isEriEnabled() {
		String strEriEnabled = webSiteInfo.getEriEnabled();
		return Boolean.valueOf(strEriEnabled);
	}
	
}
