
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
 *         &lt;element name="DeductClaimSec6A">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeductClaimSec10AA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Total">
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
    "deductClaimSec6A",
    "deductClaimSec10AA",
    "total"
})
@XmlRootElement(name = "AdjustmentSec115JC")
public class AdjustmentSec115JC {

    @XmlElement(name = "DeductClaimSec6A", required = true, defaultValue = "0")
    protected BigInteger deductClaimSec6A;
    @XmlElement(name = "DeductClaimSec10AA", required = true, defaultValue = "0")
    protected BigInteger deductClaimSec10AA;
    @XmlElement(name = "Total", required = true, defaultValue = "0")
    protected BigInteger total;

    /**
     * Gets the value of the deductClaimSec6A property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeductClaimSec6A() {
        return deductClaimSec6A;
    }

    /**
     * Sets the value of the deductClaimSec6A property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeductClaimSec6A(BigInteger value) {
        this.deductClaimSec6A = value;
    }

    /**
     * Gets the value of the deductClaimSec10AA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeductClaimSec10AA() {
        return deductClaimSec10AA;
    }

    /**
     * Sets the value of the deductClaimSec10AA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeductClaimSec10AA(BigInteger value) {
        this.deductClaimSec10AA = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotal(BigInteger value) {
        this.total = value;
    }

}
