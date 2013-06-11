//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 12:34:28 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.itr2;

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
 *         &lt;element name="AssYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="7"/>
 *               &lt;pattern value="[0-9][0-9][0-9][0-9]-[0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtCreditFwd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtCreditSetOfEy" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtCreditBalBroughtFwd" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtCreditUtilized">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BalAmtCreditCarryFwd">
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
    "assYr",
    "amtCreditFwd",
    "amtCreditSetOfEy",
    "amtCreditBalBroughtFwd",
    "amtCreditUtilized",
    "balAmtCreditCarryFwd"
})
@XmlRootElement(name = "ScheduleAMTC")
public class ScheduleAMTC {

    @XmlElement(name = "AssYr", required = true)
    protected String assYr;
    @XmlElement(name = "AmtCreditFwd", required = true, defaultValue = "0")
    protected BigInteger amtCreditFwd;
    @XmlElement(name = "AmtCreditSetOfEy", defaultValue = "0")
    protected BigInteger amtCreditSetOfEy;
    @XmlElement(name = "AmtCreditBalBroughtFwd", defaultValue = "0")
    protected BigInteger amtCreditBalBroughtFwd;
    @XmlElement(name = "AmtCreditUtilized", required = true, defaultValue = "0")
    protected BigInteger amtCreditUtilized;
    @XmlElement(name = "BalAmtCreditCarryFwd", required = true, defaultValue = "0")
    protected BigInteger balAmtCreditCarryFwd;

    /**
     * Gets the value of the assYr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssYr() {
        return assYr;
    }

    /**
     * Sets the value of the assYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssYr(String value) {
        this.assYr = value;
    }

    /**
     * Gets the value of the amtCreditFwd property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtCreditFwd() {
        return amtCreditFwd;
    }

    /**
     * Sets the value of the amtCreditFwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtCreditFwd(BigInteger value) {
        this.amtCreditFwd = value;
    }

    /**
     * Gets the value of the amtCreditSetOfEy property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtCreditSetOfEy() {
        return amtCreditSetOfEy;
    }

    /**
     * Sets the value of the amtCreditSetOfEy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtCreditSetOfEy(BigInteger value) {
        this.amtCreditSetOfEy = value;
    }

    /**
     * Gets the value of the amtCreditBalBroughtFwd property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtCreditBalBroughtFwd() {
        return amtCreditBalBroughtFwd;
    }

    /**
     * Sets the value of the amtCreditBalBroughtFwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtCreditBalBroughtFwd(BigInteger value) {
        this.amtCreditBalBroughtFwd = value;
    }

    /**
     * Gets the value of the amtCreditUtilized property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtCreditUtilized() {
        return amtCreditUtilized;
    }

    /**
     * Sets the value of the amtCreditUtilized property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtCreditUtilized(BigInteger value) {
        this.amtCreditUtilized = value;
    }

    /**
     * Gets the value of the balAmtCreditCarryFwd property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBalAmtCreditCarryFwd() {
        return balAmtCreditCarryFwd;
    }

    /**
     * Sets the value of the balAmtCreditCarryFwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBalAmtCreditCarryFwd(BigInteger value) {
        this.balAmtCreditCarryFwd = value;
    }

}
