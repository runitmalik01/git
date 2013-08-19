package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;

public enum ITRScheduleSISections {
	
	SI_111A("111A - STCG on shares where STT paid","1A", new Double[]{15d}, false, ResidentStatus.values(), true, CapitalAssetDocument.class.getSimpleName()),
	SI_112_LTGC("112 - LTCG on listed securities/ units without indexation","22", new Double[]{10d}, false , ResidentStatus.values(), true, CapitalAssetDocument.class.getSimpleName()),
	SI_112_1_c_iii("112(1)(c)(iii) - LTCG on unlisted securities in case of non-residents","21ciii", new Double[]{10d}, false , new ResidentStatus[]{ResidentStatus.NRI}, true, CapitalAssetDocument.class.getSimpleName()),
	SI_112_LTGC_OTHER("112 - LTCG on others","21", new Double[]{20d}, false, ResidentStatus.values(), true, CapitalAssetDocument.class.getSimpleName()),
	SI_115_bb("115BB - Winnings from lotteries, puzzles, races, games etc","5BB", new Double[]{30d}, false, ResidentStatus.values(), true, OtherSourcesDocument.class.getSimpleName()),
	SI_DTAA("DTAA - Double Taxation Avoidance Agreement","DTAA", new Double[]{1d}, true, ResidentStatus.values(), true, ScheduleSIDocument.class.getSimpleName()),//there is no percentage rate define for this section so we give 1 as rate that will effect in calculation
	SI_111("111 - Tax on accumulated balance of recognised PF","1", new Double[]{1d,10d,12.5d,15d,20d,30d,50d}, true, ResidentStatus.values(), true, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_a_i("115A(1)(a)(i)- Dividends, interest and income from units purchase in foreign currency","5A1ai", new Double[]{20d}, true, ResidentStatus.values(), true, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_a_ii("115A(1)(a)(ii)- Interest received from govt/Indian Concerns recived in Foreign Currency","5A1aii", new Double[]{20d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_FA("Para E II of Part I of Ist Sch of FA - Income from royalty or technical services - Non-domestic company","FA", new Double[]{50d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_a_ii_a("115A(1) (a)(iia) - Interest from Infrastructure Debt Fund","5A1aiia", new Double[]{5d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_a_ii_aa("115A(1) (a)(iiaa) - Interest as per Sec. 194LC","5A1aiiaa", new Double[]{5d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_a_iii("115A(1) (a)(iii) - Income received in respect of units of UTI purchased in Foreign Currency","5A1aiii", new Double[]{20d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_b_1("115A(1)(b)-1 - Income from royalty & technical services","5A1b1", new Double[]{30d}, true, ResidentStatus.values(), true, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_b_2("115A(1)(b)-2 - Income from royalty & technical services","5A1b2", new Double[]{20d}, true, ResidentStatus.values(), true, ScheduleSIDocument.class.getSimpleName()),
	SI_115A_1_b_3("115A(1)(b)-3 - Income from royalty & technical services","5A1b3", new Double[]{10d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115AB_1_a("115AB(1)(a) - Income in respect of units - off -shore fund","5AB1a", new Double[]{10d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115AB_1_b("115AB(1)(b) - LTCG on units - off-shore fund","5AB1b", new Double[]{10d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115AC_1("115AC(1) - Income from bonds or GDR purchases or capital gains  -  non-resident","5AC", new Double[]{10d}, true, ResidentStatus.values(),false, ScheduleSIDocument.class.getSimpleName()),
	SI_115ACA_1("115ACA(1) - Income from  GDR purchases or capital gains  - resident","5ACA", new Double[]{10d}, true, ResidentStatus.values(),false, ScheduleSIDocument.class.getSimpleName()),
	SI_115B("115B - Profits and gains of life insurance business","5B", new Double[]{12.5d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115BBA("115BBA - Tax on non-residents sportsmen or sports associations","5BBA", new Double[]{20d}, true, ResidentStatus.values(), true, ScheduleSIDocument.class.getSimpleName()),
	SI_115BBB("115BBB - Tax on income from units","5BBB", new Double[]{10d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115BBC("115BBC - Anonymous donations","5BBC", new Double[]{30d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115BBE("115BBE - Tax on income referred to in sections 68 or 69 or 69A or  69B or  69C or  69D","5BBE", new Double[]{30d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115E_a("115E(a) - Investment income","5Ea", new Double[]{20d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	SI_115E_b("115E(b) - Income by way of long term capital gains","5Eb", new Double[]{10d}, true, ResidentStatus.values(), false, ScheduleSIDocument.class.getSimpleName()),
	UNKNOWN;
	
	String displayName;//name of schedule SI section i.e. display on screen
	String xmlCode; // Xml code of schedule SI section i.e save in repository
	Double[] percentRate; // Percentage Rate of schedule SI section i.e. applied to amount provided
	boolean isActive; // section will shown on screen or not
	ResidentStatus[] residentialStatus; // sections depends on residential status of users
	boolean isXmlActive;// some schedule SI sections nodes are compulsory to create in Xml creation no matter they have or 've not corresponding Income. 
	String documentName;// name of screen on which this value depend and in that screen use ITRAdditionalScheduleSrevice
	private ITRScheduleSISections() {
		// TODO Auto-generated constructor stub
	}
	
	private ITRScheduleSISections(String displayName,String xmlCode,Double[] percentRate,boolean isActive,ResidentStatus[] residentialStatus,boolean isXmlActive,String documentName){
		this.displayName = displayName;
		this.xmlCode = xmlCode;
		this.percentRate =percentRate;
		this.isActive = isActive;
		this.residentialStatus = residentialStatus;
		this.isXmlActive = isXmlActive;
		this.documentName = documentName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public Double[] getPercentRate() {
		return percentRate;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public String getXmlCode() {
		return xmlCode;
	}
	
	public ResidentStatus[] getResidentialStatus() {
		return residentialStatus;
	}
	
	public boolean isXmlActive() {
		return isXmlActive;
	}
	
	public String getDocumentName() {
		return documentName;
	}
	
	public static ITRScheduleSISections getScheduleSISection(String xmlCode){
		if(StringUtils.isNotBlank(xmlCode)){
			for(ITRScheduleSISections si:ITRScheduleSISections.values()){
				if(xmlCode.equals(si.getXmlCode())){
					return si;
				}
			}
		}
		return ITRScheduleSISections.UNKNOWN;
	}
 	/**
 	 * This method is used to create the list of all inActive Schedule SI sections which are not being shown to user.
 	 * 
 	 *  @param inputBean {@link Map} this map list of all {@link HippoBean} Documents.
 	 *  
 	 *  @return List of all inActive Schedule SI Section.
 	 *  
 	 * */
	public static List<ITRScheduleSISections> createInActiveScheduleSIList(Map<String, HippoBean> inputBean){
		MemberPersonalInformation o = (MemberPersonalInformation) inputBean.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections schSISection:ITRScheduleSISections.values()){
			if(!schSISection.isActive() && schSISection != ITRScheduleSISections.UNKNOWN){
				for(ResidentStatus rs:schSISection.getResidentialStatus()){
					if(rs.toString().equalsIgnoreCase(o.getResidentCategory())){
						scheduleSIList.add(schSISection);
					}
				}							
			}
		}
		return scheduleSIList;
	}
	/**
	 * This method is used to create list of all sections in ITR2 Xml that must have these section nodes rather {@link ScheduleSIDocument} is present or not.
	 * 
	 * @return List all schedule SI Sections.
	 * 
	 * */
	public static List<ITRScheduleSISections> createXmlActiveListOfSI(){
		List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections si:ITRScheduleSISections.values()){
			if(si.isXmlActive() && si != ITRScheduleSISections.UNKNOWN){
				scheduleSIList.add(si);
			}
		}
		return scheduleSIList;
	}
	/**
	 * This method is used to return the all Schedule SI section which are depend any other HippoBean Documents.
	 * 
	 * @param documentName {@link String} name of document Bean of Document Type.
	 * 
	 * @return List all schedule SI Sections.
	 * 
	 * */
	public static List<ITRScheduleSISections> getListOfSISection(String documentName){
		List<ITRScheduleSISections> scheduleSIList = new ArrayList<ITRScheduleSISections>();
		for(ITRScheduleSISections si:ITRScheduleSISections.values()){
			if(si.getDocumentName().equals(documentName) && si != ITRScheduleSISections.UNKNOWN){
				scheduleSIList.add(si);
			}
		}
		return scheduleSIList;
	}
}
