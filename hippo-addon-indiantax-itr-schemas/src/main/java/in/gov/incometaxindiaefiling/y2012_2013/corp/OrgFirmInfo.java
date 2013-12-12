
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AssesseeName"/>
 *         &lt;element name="PAN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}Address"/>
 *         &lt;element name="DateOFFormOrIncorp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;maxInclusive value="2013-03-31"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="StatusOrCompanyType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DomesticCompFlg" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
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
    "assesseeName",
    "pan",
    "address",
    "dateOFFormOrIncorp",
    "statusOrCompanyType",
    "domesticCompFlg"
})
@XmlRootElement(name = "OrgFirmInfo")
public class OrgFirmInfo {

    @XmlElement(name = "AssesseeName", required = true)
    protected AssesseeName assesseeName;
    @XmlElement(name = "PAN", required = true)
    protected String pan;
    @XmlElement(name = "Address", required = true)
    protected Address address;
    @XmlElement(name = "DateOFFormOrIncorp", required = true)
    protected XMLGregorianCalendar dateOFFormOrIncorp;
    @XmlElement(name = "StatusOrCompanyType", required = true, defaultValue = "1")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String statusOrCompanyType;
    @XmlElement(name = "DomesticCompFlg", defaultValue = "Y")
    protected String domesticCompFlg;

    /**
     * Assessee name with Sur Name or Org Name
     * 							mandatory.
     * 						
     * 
     * @return
     *     possible object is
     *     {@link AssesseeName }
     *     
     */
    public AssesseeName getAssesseeName() {
        return assesseeName;
    }

    /**
     * Sets the value of the assesseeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssesseeName }
     *     
     */
    public void setAssesseeName(AssesseeName value) {
        this.assesseeName = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     *  Address of assessee
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the dateOFFormOrIncorp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOFFormOrIncorp() {
        return dateOFFormOrIncorp;
    }

    /**
     * Sets the value of the dateOFFormOrIncorp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOFFormOrIncorp(XMLGregorianCalendar value) {
        this.dateOFFormOrIncorp = value;
    }

    /**
     * Gets the value of the statusOrCompanyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusOrCompanyType() {
        return statusOrCompanyType;
    }

    /**
     * Sets the value of the statusOrCompanyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusOrCompanyType(String value) {
        this.statusOrCompanyType = value;
    }

    /**
     * Gets the value of the domesticCompFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticCompFlg() {
        return domesticCompFlg;
    }

    /**
     * Sets the value of the domesticCompFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticCompFlg(String value) {
        this.domesticCompFlg = value;
    }

}
