package model;

import model.interfaces.Curable;
import model.interfaces.Movilizable;

// Clase Asesino que hereda de la clase Fisico y representa un personaje asesino en el juego
// 🗡️
public class Asesino extends Fisico implements Movilizable, Curable{
    private int sigilo;
    private int critico;

    public Asesino(String nombre) {
        super(nombre, 100, 20, 30); // Llama al constructor de la clase padre Fisico
        this.sigilo = 15; // Inicializa el atributo sigilo
        this.critico = 25; // Inicializa el atributo critico
    }

    public void mover() {
        System.out.println("El asesino se mueve sigilosamente.");
    }

    public void curar() {
        System.out.println("El asesino se cura a sí mismo.");
        super.setSalud(super.getSalud() + 10); // Aumenta la vida del asesino al curarse
    }

    public void atacar(Personaje enemigo) {
        System.out.println("El asesino ataca");
    }

    

    public String toString() {
        return "Asesino{" +
                "sigilo=" + sigilo +
                ", critico=" + critico +
                ", nombre='" + super.getNombre() + '\'' +
                ", salud=" + super.getSalud() +
                ", daño=" + super.getDaño() +
                '}';
    }
    
    public void menuCombate() {
        System.out.println("1. Atacar");
        System.out.println("2. Curar");
        System.out.println("3. Moverse");
    }

    public void realizarAccion(int opcion, Personaje enemigo) {
        switch (opcion) {
            case 1:
                System.out.println("Elige un enemigo para atacar:");
                atacar(enemigo);
                break;
            case 2:
                System.out.println("Elige un enemigo para curar:");
                curar();
                break;
            case 3:
                System.out.println("Elige un enemigo para moverse:");
                mover();
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }
    


    // _______________________________ Getters y Setters ______________________________________
    public int getSigilo() {
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }


}

