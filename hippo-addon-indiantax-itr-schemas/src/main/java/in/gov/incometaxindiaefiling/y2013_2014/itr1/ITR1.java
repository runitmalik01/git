
package in.gov.incometaxindiaefiling.y2013_2014.itr1;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Form_ITR1"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PersonalInfo"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}FilingStatus"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITR1_IncomeDeductions"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITR1_TaxComputation"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxPaid"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Refund"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80G" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TDSonSalaries" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TDSonOthThanSals" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxPayments" minOccurs="0"/>
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
    "formITR1",
    "personalInfo",
    "filingStatus",
    "itr1IncomeDeductions",
    "itr1TaxComputation",
    "taxPaid",
    "refund",
    "schedule80G",
    "tdSonSalaries",
    "tdSonOthThanSals",
    "taxPayments",
    "taxExmpIntInc",
    "verification",
    "taxReturnPreparer"
})
@XmlRootElement(name = "ITR1", namespace = "http://incometaxindiaefiling.gov.in/ITR1")
public class ITR1 {

    @XmlElement(name = "CreationInfo", required = true)
    protected CreationInfo creationInfo;
    @XmlElement(name = "Form_ITR1", required = true)
    protected FormITR1 formITR1;
    @XmlElement(name = "PersonalInfo", required = true)
    protected PersonalInfo personalInfo;
    @XmlElement(name = "FilingStatus", required = true)
    protected FilingStatus filingStatus;
    @XmlElement(name = "ITR1_IncomeDeductions", required = true)
    protected ITR1IncomeDeductions itr1IncomeDeductions;
    @XmlElement(name = "ITR1_TaxComputation", required = true)
    protected ITR1TaxComputation itr1TaxComputation;
    @XmlElement(name = "TaxPaid", required = true)
    protected TaxPaid taxPaid;
    @XmlElement(name = "Refund", required = true)
    protected Refund refund;
    @XmlElement(name = "Schedule80G")
    protected Schedule80G schedule80G;
    @XmlElement(name = "TDSonSalaries")
    protected TDSonSalaries tdSonSalaries;
    @XmlElement(name = "TDSonOthThanSals")
    protected TDSonOthThanSals tdSonOthThanSals;
    @XmlElement(name = "TaxPayments")
    protected TaxPayments taxPayments;
    @XmlElement(name = "TaxExmpIntInc", namespace = "http://incometaxindiaefiling.gov.in/ITR1", defaultValue = "0")
    protected Integer taxExmpIntInc;
    @XmlElement(name = "Verification", required = true)
    protected Verification verification;
    @XmlElement(name = "TaxReturnPreparer")
    protected TaxReturnPreparer taxReturnPreparer;

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
     * Gets the value of the formITR1 property.
     * 
     * @return
     *     possible object is
     *     {@link FormITR1 }
     *     
     */
    public FormITR1 getFormITR1() {
        return formITR1;
    }

    /**
     * Sets the value of the formITR1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormITR1 }
     *     
     */
    public void setFormITR1(FormITR1 value) {
        this.formITR1 = value;
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
     * Gets the value of the itr1IncomeDeductions property.
     * 
     * @return
     *     possible object is
     *     {@link ITR1IncomeDeductions }
     *     
     */
    public ITR1IncomeDeductions getITR1IncomeDeductions() {
        return itr1IncomeDeductions;
    }

    /**
     * Sets the value of the itr1IncomeDeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITR1IncomeDeductions }
     *     
     */
    public void setITR1IncomeDeductions(ITR1IncomeDeductions value) {
        this.itr1IncomeDeductions = value;
    }

    /**
     * Gets the value of the itr1TaxComputation property.
     * 
     * @return
     *     possible object is
     *     {@link ITR1TaxComputation }
     *     
     */
    public ITR1TaxComputation getITR1TaxComputation() {
        return itr1TaxComputation;
    }

    /**
     * Sets the value of the itr1TaxComputation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITR1TaxComputation }
     *     
     */
    public void setITR1TaxComputation(ITR1TaxComputation value) {
        this.itr1TaxComputation = value;
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

    /**
     * Gets the value of the taxPayments property.
     * 
     * @return
     *     possible object is
     *     {@link TaxPayments }
     *     
     */
    public TaxPayments getTaxPayments() {
        return taxPayments;
    }

    /**
     * Sets the value of the taxPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPayments }
     *     
     */
    public void setTaxPayments(TaxPayments value) {
        this.taxPayments = value;
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

}
