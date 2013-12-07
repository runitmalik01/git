
/**
 *
 * @author  abhishek
 * Date: august 24, 2013
 * Time: 11:26:35 AM
 *
 */

package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import javax.jcr.RepositoryException;

import org.datanucleus.api.jpa.metamodel.SetAttributeImpl;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.SalaryIncomeDocument;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:unabsorbeddepreciationdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class UnabsorbedDepreciationDetail extends HippoItem implements FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:unabsorbeddepreciationdetail";
	static final public String NODE_NAME = UnabsorbedDepreciationDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(UnabsorbedDepreciationDetail.class);
	private String assessYear;
	private Double amtUADepreciation;

	private boolean markedForDeletion;
	private String personalInfoUuid;
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	//for personal information getter method
	public final String getAssessYear() {
		if (assessYear == null) assessYear = getProperty("mootlywcm:assessYear");
		return assessYear;
	}
	public final Double getAmtUADepreciation() {
		if (amtUADepreciation == null) amtUADepreciation = getProperty("mootlywcm:amtUaDep");
		return amtUADepreciation;
	}

	// setter method start here
	public final void setAssessYear(String assessYear) {
		this.assessYear = assessYear;
	}
	public final void setAmtUADepreciation(Double amtUADepreciation) {
		this.amtUADepreciation = amtUADepreciation;
	}

	//for personal information
	public final String getPersonalInfoUuid() {
		return personalInfoUuid;
	}

	public final void setPersonalInfoUuid(String personalInfoUuid) {
		this.personalInfoUuid = personalInfoUuid;
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

	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			node.setProperty("mootlywcm:assessYear", getAssessYear());
			if(getAmtUADepreciation()!=null){
				node.setProperty("mootlywcm:amtUaDep", getAmtUADepreciation());
			}
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		double amtdef=0.0d;
		if (formMap == null) return;
		if ( formMap.getField("assessYear") != null) {
			setAssessYear(formMap.getField("assessYear").getValue());
		}
		if ( formMap.getField("amtUaDep").getValue().isEmpty()) {
			setAmtUADepreciation(amtdef);
		}
		else{
			String stramtUaDep= formMap.getField("amtUaDep").getValue();
			double amtUaDep = Double.parseDouble(stramtUaDep);
			setAmtUADepreciation(amtUaDep);
		}

	}

	public <T extends HippoBean> void cloneBean(T sourceBean) {
		UnabsorbedDepreciationDetail objUAdepDetail = (UnabsorbedDepreciationDetail) sourceBean;
		setAssessYear(objUAdepDetail.getAssessYear());
		setAmtUADepreciation(objUAdepDetail.getAmtUADepreciation());
	};
}
