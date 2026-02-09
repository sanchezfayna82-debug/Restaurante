package com.restaurante.model;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DEL SISTEMA DE PEDIDOS ===\n");

        Pedido pedido1 = new Pedido("Fayna Caballero");

        pedido1.agregarArticulo("Hamburguesa clásica", 2, 9.50);
        pedido1.agregarArticulo("Papas fritas", 1, 4.20);
        pedido1.agregarArticulo("Coca-Cola", 2, 2.80);

        pedido1.mostrarResumen();

        System.out.println("\nCambiando estado...");
        pedido1.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido1.cambiarEstado(EstadoPedido.ENTREGADO);

        // Esto debe fallar (retroceder)
        pedido1.cambiarEstado(EstadoPedido.EN_PREPARACION);

        pedido1.mostrarResumen();
    }
}