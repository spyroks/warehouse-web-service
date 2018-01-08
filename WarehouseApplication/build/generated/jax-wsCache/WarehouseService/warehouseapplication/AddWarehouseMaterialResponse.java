
package warehouseapplication;

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
 *         &lt;element name="warehouseMaterial" type="{http://www.ttu.ee/idu0075/warehouse}warehouseMaterialType"/>
 *         &lt;element name="state" type="{http://www.ttu.ee/idu0075/warehouse}warehouseMaterialStateType"/>
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
    "warehouseMaterial",
    "state"
})
@XmlRootElement(name = "addWarehouseMaterialResponse")
public class AddWarehouseMaterialResponse {

    @XmlElement(required = true)
    protected WarehouseMaterialType warehouseMaterial;
    @XmlElement(required = true)
    protected WarehouseMaterialStateType state;

    /**
     * Gets the value of the warehouseMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseMaterialType }
     *     
     */
    public WarehouseMaterialType getWarehouseMaterial() {
        return warehouseMaterial;
    }

    /**
     * Sets the value of the warehouseMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseMaterialType }
     *     
     */
    public void setWarehouseMaterial(WarehouseMaterialType value) {
        this.warehouseMaterial = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseMaterialStateType }
     *     
     */
    public WarehouseMaterialStateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseMaterialStateType }
     *     
     */
    public void setState(WarehouseMaterialStateType value) {
        this.state = value;
    }

}
