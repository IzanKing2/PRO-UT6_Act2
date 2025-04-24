package model;

import model.interfaces.*;

// Clase Mago que hereda de la clase Magico y representa un personaje mago en el juego
// 🧙‍♂️
public class Mago extends Magica implements Magico, Curable {
    // Atributos ___________
    private int mana;
    private int sabiduria;

    // Constructor ______________________________________
    public Mago(String nombre, int nivel, int salud, int mana, int sabiduria) {
        super(nombre, nivel, salud);
        this.mana = mana;
        this.sabiduria = sabiduria;
    }

    // Métodos ____________________
    @Override
    public void lanzarHechizo() {
        
    }

    @Override
    public void curar() {
        
    }

    // Getters ____________________
    public int getMana() {
        return mana;
    }

    public int getSabiduria() {
        return sabiduria;
    }
}
