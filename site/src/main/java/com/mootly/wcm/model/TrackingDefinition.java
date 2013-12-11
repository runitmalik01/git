/**
 * 
 */
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.InvoiceDocument;
import com.mootly.wcm.beans.Review;

/**
 * @author BEN-10
 *
 */
public enum TrackingDefinition {
	TRACKER_1(true,"Review Publish Request",Review.class,"reviews",false,ValidateProperty.PROP_3),
	TRACKER_2(true,"Payments Verified",InvoiceDocument.class,"members",true,ValidateProperty.PROP_4),
	TRACKER_3(true,"Payments Request",InvoiceDocument.class,"members",true,ValidateProperty.PROP_5),
	UNKNOWN;
	
	boolean isEnable;
	String trackerName;
	Class<? extends HippoBean> documentBean;
	String scope;
	boolean haveChild;
	ValidateProperty property;
	
	private TrackingDefinition() {
		// TODO Auto-generated constructor stub
	}
	
	private TrackingDefinition(boolean isEnable,String trackerName,Class<? extends HippoBean> documentBean,String scope,boolean haveChild,ValidateProperty property){
		this.isEnable = isEnable;
		this.trackerName = trackerName;
		this.documentBean = documentBean;
		this.scope = scope;
		this.haveChild = haveChild;
		this.property = property;
	}	
	
	public Class<? extends HippoBean> getDocumentBean() {
		return documentBean;
	}
	public ValidateProperty getProperty() {
		return property;
	}
	public String getScope() {
		return scope;
	}
	public String getTrackerName() {
		return trackerName;
	}
	public boolean isHaveChild() {
		return haveChild;
	}
	public boolean isEnable() {
		return isEnable;
	}
	
	public static List<TrackingDefinition> getOnTrakers(){
		List<TrackingDefinition> trakingDefs = new ArrayList<TrackingDefinition>();
		for(TrackingDefinition trakingDef:TrackingDefinition.values()){
			if(!trakingDef.equals(TrackingDefinition.UNKNOWN)){
				if(trakingDef.isEnable()){
					trakingDefs.add(trakingDef);
				}
			}
		}
		return trakingDefs;
	}	
}
