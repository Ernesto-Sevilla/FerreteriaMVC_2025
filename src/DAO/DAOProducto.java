/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.*;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiantes
 */
public class DAOProducto {
    
    public void crearProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO Productos (nombre_producto, descripcion_producto, id_categoria, precio_unitario, stock, imagen) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombreProducto());
            stmt.setString(2, producto.getDescripcionProducto());
            stmt.setInt(3, producto.getCategoria().getIdCategoria());
            stmt.setFloat(4, producto.getPrecioUnitario());
            stmt.setInt(5, producto.getStock());
            stmt.setString(6, producto.getImagen());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOProducto dao = new DAOProducto();
            Producto producto = new Producto();

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(1); // Suponiendo que la categoría ya existe en la BD

            producto.setNombreProducto("Taladro");
            producto.setDescripcionProducto("Taladro eléctrico de 500W");
            producto.setCategoria(categoria);
            producto.setPrecioUnitario(120.99f);
            producto.setStock(10);
            producto.setImagen("taladro.jpg");

            dao.crearProducto(producto);
            System.out.println("Producto creado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear producto: " + e.getMessage());
        }
    }
}
