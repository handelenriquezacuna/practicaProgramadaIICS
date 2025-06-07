package SistemaGestionTransaccionesFinancieras.Transaccion;

public class Egreso extends Transaccion {
    private final double cargoAdicional = 0.02f;
    /* Herencia aplicada*/
    public Egreso(double monto, String descripcion, String fecha) {
        super(monto, descripcion, fecha);
    }

    /*Metodos abstractos*/
    @Override
    public double calcularImpuesto() {
        double cargo = monto * cargoAdicional;
        System.out.println("Cargo adicional aplicado al egreso: " + cargo);
        return cargo;
    }

    @Override
    public boolean procesarTransaccion(double capitalActual, ExcepcionTransaccion validador) {
        try {
            double cargo = calcularImpuesto();
            double totalEgreso = monto + cargo;

            // Validar que haya capital suficiente
            ExcepcionTransaccion.validarEgreso(totalEgreso, capitalActual);

            double nuevoCapital = capitalActual - totalEgreso;
            System.out.printf("Egreso procesado exitosamente. Monto total deducido: %.2f. Capital restante: %.2f\n", totalEgreso, nuevoCapital);
            return true;

        } catch (ExcepcionTransaccion e) {
            System.out.println("Error al procesar egreso: " + e.getMessage());
            return false;
        }
    }
}
