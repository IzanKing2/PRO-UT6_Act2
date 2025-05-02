package model;

import model.interfaces.Defendible;

// Clase Guerrero que hereda de la clase Fisico y representa un personaje guerrero en el juego
// 🛡️

public class Guerrero extends Fisico implements Defendible {
    // Constantes ________________________________________________________
    private static final int COSTOFUERZA = 5; // Multiplicador de ataque del Guerrero
    private static final int DEFENSA_EXTRA = 2; // Defensa extra por nivel del Guerrero
    private static final int DEFENSA_MAXIMA = 20; // Defensa máxima del Guerrero

    // Atributos _________________________________________________________
    private int fuerza;
    private int armadura;
    private int escudo;

    // Constructor _______________________________________________________
    public Guerrero(String nombre, int nivel, int salud, int daño, int fuerza, int armadura, int escudo) {
        super(nombre, nivel, salud, daño); // Llama al constructor de la clase base (Fisico)
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo = escudo;
    }

    // Métodos ___________________________________________________________

    /**
     * Método para cargar un ataque basado en la fuerza del Guerrero.
     * @return el daño calculado.
     */
    public int cargarAtaque() {
        return fuerza * COSTOFUERZA;
    }

    /**
     * Método para defenderse, calculando la defensa total.
     * @return el valor de defensa calculado.
     */
    @Override
    public void defender() {
        int defensaTotal = armadura + escudo + DEFENSA_EXTRA;
        Math.min(defensaTotal, DEFENSA_MAXIMA);
    }

    // Getters y Setters _________________________________________________
    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }
}

