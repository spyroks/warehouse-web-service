
package warehouseapplication;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warehouseMaterialListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warehouseMaterialListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="warehouseMaterial" type="{http://www.ttu.ee/idu0075/warehouse}warehouseMaterialType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warehouseMaterialListType", propOrder = {
    "warehouseMaterial"
})
public class WarehouseMaterialListType {

    protected List<WarehouseMaterialType> warehouseMaterial;

    /**
     * Gets the value of the warehouseMaterial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warehouseMaterial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarehouseMaterial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarehouseMaterialType }
     * 
     * 
     */
    public List<WarehouseMaterialType> getWarehouseMaterial() {
        if (warehouseMaterial == null) {
            warehouseMaterial = new ArrayList<WarehouseMaterialType>();
        }
        return this.warehouseMaterial;
    }

}
