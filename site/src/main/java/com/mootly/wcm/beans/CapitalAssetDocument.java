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
 * User: Pankaj
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */




package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

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
import com.mootly.wcm.beans.compound.PersonalInformation;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.utils.ValueListService;
import com.mootly.wcm.utils.ValueListServiceImpl;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:capitalassetdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class CapitalAssetDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:capitalassetdocument";
	static final public String NODE_NAME = "capitalassetdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:capitalassetdetail";
	private String itFolderUuid;

	public String getGross_salary() {
		return "0";
	}

	private final static Logger log = LoggerFactory.getLogger(CapitalAssetDocument.class); 

	private List<CapitalAssetDetail> capitalassetDetailList;
	String capital_gain;

	public final List<CapitalAssetDetail> getCapitalAssetDetailList() {
		if (capitalassetDetailList == null) capitalassetDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return capitalassetDetailList;
	}

	public final void setCapitalAssetDetailList(List<CapitalAssetDetail> capitalassetDetailList) {
		this.capitalassetDetailList = capitalassetDetailList;
	}

	public final void addCapitalAssetDetail(CapitalAssetDetail capitalAssetDetail) {
		getCapitalAssetDetailList();
		if (capitalassetDetailList == null) capitalassetDetailList = new ArrayList<CapitalAssetDetail>();
		capitalassetDetailList.add(capitalAssetDetail);
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
			CapitalAssetDocument capitalasset = (CapitalAssetDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			double capitalgain=0.0;
			if (capitalasset.getCapitalAssetDetailList() != null && capitalasset.getCapitalAssetDetailList().size() > 0 ){
				log.info("checking size:::"+capitalasset.getCapitalAssetDetailList().size());
				String ciiAcq=null;
				String ciiSale=null;
				
				for (CapitalAssetDetail capitalAssetDetail:capitalasset.getCapitalAssetDetailList()) {
					log.info("going to bind to node method");
					if (!capitalAssetDetail.isMarkedForDeletion()) {

						try{
							// fetching values of cii  from property file
							
							ValueListService objValueListService = ValueListServiceImpl.getInstance();
							ResourceBundle rb = ResourceBundle.getBundle("valueList_InflationIndex");
							for(int i=1981;i<2012;i++){
								
								String period=(String)rb.getString("valueList."+i);
								log.info("period"+period);
								String[] arryPeriod=period.split("-");
								log.info("arryPeriod[0]"+arryPeriod[0]);
								log.info("arryPeriod[0]"+arryPeriod[1]);
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								// fetching cii for date of acquisition
								log.info("capitalAssetDetail.getDateAcquisition()"+capitalAssetDetail.getDateAcquisition());
								java.util.Date userDateAcq = sdf.parse(capitalAssetDetail.getDateAcquisition());
								log.info("userDate"+userDateAcq);
								java.util.Date fetchdateless= sdf.parse(arryPeriod[0]);
								log.info("fetchdateless"+fetchdateless);
								java.util.Date fetchdatemore= sdf.parse(arryPeriod[1]);
								log.info("fetchdatemore"+fetchdatemore);
								if(userDateAcq.after(fetchdateless) && userDateAcq.before(fetchdatemore))
								{
									ciiAcq=(String)rb.getString("valueList."+i+".cii");
									log.info(" ciiAcq"+ ciiAcq);
								} else {
									log.info("else statement");	
								}
								// fetching cii for date of sale
								java.util.Date userDateSale=sdf.parse(capitalAssetDetail.getDateSale());
								log.info("userDateSale"+userDateSale);
								if(userDateSale.after(fetchdateless) && userDateSale.before(fetchdatemore)){
									ciiSale=(String)rb.getString("valueList."+i+".cii");
									log.info(" cii"+ ciiSale);

								}
							}

						}catch(Exception e){
							log.warn("exception"+e);

						}
						// code for doing calcualtion
					//	float ciiA = Float.parseFloat(ciiAcq);
						//float ciiS = Float.parseFloat(ciiSale);
						double ciiA = Double.parseDouble(ciiAcq);
						double ciiS= Double.parseDouble(ciiSale);
						double multcii=ciiS*ciiA;
						log.info("multcii"+multcii);
						double divAcq=(capitalAssetDetail.getCostAcquisition())/multcii;
						log.info("divAcq"+divAcq);
						 capitalgain=(capitalAssetDetail.getSaleConsideration())-divAcq;
						log.info("capitalgain"+capitalgain);
						capitalAssetDetail.setCapitalGain(capitalgain);
						capitalAssetDetail.setCostIndexAcquisition(ciiAcq);
						capitalAssetDetail.setCostIndexConsideration(ciiSale);
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						if(html.equals(null)){
							log.info("this is html node ");
						}
						capitalAssetDetail.bindToNode(html); 
					}

				}

			}
			/*
			javax.jcr.Node prdLinkNode;
			if (node.hasNode(NT_PERSONAL_INFO_LINK)) {
				prdLinkNode = node.getNode(NT_PERSONAL_INFO_LINK);
			} else {
				prdLinkNode = node.addNode(NT_PERSONAL_INFO_LINK, "hippo:mirror");
			}
			prdLinkNode.setProperty("hippo:docbase", capitalasset.getPersonalInfoUuid());
			 */
			 	
		}
		catch (RepositoryException rex) {
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
		//we know the source bean will be CapitalAssetDocument but doesn't hurt to check
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			CapitalAssetDetail source =(CapitalAssetDetail) child;
			addCapitalAssetDetail(source);
		}
		boolean found = false;
		List<CapitalAssetDetail> listOfChildren = getCapitalAssetDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				log.info("UUID:::"+o.getCanonicalUUID());
				CapitalAssetDetail destination =(CapitalAssetDetail) o;
				CapitalAssetDetail source  = (CapitalAssetDetail) child;
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
		CapitalAssetDetail source =(CapitalAssetDetail) child;
		addCapitalAssetDetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<CapitalAssetDetail> listOfChildren = getCapitalAssetDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				CapitalAssetDetail destination =(CapitalAssetDetail) o;
				CapitalAssetDetail source  = (CapitalAssetDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			CapitalAssetDetail source =(CapitalAssetDetail) child;
			addCapitalAssetDetail(source);
		}		
	}
}
