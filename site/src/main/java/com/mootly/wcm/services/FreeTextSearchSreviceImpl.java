/**
 * 
 */
package com.mootly.wcm.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.BaseDocument;

/**
 * @author BEN-10
 *
 */
public class FreeTextSearchSreviceImpl implements FreeTextSearchService {

	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean getFreeTextResultOnMember(HippoBean serviceRequestBean,String freeText,HippoBean targetHippoBean) {
		// TODO Auto-generated method stub
		try {
			if(serviceRequestBean.isHippoDocumentBean()){
				if(serviceRequestBean.getParentBean().isHippoFolderBean()){
					HippoFolder parentHippoFolder = (HippoFolder) serviceRequestBean.getParentBean();
					List<HippoDocumentBean> hippoDocumentBeans = parentHippoFolder.getDocuments();
					if(!hippoDocumentBeans.isEmpty()){
						for(HippoDocumentBean hiBean:hippoDocumentBeans){
							if(findFreeTextOnPropertyMap(hiBean.getProperties(), freeText)){
								return true;
							}
							NodeIterator nodeIterator =  hiBean.getNode().getNodes();
							if(nodeIterator.getSize() > 1){
								while(nodeIterator.hasNext()){
									PropertyIterator propertyIterator = nodeIterator.nextNode().getProperties();
									if(propertyIterator.getSize() > 1){
										Map<String, Object> hiBeanPropertyMap = new HashMap<String, Object>();
										while(propertyIterator.hasNext()){
											Property property= propertyIterator.nextProperty();
											hiBeanPropertyMap.put(property.getName(), property.getValue());
										}
										if(findFreeTextOnPropertyMap(hiBeanPropertyMap, freeText)){
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error while get all nodes of Hippo Bean Node",e);
		}
		return false;
	}
	public boolean findFreeTextOnPropertyMap(Map<String, Object> hiBeanPropertyMap, String freeText){
		if(!hiBeanPropertyMap.isEmpty()){
			for(String key:hiBeanPropertyMap.keySet()){
				Object object = hiBeanPropertyMap.get(key);
				if(object instanceof String){
					if(String.valueOf(object).equalsIgnoreCase(freeText)){
						return true;
					}
				}
				if(object instanceof Calendar){
					if(freeText.equalsIgnoreCase(BaseDocument.getIndianDateFormatter().format(((Calendar) object).getTime()))){
						return true;
					}
				}
				if(object instanceof Double){
					if(freeText.equalsIgnoreCase(String.valueOf(object))){
						return true;
					}
				}
				if(object instanceof Boolean){
					if(freeText.equalsIgnoreCase(String.valueOf(object))){
						return true;
					}
				}
				if(object instanceof Long){
					if(freeText.equalsIgnoreCase(String.valueOf(object))){
						return true;
					}
				}
				if(object instanceof String[]){
					for(String st:(String[]) object){
						if(freeText.equalsIgnoreCase(st)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
