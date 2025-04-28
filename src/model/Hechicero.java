package model;

import model.interfaces.*;

// Clase Hechicero que hereda de la clase Magico y representa un personaje hechicero en el juego
// 🧙‍♂️
public class Hechicero extends Magica implements Magico, Defendible {
    // Constantes _________________________________
    private static final int COSTO_HECHIZO = 10;
    private static final int COSTO_DEFENSA = 30;

    // Atributos ____________________
    private int maxDefensa = 20;
    private int maxDañoHechizo = 15;
    private int maxMana = 60;
    private int maxSalud = 40;
    private int maxDaño = 5;
    private int maxConcentracion = 60;

    private int mana;
    private int concentracion;
    private int defensa;
    private int dañoHechizo;

    // Constructor __________________________________________________
    public Hechicero(String nombre) {
        super(nombre, 1, 40, 5); // Salud y daño inicial
        this.mana = maxMana;
        this.concentracion = maxConcentracion;
        this.defensa = maxDefensa;
        this.dañoHechizo = maxDañoHechizo;
    }

    // Métodos _________________________________________________________________
        /**
     * Metodo para mostrar el menú de combate del mago.
     * Este método muestra las opciones de combate disponibles para el mago.
     * Incluye lanzar hechizos, atacar y curarse.
     */
    @Override
    public void menuCombate() {
        super.menuCombate();
        System.out.println("├── 1. ⚔️ Atacar");
        System.out.println("├── 2. ✨ Lanzar hechizo (Costo: " + COSTO_HECHIZO + " mana)");
        System.out.println("├── 3. 🛡️ Defender (Costo: " + COSTO_DEFENSA + " concentración)");
        System.out.println("└── 4. 🧙‍♂️ Invocar entidad (Costo: " + COSTO_HECHIZO + " mana y concentración)");
        System.out.print("\nSelecciona una opción: ");
    }

        /**
     * Método para realizar una acción en el combate.
     * Este método se encarga de ejecutar la acción seleccionada por el jugador.
     * @param opcion La opción seleccionada por el jugador
     * @param enemigo El personaje enemigo al que se le va a atacar
     */
    @Override
    public void realizarAccion(int opcion, Personaje enemigo) {
        super.realizarAccion(opcion, enemigo);
        switch (opcion) {
            case 1: // Atacar
                System.out.println("Atacando...");
                atacar(enemigo);
                break;
            case 2: // Lanzar hechizo
                System.out.println("Lanzando hechizo...");
                lanzarHechizo(enemigo);
                break;
            case 3: // Defender
                System.out.println("Defendiendo...");
                defender();
                break;
            case 4: // Invocar entidad
                System.out.println("Invocando entidad...");
                invocarEntidad();
                break;
            default: // Pasar turno
                System.out.println("Pasando turno...");
                break;
        }
    }

    /**
     *  Se defiende, reduciendo la concentración del hechicero.
     *  Si no tiene suficiente concentración, no puede defenderse.
     *  Ya que la defensa es mágica, se suma a la salud del hechicero.
     */
    @Override
    public void defender() {
        System.out.println("🛡️ Defendiendo con magia...");
        if (this.concentracion < COSTO_DEFENSA) {
            System.out.println("❌ No tienes suficiente concentración");
        } else {
            this.concentracion -= COSTO_DEFENSA;
            System.out.println("DEFENSA aplicada con exito");
            this.setSalud(this.getSalud() + defensa);
        }
    }

    /**
     * Método toString para mostrar la información del hechicero.
     * Muestra el nombre, nivel, salud, daño, mana y concentración.
     */
    @Override
    public String toString() {
        return "Hechicero [nombre=" + super.getNombre() + ", nivel=" + super.getNivel() + ", salud=" + super.getSalud() +
                ", daño=" + super.getDaño() + ", mana=" + mana + ", concentración=" + concentracion + "]";
    }

    /**
     *  Ataca a un enemigo, infligiendo daño y lanzando un hechizo.
     *  @param enemigo El personaje enemigo al que se le va a atacar
     */
    @Override
    public void atacar(Personaje enemigo) {
        super.atacar(enemigo); // Llama al método atacar de la clase base
        System.out.println("🪄 El hechicero usa magia para potenciar su ataque.");
    }

    /**
     * Lanza un hechizo, reduciendo el mana del hechicero.
     * Si no tiene suficiente mana, no puede lanzar el hechizo.
     * @param enemigo El personaje enemigo al que se le va a lanzar el hechizo.
     */
    @Override
    public void lanzarHechizo(Personaje enemigo) {
        System.out.println("✨ Lanzando hechizo...");
        if (this.mana < COSTO_HECHIZO) {
            System.out.println("❌ No tienes suficiente mana para LANZAR UN HECHIZO.");
        } else {
            this.mana -= COSTO_HECHIZO;
            enemigo.setSalud(enemigo.getSalud() - dañoHechizo);
            System.out.println("✅ Hechizo lanzado con éxito. Mana restante: " + this.mana);
        }
    }

    /**
     * Invoca una entidad mágica, reduciendo la concentración y el mana del hechicero.
     * Si no tiene suficiente concentración o mana, no puede invocar la entidad.
     * Al invocar una entidad, se aumenta la salud y el daño del hechicero.
     */
    public void invocarEntidad() {
        System.out.println("🧙‍♂️ Invocando entidad mágica...");
        if (this.concentracion < COSTO_HECHIZO  && this.mana < COSTO_HECHIZO) {
            System.out.println("❌ No tienes suficiente concentración para invocar una entidad.");
        } else {
            this.concentracion -= COSTO_HECHIZO;
            this.mana -= COSTO_HECHIZO;

            // Mejoras
            // Salud
            super.setSalud(super.getSalud() + 10); // Aumenta la salud del hechicero al invocar una entidad
            // Daño
            maxDaño += 5; // Aumenta el daño del hechicero al invocar una entidad
            super.setDaño(maxDaño); // Aumenta el daño del hechicero al invocar una entidad

            System.out.println("✅ Entidad mágica invocada con éxito. Concentración restante: " + this.concentracion);
        }
    }

    /**
     *  Aumenta el nivel del hechicero, incrementando su salud máxima, mana y sabiduría.
     *  Al subir de nivel, se aumenta el daño del hechicero y la curación máxima.
     */
    @Override
    public void subirNivel() {
        // Salud
        this.maxSalud += 4; // Aumenta la salud máxima al subir de nivel
        this.setSalud(maxSalud); // Restaura la salud al máximo
        // Mana
        this.maxMana += 4; // Aumenta el mana máximo al subir de nivel
        this.mana = maxMana; // Restaura el mana al máximo
        // Sabiduría
        this.maxConcentracion += 2; // Aumenta la sabiduría
        this.concentracion = maxConcentracion; // Restaura la sabiduría al máximo
        // Daño del hechizo
        this.maxDañoHechizo += 2; // Aumenta el daño del hechizo
        this.dañoHechizo = maxDañoHechizo; // Restaura el daño del hechizo al máximo
        // Daño
        super.setDaño(super.getDaño() + 2); // Aumenta el daño del mago al subir de nivel
        // Defensa
        this.maxDefensa += 2; // Aumenta la curación máxima al subir de nivel
        this.defensa = maxDefensa; // Restaura la curación al máximo

        super.subirNivel();
    }

    // Getters y Setters _________________
    public int getMana() {
        return mana;
    }

    public int getConcentracion() {
        return concentracion;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setMaxSalud(int maxSalud) {
        this.maxSalud = maxSalud;
    }

    public void setMana(int mana) {
        if (mana < 0 || mana > maxMana) {
            throw new IllegalArgumentException("El mana debe estar entre 0 y " + maxMana);
        }
        this.mana = mana;
    }

    public void setConcentracion(int concentracion) {
        if (concentracion < 0 || concentracion > maxConcentracion) {
            throw new IllegalArgumentException("La concentración debe estar entre 0 y " + maxConcentracion);
        }
        this.concentracion = concentracion;
    }
}
