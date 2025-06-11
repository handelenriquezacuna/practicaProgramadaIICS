package SistemaGestionTransaccionesFinancieras.Transaccion;
import java.time.LocalDate;

public class Ingreso extends Transaccion {
    private final double impuesto = 0.10;

    public Ingreso(double monto, String descripcion) {
        super(monto, descripcion, LocalDate.now().toString());
    }

    @Override
    public double calcularImpuesto() {
        double aplicacionImpuesto = monto * impuesto;
        System.out.println("Impuesto aplicado al ingreso: " + aplicacionImpuesto);
        return aplicacionImpuesto;
    }

    @Override
    public boolean procesarTransaccion(double capitalActual, ExcepcionTransaccion validador) {
        try {
            // Validar ingreso (debe ser positivo)
            ExcepcionTransaccion.validarIngreso(monto);

            double impuestoCalculado = calcularImpuesto();
            double nuevoCapital = capitalActual + monto - impuestoCalculado;

            System.out.printf("Ingreso procesado exitosamente. Monto neto ingresado: %.2f. Capital nuevo: %.2f\n",
                    (monto - impuestoCalculado), nuevoCapital);
            return true;

        } catch (ExcepcionTransaccion e) {
            System.out.println("Error al procesar ingreso: " + e.getMessage());
            return false;
        }
    }
}
