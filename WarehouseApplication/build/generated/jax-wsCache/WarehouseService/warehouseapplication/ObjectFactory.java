
package warehouseapplication;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the warehouseapplication package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddWarehouseMaterialResponse_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "addWarehouseMaterialResponse");
    private final static QName _GetWarehouseResponse_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "getWarehouseResponse");
    private final static QName _GetMaterialResponse_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "getMaterialResponse");
    private final static QName _AddWarehouseResponse_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "addWarehouseResponse");
    private final static QName _GetWarehouseMaterialListResponse_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "getWarehouseMaterialListResponse");
    private final static QName _AddMaterialResponse_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "addMaterialResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: warehouseapplication
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddMaterialRequest }
     * 
     */
    public AddMaterialRequest createAddMaterialRequest() {
        return new AddMaterialRequest();
    }

    /**
     * Create an instance of {@link GetWarehouseRequest }
     * 
     */
    public GetWarehouseRequest createGetWarehouseRequest() {
        return new GetWarehouseRequest();
    }

    /**
     * Create an instance of {@link AddWarehouseMaterialRequest }
     * 
     */
    public AddWarehouseMaterialRequest createAddWarehouseMaterialRequest() {
        return new AddWarehouseMaterialRequest();
    }

    /**
     * Create an instance of {@link GetMaterialListRequest }
     * 
     */
    public GetMaterialListRequest createGetMaterialListRequest() {
        return new GetMaterialListRequest();
    }

    /**
     * Create an instance of {@link GetMaterialRequest }
     * 
     */
    public GetMaterialRequest createGetMaterialRequest() {
        return new GetMaterialRequest();
    }

    /**
     * Create an instance of {@link MaterialType }
     * 
     */
    public MaterialType createMaterialType() {
        return new MaterialType();
    }

    /**
     * Create an instance of {@link WarehouseType }
     * 
     */
    public WarehouseType createWarehouseType() {
        return new WarehouseType();
    }

    /**
     * Create an instance of {@link GetWarehouseListResponse }
     * 
     */
    public GetWarehouseListResponse createGetWarehouseListResponse() {
        return new GetWarehouseListResponse();
    }

    /**
     * Create an instance of {@link GetWarehouseListRequest }
     * 
     */
    public GetWarehouseListRequest createGetWarehouseListRequest() {
        return new GetWarehouseListRequest();
    }

    /**
     * Create an instance of {@link WarehouseMaterialType }
     * 
     */
    public WarehouseMaterialType createWarehouseMaterialType() {
        return new WarehouseMaterialType();
    }

    /**
     * Create an instance of {@link GetWarehouseMaterialListRequest }
     * 
     */
    public GetWarehouseMaterialListRequest createGetWarehouseMaterialListRequest() {
        return new GetWarehouseMaterialListRequest();
    }

    /**
     * Create an instance of {@link GetMaterialListResponse }
     * 
     */
    public GetMaterialListResponse createGetMaterialListResponse() {
        return new GetMaterialListResponse();
    }

    /**
     * Create an instance of {@link WarehouseMaterialListType }
     * 
     */
    public WarehouseMaterialListType createWarehouseMaterialListType() {
        return new WarehouseMaterialListType();
    }

    /**
     * Create an instance of {@link AddWarehouseRequest }
     * 
     */
    public AddWarehouseRequest createAddWarehouseRequest() {
        return new AddWarehouseRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WarehouseMaterialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/warehouse", name = "addWarehouseMaterialResponse")
    public JAXBElement<WarehouseMaterialType> createAddWarehouseMaterialResponse(WarehouseMaterialType value) {
        return new JAXBElement<WarehouseMaterialType>(_AddWarehouseMaterialResponse_QNAME, WarehouseMaterialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WarehouseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/warehouse", name = "getWarehouseResponse")
    public JAXBElement<WarehouseType> createGetWarehouseResponse(WarehouseType value) {
        return new JAXBElement<WarehouseType>(_GetWarehouseResponse_QNAME, WarehouseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaterialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/warehouse", name = "getMaterialResponse")
    public JAXBElement<MaterialType> createGetMaterialResponse(MaterialType value) {
        return new JAXBElement<MaterialType>(_GetMaterialResponse_QNAME, MaterialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WarehouseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/warehouse", name = "addWarehouseResponse")
    public JAXBElement<WarehouseType> createAddWarehouseResponse(WarehouseType value) {
        return new JAXBElement<WarehouseType>(_AddWarehouseResponse_QNAME, WarehouseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WarehouseMaterialListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/warehouse", name = "getWarehouseMaterialListResponse")
    public JAXBElement<WarehouseMaterialListType> createGetWarehouseMaterialListResponse(WarehouseMaterialListType value) {
        return new JAXBElement<WarehouseMaterialListType>(_GetWarehouseMaterialListResponse_QNAME, WarehouseMaterialListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaterialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/warehouse", name = "addMaterialResponse")
    public JAXBElement<MaterialType> createAddMaterialResponse(MaterialType value) {
        return new JAXBElement<MaterialType>(_AddMaterialResponse_QNAME, MaterialType.class, null, value);
    }

}
