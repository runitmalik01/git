package com.mootly.wcm.components;

import java.util.Map;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPageComponent extends BaseComponent {
	private static final Logger log = LoggerFactory.getLogger(DefaultPageComponent.class);
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {
        super.doBeforeRender(request, response);
        Map<String, String> pageParams = getParameters(request);
        /*
        if (pageParams != null) {
        	Iterator<String> it = pageParams.keySet().iterator();
        	while (it.hasNext()) {
        		String key = it.next();
        		log.info(key + ":" + pageParams.get(key));
        	}
        }
        */
    }
}
