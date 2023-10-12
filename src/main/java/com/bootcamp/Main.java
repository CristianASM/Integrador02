package com.bootcamp;

import com.bootcamp.DAOProduct.DAOProductImpl;
import com.bootcamp.DAOProduct.IDAOProduct;
import com.bootcamp.Entity.Product;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 0;
        boolean sentry = false;
        String door;

        try {
            while (!sentry){
                showMenu();
                option = in.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("Ingrese los siguientes datos del producto a agregar");
                        System.out.print("Nombre: ");
                        String name = in.next();
                        System.out.print("Descripcion: ");
                        String description = in.next();
                        System.out.print("Precio: ");
                        double price = in.nextDouble();
                        System.out.print("Stock: ");
                        int stock = in.nextInt();
                        System.out.print("Fabricante: ");
                        String maker = in.next();
                        createProduct(name, description, price, stock, maker);
                    }
                    case 2 -> {
                        System.out.print("Ingrese la ID del producto a buscar: ");
                        int id = in.nextInt();
                        getProduct(id);
                    }
                    case 3 -> {
                        System.out.println("Todos los productos: ");
                        getAllProducts();
                    }
                    case 4 -> {
                        System.out.print("Ingrese la ID del producto a actualizar: ");
                        int idUpdated = in.nextInt();
                        System.out.print("Nombre: ");
                        String nameUpdated = in.next();
                        System.out.print("Descripcion: ");
                        String descriptionUpdated = in.next();
                        System.out.print("Precio: ");
                        double priceUpdated = in.nextDouble();
                        System.out.print("Stock: ");
                        int stockUpdated = in.nextInt();
                        System.out.print("Fabricante: ");
                        String makerUpdated = in.next();
                        updateProduct(idUpdated, nameUpdated, descriptionUpdated, priceUpdated, stockUpdated, makerUpdated);
                    }
                    case 5 -> {
                        System.out.print("Ingrese la ID del producto a eliminar: ");
                        int idDeleted = in.nextInt();
                        deleteProduct(idDeleted);
                    }
                    case 6 -> System.out.println("Saliendo del programa");
                }
                System.out.println("¿Desea seguir en el programa? 'S = si' - 'N = no'");
                door = in.next();
                if (door.equalsIgnoreCase("N")){
                    sentry = true;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Por favor ingrese un numero de opcion valida");
        }

    }
    public static void showMenu(){
        System.out.println("¡Bienvenido!, Ingrese el numero de la opcion requerida: ");
        System.out.println("1- Crear un producto");
        System.out.println("2- Buscar un producto por su ID");
        System.out.println("3- Listar todos los productos");
        System.out.println("4- Actualizar un producto por su ID");
        System.out.println("5- Eliminar un producto por su ID");
        System.out.println("6- Salir");
    }
    public static void createProduct(String name, String description, double price, int stock, String maker){
        try{
            Product product = new Product();
            product.setNombre(name);
            product.setDescripcion(description);
            product.setPrecio(price);
            product.setStock(stock);
            product.setFabricante(maker);
            IDAOProduct dao = new DAOProductImpl();
            dao.newProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void getProduct(int id){
        try{
            IDAOProduct dao = new DAOProductImpl();
            dao.getProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void getAllProducts(){
        try{
            IDAOProduct dao = new DAOProductImpl();
            dao.getAllProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void updateProduct(int id, String name, String description, double price, int stock, String maker){
        try{
            Product product = new Product();
            product.setNombre(name);
            product.setDescripcion(description);
            product.setPrecio(price);
            product.setStock(stock);
            product.setFabricante(maker);
            IDAOProduct dao = new DAOProductImpl();
            dao.updateProduct(id,product);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void deleteProduct(int id){
        try{
            IDAOProduct dao = new DAOProductImpl();
            dao.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}