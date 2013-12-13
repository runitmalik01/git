
package in.gov.incometaxindiaefiling.y2012_2013.corp;

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
 *         &lt;element name="NatOfCompFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;pattern value="\d"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HoldingCompDetail" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CompDetails"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SubsidiaryCompDetail" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CompDetails"/>
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
    "natOfCompFlg",
    "holdingCompDetail",
    "subsidiaryCompDetail"
})
@XmlRootElement(name = "HoldingStatus")
public class HoldingStatus {

    @XmlElement(name = "NatOfCompFlg", required = true, defaultValue = "4")
    protected String natOfCompFlg;
    @XmlElement(name = "HoldingCompDetail")
    protected List<HoldingStatus.HoldingCompDetail> holdingCompDetail;
    @XmlElement(name = "SubsidiaryCompDetail")
    protected List<HoldingStatus.SubsidiaryCompDetail> subsidiaryCompDetail;

    /**
     * Gets the value of the natOfCompFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNatOfCompFlg() {
        return natOfCompFlg;
    }

    /**
     * Sets the value of the natOfCompFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNatOfCompFlg(String value) {
        this.natOfCompFlg = value;
    }

    /**
     * Gets the value of the holdingCompDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the holdingCompDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHoldingCompDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HoldingStatus.HoldingCompDetail }
     * 
     * 
     */
    public List<HoldingStatus.HoldingCompDetail> getHoldingCompDetail() {
        if (holdingCompDetail == null) {
            holdingCompDetail = new ArrayList<HoldingStatus.HoldingCompDetail>();
        }
        return this.holdingCompDetail;
    }

    /**
     * Gets the value of the subsidiaryCompDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsidiaryCompDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsidiaryCompDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HoldingStatus.SubsidiaryCompDetail }
     * 
     * 
     */
    public List<HoldingStatus.SubsidiaryCompDetail> getSubsidiaryCompDetail() {
        if (subsidiaryCompDetail == null) {
            subsidiaryCompDetail = new ArrayList<HoldingStatus.SubsidiaryCompDetail>();
        }
        return this.subsidiaryCompDetail;
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
     *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CompDetails"/>
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
        "compDetails"
    })
    public static class HoldingCompDetail {

        @XmlElement(name = "CompDetails", required = true)
        protected CompDetails compDetails;

        /**
         * Gets the value of the compDetails property.
         * 
         * @return
         *     possible object is
         *     {@link CompDetails }
         *     
         */
        public CompDetails getCompDetails() {
            return compDetails;
        }

        /**
         * Sets the value of the compDetails property.
         * 
         * @param value
         *     allowed object is
         *     {@link CompDetails }
         *     
         */
        public void setCompDetails(CompDetails value) {
            this.compDetails = value;
        }

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
     *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CompDetails"/>
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
        "compDetails"
    })
    public static class SubsidiaryCompDetail {

        @XmlElement(name = "CompDetails", required = true)
        protected CompDetails compDetails;

        /**
         * Gets the value of the compDetails property.
         * 
         * @return
         *     possible object is
         *     {@link CompDetails }
         *     
         */
        public CompDetails getCompDetails() {
            return compDetails;
        }

        /**
         * Sets the value of the compDetails property.
         * 
         * @param value
         *     allowed object is
         *     {@link CompDetails }
         *     
         */
        public void setCompDetails(CompDetails value) {
            this.compDetails = value;
        }

    }

}
