/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 * User: megha
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.cms.compound;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.hippoecm.hst.content.beans.standard.HippoMirrorBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.cms.BlockDocument;
import com.mootly.wcm.beans.standard.FlexibleDocument;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:pbpagerowdetail")
public class PageRowDetail extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = PageRowDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(PageRowDetail.class); 
	final String PROP_DETAIL_BEAN="mootlywcm:pbpagerowdetail";
	final String UUID_SEPRATE = ",";
	final String PROP_COLUMN_BEAN = "mootlywcm:columns";

	Boolean notContainer;
	Boolean notRow;
	Boolean notColumn;

	List<BlockDocument> blockDocuments;
	List<String> blockCanonicalUUIDs;
	private boolean markedForDeletion;
	public final Boolean getNotContainer() {
		if (notContainer == null) notContainer = getProperty("mootlywcm:notContainer");
		return notContainer;
	}

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	public List<String> getBlockCanonicalUUIDs() {
		if(blockCanonicalUUIDs == null){
			blockCanonicalUUIDs = new ArrayList<String>();
			List<String> uuidsArray = new ArrayList<String>();
			if(getBlockDocuments()!= null){
				for(HippoBean bean:getBlockDocuments()){
					uuidsArray.add(bean.getCanonicalUUID());
				}
			}
			blockCanonicalUUIDs.addAll(uuidsArray);
		}
		return blockCanonicalUUIDs;
	}

	public void setBlockCanonicalUUIDs(List<String> blockCanonicalUUIDs) {
		this.blockCanonicalUUIDs = blockCanonicalUUIDs;
	}

	public final Boolean getNotRow() {
		if (notRow == null) notRow = getProperty("mootlywcm:notRow");
		return notRow;
	}

	public final Boolean getNotColumn() {
		if (notColumn == null) notColumn = getProperty("mootlywcm:notColumn");
		return notColumn;
	}

	public final List<BlockDocument> getBlockDocuments() {
		if (blockDocuments == null) {
			List<HippoMirrorBean> theMirrorBeans = getChildBeansByName("mootlywcm:columns");
			if (theMirrorBeans != null && theMirrorBeans.size() > 0 ) {
				blockDocuments = new ArrayList<BlockDocument>();
				for (HippoMirrorBean theMirrorBean: theMirrorBeans) {
					HippoBean theRefBean = ( (HippoMirror) theMirrorBean ).getReferencedBean();
					if (theRefBean != null && theRefBean instanceof BlockDocument) {
						blockDocuments.add((BlockDocument) theRefBean);
					}
				}	
			}
		}
		return blockDocuments;
	}

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		//super.bindToNode(node);
		if (log.isInfoEnabled()) {
			log.info("Lets see value of UUID List"+getBlockCanonicalUUIDs());			
		}
		for(String canonicalUUID:getBlockCanonicalUUIDs()){
			javax.jcr.Node prdLinkNode;
			try {
				//prdLinkNode = node.getNode(PROP_COLUMN_BEAN);
				prdLinkNode = node.addNode(PROP_COLUMN_BEAN, "hippo:mirror");
				prdLinkNode.setProperty("hippo:docbase", canonicalUUID);
			}  catch (RepositoryException e) {
				// TODO Auto-generated catch block
				log.error("Error in Repository",e);
			}	
		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		super.fill(formMap);
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		if(formMap.getField("blockDocCanonicalUUIDs")!=null){
			Map<String,String> mapForUUIDS = formMap.getField("blockDocCanonicalUUIDs").getValues();
			List<String> uuids = new ArrayList<String>();
			for(String key:mapForUUIDS.keySet()){
				if (log.isInfoEnabled()) {
					log.info("UUid of Block Doc"+mapForUUIDS.get(key));			
				}
				uuids.add(key);
			}
			setBlockCanonicalUUIDs(uuids);
		}
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		super.cloneBean(sourceBean);
		PageRowDetail pageRowDetail = (PageRowDetail) sourceBean;
		setBlockCanonicalUUIDs(pageRowDetail.getBlockCanonicalUUIDs());
	}

	@BeanClone
	public final void setNotContainer(Boolean notContainer) {
		this.notContainer = notContainer;
	}

	@BeanClone
	public final void setNotRow(Boolean notRow) {
		this.notRow = notRow;
	}

	@BeanClone
	public final void setNotColumn(Boolean notColumn) {
		this.notColumn = notColumn;
	}

	@BeanClone
	public final void setBlockDocuments(List<BlockDocument> blockDocuments) {
		this.blockDocuments = blockDocuments;
	}



}
