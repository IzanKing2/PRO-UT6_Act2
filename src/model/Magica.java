package model;

// Clase Magico que hereda de Personaje y representa un personaje mágico en el juego
// 🧙‍♂️
public class Magica extends Personaje {
    // Constructor ______________________________________________________
    public Magica(String nombre, int nivel, int salud, int daño) {
        super(nombre, nivel, salud, daño);
    }

    // Métodos __________________________________________________________
    /**
     *  Método para atacar a otro personaje
     *  @param enemigo el personaje enemigo al que se va a atacar
     */
    @Override
    public void atacar(Personaje enemigo) {
        int daño = super.getDaño();
        enemigo.setSalud(enemigo.getSalud() - daño);
        System.out.println("🪄 Atacaste a " + enemigo.getNombre() + " e infligiste " + daño + " puntos de daño.");
    }

    /**
     *  Método para subir de nivel
     *  Se incrementa el nivel del personaje en 1
     *  @throws IllegalArgumentException si el nivel es menor que 1 o mayor que 60
     */
    @Override
    public void subirNivel() {
        super.setNivel(super.getNivel() + 1);
        System.out.println("🎉 ¡Has subido de nivel! Nivel actual: " + super.getNivel());
    }
}
