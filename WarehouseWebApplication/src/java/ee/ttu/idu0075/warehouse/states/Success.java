/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse.states;

import ee.ttu.idu0075.warehouse.SuccessType;
import java.math.BigInteger;

/**
 *
 * @author spyrox
 */
public class Success {

    public static SuccessType getWarehouseSuccess() {
        SuccessType success = new SuccessType();
        success.setCode(BigInteger.valueOf(200));
        success.setMessage("OK. Warehouse successfully added!");
        return success;
    }
    
    public static SuccessType getExistingWarehouseSuccess() {
        SuccessType success = new SuccessType();
        success.setCode(BigInteger.valueOf(200));
        success.setMessage("OK. Warehouse with such name already exists!");
        return success;
    }

    public static SuccessType getMaterialSuccess() {
        SuccessType success = new SuccessType();
        success.setCode(BigInteger.valueOf(200));
        success.setMessage("OK. Material successfully added!");
        return success;
    }
    
    public static SuccessType getExistingMaterialSuccess() {
        SuccessType success = new SuccessType();
        success.setCode(BigInteger.valueOf(200));
        success.setMessage("OK. Material with such name or code already exists!");
        return success;
    }

    public static SuccessType getWarehouseMaterialSuccess() {
        SuccessType success = new SuccessType();
        success.setCode(BigInteger.valueOf(200));
        success.setMessage("OK. WarehouseMaterial successfully added!");
        return success;
    }
}
