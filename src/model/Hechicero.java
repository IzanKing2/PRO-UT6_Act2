package model;

import model.interfaces.*;

// Clase Hechicero que hereda de la clase Magico y representa un personaje hechicero en el juego
// 🧙‍♂️
public class Hechicero extends Magica implements Magico, Defendible {
    // Constantes _______________
    private static final int COSTO_HECHIZO = 8;
    private static final int DEFENSA = 20;
    private static final int COSTO_DEFENSA = 40;

    // Atributos ______________
    private int maxMana = 80;
    private int maxSalud = 40;
    private int maxDaño = 15;
    private int maxConcentracion = 90;
    private int mana;
    private int concentracion;

    // Constructor __________________________________________________
    public Hechicero(String nombre) {
        super(nombre, 1, 40, 20); // Salud inicial
        this.mana = maxMana;
        this.concentracion = maxConcentracion;
    }

    // Métodos _____________________________
    
    

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
            this.setSalud(this.getSalud() + DEFENSA);
        }
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
        this.mana = mana;
    }

    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }
}
