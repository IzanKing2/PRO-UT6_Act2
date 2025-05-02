package model;

import model.interfaces.Volador;

// Clase Arquero que hereda de la clase Fisico y representa un personaje arquero en el juego
// 🏹


public class Arquero extends Fisico implements Volador{
    
    // Atributos de la clase Arquero
    private int numFlechas;
    private int agilidad;

    // Constructor de la clase Arquero
    public Arquero(String nombre) {
        super(nombre, 1, 55, 20); // Llamada al constructor de la clase padre Fisico
        this.numFlechas = 10; // Inicializa el número de flechas a 10
        this.agilidad = 5; // Inicializa la agilidad a 5
    }

    // Métodos de la clase Arqueroº

    @Override
    public void volar() {
        System.out.println("El arquero " + super.getNombre() + " está volando.");
    }

    public void dispararFlecha() {
        if (numFlechas > 0) {
            System.out.println("El arquero " + super.getNombre() + " dispara una flecha.");
            numFlechas--;
        } else {
            System.out.println("No quedan flechas para disparar.");
        }
    }

    public void restablecerFlechas() {
        numFlechas = 10; // Restablece el número de flechas a 10
        System.out.println("El número de flechas se ha restablecido a " + numFlechas + ".");
    }

    public void menuCombate() {
        System.out.println("Menú de combate del arquero " + super.getNombre() + ":");
        System.out.println("1. Disparar flecha");
        System.out.println("2. Volar");
        System.out.println("3. Atacar cuerpo a cuerpo");
        System.out.println("4. Curarse");
    }
    public void atacar(Personaje enemigo) {
        super.atacar(enemigo); // Llama al método atacar de la clase padre
        System.out.println("El arquero ataca con flechas.");
    }

    public String toString(){
        return "Arquero{" +
                "numFlechas=" + numFlechas +
                ", agilidad=" + agilidad +
                ", nombre='" + super.getNombre() + '\'' +
                ", nivel=" + super.getNivel() +
                ", salud=" + super.getSalud() +
                ", daño=" + super.getDaño() +
                '}';
    }


    public void realizarAccion(int opcion, Personaje enemigo) {
        switch (opcion) {
            case 1: // Disparar flecha
                System.out.println("Disparando flecha...");
                dispararFlecha();
                break;
            case 2: // Volar
                System.out.println("Volando...");
                volar();
                break;
            default: 
                System.out.println("Acción no válida. Seleccione otra opción.");
                break;
        }
    }

    // __getters y setters ______________________________________________________
    public int getNumFlechas() {
        return numFlechas;
    }
    public void setNumFlechas(int numFlechas) {
        this.numFlechas = numFlechas;
    }
    public int getAgilidad() {
        return agilidad;
    }
    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
        
    }
}
