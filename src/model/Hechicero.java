package model;

import model.interfaces.*;

// Clase Hechicero que hereda de la clase Magico y representa un personaje hechicero en el juego
// 🧙‍♂️
public class Hechicero extends Magica implements Magico, Defendible {
    // Atributos ______________
    private int mana;
    private int concentracion;

    // Constructor __________________________________________________
    public Hechicero(String nombre) {
        super(nombre, 1, 60);
        this.mana = 80;
        this.concentracion = 90;
    }

    // Métodos _____________________________
    @Override
    public void lanzarHechizo() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void defender() {
        // TODO Auto-generated method stub
        
    }

    // Getters _________________
    public int getMana() {
        return mana;
    }

    public int getConcentracion() {
        return concentracion;
    }

    
}
