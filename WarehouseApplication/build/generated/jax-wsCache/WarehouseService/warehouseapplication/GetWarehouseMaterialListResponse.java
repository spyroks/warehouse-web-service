
package warehouseapplication;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="warehouseMaterials" type="{http://www.ttu.ee/idu0075/warehouse}warehouseMaterialListType"/>
 *           &lt;element name="error" type="{http://www.ttu.ee/idu0075/warehouse}errorType"/>
 *         &lt;/choice>
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
    "warehouseMaterials",
    "error"
})
@XmlRootElement(name = "getWarehouseMaterialListResponse")
public class GetWarehouseMaterialListResponse {

    protected WarehouseMaterialListType warehouseMaterials;
    protected ErrorType error;

    /**
     * Gets the value of the warehouseMaterials property.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseMaterialListType }
     *     
     */
    public WarehouseMaterialListType getWarehouseMaterials() {
        return warehouseMaterials;
    }

    /**
     * Sets the value of the warehouseMaterials property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseMaterialListType }
     *     
     */
    public void setWarehouseMaterials(WarehouseMaterialListType value) {
        this.warehouseMaterials = value;
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
