/**
 * 
 */
package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

import com.mootly.wcm.beans.AssetAndLiabilityDocument;
import com.mootly.wcm.beans.BusinessProfessionDocument;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.ManufactureFinishedProductsDocument;
import com.mootly.wcm.beans.ManufactureRawMatDocument;
import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.beans.ScheduleFiveADocument;

/**
 * @author admin
 *
 */
public enum ITRXmlValidation {

	VALIDATE1(true,"memberschedule5a",ScheduleFiveADocument.class.getSimpleName(),null,null,false,new ITRForm[]{ITRForm.ITR2,ITRForm.ITR4},new ValidateProperty[]{}),
	VALIDATE2(true,"schedule-business-profession",BusinessProfessionDocument.class.getSimpleName(),null,null,false,new ITRForm[]{ITRForm.ITR4S},new ValidateProperty[]{}),
	VALIDATE3(true,"businessnature",NatureBusinessDocument.class.getSimpleName(),null,null,false,new ITRForm[]{ITRForm.ITR4S,ITRForm.ITR4},new ValidateProperty[]{}),
	VALIDATE4(true,"assetandliability",AssetAndLiabilityDocument.class.getSimpleName(),null,null,false,new ITRForm[]{ITRForm.ITR3,ITRForm.ITR4},new ValidateProperty[]{ValidateProperty.PROP_1,ValidateProperty.PROP_2}),
	VALIDATE5(true,"memberincomefromfirmsItr3",IncomeFromFirmsDocument.class.getSimpleName(),null,null,false,new ITRForm[]{ITRForm.ITR3},new ValidateProperty[]{}),
	VALIDATE6(true,"manufacture_rawmaterials",ManufactureRawMatDocument.class.getSimpleName(),"manufacture_finishedgoods",ManufactureFinishedProductsDocument.class.getSimpleName(),true,new ITRForm[]{ITRForm.ITR4},new ValidateProperty[]{}),
	VALIDATE7(true,"reseller-package",ResellerSignupDocument.class.getSimpleName(),null,null,false,ITRForm.values(),new ValidateProperty[]{ValidateProperty.PROP_6}),
	UNKOWN;

	boolean validateOrNot;//Decide that we will validate or not
	String screenSiteMapRefID;//sitemapRefID of Screen that need to be reviewed
	String documentName;//name of Document for Screen
	String dependScreenSiteMapRefID;//added siteMapRef ID of Dependent Screen  
	String dependDocumentName;//name of document of dependent screen
	boolean crossValidate;//want to validate at cross-over i.e from both side
	ITRForm[] itrForms;//List of all ITRForm that will validate for validation
	ValidateProperty[] validateProperty;//name of all dependent screen on which this will depend

	private ITRXmlValidation() {
		// TODO Auto-generated constructor stub
	}

	private ITRXmlValidation(boolean validateOrNot, String screenSiteMapRefID, String documentName, String dependScreenSiteMapRefID, String dependDocumentName, boolean crossValidate, ITRForm[] itrForm, ValidateProperty[] validateProperty){

		this.validateOrNot = validateOrNot;
		this.screenSiteMapRefID = screenSiteMapRefID;
		this.documentName = documentName;
		this.dependScreenSiteMapRefID = dependScreenSiteMapRefID;
		this.dependDocumentName = dependDocumentName;
		this.crossValidate = crossValidate;
		this.itrForms = itrForm;
		this.validateProperty = validateProperty;
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

	public ValidateProperty[] getValidateProperty() {
		return validateProperty;
	}

	public String getDependDocumentName() {
		return dependDocumentName;
	}
	
	public String getDependScreenSiteMapRefID() {
		return dependScreenSiteMapRefID;
	}
	
	public boolean isCrossValidate() {
		return crossValidate;
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
