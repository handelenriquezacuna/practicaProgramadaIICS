package SistemaGestionTransaccionesFinancieras.Gestor;

import SistemaGestionTransaccionesFinancieras.Transaccion.*;

import java.util.ArrayList;

public class GestorTransacciones {
    // Lista donde se almacenan todas las transacciones registradas
    private final ArrayList<Transaccion> listaTransacciones;

    // Capital disponible. Se inicia con $1500.
    private double capital;

    // Constructor: inicializa lista de transacciones y capital inicial
    public GestorTransacciones() {
        this.listaTransacciones = new ArrayList<>();
        this.capital = 1500.0;
    }

    // Método para agregar una transacción al sistema
    public void agregarTransaccion(Transaccion transaccion) {
        // Primero validamos si se puede procesar la transacción
        boolean resultado = transaccion.procesarTransaccion(capital, null);

        if (resultado) {
            // Si fue válida, la agregamos al historial
            listaTransacciones.add(transaccion);

            // Actualizamos el capital dependiendo del tipo de transacción:
            // - Si es un ingreso, se suma el monto menos el impuesto
            // - Si es un egreso, se resta el monto más el impuesto
            if (transaccion instanceof Ingreso) {
                capital += transaccion.getMonto() - transaccion.calcularImpuesto();
            } else if (transaccion instanceof Egreso) {
                capital -= transaccion.getMonto() + transaccion.calcularImpuesto();
            }

        } else {
            // Si no se pudo procesar (por error de validación), se notifica
            System.out.println("No se pudo agregar la transacción.");
        }
    }

    // Método para eliminar una transacción del historial según el índice
    public void eliminarTransaccion(int indice) {
        // Validamos que el índice esté dentro del rango válido
        if (indice >= 0 && indice < listaTransacciones.size()) {
            // Quitamos la transacción de la lista
            Transaccion transaccion = listaTransacciones.remove(indice);

            // Revertimos el efecto que esa transacción tuvo sobre el capital:
            // - Si era un ingreso, se resta lo que antes se sumó
            // - Si era un egreso, se suma lo que antes se restó
            if (transaccion instanceof Ingreso) {
                capital -= transaccion.getMonto() - transaccion.calcularImpuesto();
            } else if (transaccion instanceof Egreso) {
                capital += transaccion.getMonto() + transaccion.calcularImpuesto();
            }

            System.out.println("Transacción eliminada correctamente.");
        } else {
            // Si el índice es inválido, se informa al usuario
            System.out.println("El índice ingresado no es válido.");
        }
    }

    // Método para mostrar todas las transacciones almacenadas
    public void mostrarTransacciones() {
        if (listaTransacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            // Se recorren todas las transacciones y se muestran con su índice
            for (int i = 0; i < listaTransacciones.size(); i++) {
                System.out.println("[" + i + "] " + listaTransacciones.get(i));
            }
        }
    }

    // Muestra en pantalla el capital actual del sistema
    public void mostrarCapitalActual() {
        System.out.printf("Capital actual: $%.2f\n", capital);
    }

    // Devuelve el capital actual (por si otros módulos lo necesitan)
    public double getCapital() {
        return capital;
    }

    // Devuelve la lista completa de transacciones se puede usar en reportes
    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }
}
