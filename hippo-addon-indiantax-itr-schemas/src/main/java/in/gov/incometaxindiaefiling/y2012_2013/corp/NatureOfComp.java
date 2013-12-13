
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
 *         &lt;element name="PubSectCompUs2_36AFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RBICompFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CompLes40PercSharGovRBIFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BankCompUs5Flg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SchedBankOfRBIActFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CompWithIRDARegisterFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NonBankFIICompFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
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
    "pubSectCompUs236AFlg",
    "rbiCompFlg",
    "compLes40PercSharGovRBIFlg",
    "bankCompUs5Flg",
    "schedBankOfRBIActFlg",
    "compWithIRDARegisterFlg",
    "nonBankFIICompFlg"
})
@XmlRootElement(name = "NatureOfComp")
public class NatureOfComp {

    @XmlElement(name = "PubSectCompUs2_36AFlg", required = true, defaultValue = "N")
    protected String pubSectCompUs236AFlg;
    @XmlElement(name = "RBICompFlg", required = true, defaultValue = "N")
    protected String rbiCompFlg;
    @XmlElement(name = "CompLes40PercSharGovRBIFlg", required = true, defaultValue = "N")
    protected String compLes40PercSharGovRBIFlg;
    @XmlElement(name = "BankCompUs5Flg", required = true, defaultValue = "N")
    protected String bankCompUs5Flg;
    @XmlElement(name = "SchedBankOfRBIActFlg", required = true, defaultValue = "N")
    protected String schedBankOfRBIActFlg;
    @XmlElement(name = "CompWithIRDARegisterFlg", required = true, defaultValue = "N")
    protected String compWithIRDARegisterFlg;
    @XmlElement(name = "NonBankFIICompFlg", required = true, defaultValue = "N")
    protected String nonBankFIICompFlg;

    /**
     * Gets the value of the pubSectCompUs236AFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubSectCompUs236AFlg() {
        return pubSectCompUs236AFlg;
    }

    /**
     * Sets the value of the pubSectCompUs236AFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubSectCompUs236AFlg(String value) {
        this.pubSectCompUs236AFlg = value;
    }

    /**
     * Gets the value of the rbiCompFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRBICompFlg() {
        return rbiCompFlg;
    }

    /**
     * Sets the value of the rbiCompFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRBICompFlg(String value) {
        this.rbiCompFlg = value;
    }

    /**
     * Gets the value of the compLes40PercSharGovRBIFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompLes40PercSharGovRBIFlg() {
        return compLes40PercSharGovRBIFlg;
    }

    /**
     * Sets the value of the compLes40PercSharGovRBIFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompLes40PercSharGovRBIFlg(String value) {
        this.compLes40PercSharGovRBIFlg = value;
    }

    /**
     * Gets the value of the bankCompUs5Flg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCompUs5Flg() {
        return bankCompUs5Flg;
    }

    /**
     * Sets the value of the bankCompUs5Flg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCompUs5Flg(String value) {
        this.bankCompUs5Flg = value;
    }

    /**
     * Gets the value of the schedBankOfRBIActFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedBankOfRBIActFlg() {
        return schedBankOfRBIActFlg;
    }

    /**
     * Sets the value of the schedBankOfRBIActFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedBankOfRBIActFlg(String value) {
        this.schedBankOfRBIActFlg = value;
    }

    /**
     * Gets the value of the compWithIRDARegisterFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompWithIRDARegisterFlg() {
        return compWithIRDARegisterFlg;
    }

    /**
     * Sets the value of the compWithIRDARegisterFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompWithIRDARegisterFlg(String value) {
        this.compWithIRDARegisterFlg = value;
    }

    /**
     * Gets the value of the nonBankFIICompFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonBankFIICompFlg() {
        return nonBankFIICompFlg;
    }

    /**
     * Sets the value of the nonBankFIICompFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonBankFIICompFlg(String value) {
        this.nonBankFIICompFlg = value;
    }

}
