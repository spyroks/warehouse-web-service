/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.warehouse;

import java.math.BigInteger;
import java.util.Scanner;
import warehouseapplication.AddMaterialRequest;
import warehouseapplication.AddMaterialResponse;
import warehouseapplication.GetMaterialListRequest;
import warehouseapplication.GetMaterialListResponse;
import warehouseapplication.GetMaterialRequest;
import warehouseapplication.GetMaterialResponse;
import warehouseapplication.WarehousePortType;
import warehouseapplication.WarehouseService;

/**
 *
 * @author spyrox
 */
public class WarehouseApplication {

    private static final String API_TOKEN = "salajane";

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

        System.out.println("Possible operations to choose:");
        System.out.println("'1' - addMaterial operation");
        System.out.println("'2' - getMaterial operation");
        System.out.println("'3' - getMaterialList operation");
        System.out.println("Type 'quit' to finish");
        while (isDone) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation number: ");
            String temp = scanner.nextLine();
            if (temp.trim().equals("1")
                    || temp.trim().equals("2")
                    || temp.trim().equals("3")
                    || temp.trim().equals("quit")) {
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
                    AddMaterialResponse amre = addMaterial(amr);
                    if (amre.getMaterial() != null) {
                        System.out.println("Material successfully added!");
                        isDone = false;
                        break;
                    } else {
                        System.out.println(amre.getState().getError().getMessage());
                        break;
                    }
                case "2":
                    System.out.println("Enter material id: ");
                    String check = scanner.nextLine().trim();
                    if (check != null && check.matches("[-+]?\\d*\\.?\\d+")) {
                        id = check;
                        GetMaterialRequest gmr = new GetMaterialRequest();
                        gmr.setToken(API_TOKEN);
                        gmr.setId(BigInteger.valueOf(Integer.valueOf(id)));
                        GetMaterialResponse gmre = getMaterial(gmr);
                        if (gmre.getMaterial() != null) {
                            System.out.println("Material id: " + gmre.getMaterial().getId()
                                    + "\n Material name: " + gmre.getMaterial().getName()
                                    + "\n Material code: " + gmre.getMaterial().getCode()
                                    + "\n Material composition: " + gmre.getMaterial().getComposition()
                                    + "\n Material durability: " + gmre.getMaterial().getDurability());
                        } else {
                            System.out.println("Materail with such id does not exist.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input!");
                        break;
                    }
                    isDone = false;
                    break;
                case "3":
                    GetMaterialListRequest gmlr = new GetMaterialListRequest();
                    gmlr.setToken(API_TOKEN);
                    getMaterialList(gmlr).getMaterials().forEach((material) -> {
                        System.out.println("id: " + material.getId()
                                + "  Name: " + material.getName()
                                + "  Code: " + material.getCode()
                                + "  Composition: " + material.getComposition()
                                + "  Durability: " + material.getDurability());
                    });
                    isDone = false;
                    break;
                case "quit":
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
    private static AddMaterialResponse addMaterial(AddMaterialRequest parameter) {
        WarehouseService service = new WarehouseService();
        WarehousePortType port = service.getWarehousePort();
        return port.addMaterial(parameter);
    }

    /**
     *
     * @param parameter
     * @return single material
     */
    private static GetMaterialResponse getMaterial(GetMaterialRequest parameter) {
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
     *
     * @param input
     * @return operation name
     */
    private static String getOperation(String input) {
        if (input != null) {
            switch (input) {
                case "1":
                    return "addMaterial";
                case "2":
                    return "getMaterial";
                case "3":
                    return "getMaterialList";
                case "quit":
                    return "Exit";
            }
        }
        return null;
    }
}
