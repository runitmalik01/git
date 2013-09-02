
/**
 * 
 * @author  abhishek
 * Date: 01/09/2013
 * Time: 11:26:35 AM
 * 
 */


package com.mootly.wcm.beans;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.services.ScreenCalculatorService;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:tcsdocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class TcsDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:tcsdocument";
	static final public String NODE_NAME = "tcsdocument";
	final String PROP_DETAIL_BEAN="mootlywcm:tcsdetail";
	private String itFolderUuid;
	private Double Total;
	public String getGross_salary() {
		return "0";
	}

	private final static Logger log = LoggerFactory.getLogger(TcsDocument.class); 

	private List<TcsDetail> tcsDetailList;

	public final List<TcsDetail> getTcsDetailList() {
		if (tcsDetailList == null) tcsDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return tcsDetailList;
	}

	public final void setTcsDetailList(List<TcsDetail> tcsDetailList) {
		this.tcsDetailList = tcsDetailList;
	}

	public final void addTcsDetail(TcsDetail tcsDetail) {
		getTcsDetailList();
		if (tcsDetailList == null) tcsDetailList = new ArrayList<TcsDetail>();
		tcsDetailList.add(tcsDetail);
	}

	public final Double getTotal() {
		if (Total == null) Total = getProperty("mootlywcm:Total");
		return Total;
	}

	public final void setTotal(Double Total) {
		this.Total = Total;
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
			TcsDocument tcsDocument = (TcsDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			double sum=0d;
			if (tcsDocument.getTcsDetailList() != null && tcsDocument.getTcsDetailList().size() > 0 ){ 
				for (TcsDetail tcsDetail:tcsDocument.getTcsDetailList()) {

					if (!tcsDetail.isMarkedForDeletion()) {
						double amount=tcsDetail.getTaxCredited();
						sum=sum+amount;
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						tcsDetail.bindToNode(html); 
					}
				}
				setTotal(sum);
			}
			//Map<String,Object> totalMapForJSSalary = new HashMap<String, Object>();
			//Map<String,String[]> requestParameterMap=new HashMap<String,String[]>();
			//totalMapForJSSalary.put("salaryincome", salaryincome);
			//Map<String,Object> resultMapSalary = ScreenCalculatorService.getScreenCalculations("salaryincome.js", requestParameterMap , totalMapForJSSalary);
			//setTotal(Double.parseDouble(resultMapSalary.get("total_salaryincome").toString()));
			node.setProperty("mootlywcm:Total",getTotal());
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
		TcsDocument tcsDocument = (TcsDocument) sourceBean;


	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			TcsDetail source =(TcsDetail) child;
			addTcsDetail(source);
		}
		boolean found = false;
		List<TcsDetail> listOfChildren = getTcsDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				TcsDetail destination =(TcsDetail) o;
				TcsDetail source  = (TcsDetail) child;
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
		TcsDetail source =(TcsDetail) child;
		addTcsDetail(source);		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<TcsDetail> listOfChildren = getTcsDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				TcsDetail destination =(TcsDetail) o;
				TcsDetail source  = (TcsDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			TcsDetail source =(TcsDetail) child;
			addTcsDetail(source);
		}		
	}
}
