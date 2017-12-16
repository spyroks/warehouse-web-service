/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import warehouseapplication.AddMaterialRequest;
import warehouseapplication.GetMaterialListRequest;
import warehouseapplication.GetMaterialListResponse;
import warehouseapplication.GetMaterialRequest;
import warehouseapplication.MaterialType;
import warehouseapplication.WarehousePortType;
import warehouseapplication.WarehouseService;

/**
 *
 * @author spyrox
 */
public class WarehouseApplication {

    private static final String API_TOKEN = "salajane";
    private static int nextMaterialId = 1;
    private static final List<MaterialType> materialList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String number = "";
        String name;
        String code;
        String composition;
        String durability;
        String id;
        boolean isDone = true;

        System.out.println("Possible operations to choose");
        System.out.println("'1' - addMaterial operation");
        System.out.println("'2' - getMaterial operation");
        System.out.println("'3' - getMaterialList operation");
        while (isDone) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation number: ");
            String temp = scanner.nextLine();
            if (temp.trim().equals("1")
                || temp.trim().equals("2")
                || temp.trim().equals("3")) {
                number = temp.trim();
                System.out.println(getOperation(number) + " operation selected!");
            } else {
                System.out.println("Invalid operation number, try again!");
                System.out.println("Enter operation number: ");
                scanner.nextLine();
            }
            switch (number) {
                case "1":
                    System.out.println("Enter material name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter material code: ");
                    code = scanner.nextLine();    
                    System.out.println("Enter material composition (glass, metal, wood, plastic): ");
                    composition = scanner.nextLine();
                    System.out.println("Enter material durability (low/medium/high): ");
                    durability = scanner.nextLine();
                    AddMaterialRequest amr = new AddMaterialRequest();
                    amr.setToken(API_TOKEN);
                    amr.setName(name);
                    amr.setCode(code);
                    amr.setComposition(composition);
                    amr.setDurability(durability);
                    addMaterial(amr);
                    System.out.println("Material successfully added!");
                    isDone = false;
                    break;
                case "2":
                    System.out.println("Enter material id: ");
                    String check = scanner.nextLine().trim();
                    if (check != null && check.matches("[-+]?\\d*\\.?\\d+")) {
                        id = check;
                        GetMaterialRequest gmr = new GetMaterialRequest();
                        gmr.setToken(API_TOKEN);
                        gmr.setId(BigInteger.valueOf(Integer.valueOf(id)));
                        MaterialType mt = getMaterial(gmr);
                        if (mt != null) {
                        System.out.println("Material id: " + mt.getId()
                                + "\n Material name: " + mt.getName()
                                + "\n Material code: " + mt.getCode()
                                + "\n Material composition: " + mt.getComposition()
                                + "\n Material durability: " + mt.getDurability());
                        } else {
                            System.out.println("Materail with such id does not exist.");
                            isDone = false;
                            break;
                        }
                    }
                    System.out.println("Invalid input!");
                    isDone = false;
                    break;
                case "3":
                    GetMaterialListRequest gmlr = new GetMaterialListRequest();
                    gmlr.setToken(API_TOKEN);
                    getMaterialList(gmlr).getMaterial().forEach((material) -> {
                        System.out.println("Id: " + material.getId() 
                                + "  Name: " + material.getName()
                                + "  Code: " + material.getCode()
                                + "  Composition: " + material.getComposition()
                                + "  Durability: " + material.getDurability());
                    });
                    isDone = false;
                    break;
                default:
                    System.out.println("Invalid operation number! Number must be in range [1...3]");
                    isDone = false;
                    break;
            }
        }
    }

    /**
     *
     * @param parameter
     * @return add material
     */
    private static MaterialType addMaterial(AddMaterialRequest parameter) {
        WarehouseService service = new WarehouseService();
        WarehousePortType port = service.getWarehousePort();
        return port.addMaterial(parameter);
    }

    /**
     *
     * @param parameter
     * @return single material
     */
    private static MaterialType getMaterial(GetMaterialRequest parameter) {
        WarehouseService service = new WarehouseService();
        WarehousePortType port = service.getWarehousePort();
        return port.getMaterial(parameter);
    }

    /**
     *
     * @param parameter
     * @return material list
     */
    private static GetMaterialListResponse getMaterialList(GetMaterialListRequest parameter) {
        WarehouseService service = new WarehouseService();
        WarehousePortType port = service.getWarehousePort();
        return port.getMaterialList(parameter);
    }

    /**
     * Current operation checker
     * @param number
     * @return operation name
     */
    private static String getOperation(String number) {
        switch (number) {
            case "1":
                return "addMaterial";
            case "2":
                return "getMaterial";
            default:
                return "getMaterialList";
        }
    }
}
