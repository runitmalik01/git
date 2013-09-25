
/**

 * @author:Abhishek Bhardwaj
 * Date: 3/6/2013
 * Description: This take data from user about his/her property and calculate 
 * the capital gain.
 *
 */


package com.mootly.wcm.member;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRForm;


@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@PrimaryBean(primaryBeanClass=CapitalAssetDocument.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
@ChildBean(childBeanClass=CapitalAssetDetail.class)
@FormFields(fieldNames={"date_acquisition","saleconsideration","costacquisition","date_sale","capitalgain","nameasset","costimprovement","sst_charge",
		"asset_type","months","costtrnsfr","asset111","assetnt111","amtdeemed","balanc","losssec94","dedsec54","section48","unlstdsecurity" ,"upto15st","upto15oth",
		"upto16st","upto16oth","upto16decst","upto16decoth","upto31st","upto31oth","upto15Lt","upto15np","upto16Lt","upto16np","upto16decLt","uptodecnp",
		"upto31Lt","upto31np","index","panifded","accural_info","date_improve","cgSlump","netCGSlump","amtdeemedsc"})
public class CapitalAsset extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(CapitalAsset.class);
	CapitalAssetDetail childBean=null;
	MemberPersonalInformation requiredBean=null;
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		// for getting residential status on capital gain screen
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if (memberPersonalInformation!=null) {
			String status=memberPersonalInformation.getResidentCategory();
			ITRForm itrform=memberPersonalInformation.getSelectedITRForm();
			log.info("here the form"+itrform);
			if(null!=itrform){
				request.setAttribute("itrform", itrform);
			}
			if(null!=status){
				request.setAttribute("status", status);
			}
		}

		if(log.isInfoEnabled()){
			log.info("this is do before render of capital asset");
		}
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}


