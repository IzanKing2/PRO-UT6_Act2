package model;

import model.interfaces.*;

// Clase Mago que hereda de la clase Magica y representa un personaje mago en el juego
// 🧙‍♂️
public class Mago extends Magica implements Magico, Curable {
    // Constantes ____________________________________
    private static final int COSTO_HECHIZO = 20;
    private static final int COSTO_CURACION = 20;

    // Atributos _________________
    private int maxRegeneracionMana = 10;
    private int maxCuracion = 30;
    private int maxMana = 40;
    private int maxSalud = 50;
    private int maxDaño = 8;
    private int maxSabiduria = 60;
    private int maxDañoHechizo = 25;
    
    private int dañoHechizo;
    private int curacion;
    private int mana;
    private int sabiduria;
    private int regeneracionMana;

    // Constructor __________________________________________________
    public Mago(String nombre) {
        super(nombre, 1, 50, 10); // Salud inicial
        this.mana = maxMana;
        this.sabiduria = maxSabiduria;
        this.dañoHechizo = maxDañoHechizo;
        this.curacion = maxCuracion;
        this.regeneracionMana = maxRegeneracionMana;
    }

    // Métodos ______________________________________________________________________________
    /**
     * Lanza un hechizo, reduciendo el mana del mago. Si no tiene suficiente mana,
     * intenta regenerarlo automáticamente.
     */
    @Override
    public void lanzarHechizo(Personaje enemigo) {
        System.out.println("✨ Lanzando hechizo...");
        if (this.mana < COSTO_HECHIZO) {
            System.out.println("❌ No tienes suficiente mana para LANZAR UN HECHIZO.");
        } else {
            this.mana -= COSTO_HECHIZO;
            enemigo.setSalud(enemigo.getSalud() - dañoHechizo);
            System.out.println("✅ Hechizo lanzado con éxito. Mana restante: " + this.mana);
        }
    }

    /**
     *  Ataca a un enemigo, infligiendo daño y lanzando un hechizo.
     *  @param enemigo El personaje enemigo al que se le va a atacar
     */
    @Override
    public void atacar(Personaje enemigo) {
        super.atacar(enemigo); // Llama al método atacar de la clase padre
        System.out.println("🪄 El mago lanza un hechizo para potenciar su ataque.");
    }

    /**
     *  Cura al mago, restaurando su salud. Si no tiene suficiente sabiduria, no puede
     *  curarse.
     */
    @Override
    public void curar() {
        if (this.sabiduria < COSTO_CURACION) {
            System.out.println("❌ No tienes suficiente mana para CURARTE.");
        } else {
            this.sabiduria -= COSTO_CURACION;
            System.out.println("🩹 Curando...");
            int nuevaSalud = limitarValor(super.getSalud() + curacion, maxSalud);
            super.setSalud(nuevaSalud);
            System.out.println("✅ Salud actual: " + super.getSalud());
        }
    }

    /**
     *  Regenera el mana del mago, aumentando su cantidad de mana. Si el mana
     *  excede el máximo, se limita al máximo.
     */
    public void regenerarMana() {
        System.out.println("🔄 Regenerando mana...");
        this.mana = limitarValor(this.mana + regeneracionMana, maxMana);
        System.out.println("✅ Mana actual: " + this.mana);
    }

    /**
     *  Aumenta el nivel del mago, incrementando su salud máxima, mana y sabiduría.
     *  También restaura la salud y mana al máximo.
     */
    @Override
    public void subirNivel() {
        // Salud
        this.maxSalud += 4; // Aumenta la salud máxima al subir de nivel
        this.setSalud(maxSalud); // Restaura la salud al máximo
        // Mana
        this.maxMana += 4; // Aumenta el mana máximo al subir de nivel
        this.mana = maxMana; // Restaura el mana al máximo
        // Sabiduría
        this.maxSabiduria += 2; // Aumenta la sabiduría
        this.sabiduria = maxSabiduria; // Restaura la sabiduría al máximo
        // Daño del hechizo
        this.maxDañoHechizo += 2; // Aumenta el daño del hechizo
        this.dañoHechizo = maxDañoHechizo; // Restaura el daño del hechizo al máximo
        // Daño
        super.setDaño(super.getDaño() + 2); // Aumenta el daño del mago al subir de nivel
        this.setDaño(maxDaño); // Restaura el daño al máximo
        // Curacion
        this.maxCuracion += 2; // Aumenta la curación máxima al subir de nivel
        this.curacion = maxCuracion; // Restaura la curación al máximo
        // Regeneración de mana
        this.maxRegeneracionMana += 2; // Aumenta la regeneración de mana al subir de nivel
        this.regeneracionMana = maxRegeneracionMana; // Restaura la regeneración de mana al máximo

        super.subirNivel();
    }

    /**
     *  Método toString que devuelve una representación en cadena del mago,
     *  incluyendo su nombre, nivel, salud, daño, mana y sabiduría.
     */
    @Override
    public String toString() {
        return "🧙‍♂️ Mago [nombre=" + super.getNombre() + ", nivel=" + super.getNivel() + ", salud=" + super.getSalud()
                + ", daño=" + super.getDaño() + ", mana=" + mana + ", sabiduría=" + sabiduria + "]";
    }

    // Métodos auxiliares ______________________________
    private int limitarValor(int valor, int maximo) {
        return Math.min(valor, maximo);
    }

    // Getters y Setters __________________________
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
