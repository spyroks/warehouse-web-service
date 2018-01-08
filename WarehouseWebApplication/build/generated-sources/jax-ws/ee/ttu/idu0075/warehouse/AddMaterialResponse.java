
package ee.ttu.idu0075.warehouse;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="material" type="{http://www.ttu.ee/idu0075/warehouse}materialType"/&gt;
 *         &lt;element name="state" type="{http://www.ttu.ee/idu0075/warehouse}materialStateType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "material",
    "state"
})
@XmlRootElement(name = "addMaterialResponse")
public class AddMaterialResponse {

    @XmlElement(required = true)
    protected MaterialType material;
    @XmlElement(required = true)
    protected MaterialStateType state;

    /**
     * Gets the value of the material property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialType }
     *     
     */
    public MaterialType getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialType }
     *     
     */
    public void setMaterial(MaterialType value) {
        this.material = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialStateType }
     *     
     */
    public MaterialStateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialStateType }
     *     
     */
    public void setState(MaterialStateType value) {
        this.state = value;
    }

}
