package com.bootcamp.DAOProduct;

import com.bootcamp.DB.ConnectionDB;
import com.bootcamp.Entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOProductImpl implements IDAOProduct{
    ConnectionDB connectionDB;
    public DAOProductImpl() {
        connectionDB = new ConnectionDB();
    }

    @Override
    public void newProduct(Product product) throws SQLException {
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("INSERT INTO productos(nombre, descripcion, precio, stock, fabricante) VALUES(?,?,?,?,?)");
            st.setString(1, product.getNombre());
            st.setString(2, product.getDescripcion());
            st.setDouble(3, product.getPrecio());
            st.setInt(4, product.getStock());
            st.setString(5, product.getFabricante());
            st.executeUpdate();
            System.out.println("Producto añadido correctamente: ");
            System.out.println("Nombre: "+product.getNombre());
            System.out.println("Descripcion: "+product.getDescripcion());
            System.out.println("Precio: "+product.getPrecio());
            System.out.println("Stock: "+product.getStock());
            System.out.println("Fabricante: "+product.getFabricante());

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.close();
        }
    }
    @Override
    public void getProduct(int id) throws SQLException {
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id_producto"));
                product.setNombre(resultSet.getString("nombre"));
                product.setDescripcion(resultSet.getString("descripcion"));
                product.setPrecio(resultSet.getDouble("precio"));
                product.setStock(resultSet.getInt("stock"));
                product.setFabricante(resultSet.getString("fabricante"));

                System.out.println("ID: " + product.getId());
                System.out.println("Nombre: " + product.getNombre());
                System.out.println("Descripción: " + product.getDescripcion());
                System.out.println("Precio: " + product.getPrecio());
                System.out.println("Stock: " + product.getStock());
                System.out.println("Fabricante: " + product.getFabricante());
            } else {
                System.out.println("Producto no encontrado");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.close();
        }
    }
    @Override
    public void getAllProducts() throws SQLException {
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("SELECT * FROM productos");
            ResultSet resultSet = st.executeQuery();

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
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.close();
        }
    }

    @Override
    public void updateProduct(int id, Product product) throws SQLException {
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ?, fabricante = ? WHERE id_producto = ?");
            st.setString(1, product.getNombre());
            st.setString(2, product.getDescripcion());
            st.setDouble(3, product.getPrecio());
            st.setInt(4, product.getStock());
            st.setString(5, product.getFabricante());
            st.setInt(6, id);
            st.executeUpdate();
            System.out.println("Producto con la ID "+ id + " fue actualizado");
            System.out.println("Nombre: " + product.getNombre());
            System.out.println("Descripción: " + product.getDescripcion());
            System.out.println("Precio: " + product.getPrecio());
            System.out.println("Stock: " + product.getStock());
            System.out.println("Fabricante: " + product.getFabricante());

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.close();
        }
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        try {
            PreparedStatement st = connectionDB.connection().prepareStatement("DELETE FROM productos WHERE id_producto = ?");
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Producto con la ID " + id + " fue eliminado");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionDB.close();
        }
    }
}
