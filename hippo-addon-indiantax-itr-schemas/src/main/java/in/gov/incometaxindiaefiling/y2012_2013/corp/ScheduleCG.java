
package in.gov.incometaxindiaefiling.y2012_2013.corp;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ShortTermCapGain" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}LongTermCapGain" minOccurs="0"/>
 *         &lt;element name="IncChargeableHeadCapGain" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AccruOrRecOfCG"/>
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
    "shortTermCapGain",
    "longTermCapGain",
    "incChargeableHeadCapGain",
    "accruOrRecOfCG"
})
@XmlRootElement(name = "ScheduleCG")
public class ScheduleCG {

    @XmlElement(name = "ShortTermCapGain")
    protected ShortTermCapGain shortTermCapGain;
    @XmlElement(name = "LongTermCapGain")
    protected LongTermCapGain longTermCapGain;
    @XmlElement(name = "IncChargeableHeadCapGain", defaultValue = "0")
    protected Long incChargeableHeadCapGain;
    @XmlElement(name = "AccruOrRecOfCG", required = true)
    protected AccruOrRecOfCG accruOrRecOfCG;

    /**
     * Gets the value of the shortTermCapGain property.
     * 
     * @return
     *     possible object is
     *     {@link ShortTermCapGain }
     *     
     */
    public ShortTermCapGain getShortTermCapGain() {
        return shortTermCapGain;
    }

    /**
     * Sets the value of the shortTermCapGain property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortTermCapGain }
     *     
     */
    public void setShortTermCapGain(ShortTermCapGain value) {
        this.shortTermCapGain = value;
    }

    /**
     * Gets the value of the longTermCapGain property.
     * 
     * @return
     *     possible object is
     *     {@link LongTermCapGain }
     *     
     */
    public LongTermCapGain getLongTermCapGain() {
        return longTermCapGain;
    }

    /**
     * Sets the value of the longTermCapGain property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongTermCapGain }
     *     
     */
    public void setLongTermCapGain(LongTermCapGain value) {
        this.longTermCapGain = value;
    }

    /**
     * Gets the value of the incChargeableHeadCapGain property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncChargeableHeadCapGain() {
        return incChargeableHeadCapGain;
    }

    /**
     * Sets the value of the incChargeableHeadCapGain property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncChargeableHeadCapGain(Long value) {
        this.incChargeableHeadCapGain = value;
    }

    /**
     * Info about accrual or reciept of Capital Gains
     * 							after Adjustments of Losses in Sch CYLA and BFLA
     * 						
     * 
     * @return
     *     possible object is
     *     {@link AccruOrRecOfCG }
     *     
     */
    public AccruOrRecOfCG getAccruOrRecOfCG() {
        return accruOrRecOfCG;
    }

    /**
     * Sets the value of the accruOrRecOfCG property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccruOrRecOfCG }
     *     
     */
    public void setAccruOrRecOfCG(AccruOrRecOfCG value) {
        this.accruOrRecOfCG = value;
    }

}
