public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PEDIDOS DE RESTAURANTE ===\n");
        
        // 1. Crear un pedido
        System.out.println("1. Creando nuevo pedido...");
        Pedido miPedido = new Pedido("Ana García");
        System.out.println("Pedido creado: " + miPedido);
        
        // 2. Agregar artículos
        System.out.println("\n2. Agregando artículos...");
        
        Articulo art1 = new Articulo("Hamburguesa", 2, 8.50);
        Articulo art2 = new Articulo("Papas fritas", 1, 3.50);
        Articulo art3 = new Articulo("Refresco", 2, 2.00);
        Articulo art4 = new Articulo("Ensalada", 1, 6.00);
        Articulo art5 = new Articulo("Postre", 1, 4.50);
        
        miPedido.agregarArticulo(art1);
        miPedido.agregarArticulo(art2);
        miPedido.agregarArticulo(art3);
        miPedido.agregarArticulo(art4);
        miPedido.agregarArticulo(art5);
        
        // 3. Intentar agregar un artículo extra
        System.out.println("\n3. Intentando agregar un 6to artículo...");
        Articulo art6 = new Articulo("Café", 1, 2.00);
        miPedido.agregarArticulo(art6);
        
        // 4. Mostrar resumen
        System.out.println("\n4. Mostrando resumen del pedido:");
        miPedido.mostrarResumen();
        
        // 5. Cambiar estados
        System.out.println("5. Cambiando estados del pedido:");
        
        System.out.print("De EN_PREPARACION a LISTO: ");
        miPedido.cambiarEstado(Estadopedido.LISTO_PARA_ENTREGAR);
        
        System.out.print("Intentar volver a EN_PREPARACION: ");
        miPedido.cambiarEstado(Estadopedido.EN_PREPARACION);
        
        System.out.print("De LISTO a ENTREGADO: ");
        miPedido.cambiarEstado(Estadopedido.ENTREGADO);
        
        System.out.print("Intentar cambiar después de ENTREGADO: ");
        miPedido.cambiarEstado(Estadopedido.LISTO_PARA_ENTREGAR);
        
        // 6. Mostrar resumen final
        System.out.println("\n6. Resumen final:");
        miPedido.mostrarResumen();
        
        // 7. Crear otro pedido
        System.out.println("\n7. Creando segundo pedido...");
        Pedido otroPedido = new Pedido("Carlos López");
        System.out.println("Segundo pedido: " + otroPedido);
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}