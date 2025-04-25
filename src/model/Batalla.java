package model;

import java.util.Scanner;

public class Batalla {
    private static final int TURNO_PERSONAJE_1 = 1;
    private static final int TURNO_PERSONAJE_2 = 2;

    private Scanner sc = new Scanner(System.in);
    private int turno = TURNO_PERSONAJE_1;

    /**
     * Constructor de la clase Batalla.
     * Inicializa los personajes y el turno.
     * @param personaje1 El primer personaje que participará en la batalla.
     * @param personaje2 El segundo personaje que participará en la batalla.
     */
    public void batalla(Personaje personaje1, Personaje personaje2) {
        System.out.println("⚔️ Batalla entre " + personaje1.getNombre() + " y " + personaje2.getNombre() + "!");

        // Mientras ambos personajes tengan salud, la batalla continúa ⚔️
        while (personaje1.getSalud() > 0 && personaje2.getSalud() > 0) {
            if (turno == TURNO_PERSONAJE_1) {
                System.out.println("Turno de " + personaje1.getNombre() + ":");
                System.out.println(personaje1);
                System.out.println(personaje2);
                ejecutarTurno(personaje1, personaje2);
                turno = TURNO_PERSONAJE_2;
            } else {
                System.out.println("Turno de " + personaje2.getNombre() + ":");
                System.out.println(personaje1);
                System.out.println(personaje2);
                ejecutarTurno(personaje2, personaje1);
                turno = TURNO_PERSONAJE_1;
            }
        }

        // Fin de la batalla, se determina el ganador
        determinarGanador(personaje1, personaje2);
    }

    /**
     * Ejecuta el turno de un personaje.
     * @param atacante El personaje que realiza la acción.
     * @param defensor El personaje que recibe la acción.
     */
    private void ejecutarTurno(Personaje atacante, Personaje defensor) {
        atacante.menuCombate();
        int opcion = leerOpcion();
        atacante.realizarAccion(opcion, defensor);
    }

    /**
     * Lee la opción ingresada por el usuario de forma segura.
     * @return La opción seleccionada por el usuario.
     */
    private int leerOpcion() {
        int opcion = -1;
        while (true) {
            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                sc.nextLine(); // Limpiar el buffer en caso de error
            }
        }
        return opcion;
    }

    /**
     * Determina el ganador de la batalla y muestra el resultado.
     * @param personaje1 El primer personaje.
     * @param personaje2 El segundo personaje.
     */
    private void determinarGanador(Personaje personaje1, Personaje personaje2) {
        if (personaje1.getSalud() <= 0) {
            System.out.println("💀 " + personaje1.getNombre() + " ha sido derrotado!");
            personaje2.subirNivel(); // El personaje 2 sube de nivel
        } else {
            System.out.println("💀 " + personaje2.getNombre() + " ha sido derrotado!");
            personaje1.subirNivel(); // El personaje 1 sube de nivel
        }
    }
}
