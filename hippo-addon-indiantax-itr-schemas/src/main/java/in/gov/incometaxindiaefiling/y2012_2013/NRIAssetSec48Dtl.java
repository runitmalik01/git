
package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element name="NRI111AApplicable">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NRI111ANotApplicable">
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
    "nri111AApplicable",
    "nri111ANotApplicable"
})
@XmlRootElement(name = "NRIAssetSec48Dtl")
public class NRIAssetSec48Dtl {

    @XmlElement(name = "NRI111AApplicable")
    protected long nri111AApplicable;
    @XmlElement(name = "NRI111ANotApplicable")
    protected long nri111ANotApplicable;

    /**
     * Gets the value of the nri111AApplicable property.
     * 
     */
    public long getNRI111AApplicable() {
        return nri111AApplicable;
    }

    /**
     * Sets the value of the nri111AApplicable property.
     * 
     */
    public void setNRI111AApplicable(long value) {
        this.nri111AApplicable = value;
    }

    /**
     * Gets the value of the nri111ANotApplicable property.
     * 
     */
    public long getNRI111ANotApplicable() {
        return nri111ANotApplicable;
    }

    /**
     * Sets the value of the nri111ANotApplicable property.
     * 
     */
    public void setNRI111ANotApplicable(long value) {
        this.nri111ANotApplicable = value;
    }

}
