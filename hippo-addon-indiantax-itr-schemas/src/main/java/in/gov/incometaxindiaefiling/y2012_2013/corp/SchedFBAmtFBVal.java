
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
 *         &lt;element name="AmtOrValueOfExpenditure">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ValueOfFB">
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
    "amtOrValueOfExpenditure",
    "valueOfFB"
})
@XmlRootElement(name = "SchedFBAmtFBVal")
public class SchedFBAmtFBVal {

    @XmlElement(name = "AmtOrValueOfExpenditure", required = true, defaultValue = "0")
    protected BigInteger amtOrValueOfExpenditure;
    @XmlElement(name = "ValueOfFB", required = true, defaultValue = "0")
    protected BigInteger valueOfFB;

    /**
     * Gets the value of the amtOrValueOfExpenditure property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtOrValueOfExpenditure() {
        return amtOrValueOfExpenditure;
    }

    /**
     * Sets the value of the amtOrValueOfExpenditure property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtOrValueOfExpenditure(BigInteger value) {
        this.amtOrValueOfExpenditure = value;
    }

    /**
     * Gets the value of the valueOfFB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValueOfFB() {
        return valueOfFB;
    }

    /**
     * Sets the value of the valueOfFB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValueOfFB(BigInteger value) {
        this.valueOfFB = value;
    }

}
