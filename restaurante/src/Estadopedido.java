
public enum Estadopedido {
    EN_PREPARACION,
    LISTO_PARA_ENTREGAR,
    ENTREGADO;
    
    public static boolean puedeCambiar(Estadopedido actual, Estadopedido nuevo) {
        if (actual == ENTREGADO) {
            return false;
        }
        
        if (actual == LISTO_PARA_ENTREGAR && nuevo == EN_PREPARACION) {
            return false;
        }
        
        return true;
    }
}