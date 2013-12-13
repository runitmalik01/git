
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import java.math.BigDecimal;
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
 *         &lt;element name="CompName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="125"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CompPAN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AddressDetail"/>
 *         &lt;element name="CompSharePercent" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="5"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="100"/>
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
    "compName",
    "compPAN",
    "addressDetail",
    "compSharePercent"
})
@XmlRootElement(name = "CompDetails")
public class CompDetails {

    @XmlElement(name = "CompName", required = true)
    protected String compName;
    @XmlElement(name = "CompPAN")
    protected String compPAN;
    @XmlElement(name = "AddressDetail", required = true)
    protected AddressDetail addressDetail;
    @XmlElement(name = "CompSharePercent", defaultValue = "0")
    protected BigDecimal compSharePercent;

    /**
     * Gets the value of the compName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompName() {
        return compName;
    }

    /**
     * Sets the value of the compName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompName(String value) {
        this.compName = value;
    }

    /**
     * Gets the value of the compPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompPAN() {
        return compPAN;
    }

    /**
     * Sets the value of the compPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompPAN(String value) {
        this.compPAN = value;
    }

    /**
     * Gets the value of the addressDetail property.
     * 
     * @return
     *     possible object is
     *     {@link AddressDetail }
     *     
     */
    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    /**
     * Sets the value of the addressDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressDetail }
     *     
     */
    public void setAddressDetail(AddressDetail value) {
        this.addressDetail = value;
    }

    /**
     * Gets the value of the compSharePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCompSharePercent() {
        return compSharePercent;
    }

    /**
     * Sets the value of the compSharePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCompSharePercent(BigDecimal value) {
        this.compSharePercent = value;
    }

}
