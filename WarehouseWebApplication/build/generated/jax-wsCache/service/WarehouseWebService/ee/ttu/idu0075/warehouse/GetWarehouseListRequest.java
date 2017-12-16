
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
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="warehouseName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="warehouseAddress" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="hasRelatedMaterials" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="jah|ei"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
    "token",
    "warehouseName",
    "warehouseAddress",
    "hasRelatedMaterials"
})
@XmlRootElement(name = "getWarehouseListRequest")
public class GetWarehouseListRequest {

    @XmlElement(required = true)
    protected String token;
    @XmlElement(required = true)
    protected String warehouseName;
    @XmlElement(required = true)
    protected String warehouseAddress;
    protected String hasRelatedMaterials;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
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
     * Gets the value of the hasRelatedMaterials property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasRelatedMaterials() {
        return hasRelatedMaterials;
    }

    /**
     * Sets the value of the hasRelatedMaterials property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasRelatedMaterials(String value) {
        this.hasRelatedMaterials = value;
    }

}
