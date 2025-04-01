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
public class DAODetalleCompra {
    public void crearDetalleCompra(DetalleCompra detalleCompra) throws SQLException {
        String sql = "INSERT INTO DetalleCompra (id_compra, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalleCompra.getCompra().getIdCompra());
            stmt.setInt(2, detalleCompra.getProducto().getIdProducto());
            stmt.setInt(3, detalleCompra.getCantidad());
            stmt.setFloat(4, detalleCompra.getPrecioUnitario());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAODetalleCompra dao = new DAODetalleCompra();
            DetalleCompra detalle = new DetalleCompra();

            Compra compra = new Compra();
            compra.setIdCompra(1); // Suponiendo que la compra ya existe en la BD

            Producto producto = new Producto();
            producto.setIdProducto(2); // Suponiendo que el producto ya existe en la BD

            detalle.setCompra(compra);
            detalle.setProducto(producto);
            detalle.setCantidad(5);
            detalle.setPrecioUnitario(50.75f);

            dao.crearDetalleCompra(detalle);
            System.out.println("Detalle de compra creado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear detalle de compra: " + e.getMessage());
        }
    }
}
