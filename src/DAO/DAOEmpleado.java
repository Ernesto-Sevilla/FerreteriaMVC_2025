/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class DAOEmpleado {
    
    public void crearEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO Empleados (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, cargo, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, empleado.getPrimerNombre());
            stmt.setString(2, empleado.getSegundoNombre());
            stmt.setString(3, empleado.getPrimerApellido());
            stmt.setString(4, empleado.getSegundoApellido());
            stmt.setString(5, empleado.getCelular());
            stmt.setString(6, empleado.getCargo());
            stmt.setDate(7, new Date(empleado.getFechaContratacion().getTime()));
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOEmpleado dao = new DAOEmpleado();
            Empleado empleado = new Empleado();
            empleado.setPrimerNombre("Ana");
            empleado.setSegundoNombre("Maria");
            empleado.setPrimerApellido("Lopez");
            empleado.setSegundoApellido("Fernandez");
            empleado.setCelular("87654321");
            empleado.setCargo("Gerente");
            empleado.setFechaContratacion(new java.util.Date());

            dao.crearEmpleado(empleado);
            System.out.println("Empleado creado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear empleado: " + e.getMessage());
        }
    }
}
