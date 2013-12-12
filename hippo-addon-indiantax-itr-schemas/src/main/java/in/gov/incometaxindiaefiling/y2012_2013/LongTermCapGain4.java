
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
 *         &lt;element name="NRIAssetSec48">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}CapGainSlumpSale" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}OtherAssetNoProviso112"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}OtherAssetProviso112"/>
 *         &lt;element name="UnlistedSecurities">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}AmtDeemedCGSec54"/>
 *         &lt;element name="TotalLTCG">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PANIfDeduction54GB" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z]{5}[0-9]{4}[A-Z]{1}"/>
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
    "nriAssetSec48",
    "capGainSlumpSale",
    "otherAssetNoProviso112",
    "otherAssetProviso112",
    "unlistedSecurities",
    "amtDeemedCGSec54",
    "totalLTCG",
    "panIfDeduction54GB"
})
@XmlRootElement(name = "LongTermCapGain4")
public class LongTermCapGain4 {

    @XmlElement(name = "NRIAssetSec48", defaultValue = "0")
    protected long nriAssetSec48;
    @XmlElement(name = "CapGainSlumpSale")
    protected CapGainSlumpSale capGainSlumpSale;
    @XmlElement(name = "OtherAssetNoProviso112", required = true)
    protected OtherAssetNoProviso112 otherAssetNoProviso112;
    @XmlElement(name = "OtherAssetProviso112", required = true)
    protected OtherAssetProviso112 otherAssetProviso112;
    @XmlElement(name = "UnlistedSecurities", defaultValue = "0")
    protected long unlistedSecurities;
    @XmlElement(name = "AmtDeemedCGSec54", required = true, defaultValue = "0")
    protected BigInteger amtDeemedCGSec54;
    @XmlElement(name = "TotalLTCG", defaultValue = "0")
    protected long totalLTCG;
    @XmlElement(name = "PANIfDeduction54GB")
    protected String panIfDeduction54GB;

    /**
     * Gets the value of the nriAssetSec48 property.
     * 
     */
    public long getNRIAssetSec48() {
        return nriAssetSec48;
    }

    /**
     * Sets the value of the nriAssetSec48 property.
     * 
     */
    public void setNRIAssetSec48(long value) {
        this.nriAssetSec48 = value;
    }

    /**
     * Gets the value of the capGainSlumpSale property.
     * 
     * @return
     *     possible object is
     *     {@link CapGainSlumpSale }
     *     
     */
    public CapGainSlumpSale getCapGainSlumpSale() {
        return capGainSlumpSale;
    }

    /**
     * Sets the value of the capGainSlumpSale property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapGainSlumpSale }
     *     
     */
    public void setCapGainSlumpSale(CapGainSlumpSale value) {
        this.capGainSlumpSale = value;
    }

    /**
     * Gets the value of the otherAssetNoProviso112 property.
     * 
     * @return
     *     possible object is
     *     {@link OtherAssetNoProviso112 }
     *     
     */
    public OtherAssetNoProviso112 getOtherAssetNoProviso112() {
        return otherAssetNoProviso112;
    }

    /**
     * Sets the value of the otherAssetNoProviso112 property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherAssetNoProviso112 }
     *     
     */
    public void setOtherAssetNoProviso112(OtherAssetNoProviso112 value) {
        this.otherAssetNoProviso112 = value;
    }

    /**
     * Gets the value of the otherAssetProviso112 property.
     * 
     * @return
     *     possible object is
     *     {@link OtherAssetProviso112 }
     *     
     */
    public OtherAssetProviso112 getOtherAssetProviso112() {
        return otherAssetProviso112;
    }

    /**
     * Sets the value of the otherAssetProviso112 property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherAssetProviso112 }
     *     
     */
    public void setOtherAssetProviso112(OtherAssetProviso112 value) {
        this.otherAssetProviso112 = value;
    }

    /**
     * Gets the value of the unlistedSecurities property.
     * 
     */
    public long getUnlistedSecurities() {
        return unlistedSecurities;
    }

    /**
     * Sets the value of the unlistedSecurities property.
     * 
     */
    public void setUnlistedSecurities(long value) {
        this.unlistedSecurities = value;
    }

    /**
     * Gets the value of the amtDeemedCGSec54 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtDeemedCGSec54() {
        return amtDeemedCGSec54;
    }

    /**
     * Sets the value of the amtDeemedCGSec54 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtDeemedCGSec54(BigInteger value) {
        this.amtDeemedCGSec54 = value;
    }

    /**
     * Gets the value of the totalLTCG property.
     * 
     */
    public long getTotalLTCG() {
        return totalLTCG;
    }

    /**
     * Sets the value of the totalLTCG property.
     * 
     */
    public void setTotalLTCG(long value) {
        this.totalLTCG = value;
    }

    /**
     * Gets the value of the panIfDeduction54GB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPANIfDeduction54GB() {
        return panIfDeduction54GB;
    }

    /**
     * Sets the value of the panIfDeduction54GB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPANIfDeduction54GB(String value) {
        this.panIfDeduction54GB = value;
    }

}
