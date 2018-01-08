/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse.states;

import ee.ttu.idu0075.warehouse.UpdateType;
import java.math.BigInteger;

/**
 *
 * @author spyrox
 */
public class Update {

    public static UpdateType getWarehouseMaterialUpdate() {
        UpdateType update = new UpdateType();
        update.setCode(BigInteger.valueOf(200));
        update.setMessage("OK. WarehouseMaterial updated successfully!");
        return update;
    }
}
