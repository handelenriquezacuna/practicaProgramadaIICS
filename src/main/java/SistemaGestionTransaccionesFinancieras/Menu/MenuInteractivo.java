package SistemaGestionTransaccionesFinancieras.Menu;
import java.util.Scanner;

public class MenuInteractivo {

    private MenuInteractivo sistema;

    public void Menu(MenuInteractivo sistema) {
        this.sistema = sistema;
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

            }
        }
    }


}
