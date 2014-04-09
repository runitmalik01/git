
package in.gov.incometaxindiaefiling.y2013_2014;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}EmployerOrDeductorOrCollectDetl"/>
 *         &lt;element name="UniqueTDSCerNo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
 *               &lt;maxLength value="8"/>
 *               &lt;pattern value="|[a-zA-Z0-9]{8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeductedYr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="4"/>
 *               &lt;pattern value="\d\d\d\d"/>
 *               &lt;maxInclusive value="2013"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
 *         &lt;element name="AmtClaimedBySpouse" minOccurs="0">
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
    "uniqueTDSCerNo",
    "deductedYr",
    "totTDSOnAmtPaid",
    "claimOutOfTotTDSOnAmtPaid",
    "amtClaimedBySpouse"
})
@XmlRootElement(name = "TDSonOthThanSal")
public class TDSonOthThanSal {

    @XmlElement(name = "EmployerOrDeductorOrCollectDetl", required = true)
    protected EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl;
    @XmlElement(name = "UniqueTDSCerNo")
    protected String uniqueTDSCerNo;
    @XmlElement(name = "DeductedYr")
    protected Integer deductedYr;
    @XmlElement(name = "TotTDSOnAmtPaid", required = true, defaultValue = "0")
    protected BigInteger totTDSOnAmtPaid;
    @XmlElement(name = "ClaimOutOfTotTDSOnAmtPaid", required = true, defaultValue = "0")
    protected BigInteger claimOutOfTotTDSOnAmtPaid;
    @XmlElement(name = "AmtClaimedBySpouse", defaultValue = "0")
    protected BigInteger amtClaimedBySpouse;

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
     * Gets the value of the uniqueTDSCerNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueTDSCerNo() {
        return uniqueTDSCerNo;
    }

    /**
     * Sets the value of the uniqueTDSCerNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueTDSCerNo(String value) {
        this.uniqueTDSCerNo = value;
    }

    /**
     * Gets the value of the deductedYr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeductedYr() {
        return deductedYr;
    }

    /**
     * Sets the value of the deductedYr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeductedYr(Integer value) {
        this.deductedYr = value;
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

    /**
     * Gets the value of the amtClaimedBySpouse property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmtClaimedBySpouse() {
        return amtClaimedBySpouse;
    }

    /**
     * Sets the value of the amtClaimedBySpouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmtClaimedBySpouse(BigInteger value) {
        this.amtClaimedBySpouse = value;
    }

}
