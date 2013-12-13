
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
 *         &lt;element name="OtherSrcThanOwnRaceHorse">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WinLotteriesRacesGambling">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FromOwnRaceHorse">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotIncFromOS">
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
    "otherSrcThanOwnRaceHorse",
    "winLotteriesRacesGambling",
    "fromOwnRaceHorse",
    "totIncFromOS"
})
@XmlRootElement(name = "IncFromOS")
public class IncFromOS {

    @XmlElement(name = "OtherSrcThanOwnRaceHorse", defaultValue = "0")
    protected long otherSrcThanOwnRaceHorse;
    @XmlElement(name = "WinLotteriesRacesGambling", required = true, defaultValue = "0")
    protected BigInteger winLotteriesRacesGambling;
    @XmlElement(name = "FromOwnRaceHorse", required = true, defaultValue = "0")
    protected BigInteger fromOwnRaceHorse;
    @XmlElement(name = "TotIncFromOS", required = true, defaultValue = "0")
    protected BigInteger totIncFromOS;

    /**
     * Gets the value of the otherSrcThanOwnRaceHorse property.
     * 
     */
    public long getOtherSrcThanOwnRaceHorse() {
        return otherSrcThanOwnRaceHorse;
    }

    /**
     * Sets the value of the otherSrcThanOwnRaceHorse property.
     * 
     */
    public void setOtherSrcThanOwnRaceHorse(long value) {
        this.otherSrcThanOwnRaceHorse = value;
    }

    /**
     * Gets the value of the winLotteriesRacesGambling property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWinLotteriesRacesGambling() {
        return winLotteriesRacesGambling;
    }

    /**
     * Sets the value of the winLotteriesRacesGambling property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWinLotteriesRacesGambling(BigInteger value) {
        this.winLotteriesRacesGambling = value;
    }

    /**
     * Gets the value of the fromOwnRaceHorse property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFromOwnRaceHorse() {
        return fromOwnRaceHorse;
    }

    /**
     * Sets the value of the fromOwnRaceHorse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFromOwnRaceHorse(BigInteger value) {
        this.fromOwnRaceHorse = value;
    }

    /**
     * Gets the value of the totIncFromOS property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotIncFromOS() {
        return totIncFromOS;
    }

    /**
     * Sets the value of the totIncFromOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotIncFromOS(BigInteger value) {
        this.totIncFromOS = value;
    }

}
