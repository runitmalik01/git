
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}EmployerOrDeductorOrCollectDetl"/>
 *         &lt;element name="TotTDSOnAmtPaid">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ClaimOutOfTotTDSOnAmtPaid">
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
    "employerOrDeductorOrCollectDetl",
    "totTDSOnAmtPaid",
    "claimOutOfTotTDSOnAmtPaid"
})
@XmlRootElement(name = "TDSonOthThanSal")
public class TDSonOthThanSal {

    @XmlElement(name = "EmployerOrDeductorOrCollectDetl", required = true)
    protected EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl;
    @XmlElement(name = "TotTDSOnAmtPaid", required = true, defaultValue = "0")
    protected BigInteger totTDSOnAmtPaid;
    @XmlElement(name = "ClaimOutOfTotTDSOnAmtPaid", required = true, defaultValue = "0")
    protected BigInteger claimOutOfTotTDSOnAmtPaid;

    /**
     * Deductor Details
     * 
     * @return
     *     possible object is
     *     {@link EmployerOrDeductorOrCollectDetl }
     *     
     */
    public EmployerOrDeductorOrCollectDetl getEmployerOrDeductorOrCollectDetl() {
        return employerOrDeductorOrCollectDetl;
    }

    /**
     * Sets the value of the employerOrDeductorOrCollectDetl property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployerOrDeductorOrCollectDetl }
     *     
     */
    public void setEmployerOrDeductorOrCollectDetl(EmployerOrDeductorOrCollectDetl value) {
        this.employerOrDeductorOrCollectDetl = value;
    }

    /**
     * Gets the value of the totTDSOnAmtPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotTDSOnAmtPaid() {
        return totTDSOnAmtPaid;
    }

    /**
     * Sets the value of the totTDSOnAmtPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotTDSOnAmtPaid(BigInteger value) {
        this.totTDSOnAmtPaid = value;
    }

    /**
     * Gets the value of the claimOutOfTotTDSOnAmtPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getClaimOutOfTotTDSOnAmtPaid() {
        return claimOutOfTotTDSOnAmtPaid;
    }

    /**
     * Sets the value of the claimOutOfTotTDSOnAmtPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setClaimOutOfTotTDSOnAmtPaid(BigInteger value) {
        this.claimOutOfTotTDSOnAmtPaid = value;
    }

}
