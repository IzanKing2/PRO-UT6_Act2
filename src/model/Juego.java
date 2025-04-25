package model;

import java.util.ArrayList;

// Clase Juego que representa el juego en sí
// y contiene la lógica principal del mismo
// 🎮
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
     */
    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
        System.out.println("✅ Personaje " + personaje.getNombre() + " agregado al juego.");
    }

    /**
     * Inicia una batalla entre dos personajes.
     * @param personaje1 El primer personaje.
     * @param personaje2 El segundo personaje.
     */
    public void batalla(Personaje personaje1, Personaje personaje2) {
        batalla.batalla(personaje1, personaje2); // Llama al método de la clase Batalla
    }

    // Getters y Setters
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
