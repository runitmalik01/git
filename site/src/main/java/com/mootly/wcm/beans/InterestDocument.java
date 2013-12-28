
/**
 * User: Dhananjay
 * Date: March 30, 2013
 */

package com.mootly.wcm.beans;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:interestdocument")
public class InterestDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:interestdocument";
	static final public String NODE_NAME = "interestdocument";
	private String section234A;
	private String section234B;
	private String section234C;
	
	public String getSection234A() {
        if (section234A == null) section234A = getProperty("mootlywcm:section234A");
        return section234A;
    }

    public String getSection234B() {
    	if (section234B == null) section234B = getProperty("mootlywcm:section234B");
    	return section234B;
    }

    public String getSection234C() {
    	if (section234C== null) section234C= getProperty("mootlywcm:section234C");
    	return section234C;
    }

    
    public final void setSection234A(String Section234A) {
		this. section234A =  Section234A;
	}

	public final void setSection234B(String Section234B) {
		this.section234B = Section234B;
	}

	public final void setSection234C(String Section234C) {
		this.section234C = Section234C;
	}
   
	@SuppressWarnings("deprecation")
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			InterestDocument interestdocument = (InterestDocument) content;
			
			node.setProperty("mootlywcm:section234A",interestdocument.getSection234A());
	    	node.setProperty("mootlywcm:section234B",interestdocument.getSection234B());
	    	node.setProperty("mootlywcm:section234C",interestdocument.getSection234C());
	    	
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		if ( formMap.getField("section234A") != null) {
			setSection234A(formMap.getField("section234A").getValue());
		}
		if ( formMap.getField("section234B") != null) {
			setSection234B(formMap.getField("section234B").getValue());
		}
		if ( formMap.getField("section234C") != null) {
			setSection234C(formMap.getField("section234C").getValue());
		}
		
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
