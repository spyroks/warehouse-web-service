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
 * Materials
 * @author spyrox
 */
@Path("materials")
public class MaterialsResource {

    @Context
    private UriInfo context;

    private WarehouseWebService ws;

    /**
     * Creates a new instance of MaterialsResource
     */
    public MaterialsResource() {
        ws = new WarehouseWebService();
    }

    /**
     * Retrieves representation of an instance of MaterialsResource
     * @param token
     * @return an instance of GetMaterialListResponse
     */
    @GET
    @Produces("application/json")
    public GetMaterialListResponse getMaterialList(@QueryParam("token") String token) {
        GetMaterialListRequest request = new GetMaterialListRequest();
        request.setToken(token);
        return ws.getMaterialList(request);
    }

    /**
     * Retrieves representation of an instance of MaterialsResource
     * @param id
     * @param token
     * @return an instance of GetMaterialResponse
     */
    @GET
    @Path("{id : \\d+}")
    @Produces("application/json")
    public GetMaterialResponse getMaterial(@PathParam("id") String id,
            @QueryParam("token") String token) {
        GetMaterialRequest request = new GetMaterialRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getMaterial(request);
    }

    /**
     * Retrieves representation of an instance of MaterialsResource
     * @param content
     * @param token
     * @return an instance of AddMaterialResponse
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public AddMaterialResponse addMaterial(MaterialType content, 
                                @QueryParam("token") String token) {
        AddMaterialRequest request = new AddMaterialRequest();
        request.setCode(content.getCode());
        request.setName(content.getName());
        request.setComposition(content.getComposition());
        request.setDurability(content.getDurability());
        request.setToken(token);
        return ws.addMaterial(request);
    }

    /**
     * PUT method for updating or creating an instance of MaterialsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(MaterialType content) {
    }
}
