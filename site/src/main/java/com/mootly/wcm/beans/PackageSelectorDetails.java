/* For Selection of package */

package com.mootly.wcm.beans;


import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;


@Node(jcrType="mootlywcm:PackageSelectorDetails")
public class PackageSelectorDetails  extends BaseDocument implements ContentNodeBinder, FormMapFiller {
	// private static final Logger log = LoggerFactory.getLogger(PackageSelectorDetails.class);
	static final public String NAMESPACE = "mootlywcm:PackageSelectorDetails";
	static final public String NODE_NAME = "PackageSelectorDetails";
	String pan;
	String financialyear;
	String filingstatus;
	Boolean basic;
	Boolean premier;
	Boolean assisted;
	//String packageUuid;

	public String getPan() {
		if (pan== null) pan = getProperty("mootlywcm:pan");
		return pan;
	}
	public String getFinancialyear() {
		if (financialyear== null) financialyear = getProperty("mootlywcm:financialyear");
		return financialyear;
	}
	public String getFilingstatus() {
		if (filingstatus== null) filingstatus = getProperty("mootlywcm:filingstatus");
		return filingstatus;	
	}
	public Boolean getBasic() {
		if (basic== null) basic = getProperty("mootlywcm:basic");
		return basic;
	}
	public Boolean getPremier() {
		if (premier== null) premier = getProperty("mootlywcm:premier");
		return premier;
	}
	public Boolean getAssisted() {
		if (assisted== null) assisted = getProperty("mootlywcm:assisted");
		return assisted;
	}
	/*public String getPackageUuid() {
        return packageUuid;
    }

    public void setPackageUuid(String uuid) {
        this.packageUuid = uuid;
    } */
	
	
	public void setPan(String pan) {
		this.pan = pan;
	}
	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}
	
	public void setFilingstatus(String filingstatus) {
		this.filingstatus = filingstatus;
	}
	
	public void setBasic(Boolean basic) {
		this.basic = basic;
	}
	public void setPremier(Boolean premier) {
		this.premier = premier;
	}
	public void setAssisted(Boolean assisted) {
		this.assisted = assisted;
	}	
	
	/*public Package getPackage() {
        HippoBean bean = getBean("mootlywcm:packagelink");
        if (!(bean instanceof HippoMirror)) {
            return null;
        }

        Package prdBean = (Package) ((HippoMirror) bean).getReferencedBean();

        if (prdBean == null) {
            return null;
        }
        return prdBean;
    } */

	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
       // if (content instanceof PackageSelectorDetails) {
            try {
			PackageSelectorDetails packageselector = (PackageSelectorDetails) content;
			node.setProperty("mootlywcm:pan", packageselector.getPan());
			node.setProperty("mootlywcm:financialyear", packageselector.getFinancialyear());
			node.setProperty("mootlywcm:filingstatus", packageselector.getFilingstatus());
			node.setProperty("mootlywcm:basic", packageselector.getBasic());
			node.setProperty("mootlywcm:premier", packageselector.getPremier());
			node.setProperty("mootlywcm:assisted", packageselector.getAssisted());
            
		/*	javax.jcr.Node prdLinkNode;

            if (node.hasNode("mootlywcm:packagelink")) {
                prdLinkNode = node.getNode("mootlywcm:packagelink");
            } else {
                prdLinkNode = node.addNode("mootlywcm:packagelink", "hippo:mirror");
            }
            prdLinkNode.setProperty("hippo:docbase", packageselector.getPackageUuid());
            */

        } 
        catch (Exception e) {
            log.error("Unable to bind the content to the JCR Node" + e.getMessage(), e);
            throw new ContentNodeBindingException(e);
        }

    return true;
}
	
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		if ( formMap.getField("pan") != null) {
			setPan(formMap.getField("pan").getValue());
		}
		if ( formMap.getField("financialyear") != null) {
			setFinancialyear(formMap.getField("financialyear").getValue());
		}
		if ( formMap.getField("filingstatus") != null) {
			setFilingstatus(formMap.getField("filingstatus").getValue());
		}
		if(formMap.getField("package")!=null){
			if(formMap.getField("package").getValue().matches("basic")) setBasic(true);
			if(formMap.getField("package").getValue().matches("premier")) setPremier(true);
			if(formMap.getField("package").getValue().matches("assisted")) setAssisted(true);
		}

	}
	

	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	
	
}
