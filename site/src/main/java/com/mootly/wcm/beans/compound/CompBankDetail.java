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

package com.mootly.wcm.beans.compound;

import static com.mootly.wcm.utils.Constants.BD_ACC_NUMBER;
import static com.mootly.wcm.utils.Constants.BD_ADD_BANK_BRANCH;
import static com.mootly.wcm.utils.Constants.BD_BANK_NAME;
import static com.mootly.wcm.utils.Constants.BD_ECS;
import static com.mootly.wcm.utils.Constants.BD_MICR_CODE;
import static com.mootly.wcm.utils.Constants.BD_TYPE_ACC;
import javax.jcr.RepositoryException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Bean mapping class for the 'mootlywcm:address' document type
 */
@Node(jcrType = "mootlywcm:CompBankDetail")
public class CompBankDetail extends HippoItem {
	
	private static final Logger log = LoggerFactory.getLogger(CompBankDetail.class);
	
	private String accNumber ;
	private String bankName ;
	private String ecs ;
	private String typeAcc;
	private String addBankBranch;
	private String micrCode;

	public String getBD_ADD_BANK_BRANCH() {
		if (addBankBranch == null) addBankBranch = getProperty(BD_ADD_BANK_BRANCH);
		return addBankBranch;
	}
	public String getBD_MICR_CODE() {
		if (micrCode == null) micrCode = getProperty(BD_MICR_CODE);
		return micrCode;
	}
	public String getBD_ACC_NUMBER() {
		if (accNumber == null) accNumber = getProperty(BD_ACC_NUMBER);
		return accNumber;
	}

	public String getBD_BANK_NAME() {
		if (bankName == null) bankName = getProperty(BD_BANK_NAME);
		return bankName;
	}

	public String getBD_ECS() {
		if (ecs == null) ecs = getProperty(BD_ECS);
		return ecs;
	}

	public String getBD_TYPE_ACC() {
		if (typeAcc == null) typeAcc = getProperty(BD_TYPE_ACC);
		return typeAcc;
	}
    
    public void bindToNode(javax.jcr.Node node) throws RepositoryException {
    	try {

 				node.setProperty(BD_ACC_NUMBER,getBD_ACC_NUMBER());

 				node.setProperty(BD_BANK_NAME,getBD_BANK_NAME());

 				node.setProperty(BD_ECS,getBD_ECS());

 				node.setProperty(BD_TYPE_ACC,getBD_TYPE_ACC());

 				node.setProperty(BD_ADD_BANK_BRANCH,getBD_ADD_BANK_BRANCH());

 				node.setProperty(BD_MICR_CODE,getBD_MICR_CODE());

    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		throw re;
    	}
    	
    }

    public final void setBD_MICR_CODE(String micrCode) {
		this.micrCode = micrCode;
	}

	public final void setBD_ADD_BANK_BRANCH(String addBankBranch) {
		this.addBankBranch = addBankBranch;
	}

	public final void setBD_ACC_NUMBER(String accNumber) {
		this.accNumber = accNumber;
	}

	public final void setBD_BANK_NAME(String bankName) {
		this.bankName = bankName;
	}

	public final void setBD_ECS(String ecs) {
		this.ecs = ecs;
	}

	public final void setBD_TYPE_ACC(String typeAcc) {
		this.typeAcc = typeAcc;
	}
    	
}    	