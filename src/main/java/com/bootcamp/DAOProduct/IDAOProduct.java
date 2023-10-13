package com.bootcamp.DAOProduct;

import com.bootcamp.Entity.Product;

import java.sql.SQLException;

public interface IDAOProduct {
    void newProduct(Product product) throws SQLException;
    void findProduct(int id) throws SQLException;
    void findProductByName(String name) throws SQLException;
    void findAllProducts() throws SQLException;
    void updateProduct(int id, Product product) throws SQLException;
    void updateProductPrice(int id, double price) throws SQLException;
    void updateProductStock(int id, int newStock) throws SQLException;
    void deleteProduct(int id) throws SQLException;
}
