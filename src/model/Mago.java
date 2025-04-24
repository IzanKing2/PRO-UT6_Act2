package model;

import model.interfaces.*;

// Clase Mago que hereda de la clase Magico y representa un personaje mago en el juego
// 🧙‍♂️
public class Mago extends Magica implements Magico, Curable {
    // Atributos ___________
    private int mana;
    private int sabiduria;

    // Constructor ______________________________________
    public Mago(String nombre) {
        super(nombre, 1, 60);
        this.mana = 50;
        this.sabiduria = 60;
    }

    // Métodos ____________________
    @Override
    public void lanzarHechizo() {
        
    }

    @Override
    public void curar() {
        
    }

    @Override
    public String toString() {
        return "Mago [Nivel: " + super.getNivel() + "Salud: " + super.getSalud() + "Mana: " + this.mana + "Sabiduria: " + this.sabiduria + "]";
    }

    // Getters ____________________
    public int getMana() {
        return mana;
    }

    public int getSabiduria() {
        return sabiduria;
    }
}
