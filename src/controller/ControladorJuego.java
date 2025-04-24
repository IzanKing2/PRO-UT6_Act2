package controller;

import model.Personaje;
import model.Juego;

// 👀 Maneja el flujo entre el juego y lo que el usuario ve
public class ControladorJuego {
    // Atributos
    Juego juego = new Juego();

    // Métodos
    public void añadirPersonaje(Personaje personaje) {
        juego.getPersonajes().add(personaje);
    }
}
