package model;

import model.interfaces.Defendible;

// Clase Guerrero que hereda de la clase Fisico y representa un personaje guerrero en el juego
// 🛡️

public class Guerrero extends Fisico implements Defendible {
    // Constantes ________________________________________________________
    private static final int COSTOFUERZA = 5; // Multiplicador de ataque del Guerrero
    private static final int DEFENSA_EXTRA = 2; // Defensa extra por nivel del Guerrero
    private static final int COSTO_ESCUDO = 5; // Defensa máxima del Guerrero

    // Atributos _________________________________________________________
    private int maxFuerza = 10; // Fuerza máxima del Guerrero
    private int maxArmadura = 15; // Armadura máxima del Guerrero
    private int maxEscudo = 10; // Escudo máximo del Guerrero
    private int maxConcentracion = 100; // Concentración máxima del Guerrero

    private int fuerza;
    private int armadura;
    private int escudo;
    private int concentracion; // Concentración del Guerrero

    // Constructor _______________________________________________________
    public Guerrero(String nombre) {
        super(nombre, 1,75, 25); // Llama al constructor de la clase base (Fisico)
        this.fuerza = maxFuerza;
        this.armadura = maxArmadura;
        this.escudo = maxEscudo;
        this.concentracion = maxConcentracion; // Inicializa la concentración
    }

    // Métodos ___________________________________________________________

    public void menuCombate() {
        super.menuCombate(); // Llama al método de la clase base (Fisico)
        System.out.println("├── 1. ⚔️ Atacar");
        System.out.println("├── 2. 🛡️ Defender (Costo: " + DEFENSA_EXTRA + " concentración)");
        System.out.println("└── 3. 🛡️ Usar escudo (Costo: " + COSTO_ESCUDO + " concentración)");
        System.out.print("\nSelecciona una opción: ");
    }


    public void realizarAccion(int opcion, Personaje enemigo) {
        super.realizarAccion(opcion, enemigo); // Llama al método de la clase base (Fisico)
        switch (opcion) {
            case 1: // Atacar
                cargarAtaque(enemigo); // Llama al método cargarAtaque
                break;
            case 2: // Defender
                defender(); // Llama al método defender
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }



    /**
     * Método para cargar un ataque basado en la fuerza del Guerrero.
     * Consume concentración antes de realizar el ataque.
     * @param enemigo El personaje enemigo al que se va a atacar.
     */
    public void cargarAtaque(Personaje enemigo) {
        int costoConcentracion = 10; // Costo de concentración para cargar el ataque

        if (getConcentracion() < costoConcentracion) {
            System.out.println("❌ No tienes suficiente concentración para cargar el ataque.");
        } else {
            setConcentracion(getConcentracion() - costoConcentracion);
            int daño = fuerza * COSTOFUERZA;
            enemigo.setSalud(enemigo.getSalud() - daño);
            System.out.println("⚔️ Ataque cargado con éxito. Daño infligido: " + daño + ". Concentración restante: " + getConcentracion());
        }
    }

    /**
     * Método para defenderse, calculando la defensa total.
     * @return el valor de defensa calculado.
     */
    @Override
    public void defender() {
        int defensaTotal = armadura + escudo + DEFENSA_EXTRA;
        super.setSalud(super.getSalud() + defensaTotal); // Aumenta la salud del Guerrero
    }

    @Override
    public String toString() {
        return super.toString() + " Guerrero [fuerza=" + fuerza + ", armadura=" + armadura + ", escudo=" + escudo + "]";
    }

    @Override
    public void atacar(Personaje enemigo) {
        super.atacar(enemigo); // Llama al método de la clase base (Fisico)
        System.out.println("El gerrero ataca con fuerza");
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

    public int getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }
}

