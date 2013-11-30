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
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.hippoecm.hst.content.beans.standard.HippoMirrorBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.CalculatedField;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.NodeBinder;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.annotations.prop.FormMapKey;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.cms.BlockDocument;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.Transaction.ENQUIRY_RESP_CODE;
import com.mootly.wcm.utils.BeanCloneHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;
import com.mootly.wcm.utils.NodeBinderHelper;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:pbpagerowdetail")
public class PageRowDetail extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = PageRowDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(PageRowDetail.class); 
	final String PROP_DETAIL_BEAN="mootlywcm:pbpagerowdetail";
	
	Boolean notContainer;
	Boolean notRow;
	Boolean notColumn;
	
	List<BlockDocument> blockDocuments;
	
	public final Boolean getNotContainer() {
		if (notContainer == null) notContainer = getProperty("mootlywcm:notContainer");
		return notContainer;
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
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		super.fill(formMap);
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		super.cloneBean(sourceBean);
		
	};
	
	@Override
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		return super.bindToNode(node);
	}
}
