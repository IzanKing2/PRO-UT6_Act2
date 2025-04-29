package model;

import java.util.ArrayList;

public class Juego {
    // Atributos
    private ArrayList<Personaje> personajes;
    private int turno;
    private Batalla batalla; // Objeto Batalla para manejar la lógica de combate

    // Constructor
    public Juego() {
        personajes = new ArrayList<>();
        turno = 1;
        batalla = new Batalla(); // Inicializa el objeto Batalla
    }

    // Métodos
    /**
     * Agrega un personaje al juego.
     * @param personaje El personaje a agregar.
     * @throws IllegalArgumentException Si el personaje es nulo.
     */
    public void agregarPersonaje(Personaje personaje) {
        if (personaje == null) {
            throw new IllegalArgumentException("El personaje no puede ser nulo.");
        }
        personajes.add(personaje);
    }

    /**
     * Inicia una batalla entre dos personajes.
     * @param personaje1 El primer personaje.
     * @param personaje2 El segundo personaje.
     */
    public void iniciarBatalla(Personaje personaje1, Personaje personaje2) {
        if (personaje1 == null || personaje2 == null) {
            throw new IllegalArgumentException("Ambos personajes deben ser válidos para iniciar la batalla.");
        }
        batalla.batalla(personaje1, personaje2); // Llama al método de la clase Batalla
    }

    /**
     * Muestra las instrucciones del juego.
     */
    public void mostrarInstrucciones() {
        System.out.println("\n┌──── INSTRUCCIONES DEL JUEGO ──────────────────┐");
        System.out.println("│ 1. Selecciona dos personajes para la batalla. │");
        System.out.println("│ 2. Cada personaje tiene habilidades únicas.   │");
        System.out.println("│ 3. Durante la batalla, elige acciones como:   │");
        System.out.println("│    - Atacar                                   │");
        System.out.println("│    - Lanzar hechizos                          │");
        System.out.println("│    - Defenderse                               │");
        System.out.println("│    - Curarse                                  │");
        System.out.println("│ 4. El objetivo es reducir la salud del        │");
        System.out.println("│    enemigo a 0 para ganar la batalla.         │");
        System.out.println("│ 5. ¡Sube de nivel y mejora tus habilidades!   │");
        System.out.println("└───────────────────────────────────────────────┘");
    }

    // Getters y Setters
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        if (personajes == null) {
            throw new IllegalArgumentException("La lista de personajes no puede ser nula.");
        }
        this.personajes = personajes;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        if (turno < 1) {
            throw new IllegalArgumentException("El turno debe ser mayor o igual a 1.");
        }
        this.turno = turno;
    }
}
