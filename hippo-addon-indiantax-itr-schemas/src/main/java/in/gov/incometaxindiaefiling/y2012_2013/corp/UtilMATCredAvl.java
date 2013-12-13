
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
 *         &lt;element name="AssYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="7"/>
 *               &lt;pattern value="[0-9][0-9][0-9][0-9]-[0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MATCredGross">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MATCredSetOff">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MATCredBF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MATCredUtilCurrYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BalMATCredCF">
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
    "matCredGross",
    "matCredSetOff",
    "matCredBF",
    "matCredUtilCurrYr",
    "balMATCredCF"
})
@XmlRootElement(name = "UtilMATCredAvl")
public class UtilMATCredAvl {

    @XmlElement(name = "AssYr", required = true)
    protected String assYr;
    @XmlElement(name = "MATCredGross", required = true, defaultValue = "0")
    protected BigInteger matCredGross;
    @XmlElement(name = "MATCredSetOff", required = true, defaultValue = "0")
    protected BigInteger matCredSetOff;
    @XmlElement(name = "MATCredBF", required = true, defaultValue = "0")
    protected BigInteger matCredBF;
    @XmlElement(name = "MATCredUtilCurrYr", required = true, defaultValue = "0")
    protected BigInteger matCredUtilCurrYr;
    @XmlElement(name = "BalMATCredCF", required = true, defaultValue = "0")
    protected BigInteger balMATCredCF;

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
     * Gets the value of the matCredGross property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMATCredGross() {
        return matCredGross;
    }

    /**
     * Sets the value of the matCredGross property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMATCredGross(BigInteger value) {
        this.matCredGross = value;
    }

    /**
     * Gets the value of the matCredSetOff property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMATCredSetOff() {
        return matCredSetOff;
    }

    /**
     * Sets the value of the matCredSetOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMATCredSetOff(BigInteger value) {
        this.matCredSetOff = value;
    }

    /**
     * Gets the value of the matCredBF property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMATCredBF() {
        return matCredBF;
    }

    /**
     * Sets the value of the matCredBF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMATCredBF(BigInteger value) {
        this.matCredBF = value;
    }

    /**
     * Gets the value of the matCredUtilCurrYr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMATCredUtilCurrYr() {
        return matCredUtilCurrYr;
    }

    /**
     * Sets the value of the matCredUtilCurrYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMATCredUtilCurrYr(BigInteger value) {
        this.matCredUtilCurrYr = value;
    }

    /**
     * Gets the value of the balMATCredCF property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBalMATCredCF() {
        return balMATCredCF;
    }

    /**
     * Sets the value of the balMATCredCF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBalMATCredCF(BigInteger value) {
        this.balMATCredCF = value;
    }

}
