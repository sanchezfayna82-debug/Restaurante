package com.restaurante.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // Atributo estático para generar IDs automáticos (se incrementa con cada nuevo pedido)
    private static int contadorId = 1;

    // Atributos del pedido
    private final int id;                   // final porque no cambia
    private String nombreCliente;
    private List<Articulo> articulos;
    private EstadoPedido estado;

    // Constructor principal
    public Pedido(String nombreCliente) {
        this.id = contadorId++;             // asigna y aumenta el contador
        this.nombreCliente = nombreCliente;
        this.articulos = new ArrayList<>(); // lista vacía al inicio
        this.estado = EstadoPedido.EN_PREPARACION; // estado inicial
    }

    // Getters (encapsulación)
    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public List<Articulo> getArticulos() {
        // Devolvemos copia para proteger la lista interna
        return new ArrayList<>(articulos);
    }

    // Método para agregar artículo con validaciones
    public boolean agregarArticulo(String nombre, int cantidad, double precioUnitario) {
        if (articulos.size() >= 5) {
            System.out.println("¡Error! No se pueden agregar más de 5 artículos al pedido.");
            return false;
        }
        if (cantidad <= 0 || precioUnitario <= 0) {
            System.out.println("¡Error! Cantidad y precio deben ser mayores que 0.");
            return false;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("¡Error! El nombre del artículo no puede estar vacío.");
            return false;
        }

        Articulo nuevoArticulo = new Articulo(nombre, cantidad, precioUnitario);
        articulos.add(nuevoArticulo);
        System.out.println("Artículo agregado: " + nuevoArticulo);
        return true;
    }

    // Calcular el precio total
    public double calcularTotal() {
        double total = 0.0;
        for (Articulo art : articulos) {
            total += art.getSubtotal();
        }
        return total;
    }

    // Cambiar estado con validación (no permite retroceder)
    public boolean cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) {
            System.out.println("¡Error! Estado no puede ser nulo.");
            return false;
        }

        // Comparar ordinales para asegurar progresión
        if (nuevoEstado.ordinal() <= this.estado.ordinal()) {
            System.out.println("¡Error! No se puede retroceder el estado del pedido.");
            return false;
        }

        this.estado = nuevoEstado;
        System.out.println("Estado del pedido actualizado a: " + nuevoEstado);
        return true;
    }

    // Mostrar resumen del pedido
    public void mostrarResumen() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("PEDIDO #" + id);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado actual: " + estado);
        System.out.println("Artículos (" + articulos.size() + "/5):");

        if (articulos.isEmpty()) {
            System.out.println("   → No hay artículos en el pedido todavía.");
        } else {
            for (Articulo art : articulos) {
                System.out.println("   • " + art);
                System.out.printf("     Subtotal: $%.2f%n", art.getSubtotal());
            }
        }

        System.out.printf("TOTAL A PAGAR: $%.2f%n", calcularTotal());
        System.out.println("=".repeat(40));
    }
}
