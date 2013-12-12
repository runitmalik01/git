
package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element name="TaxPayableOnDeemedTI">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TaxDeemedTISec115JC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="EducationCess">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotalTax">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxPayableOnTI"/>
 *         &lt;element name="RebateUs88E" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BalTaxPayable">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SurchargeOnTaxPayable" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GrossTaxPayable">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CreditUS115JD">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPayAfterCreditUs115JD">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxRelief" minOccurs="0"/>
 *         &lt;element name="NetTaxLiability">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}IntrstPay"/>
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
    "rebateUs88E",
    "balTaxPayable",
    "surchargeOnTaxPayable",
    "educationCess",
    "grossTaxLiability",
    "grossTaxPayable",
    "creditUS115JD",
    "taxPayAfterCreditUs115JD",
    "taxRelief",
    "netTaxLiability",
    "intrstPay",
    "aggregateTaxInterestLiability"
})
@XmlRootElement(name = "ComputationOfTaxLiability")
public class ComputationOfTaxLiability {

    @XmlElement(name = "TaxPayableOnDeemedTI", required = true)
    protected ComputationOfTaxLiability.TaxPayableOnDeemedTI taxPayableOnDeemedTI;
    @XmlElement(name = "TaxPayableOnTI", required = true)
    protected TaxPayableOnTI taxPayableOnTI;
    @XmlElement(name = "RebateUs88E", defaultValue = "0")
    protected BigInteger rebateUs88E;
    @XmlElement(name = "BalTaxPayable", required = true, defaultValue = "0")
    protected BigInteger balTaxPayable;
    @XmlElement(name = "SurchargeOnTaxPayable", required = true)
    protected Object surchargeOnTaxPayable;
    @XmlElement(name = "EducationCess", required = true, defaultValue = "0")
    protected BigInteger educationCess;
    @XmlElement(name = "GrossTaxLiability", required = true, defaultValue = "0")
    protected BigInteger grossTaxLiability;
    @XmlElement(name = "GrossTaxPayable", required = true)
    protected BigInteger grossTaxPayable;
    @XmlElement(name = "CreditUS115JD", required = true, defaultValue = "0")
    protected BigInteger creditUS115JD;
    @XmlElement(name = "TaxPayAfterCreditUs115JD", required = true)
    protected BigInteger taxPayAfterCreditUs115JD;
    @XmlElement(name = "TaxRelief")
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
     *     {@link ComputationOfTaxLiability.TaxPayableOnDeemedTI }
     *     
     */
    public ComputationOfTaxLiability.TaxPayableOnDeemedTI getTaxPayableOnDeemedTI() {
        return taxPayableOnDeemedTI;
    }

    /**
     * Sets the value of the taxPayableOnDeemedTI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComputationOfTaxLiability.TaxPayableOnDeemedTI }
     *     
     */
    public void setTaxPayableOnDeemedTI(ComputationOfTaxLiability.TaxPayableOnDeemedTI value) {
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
     * Gets the value of the rebateUs88E property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRebateUs88E() {
        return rebateUs88E;
    }

    /**
     * Sets the value of the rebateUs88E property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRebateUs88E(BigInteger value) {
        this.rebateUs88E = value;
    }

    /**
     * Gets the value of the balTaxPayable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBalTaxPayable() {
        return balTaxPayable;
    }

    /**
     * Sets the value of the balTaxPayable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBalTaxPayable(BigInteger value) {
        this.balTaxPayable = value;
    }

    /**
     * Gets the value of the surchargeOnTaxPayable property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSurchargeOnTaxPayable() {
        return surchargeOnTaxPayable;
    }

    /**
     * Sets the value of the surchargeOnTaxPayable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSurchargeOnTaxPayable(Object value) {
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
     * Gets the value of the taxPayAfterCreditUs115JD property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPayAfterCreditUs115JD() {
        return taxPayAfterCreditUs115JD;
    }

    /**
     * Sets the value of the taxPayAfterCreditUs115JD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPayAfterCreditUs115JD(BigInteger value) {
        this.taxPayAfterCreditUs115JD = value;
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
     * 
     * 						
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
     *         &lt;element name="TaxDeemedTISec115JC">
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
     *         &lt;element name="TotalTax">
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
        "taxDeemedTISec115JC",
        "educationCess",
        "totalTax"
    })
    public static class TaxPayableOnDeemedTI {

        @XmlElement(name = "TaxDeemedTISec115JC", required = true, defaultValue = "0")
        protected BigInteger taxDeemedTISec115JC;
        @XmlElement(name = "EducationCess", required = true, defaultValue = "0")
        protected BigInteger educationCess;
        @XmlElement(name = "TotalTax", required = true, defaultValue = "0")
        protected BigInteger totalTax;

        /**
         * Gets the value of the taxDeemedTISec115JC property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTaxDeemedTISec115JC() {
            return taxDeemedTISec115JC;
        }

        /**
         * Sets the value of the taxDeemedTISec115JC property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTaxDeemedTISec115JC(BigInteger value) {
            this.taxDeemedTISec115JC = value;
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
         * Gets the value of the totalTax property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotalTax() {
            return totalTax;
        }

        /**
         * Sets the value of the totalTax property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotalTax(BigInteger value) {
            this.totalTax = value;
        }

    }

}
