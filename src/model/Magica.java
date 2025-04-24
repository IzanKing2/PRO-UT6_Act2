package model;

// Clase Magico que hereda de Personaje y representa un personaje mágico en el juego
// 🧙‍♂️
public class Magica extends Personaje{
    // Constructor
    public Magica(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    // Métodos
    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Atacando... 🪄");
    }
}
