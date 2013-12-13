
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}TaxPayableOnDeemedTI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}TaxPayableOnTI"/>
 *         &lt;element name="SurchargeOnTaxPayable" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EducationCess">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GrossTaxLiability">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GrossTaxPayable" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CredUs115JAATaxPaid" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CreditUS115JD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPaidUnderCredit">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPayableAfterCredUs115JAA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}TaxRelief"/>
 *         &lt;element name="NetTaxLiability">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}IntrstPay"/>
 *         &lt;element name="AggregateTaxInterestLiability">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "taxPayableOnDeemedTI",
    "taxPayableOnTI",
    "surchargeOnTaxPayable",
    "educationCess",
    "grossTaxLiability",
    "grossTaxPayable",
    "credUs115JAATaxPaid",
    "creditUS115JD",
    "taxPaidUnderCredit",
    "taxPayableAfterCredUs115JAA",
    "taxRelief",
    "netTaxLiability",
    "intrstPay",
    "aggregateTaxInterestLiability"
})
@XmlRootElement(name = "ComputationOfTaxLiability")
public class ComputationOfTaxLiability {

    @XmlElement(name = "TaxPayableOnDeemedTI", required = true)
    protected TaxPayableOnDeemedTI taxPayableOnDeemedTI;
    @XmlElement(name = "TaxPayableOnTI", required = true)
    protected TaxPayableOnTI taxPayableOnTI;
    @XmlElement(name = "SurchargeOnTaxPayable")
    protected BigInteger surchargeOnTaxPayable;
    @XmlElement(name = "EducationCess", required = true, defaultValue = "0")
    protected BigInteger educationCess;
    @XmlElement(name = "GrossTaxLiability", required = true, defaultValue = "0")
    protected BigInteger grossTaxLiability;
    @XmlElement(name = "GrossTaxPayable", defaultValue = "0")
    protected BigInteger grossTaxPayable;
    @XmlElement(name = "CredUs115JAATaxPaid")
    protected BigInteger credUs115JAATaxPaid;
    @XmlElement(name = "CreditUS115JD", defaultValue = "0")
    protected BigInteger creditUS115JD;
    @XmlElement(name = "TaxPaidUnderCredit", required = true, defaultValue = "0")
    protected BigInteger taxPaidUnderCredit;
    @XmlElement(name = "TaxPayableAfterCredUs115JAA")
    protected BigInteger taxPayableAfterCredUs115JAA;
    @XmlElement(name = "TaxRelief", required = true)
    protected TaxRelief taxRelief;
    @XmlElement(name = "NetTaxLiability", required = true, defaultValue = "0")
    protected BigInteger netTaxLiability;
    @XmlElement(name = "IntrstPay", required = true)
    protected IntrstPay intrstPay;
    @XmlElement(name = "AggregateTaxInterestLiability", required = true, defaultValue = "0")
    protected BigInteger aggregateTaxInterestLiability;

    /**
     * Gets the value of the taxPayableOnDeemedTI property.
     * 
     * @return
     *     possible object is
     *     {@link TaxPayableOnDeemedTI }
     *     
     */
    public TaxPayableOnDeemedTI getTaxPayableOnDeemedTI() {
        return taxPayableOnDeemedTI;
    }

    /**
     * Sets the value of the taxPayableOnDeemedTI property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPayableOnDeemedTI }
     *     
     */
    public void setTaxPayableOnDeemedTI(TaxPayableOnDeemedTI value) {
        this.taxPayableOnDeemedTI = value;
    }

    /**
     * Gets the value of the taxPayableOnTI property.
     * 
     * @return
     *     possible object is
     *     {@link TaxPayableOnTI }
     *     
     */
    public TaxPayableOnTI getTaxPayableOnTI() {
        return taxPayableOnTI;
    }

    /**
     * Sets the value of the taxPayableOnTI property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPayableOnTI }
     *     
     */
    public void setTaxPayableOnTI(TaxPayableOnTI value) {
        this.taxPayableOnTI = value;
    }

    /**
     * Gets the value of the surchargeOnTaxPayable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSurchargeOnTaxPayable() {
        return surchargeOnTaxPayable;
    }

    /**
     * Sets the value of the surchargeOnTaxPayable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSurchargeOnTaxPayable(BigInteger value) {
        this.surchargeOnTaxPayable = value;
    }

    /**
     * Gets the value of the educationCess property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEducationCess() {
        return educationCess;
    }

    /**
     * Sets the value of the educationCess property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEducationCess(BigInteger value) {
        this.educationCess = value;
    }

    /**
     * Gets the value of the grossTaxLiability property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGrossTaxLiability() {
        return grossTaxLiability;
    }

    /**
     * Sets the value of the grossTaxLiability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGrossTaxLiability(BigInteger value) {
        this.grossTaxLiability = value;
    }

    /**
     * Gets the value of the grossTaxPayable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGrossTaxPayable() {
        return grossTaxPayable;
    }

    /**
     * Sets the value of the grossTaxPayable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGrossTaxPayable(BigInteger value) {
        this.grossTaxPayable = value;
    }

    /**
     * Gets the value of the credUs115JAATaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCredUs115JAATaxPaid() {
        return credUs115JAATaxPaid;
    }

    /**
     * Sets the value of the credUs115JAATaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCredUs115JAATaxPaid(BigInteger value) {
        this.credUs115JAATaxPaid = value;
    }

    /**
     * Gets the value of the creditUS115JD property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCreditUS115JD() {
        return creditUS115JD;
    }

    /**
     * Sets the value of the creditUS115JD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCreditUS115JD(BigInteger value) {
        this.creditUS115JD = value;
    }

    /**
     * Gets the value of the taxPaidUnderCredit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPaidUnderCredit() {
        return taxPaidUnderCredit;
    }

    /**
     * Sets the value of the taxPaidUnderCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPaidUnderCredit(BigInteger value) {
        this.taxPaidUnderCredit = value;
    }

    /**
     * Gets the value of the taxPayableAfterCredUs115JAA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPayableAfterCredUs115JAA() {
        return taxPayableAfterCredUs115JAA;
    }

    /**
     * Sets the value of the taxPayableAfterCredUs115JAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPayableAfterCredUs115JAA(BigInteger value) {
        this.taxPayableAfterCredUs115JAA = value;
    }

    /**
     * Gets the value of the taxRelief property.
     * 
     * @return
     *     possible object is
     *     {@link TaxRelief }
     *     
     */
    public TaxRelief getTaxRelief() {
        return taxRelief;
    }

    /**
     * Sets the value of the taxRelief property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRelief }
     *     
     */
    public void setTaxRelief(TaxRelief value) {
        this.taxRelief = value;
    }

    /**
     * Gets the value of the netTaxLiability property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNetTaxLiability() {
        return netTaxLiability;
    }

    /**
     * Sets the value of the netTaxLiability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNetTaxLiability(BigInteger value) {
        this.netTaxLiability = value;
    }

    /**
     * Gets the value of the intrstPay property.
     * 
     * @return
     *     possible object is
     *     {@link IntrstPay }
     *     
     */
    public IntrstPay getIntrstPay() {
        return intrstPay;
    }

    /**
     * Sets the value of the intrstPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntrstPay }
     *     
     */
    public void setIntrstPay(IntrstPay value) {
        this.intrstPay = value;
    }

    /**
     * Gets the value of the aggregateTaxInterestLiability property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAggregateTaxInterestLiability() {
        return aggregateTaxInterestLiability;
    }

    /**
     * Sets the value of the aggregateTaxInterestLiability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAggregateTaxInterestLiability(BigInteger value) {
        this.aggregateTaxInterestLiability = value;
    }

}
