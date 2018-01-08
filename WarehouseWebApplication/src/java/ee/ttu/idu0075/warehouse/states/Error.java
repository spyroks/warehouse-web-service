/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse.states;

import ee.ttu.idu0075.warehouse.ErrorType;
import java.math.BigInteger;

/**
 *
 * @author spyrox
 */
public class Error {

    public static ErrorType getAuthError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(401));
        error.setMessage("Unauthorized. Token is wrong!");
        return error;
    }

    public static ErrorType getRequestError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(400));
        error.setMessage("Bad Request. Invalid input type or Element is missing!");
        return error;
    }

    public static ErrorType getEmptyListError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(405));
        error.setMessage("Method Not Allowed. List is empty!");
        return error;
    }

    public static ErrorType getWarehouseNotFoundError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(404));
        error.setMessage("Not Found. Warehouse not found!");
        return error;
    }

    public static ErrorType getMaterialNotFoundError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(404));
        error.setMessage("Not Found. Material not found!");
        return error;
    }

    public static ErrorType getWarehouseMaterialNotFoundError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(404));
        error.setMessage("Not Found. WarehouseMaterial not found!");
        return error;
    }
    public static ErrorType getDoesntMatchRestrictionError() {
        ErrorType error = new ErrorType();
        error.setCode(BigInteger.valueOf(406));
        error.setMessage("Not Acceptable. Only acceptable values are \"jah\", \"ei\" or leave this field empty!");
        return error;
    }
}
