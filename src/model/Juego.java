package model;

import java.util.ArrayList;

// Clase Juego que representa el juego en sí
// y contiene la lógica principal del mismo
// 🎮
public class Juego {
    // Atributos
    private ArrayList<Personaje> personajes;
    private int turno;

    // Constructor
    public Juego() {
        personajes = new ArrayList<>();
        turno = 1;
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
