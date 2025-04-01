/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Compra;
import Modelo.Empleado;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
/**
 *
 * @author Estudiantes
 */
public class DAOCompra {
    
    public void crearCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO Compras (id_empleado, fecha_compra, total_compra) VALUES (?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, compra.getEmpleado().getIdEmpleado());
            stmt.setDate(2, new Date(compra.getFechaCompra().getTime()));
            stmt.setFloat(3, compra.getTotalCompra());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOCompra dao = new DAOCompra();
            Compra compra = new Compra();
            
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(1); // Suponiendo que ya existe un empleado en la BD

            compra.setEmpleado(empleado);
            compra.setFechaCompra(new java.util.Date());
            compra.setTotalCompra(250.75f);

            dao.crearCompra(compra);
            System.out.println("Compra creada con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear compra: " + e.getMessage());
        }
    }
}
