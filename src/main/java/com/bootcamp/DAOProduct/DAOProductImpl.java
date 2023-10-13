package com.bootcamp.DAOProduct;

import com.bootcamp.DB.ConnectionDB;
import com.bootcamp.Entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOProductImpl implements IDAOProduct {
    private final ConnectionDB connectionDB; // Creo una instancia de la clase ConnectionDB

    public DAOProductImpl() {  // Cada vez que instancie DAOProductImpl va a crear una instancia de ConnectionDB
        connectionDB = new ConnectionDB();
    }

    @Override
    public void newProduct(Product product) throws SQLException { // Crea un nuevo producto con todos sus atributos
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("INSERT INTO productos(nombre, descripcion, precio, stock, fabricante) VALUES(?,?,?,?,?)");
            st.setString(1, product.getName());
            st.setString(2, product.getDescription());
            st.setDouble(3, product.getPrice());
            st.setInt(4, product.getStock());
            st.setString(5, product.getMaker());
            st.executeUpdate();
            System.out.println("Producto añadido correctamente: ");
            System.out.println("Nombre: " + product.getName());
            System.out.println("Descripcion: " + product.getDescription());
            System.out.println("Precio: " + product.getPrice());
            System.out.println("Stock: " + product.getStock());
            System.out.println("Fabricante: " + product.getMaker());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }

    @Override
    public void findProduct(int id) throws SQLException { // Busca un producto por su ID
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id_producto"));
                product.setName(resultSet.getString("nombre"));
                product.setDescription(resultSet.getString("descripcion"));
                product.setPrice(resultSet.getDouble("precio"));
                product.setStock(resultSet.getInt("stock"));
                product.setMaker(resultSet.getString("fabricante"));

                System.out.println("ID: " + product.getId());
                System.out.println("Nombre: " + product.getName());
                System.out.println("Descripción: " + product.getDescription());
                System.out.println("Precio: " + product.getPrice());
                System.out.println("Stock: " + product.getStock());
                System.out.println("Fabricante: " + product.getMaker());
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }

    @Override
    public void findProductByName(String name) throws SQLException { // Busca un producto por su NOMBRE
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("SELECT * FROM productos WHERE nombre = ?");
            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id_producto"));
                product.setName(resultSet.getString("nombre"));
                product.setDescription(resultSet.getString("descripcion"));
                product.setPrice(resultSet.getDouble("precio"));
                product.setStock(resultSet.getInt("stock"));
                product.setMaker(resultSet.getString("fabricante"));

                System.out.println("ID: " + product.getId());
                System.out.println("Nombre: " + product.getName());
                System.out.println("Descripción: " + product.getDescription());
                System.out.println("Precio: " + product.getPrice());
                System.out.println("Stock: " + product.getStock());
                System.out.println("Fabricante: " + product.getMaker());
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }

    @Override
    public void findAllProducts() throws SQLException { // Busca todos los productos
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("SELECT * FROM productos");
            ResultSet resultSet = st.executeQuery();
            System.out.println("Todos los productos: ");

            while (resultSet.next()) {
                int productId = resultSet.getInt("id_producto");
                String name = resultSet.getString("nombre");
                String description = resultSet.getString("descripcion");
                double price = resultSet.getDouble("precio");
                int stock = resultSet.getInt("stock");
                String maker = resultSet.getString("fabricante");

                System.out.println("ID: " + productId);
                System.out.println("Nombre: " + name);
                System.out.println("Descripción: " + description);
                System.out.println("Precio: " + price);
                System.out.println("Stock: " + stock);
                System.out.println("Fabricante: " + maker);
                System.out.println("-------------------------");
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }

    @Override
    public void updateProduct(int id, Product product) throws SQLException { // Actualiza un producto por si ID
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ?, fabricante = ? WHERE id_producto = ?");
            st.setString(1, product.getName());
            st.setString(2, product.getDescription());
            st.setDouble(3, product.getPrice());
            st.setInt(4, product.getStock());
            st.setString(5, product.getMaker());
            st.setInt(6, id);

            int result = st.executeUpdate();
            if (result != 0) {
                System.out.println("Producto con la ID " + id + " fue actualizado");
                System.out.println("Nombre: " + product.getName());
                System.out.println("Descripción: " + product.getDescription());
                System.out.println("Precio: " + product.getPrice());
                System.out.println("Stock: " + product.getStock());
                System.out.println("Fabricante: " + product.getMaker());
            } else {
                System.out.println("Producto no encontrado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }

    @Override
    public void updateProductPrice(int id, double price) throws SQLException { // Actualiza el precio de un producto por su ID
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("UPDATE productos SET precio = ? WHERE id_producto = ?");
            st.setDouble(1, price);
            st.setInt(2, id);

            int result = st.executeUpdate();
            if (result != 0) {
                findProduct(id);
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }

    @Override
    public void deleteProduct(int id) throws SQLException { // Elimina un producto por su ID
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("DELETE FROM productos WHERE id_producto = ?");
            st.setInt(1, id);

            int result = st.executeUpdate();
            if (result != 0) {
                System.out.println("Producto con la ID " + id + " fue eliminado");
            } else {
                System.out.println("Producto no encontrado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.close();
        }
    }
}
