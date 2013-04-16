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
import static com.mootly.wcm.utils.Constants.PROP_TDS_SALARY;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.PreviousYearsSalaryInfo;
import com.mootly.wcm.beans.compound.TdsSalary;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberRebateSectionEightyNine")
public class MemberRebateSectionEightyNine extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:MemberRebateSectionEightyNine";
	static final public String NODE_NAME = "MemberRebateSectionEightyNine";
	
	private String salaryincome;
	private String otherincome;
	private String arrears;
	private String totalincomearrears;
	private String taxsalaryincome;
	private String taxarrears;
	private String diff;
	private String computedtabletotal;
	private String taxrelief;
	private List<PreviousYearsSalaryInfo> prevsalaryinfoList;

	
    public String getSalaryIncome() {
    	if (salaryincome == null) salaryincome = getProperty("mootlywcm:salaryIncome");
    	return salaryincome;
    }

    public String getOtherIncome() {
    	if (otherincome == null) otherincome = getProperty("mootlywcm:otherIncome");
    	return otherincome;
    }

    public String getArrears() {
    	if (arrears == null) arrears = getProperty("mootlywcm:arrears");
    	return arrears;
    }

    public String getTotalIncomeArrears() {
    	if (totalincomearrears == null) totalincomearrears = getProperty("mootlywcm:totalIncomearrears");
    	return totalincomearrears;
    }

    public String getTaxSalaryIncome() {
    	if (taxsalaryincome == null) taxsalaryincome = getProperty("mootlywcm:taxSalaryIncome");
    	return taxsalaryincome;
    }

    public String getTaxArrears() {
    	if (taxarrears == null) taxarrears = getProperty("mootlywcm:taxArrears");
    	return taxarrears;
    }


    public String getDiff() {
    	if (diff == null) diff =  getProperty("mootlywcm:diff");
    	return diff;
    }

    public String getComputedTableTotal() {
    	if (computedtabletotal == null) computedtabletotal =  getProperty("mootlywcm:computedTableTotal");
    	return computedtabletotal;
    }

    public String getTaxRelief() {
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

    public final void setSalaryIncome(String salaryincome) {
    	this.salaryincome = salaryincome;
    }

    public final void setOtherIncome(String otherincome) {
    	this.otherincome = otherincome;
    }

    public final void setArrears(String arrears) {
    	this.arrears = arrears;
    }

    public final void setTotalIncomeArrears(String totalincomearrears) {
    	this.totalincomearrears = totalincomearrears;
    }

    public final void setTaxSalaryIncome(String taxsalaryincome) {
    	this.taxsalaryincome = taxsalaryincome;
    }

    public final void setTaxArrears(String taxarrears) {
    	this.taxarrears = taxarrears;
    }
    public final void setDiff(String diff) {
    	this.diff = diff;
    }

    public final void setComputedTableTotal(String computedtabletotal) {
    	this.computedtabletotal = computedtabletotal;
    }

    public final void setTaxRelief(String taxrelief) {
    	this.taxrelief = taxrelief;
    }

//for personal information
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is Contact bean");
			MemberRebateSectionEightyNine section89 = (MemberRebateSectionEightyNine) content;
			
	    	node.setProperty("mootlywcm:salaryIncome", section89.getSalaryIncome());
	    	node.setProperty("mootlywcm:otherIncome", section89.getOtherIncome());
	    	node.setProperty("mootlywcm:arrears", section89.getArrears());
	    	node.setProperty("mootlywcm:totalIncomearrears", section89.getTotalIncomeArrears());
	    	node.setProperty("mootlywcm:taxSalaryIncome", section89.getTaxSalaryIncome());
	    	node.setProperty("mootlywcm:taxArrears", section89.getTaxArrears());
	    	node.setProperty("mootlywcm:diff", section89.getDiff());
	    	node.setProperty("mootlywcm:computedTableTotal", section89.getComputedTableTotal());
	    	node.setProperty("mootlywcm:taxRelief", section89.getTaxRelief());	
	    	
	    	NodeIterator nodeIterator = node.getNodes("mootlywcm:PreviousYearsSalaryInfo");
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	if (section89.getPrevSalaryInfoList() != null && section89.getPrevSalaryInfoList().size() > 0 ){ 
        		for (PreviousYearsSalaryInfo prevsalaryinfo:section89.getPrevSalaryInfoList()) {
	                javax.jcr.Node html = node.addNode("mootlywcm:PreviousYearsSalaryInfo", "mootlywcm:PreviousYearsSalaryInfo");
	                prevsalaryinfo.bindToNode(html); 
        		}
        	}
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
}
