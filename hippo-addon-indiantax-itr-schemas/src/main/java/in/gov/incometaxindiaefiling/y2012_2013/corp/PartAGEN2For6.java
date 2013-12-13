
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}HoldingStatus"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}BusOrganisation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}KeyPersons" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ShareHolderInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}NatureOfComp"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}NatOfBus"/>
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
    "holdingStatus",
    "busOrganisation",
    "keyPersons",
    "shareHolderInfo",
    "natureOfComp",
    "natOfBus"
})
@XmlRootElement(name = "PartA_GEN2For6")
public class PartAGEN2For6 {

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
    @XmlElement(name = "HoldingStatus", required = true)
    protected HoldingStatus holdingStatus;
    @XmlElement(name = "BusOrganisation")
    protected List<BusOrganisation> busOrganisation;
    @XmlElement(name = "KeyPersons", required = true)
    protected List<KeyPersons> keyPersons;
    @XmlElement(name = "ShareHolderInfo")
    protected List<ShareHolderInfo> shareHolderInfo;
    @XmlElement(name = "NatureOfComp", required = true)
    protected NatureOfComp natureOfComp;
    @XmlElement(name = "NatOfBus", required = true)
    protected NatOfBus natOfBus;

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
     * Gets the value of the holdingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link HoldingStatus }
     *     
     */
    public HoldingStatus getHoldingStatus() {
        return holdingStatus;
    }

    /**
     * Sets the value of the holdingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link HoldingStatus }
     *     
     */
    public void setHoldingStatus(HoldingStatus value) {
        this.holdingStatus = value;
    }

    /**
     * Gets the value of the busOrganisation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busOrganisation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusOrganisation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusOrganisation }
     * 
     * 
     */
    public List<BusOrganisation> getBusOrganisation() {
        if (busOrganisation == null) {
            busOrganisation = new ArrayList<BusOrganisation>();
        }
        return this.busOrganisation;
    }

    /**
     * Gets the value of the keyPersons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyPersons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyPersons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyPersons }
     * 
     * 
     */
    public List<KeyPersons> getKeyPersons() {
        if (keyPersons == null) {
            keyPersons = new ArrayList<KeyPersons>();
        }
        return this.keyPersons;
    }

    /**
     * Gets the value of the shareHolderInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shareHolderInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShareHolderInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShareHolderInfo }
     * 
     * 
     */
    public List<ShareHolderInfo> getShareHolderInfo() {
        if (shareHolderInfo == null) {
            shareHolderInfo = new ArrayList<ShareHolderInfo>();
        }
        return this.shareHolderInfo;
    }

    /**
     * Gets the value of the natureOfComp property.
     * 
     * @return
     *     possible object is
     *     {@link NatureOfComp }
     *     
     */
    public NatureOfComp getNatureOfComp() {
        return natureOfComp;
    }

    /**
     * Sets the value of the natureOfComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureOfComp }
     *     
     */
    public void setNatureOfComp(NatureOfComp value) {
        this.natureOfComp = value;
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

}
