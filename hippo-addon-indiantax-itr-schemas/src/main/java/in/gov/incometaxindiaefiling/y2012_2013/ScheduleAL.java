
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
 *         &lt;element name="ImmovableAssetLand" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ImmovableAssetBuilding" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}MovableAsset" minOccurs="0"/>
 *         &lt;element name="LiabilityInRelatAssets" minOccurs="0">
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
    "immovableAssetLand",
    "immovableAssetBuilding",
    "movableAsset",
    "liabilityInRelatAssets"
})
@XmlRootElement(name = "ScheduleAL")
public class ScheduleAL {

    @XmlElement(name = "ImmovableAssetLand", defaultValue = "0")
    protected BigInteger immovableAssetLand;
    @XmlElement(name = "ImmovableAssetBuilding", defaultValue = "0")
    protected BigInteger immovableAssetBuilding;
    @XmlElement(name = "MovableAsset")
    protected MovableAsset movableAsset;
    @XmlElement(name = "LiabilityInRelatAssets", defaultValue = "0")
    protected BigInteger liabilityInRelatAssets;

    /**
     * Gets the value of the immovableAssetLand property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getImmovableAssetLand() {
        return immovableAssetLand;
    }

    /**
     * Sets the value of the immovableAssetLand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setImmovableAssetLand(BigInteger value) {
        this.immovableAssetLand = value;
    }

    /**
     * Gets the value of the immovableAssetBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getImmovableAssetBuilding() {
        return immovableAssetBuilding;
    }

    /**
     * Sets the value of the immovableAssetBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setImmovableAssetBuilding(BigInteger value) {
        this.immovableAssetBuilding = value;
    }

    /**
     * Gets the value of the movableAsset property.
     * 
     * @return
     *     possible object is
     *     {@link MovableAsset }
     *     
     */
    public MovableAsset getMovableAsset() {
        return movableAsset;
    }

    /**
     * Sets the value of the movableAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovableAsset }
     *     
     */
    public void setMovableAsset(MovableAsset value) {
        this.movableAsset = value;
    }

    /**
     * Gets the value of the liabilityInRelatAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLiabilityInRelatAssets() {
        return liabilityInRelatAssets;
    }

    /**
     * Sets the value of the liabilityInRelatAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLiabilityInRelatAssets(BigInteger value) {
        this.liabilityInRelatAssets = value;
    }

}
