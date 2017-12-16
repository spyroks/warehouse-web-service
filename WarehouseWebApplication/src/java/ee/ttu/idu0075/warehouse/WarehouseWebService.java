/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author derast
 */
@WebService(serviceName = "WarehouseService", portName = "WarehousePort", endpointInterface = "ee.ttu.idu0075.warehouse.WarehousePortType", targetNamespace = "http://www.ttu.ee/idu0075/warehouse", wsdlLocation = "WEB-INF/wsdl/WarehouseWebService/WarehouseService.wsdl")
public class WarehouseWebService {

    private static int nextMaterialId = 1;
    private static final List<MaterialType> materialList = new ArrayList<>();
    private static int nextWarehouseId = 1;
    private static final List<WarehouseType> warehouseList = new ArrayList<>();

    public MaterialType getMaterial(GetMaterialRequest parameter) {
        MaterialType mt = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < materialList.size(); i++) {
                if (materialList.get(i).getId().equals(parameter.getId())) {
                    mt = materialList.get(i);
                }
            }
        }
        return mt;
    }

    public MaterialType addMaterial(AddMaterialRequest parameter) {
        MaterialType mt = new MaterialType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            mt.setName(parameter.getName());
            mt.setCode(parameter.getCode());
            mt.setComposition(parameter.getComposition());
            mt.setDurability(parameter.getDurability());
            mt.setId(BigInteger.valueOf(nextMaterialId++));
            materialList.add(mt);
        }
        return mt;
    }  

    public GetMaterialListResponse getMaterialList(GetMaterialListRequest parameter) {
        GetMaterialListResponse gmlr = new GetMaterialListResponse();
        if  (parameter.getToken().equalsIgnoreCase("salajane")) {
            materialList.forEach((materialType) -> {
                gmlr.getMaterial().add(materialType);
            });
        }
        return gmlr;
    }

    public WarehouseType getWarehouse(GetWarehouseRequest parameter) {
        WarehouseType wt = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < warehouseList.size(); i++) {
                if (warehouseList.get(i).getId().equals(parameter.getId())) {
                    wt = warehouseList.get(i);
                }
            }    
        }
        return wt;
    }

    public WarehouseType addWarehouse(AddWarehouseRequest parameter) {
        WarehouseType wt = new WarehouseType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            wt.setId(BigInteger.valueOf(nextWarehouseId++));
            wt.setWarehouseName(parameter.getWarehouseName());
            wt.setWarehouseAddress(parameter.getWarehouseAddress());
            wt.setWarehouseCapacity(parameter.getWarehouseCapacity());
            wt.setWarehouseArea(parameter.getWarehouseArea());
            wt.setWarehouseMaterialList(new WarehouseMaterialListType());
            warehouseList.add(wt);
        }
        return wt;
    }

    public GetWarehouseListResponse getWarehouseList(GetWarehouseListRequest parameter) { 
        GetWarehouseListResponse gwlr = new GetWarehouseListResponse(); 
        if (parameter.getToken().equalsIgnoreCase("salajane")) { 
            warehouseList.forEach((warehouseType) -> {
                String hasRelatedMaterials = parameter.getHasRelatedMaterials();
                if (hasRelatedMaterials == null) {
                    gwlr.getWarehouse().add(warehouseType);
                } else if (hasRelatedMaterials.equalsIgnoreCase("jah")) {
                    if (!isWarehouseEmpty(warehouseType)) {
                        gwlr.getWarehouse().add(warehouseType);
                    }
                } else if (hasRelatedMaterials.equalsIgnoreCase("ei")) {
                    if (isWarehouseEmpty(warehouseType)) {
                        gwlr.getWarehouse().add(warehouseType);
                    }
                }
            }); 
        }
        return gwlr; 
    } 

    private boolean isWarehouseEmpty(WarehouseType warehouseType) { 
        return warehouseType.getWarehouseMaterialList().getWarehouseMaterial().isEmpty(); 
    }

    public WarehouseMaterialListType getWarehouseMaterialList(GetWarehouseMaterialListRequest parameter) {
        WarehouseMaterialListType wmlt = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < warehouseList.size(); i++) {
                if (warehouseList.get(i).getId().equals(parameter.getWarehouseId())) {
                    wmlt = warehouseList.get(i).getWarehouseMaterialList();
                }

            }    
        }
        return wmlt;
    }

    public WarehouseMaterialType addWarehouseMaterial(AddWarehouseMaterialRequest parameter) {
        WarehouseMaterialType wm = new WarehouseMaterialType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            GetMaterialRequest mr = new GetMaterialRequest();
            mr.setToken(parameter.getToken());
            mr.setId(parameter.getMaterialId());
            wm.setMaterial(getMaterial(mr));
            wm.setQuantity(parameter.getQuantity());
            wm.setUnitPrice(parameter.getUnitPrice());
            for (int i = 0; i < warehouseList.size(); i++) {
                if (warehouseList.get(i).getId().equals(parameter.getWarehouseId())) {
                    warehouseList.get(i).getWarehouseMaterialList().getWarehouseMaterial().add(wm);
                    return wm;
                }
            } 
        }
        return null;
    }
}
