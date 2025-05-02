package model;

// Clase Fisico que hereda de Personaje y representa un personaje físico en el juego
// 🏋️‍♂️

public class Fisico extends Personaje {

    // Constructor ______________________________________________________
    public Fisico(String nombre, int nivel, int salud, int daño) {
        super(nombre, nivel, salud, daño);
    }

    // Métodos __________________________________________________________
    /**
     *  Método para atacar a otro personaje
     *  @param enemigo el personaje enemigo al que se va a atacar
     */
    @Override
    public void realizarAccion(int opcion, Personaje enemigo) {
        System.out.println("Realizando acción física...");
        // Lógica para realizar una acción física
    }

    @Override
    public void atacar(Personaje enemigo) {
        int daño = super.getDaño();
        enemigo.setSalud(enemigo.getSalud() - daño);
        System.out.println(" Atacaste a " + enemigo.getNombre() + " e infligiste " + daño + " puntos de daño.");
    }

    @Override
    public void menuCombate() {
        System.out.println("__MENÚ DE COMBATE MÁGICO__");
    }

    @Override
    public void subirNivel() {
        super.setNivel(super.getNivel() + 1);
        System.out.println("🎉 ¡Has subido de nivel! Nivel actual: " + super.getNivel());
    }

    
    
}

