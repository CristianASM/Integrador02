package com.bootcamp;

import com.bootcamp.Service.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner in = new Scanner(System.in);
        int option;
        boolean sentry = false;
        String door;

        try {
            while (!sentry) {
                productService.showMenu();
                option = in.nextInt();
                if (option >= 0 && option <= 9) {
                    switch (option) {
                        case 1 -> {
                            System.out.println("Ingrese los siguientes datos del producto a agregar");
                            System.out.print("Nombre: ");
                            in.nextLine();
                            String name = in.nextLine();
                            System.out.print("Descripcion: ");
                            String description = in.nextLine();
                            System.out.print("Precio: ");
                            double price = in.nextDouble();
                            System.out.print("Stock: ");
                            int stock = in.nextInt();
                            in.nextLine();
                            System.out.print("Fabricante: ");
                            String maker = in.nextLine();
                            productService.createProduct(name, description, price, stock, maker);
                        }
                        case 2 -> {
                            System.out.print("Ingrese la ID del producto a buscar: ");
                            int id = in.nextInt();
                            productService.getProduct(id);
                        }
                        case 3 -> {
                            System.out.print("Ingrese el nombre del producto a buscar: ");
                            in.nextLine();
                            String name = in.nextLine();
                            productService.getProductByName(name);
                        }
                        case 4 -> productService.getAllProducts();
                        case 5 -> {
                            System.out.print("Ingrese la ID del producto a actualizar: ");
                            int idUpdated = in.nextInt();
                            System.out.print("Nombre: ");
                            in.nextLine();
                            String nameUpdated = in.nextLine();
                            System.out.print("Descripcion: ");
                            String descriptionUpdated = in.nextLine();
                            System.out.print("Precio: ");
                            double priceUpdated = in.nextDouble();
                            System.out.print("Stock: ");
                            int stockUpdated = in.nextInt();
                            in.nextLine();
                            System.out.print("Fabricante: ");
                            String makerUpdated = in.nextLine();
                            productService.updateProduct(idUpdated, nameUpdated, descriptionUpdated, priceUpdated, stockUpdated, makerUpdated);
                        }
                        case 6 -> {
                            System.out.print("Ingrese la ID del producto a actualizar: ");
                            int idUpdated = in.nextInt();
                            System.out.print("Precio: ");
                            double priceUpdated = in.nextDouble();
                            productService.updateProductPrice(idUpdated, priceUpdated);
                        }
                        case 7 -> {
                            System.out.print("Ingrese la ID del producto a actualizar: ");
                            int idUpdated = in.nextInt();
                            System.out.print("Stock: ");
                            double stockUpdated = in.nextDouble();
                            productService.updateProductStock(idUpdated, stockUpdated);
                        }
                        case 8 -> {
                            System.out.print("Ingrese la ID del producto a actualizar: ");
                            int idUpdated = in.nextInt();
                            System.out.print("Stock: ");
                            int stockUpdated = in.nextInt();
                            productService.addProductStock(idUpdated, stockUpdated);
                        }
                        case 9 -> {
                            System.out.print("Ingrese la ID del producto a eliminar: ");
                            int idDeleted = in.nextInt();
                            productService.deleteProduct(idDeleted);
                        }
                        case 0 -> {
                            System.out.println("Saliendo del programa");
                            sentry = true;
                        }
                    }
                } else {
                    System.out.println("Por favor, ingrese una opción válida.");
                }
                if (!sentry) {
                    System.out.println("....................................................");
                    System.out.println("¿Desea seguir en el programa?");
                    System.out.println("Presione cualquier letra para seguir. - Presione 'S' para SALIR");
                    door = in.next();
                    if (door.equalsIgnoreCase("S")) {
                        sentry = true;
                        System.out.println("Saliendo del programa");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Caracter invalido");
        }
    }
}