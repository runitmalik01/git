/**
 * 
 */
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;

/**
 * @author admin
 *
 */
public enum ITRXmlValidation {

	VALIDATE1(true,"memberschedule5a",ScheduleFiveADocument.class.getSimpleName(),new ITRForm[]{ITRForm.ITR2,ITRForm.ITR4}),
	VALIDATE2(true,"schedule-business-profession",BusinessProfessionDocument.class.getSimpleName(),new ITRForm[]{ITRForm.ITR4S}),
	VALIDATE3(true,"businessnature",NatureBusinessDocument.class.getSimpleName(),new ITRForm[]{ITRForm.ITR4S}),
	UNKOWN;

	boolean validateOrNot;//Decide that we will validate or not
	String screenSiteMapRefID;//sitemapRefID of Screen that need to be reviewed
	String documentName;//name of Document for Screen
	ITRForm[] itrForms;//List of all ITRForm that will validate for validation

	private ITRXmlValidation() {
		// TODO Auto-generated constructor stub
	}

	private ITRXmlValidation(boolean validateOrNot,String screenSiteMapRefID,String documentName,ITRForm[] itrForm){
		
		this.validateOrNot = validateOrNot;
		this.screenSiteMapRefID = screenSiteMapRefID;
		this.documentName = documentName;
		this.itrForms = itrForm;
	}

	public boolean isValidateOrNot() {
		return validateOrNot;
	}

	public String getScreenSiteMapRefID() {
		return screenSiteMapRefID;
	}

	public String getDocumentName() {
		return documentName;
	}

	public ITRForm[] getItrForms() {
		return itrForms;
	}

	public static List<ITRXmlValidation> getListOfXmlValidation(){
		List<ITRXmlValidation> listOfITRXmlValidation = new ArrayList<ITRXmlValidation>();
		for(ITRXmlValidation itrXmlValidation:ITRXmlValidation.values()){
			if(itrXmlValidation.isValidateOrNot() && !itrXmlValidation.equals(ITRXmlValidation.UNKOWN)){
				listOfITRXmlValidation.add(itrXmlValidation);
			}	
		}
		return listOfITRXmlValidation;
	}
}
