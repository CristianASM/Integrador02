package com.bootcamp.Service;

import com.bootcamp.DAOProduct.DAOProductImpl;
import com.bootcamp.DAOProduct.IDAOProduct;
import com.bootcamp.Entity.Product;

import java.sql.SQLException;

public class ProductService {
    public void showMenu() {
        System.out.println("¡Bienvenido!, Ingrese el numero de la opcion requerida: ");
        System.out.println("  1- Crear un producto");
        System.out.println("  2- Buscar un producto por su ID");
        System.out.println("  3- Buscar un producto por su NOMBRE");
        System.out.println("  4- Listar todos los productos");
        System.out.println("  5- Actualizar un producto por su ID");
        System.out.println("  6- Actualizar el precio de un producto");
        System.out.println("  7- Agregar stock a un producto");
        System.out.println("  8- Eliminar un producto por su ID");
        System.out.println("  9- Salir");
    }

    public void createProduct(String name, String description, double price, int stock, String maker) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);
            product.setMaker(maker);
            IDAOProduct dao = new DAOProductImpl();
            dao.newProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void getProduct(int id) {
        try {
            IDAOProduct dao = new DAOProductImpl();
            dao.findProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void getProductByName(String name) {
        try {
            IDAOProduct dao = new DAOProductImpl();
            dao.findProductByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void getAllProducts() {
        try {
            IDAOProduct dao = new DAOProductImpl();
            dao.findAllProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateProduct(int id, String name, String description, double price, int stock, String maker) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);
            product.setMaker(maker);
            IDAOProduct dao = new DAOProductImpl();
            dao.updateProduct(id, product);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void updateProductPrice(int id, double price) {
        try {
            IDAOProduct dao = new DAOProductImpl();
            dao.updateProductPrice(id, price);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void updateProductStock(int id, int newStock) {
        try {
            IDAOProduct dao = new DAOProductImpl();
            dao.updateProductStock(id, newStock);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        try {
            IDAOProduct dao = new DAOProductImpl();
            dao.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
