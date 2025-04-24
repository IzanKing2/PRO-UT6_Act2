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

    // Getters
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
