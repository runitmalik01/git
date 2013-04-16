
/**
 * User: Dhananjay
 * Date: March 30, 2013
 */

package com.mootly.wcm.beans;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.RepositoryException;
import javax.jcr.Value;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:interestdocument")
public class InterestDocument extends BaseDocument implements ContentNodeBinder {
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
}
