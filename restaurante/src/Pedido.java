import java.util.ArrayList;

public class Pedido {
    private final int id;
    private final String cliente;
    private final ArrayList<Articulo> articulos;
    private Estadopedido estado;
    
    private static int siguienteId = 1;
    
    public Pedido(String cliente) {
        this.id = siguienteId;
        siguienteId++;
        this.cliente = cliente;
        this.articulos = new ArrayList<>();
        this.estado = Estadopedido.EN_PREPARACION;
    }
    
    public boolean agregarArticulo(Articulo articulo) {
        if (articulos.size() >= 5) {
            System.out.println("¡Error! Máximo 5 artículos por pedido.");
            return false;
        }
        
        articulos.add(articulo);
        System.out.println("Artículo agregado: " + articulo.getNombre());
        return true;
    }
    
    public boolean cambiarEstado(Estadopedido nuevoEstado) {
        if (Estadopedido.puedeCambiar(this.estado, nuevoEstado)) {
            this.estado = nuevoEstado;
            System.out.println("Estado cambiado a: " + nuevoEstado);
            return true;
        } else {
            System.out.println("No se puede cambiar de " + this.estado + " a " + nuevoEstado);
            return false;
        }
    }
    
    public double calcularTotal() {
        double total = 0;
        
        for (Articulo art : articulos) {
            total += art.getSubtotal();
        }
        
        return total;
    }
    
    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN DEL PEDIDO ===");
        System.out.println("ID: " + id);
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);
        System.out.println("Artículos:");
        
        for (int i = 0; i < articulos.size(); i++) {
            Articulo art = articulos.get(i);
            System.out.println("  " + (i+1) + ". " + art.getNombre() + " (x" + art.getCantidad() + ") - $" + art.getSubtotal());
                             
                             
        }
        
        System.out.println("TOTAL: $" + calcularTotal());
    }
    
    public int getId() {
        return id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public Estadopedido getEstado() {
        return estado;
    }
    
    @Override
    public String toString() {
        return "Pedido #" + id + " - " + cliente + " - " + estado;
    }
}