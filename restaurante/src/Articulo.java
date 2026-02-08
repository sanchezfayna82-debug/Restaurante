
public class Articulo {
    private final String nombre;
    private final int cantidad;
    private final double precioUnitario;
    
    public Articulo(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    public double getSubtotal() {
        return cantidad * precioUnitario;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
}