package com.mootly.wcm.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@XmlAccessorType(XmlAccessType.NONE)
public interface FormMapFiller {
	void fill(FormMap formMap);
	<T extends HippoBean> void cloneBean(T sourceBean);
}
