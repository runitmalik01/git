
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}CapGainSlumpSale" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}NRIAssetSec48Dtl" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}OtherAsset111AApplicable" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}OtherAsset"/>
 *         &lt;element name="DeemedSTCGDeprAsset" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}AmtDeemedCGSec54"/>
 *         &lt;element name="TotalSTCG">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
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
    "capGainSlumpSale",
    "nriAssetSec48Dtl",
    "otherAsset111AApplicable",
    "otherAsset",
    "deemedSTCGDeprAsset",
    "amtDeemedCGSec54",
    "totalSTCG"
})
@XmlRootElement(name = "ShortTermCapGainFor4")
public class ShortTermCapGainFor4 {

    @XmlElement(name = "CapGainSlumpSale")
    protected CapGainSlumpSale capGainSlumpSale;
    @XmlElement(name = "NRIAssetSec48Dtl")
    protected NRIAssetSec48Dtl nriAssetSec48Dtl;
    @XmlElement(name = "OtherAsset111AApplicable")
    protected OtherAsset111AApplicable otherAsset111AApplicable;
    @XmlElement(name = "OtherAsset", required = true)
    protected OtherAsset otherAsset;
    @XmlElement(name = "DeemedSTCGDeprAsset", defaultValue = "0")
    protected Long deemedSTCGDeprAsset;
    @XmlElement(name = "AmtDeemedCGSec54", required = true, defaultValue = "0")
    protected BigInteger amtDeemedCGSec54;
    @XmlElement(name = "TotalSTCG", defaultValue = "0")
    protected long totalSTCG;

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
     * Gets the value of the nriAssetSec48Dtl property.
     * 
     * @return
     *     possible object is
     *     {@link NRIAssetSec48Dtl }
     *     
     */
    public NRIAssetSec48Dtl getNRIAssetSec48Dtl() {
        return nriAssetSec48Dtl;
    }

    /**
     * Sets the value of the nriAssetSec48Dtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link NRIAssetSec48Dtl }
     *     
     */
    public void setNRIAssetSec48Dtl(NRIAssetSec48Dtl value) {
        this.nriAssetSec48Dtl = value;
    }

    /**
     * Gets the value of the otherAsset111AApplicable property.
     * 
     * @return
     *     possible object is
     *     {@link OtherAsset111AApplicable }
     *     
     */
    public OtherAsset111AApplicable getOtherAsset111AApplicable() {
        return otherAsset111AApplicable;
    }

    /**
     * Sets the value of the otherAsset111AApplicable property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherAsset111AApplicable }
     *     
     */
    public void setOtherAsset111AApplicable(OtherAsset111AApplicable value) {
        this.otherAsset111AApplicable = value;
    }

    /**
     * Gets the value of the otherAsset property.
     * 
     * @return
     *     possible object is
     *     {@link OtherAsset }
     *     
     */
    public OtherAsset getOtherAsset() {
        return otherAsset;
    }

    /**
     * Sets the value of the otherAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherAsset }
     *     
     */
    public void setOtherAsset(OtherAsset value) {
        this.otherAsset = value;
    }

    /**
     * Gets the value of the deemedSTCGDeprAsset property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeemedSTCGDeprAsset() {
        return deemedSTCGDeprAsset;
    }

    /**
     * Sets the value of the deemedSTCGDeprAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeemedSTCGDeprAsset(Long value) {
        this.deemedSTCGDeprAsset = value;
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
     * Gets the value of the totalSTCG property.
     * 
     */
    public long getTotalSTCG() {
        return totalSTCG;
    }

    /**
     * Sets the value of the totalSTCG property.
     * 
     */
    public void setTotalSTCG(long value) {
        this.totalSTCG = value;
    }

}
