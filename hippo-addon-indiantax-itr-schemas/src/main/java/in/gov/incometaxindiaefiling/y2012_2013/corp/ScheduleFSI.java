
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
 *         &lt;element name="CountryName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="55"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CountryCode"/>
 *         &lt;element name="TaxIdentificationNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IncFromHPPartBTIA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IncBusinessPartBTIB">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IncCapGainPartBTIC">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IncOthSrcPartBTID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalCountryWise">
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
    "countryName",
    "countryCode",
    "taxIdentificationNo",
    "incFromHPPartBTIA",
    "incBusinessPartBTIB",
    "incCapGainPartBTIC",
    "incOthSrcPartBTID",
    "totalCountryWise"
})
@XmlRootElement(name = "ScheduleFSI")
public class ScheduleFSI {

    @XmlElement(name = "CountryName", required = true)
    protected String countryName;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "TaxIdentificationNo", required = true)
    protected String taxIdentificationNo;
    @XmlElement(name = "IncFromHPPartBTIA", required = true, defaultValue = "0")
    protected BigInteger incFromHPPartBTIA;
    @XmlElement(name = "IncBusinessPartBTIB", required = true, defaultValue = "0")
    protected BigInteger incBusinessPartBTIB;
    @XmlElement(name = "IncCapGainPartBTIC", required = true, defaultValue = "0")
    protected BigInteger incCapGainPartBTIC;
    @XmlElement(name = "IncOthSrcPartBTID", required = true, defaultValue = "0")
    protected BigInteger incOthSrcPartBTID;
    @XmlElement(name = "TotalCountryWise", required = true, defaultValue = "0")
    protected BigInteger totalCountryWise;

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the taxIdentificationNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxIdentificationNo() {
        return taxIdentificationNo;
    }

    /**
     * Sets the value of the taxIdentificationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxIdentificationNo(String value) {
        this.taxIdentificationNo = value;
    }

    /**
     * Gets the value of the incFromHPPartBTIA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncFromHPPartBTIA() {
        return incFromHPPartBTIA;
    }

    /**
     * Sets the value of the incFromHPPartBTIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncFromHPPartBTIA(BigInteger value) {
        this.incFromHPPartBTIA = value;
    }

    /**
     * Gets the value of the incBusinessPartBTIB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncBusinessPartBTIB() {
        return incBusinessPartBTIB;
    }

    /**
     * Sets the value of the incBusinessPartBTIB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncBusinessPartBTIB(BigInteger value) {
        this.incBusinessPartBTIB = value;
    }

    /**
     * Gets the value of the incCapGainPartBTIC property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncCapGainPartBTIC() {
        return incCapGainPartBTIC;
    }

    /**
     * Sets the value of the incCapGainPartBTIC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncCapGainPartBTIC(BigInteger value) {
        this.incCapGainPartBTIC = value;
    }

    /**
     * Gets the value of the incOthSrcPartBTID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncOthSrcPartBTID() {
        return incOthSrcPartBTID;
    }

    /**
     * Sets the value of the incOthSrcPartBTID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncOthSrcPartBTID(BigInteger value) {
        this.incOthSrcPartBTID = value;
    }

    /**
     * Gets the value of the totalCountryWise property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalCountryWise() {
        return totalCountryWise;
    }

    /**
     * Sets the value of the totalCountryWise property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalCountryWise(BigInteger value) {
        this.totalCountryWise = value;
    }

}
