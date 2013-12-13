
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
 *         &lt;element name="DepositsInBank" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SharesAndSecurities" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InsurancePolicies" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LoansAndAdvancesGiven" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CashInHand" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="JewelleryBullionEtc" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ArchCollDrawPaintSulpArt" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VehiclYachtsBoatsAircrafts" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalImmovablMovablAssets">
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
    "depositsInBank",
    "sharesAndSecurities",
    "insurancePolicies",
    "loansAndAdvancesGiven",
    "cashInHand",
    "jewelleryBullionEtc",
    "archCollDrawPaintSulpArt",
    "vehiclYachtsBoatsAircrafts",
    "totalImmovablMovablAssets"
})
@XmlRootElement(name = "MovableAsset")
public class MovableAsset {

    @XmlElement(name = "DepositsInBank")
    protected BigInteger depositsInBank;
    @XmlElement(name = "SharesAndSecurities")
    protected BigInteger sharesAndSecurities;
    @XmlElement(name = "InsurancePolicies")
    protected BigInteger insurancePolicies;
    @XmlElement(name = "LoansAndAdvancesGiven")
    protected BigInteger loansAndAdvancesGiven;
    @XmlElement(name = "CashInHand")
    protected BigInteger cashInHand;
    @XmlElement(name = "JewelleryBullionEtc")
    protected BigInteger jewelleryBullionEtc;
    @XmlElement(name = "ArchCollDrawPaintSulpArt")
    protected BigInteger archCollDrawPaintSulpArt;
    @XmlElement(name = "VehiclYachtsBoatsAircrafts")
    protected BigInteger vehiclYachtsBoatsAircrafts;
    @XmlElement(name = "TotalImmovablMovablAssets", required = true, defaultValue = "0")
    protected BigInteger totalImmovablMovablAssets;

    /**
     * Gets the value of the depositsInBank property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDepositsInBank() {
        return depositsInBank;
    }

    /**
     * Sets the value of the depositsInBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDepositsInBank(BigInteger value) {
        this.depositsInBank = value;
    }

    /**
     * Gets the value of the sharesAndSecurities property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSharesAndSecurities() {
        return sharesAndSecurities;
    }

    /**
     * Sets the value of the sharesAndSecurities property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSharesAndSecurities(BigInteger value) {
        this.sharesAndSecurities = value;
    }

    /**
     * Gets the value of the insurancePolicies property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInsurancePolicies() {
        return insurancePolicies;
    }

    /**
     * Sets the value of the insurancePolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInsurancePolicies(BigInteger value) {
        this.insurancePolicies = value;
    }

    /**
     * Gets the value of the loansAndAdvancesGiven property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLoansAndAdvancesGiven() {
        return loansAndAdvancesGiven;
    }

    /**
     * Sets the value of the loansAndAdvancesGiven property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLoansAndAdvancesGiven(BigInteger value) {
        this.loansAndAdvancesGiven = value;
    }

    /**
     * Gets the value of the cashInHand property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCashInHand() {
        return cashInHand;
    }

    /**
     * Sets the value of the cashInHand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCashInHand(BigInteger value) {
        this.cashInHand = value;
    }

    /**
     * Gets the value of the jewelleryBullionEtc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJewelleryBullionEtc() {
        return jewelleryBullionEtc;
    }

    /**
     * Sets the value of the jewelleryBullionEtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJewelleryBullionEtc(BigInteger value) {
        this.jewelleryBullionEtc = value;
    }

    /**
     * Gets the value of the archCollDrawPaintSulpArt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getArchCollDrawPaintSulpArt() {
        return archCollDrawPaintSulpArt;
    }

    /**
     * Sets the value of the archCollDrawPaintSulpArt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setArchCollDrawPaintSulpArt(BigInteger value) {
        this.archCollDrawPaintSulpArt = value;
    }

    /**
     * Gets the value of the vehiclYachtsBoatsAircrafts property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVehiclYachtsBoatsAircrafts() {
        return vehiclYachtsBoatsAircrafts;
    }

    /**
     * Sets the value of the vehiclYachtsBoatsAircrafts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVehiclYachtsBoatsAircrafts(BigInteger value) {
        this.vehiclYachtsBoatsAircrafts = value;
    }

    /**
     * Gets the value of the totalImmovablMovablAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalImmovablMovablAssets() {
        return totalImmovablMovablAssets;
    }

    /**
     * Sets the value of the totalImmovablMovablAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalImmovablMovablAssets(BigInteger value) {
        this.totalImmovablMovablAssets = value;
    }

}
