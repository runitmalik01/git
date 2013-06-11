//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 12:34:17 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.master;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="TaxSection115JC">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxOthProvisions">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtTaxCreditAvailable">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleAMTC" maxOccurs="unbounded"/>
 *         &lt;element name="TotAMTGross">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotSetOffEys">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotBalBF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxSection115JD">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtLiabilityAvailable">
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
    "taxSection115JC",
    "taxOthProvisions",
    "amtTaxCreditAvailable",
    "scheduleAMTC",
    "totAMTGross",
    "totSetOffEys",
    "totBalBF",
    "taxSection115JD",
    "amtLiabilityAvailable"
})
@XmlRootElement(name = "ITRScheduleAMTC")
public class ITRScheduleAMTC {

    @XmlElement(name = "TaxSection115JC", required = true, defaultValue = "0")
    protected BigInteger taxSection115JC;
    @XmlElement(name = "TaxOthProvisions", required = true, defaultValue = "0")
    protected BigInteger taxOthProvisions;
    @XmlElement(name = "AmtTaxCreditAvailable", required = true, defaultValue = "0")
    protected BigInteger amtTaxCreditAvailable;
    @XmlElement(name = "ScheduleAMTC", required = true)
    protected List<ScheduleAMTC> scheduleAMTC;
    @XmlElement(name = "TotAMTGross", required = true, defaultValue = "0")
    protected BigInteger totAMTGross;
    @XmlElement(name = "TotSetOffEys", required = true, defaultValue = "0")
    protected BigInteger totSetOffEys;
    @XmlElement(name = "TotBalBF", required = true, defaultValue = "0")
    protected BigInteger totBalBF;
    @XmlElement(name = "TaxSection115JD", required = true, defaultValue = "0")
    protected BigInteger taxSection115JD;
    @XmlElement(name = "AmtLiabilityAvailable", required = true, defaultValue = "0")
    protected BigInteger amtLiabilityAvailable;

    /**
     * Gets the value of the taxSection115JC property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxSection115JC() {
        return taxSection115JC;
    }

    /**
     * Sets the value of the taxSection115JC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxSection115JC(BigInteger value) {
        this.taxSection115JC = value;
    }

    /**
     * Gets the value of the taxOthProvisions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxOthProvisions() {
        return taxOthProvisions;
    }

    /**
     * Sets the value of the taxOthProvisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxOthProvisions(BigInteger value) {
        this.taxOthProvisions = value;
    }

    /**
     * Gets the value of the amtTaxCreditAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtTaxCreditAvailable() {
        return amtTaxCreditAvailable;
    }

    /**
     * Sets the value of the amtTaxCreditAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtTaxCreditAvailable(BigInteger value) {
        this.amtTaxCreditAvailable = value;
    }

    /**
     * Gets the value of the scheduleAMTC property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scheduleAMTC property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScheduleAMTC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduleAMTC }
     * 
     * 
     */
    public List<ScheduleAMTC> getScheduleAMTC() {
        if (scheduleAMTC == null) {
            scheduleAMTC = new ArrayList<ScheduleAMTC>();
        }
        return this.scheduleAMTC;
    }

    /**
     * Gets the value of the totAMTGross property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotAMTGross() {
        return totAMTGross;
    }

    /**
     * Sets the value of the totAMTGross property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotAMTGross(BigInteger value) {
        this.totAMTGross = value;
    }

    /**
     * Gets the value of the totSetOffEys property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotSetOffEys() {
        return totSetOffEys;
    }

    /**
     * Sets the value of the totSetOffEys property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotSetOffEys(BigInteger value) {
        this.totSetOffEys = value;
    }

    /**
     * Gets the value of the totBalBF property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotBalBF() {
        return totBalBF;
    }

    /**
     * Sets the value of the totBalBF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotBalBF(BigInteger value) {
        this.totBalBF = value;
    }

    /**
     * Gets the value of the taxSection115JD property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxSection115JD() {
        return taxSection115JD;
    }

    /**
     * Sets the value of the taxSection115JD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxSection115JD(BigInteger value) {
        this.taxSection115JD = value;
    }

    /**
     * Gets the value of the amtLiabilityAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtLiabilityAvailable() {
        return amtLiabilityAvailable;
    }

    /**
     * Sets the value of the amtLiabilityAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtLiabilityAvailable(BigInteger value) {
        this.amtLiabilityAvailable = value;
    }

}
