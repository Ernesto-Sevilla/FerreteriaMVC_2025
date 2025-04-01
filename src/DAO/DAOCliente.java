/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiantes
 */
public class DAOCliente {

    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Clientes (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, direccion, cedula) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cliente.getPrimerNombre());
            stmt.setString(2, cliente.getSegundoNombre());
            stmt.setString(3, cliente.getPrimerApellido());
            stmt.setString(4, cliente.getSegundoApellido());
            stmt.setString(5, cliente.getCelular());
            stmt.setString(6, cliente.getDireccion());
            stmt.setString(7, cliente.getCedula());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOCliente dao = new DAOCliente();
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre("Juan");
            cliente.setSegundoNombre("Carlos");
            cliente.setPrimerApellido("Perez");
            cliente.setSegundoApellido("Gomez");
            cliente.setCelular("12345678");
            cliente.setDireccion("Calle 123");
            cliente.setCedula("001-234567-8901X");

            dao.crearCliente(cliente);
            System.out.println("Cliente creado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear cliente: " + e.getMessage());
        }
    }
}
