/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Categoria;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiantes
 */
public class DAODetalleVenta {
    
    public void crearDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO DetalleVenta (id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalleVenta.getVenta().getIdVenta());
            stmt.setInt(2, detalleVenta.getProducto().getIdProducto());
            stmt.setInt(3, detalleVenta.getCantidad());
            stmt.setFloat(4, detalleVenta.getPrecioUnitario());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAODetalleVenta dao = new DAODetalleVenta();
            DetalleVenta detalle = new DetalleVenta();

            Venta venta = new Venta();
            venta.setIdVenta(1); // Suponiendo que la venta ya existe en la BD

            Producto producto = new Producto();
            producto.setIdProducto(3); // Suponiendo que el producto ya existe en la BD

            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setCantidad(2);
            detalle.setPrecioUnitario(75.25f);

            dao.crearDetalleVenta(detalle);
            System.out.println("Detalle de venta creado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear detalle de venta: " + e.getMessage());
        }
    }
}
