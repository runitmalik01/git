
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR5}ITR5" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR6}ITR6" maxOccurs="unbounded" minOccurs="0"/>
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
    "itr5",
    "itr6"
})
@XmlRootElement(name = "ITR", namespace = "http://incometaxindiaefiling.gov.in/main")
public class ITR {

    @XmlElement(name = "ITR5", namespace = "http://incometaxindiaefiling.gov.in/ITR5")
    protected List<ITR5> itr5;
    @XmlElement(name = "ITR6", namespace = "http://incometaxindiaefiling.gov.in/ITR6")
    protected List<ITR6> itr6;

    /**
     * Gets the value of the itr5 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr5 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR5().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR5 }
     * 
     * 
     */
    public List<ITR5> getITR5() {
        if (itr5 == null) {
            itr5 = new ArrayList<ITR5>();
        }
        return this.itr5;
    }

    /**
     * Gets the value of the itr6 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr6 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR6().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR6 }
     * 
     * 
     */
    public List<ITR6> getITR6() {
        if (itr6 == null) {
            itr6 = new ArrayList<ITR6>();
        }
        return this.itr6;
    }

}
