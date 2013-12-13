
package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR1}ITR1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR2}ITR2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR3}ITR3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR4}ITR4" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/ITR4S}ITR4S" maxOccurs="unbounded" minOccurs="0"/>
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
    "itr1",
    "itr2",
    "itr3",
    "itr4",
    "itr4S"
})
@XmlRootElement(name = "ITR", namespace = "http://incometaxindiaefiling.gov.in/main")
public class ITR {

    @XmlElement(name = "ITR1", namespace = "http://incometaxindiaefiling.gov.in/ITR1")
    protected List<ITR1> itr1;
    @XmlElement(name = "ITR2", namespace = "http://incometaxindiaefiling.gov.in/ITR2")
    protected List<ITR2> itr2;
    @XmlElement(name = "ITR3", namespace = "http://incometaxindiaefiling.gov.in/ITR3")
    protected List<ITR3> itr3;
    @XmlElement(name = "ITR4", namespace = "http://incometaxindiaefiling.gov.in/ITR4")
    protected List<ITR4> itr4;
    @XmlElement(name = "ITR4S", namespace = "http://incometaxindiaefiling.gov.in/ITR4S")
    protected List<ITR4S> itr4S;

    /**
     * Gets the value of the itr1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR1 }
     * 
     * 
     */
    public List<ITR1> getITR1() {
        if (itr1 == null) {
            itr1 = new ArrayList<ITR1>();
        }
        return this.itr1;
    }

    /**
     * Gets the value of the itr2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR2 }
     * 
     * 
     */
    public List<ITR2> getITR2() {
        if (itr2 == null) {
            itr2 = new ArrayList<ITR2>();
        }
        return this.itr2;
    }

    /**
     * Gets the value of the itr3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR3 }
     * 
     * 
     */
    public List<ITR3> getITR3() {
        if (itr3 == null) {
            itr3 = new ArrayList<ITR3>();
        }
        return this.itr3;
    }

    /**
     * Gets the value of the itr4 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr4 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR4().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR4 }
     * 
     * 
     */
    public List<ITR4> getITR4() {
        if (itr4 == null) {
            itr4 = new ArrayList<ITR4>();
        }
        return this.itr4;
    }

    /**
     * Gets the value of the itr4S property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itr4S property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITR4S().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ITR4S }
     * 
     * 
     */
    public List<ITR4S> getITR4S() {
        if (itr4S == null) {
            itr4S = new ArrayList<ITR4S>();
        }
        return this.itr4S;
    }

}
