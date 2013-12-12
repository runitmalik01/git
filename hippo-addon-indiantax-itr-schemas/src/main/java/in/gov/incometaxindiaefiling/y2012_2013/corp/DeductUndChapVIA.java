
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
 *         &lt;element name="Section80G" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80GGA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80GGB" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80GGC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80IA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80IAB" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80IB" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80IC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80JJA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80JJAA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80LA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80P" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Section80ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalChapVIADeductions">
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
    "section80G",
    "section80GGA",
    "section80GGB",
    "section80GGC",
    "section80IA",
    "section80IAB",
    "section80IB",
    "section80IC",
    "section80JJA",
    "section80JJAA",
    "section80LA",
    "section80P",
    "section80ID",
    "totalChapVIADeductions"
})
@XmlRootElement(name = "DeductUndChapVIA")
public class DeductUndChapVIA {

    @XmlElement(name = "Section80G", defaultValue = "0")
    protected BigInteger section80G;
    @XmlElement(name = "Section80GGA", defaultValue = "0")
    protected BigInteger section80GGA;
    @XmlElement(name = "Section80GGB", defaultValue = "0")
    protected BigInteger section80GGB;
    @XmlElement(name = "Section80GGC", defaultValue = "0")
    protected BigInteger section80GGC;
    @XmlElement(name = "Section80IA", defaultValue = "0")
    protected BigInteger section80IA;
    @XmlElement(name = "Section80IAB", defaultValue = "0")
    protected BigInteger section80IAB;
    @XmlElement(name = "Section80IB", defaultValue = "0")
    protected BigInteger section80IB;
    @XmlElement(name = "Section80IC", defaultValue = "0")
    protected BigInteger section80IC;
    @XmlElement(name = "Section80JJA", defaultValue = "0")
    protected BigInteger section80JJA;
    @XmlElement(name = "Section80JJAA", defaultValue = "0")
    protected BigInteger section80JJAA;
    @XmlElement(name = "Section80LA", defaultValue = "0")
    protected BigInteger section80LA;
    @XmlElement(name = "Section80P", defaultValue = "0")
    protected BigInteger section80P;
    @XmlElement(name = "Section80ID", defaultValue = "0")
    protected BigInteger section80ID;
    @XmlElement(name = "TotalChapVIADeductions", required = true, defaultValue = "0")
    protected BigInteger totalChapVIADeductions;

    /**
     * Gets the value of the section80G property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80G() {
        return section80G;
    }

    /**
     * Sets the value of the section80G property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80G(BigInteger value) {
        this.section80G = value;
    }

    /**
     * Gets the value of the section80GGA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80GGA() {
        return section80GGA;
    }

    /**
     * Sets the value of the section80GGA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80GGA(BigInteger value) {
        this.section80GGA = value;
    }

    /**
     * Gets the value of the section80GGB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80GGB() {
        return section80GGB;
    }

    /**
     * Sets the value of the section80GGB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80GGB(BigInteger value) {
        this.section80GGB = value;
    }

    /**
     * Gets the value of the section80GGC property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80GGC() {
        return section80GGC;
    }

    /**
     * Sets the value of the section80GGC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80GGC(BigInteger value) {
        this.section80GGC = value;
    }

    /**
     * Gets the value of the section80IA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80IA() {
        return section80IA;
    }

    /**
     * Sets the value of the section80IA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80IA(BigInteger value) {
        this.section80IA = value;
    }

    /**
     * Gets the value of the section80IAB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80IAB() {
        return section80IAB;
    }

    /**
     * Sets the value of the section80IAB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80IAB(BigInteger value) {
        this.section80IAB = value;
    }

    /**
     * Gets the value of the section80IB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80IB() {
        return section80IB;
    }

    /**
     * Sets the value of the section80IB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80IB(BigInteger value) {
        this.section80IB = value;
    }

    /**
     * Gets the value of the section80IC property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80IC() {
        return section80IC;
    }

    /**
     * Sets the value of the section80IC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80IC(BigInteger value) {
        this.section80IC = value;
    }

    /**
     * Gets the value of the section80JJA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80JJA() {
        return section80JJA;
    }

    /**
     * Sets the value of the section80JJA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80JJA(BigInteger value) {
        this.section80JJA = value;
    }

    /**
     * Gets the value of the section80JJAA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80JJAA() {
        return section80JJAA;
    }

    /**
     * Sets the value of the section80JJAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80JJAA(BigInteger value) {
        this.section80JJAA = value;
    }

    /**
     * Gets the value of the section80LA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80LA() {
        return section80LA;
    }

    /**
     * Sets the value of the section80LA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80LA(BigInteger value) {
        this.section80LA = value;
    }

    /**
     * Gets the value of the section80P property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80P() {
        return section80P;
    }

    /**
     * Sets the value of the section80P property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80P(BigInteger value) {
        this.section80P = value;
    }

    /**
     * Gets the value of the section80ID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSection80ID() {
        return section80ID;
    }

    /**
     * Sets the value of the section80ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSection80ID(BigInteger value) {
        this.section80ID = value;
    }

    /**
     * Gets the value of the totalChapVIADeductions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalChapVIADeductions() {
        return totalChapVIADeductions;
    }

    /**
     * Sets the value of the totalChapVIADeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalChapVIADeductions(BigInteger value) {
        this.totalChapVIADeductions = value;
    }

}
