/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiantes
 */
public class DAOUsuario {

    public void crearUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (usuario, contrasena) VALUES (?, ?)";
        
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOUsuario dao = new DAOUsuario();
            Usuario usuario = new Usuario();
            usuario.setUsuario("admin");
            usuario.setContrasena("12345");

            dao.crearUsuario(usuario);
            System.out.println("Usuario creado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }
}
