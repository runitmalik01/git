package com.mootly.wcm.model;

import org.apache.commons.lang.StringUtils;

public enum ITRScheduleSISections {
	
	SI_111A("111A - STCG on shares where STT paid","1A", 15, false, ResidentStatus.values()),
	SI_112_LTGC("112 - LTCG on listed securities/ units without indexation","22", 10, false , ResidentStatus.values()),
	SI_112_1_c_iii("112(1)(c)(iii) - LTCG on unlisted ","21ciii", 10, false , ResidentStatus.values()),
	SI_112_LTGC_OTHER("112 - LTCG on others","21", 20, false, ResidentStatus.values()),
	SI_115_bb("115BB - Winnings from lotteries, puzzles, races, games etc","5BB", 30, false, ResidentStatus.values()),
	SI_DTAA("DTAA - Double Taxation Avoidance Agreement","DTAA", 1, true, ResidentStatus.values()),//there is no percentage rate define for this section so we give 1 as rate that will effect in calculation
	SI_111("111 - Tax on accumulated balance of recognised PF","1", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_a_i("115A(1)(a)(i)- Dividends, interest and income from units purchase in foreign currency","5A1ai", 20, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_a_ii("115A(1)(a)(ii)- Interest received from govt/Indian Concerns recived in Foreign Currency","5A1aii", 20, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_FA("Para E II of Part I of Ist Sch of FA - Income from royalty or technical services - Non-domestic company","FA", 50, true, new ResidentStatus[]{ResidentStatus.NRI}),
	SI_115A_1_a_ii_a("115A(1) (a)(iia) - Interest from Infrastructure Debt Fund","5A1aiia", 5, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_a_ii_aa("115A(1) (a)(iiaa) - Interest as per Sec. 194LC","5A1aiiaa", 5, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_a_iii("115A(1) (a)(iii) - Income received in respect of units of UTI purchased in Foreign Currency","5A1aiii", 20, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_b_1("115A(1)(b)-1 - Income from royalty & technical services","5A1b1", 30, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_b_2("115A(1)(b)-2 - Income from royalty & technical services","5A1b2", 20, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115A_1_b_3("115A(1)(b)-3 - Income from royalty & technical services","5A1b3", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115AB_1_a("115AB(1)(a) - Income in respect of units - off -shore fund","5AB1a", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115AB_1_b("115AB(1)(b) - LTCG on units - off-shore fund","5AB1b", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115AC_1("115AC(1) - Income from bonds or GDR purchases or capital gains  -  non-resident","5AC", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115ACA_1("115ACA(1) - Income from  GDR purchases or capital gains  - resident","5ACA", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115B("115B - Profits and gains of life insurance business","5B", 12.5, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115BBA("115BBA - Tax on non-residents sportsmen or sports associations","5BBA", 20, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115BBB("115BBB - Tax on income from units","5BBB", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115BBC("115BBC - Anonymous donations","5BBC", 30, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115BBE("115BBE - Tax on income referred to in sections 68 or 69 or 69A or  69B or  69C or  69D","5BBE", 30, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115E_a("115E(a) - Investment income","5Ea", 20, true, new ResidentStatus[]{ResidentStatus.RES}),
	SI_115E_b("115E(b) - Income by way of long term capital gains","5Eb", 10, true, new ResidentStatus[]{ResidentStatus.RES}),
	UNKNOWN;
	
	String displayName;//name of schedule SI section i.e. display on screen
	String xmlCode; // Xml code of schedule SI section i.e save in repository
	double percentRate; // Percentage Rate of schedule SI section i.e. applied to amount provided
	boolean isActive; // section will shown on screen or not
	ResidentStatus[] residentialStatus; // sections depends on residential status of users
	private ITRScheduleSISections() {
		// TODO Auto-generated constructor stub
	}
	
	private ITRScheduleSISections(String displayName,String xmlCode,double percentRate,boolean isActive,ResidentStatus[] residentialStatus){
		this.displayName = displayName;
		this.xmlCode = xmlCode;
		this.percentRate =percentRate;
		this.isActive = isActive;
		this.residentialStatus = residentialStatus;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public double getPercentRate() {
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
 	
}
