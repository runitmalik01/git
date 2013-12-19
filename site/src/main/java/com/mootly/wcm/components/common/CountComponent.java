/**
 * 
 */
package com.mootly.wcm.components.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.ITReturnComponent;

/**
 * @author admin
 *
 */
public class CountComponent extends ITReturnComponent {
	
	public static final Logger log = LoggerFactory.getLogger(CountComponent.class);
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean targetBeanScope = null;
		HippoBean siteContentBaseBean = getSiteContentBaseBeanForReseller(request);//getSiteContentBaseBean(request);//
		if(siteContentBaseBean == null){
			if(log.isInfoEnabled()){
				log.info("Site content Bean is { } null.Not able to proceed.");
			}
		}
		List<Counting> counterList = Counting.getOnCounters();
		Map<String,Integer> mapForCounterCompo = new HashMap<String,Integer>();
		if(!counterList.isEmpty()){
			for(Counting counter:counterList){
				Integer countValue = 0;
				List<HippoDocumentBean> hippoBeanList = loadAllBeansUnderTheFolder(request, response, counter.getCounterScope(), null, null);
				log.info("Size of hippoBean List returned"+hippoBeanList.size());
				for(HippoBean hippoBean:hippoBeanList){
					if(hippoBean.getClass().equals(counter.getCounterBean())){
						countValue += 1;
						if(log.isInfoEnabled()){
							log.info("Lets see class."+hippoBean.getClass().getSimpleName());
						}
						if(log.isInfoEnabled()){
							try {
								log.info("Lets observe comparison::"+hippoBean.equalCompare(counter.getCounterBean().newInstance()));
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				if(log.isInfoEnabled()){
					log.info("Value of Count::"+countValue);
				}
				mapForCounterCompo.put(counter.getCounterName(), countValue);
			}
		}
		request.setAttribute("mapForCounterCompo", mapForCounterCompo);
	}
}

enum Counting {
	
	COUNTER_1(true,"Members",MemberSignupDocument.class,"members"),
	COUNTER_2(true,"Filed Returns",MemberPersonalInformation.class,"members"),
	UNKNOWN;

	boolean isEnable;
	String counterName;
	Class<? extends HippoBean> counterBean;
	String counterScope;

	private Counting() {
		// TODO Auto-generated constructor stub
	}

	private Counting(boolean isEnable,String counterName,Class<? extends HippoBean> counterBean,String counterScope){
		this.isEnable = isEnable;
		this.counterName = counterName;
		this.counterBean = counterBean;
		this.counterScope = counterScope;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public String getCounterName() {
		return counterName;
	}
	public Class<? extends HippoBean> getCounterBean() {
		return counterBean;
	}
	public String getCounterScope() {
		return counterScope;
	}
	public static List<Counting> getOnCounters(){
		List<Counting> counters = new ArrayList<Counting>();
		for(Counting counter:Counting.values()){
			if(!counter.equals(Counting.UNKNOWN)){
				if(counter.isEnable()){
					counters.add(counter);
				}
			}
		}
		return counters;
	}
} 
