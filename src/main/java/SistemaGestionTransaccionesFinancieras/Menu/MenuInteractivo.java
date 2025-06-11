package SistemaGestionTransaccionesFinancieras.Menu;
import SistemaGestionTransaccionesFinancieras.Gestor.GestorTransacciones;
import SistemaGestionTransaccionesFinancieras.Transaccion.Ingreso;
import SistemaGestionTransaccionesFinancieras.Transaccion.Egreso;

import java.util.Scanner;

public class MenuInteractivo {

    private GestorTransacciones gestor;

    public MenuInteractivo(GestorTransacciones gestor) {
        this.gestor = gestor;
    }
    public  void mostrarMenu() {
        boolean menu = true;
        Scanner sc = new Scanner(System.in);

        boolean Menu = true;
        while (menu) {
            System.out.println("\n=== MENÚ DE TRANSACCIONES ===");
            System.out.println("1. Registrar ingreso");
            System.out.println("2. Registrar egreso");
            System.out.println("3. Eliminar transacción");
            System.out.println("4. Mostrar todas las transacciones");
            System.out.println("5. Salir");
            System.out.println("Opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el monto: ");
                    double montoIngreso = Double.parseDouble(sc.nextLine());
                    System.out.print("Descripción: ");
                    String descripcionIngreso = sc.nextLine();
                    Ingreso ingreso1 = new Ingreso(montoIngreso, descripcionIngreso);
                    gestor.agregarTransaccion(ingreso1);
                    break;
                case "2":
                    System.out.println("Ingrese el monto: ");
                    double montoEgreso = Double.parseDouble(sc.nextLine());
                    System.out.println("Descripcion: ");
                    String descripcionEgreso = sc.nextLine();
                    Egreso egreso = new Egreso(montoEgreso, descripcionEgreso);
                    gestor.agregarTransaccion(egreso);
                    break;
                case "3":
                    System.out.println("Número de transacción a eliminar: ");
                    int indice = Integer.parseInt(sc.nextLine());
                    gestor.eliminarTransaccion(indice);
                    break;
                case "4":
                    gestor.mostrarTransacciones();
                    break;
                case "5":
                    menu = false;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");

                default:
                    System.out.println("Opción invalida. Intente de nuevo.");

            }
        }

        sc.close();
    }


}