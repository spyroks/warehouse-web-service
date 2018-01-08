/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse;

import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * Warehouses
 * @author spyrox
 */
@Path("warehouses")
public class WarehousesResource {

    @Context
    private UriInfo context;

    private final WarehouseWebService ws;

    /**
     * Creates a new instance of WarehousesResource
     */
    public WarehousesResource() {
        ws = new WarehouseWebService();
    }

    /**
     * Retrieves representation of an instance of WarehousesResource
     * @param token
     * @param hasRelatedMaterials
     * @return an instance of GetWarehouseListResponse
     */
    @GET
    @Produces("application/json")
    public GetWarehouseListResponse getWarehouseList(@QueryParam("token") String token,
            @QueryParam("has_materials") String hasRelatedMaterials) {
        GetWarehouseListRequest request = new GetWarehouseListRequest();
        request.setToken(token);
        request.setHasRelatedMaterials(hasRelatedMaterials);
        return ws.getWarehouseList(request);
    }

    /**
     * Retrieves representation of an instance of WarehousesResource
     * @param id
     * @param token
     * @return an instance of GetWarehouseResponse
     */
    @GET
    @Path("{id : \\d+}")
    @Produces("application/json")
    public GetWarehouseResponse getWarehouse(@PathParam("id") String id,
            @QueryParam("token") String token) {
        GetWarehouseRequest request = new GetWarehouseRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getWarehouse(request);
    }

    /**
     * Retrieves representation of an instance of WarehousesResource
     * @param content
     * @param token
     * @return an instance of AddWarehouseResponse
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public AddWarehouseResponse addWarehouse(WarehouseType content,
            @QueryParam("token") String token) {
        AddWarehouseRequest request = new AddWarehouseRequest();
        request.setToken(token);
        request.setWarehouseName(content.getWarehouseName());
        request.setWarehouseAddress(content.getWarehouseAddress());
        request.setWarehouseCapacity(content.getWarehouseCapacity());
        request.setWarehouseArea(content.getWarehouseArea());
        return ws.addWarehouse(request);    
    }

    /**
     * Retrieves representation of an instance of WarehousesResource
     * @param id
     * @param token
     * @return an instance of GetWarehouseMaterialListResponse
     */
    @GET
    @Path("{id : \\d+}/materials")
    @Produces("application/json")
    public GetWarehouseMaterialListResponse getWarehouseMaterialList(@PathParam("id") String id,
            @QueryParam("token") String token) {
        GetWarehouseMaterialListRequest request = new GetWarehouseMaterialListRequest();
        request.setWarehouseId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getWarehouseMaterialList(request);
    }

    /**
     * Retrieves representation of an instance of WarehousesResource
     * @param content
     * @param token
     * @param id
     * @return an instance of AddWarehouseMaterialResponse
     */
    @POST
    @Path("{id : \\d+}/add_material")
    @Consumes("application/json")
    @Produces("application/json")
    public AddWarehouseMaterialResponse addWarehouseMaterial(AddWarehouseMaterialRequest content,
            @QueryParam("token") String token,
            @PathParam("id") String id) {
        AddWarehouseMaterialRequest request = new AddWarehouseMaterialRequest();
        request.setToken(token);
        request.setWarehouseId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setMaterialId(content.getMaterialId());
        request.setQuantity(content.getQuantity());
        request.setUnitPrice(content.getUnitPrice());
        return ws.addWarehouseMaterial(request);
    }

    /**
     * PUT method for updating or creating an instance of WarehousesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(WarehouseType content) {
    }
}
