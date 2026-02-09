package com.restaurante.model;

public class Articulo {
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Articulo(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Método útil para el total
    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    // Para mostrar bonito en el resumen
    @Override
    public String toString() {
        return cantidad + "x " + nombre + " ($" + String.format("%.2f", precioUnitario) + ")";
    }
}
