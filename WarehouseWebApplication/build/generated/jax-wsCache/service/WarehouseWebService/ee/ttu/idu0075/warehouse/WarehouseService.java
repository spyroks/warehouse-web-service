
package ee.ttu.idu0075.warehouse;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WarehouseService", targetNamespace = "http://www.ttu.ee/idu0075/warehouse", wsdlLocation = "file:/Users/spyrox/Desktop/Veebiteenused/Warehouse/src/conf/xml-resources/web-services/WarehouseWebService/wsdl/WarehouseService.wsdl")
public class WarehouseService
    extends Service
{

    private final static URL WAREHOUSESERVICE_WSDL_LOCATION;
    private final static WebServiceException WAREHOUSESERVICE_EXCEPTION;
    private final static QName WAREHOUSESERVICE_QNAME = new QName("http://www.ttu.ee/idu0075/warehouse", "WarehouseService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/spyrox/Desktop/Veebiteenused/Warehouse/src/conf/xml-resources/web-services/WarehouseWebService/wsdl/WarehouseService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WAREHOUSESERVICE_WSDL_LOCATION = url;
        WAREHOUSESERVICE_EXCEPTION = e;
    }

    public WarehouseService() {
        super(__getWsdlLocation(), WAREHOUSESERVICE_QNAME);
    }

    public WarehouseService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WAREHOUSESERVICE_QNAME, features);
    }

    public WarehouseService(URL wsdlLocation) {
        super(wsdlLocation, WAREHOUSESERVICE_QNAME);
    }

    public WarehouseService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WAREHOUSESERVICE_QNAME, features);
    }

    public WarehouseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WarehouseService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WarehousePortType
     */
    @WebEndpoint(name = "WarehousePort")
    public WarehousePortType getWarehousePort() {
        return super.getPort(new QName("http://www.ttu.ee/idu0075/warehouse", "WarehousePort"), WarehousePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WarehousePortType
     */
    @WebEndpoint(name = "WarehousePort")
    public WarehousePortType getWarehousePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.ttu.ee/idu0075/warehouse", "WarehousePort"), WarehousePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WAREHOUSESERVICE_EXCEPTION!= null) {
            throw WAREHOUSESERVICE_EXCEPTION;
        }
        return WAREHOUSESERVICE_WSDL_LOCATION;
    }

}
