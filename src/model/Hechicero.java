package model;

import model.interfaces.*;

// Clase Hechicero que hereda de la clase Magico y representa un personaje hechicero en el juego
// 🧙‍♂️
public class Hechicero extends Magica implements Magico, Defendible {
    // Constantes _______________
    private static final int COSTO_HECHIZO = 5;
    private static final int REGENERACION_MANA = 30;
    private static final int DEFENSA = 50;

    // Atributos ______________
    private int maxMana = 80;
    private int maxSalud = 40;
    private int maxDaño = 15;
    private int mana;
    private int concentracion;

    // Constructor __________________________________________________
    public Hechicero(String nombre) {
        super(nombre, 1, 40, 20); // Salud inicial
        this.mana = maxMana;
        this.concentracion = 90;
    }

    // Métodos _____________________________
    @Override
    public void lanzarHechizo() {
        System.out.println("✨ Lanzando hechizo...");
        if (this.mana < COSTO_HECHIZO) {
            System.out.println("❌ No tienes suficiente mana para lanzar un hechizo.");
        } else {
            this.mana -= COSTO_HECHIZO;
            System.out.println("✅ Hechizo lanzado con éxito. Mana restante: " + this.mana);
        }
    }

    @Override
    public void defender() {
        // TODO Auto-generated method stub
        
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
