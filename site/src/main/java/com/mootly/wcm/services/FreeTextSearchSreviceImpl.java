/**
 * 
 */
package com.mootly.wcm.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
			//targetHippoBean this is passed to improve performance by not search in all documents i.e. limit the search space and search for only passed document.
			if(serviceRequestBean.isHippoDocumentBean()){
				if(serviceRequestBean.getParentBean().isHippoFolderBean()){
					HippoFolder parentHippoFolder = (HippoFolder) serviceRequestBean.getParentBean();
					List<HippoDocumentBean> hippoDocumentBeans = parentHippoFolder.getDocuments();
					if(!hippoDocumentBeans.isEmpty()){
						for(HippoDocumentBean hiBean:hippoDocumentBeans){
							if(findFreeTextOnPropertyMap(hiBean.getProperties(), freeText)){
								return true;
							}
							//find all child nodes so that we can have a complete search on a documents.
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
									}else{
										//skip hippo:translation which does not part of our search
										nodeIterator.skip(nodeIterator.getPosition());	
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
		} catch (NoSuchElementException e){
			log.error("Error while Iterate NodeIterator i.e have no element",e);
		}
		return false;
	}
	public boolean findFreeTextOnPropertyMap(Map<String, Object> hiBeanPropertyMap, String freeText){
		if(!hiBeanPropertyMap.isEmpty()){
			for(String key:hiBeanPropertyMap.keySet()){
				Object object = hiBeanPropertyMap.get(key);
				if(object instanceof String){
					if(String.valueOf(object).toLowerCase().contains(freeText.toLowerCase())){
						return true;
					}
				}
				if(object instanceof Calendar){
					if(freeText.contains(BaseDocument.getIndianDateFormatter().format(((Calendar) object).getTime()))){
						return true;
					}
				}
				if(object instanceof Double){
					if(freeText.contains(String.valueOf(object))){
						return true;
					}
				}
				if(object instanceof Boolean){
					if(freeText.toLowerCase().contains(String.valueOf(object).toLowerCase())){
						return true;
					}
				}
				if(object instanceof Long){
					if(freeText.contains(String.valueOf(object))){
						return true;
					}
				}
				if(object instanceof String[]){
					for(String st:(String[]) object){
						if(freeText.toLowerCase().contains(st.toLowerCase())){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
