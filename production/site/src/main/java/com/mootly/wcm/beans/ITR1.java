package com.mootly.wcm.beans;

import static com.mootly.wcm.utils.Constants.PROP_TDS_SALARY;

import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

import com.mootly.wcm.beans.compound.TdsSalary;

@Node(jcrType = "mootlywcm:itrone")
public class ITR1 extends IncomeTaxReturn {

	private List<TdsSalary> tdsSalaryList;

	public final List<TdsSalary> getTdsSalaryList() {
		if (tdsSalaryList == null) tdsSalaryList= getChildBeans(PROP_TDS_SALARY);
		return tdsSalaryList;
	}

	public final void setTdsSalaryList(List<TdsSalary> tdsSalaryList) {
		this.tdsSalaryList = tdsSalaryList;
	}

	@Override
    public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
        super.bind(content, node);
        ITR1 bean = (ITR1) content;
        try {
        	NodeIterator nodeIterator = node.getNodes(PROP_TDS_SALARY);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
        	if (bean.getTdsSalaryList() != null && bean.getTdsSalaryList().size() > 0 ){ 
        		for (TdsSalary tdsSalary:bean.getTdsSalaryList()) {
	                javax.jcr.Node html = node.addNode(PROP_TDS_SALARY, PROP_TDS_SALARY);
	                tdsSalary.bindToNode(html); 
        		}
        	}
        	
//            if (getDescriptionContent() != null) {
//                if (node.hasNode(PROP_DESCRIPTION)) {
//                    javax.jcr.Node htmlNode = node.getNode(PROP_DESCRIPTION);
//                    if (!htmlNode.isNodeType("hippostd:html")) {
//                        throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
//                    }
//                    htmlNode.setProperty("hippostd:content", getDescriptionContent());
//                } else {
//                    javax.jcr.Node html = node.addNode(PROP_DESCRIPTION, "hippostd:html");
//                    html.setProperty("hippostd:content", html);
//                }
//            }
        } catch (RepositoryException e) {
            throw new ContentNodeBindingException(e);
        }

        return true;
    }
}
