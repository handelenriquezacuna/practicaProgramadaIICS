package SistemaGestionTransaccionesFinancieras.Transaccion;

public abstract class Transaccion {
    protected double monto;
    protected String descripcion;
    protected String fecha;

    public Transaccion(double monto, String descripcion, String fecha) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public abstract double calcularImpuesto();

    public abstract boolean procesarTransaccion(double capitalActual, ExcepcionTransaccion validador);

    @Override
    public String toString() {
        return String.format("Fecha: %s | Monto: %.2f | Descripción: %s", fecha, monto, descripcion);
    }
}
