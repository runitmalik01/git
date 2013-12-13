
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
 *         &lt;element name="IncChrgSTT">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="STTNonSpecBusUsA34">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="STTSpecBusUsB38">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotChrgAmtSTT">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TaxPaySTTAvgRate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STTPaid">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RebateUs88E">
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
    "incChrgSTT",
    "taxPaySTTAvgRate",
    "sttPaid",
    "rebateUs88E"
})
@XmlRootElement(name = "ScheduleSTTC")
public class ScheduleSTTC {

    @XmlElement(name = "IncChrgSTT", required = true)
    protected ScheduleSTTC.IncChrgSTT incChrgSTT;
    @XmlElement(name = "TaxPaySTTAvgRate", required = true)
    protected BigInteger taxPaySTTAvgRate;
    @XmlElement(name = "STTPaid", required = true)
    protected BigInteger sttPaid;
    @XmlElement(name = "RebateUs88E", required = true)
    protected BigInteger rebateUs88E;

    /**
     * Gets the value of the incChrgSTT property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleSTTC.IncChrgSTT }
     *     
     */
    public ScheduleSTTC.IncChrgSTT getIncChrgSTT() {
        return incChrgSTT;
    }

    /**
     * Sets the value of the incChrgSTT property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleSTTC.IncChrgSTT }
     *     
     */
    public void setIncChrgSTT(ScheduleSTTC.IncChrgSTT value) {
        this.incChrgSTT = value;
    }

    /**
     * Gets the value of the taxPaySTTAvgRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPaySTTAvgRate() {
        return taxPaySTTAvgRate;
    }

    /**
     * Sets the value of the taxPaySTTAvgRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPaySTTAvgRate(BigInteger value) {
        this.taxPaySTTAvgRate = value;
    }

    /**
     * Gets the value of the sttPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSTTPaid() {
        return sttPaid;
    }

    /**
     * Sets the value of the sttPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSTTPaid(BigInteger value) {
        this.sttPaid = value;
    }

    /**
     * Gets the value of the rebateUs88E property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRebateUs88E() {
        return rebateUs88E;
    }

    /**
     * Sets the value of the rebateUs88E property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRebateUs88E(BigInteger value) {
        this.rebateUs88E = value;
    }


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
     *         &lt;element name="STTNonSpecBusUsA34">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="STTSpecBusUsB38">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotChrgAmtSTT">
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
        "sttNonSpecBusUsA34",
        "sttSpecBusUsB38",
        "totChrgAmtSTT"
    })
    public static class IncChrgSTT {

        @XmlElement(name = "STTNonSpecBusUsA34")
        protected long sttNonSpecBusUsA34;
        @XmlElement(name = "STTSpecBusUsB38")
        protected long sttSpecBusUsB38;
        @XmlElement(name = "TotChrgAmtSTT")
        protected long totChrgAmtSTT;

        /**
         * Gets the value of the sttNonSpecBusUsA34 property.
         * 
         */
        public long getSTTNonSpecBusUsA34() {
            return sttNonSpecBusUsA34;
        }

        /**
         * Sets the value of the sttNonSpecBusUsA34 property.
         * 
         */
        public void setSTTNonSpecBusUsA34(long value) {
            this.sttNonSpecBusUsA34 = value;
        }

        /**
         * Gets the value of the sttSpecBusUsB38 property.
         * 
         */
        public long getSTTSpecBusUsB38() {
            return sttSpecBusUsB38;
        }

        /**
         * Sets the value of the sttSpecBusUsB38 property.
         * 
         */
        public void setSTTSpecBusUsB38(long value) {
            this.sttSpecBusUsB38 = value;
        }

        /**
         * Gets the value of the totChrgAmtSTT property.
         * 
         */
        public long getTotChrgAmtSTT() {
            return totChrgAmtSTT;
        }

        /**
         * Sets the value of the totChrgAmtSTT property.
         * 
         */
        public void setTotChrgAmtSTT(long value) {
            this.totChrgAmtSTT = value;
        }

    }

}
