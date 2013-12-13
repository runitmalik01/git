
package in.gov.incometaxindiaefiling.y2012_2013.corp;

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
 *         &lt;element name="TaxUs115JBCurrAssYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxOthProvCurrAssYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtOfTaxWithCred">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}UtilMATCredAvl" maxOccurs="8" minOccurs="0"/>
 *         &lt;element name="TotMatCredGross">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotMatCredSetOff">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotMatCredBF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotMatCredUtilCurrYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotBalMATCredCF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtTaxCredUs115JAA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtMATLiabAllAssYrAvailSubseqYr">
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
    "taxUs115JBCurrAssYr",
    "taxOthProvCurrAssYr",
    "amtOfTaxWithCred",
    "utilMATCredAvl",
    "totMatCredGross",
    "totMatCredSetOff",
    "totMatCredBF",
    "totMatCredUtilCurrYr",
    "totBalMATCredCF",
    "amtTaxCredUs115JAA",
    "amtMATLiabAllAssYrAvailSubseqYr"
})
@XmlRootElement(name = "ScheduleMATC")
public class ScheduleMATC {

    @XmlElement(name = "TaxUs115JBCurrAssYr", required = true, defaultValue = "0")
    protected BigInteger taxUs115JBCurrAssYr;
    @XmlElement(name = "TaxOthProvCurrAssYr", required = true, defaultValue = "0")
    protected BigInteger taxOthProvCurrAssYr;
    @XmlElement(name = "AmtOfTaxWithCred", required = true, defaultValue = "0")
    protected BigInteger amtOfTaxWithCred;
    @XmlElement(name = "UtilMATCredAvl")
    protected List<UtilMATCredAvl> utilMATCredAvl;
    @XmlElement(name = "TotMatCredGross", required = true, defaultValue = "0")
    protected BigInteger totMatCredGross;
    @XmlElement(name = "TotMatCredSetOff", required = true, defaultValue = "0")
    protected BigInteger totMatCredSetOff;
    @XmlElement(name = "TotMatCredBF", required = true, defaultValue = "0")
    protected BigInteger totMatCredBF;
    @XmlElement(name = "TotMatCredUtilCurrYr", required = true, defaultValue = "0")
    protected BigInteger totMatCredUtilCurrYr;
    @XmlElement(name = "TotBalMATCredCF", required = true, defaultValue = "0")
    protected BigInteger totBalMATCredCF;
    @XmlElement(name = "AmtTaxCredUs115JAA", required = true, defaultValue = "0")
    protected BigInteger amtTaxCredUs115JAA;
    @XmlElement(name = "AmtMATLiabAllAssYrAvailSubseqYr", required = true, defaultValue = "0")
    protected BigInteger amtMATLiabAllAssYrAvailSubseqYr;

    /**
     * Gets the value of the taxUs115JBCurrAssYr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxUs115JBCurrAssYr() {
        return taxUs115JBCurrAssYr;
    }

    /**
     * Sets the value of the taxUs115JBCurrAssYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxUs115JBCurrAssYr(BigInteger value) {
        this.taxUs115JBCurrAssYr = value;
    }

    /**
     * Gets the value of the taxOthProvCurrAssYr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxOthProvCurrAssYr() {
        return taxOthProvCurrAssYr;
    }

    /**
     * Sets the value of the taxOthProvCurrAssYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxOthProvCurrAssYr(BigInteger value) {
        this.taxOthProvCurrAssYr = value;
    }

    /**
     * Gets the value of the amtOfTaxWithCred property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtOfTaxWithCred() {
        return amtOfTaxWithCred;
    }

    /**
     * Sets the value of the amtOfTaxWithCred property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtOfTaxWithCred(BigInteger value) {
        this.amtOfTaxWithCred = value;
    }

    /**
     * Gets the value of the utilMATCredAvl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the utilMATCredAvl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUtilMATCredAvl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UtilMATCredAvl }
     * 
     * 
     */
    public List<UtilMATCredAvl> getUtilMATCredAvl() {
        if (utilMATCredAvl == null) {
            utilMATCredAvl = new ArrayList<UtilMATCredAvl>();
        }
        return this.utilMATCredAvl;
    }

    /**
     * Gets the value of the totMatCredGross property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotMatCredGross() {
        return totMatCredGross;
    }

    /**
     * Sets the value of the totMatCredGross property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotMatCredGross(BigInteger value) {
        this.totMatCredGross = value;
    }

    /**
     * Gets the value of the totMatCredSetOff property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotMatCredSetOff() {
        return totMatCredSetOff;
    }

    /**
     * Sets the value of the totMatCredSetOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotMatCredSetOff(BigInteger value) {
        this.totMatCredSetOff = value;
    }

    /**
     * Gets the value of the totMatCredBF property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotMatCredBF() {
        return totMatCredBF;
    }

    /**
     * Sets the value of the totMatCredBF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotMatCredBF(BigInteger value) {
        this.totMatCredBF = value;
    }

    /**
     * Gets the value of the totMatCredUtilCurrYr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotMatCredUtilCurrYr() {
        return totMatCredUtilCurrYr;
    }

    /**
     * Sets the value of the totMatCredUtilCurrYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotMatCredUtilCurrYr(BigInteger value) {
        this.totMatCredUtilCurrYr = value;
    }

    /**
     * Gets the value of the totBalMATCredCF property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotBalMATCredCF() {
        return totBalMATCredCF;
    }

    /**
     * Sets the value of the totBalMATCredCF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotBalMATCredCF(BigInteger value) {
        this.totBalMATCredCF = value;
    }

    /**
     * Gets the value of the amtTaxCredUs115JAA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtTaxCredUs115JAA() {
        return amtTaxCredUs115JAA;
    }

    /**
     * Sets the value of the amtTaxCredUs115JAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtTaxCredUs115JAA(BigInteger value) {
        this.amtTaxCredUs115JAA = value;
    }

    /**
     * Gets the value of the amtMATLiabAllAssYrAvailSubseqYr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtMATLiabAllAssYrAvailSubseqYr() {
        return amtMATLiabAllAssYrAvailSubseqYr;
    }

    /**
     * Sets the value of the amtMATLiabAllAssYrAvailSubseqYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtMATLiabAllAssYrAvailSubseqYr(BigInteger value) {
        this.amtMATLiabAllAssYrAvailSubseqYr = value;
    }

}
