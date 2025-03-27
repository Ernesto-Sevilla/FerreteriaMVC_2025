/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Estudiantes
 */
public class Venta {
    
    private int idVenta;
    private Cliente cliente; // Relación con Cliente
    private Empleado empleado; // Relación con Empleado
    private Date fechaVenta;
    private float totalVenta;
    private List<DetalleVenta> detalles; // Relación con DetalleVenta
    
}
