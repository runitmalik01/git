
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
 *         &lt;element name="TaxDeemedTISec115JC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxDeemedTISec115JB" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Surcharge" minOccurs="0">
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
 *         &lt;element name="TotalTaxSec115JB" minOccurs="0">
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
    "taxDeemedTISec115JB",
    "surcharge",
    "educationCess",
    "totalTax",
    "totalTaxSec115JB"
})
@XmlRootElement(name = "TaxPayableOnDeemedTI")
public class TaxPayableOnDeemedTI {

    @XmlElement(name = "TaxDeemedTISec115JC", defaultValue = "0")
    protected BigInteger taxDeemedTISec115JC;
    @XmlElement(name = "TaxDeemedTISec115JB")
    protected BigInteger taxDeemedTISec115JB;
    @XmlElement(name = "Surcharge")
    protected BigInteger surcharge;
    @XmlElement(name = "EducationCess", required = true, defaultValue = "0")
    protected BigInteger educationCess;
    @XmlElement(name = "TotalTax", required = true, defaultValue = "0")
    protected BigInteger totalTax;
    @XmlElement(name = "TotalTaxSec115JB")
    protected BigInteger totalTaxSec115JB;

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
     * Gets the value of the taxDeemedTISec115JB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxDeemedTISec115JB() {
        return taxDeemedTISec115JB;
    }

    /**
     * Sets the value of the taxDeemedTISec115JB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxDeemedTISec115JB(BigInteger value) {
        this.taxDeemedTISec115JB = value;
    }

    /**
     * Gets the value of the surcharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSurcharge() {
        return surcharge;
    }

    /**
     * Sets the value of the surcharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSurcharge(BigInteger value) {
        this.surcharge = value;
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

    /**
     * Gets the value of the totalTaxSec115JB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalTaxSec115JB() {
        return totalTaxSec115JB;
    }

    /**
     * Sets the value of the totalTaxSec115JB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalTaxSec115JB(BigInteger value) {
        this.totalTaxSec115JB = value;
    }

}
