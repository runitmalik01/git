package org.onehippo.forge.security.support.springsecurity.authentication;

import java.io.Serializable;

import javax.jcr.Node;

/**
 *  String channelPath = theMountNode.getProperty("hst:channelpath").getString();
			 String channelAbsPath = channelPath + "/" + "hst:channelinfo";
			 Node theChannelInfoNode = session.getNode(channelAbsPath);
			 boolean isReseller = false;
			 String resellerId = null;
			 if ( theChannelInfoNode.hasProperty("isReseller") ) {
				 isReseller = Boolean.valueOf( theChannelInfoNode.getProperty("isReseller").getString() );
			 }
			 if ( isReseller ) {
				 if (theChannelInfoNode.hasProperty("resellerId")) {
					 resellerId = theChannelInfoNode.getProperty("resellerId").getString().trim();
					 pathToRestrict = "/content/documents/mootlywcm/resellers/" + resellerId + "/members";
				 }
			 }
 * @author admin
 *
 */
public class HippoMountDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final String UUID;
	String channelAbsPath;
	String channelPath;
	Boolean isReseller;
	String resellerId;
	String pathToRestrict;
	
	public HippoMountDetail(String UUID) {
		this.UUID = UUID;
	}

	public final String getUUID() {
		return UUID;
	}

	public final String getChannelAbsPath() {
		return channelAbsPath;
	}

	public final void setChannelAbsPath(String channelAbsPath) {
		this.channelAbsPath = channelAbsPath;
	}


	public final String getResellerId() {
		return resellerId;
	}

	public final void setResellerId(String resellerId) {
		this.resellerId = resellerId;
	}

	public final String getPathToRestrict() {
		return pathToRestrict;
	}

	public final void setPathToRestrict(String pathToRestrict) {
		this.pathToRestrict = pathToRestrict;
	}

	public final String getChannelPath() {
		return channelPath;
	}

	public final void setChannelPath(String channelPath) {
		this.channelPath = channelPath;
	}

	public final Boolean getIsReseller() {
		return isReseller;
	}

	public final void setIsReseller(Boolean isReseller) {
		this.isReseller = isReseller;
	}
	
}
