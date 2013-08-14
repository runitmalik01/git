
/**

 * @author:Abhishek Bhardwaj
 * Date: 3/6/2013
 * Description: This take data from user about his/her property and calculate 
 * the capital gain.
 *
 */


package com.mootly.wcm.member;

import java.util.Calendar;
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


@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@PrimaryBean(primaryBeanClass=CapitalAssetDocument.class)
@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class})
@ChildBean(childBeanClass=CapitalAssetDetail.class)
@FormFields(fieldNames={"date_acquisition","saleconsideration","costacquisition","date_sale","capitalgain",
		"nameasset","costimprovement","sst_charge","asset_type","months","costtrnsfr","asset111","assetnt111","amtdeemed","balanc","losssec94","dedsec54",
		"section48","unlstdsecurity"})
public class CapitalAsset extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(CapitalAsset.class);
	CapitalAssetDetail childBean=null;
	Calendar dt1=null;
	Calendar dt2=null;
	MemberPersonalInformation requiredBean=null;
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		// for getting residential status on capital gain screen
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if (memberPersonalInformation!=null) {

			String status=memberPersonalInformation.getResidentCategory();
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


