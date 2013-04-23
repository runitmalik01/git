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

package com.mootly.wcm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.compound.PreviousYearsSalaryInfo;
import com.mootly.wcm.member.Calculations;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberRebateSectionEightyNine")
public class MemberRebateSectionEightyNine extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:MemberRebateSectionEightyNine";
	static final public String NODE_NAME = "MemberRebateSectionEightyNine";
	private final static Logger log = LoggerFactory.getLogger(MemberRebateSectionEightyNine.class); 
	private Double netincome;
	private Double arrears;
	private Double totalincomearrears;
	private Double taxsalaryincome;
	private Double taxarrears;
	private Double diff;
	private Double computedtabletotal;
	private Double taxrelief;
	private String itFolderUuid;
	private List<PreviousYearsSalaryInfo> prevsalaryinfoList;


	public Double getNetIncome() {
		if (netincome == null) netincome = getProperty("mootlywcm:netIncome");
		return netincome;
	}

	public Double getArrears() {
		if (arrears == null) arrears = getProperty("mootlywcm:arrears");
		return arrears;
	}

	public Double getTotalIncomeArrears() {
		if (totalincomearrears == null) totalincomearrears = getProperty("mootlywcm:totalIncomearrears");
		return totalincomearrears;
	}

	public Double getTaxSalaryIncome() {
		if (taxsalaryincome == null) taxsalaryincome = getProperty("mootlywcm:taxNetIncome");
		return taxsalaryincome;
	}

	public Double getTaxArrears() {
		if (taxarrears == null) taxarrears = getProperty("mootlywcm:taxArrears");
		return taxarrears;
	}


	public Double getDiff() {
		if (diff == null) diff =  getProperty("mootlywcm:diff");
		return diff;
	}

	public Double getComputedTableTotal() {
		if (computedtabletotal == null) computedtabletotal =  getProperty("mootlywcm:computedTableTotal");
		return computedtabletotal;
	}

	public Double getTaxRelief() {
		if (taxrelief == null) taxrelief = getProperty("mootlywcm:taxRelief");
		return taxrelief;
	}
	public final List<PreviousYearsSalaryInfo> getPrevSalaryInfoList() {
		if (prevsalaryinfoList == null) prevsalaryinfoList= getChildBeans("mootlywcm:PreviousYearsSalaryInfo");
		return prevsalaryinfoList;
	}

	public final void setPrevSalaryInfoList(List<PreviousYearsSalaryInfo> prevsalaryinfoList) {
		this.prevsalaryinfoList = prevsalaryinfoList;
	}

	public final void setNetIncome(Double netincome) {
		this.netincome = netincome;
	}

	public final void setArrears(Double arrears) {
		this.arrears = arrears;
	}

	public final void setTotalIncomeArrears(Double totalincomearrears) {
		this.totalincomearrears = totalincomearrears;
	}

	public final void setTaxSalaryIncome(Double taxsalaryincome) {
		this.taxsalaryincome = taxsalaryincome;
	}

	public final void setTaxArrears(Double taxarrears) {
		this.taxarrears = taxarrears;
	}
	public final void setDiff(Double diff) {
		this.diff = diff;
	}

	public final void setComputedTableTotal(Double computedtabletotal) {
		this.computedtabletotal = computedtabletotal;
	}

	public final void setTaxRelief(Double taxrelief) {
		this.taxrelief = taxrelief;
	}
	public final void addPreviousYearsSalaryInfo(PreviousYearsSalaryInfo prevsalinfo) {
		getPrevSalaryInfoList();
		if (prevsalaryinfoList == null) prevsalaryinfoList = new ArrayList<PreviousYearsSalaryInfo>();
		prevsalaryinfoList.add(prevsalinfo);
	}

	public final String getItFolderUuid() {
		return itFolderUuid;
	}

	public final void setItFolderUuid(String itFolderUuid) {
		this.itFolderUuid = itFolderUuid;
	}
	//for personal information


	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if(log.isInfoEnabled()){
			log.info("this is Contact bean");
			}
			MemberRebateSectionEightyNine section89 = (MemberRebateSectionEightyNine) content;	

			NodeIterator nodeIterator = node.getNodes("mootlywcm:PreviousYearsSalaryInfo");
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			Double sumArrears=0.0d;Double sumPrevTotalTax=0.0d;
			if (section89.getPrevSalaryInfoList() != null && section89.getPrevSalaryInfoList().size() > 0 ){ 
				for (PreviousYearsSalaryInfo prevsalaryinfo:section89.getPrevSalaryInfoList()) {
					sumArrears=sumArrears+prevsalaryinfo.getPrevArrears();
					sumPrevTotalTax=sumPrevTotalTax+prevsalaryinfo.getPrevTaxDiff();
					javax.jcr.Node html = node.addNode("mootlywcm:PreviousYearsSalaryInfo", "mootlywcm:PreviousYearsSalaryInfo");
					prevsalaryinfo.bindToNode(html); 
				}
			}
			setArrears(sumArrears);
			setComputedTableTotal(sumPrevTotalTax);
			Calculations cal=new Calculations();
			
			node.setProperty("mootlywcm:netIncome", section89.getNetIncome());
			node.setProperty("mootlywcm:arrears", section89.getArrears());
			node.setProperty("mootlywcm:totalIncomearrears", section89.getTotalIncomeArrears());
			node.setProperty("mootlywcm:taxSalaryIncome", section89.getTaxSalaryIncome());
			node.setProperty("mootlywcm:taxArrears", section89.getTaxArrears());
			node.setProperty("mootlywcm:diff", section89.getDiff());
			node.setProperty("mootlywcm:computedTableTotal", section89.getComputedTableTotal());
			node.setProperty("mootlywcm:taxRelief", section89.getTaxRelief());
			/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", section89.getPersonalInfoUuid());
			 */
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap != null) {
			if(log.isInfoEnabled()){
			log.info("this is form map in Rebate 89");
			}
			if ( formMap.getField("salaryincome") != null) {
				setNetIncome(Double.parseDouble(formMap.getField("salaryincome").getValue()));
			}
			if ( formMap.getField("totalincomearrears") != null) {
				setTotalIncomeArrears(Double.parseDouble(formMap.getField("totalincomearrears").getValue()));
			}
			if ( formMap.getField("taxsalaryincome") != null) {
				setTaxSalaryIncome(Double.parseDouble(formMap.getField("taxsalaryincome").getValue()));
			}
			if ( formMap.getField("taxarrears") != null) {
				setTaxArrears(Double.parseDouble(formMap.getField("taxarrears").getValue()));
			}
			if ( formMap.getField("Diff") != null) {
				setDiff(Double.parseDouble(formMap.getField("Diff").getValue()));
			}
			if ( formMap.getField("taxRelief") != null) {
				setTaxRelief(Double.parseDouble(formMap.getField("taxRelief").getValue()));
			}
		}
	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		//we know the source bean will be SalaryIncomeDocument but doesn't hurt to check
		MemberRebateSectionEightyNine rebatesection89 = (MemberRebateSectionEightyNine) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			PreviousYearsSalaryInfo source =(PreviousYearsSalaryInfo) child;
			addPreviousYearsSalaryInfo(source);
		}
		boolean found = false;
		List<PreviousYearsSalaryInfo> listOfChildren = getPrevSalaryInfoList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				PreviousYearsSalaryInfo destination =(PreviousYearsSalaryInfo) o;
				PreviousYearsSalaryInfo source  = (PreviousYearsSalaryInfo) child;
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
		PreviousYearsSalaryInfo source =(PreviousYearsSalaryInfo) child;
		addPreviousYearsSalaryInfo(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<PreviousYearsSalaryInfo> listOfChildren = getPrevSalaryInfoList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				PreviousYearsSalaryInfo destination =(PreviousYearsSalaryInfo) o;
				PreviousYearsSalaryInfo source  = (PreviousYearsSalaryInfo) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			PreviousYearsSalaryInfo source =(PreviousYearsSalaryInfo) child;
			addPreviousYearsSalaryInfo(source);
		}		
	}
}
