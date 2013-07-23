package com.mootly.wcm.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineFactory;

public final class VelocityUtils {
	static VelocityEngine velocityEngine = null;
	static Map<String,Object> globalMap = new HashMap<String, Object>();
	static {
		try{
			velocityEngine = new VelocityEngineFactory().createVelocityEngine();
			velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "jive");
            //ve.setProperty("jive.resource.loader.public.name", "Jive");
            //ve.setProperty("jive.resource.loader.description"," Jive Velocity Resource Loader");
            //ve.setProperty("jive.resource.loader.class", com.jivesoftware.util.JiveVelocityResourceLoader.class.getName());
			velocityEngine.setProperty("velocimacro.library", "");
            //ve.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, com.jivesoftware.base.log.JiveLogImpl.class.getName());
			velocityEngine.init();
			
			ResourceBundle messages = ResourceBundle.getBundle("messages");
			if (messages != null) globalMap.put("messages", messages);

		}catch (IOException ioe) {
			
		}
	}
	/**
	 * 
	 * @param velocityHtml
	 * @param contextMap
	 * @return
	 */
	public static String parseVelocity(String velocityHtml,Map<String,Object> contextMap) {
		Map<String,Object> context = new HashMap<String, Object>();
		context.putAll(contextMap);
		context.putAll(globalMap);
		VelocityContext velContext = new VelocityContext(context);	
		Writer sw = new StringWriter();
		velocityEngine.evaluate(velContext, sw, "groupMoveEmailReport", velocityHtml);
        String parsedSubject = sw.toString();
        return parsedSubject;
	}
}
