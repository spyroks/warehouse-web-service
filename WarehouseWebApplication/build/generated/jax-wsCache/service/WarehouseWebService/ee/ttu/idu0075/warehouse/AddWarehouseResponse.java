
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
 *         &lt;sequence&gt;
 *           &lt;element name="warehouse" type="{http://www.ttu.ee/idu0075/warehouse}warehouseType"/&gt;
 *           &lt;element name="state" type="{http://www.ttu.ee/idu0075/warehouse}warehouseStateType"/&gt;
 *         &lt;/sequence&gt;
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
    "warehouse",
    "state"
})
@XmlRootElement(name = "addWarehouseResponse")
public class AddWarehouseResponse {

    @XmlElement(required = true)
    protected WarehouseType warehouse;
    @XmlElement(required = true)
    protected WarehouseStateType state;

    /**
     * Gets the value of the warehouse property.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseType }
     *     
     */
    public WarehouseType getWarehouse() {
        return warehouse;
    }

    /**
     * Sets the value of the warehouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseType }
     *     
     */
    public void setWarehouse(WarehouseType value) {
        this.warehouse = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseStateType }
     *     
     */
    public WarehouseStateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseStateType }
     *     
     */
    public void setState(WarehouseStateType value) {
        this.state = value;
    }

}
