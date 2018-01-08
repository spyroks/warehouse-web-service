
package ee.ttu.idu0075.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;choice&gt;
 *           &lt;element name="warehouse" type="{http://www.ttu.ee/idu0075/warehouse}warehouseType"/&gt;
 *           &lt;element name="error" type="{http://www.ttu.ee/idu0075/warehouse}errorType"/&gt;
 *         &lt;/choice&gt;
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
    "error"
})
@XmlRootElement(name = "getWarehouseResponse")
public class GetWarehouseResponse {

    protected WarehouseType warehouse;
    protected ErrorType error;

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
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setError(ErrorType value) {
        this.error = value;
    }

}
