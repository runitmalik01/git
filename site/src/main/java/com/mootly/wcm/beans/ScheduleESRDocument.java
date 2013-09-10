
/**
 * 
 * User: abhishek
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */


package com.mootly.wcm.beans;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.member.ITRScheduleSI;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRScheduleSISections;
import com.mootly.wcm.services.ITRAdditionalScheduleService;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:scheduleesrdocument")
public class ScheduleESRDocument extends BaseDocument implements ContentNodeBinder, FormMapFiller,ITRAdditionalScheduleService {
	static final public String NAMESPACE = "mootlywcm:scheduleesrdocument";
	static final public String NODE_NAME = "scheduleesrdocument";
	private Double amtDebit1;
	private Double amtDeduct1;
	private Double amtExcess1;
	private Double amtDebit2;
	private Double amtDeduct2;
	private Double amtExcess2;
	private Double amtDebit3;
	private Double amtDeduct3;
	private Double amtExcess3;
	private Double amtDebit4;
	private Double amtDeduct4;
	private Double amtExcess4;
	private Double amtDebit2AA;
	private Double amtDeduct2AA;
	private Double amtExcess2AA;
	private Double amtDebit2AB;
	private Double amtDeduct2AB;
	private Double amtExcess2AB;
	private Double totalDebit;
	private Double totalDeduct;
	private Double totalExcess;


	//for personal information
	public  Double getAmtDebit1() {
		if (amtDebit1 == null) amtDebit1 = getProperty("mootlywcm:amtDebit1");
		return amtDebit1;
	}
	public  Double getAmtDeduct1() {
		if (amtDeduct1 == null) amtDeduct1 = getProperty("mootlywcm:amtDeduct1");
		return amtDeduct1;
	}
	public  Double getAmtExcess1() {
		if (amtExcess1 == null) amtExcess1 = getProperty("mootlywcm:amtExcess1");
		return amtExcess1;
	}
	public  Double getAmtDebit2() {
		if (amtDebit2 == null) amtDebit2 = getProperty("mootlywcm:amtDebit2");
		return amtDebit2;
	}
	public  Double getAmtDeduct2() {
		if (amtDeduct2 == null) amtDeduct2 = getProperty("mootlywcm:amtDeduct2");
		return amtDeduct2;
	}
	public  Double getAmtExcess2() {
		if (amtExcess2 == null) amtExcess2 = getProperty("mootlywcm:amtExcess2");
		return amtExcess2;
	}
	public  Double getAmtDebit3() {
		if (amtDebit3 == null) amtDebit3 = getProperty("mootlywcm:amtDebit3");
		return amtDebit3;
	}
	public  Double getAmtDeduct3() {
		if (amtDeduct3 == null) amtDeduct3 = getProperty("mootlywcm:amtDeduct3");
		return amtDeduct3;
	}
	public  Double getAmtExcess3() {
		if (amtExcess3 == null) amtExcess3 = getProperty("mootlywcm:amtExcess3");
		return amtExcess3;
	}
	public  Double getAmtDebit4() {
		if (amtDebit4 == null) amtDebit4 = getProperty("mootlywcm:amtDebit4");
		return amtDebit4;
	}
	public  Double getAmtDeduct4() {
		if (amtDeduct4 == null) amtDeduct4 = getProperty("mootlywcm:amtDeduct4");
		return amtDeduct4;
	}
	public  Double getAmtExcess4() {
		if (amtExcess4 == null) amtExcess4 = getProperty("mootlywcm:amtExcess4");
		return amtExcess4;
	}
	public  Double getAmtDebit2AA() {
		if (amtDebit2AA == null) amtDebit2AA = getProperty("mootlywcm:amtDebit2AA");
		return amtDebit2AA;
	}
	public  Double getAmtDeduct2AA() {
		if (amtDeduct2AA == null) amtDeduct2AA = getProperty("mootlywcm:amtDeduct2AA");
		return amtDeduct2AA;
	}
	public  Double getAmtExcess2AA() {
		if (amtExcess2AA == null) amtExcess2AA = getProperty("mootlywcm:amtExcess2AA");
		return amtExcess2AA;
	}
	public  Double getAmtDebit2AB() {
		if (amtDebit2AB == null) amtDebit2AB = getProperty("mootlywcm:amtDebit2AB");
		return amtDebit2AB;
	}
	public  Double getAmtDeduct2AB() {
		if (amtDeduct2AB == null) amtDeduct2AB = getProperty("mootlywcm:amtDeduct2AB");
		return amtDeduct2AB;
	}
	public  Double getAmtExcess2AB() {
		if (amtExcess2AB == null) amtExcess2AB = getProperty("mootlywcm:amtExcess2AB");
		return amtExcess2AB;
	}
	public  Double getTotalDebit() {
		if (totalDebit == null) totalDebit = getProperty("mootlywcm:totalDebit");
		return totalDebit;
	}
	public  Double getTotalDeduct() {
		if (totalDeduct == null) totalDeduct = getProperty("mootlywcm:totalDeduct");
		return totalDeduct;
	}
	public  Double getTotalExcess() {
		if (totalExcess == null) totalExcess = getProperty("mootlywcm:totalExcess");
		return totalExcess;
	}




	// set method for otherincome document

	public final void  setAmtDebit1(Double amtDebit1) {
		this.amtDebit1 = amtDebit1;
	}
	public final void setAmtDeduct1(Double amtDeduct1) {
		this.amtDeduct1 = amtDeduct1;
	}
	public final void setAmtExcess1(Double amtExcess1) {
		this.amtExcess1 = amtExcess1;
	}
	public final void  setAmtDebit2(Double amtDebit2) {
		this.amtDebit2 = amtDebit2;
	}
	public final void setAmtDeduct2(Double amtDeduct2) {
		this.amtDeduct2 = amtDeduct2;
	}
	public final void setAmtExcess2(Double amtExcess2) {
		this.amtExcess2 = amtExcess2;
	}
	public final void  setAmtDebit3(Double amtDebit3) {
		this.amtDebit3 = amtDebit3;
	}
	public final void setAmtDeduct3(Double amtDeduct3) {
		this.amtDeduct3 = amtDeduct3;
	}
	public final void setAmtExcess3(Double amtExcess3) {
		this.amtExcess3 = amtExcess3;
	}
	public final void  setAmtDebit4(Double amtDebit4) {
		this.amtDebit4 = amtDebit4;
	}
	public final void setAmtDeduct4(Double amtDeduct4) {
		this.amtDeduct4 = amtDeduct4;
	}
	public final void setAmtExcess4(Double amtExcess4) {
		this.amtExcess4 = amtExcess4;
	}
	public final void  setAmtDebit2AA(Double amtDebit2AA) {
		this.amtDebit2AA = amtDebit2AA;
	}
	public final void setAmtDeduct2AA(Double amtDeduct2AA) {
		this.amtDeduct2AA = amtDeduct2AA;
	}
	public final void setAmtExcess2AA(Double amtExcess2AA) {
		this.amtExcess2AA = amtExcess2AA;
	}
	public final void  setAmtDebit2AB(Double amtDebit2AB) {
		this.amtDebit2AB = amtDebit2AB;
	}
	public final void setAmtDeduct2AB(Double amtDeduct2AB) {
		this.amtDeduct2AB = amtDeduct2AB;
	}
	public final void setAmtExcess2AB(Double amtExcess2AB) {
		this.amtExcess2AB = amtExcess2AB;
	}

	public final void  setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}
	public final void setTotalDeduct(Double totalDeduct) {
		this.totalDeduct = totalDeduct;
	}
	public final void setTotalExcess(Double totalExcess) {
		this.totalExcess = totalExcess;
	}


	/* public MemberPersonalInformation getMemberPersoanlInformation() {
	    	HippoBean bean = getBean(PROP_PI_PERSONALINFO_LINK);
	    	if (!(bean instanceof HippoMirror)) {
	    		return null;
	    	}
	    	MemberPersonalInformation prdBean = (MemberPersonalInformation) ((HippoMirror) bean).getReferencedBean();
	    	if (prdBean == null) {
	    		return null;
	    	}
	    	return prdBean;
	    }
	 */
	//for personal information

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {

			ScheduleESRDocument scheduleESRDocument = (ScheduleESRDocument) content;
			if (getAmtDebit1() != null) {
				node.setProperty("mootlywcm:amtDebit1", scheduleESRDocument.getAmtDebit1());
			}if(getAmtDeduct1()!=null){
				node.setProperty("mootlywcm:amtDeduct1", scheduleESRDocument.getAmtDeduct1());
			}if(getAmtExcess1()!=null){
				node.setProperty("mootlywcm:amtExcess1", scheduleESRDocument.getAmtExcess1());
			}
			if (getAmtDebit2() != null) {
				node.setProperty("mootlywcm:amtDebit2", scheduleESRDocument.getAmtDebit2());
			}if(getAmtDeduct2()!=null){
				node.setProperty("mootlywcm:amtDeduct2", scheduleESRDocument.getAmtDeduct2());
			}if(getAmtExcess2()!=null){
				node.setProperty("mootlywcm:amtExcess2", scheduleESRDocument.getAmtExcess2());
			}
			if (getAmtDebit3() != null) {
				node.setProperty("mootlywcm:amtDebit3", scheduleESRDocument.getAmtDebit3());
			}if(getAmtDeduct3()!=null){
				node.setProperty("mootlywcm:amtDeduct3", scheduleESRDocument.getAmtDeduct3());
			}if(getAmtExcess3()!=null){
				node.setProperty("mootlywcm:amtExcess3", scheduleESRDocument.getAmtExcess3());
			}
			if (getAmtDebit4() != null) {
				node.setProperty("mootlywcm:amtDebit4", scheduleESRDocument.getAmtDebit4());
			}if(getAmtDeduct4()!=null){
				node.setProperty("mootlywcm:amtDeduct4", scheduleESRDocument.getAmtDeduct4());
			}if(getAmtExcess4()!=null){
				node.setProperty("mootlywcm:amtExcess4", scheduleESRDocument.getAmtExcess4());
			}
			if (getAmtDebit2AA() != null) {
				node.setProperty("mootlywcm:amtDebit2AA", scheduleESRDocument.getAmtDebit2AA());
			}if(getAmtDeduct2AA()!=null){
				node.setProperty("mootlywcm:amtDeduct2AA", scheduleESRDocument.getAmtDeduct2AA());
			}if(getAmtExcess2AA()!=null){
				node.setProperty("mootlywcm:amtExcess2AA", scheduleESRDocument.getAmtExcess2AA());
			}
			if (getAmtDebit2AB() != null) {
				node.setProperty("mootlywcm:amtDebit2AB", scheduleESRDocument.getAmtDebit2AB());
			}if(getAmtDeduct2AB()!=null){
				node.setProperty("mootlywcm:amtDeduct2AB", scheduleESRDocument.getAmtDeduct2AB());
			}if(getAmtExcess2AB()!=null){
				node.setProperty("mootlywcm:amtExcess2AB", scheduleESRDocument.getAmtExcess2AB());
			}
			if (getTotalDebit() != null) {
				node.setProperty("mootlywcm:totalDebit", scheduleESRDocument.getTotalDebit());
			}if(getTotalDeduct()!=null){
				node.setProperty("mootlywcm:totalDeduct", scheduleESRDocument.getTotalDeduct());
			}if(getTotalExcess()!=null){
				node.setProperty("mootlywcm:totalExcess", scheduleESRDocument.getTotalExcess());
			}

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		double amt=0.0d;

		if (formMap.getField("amtDebit1").getValue().isEmpty()){
			setAmtDebit1(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDebit1").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDebit1(amt1);
		}
		if (formMap.getField("amtDeduct1").getValue().isEmpty()){
			setAmtDeduct1(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDeduct1").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDeduct1(amt1);
		}
		if (formMap.getField("amtExcess1").getValue().isEmpty()){
			setAmtExcess1(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtExcess1").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtExcess1(amt1);
		}

		if (formMap.getField("amtDebit2").getValue().isEmpty()){
			setAmtDebit2(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDebit2").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDebit2(amt1);
		}
		if (formMap.getField("amtDeduct2").getValue().isEmpty()){
			setAmtDeduct2(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDeduct2").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDeduct2(amt1);
		}
		if (formMap.getField("amtExcess2").getValue().isEmpty()){
			setAmtExcess2(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtExcess2").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtExcess2(amt1);
		}


		if (formMap.getField("amtDebit3").getValue().isEmpty()){
			setAmtDebit3(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDebit3").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDebit3(amt1);
		}
		if (formMap.getField("amtDeduct3").getValue().isEmpty()){
			setAmtDeduct3(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDeduct3").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDeduct3(amt1);
		}
		if (formMap.getField("amtExcess3").getValue().isEmpty()){
			setAmtExcess3(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtExcess3").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtExcess3(amt1);
		}

		if (formMap.getField("amtDebit4").getValue().isEmpty()){
			setAmtDebit4(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDebit4").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDebit4(amt1);
		}
		if (formMap.getField("amtDeduct4").getValue().isEmpty()){
			setAmtDeduct4(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDeduct4").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDeduct4(amt1);
		}
		if (formMap.getField("amtExcess4").getValue().isEmpty()){
			setAmtExcess4(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtExcess4").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtExcess4(amt1);
		}
		if (formMap.getField("amtDebit2AA").getValue().isEmpty()){
			setAmtDebit2AA(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDebit2AA").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDebit2AA(amt1);
		}
		if (formMap.getField("amtDeduct2AA").getValue().isEmpty()){
			setAmtDeduct2AA(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDeduct2AA").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDeduct2AA(amt1);
		}
		if (formMap.getField("amtExcess2AA").getValue().isEmpty()){
			setAmtExcess2AA(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtExcess2AA").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtExcess2AA(amt1);
		}

		if (formMap.getField("amtDebit2AB").getValue().isEmpty()){
			setAmtDebit2AB(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDebit2AB").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDebit2AB(amt1);
		}
		if (formMap.getField("amtDeduct2AB").getValue().isEmpty()){
			setAmtDeduct2AB(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtDeduct2AB").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtDeduct2AB(amt1);
		}
		if (formMap.getField("amtExcess2AB").getValue().isEmpty()){
			setAmtExcess2AB(amt);
		}
		else{
			String stramtDebit1=formMap.getField("amtExcess2AB").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setAmtExcess2AB(amt1);
		}

		if (formMap.getField("totalDebit").getValue().isEmpty()){
			setTotalDebit(amt);
		}
		else{
			String stramtDebit1=formMap.getField("totalDebit").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setTotalDebit(amt1);
		}
		if (formMap.getField("totalDeduct").getValue().isEmpty()){
			setTotalDeduct(amt);
		}
		else{
			String stramtDebit1=formMap.getField("totalDeduct").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setTotalDeduct(amt1);
		}
		if (formMap.getField("totalExcess").getValue().isEmpty()){
			setTotalExcess(amt);
		}
		else{
			String stramtDebit1=formMap.getField("totalExcess").getValue();
			double amt1= Double.parseDouble(stramtDebit1);
			setTotalExcess(amt1);
		}



		/*	if (formMap.getField("Income_maintain").getValue().isEmpty()){}
		else{
			String strIncome_maintain=formMap.getField("Income_maintain").getValue();
			double amt= Double.parseDouble(strIncome_maintain);

			setIncome_maintain(amt);
		}*/


	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	@Override
	public Map<String, Map<String, Object>> getScheduleSIService(
			FinancialYear financialYear, Map<String, HippoBean> inputBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
