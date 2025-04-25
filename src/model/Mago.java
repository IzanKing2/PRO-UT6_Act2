package model;

import model.interfaces.*;

// Clase Mago que hereda de la clase Magica y representa un personaje mago en el juego
// 🧙‍♂️
public class Mago extends Magica implements Magico, Curable {
    // Constantes
    private static final int COSTO_HECHIZO = 10;
    private static final int REGENERACION_MANA = 20;
    private static final int CURACION = 30;

    // Atributos
    private int maxMana = 50;
    private int maxSalud = 50;
    private int mana;
    private int sabiduria;

    // Constructor
    public Mago(String nombre) {
        super(nombre, 1, 50); // Salud inicial
        this.mana = maxMana;
        this.sabiduria = 30;
    }

    // Métodos
    /**
     * Lanza un hechizo, reduciendo el mana del mago. Si no tiene suficiente mana,
     * intenta regenerarlo automáticamente.
     */
    @Override
    public void lanzarHechizo() {
        System.out.println("✨ Lanzando hechizo...");
        if (this.mana < COSTO_HECHIZO) {
            System.out.println("❌ No tienes suficiente mana para lanzar un hechizo.");
            regenerarMana();
        } else {
            this.mana -= COSTO_HECHIZO;
            System.out.println("✅ Hechizo lanzado con éxito. Mana restante: " + this.mana);
        }
    }

    @Override
    public void curar() {
        System.out.println("🩹 Curando...");
        int nuevaSalud = limitarValor(super.getSalud() + CURACION, maxSalud);
        super.setSalud(nuevaSalud);
        System.out.println("✅ Salud actual: " + super.getSalud());
    }

    public void regenerarMana() {
        System.out.println("🔄 Regenerando mana...");
        this.mana = limitarValor(this.mana + REGENERACION_MANA, maxMana);
        System.out.println("✅ Mana actual: " + this.mana);
    }

    @Override
    public void subirNivel() {
        this.maxSalud += 5; // Aumenta la salud máxima al subir de nivel
        this.setSalud(maxSalud); // Restaura la salud al máximo
        this.maxMana += 5; // Aumenta el mana máximo al subir de nivel
        this.mana = maxMana; // Restaura el mana al máximo
        this.sabiduria += 5; // Aumenta la sabiduría
        super.subirNivel();
    }

    @Override
    public String toString() {
        return "Mago [Nombre: " + super.getNombre() + ", Nivel: " + super.getNivel() +
            ", Salud: " + super.getSalud() + "/" + maxSalud + ", Mana: " + this.mana +
            "/" + maxMana + ", Sabiduria: " + this.sabiduria + "]";
    }

    // Métodos auxiliares
    private int limitarValor(int valor, int maximo) {
        return Math.min(valor, maximo);
    }

    // Getters y Setters
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = limitarValor(mana, maxMana);
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(int sabiduria) {
        if (sabiduria < 0) {
            throw new IllegalArgumentException("La sabiduría no puede ser negativa.");
        }
        this.sabiduria = sabiduria;
    }
}
