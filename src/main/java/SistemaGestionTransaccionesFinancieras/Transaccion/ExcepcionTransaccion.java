package SistemaGestionTransaccionesFinancieras.Transaccion;

public class ExcepcionTransaccion {
    private String mensaje;

    public ExcepcionTransaccion() {
        this.mensaje = "";
    }

    public boolean validarIngreso(double monto) {
        if (monto < 0) {
            mensaje = "El monto no puede ser negativo para un ingreso.";
            return false;
        }
        return true;
    }

    public boolean validarEgreso(double monto, double capitalDisponible) {
        if (monto > capitalDisponible) {
            mensaje = "El egreso excede el capital disponible.";
            return false;
        }
        return true;
    }

    public String getMensaje() {
        return mensaje;
    }

}
