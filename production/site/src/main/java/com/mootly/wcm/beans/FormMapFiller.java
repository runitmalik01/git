package com.mootly.wcm.beans;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.standard.HippoBean;


public interface FormMapFiller {
	void fill(FormMap formMap);
	<T extends HippoBean> void cloneBean(T sourceBean);
}
