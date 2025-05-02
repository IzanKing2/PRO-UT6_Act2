package controller;

import model.Juego;
import model.Personaje;
import model.TipoPersonaje;
import view.VistaJuego;

import java.util.ArrayList;
import java.util.Scanner;

public class ControladorJuego {
    // Atributos _____________________
    private Juego juego;
    private VistaJuego vistaJuego;
    private Scanner scanner;
    private boolean iniciado;

    // Constructor _____________________________________________________
    public ControladorJuego(Juego juego, VistaJuego vistaJuego) {
        this.juego = juego;
        this.vistaJuego = vistaJuego;
        this.scanner = new Scanner(System.in); // scanner para leer la entrada del usuario
        this.iniciado = false; // Inicializa el estado del juego como no iniciado
    }

    // Métodos ____________________________________________________________________
    /**
     * Inicia el flujo principal del juego.
     */
    public void iniciarJuego() {
        vistaJuego.imprimir("Bienvenido al juego de batalla\n".toUpperCase());
        setIniciado(true); // Cambia el estado del juego a iniciado
    }

    public boolean juegoIniciado(boolean iniciado) {
        if (iniciado) {
            return true; // El juego ya ha sido iniciado
        } else {
            return false; // El juego no ha sido iniciado
        }
    }

    /**
     * Permite al usuario seleccionar los personajes para la batalla.
     * @param personajes Lista de personajes disponibles.
     * @return El personaje seleccionado por el usuario.
     */
    private Personaje seleccionarPersonajes(ArrayList<Personaje> personajes) {
        while (true) { // Bucle para asegurar una selección válida
            System.out.print("Selecciona el personaje: ");
            String nombre = scanner.nextLine(); // Leer el nombre del personaje
            for (Personaje p : personajes) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    return p; // Retorna el personaje seleccionado
                }
            }
            System.out.println("Personaje no encontrado. Intenta de nuevo.");
        }
    }

    /**
     * Crea un personaje basado en la selección del usuario.
     * @return Un personaje creado.
     */
    private Personaje crearPersonaje() {
        vistaJuego.imprimir("Elige un tipo de personaje:");
        vistaJuego.imprimir("├── 1. Mago");
        vistaJuego.imprimir("├── 2. Hechicero");       
        // Poner aquí el resto de personajes

        System.out.print("\n- Tipo de personaje: ");
        int opcion = leerOpcion(); // Leer la opción elegida por el usuario
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("\n- Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine(); // Leer el nombre del personaje

        switch (opcion) {
            // Creando Mago
            case 1:
                return TipoPersonaje.MAGO.crearPersonaje(TipoPersonaje.MAGO, nombre);
            // Creando Hechicero
            case 2:
                return TipoPersonaje.HECHICERO.crearPersonaje(TipoPersonaje.HECHICERO, nombre);
            // Agregar más casos para otros tipos de personajes
            // Por defecto, si no se selecciona un tipo válido, vuelve a llamar a crearPersonaje
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                return crearPersonaje(); // Llama de nuevo al método para seleccionar un personaje
        }
    }

    /**
     * Inicia la batalla entre los personajes seleccionados.
     */
    private void iniciarBatalla() {
        if (juego.getPersonajes().size() < 2) {
            vistaJuego.imprimir("No hay suficientes personajes para iniciar la batalla.");
            return;
        }

        mostrarPersonajesDisponibles();
        Personaje personaje1 = seleccionarPersonajes(juego.getPersonajes());
        mostrarPersonajesDisponibles();
        Personaje personaje2 = seleccionarPersonajes(juego.getPersonajes());

        if (personaje1 == null || personaje2 == null) { // Validación adicional (por seguridad)
            vistaJuego.imprimir("Error al seleccionar personajes. Intenta de nuevo.");
            return;
        }

        vistaJuego.imprimir("Iniciando batalla entre " + personaje1.getNombre() + " y " + personaje2.getNombre() + "...");
        juego.iniciarBatalla(personaje1, personaje2);
    }

    /**
     * Lee la opción ingresada del menú principal.
     * - Opción 1: Mostrar instrucciones
     * - Opción 2: Iniciar juego
     * - Opción 3: Salir del juego
     * - Opción 4: Crear personaje
     * - Opción 5: Ver estadísticas de los personajes
     * - Opción 6: Combatir
     * Si la opción no es válida, vuelve a mostrar el menú principal.
     */
    public void leerOpcionMenuPrincipal() {
        System.out.print("\nIngrese su opción: ");
        int opcion = leerOpcion(); // Leer la opción elegida por el usuario

        switch (opcion) {
            case 1: // Mostrar instrucciones
                juego.mostrarInstrucciones(); // Muestra las instrucciones del juego
                break;
            case 2: // Iniciar juego
                if (iniciado) {
                    vistaJuego.imprimir("\nEl juego ya ha sido iniciado.");
                } else {
                    vistaJuego.imprimir("\nIniciando juego...");
                    iniciarJuego(); // Inicia el juego
                }
                break;
            case 3: // Salir del juego
                if (!iniciado) {
                    vistaJuego.imprimir("\nEl juego no ha sido iniciado.");
                } else {
                    vistaJuego.imprimir("\nSaliendo del juego...");
                    setIniciado(false); // Cambia el estado del juego a no iniciado
                    System.exit(0); // Sale del juego
                }
                break;
            case 4: // Crear personaje
                System.out.println("\n┌──── CREAR PERSONAJE ───────────────────────┐");
                if (!verificarJuegoIniciado()) return;
                Personaje personaje = crearPersonaje(); // Crea un nuevo personaje
                juego.agregarPersonaje(personaje); // Agrega el personaje a la lista de personajes
                System.out.println("Personaje creado: " + personaje.getNombre() + " (" + personaje.getTipo() + ")");
                System.out.println("└────────────────────────────────────────────┘");
                break;
            case 5: // Ver estadísticas de los personajes
                System.out.println("\n┌──── ESTADÍSTICAS DE LOS PERSONAJES ────────┐");
                if (!verificarJuegoIniciado()) return;
                mostrarPersonajesDisponibles(); // Muestra las estadísticas de todos los personajes
                System.out.println("└────────────────────────────────────────────┘");
                break;
            case 6: // Combatir
                System.out.println("\n┌──── COMBATE ──────────────────────────────┐");
                if (!verificarJuegoIniciado()) return;
                iniciarBatalla(); // Inicia la batalla entre los personajes
                System.out.println("└────────────────────────────────────────────┘");
                break;
            default:
                System.out.println("\nOpción no válida. Intenta de nuevo.");
                leerOpcionMenuPrincipal(); // Llama de nuevo al método para leer la opción
                break;
        }
    }

    /**
     * Método para mostrar todos los personajes disponibles en el juego.
     * Este método recorre la lista de personajes y muestra sus nombres y tipos.
     */
    public void mostrarPersonajesDisponibles() {
        System.out.println("┌──── PERSONAJES ──────────────────────────────┐");
        for (Personaje p : juego.getPersonajes()) {
            vistaJuego.imprimir(p.toString()); // Muestra las estadísticas de cada personaje
        }
        System.out.println("└──────────────────────────────────────────────┘");
    }

    private int leerOpcion() {
        return scanner.nextInt(); // Leer la opción elegida por el usuario
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado; // Cambia el estado del juego a iniciado o no iniciado
    }

    /**
     * Verifica si el juego está iniciado. Si no lo está, muestra un mensaje y retorna false.
     * @return true si el juego está iniciado, false en caso contrario.
     */
    private boolean verificarJuegoIniciado() {
        if (!iniciado) {
            vistaJuego.imprimir("El juego no ha sido iniciado. Por favor, inícialo primero.");
            return false;
        }
        return true;
    }
}
