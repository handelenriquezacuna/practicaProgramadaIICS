package SistemaGestionTransaccionesFinancieras;

import SistemaGestionTransaccionesFinancieras.Gestor.GestorTransacciones;
import SistemaGestionTransaccionesFinancieras.Menu.MenuInteractivo;

import static java.awt.SystemColor.menu;

public class Main {
    public static void main(String[] args) {
        GestorTransacciones gestor = new GestorTransacciones();
        MenuInteractivo menu = new MenuInteractivo(gestor);
        menu.mostrarMenu();
    }
}
