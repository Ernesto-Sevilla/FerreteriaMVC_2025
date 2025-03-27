/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiantes
 */
public class DetalleCompra {
    
    private int idDetalleCompra;
    private Compra compra; // Relación con Compra
    private Producto producto; // Relación con Producto
    private int cantidad;
    private float precioUnitario;

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalleCompra, Compra compra, Producto producto, int cantidad, float precioUnitario) {
        this.idDetalleCompra = idDetalleCompra;
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    
}   
