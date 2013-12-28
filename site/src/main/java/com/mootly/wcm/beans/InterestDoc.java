
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
@Node(jcrType = "mootlywcm:interestdoc")
public class InterestDoc extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:interestdoc";
	static final public String NODE_NAME = "interestdoc";
	private Double section234A;
	private Double section234B;
	private Double section234C;
	private Double section234ABC;
	
	public Double getSection234A() {
		if (section234A == null) section234A = getProperty("mootlywcm:section234A");
    	return section234A;
    }

    public Double getSection234B() {
    	if (section234B == null) section234B = getProperty("mootlywcm:section234B");
    	return section234B;
    }

    public Double getSection234C() {
    	if (section234C == null) section234C = getProperty("mootlywcm:section234C");
    	return section234C;
    }
    
    public Double getSection234ABC() {
    	if (section234ABC == null) section234ABC = getProperty("mootlywcm:section234ABC");
      	return section234ABC;
    }
    
    public final void setSection234A(Double Section234A) {
		this. section234A =  Section234A;
	}

	public final void setSection234B(Double Section234B) {
		this.section234B = Section234B;
	}

	public final void setSection234C(Double Section234C) {
		this.section234C = Section234C;
	}
   
	public final void setSection234ABC(Double Section234ABC) {
		this.section234ABC = Section234ABC;
	}
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			InterestDoc interestdocument = (InterestDoc) content;
			
			node.setProperty("mootlywcm:section234A",interestdocument.getSection234A());
	    	node.setProperty("mootlywcm:section234B",interestdocument.getSection234B());
	    	node.setProperty("mootlywcm:section234C",interestdocument.getSection234C());
	    	node.setProperty("mootlywcm:section234ABC",interestdocument.getSection234ABC());
	    	
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
		if ( formMap.getField("intA") != null) {
			String strSection234A=formMap.getField("intA").getValue();
			double sec234a = Double.parseDouble(strSection234A);
			setSection234A(sec234a);
		}
		if ( formMap.getField("intB") != null) {
			String strSection234B=formMap.getField("intB").getValue();
			double sec234b = Double.parseDouble(strSection234B);
			setSection234B(sec234b);
		}
		if ( formMap.getField("ic") != null) {
			String strSection234C=formMap.getField("ic").getValue();
			double sec234c = Double.parseDouble(strSection234C);
			setSection234C(sec234c);
		}
		if ( formMap.getField("intt") != null) {
			String strSection234ABC=formMap.getField("intt").getValue();
			double sec234abc = Double.parseDouble(strSection234ABC);
			setSection234ABC(sec234abc);
		}
		
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
