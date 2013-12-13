
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
 *         &lt;element name="TotalIncItem11">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AdjustmentSec115JC" maxOccurs="unbounded"/>
 *         &lt;element name="AdjustedUnderSec115JC">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPayableUnderSec115JC">
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
    "totalIncItem11",
    "adjustmentSec115JC",
    "adjustedUnderSec115JC",
    "taxPayableUnderSec115JC"
})
@XmlRootElement(name = "ITRScheduleAMT")
public class ITRScheduleAMT {

    @XmlElement(name = "TotalIncItem11", required = true, defaultValue = "0")
    protected BigInteger totalIncItem11;
    @XmlElement(name = "AdjustmentSec115JC", required = true)
    protected List<AdjustmentSec115JC> adjustmentSec115JC;
    @XmlElement(name = "AdjustedUnderSec115JC", required = true, defaultValue = "0")
    protected BigInteger adjustedUnderSec115JC;
    @XmlElement(name = "TaxPayableUnderSec115JC", required = true, defaultValue = "0")
    protected BigInteger taxPayableUnderSec115JC;

    /**
     * Gets the value of the totalIncItem11 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalIncItem11() {
        return totalIncItem11;
    }

    /**
     * Sets the value of the totalIncItem11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalIncItem11(BigInteger value) {
        this.totalIncItem11 = value;
    }

    /**
     * Gets the value of the adjustmentSec115JC property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adjustmentSec115JC property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdjustmentSec115JC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdjustmentSec115JC }
     * 
     * 
     */
    public List<AdjustmentSec115JC> getAdjustmentSec115JC() {
        if (adjustmentSec115JC == null) {
            adjustmentSec115JC = new ArrayList<AdjustmentSec115JC>();
        }
        return this.adjustmentSec115JC;
    }

    /**
     * Gets the value of the adjustedUnderSec115JC property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAdjustedUnderSec115JC() {
        return adjustedUnderSec115JC;
    }

    /**
     * Sets the value of the adjustedUnderSec115JC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAdjustedUnderSec115JC(BigInteger value) {
        this.adjustedUnderSec115JC = value;
    }

    /**
     * Gets the value of the taxPayableUnderSec115JC property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPayableUnderSec115JC() {
        return taxPayableUnderSec115JC;
    }

    /**
     * Sets the value of the taxPayableUnderSec115JC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPayableUnderSec115JC(BigInteger value) {
        this.taxPayableUnderSec115JC = value;
    }

}
