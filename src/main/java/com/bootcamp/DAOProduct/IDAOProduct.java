package com.bootcamp.DAOProduct;

import com.bootcamp.Entity.Product;

import java.sql.SQLException;

public interface IDAOProduct {
    void newProduct(Product product) throws SQLException;
    void getProduct(int id) throws SQLException;
    void getAllProducts() throws SQLException;
    void updateProduct(int id, Product product) throws SQLException;
    void deleteProduct(int id) throws SQLException;
}
