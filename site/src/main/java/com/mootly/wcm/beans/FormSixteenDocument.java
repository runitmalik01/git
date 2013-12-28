
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
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.PersonalInformation;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:formsixteendocument")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class FormSixteenDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final public String NAMESPACE = "mootlywcm:formsixteendocument";
	static final public String NODE_NAME = "formsixteendocument";
	final String PROP_DETAIL_BEAN="mootlywcm:formsixteendetail";
	private String itFolderUuid;
	
	private final static Logger log = LoggerFactory.getLogger(FormSixteenDocument.class); 

	private List<FormSixteenDetail> formSixteenDetailList;

	public final List<FormSixteenDetail> getFormSixteenDetailList() {
		if (formSixteenDetailList == null) formSixteenDetailList= getChildBeans(PROP_DETAIL_BEAN);
		return formSixteenDetailList;
	}

	public final void setFormSixteenDetailList(List<FormSixteenDetail> formSixteenDetailList) {
		this.formSixteenDetailList = formSixteenDetailList;
	}
	
	public final void addFormSixteenDetail(FormSixteenDetail formSixteenDetail) {
		getFormSixteenDetailList();
		if (formSixteenDetailList == null) formSixteenDetailList = new ArrayList<FormSixteenDetail>();
		formSixteenDetailList.add(formSixteenDetail);
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
			FormSixteenDocument objFormSixteen = (FormSixteenDocument) content;
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	if (objFormSixteen.getFormSixteenDetailList() != null && objFormSixteen.getFormSixteenDetailList().size() > 0 ){ 
        		for (FormSixteenDetail formSixteenDetail:objFormSixteen.getFormSixteenDetailList()) {
        			if (!formSixteenDetail.isMarkedForDeletion()) {
		                javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
		                formSixteenDetail.bindToNode(html); 
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
		FormSixteenDocument objFormSixteenDocument = (FormSixteenDocument) sourceBean;
		
		
	}
	
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		//check for available children
		if (child.getCanonicalUUID() == null) {
			FormSixteenDetail source =(FormSixteenDetail) child;
			addFormSixteenDetail(source);
		}
		boolean found = false;
		List<FormSixteenDetail> listOfChildren = getFormSixteenDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				FormSixteenDetail destination =(FormSixteenDetail) o;
				FormSixteenDetail source  = (FormSixteenDetail) child;
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
		FormSixteenDetail source =(FormSixteenDetail) child;
		addFormSixteenDetail(source);		
	}
	
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//check for available children
		boolean found = false;
		List<FormSixteenDetail> listOfChildren = getFormSixteenDetailList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				FormSixteenDetail destination =(FormSixteenDetail) o;
				FormSixteenDetail source  = (FormSixteenDetail) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			FormSixteenDetail source =(FormSixteenDetail) child;
			addFormSixteenDetail(source);
		}		
	}
}
