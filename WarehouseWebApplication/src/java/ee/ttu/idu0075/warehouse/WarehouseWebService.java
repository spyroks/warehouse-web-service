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
import ee.ttu.idu0075.warehouse.states.Success;
import ee.ttu.idu0075.warehouse.states.Error;
import ee.ttu.idu0075.warehouse.states.Update;

/**
 *
 * @author spyrox
 */
@WebService(serviceName = "WarehouseService", portName = "WarehousePort", endpointInterface = "ee.ttu.idu0075.warehouse.WarehousePortType", targetNamespace = "http://www.ttu.ee/idu0075/warehouse", wsdlLocation = "WEB-INF/wsdl/WarehouseWebService/WarehouseService.wsdl")
public class WarehouseWebService {

    private static int nextWarehouseId = 1;
    private static final List<WarehouseType> WAREHOUSES = new ArrayList<>();
    private static int nextMaterialId = 1;
    private static final List<MaterialType> MATERIALS = new ArrayList<>();

    public GetWarehouseResponse getWarehouse(GetWarehouseRequest parameter) {
        GetWarehouseResponse gwr = new GetWarehouseResponse();
        WarehouseType wt;
        if (parameter.getToken() != null && parameter.getId() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                if (WAREHOUSES.size() > 0) {
                    boolean checker = false;
                    for (int i = 0; i < WAREHOUSES.size(); i++) {
                        if (WAREHOUSES.get(i).getId().equals(parameter.getId())) {
                            wt = WAREHOUSES.get(i);
                            gwr.setWarehouse(wt);
                            checker = true;
                            break;
                        }
                    }
                    if (checker == true) {
                        return gwr;
                    } else {
                        gwr.setError(Error.getWarehouseNotFoundError());
                        return gwr;
                    }
                } else {
                    gwr.setError(Error.getEmptyListError());
                    return gwr;
                }
            } else {
                gwr.setError(Error.getAuthError());
                return gwr;
            }
        } else {
            gwr.setError(Error.getRequestError());
            return gwr;
        }
    }

    public AddWarehouseResponse addWarehouse(AddWarehouseRequest parameter) {
        AddWarehouseResponse awr = new AddWarehouseResponse();
        WarehouseType wt = new WarehouseType();
        WarehouseStateType wst = new WarehouseStateType();
        if (parameter.getToken() != null && parameter.getWarehouseName() != null
                && parameter.getWarehouseAddress() != null
                && parameter.getWarehouseCapacity() != 0
                && parameter.getWarehouseArea() != 0) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                if (!parameter.getWarehouseName().trim().equals("")
                        && !parameter.getWarehouseAddress().trim().equals("")
                        && !String.valueOf(parameter.getWarehouseCapacity()).trim().equals("")
                        && !String.valueOf(parameter.getWarehouseArea()).trim().equals("")) {
                    wt.setId(BigInteger.valueOf(nextWarehouseId++));
                    wt.setWarehouseName(parameter.getWarehouseName());
                    wt.setWarehouseAddress(parameter.getWarehouseAddress());
                    wt.setWarehouseCapacity(parameter.getWarehouseCapacity());
                    wt.setWarehouseArea(parameter.getWarehouseArea());
                    wt.setWarehouseMaterialList(new WarehouseMaterialListType());
                    WAREHOUSES.add(wt);
                    awr.setWarehouse(wt);
                    wst.setSuccess(Success.getWarehouseSuccess());
                    awr.setState(wst);
                    return awr;
                } else {
                    wst.setError(Error.getRequestError());
                    awr.setState(wst);
                    return awr;
                }
            } else {
                wst.setError(Error.getAuthError());
                awr.setState(wst);
                return awr;
            }
        } else {
            wst.setError(Error.getRequestError());
            awr.setState(wst);
            return awr;
        }
    }

    public GetWarehouseListResponse getWarehouseList(GetWarehouseListRequest parameter) {
        GetWarehouseListResponse gwlr = new GetWarehouseListResponse();
        if (parameter.getToken() != null && parameter.getHasRelatedMaterials() != null) {
            if (parameter.getHasRelatedMaterials().equals("jah")
                    || parameter.getHasRelatedMaterials().equals("ei")
                    || parameter.getHasRelatedMaterials().equals("")) {
                if (parameter.getToken().equalsIgnoreCase("salajane")) {
                    if (WAREHOUSES.size() > 0) {
                        WAREHOUSES.forEach((warehouseType) -> {
                            String hasRelatedMaterials = parameter.getHasRelatedMaterials();
                            if (hasRelatedMaterials.equals("")) {
                                gwlr.getWarehouses().add(warehouseType);
                            } else if (hasRelatedMaterials.equalsIgnoreCase("jah")) {
                                if (!isWarehouseEmpty(warehouseType)) {
                                    gwlr.getWarehouses().add(warehouseType);
                                }
                            } else if (hasRelatedMaterials.equalsIgnoreCase("ei")) {
                                if (isWarehouseEmpty(warehouseType)) {
                                    gwlr.getWarehouses().add(warehouseType);
                                }
                            }
                        });
                        if (gwlr.getWarehouses().size() > 0) {
                            return gwlr;
                        } else {
                            gwlr.setError(Error.getEmptyListError());
                            return gwlr;
                        }
                    } else {
                        gwlr.setError(Error.getEmptyListError());
                        return gwlr;
                    }
                } else {
                    gwlr.setError(Error.getAuthError());
                    return gwlr;
                }
            } else {
                gwlr.setError(Error.getDoesntMatchRestrictionError());
                return gwlr;
            }
        } else {
            gwlr.setError(Error.getRequestError());
            return gwlr;
        }
    }

    private boolean isWarehouseEmpty(WarehouseType warehouseType) {
        return warehouseType.getWarehouseMaterialList().getWarehouseMaterial().isEmpty();
    }

    public GetMaterialResponse getMaterial(GetMaterialRequest parameter) {
        GetMaterialResponse gmr = new GetMaterialResponse();
        MaterialType mt;
        if (parameter.getToken() != null && parameter.getId() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                if (MATERIALS.size() > 0) {
                    boolean checker = false;
                    for (int i = 0; i < MATERIALS.size(); i++) {
                        if (MATERIALS.get(i).getId().equals(parameter.getId())) {
                            mt = MATERIALS.get(i);
                            gmr.setMaterial(mt);
                            checker = true;
                            break;
                        }
                    }
                    if (checker == true) {
                        return gmr;
                    } else {
                        gmr.setError(Error.getMaterialNotFoundError());
                        return gmr;
                    }
                } else {
                    gmr.setError(Error.getEmptyListError());
                    return gmr;
                }
            } else {
                gmr.setError(Error.getAuthError());
                return gmr;
            }
        } else {
            gmr.setError(Error.getRequestError());
            return gmr;
        }
    }

    public AddMaterialResponse addMaterial(AddMaterialRequest parameter) {
        AddMaterialResponse amr = new AddMaterialResponse();
        MaterialType mt = new MaterialType();
        MaterialStateType mst = new MaterialStateType();
        if (parameter.getToken() != null && parameter.getName() != null
                && parameter.getCode() != null
                && parameter.getComposition() != null
                && parameter.getDurability() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                if (!parameter.getName().trim().equals("") && !parameter.getCode().trim().equals("")
                        && !parameter.getComposition().trim().equals("")
                        && !parameter.getDurability().trim().equals("")) {
                    mt.setName(parameter.getName());
                    mt.setCode(parameter.getCode());
                    mt.setComposition(parameter.getComposition());
                    mt.setDurability(parameter.getDurability());
                    mt.setId(BigInteger.valueOf(nextMaterialId++));
                    MATERIALS.add(mt);
                    amr.setMaterial(mt);
                    mst.setSuccess(Success.getMaterialSuccess());
                    amr.setState(mst);
                    return amr;
                } else {
                    mst.setError(Error.getRequestError());
                    amr.setState(mst);
                    return amr;
                }
            } else {
                mst.setError(Error.getAuthError());
                amr.setState(mst);
                return amr;
            }
        } else {
            mst.setError(Error.getRequestError());
            amr.setState(mst);
            return amr;
        }
    }

    public GetMaterialListResponse getMaterialList(GetMaterialListRequest parameter) {
        GetMaterialListResponse gmlr = new GetMaterialListResponse();
        if (parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                if (MATERIALS.size() > 0) {
                    MATERIALS.forEach((materialType) -> {
                        gmlr.getMaterials().add(materialType);
                    });
                    return gmlr;
                } else {
                    gmlr.setError(Error.getEmptyListError());
                    return gmlr;
                }
            } else {
                gmlr.setError(Error.getAuthError());
                return gmlr;
            }
        } else {
            gmlr.setError(Error.getRequestError());
            return gmlr;
        }
    }

    public GetWarehouseMaterialListResponse getWarehouseMaterialList(GetWarehouseMaterialListRequest parameter) {
        GetWarehouseMaterialListResponse gwmlr = new GetWarehouseMaterialListResponse();
        WarehouseMaterialListType wmlt;
        if (parameter.getToken() != null && parameter.getWarehouseId() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                if (WAREHOUSES.size() > 0) {
                    boolean checker = false;
                    for (int i = 0; i < WAREHOUSES.size(); i++) {
                        if (WAREHOUSES.get(i).getId().equals(parameter.getWarehouseId())) {
                            wmlt = WAREHOUSES.get(i).getWarehouseMaterialList();
                            gwmlr.setWarehouseMaterials(wmlt);
                            checker = true;
                        }
                    }
                    if (checker == true) {
                        if (!gwmlr.getWarehouseMaterials().getWarehouseMaterial().isEmpty()) {
                            return gwmlr;
                        } else {
                            gwmlr.setError(Error.getEmptyListError());
                            return gwmlr;
                        }
                    } else {
                        gwmlr.setError(Error.getWarehouseMaterialNotFoundError());
                        return gwmlr;
                    }
                } else {
                    gwmlr.setError(Error.getEmptyListError());
                    return gwmlr;
                }
            } else {
                gwmlr.setError(Error.getAuthError());
                return gwmlr;
            }
        } else {
            gwmlr.setError(Error.getRequestError());
            return gwmlr;
        }
    }

    public AddWarehouseMaterialResponse addWarehouseMaterial(AddWarehouseMaterialRequest parameter) {
        AddWarehouseMaterialResponse awmr = new AddWarehouseMaterialResponse();
        WarehouseMaterialType wmt = new WarehouseMaterialType();
        WarehouseMaterialStateType wmst = new WarehouseMaterialStateType();
        if (parameter.getToken() != null && parameter.getWarehouseId() != null
                && parameter.getMaterialId() != null
                && parameter.getQuantity() != 0
                && parameter.getUnitPrice() != 0) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                GetMaterialRequest gmr = new GetMaterialRequest();
                gmr.setToken(parameter.getToken());
                gmr.setId(parameter.getMaterialId());
                MaterialType mt = getMaterial(gmr).getMaterial();
                if (mt != null) {
                    wmt.setMaterial(mt);
                    wmt.setQuantity(parameter.getQuantity());
                    wmt.setUnitPrice(parameter.getUnitPrice());
                    if (WAREHOUSES.size() > 0) {
                        boolean checker = false;
                        for (int i = 0; i < WAREHOUSES.size(); i++) {
                            if (WAREHOUSES.get(i).getId().equals(parameter.getWarehouseId())) {
                                if (isWarehouseHasSuchMaterial(parameter) == null) {
                                    WAREHOUSES.get(i).getWarehouseMaterialList().getWarehouseMaterial().add(wmt);
                                    awmr.setWarehouseMaterial(wmt);
                                    wmst.setSuccess(Success.getWarehouseMaterialSuccess());
                                    awmr.setState(wmst);
                                    checker = true;
                                } else {
                                    WAREHOUSES.get(i).getWarehouseMaterialList().getWarehouseMaterial().remove(isWarehouseHasSuchMaterial(parameter));
                                    WAREHOUSES.get(i).getWarehouseMaterialList().getWarehouseMaterial().add(wmt);
                                    awmr.setWarehouseMaterial(wmt);
                                    wmst.setUpdate(Update.getWarehouseMaterialUpdate());
                                    awmr.setState(wmst);
                                    checker = true;
                                }
                            }
                        }
                        if (checker == true) {
                            return awmr;
                        } else {
                            wmst.setError(Error.getWarehouseNotFoundError());
                            awmr.setState(wmst);
                            return awmr;
                        }
                    } else {
                        wmst.setError(Error.getEmptyListError());
                        awmr.setState(wmst);
                        return awmr;
                    }
                } else {
                    wmst.setError(Error.getMaterialNotFoundError());
                    awmr.setState(wmst);
                    return awmr;
                }
            } else {
                wmst.setError(Error.getAuthError());
                awmr.setState(wmst);
                return awmr;
            }
        } else {
            wmst.setError(Error.getRequestError());
            awmr.setState(wmst);
            return awmr;
        }
    }

    private WarehouseMaterialType isWarehouseHasSuchMaterial(AddWarehouseMaterialRequest parameter) {
        WarehouseMaterialType wmt = null;
        for (int k = 0; k < WAREHOUSES.size(); k++) {
            if (WAREHOUSES.get(k).getId().equals(parameter.getWarehouseId())) {
                for (int j = 0; j < WAREHOUSES.get(k).getWarehouseMaterialList().getWarehouseMaterial().size(); j++) {
                    if (WAREHOUSES.get(k).getWarehouseMaterialList().getWarehouseMaterial().get(j).getMaterial().getId().equals(parameter.getMaterialId())) {
                        wmt = WAREHOUSES.get(k).getWarehouseMaterialList().getWarehouseMaterial().get(j);
                    }
                }
            }
        }
        return wmt;
    }
}
