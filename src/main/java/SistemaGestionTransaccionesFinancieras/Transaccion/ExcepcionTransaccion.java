package SistemaGestionTransaccionesFinancieras.Transaccion;

/**
 * Excepción personalizada para errores en transacciones financieras.
 */
public class ExcepcionTransaccion extends Exception {

    public ExcepcionTransaccion(String mensaje) {
        super(mensaje);
    }

    /**
     * Lanza excepción si el monto no es positivo.
     * @param monto Monto a validar.
     * @throws ExcepcionTransaccion si el monto es <= 0.
     */
    public static void validarMontoPositivo(double monto) throws ExcepcionTransaccion {
        if (monto <= 0) {
            throw new ExcepcionTransaccion("El monto debe ser mayor que cero.");
        }
    }

    /**
     * Valida que un ingreso tenga un monto válido.
     *
     * @param monto Monto del ingreso.
     * @return
     * @throws ExcepcionTransaccion si el monto no es válido.
     */
    public static boolean validarIngreso(double monto) throws ExcepcionTransaccion {
        validarMontoPositivo(monto);
        return false;
    }

    /**
     * Valida que un egreso no supere el capital disponible y sea válido.
     * @param monto Monto del egreso (incluyendo cargos).
     * @param capitalDisponible Capital disponible.
     * @throws ExcepcionTransaccion si el egreso es inválido.
     */
    public static void validarEgreso(double monto, double capitalDisponible) throws ExcepcionTransaccion {
        validarMontoPositivo(monto);
        if (monto > capitalDisponible) {
            throw new ExcepcionTransaccion("El egreso excede el capital disponible.");
        }
    }
}