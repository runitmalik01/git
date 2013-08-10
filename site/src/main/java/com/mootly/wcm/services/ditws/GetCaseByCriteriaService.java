package com.mootly.wcm.services.ditws;



public interface GetCaseByCriteriaService {
	public static final String workLogQualificationString = "workLogQualificationString";
	public static final String workLogStartRecord = "workLogStartRecord"; 
	public static final String workLogMaxLimit = "workLogMaxLimit"; 
	public static final String otherHistoryItemsQualificationString = "otherHistoryItemsQualificationString"; 
	public static final String otherHistoryItemsStartRecord = "otherHistoryItemsStartRecord"; 
	public static final String otherHistoryItemsMaxLimit = "otherHistoryItemsMaxLimit"; 
	String soapMessage = 
		"<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:crm=\"http://schemas.knova.com/CRMInterface\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
		"   <soapenv:Header/>" +
		"   <soapenv:Body>" +
		"      <crm:getCasesByCriteria soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
		"         <in0 xsi:type=\"xsd:int\">1</in0>" +
		"         <in1 xsi:type=\"xsd:int\">1</in1>" +
		"         <in2 xsi:type=\"crm:CRMCriteria\">" +
		"            <criteriaFields xsi:type=\"crm:ArrayOfCRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[]\">" +
		"		<criteriaField xsi:type=\"crm:CRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[0]\">" +
		"			<name xsi:type=\"soapenc:string\">workLogQualificationString</name>" +
		"			<value xsi:type=\"soapenc:string\">\"'Request ID' LIKE \"%1\"\"</value>" +
		"		</criteriaField>" +
		"		<criteriaField xsi:type=\"crm:CRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[1]\">" +
		"			<name xsi:type=\"soapenc:string\">workLogStartRecord</name>" +
		"			<value xsi:type=\"soapenc:string\">2</value>" +
		"		</criteriaField>" +
		"		<criteriaField xsi:type=\"crm:CRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[2]\">" +
		"			<name xsi:type=\"soapenc:string\">workLogMaxLimit</name>" +
		"			<value xsi:type=\"soapenc:string\">2</value>" +
		"		</criteriaField>" +
		"		<criteriaField xsi:type=\"crm:CRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[3]\">" +
		"			<name xsi:type=\"soapenc:string\">otherHistoryItemsQualificationString</name>" +
		"			<value xsi:type=\"soapenc:string\">2</value>" +
		"		</criteriaField>" +
		"		<criteriaField xsi:type=\"crm:CRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[4]\">" +
		"			<name xsi:type=\"soapenc:string\">otherHistoryItemsStartRecord</name>" +
		"			<value xsi:type=\"soapenc:string\">2</value>" +
		"		</criteriaField>" +
		"		<criteriaField xsi:type=\"crm:CRMCriteriaField\" soapenc:arrayType=\"crm:CRMCriteriaField[5]\">" +
		"			<name xsi:type=\"soapenc:string\">otherHistoryItemsMaxLimitimit</name>" +
		"			<value xsi:type=\"soapenc:string\">2</value>" +
		"		</criteriaField>" +
		"	    </criteriaFields>" +
		"            <criteriaType xsi:type=\"soapenc:string\">?</criteriaType>" +
		"         </in2>" +
		"      </crm:getCasesByCriteria>" +
		"   </soapenv:Body>" +
	"</soapenv:Envelope>";
}
