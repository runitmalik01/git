/**
 * 
 */
package com.mootly.wcm.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.ObjectBeanManager;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.ScreenFiedSetDocument;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.beans.compound.ScreenFieldConfig;
import com.mootly.wcm.beans.compound.ScreenFieldSetDetail;
import com.mootly.wcm.beans.compound.ValueListDocumentDetail;
import com.mootly.wcm.components.ITReturnComponent;

/**
 * @author BEN-10
 *
 */
public class ITRBalanceSheet extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(ITRBalanceSheet.class);
	private String basePathToValueList = null;
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		//Test Logic for to Create Screen from Screen Config.
		try {
			//create the object of objectBeanManager
			ObjectBeanManager objectBeanManager = getObjectBeanManager(request);
			basePathToValueList = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath()+"/common/valuelists/";
			//number value list which is used to decide how fields will be in field sets
			ValueListDocument numValueListDocument = (ValueListDocument) objectBeanManager.getObject(basePathToValueList+"numbervaluelist");
			//this Map have all form Field used
			ValueListDocument frmFieldTypeValueListDoc = (ValueListDocument) objectBeanManager.getObject(basePathToValueList+"formfields");
			//get FieldSet document with same name as screen field Config document i.e responsible for presentation of screen
			ScreenFiedSetDocument screenFiedSetDocument = getSiteContentBaseBean(request).getBean("configuration/screenconfigs/screenpresentation/balancesheet");
			//get the ScreenConfig Document
			ScreenConfigDocument screenConfigDocument = getSiteContentBaseBean(request).getBean("configuration/screenconfigs/balancesheet");
			//if screen config have any any DropDown then fetch those DropDown ValueList items from ValueList Folder
			Map<String, ValueListDocument> screenFieldConfigDropDownMap = new HashMap<String, ValueListDocument>();
			//create DropDown Value List Map with Field ID as Key
			for(ScreenFieldConfig screenFieldConfig:screenConfigDocument.getScreenFieldConfigList()){
				if(screenFieldConfig.getFormFieldType().equals("select")){
					ValueListDocument dropDownValueListDoc = null;
					dropDownValueListDoc = (ValueListDocument) objectBeanManager.getObject(basePathToValueList+screenFieldConfig.getDropDownListName());
					screenFieldConfigDropDownMap.put(screenFieldConfig.getFieldId(), dropDownValueListDoc);
				}
			}
			//this have complete Map which have ScreenFieldConfig Documents according to their respective Field Set. 
			Map<String, Map<String, List<ScreenFieldConfig>>> totalScreenConfigMapforFS = new HashMap<String, Map<String,List<ScreenFieldConfig>>>();
			//set all FieldSet Compound Documents in Map with similar key of above Map 
			Map<String, ScreenFieldSetDetail> reFieldSetMap = new HashMap<String, ScreenFieldSetDetail>();
			if(screenFiedSetDocument !=null){
				int i=1;
				//Screen Field Set Detail have legend and all Field ID of Screen FieldConfig
				for(ScreenFieldSetDetail screenFieldSet:screenFiedSetDocument.getScreenFieldSetDocumentList()){
					Map<String, List<ScreenFieldConfig>> screenFieldConfigMapforFS = new HashMap<String, List<ScreenFieldConfig>>();
					//Initialize the Map 
					for(ValueListDocumentDetail valueDetail:numValueListDocument.getValueListDocumentDetailList()){
						screenFieldConfigMapforFS.put(valueDetail.getKey(), new ArrayList<ScreenFieldConfig>()); 
					}
					for(String fieldId:screenFieldSet.getFieldId()){
						for(ScreenFieldConfig fieldConfig:screenConfigDocument.getScreenFieldConfigList()){
							if(fieldId.equals(fieldConfig.getFieldId())){
								//decide which FieldConfig will at which level in Field set 
								for(ValueListDocumentDetail valueDetail:numValueListDocument.getValueListDocumentDetailList()){
									if(screenFieldConfigMapforFS.containsKey(valueDetail.getKey()) && fieldConfig.getRowLabel().equals(valueDetail.getKey())){
										List<ScreenFieldConfig> screenConfigList = screenFieldConfigMapforFS.get(valueDetail.getKey());
										screenConfigList.add(fieldConfig);
										screenFieldConfigMapforFS.put(valueDetail.getKey(), screenConfigList);
									}
								}
							}
						}
					}
					totalScreenConfigMapforFS.put("FS"+i, screenFieldConfigMapforFS);
					reFieldSetMap.put("FS"+i, screenFieldSet);
					i++;
				}
				request.setAttribute("totalScreenConfigMapforFS", totalScreenConfigMapforFS);
				request.setAttribute("reFieldSetMap", reFieldSetMap);
				request.setAttribute("screenFieldConfigDropDownMap", screenFieldConfigDropDownMap);
				request.setAttribute("numValueListDocument", numValueListDocument);
			}
			if(screenConfigDocument!=null){
				request.setAttribute("screenConfigDocument", screenConfigDocument);
			}
		} catch (ObjectBeanManagerException e) {
			// TODO Auto-generated catch block
			log.error("Error While get the Object at"+basePathToValueList+"in repository",e);
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
