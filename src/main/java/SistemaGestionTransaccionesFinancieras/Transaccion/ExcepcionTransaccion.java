package SistemaGestionTransaccionesFinancieras.Transaccion;

public class ExcepcionTransaccion extends RuntimeException {
    public ExcepcionTransaccion(String message) {
        super(message);
    }
}
