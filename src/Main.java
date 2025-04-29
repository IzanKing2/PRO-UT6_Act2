import controller.ControladorJuego;
import model.Juego;
import view.VistaJuego;
import java.util.Scanner;

public class Main {
    /**
     * Método principal que inicia el juego.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Inicializar el modelo
        Juego juego = new Juego();

        // Inicializar la vista
        VistaJuego vistaJuego = new VistaJuego();

        // Inicializar el controlador
        ControladorJuego controlador = new ControladorJuego(juego, vistaJuego);

        // Mostrar el menú principal
        while (true) {
            vistaJuego.menu();
            controlador.leerOpcionMenuPrincipal();

            // Esperar a que el usuario presione Enter para continuar
            vistaJuego.imprimir("Presiona Enter para continuar...");
            scanner.nextLine();
        }
    }
}