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
 * Date:dec 09, 2013
 * Time: 11:26:35 AM
 * 
 */




package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.compound.ClubIncomeDetail;
import com.mootly.wcm.beans.compound.MemberTicketDocumentDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.TdsOthersDetail;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:clubincomedocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class MemberTicketDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:memberticketdocument";
	static final public String NODE_NAME = "memberticketdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:memberticketdocumentdetail";
	private String itFolderUuid;
	private Double Total;
	
	private Double total_amount;
	private final static Logger log = LoggerFactory.getLogger(MemberTicketDocument.class); 

	private List<MemberTicketDocumentDetail> memberticketdocumentDetailList;

	public final List<MemberTicketDocumentDetail> getMemberTicketDocumentDetailList() {
		if ( memberticketdocumentDetailList == null)  memberticketdocumentDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return  memberticketdocumentDetailList;
	}

	public final void setMemberTicketDocumentDetailList(List<MemberTicketDocumentDetail> memberticketdocumentDetailList) {
		this. memberticketdocumentDetailList = memberticketdocumentDetailList;
	}
	
	public final void addMemberTicketDocumentDetail(MemberTicketDocumentDetail memberticketdocumentdetail) {
		getMemberTicketDocumentDetailList();
		if ( memberticketdocumentDetailList == null)  memberticketdocumentDetailList = new ArrayList<MemberTicketDocumentDetail>();
		memberticketdocumentDetailList.add(memberticketdocumentdetail);
	}
	  
	public final String getItFolderUuid() {
		return itFolderUuid;
	}

	public final void setItFolderUuid(String itFolderUuid) {
		this.itFolderUuid = itFolderUuid;
	}

	public PersonalInformation getPersonalInformation() {
		HippoBean bean = getBean(NT_PERSONAL_INFO_LINK);
		if (!(bean instanceof HippoMirror)) {
			return null;
		}
		PersonalInformation prdBean = (PersonalInformation) ((HippoMirror) bean).getReferencedBean();
		if (prdBean == null) {
			return null;
		}
		return prdBean;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			MemberTicketDocument memberticket = (MemberTicketDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
			double sum=0d;
        	// String strSum="";
        	if ( memberticket.getMemberTicketDocumentDetailList() != null &&  memberticket.getMemberTicketDocumentDetailList().size() > 0 ){ 
        		log.info("checking size in member ticket bean:::"+ memberticket.getMemberTicketDocumentDetailList().size());
        		for (MemberTicketDocumentDetail objMemberTicket:memberticket.getMemberTicketDocumentDetailList()) {
        		    if (!objMemberTicket.isMarkedForDeletion()) {
        				
            		    // Double sum1= (double) sum;
            		   //  strSum= BigDecimal.valueOf(sum1).toPlainString();
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                objMemberTicket.bindToNode(html); 
        			}
        		}
        		//setTotal_Amount(sum);
        	}
        	//node.setProperty("mootlywcm:totalamount", getTotal_Amount());
        	/*
			javax.jcr.Node prdLinkNode;
			if (node.hasNode(NT_PERSONAL_INFO_LINK)) {
				prdLinkNode = node.getNode(NT_PERSONAL_INFO_LINK);
			} else {
				prdLinkNode = node.addNode(NT_PERSONAL_INFO_LINK, "hippo:mirror");
			}
			prdLinkNode.setProperty("hippo:docbase", salaryincome.getPersonalInfoUuid());
			*/

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap != null) {
			
		}
	}
	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		//we know the source bean will be SalaryIncomeDocument but doesn't hurt to check
		MemberTicketDocument MemberTicketDocument = (MemberTicketDocument) sourceBean;
		}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			MemberTicketDocumentDetail source =(MemberTicketDocumentDetail) child;
			addMemberTicketDocumentDetail(source);
		}
		boolean found = false;
		List<MemberTicketDocumentDetail> listOfChildren = getMemberTicketDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				MemberTicketDocumentDetail destination =(MemberTicketDocumentDetail) o;
				MemberTicketDocumentDetail source  = (MemberTicketDocumentDetail) child;
				destination.cloneBean(source);
				found = true;
				break;
			}
		}		
	}
	
	@Override
	public void add(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		MemberTicketDocumentDetail source =(MemberTicketDocumentDetail) child;
		addMemberTicketDocumentDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<MemberTicketDocumentDetail> listOfChildren = getMemberTicketDocumentDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				MemberTicketDocumentDetail destination =(MemberTicketDocumentDetail) o;
				MemberTicketDocumentDetail source  = (MemberTicketDocumentDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			MemberTicketDocumentDetail source =(MemberTicketDocumentDetail) child;
			addMemberTicketDocumentDetail(source);
		}		
	}
}
