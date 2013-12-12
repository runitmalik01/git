
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ComputationOfTaxLiability"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}TaxPaid"/>
 *         &lt;element name="RefundsDue" minOccurs="0">
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
    "computationOfTaxLiability",
    "taxPaid",
    "refundsDue"
})
@XmlRootElement(name = "PartB_TTI")
public class PartBTTI {

    @XmlElement(name = "ComputationOfTaxLiability", required = true)
    protected ComputationOfTaxLiability computationOfTaxLiability;
    @XmlElement(name = "TaxPaid", required = true)
    protected TaxPaid taxPaid;
    @XmlElement(name = "RefundsDue", defaultValue = "0")
    protected BigInteger refundsDue;

    /**
     * Gets the value of the computationOfTaxLiability property.
     * 
     * @return
     *     possible object is
     *     {@link ComputationOfTaxLiability }
     *     
     */
    public ComputationOfTaxLiability getComputationOfTaxLiability() {
        return computationOfTaxLiability;
    }

    /**
     * Sets the value of the computationOfTaxLiability property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComputationOfTaxLiability }
     *     
     */
    public void setComputationOfTaxLiability(ComputationOfTaxLiability value) {
        this.computationOfTaxLiability = value;
    }

    /**
     * Gets the value of the taxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link TaxPaid }
     *     
     */
    public TaxPaid getTaxPaid() {
        return taxPaid;
    }

    /**
     * Sets the value of the taxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPaid }
     *     
     */
    public void setTaxPaid(TaxPaid value) {
        this.taxPaid = value;
    }

    /**
     * Gets the value of the refundsDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRefundsDue() {
        return refundsDue;
    }

    /**
     * Sets the value of the refundsDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRefundsDue(BigInteger value) {
        this.refundsDue = value;
    }

}
