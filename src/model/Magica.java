package model;

// Clase Magico que hereda de Personaje y representa un personaje mágico en el juego
// 🧙‍♂️
public class Magica extends Personaje {
    // Constructor
    public Magica(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    // Métodos
    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Atacando... 🪄");
    }

    @Override
    public void subirNivel() {
        super.setNivel(super.getNivel() + 1);
        System.out.println("🎉 ¡Has subido de nivel! Nivel actual: " + super.getNivel());
    }
}
