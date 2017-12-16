
package warehouseapplication;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warehouseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warehouseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="warehouseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="warehouseAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="warehouseCapacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="warehouseArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="warehouseMaterialList" type="{http://www.ttu.ee/idu0075/warehouse}warehouseMaterialListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warehouseType", propOrder = {
    "id",
    "warehouseName",
    "warehouseAddress",
    "warehouseCapacity",
    "warehouseArea",
    "warehouseMaterialList"
})
public class WarehouseType {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String warehouseName;
    @XmlElement(required = true)
    protected String warehouseAddress;
    protected double warehouseCapacity;
    protected double warehouseArea;
    @XmlElement(required = true)
    protected WarehouseMaterialListType warehouseMaterialList;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the warehouseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * Sets the value of the warehouseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarehouseName(String value) {
        this.warehouseName = value;
    }

    /**
     * Gets the value of the warehouseAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    /**
     * Sets the value of the warehouseAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarehouseAddress(String value) {
        this.warehouseAddress = value;
    }

    /**
     * Gets the value of the warehouseCapacity property.
     * 
     */
    public double getWarehouseCapacity() {
        return warehouseCapacity;
    }

    /**
     * Sets the value of the warehouseCapacity property.
     * 
     */
    public void setWarehouseCapacity(double value) {
        this.warehouseCapacity = value;
    }

    /**
     * Gets the value of the warehouseArea property.
     * 
     */
    public double getWarehouseArea() {
        return warehouseArea;
    }

    /**
     * Sets the value of the warehouseArea property.
     * 
     */
    public void setWarehouseArea(double value) {
        this.warehouseArea = value;
    }

    /**
     * Gets the value of the warehouseMaterialList property.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseMaterialListType }
     *     
     */
    public WarehouseMaterialListType getWarehouseMaterialList() {
        return warehouseMaterialList;
    }

    /**
     * Sets the value of the warehouseMaterialList property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseMaterialListType }
     *     
     */
    public void setWarehouseMaterialList(WarehouseMaterialListType value) {
        this.warehouseMaterialList = value;
    }

}
