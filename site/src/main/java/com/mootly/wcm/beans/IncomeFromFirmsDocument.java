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
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */




package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

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
import com.mootly.wcm.beans.compound.IncomeFromFirmsDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:incomefromfirmsdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class IncomeFromFirmsDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:incomefromfirmsdocument";
	static final public String NODE_NAME = "incomefromfirmsdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:incomefromfirmsdetail";
	private String itFolderUuid;
	
	public String getGross_salary() {
		return "0";
	}
	private Double val_Salary;
	private Double val_InterestRcv;
	private Double val_salaryAndIntrst;
	private Double val_Expense;
	private Double val_NetIncome;
	private final static Logger log = LoggerFactory.getLogger(IncomeFromFirmsDocument.class); 

	private List<IncomeFromFirmsDetail> incomeFromFirmsDetailList;

	public final List<IncomeFromFirmsDetail> getIncFromFirmsDetailList() {
		if (incomeFromFirmsDetailList == null) incomeFromFirmsDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return incomeFromFirmsDetailList;
	}

	public final void setIncFromFirmsDetailList(List<IncomeFromFirmsDetail> IncomeFromFirmsDetailList) {
		this.incomeFromFirmsDetailList = IncomeFromFirmsDetailList;
	}
	
	public final void addIncomeFromFirmsDetail(IncomeFromFirmsDetail IncomeFromFirmsDetail) {
		getIncFromFirmsDetailList();
		if (incomeFromFirmsDetailList == null) incomeFromFirmsDetailList = new ArrayList<IncomeFromFirmsDetail>();
		incomeFromFirmsDetailList.add(IncomeFromFirmsDetail);
	}
	   public Double getVal_Salary() {
	    	if (val_Salary == null) val_Salary = getProperty("mootlywcm:val_Salary");
	    	return val_Salary;
	 }
	   
	   public final void setVal_Salary(Double val_Salary) {
			this.val_Salary = val_Salary;
		}
	   public Double getVal_InterestRcv() {
	    	if (val_InterestRcv == null) val_InterestRcv = getProperty("mootlywcm:val_InterestRcv");
	    	return val_InterestRcv;
	 }
	   
	   public final void setVal_InterestRcv(Double val_InterestRcv) {
			this.val_InterestRcv = val_InterestRcv;
		}
	   public Double getVal_salaryAndIntrst() {
	    	if (val_salaryAndIntrst == null) val_salaryAndIntrst = getProperty("mootlywcm:val_salaryAndIntrst");
	    	return val_salaryAndIntrst;
	 }
	   
	   public final void setVal_salaryAndIntrst(Double val_salaryAndIntrst) {
			this.val_salaryAndIntrst = val_salaryAndIntrst;
		}
	   public Double getVal_Expense() {
	    	if (val_Expense == null) val_Expense = getProperty("mootlywcm:val_Expense");
	    	return val_Expense;
	 }
	   
	   public final void setVal_Expense(Double val_Expense) {
			this.val_Expense = val_Expense;
		}
	   public Double getVal_NetIncome() {
	    	if (val_NetIncome == null) val_NetIncome = getProperty("mootlywcm:val_NetIncome");
	    	return val_NetIncome;
	 }
	   
	   public final void setVal_NetIncome(Double val_NetIncome) {
			this.val_NetIncome = val_NetIncome;
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
			IncomeFromFirmsDocument firms_Income = (IncomeFromFirmsDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
             Double tot_Salary = 0.0d;
        	 Double tot_InterestRcv=0.0d;
             Double tot_salaryAndIntrst = 0.0d;
        	 Double tot_Expense = 0.0d;
        	 Double tot_NetIncome = 0.0d;
        	if ( firms_Income.getIncFromFirmsDetailList() != null &&  firms_Income.getIncFromFirmsDetailList().size() > 0 ){ 
        		log.info("checking size in salary income bean:::"+ firms_Income.getIncFromFirmsDetailList().size());
        		
        		for (IncomeFromFirmsDetail objIncFromFirm:firms_Income.getIncFromFirmsDetailList()) {
        		    
        			if (!objIncFromFirm.isMarkedForDeletion()) {
        				tot_Salary=tot_Salary+ objIncFromFirm.getSalary_BonusRcv();
        				tot_InterestRcv = tot_InterestRcv + objIncFromFirm.getInterest_Rcv();
        				tot_salaryAndIntrst = tot_salaryAndIntrst + objIncFromFirm.getTotal_SalaryAndInterest();
        				tot_Expense = tot_Expense + objIncFromFirm.getExpenses_RelTotal();
        				tot_NetIncome = tot_NetIncome + objIncFromFirm.getNetIncome();
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                objIncFromFirm.bindToNode(html); 
        			}
        		}
        		setVal_InterestRcv(tot_InterestRcv);
        		setVal_Salary(tot_Salary);
        		setVal_Expense(tot_Expense);
        		setVal_NetIncome(tot_NetIncome);
        		setVal_salaryAndIntrst(tot_salaryAndIntrst);
        		
        	}
        	node.setProperty("mootlywcm:val_Salary", getVal_Salary());
        	node.setProperty("mootlywcm:val_InterestRcv", getVal_InterestRcv());
        	node.setProperty("mootlywcm:val_salaryAndIntrst", getVal_salaryAndIntrst());
        	node.setProperty("mootlywcm:val_Expense", getVal_Expense());
        	node.setProperty("mootlywcm:val_NetIncome", getVal_NetIncome());
        	
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
		IncomeFromFirmsDocument salaryIncomeDocument = (IncomeFromFirmsDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			IncomeFromFirmsDetail source =(IncomeFromFirmsDetail) child;
			addIncomeFromFirmsDetail(source);
		}
		boolean found = false;
		List<IncomeFromFirmsDetail> listOfChildren = getIncFromFirmsDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				IncomeFromFirmsDetail destination =(IncomeFromFirmsDetail) o;
				IncomeFromFirmsDetail source  = (IncomeFromFirmsDetail) child;
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
		IncomeFromFirmsDetail source =(IncomeFromFirmsDetail) child;
		addIncomeFromFirmsDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<IncomeFromFirmsDetail> listOfChildren = getIncFromFirmsDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				IncomeFromFirmsDetail destination =(IncomeFromFirmsDetail) o;
				IncomeFromFirmsDetail source  = (IncomeFromFirmsDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			IncomeFromFirmsDetail source =(IncomeFromFirmsDetail) child;
			addIncomeFromFirmsDetail(source);
		}		
	}
}
