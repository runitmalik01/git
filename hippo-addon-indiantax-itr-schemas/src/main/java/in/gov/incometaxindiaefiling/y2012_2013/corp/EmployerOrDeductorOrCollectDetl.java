//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.26 at 10:23:30 PM PDT 
//


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
 *         &lt;element name="TAN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z]\d\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EmployerOrDeductorOrCollecterName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TDSCertificateNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="8"/>
 *               &lt;pattern value="[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TDSFinYr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="4"/>
 *               &lt;pattern value="\d\d\d\d"/>
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
    "tan",
    "employerOrDeductorOrCollecterName",
    "tdsCertificateNumber",
    "tdsFinYr"
})
@XmlRootElement(name = "EmployerOrDeductorOrCollectDetl")
public class EmployerOrDeductorOrCollectDetl {

    @XmlElement(name = "TAN", required = true)
    protected String tan;
    @XmlElement(name = "EmployerOrDeductorOrCollecterName", required = true)
    protected String employerOrDeductorOrCollecterName;
    @XmlElement(name = "TDSCertificateNumber")
    protected String tdsCertificateNumber;
    @XmlElement(name = "TDSFinYr")
    protected BigInteger tdsFinYr;

    /**
     * Gets the value of the tan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAN() {
        return tan;
    }

    /**
     * Sets the value of the tan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAN(String value) {
        this.tan = value;
    }

    /**
     * Gets the value of the employerOrDeductorOrCollecterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployerOrDeductorOrCollecterName() {
        return employerOrDeductorOrCollecterName;
    }

    /**
     * Sets the value of the employerOrDeductorOrCollecterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployerOrDeductorOrCollecterName(String value) {
        this.employerOrDeductorOrCollecterName = value;
    }

    /**
     * Gets the value of the tdsCertificateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTDSCertificateNumber() {
        return tdsCertificateNumber;
    }

    /**
     * Sets the value of the tdsCertificateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTDSCertificateNumber(String value) {
        this.tdsCertificateNumber = value;
    }

    /**
     * Gets the value of the tdsFinYr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTDSFinYr() {
        return tdsFinYr;
    }

    /**
     * Sets the value of the tdsFinYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTDSFinYr(BigInteger value) {
        this.tdsFinYr = value;
    }

}
