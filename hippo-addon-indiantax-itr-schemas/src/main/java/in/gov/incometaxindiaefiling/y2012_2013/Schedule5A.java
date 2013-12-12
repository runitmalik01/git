
package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element name="NameOfSpouse">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PANOfSpouse">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z]{5}[0-9]{4}[A-Z]{1}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HPHeadIncome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BusHeadIncome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CapGainHeadIncome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherSourcesHeadIncome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalHeadIncome">
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
    "nameOfSpouse",
    "panOfSpouse",
    "hpHeadIncome",
    "busHeadIncome",
    "capGainHeadIncome",
    "otherSourcesHeadIncome",
    "totalHeadIncome"
})
@XmlRootElement(name = "Schedule5A")
public class Schedule5A {

    @XmlElement(name = "NameOfSpouse", required = true)
    protected String nameOfSpouse;
    @XmlElement(name = "PANOfSpouse", required = true)
    protected String panOfSpouse;
    @XmlElement(name = "HPHeadIncome", defaultValue = "0")
    protected long hpHeadIncome;
    @XmlElement(name = "BusHeadIncome", defaultValue = "0")
    protected long busHeadIncome;
    @XmlElement(name = "CapGainHeadIncome", defaultValue = "0")
    protected long capGainHeadIncome;
    @XmlElement(name = "OtherSourcesHeadIncome", defaultValue = "0")
    protected long otherSourcesHeadIncome;
    @XmlElement(name = "TotalHeadIncome", defaultValue = "0")
    protected long totalHeadIncome;

    /**
     * Gets the value of the nameOfSpouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfSpouse() {
        return nameOfSpouse;
    }

    /**
     * Sets the value of the nameOfSpouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfSpouse(String value) {
        this.nameOfSpouse = value;
    }

    /**
     * Gets the value of the panOfSpouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPANOfSpouse() {
        return panOfSpouse;
    }

    /**
     * Sets the value of the panOfSpouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPANOfSpouse(String value) {
        this.panOfSpouse = value;
    }

    /**
     * Gets the value of the hpHeadIncome property.
     * 
     */
    public long getHPHeadIncome() {
        return hpHeadIncome;
    }

    /**
     * Sets the value of the hpHeadIncome property.
     * 
     */
    public void setHPHeadIncome(long value) {
        this.hpHeadIncome = value;
    }

    /**
     * Gets the value of the busHeadIncome property.
     * 
     */
    public long getBusHeadIncome() {
        return busHeadIncome;
    }

    /**
     * Sets the value of the busHeadIncome property.
     * 
     */
    public void setBusHeadIncome(long value) {
        this.busHeadIncome = value;
    }

    /**
     * Gets the value of the capGainHeadIncome property.
     * 
     */
    public long getCapGainHeadIncome() {
        return capGainHeadIncome;
    }

    /**
     * Sets the value of the capGainHeadIncome property.
     * 
     */
    public void setCapGainHeadIncome(long value) {
        this.capGainHeadIncome = value;
    }

    /**
     * Gets the value of the otherSourcesHeadIncome property.
     * 
     */
    public long getOtherSourcesHeadIncome() {
        return otherSourcesHeadIncome;
    }

    /**
     * Sets the value of the otherSourcesHeadIncome property.
     * 
     */
    public void setOtherSourcesHeadIncome(long value) {
        this.otherSourcesHeadIncome = value;
    }

    /**
     * Gets the value of the totalHeadIncome property.
     * 
     */
    public long getTotalHeadIncome() {
        return totalHeadIncome;
    }

    /**
     * Sets the value of the totalHeadIncome property.
     * 
     */
    public void setTotalHeadIncome(long value) {
        this.totalHeadIncome = value;
    }

}
