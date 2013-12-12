
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
 *         &lt;element name="LiableSec44AAflg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LiableSec44ABflg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditedByAccountantFlg" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="Y|N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AuditInfo" minOccurs="0"/>
 *         &lt;element name="RepSec92EFlag">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="YES"/>
 *               &lt;enumeration value="NO"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AuditDetails" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}NatOfBus"/>
 *         &lt;element name="PrevYrMemPartChange">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}PartnerOrMemberInfo" maxOccurs="unbounded"/>
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
    "liableSec44AAflg",
    "liableSec44ABflg",
    "auditedByAccountantFlg",
    "auditInfo",
    "repSec92EFlag",
    "auditDetails",
    "natOfBus",
    "prevYrMemPartChange",
    "partnerOrMemberInfo"
})
@XmlRootElement(name = "PartA_GEN2")
public class PartAGEN2 {

    @XmlElement(name = "LiableSec44AAflg", required = true, defaultValue = "N")
    protected String liableSec44AAflg;
    @XmlElement(name = "LiableSec44ABflg", required = true, defaultValue = "N")
    protected String liableSec44ABflg;
    @XmlElement(name = "AuditedByAccountantFlg")
    protected String auditedByAccountantFlg;
    @XmlElement(name = "AuditInfo")
    protected AuditInfo auditInfo;
    @XmlElement(name = "RepSec92EFlag", required = true)
    protected String repSec92EFlag;
    @XmlElement(name = "AuditDetails")
    protected List<AuditDetails> auditDetails;
    @XmlElement(name = "NatOfBus", required = true)
    protected NatOfBus natOfBus;
    @XmlElement(name = "PrevYrMemPartChange", required = true, defaultValue = "N")
    protected String prevYrMemPartChange;
    @XmlElement(name = "PartnerOrMemberInfo", required = true)
    protected List<PartnerOrMemberInfo> partnerOrMemberInfo;

    /**
     * Gets the value of the liableSec44AAflg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiableSec44AAflg() {
        return liableSec44AAflg;
    }

    /**
     * Sets the value of the liableSec44AAflg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiableSec44AAflg(String value) {
        this.liableSec44AAflg = value;
    }

    /**
     * Gets the value of the liableSec44ABflg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiableSec44ABflg() {
        return liableSec44ABflg;
    }

    /**
     * Sets the value of the liableSec44ABflg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiableSec44ABflg(String value) {
        this.liableSec44ABflg = value;
    }

    /**
     * Gets the value of the auditedByAccountantFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditedByAccountantFlg() {
        return auditedByAccountantFlg;
    }

    /**
     * Sets the value of the auditedByAccountantFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditedByAccountantFlg(String value) {
        this.auditedByAccountantFlg = value;
    }

    /**
     * Gets the value of the auditInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AuditInfo }
     *     
     */
    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    /**
     * Sets the value of the auditInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditInfo }
     *     
     */
    public void setAuditInfo(AuditInfo value) {
        this.auditInfo = value;
    }

    /**
     * Gets the value of the repSec92EFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepSec92EFlag() {
        return repSec92EFlag;
    }

    /**
     * Sets the value of the repSec92EFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepSec92EFlag(String value) {
        this.repSec92EFlag = value;
    }

    /**
     * Gets the value of the auditDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auditDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuditDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuditDetails }
     * 
     * 
     */
    public List<AuditDetails> getAuditDetails() {
        if (auditDetails == null) {
            auditDetails = new ArrayList<AuditDetails>();
        }
        return this.auditDetails;
    }

    /**
     * Gets the value of the natOfBus property.
     * 
     * @return
     *     possible object is
     *     {@link NatOfBus }
     *     
     */
    public NatOfBus getNatOfBus() {
        return natOfBus;
    }

    /**
     * Sets the value of the natOfBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatOfBus }
     *     
     */
    public void setNatOfBus(NatOfBus value) {
        this.natOfBus = value;
    }

    /**
     * Gets the value of the prevYrMemPartChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevYrMemPartChange() {
        return prevYrMemPartChange;
    }

    /**
     * Sets the value of the prevYrMemPartChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevYrMemPartChange(String value) {
        this.prevYrMemPartChange = value;
    }

    /**
     * Gets the value of the partnerOrMemberInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partnerOrMemberInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartnerOrMemberInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartnerOrMemberInfo }
     * 
     * 
     */
    public List<PartnerOrMemberInfo> getPartnerOrMemberInfo() {
        if (partnerOrMemberInfo == null) {
            partnerOrMemberInfo = new ArrayList<PartnerOrMemberInfo>();
        }
        return this.partnerOrMemberInfo;
    }

}
