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

import static com.mootly.wcm.utils.Constants.income_Chargeable;
import static com.mootly.wcm.utils.Constants.name_Employer;
import static com.mootly.wcm.utils.Constants.tan_Employer;
import static com.mootly.wcm.utils.Constants.total_Taxdeducted;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * User: Pankaj Singh
 * Date: 3/13/2013
 * 
 */

// this bean is used for processapplication.jsp

@Node(jcrType = "mootlywcm:tdsfromsalaryinformation")
public class TdsFromSalaryInformation extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:tdsfromsalaryinformation";            
	static final public String NODE_NAME = "tdsfromsalaryinformation";
	

	
	private String[] tan_employer ;
	private String[] name_employer ;
	private String[] income_chargeable ;
	private String []total_taxdeducted;
	private String total_value;
	
   

    public String[] getTan_Employer() {
    	if (tan_employer == null) tan_employer = getProperty(tan_Employer,new String[]{""});
    	return tan_employer;
    }

    public String[] getName_Employer() {
    	if (name_employer == null) name_employer = getProperty(name_Employer,new String[]{""});
    	return name_employer;
    }

    public String[] getIncome_Chargeable() {
    	if (income_chargeable == null) income_chargeable = getProperty(income_Chargeable,new String[]{""});
    	return income_chargeable;
    }

    public String[] getTotal_TaxDeducted() {
    	if (total_taxdeducted == null) total_taxdeducted = getProperty(total_Taxdeducted,new String[]{""});
    	return total_taxdeducted;
    }
    public String getTotal_Value() {
    	if (total_value == null) total_value = getProperty("mootlywcm:totaloftaxdeducted");
    	return total_value;
    		}
   
    
    

	public final void setTan_Employer(String[] tan_employer) {
		this.tan_employer = tan_employer;
	}


 
	public final void setName_Employer(String[] name_employer) {
		this.name_employer = name_employer;
	}
	

	public final void setIncome_Chargeable(String[] income_chargeable) {
		this.income_chargeable = income_chargeable;
	}

	public final void setTotal_TaxDeducted(String[] total_taxdeducted) {
		this.total_taxdeducted = total_taxdeducted;
	}
	 public final void setTotal_Value(String totalvalue) {
			this.total_value = totalvalue;
		}
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			TdsFromSalaryInformation tds_salary = (TdsFromSalaryInformation) content;
			


			
	       if (tds_salary.getTan_Employer() != null) {
				node.setProperty(tan_Employer, tds_salary.getTan_Employer());
			}
	       if (tds_salary.getName_Employer() != null) {
				node.setProperty(name_Employer, tds_salary.getName_Employer());
			}
	       if (tds_salary.getIncome_Chargeable() != null) {
				node.setProperty(income_Chargeable, tds_salary.getIncome_Chargeable());
			}
	       if (tds_salary.getTotal_TaxDeducted() != null) {
				node.setProperty(total_Taxdeducted, tds_salary.getTotal_TaxDeducted());
			}
	   	node.setProperty("mootlywcm:totaloftaxdeducted", tds_salary.getTotal_Value());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
