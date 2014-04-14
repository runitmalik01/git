
package in.gov.incometaxindiaefiling.y2013_2014.itr4s;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}CreationInfo"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Form_ITR4S"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PersonalInfo"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}FilingStatus"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITR4S_IncomeDeductions"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITR4S_TaxComputation"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxPaid"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Refund"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80G" minOccurs="0"/>
 *         &lt;element name="TaxExmpIntInc" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="4"/>
 *               &lt;maxInclusive value="5000"/>
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Verification"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxReturnPreparer" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}NatOfBus" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleBPForITR4S"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleIT" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTCS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TDSonSalaries" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TDSonOthThanSals" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "creationInfo",
    "formITR4S",
    "personalInfo",
    "filingStatus",
    "itr4SIncomeDeductions",
    "itr4STaxComputation",
    "taxPaid",
    "refund",
    "schedule80G",
    "taxExmpIntInc",
    "verification",
    "taxReturnPreparer",
    "natOfBus",
    "scheduleBPForITR4S",
    "scheduleIT",
    "scheduleTCS",
    "tdSonSalaries",
    "tdSonOthThanSals"
})
@XmlRootElement(name = "ITR4S", namespace = "http://incometaxindiaefiling.gov.in/ITR4S")
public class ITR4S {

    @XmlElement(name = "CreationInfo", required = true)
    protected CreationInfo creationInfo;
    @XmlElement(name = "Form_ITR4S", required = true)
    protected FormITR4S formITR4S;
    @XmlElement(name = "PersonalInfo", required = true)
    protected PersonalInfo personalInfo;
    @XmlElement(name = "FilingStatus", required = true)
    protected FilingStatus filingStatus;
    @XmlElement(name = "ITR4S_IncomeDeductions", required = true)
    protected ITR4SIncomeDeductions itr4SIncomeDeductions;
    @XmlElement(name = "ITR4S_TaxComputation", required = true)
    protected ITR4STaxComputation itr4STaxComputation;
    @XmlElement(name = "TaxPaid", required = true)
    protected TaxPaid taxPaid;
    @XmlElement(name = "Refund", required = true)
    protected Refund refund;
    @XmlElement(name = "Schedule80G")
    protected Schedule80G schedule80G;
    @XmlElement(name = "TaxExmpIntInc", namespace = "http://incometaxindiaefiling.gov.in/ITR4S", defaultValue = "0")
    protected Integer taxExmpIntInc;
    @XmlElement(name = "Verification", required = true)
    protected Verification verification;
    @XmlElement(name = "TaxReturnPreparer")
    protected TaxReturnPreparer taxReturnPreparer;
    @XmlElement(name = "NatOfBus")
    protected NatOfBus natOfBus;
    @XmlElement(name = "ScheduleBPForITR4S", required = true)
    protected ScheduleBPForITR4S scheduleBPForITR4S;
    @XmlElement(name = "ScheduleIT")
    protected ScheduleIT scheduleIT;
    @XmlElement(name = "ScheduleTCS")
    protected ScheduleTCS scheduleTCS;
    @XmlElement(name = "TDSonSalaries")
    protected TDSonSalaries tdSonSalaries;
    @XmlElement(name = "TDSonOthThanSals")
    protected TDSonOthThanSals tdSonOthThanSals;

    /**
     * Gets the value of the creationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CreationInfo }
     *     
     */
    public CreationInfo getCreationInfo() {
        return creationInfo;
    }

    /**
     * Sets the value of the creationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationInfo }
     *     
     */
    public void setCreationInfo(CreationInfo value) {
        this.creationInfo = value;
    }

    /**
     * Gets the value of the formITR4S property.
     * 
     * @return
     *     possible object is
     *     {@link FormITR4S }
     *     
     */
    public FormITR4S getFormITR4S() {
        return formITR4S;
    }

    /**
     * Sets the value of the formITR4S property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormITR4S }
     *     
     */
    public void setFormITR4S(FormITR4S value) {
        this.formITR4S = value;
    }

    /**
     * Gets the value of the personalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PersonalInfo }
     *     
     */
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    /**
     * Sets the value of the personalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonalInfo }
     *     
     */
    public void setPersonalInfo(PersonalInfo value) {
        this.personalInfo = value;
    }

    /**
     * Gets the value of the filingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatus }
     *     
     */
    public FilingStatus getFilingStatus() {
        return filingStatus;
    }

    /**
     * Sets the value of the filingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatus }
     *     
     */
    public void setFilingStatus(FilingStatus value) {
        this.filingStatus = value;
    }

    /**
     * Gets the value of the itr4SIncomeDeductions property.
     * 
     * @return
     *     possible object is
     *     {@link ITR4SIncomeDeductions }
     *     
     */
    public ITR4SIncomeDeductions getITR4SIncomeDeductions() {
        return itr4SIncomeDeductions;
    }

    /**
     * Sets the value of the itr4SIncomeDeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITR4SIncomeDeductions }
     *     
     */
    public void setITR4SIncomeDeductions(ITR4SIncomeDeductions value) {
        this.itr4SIncomeDeductions = value;
    }

    /**
     * Gets the value of the itr4STaxComputation property.
     * 
     * @return
     *     possible object is
     *     {@link ITR4STaxComputation }
     *     
     */
    public ITR4STaxComputation getITR4STaxComputation() {
        return itr4STaxComputation;
    }

    /**
     * Sets the value of the itr4STaxComputation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITR4STaxComputation }
     *     
     */
    public void setITR4STaxComputation(ITR4STaxComputation value) {
        this.itr4STaxComputation = value;
    }

    /**
     * Gets the value of the taxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link TaxPaid }
     *     
     */
    public TaxPaid getTaxPaid() {
        return taxPaid;
    }

    /**
     * Sets the value of the taxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPaid }
     *     
     */
    public void setTaxPaid(TaxPaid value) {
        this.taxPaid = value;
    }

    /**
     * Gets the value of the refund property.
     * 
     * @return
     *     possible object is
     *     {@link Refund }
     *     
     */
    public Refund getRefund() {
        return refund;
    }

    /**
     * Sets the value of the refund property.
     * 
     * @param value
     *     allowed object is
     *     {@link Refund }
     *     
     */
    public void setRefund(Refund value) {
        this.refund = value;
    }

    /**
     * Gets the value of the schedule80G property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule80G }
     *     
     */
    public Schedule80G getSchedule80G() {
        return schedule80G;
    }

    /**
     * Sets the value of the schedule80G property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule80G }
     *     
     */
    public void setSchedule80G(Schedule80G value) {
        this.schedule80G = value;
    }

    /**
     * Gets the value of the taxExmpIntInc property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTaxExmpIntInc() {
        return taxExmpIntInc;
    }

    /**
     * Sets the value of the taxExmpIntInc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTaxExmpIntInc(Integer value) {
        this.taxExmpIntInc = value;
    }

    /**
     * Gets the value of the verification property.
     * 
     * @return
     *     possible object is
     *     {@link Verification }
     *     
     */
    public Verification getVerification() {
        return verification;
    }

    /**
     * Sets the value of the verification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Verification }
     *     
     */
    public void setVerification(Verification value) {
        this.verification = value;
    }

    /**
     * Gets the value of the taxReturnPreparer property.
     * 
     * @return
     *     possible object is
     *     {@link TaxReturnPreparer }
     *     
     */
    public TaxReturnPreparer getTaxReturnPreparer() {
        return taxReturnPreparer;
    }

    /**
     * Sets the value of the taxReturnPreparer property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxReturnPreparer }
     *     
     */
    public void setTaxReturnPreparer(TaxReturnPreparer value) {
        this.taxReturnPreparer = value;
    }

    /**
     * Gets the value of the natOfBus property.
     * 
     * @return
     *     possible object is
     *     {@link NatOfBus }
     *     
     */
    public NatOfBus getNatOfBus() {
        return natOfBus;
    }

    /**
     * Sets the value of the natOfBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatOfBus }
     *     
     */
    public void setNatOfBus(NatOfBus value) {
        this.natOfBus = value;
    }

    /**
     * Gets the value of the scheduleBPForITR4S property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleBPForITR4S }
     *     
     */
    public ScheduleBPForITR4S getScheduleBPForITR4S() {
        return scheduleBPForITR4S;
    }

    /**
     * Sets the value of the scheduleBPForITR4S property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleBPForITR4S }
     *     
     */
    public void setScheduleBPForITR4S(ScheduleBPForITR4S value) {
        this.scheduleBPForITR4S = value;
    }

    /**
     * Gets the value of the scheduleIT property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleIT }
     *     
     */
    public ScheduleIT getScheduleIT() {
        return scheduleIT;
    }

    /**
     * Sets the value of the scheduleIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleIT }
     *     
     */
    public void setScheduleIT(ScheduleIT value) {
        this.scheduleIT = value;
    }

    /**
     * Gets the value of the scheduleTCS property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleTCS }
     *     
     */
    public ScheduleTCS getScheduleTCS() {
        return scheduleTCS;
    }

    /**
     * Sets the value of the scheduleTCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleTCS }
     *     
     */
    public void setScheduleTCS(ScheduleTCS value) {
        this.scheduleTCS = value;
    }

    /**
     * Gets the value of the tdSonSalaries property.
     * 
     * @return
     *     possible object is
     *     {@link TDSonSalaries }
     *     
     */
    public TDSonSalaries getTDSonSalaries() {
        return tdSonSalaries;
    }

    /**
     * Sets the value of the tdSonSalaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDSonSalaries }
     *     
     */
    public void setTDSonSalaries(TDSonSalaries value) {
        this.tdSonSalaries = value;
    }

    /**
     * Gets the value of the tdSonOthThanSals property.
     * 
     * @return
     *     possible object is
     *     {@link TDSonOthThanSals }
     *     
     */
    public TDSonOthThanSals getTDSonOthThanSals() {
        return tdSonOthThanSals;
    }

    /**
     * Sets the value of the tdSonOthThanSals property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDSonOthThanSals }
     *     
     */
    public void setTDSonOthThanSals(TDSonOthThanSals value) {
        this.tdSonOthThanSals = value;
    }

}
