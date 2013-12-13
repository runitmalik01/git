
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
 *         &lt;element name="CountryName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="55"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}CountryCode"/>
 *         &lt;element name="TaxIdentificationNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RelavantArticleDTAA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalTaxpaid">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotTaxreliefClaimed">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ReliefClaimed90Or90A">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ReliefClaimedUs91">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "countryName",
    "countryCode",
    "taxIdentificationNo",
    "relavantArticleDTAA",
    "totalTaxpaid",
    "totTaxreliefClaimed"
})
@XmlRootElement(name = "ScheduleTR")
public class ScheduleTR {

    @XmlElement(name = "CountryName", required = true)
    protected String countryName;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "TaxIdentificationNo", required = true)
    protected String taxIdentificationNo;
    @XmlElement(name = "RelavantArticleDTAA", required = true)
    protected String relavantArticleDTAA;
    @XmlElement(name = "TotalTaxpaid", required = true, defaultValue = "0")
    protected BigInteger totalTaxpaid;
    @XmlElement(name = "TotTaxreliefClaimed", required = true)
    protected ScheduleTR.TotTaxreliefClaimed totTaxreliefClaimed;

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the taxIdentificationNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxIdentificationNo() {
        return taxIdentificationNo;
    }

    /**
     * Sets the value of the taxIdentificationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxIdentificationNo(String value) {
        this.taxIdentificationNo = value;
    }

    /**
     * Gets the value of the relavantArticleDTAA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelavantArticleDTAA() {
        return relavantArticleDTAA;
    }

    /**
     * Sets the value of the relavantArticleDTAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelavantArticleDTAA(String value) {
        this.relavantArticleDTAA = value;
    }

    /**
     * Gets the value of the totalTaxpaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalTaxpaid() {
        return totalTaxpaid;
    }

    /**
     * Sets the value of the totalTaxpaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalTaxpaid(BigInteger value) {
        this.totalTaxpaid = value;
    }

    /**
     * Gets the value of the totTaxreliefClaimed property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleTR.TotTaxreliefClaimed }
     *     
     */
    public ScheduleTR.TotTaxreliefClaimed getTotTaxreliefClaimed() {
        return totTaxreliefClaimed;
    }

    /**
     * Sets the value of the totTaxreliefClaimed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleTR.TotTaxreliefClaimed }
     *     
     */
    public void setTotTaxreliefClaimed(ScheduleTR.TotTaxreliefClaimed value) {
        this.totTaxreliefClaimed = value;
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
     *         &lt;element name="ReliefClaimed90Or90A">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ReliefClaimedUs91">
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
        "reliefClaimed90Or90A",
        "reliefClaimedUs91"
    })
    public static class TotTaxreliefClaimed {

        @XmlElement(name = "ReliefClaimed90Or90A", required = true)
        protected BigInteger reliefClaimed90Or90A;
        @XmlElement(name = "ReliefClaimedUs91", required = true)
        protected BigInteger reliefClaimedUs91;

        /**
         * Gets the value of the reliefClaimed90Or90A property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getReliefClaimed90Or90A() {
            return reliefClaimed90Or90A;
        }

        /**
         * Sets the value of the reliefClaimed90Or90A property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setReliefClaimed90Or90A(BigInteger value) {
            this.reliefClaimed90Or90A = value;
        }

        /**
         * Gets the value of the reliefClaimedUs91 property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getReliefClaimedUs91() {
            return reliefClaimedUs91;
        }

        /**
         * Sets the value of the reliefClaimedUs91 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setReliefClaimedUs91(BigInteger value) {
            this.reliefClaimedUs91 = value;
        }

    }

}
