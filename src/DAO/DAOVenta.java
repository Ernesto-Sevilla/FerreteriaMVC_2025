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
public class DAOVenta {

    public void crearVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO Ventas (id_cliente, id_empleado, fecha_venta, total_venta) VALUES (?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, venta.getCliente().getIdCliente());
            stmt.setInt(2, venta.getEmpleado().getIdEmpleado());
            stmt.setDate(3, new Date(venta.getFechaVenta().getTime()));
            stmt.setFloat(4, venta.getTotalVenta());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOVenta dao = new DAOVenta();
            Venta venta = new Venta();
            
            Cliente cliente = new Cliente();
            cliente.setIdCliente(1); // Suponiendo que ya existe un cliente en la BD
            
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(2); // Suponiendo que ya existe un empleado en la BD

            venta.setCliente(cliente);
            venta.setEmpleado(empleado);
            venta.setFechaVenta(new java.util.Date());
            venta.setTotalVenta(150.50f);

            dao.crearVenta(venta);
            System.out.println("Venta creada con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear venta: " + e.getMessage());
        }
    }
}
