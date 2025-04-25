package model;

// Clase Personaje que representa a un personaje en el juego
// Esta es una clase abstracta que sirve como base para otros tipos de personajes
// 🧑‍🤝‍🧑
public abstract class Personaje {
    // Constantes ______________________________________
    protected static final int NIVEL_MINIMO = 1;
    protected static final int NIVEL_MAXIMO = 60;

    // Atributos _____________
    private String nombre;
    private int nivel;
    private int salud;
    private int daño;

    // Constructor ________________________________________________________
    public Personaje(String nombre, int nivel, int salud, int daño) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.daño = daño;
    }

    // Métodos Abstractos ______________________________________
    /**
     *  Método abstracto para atacar a otro personaje
     *  @param enemigo el personaje enemigo al que se va a atacar
     */
    abstract public void atacar(Personaje enemigo);

    /**
     * Método abstracto para mostrar el menú de combate
     */
    abstract public void menuCombate();

    /**
     * Método abstracto para realizar una acción
     * Este método se puede personalizar para realizar diferentes acciones
     */
    abstract public void realizarAccion(int opcion, Personaje enemigo);

    /**
     *  Método abstracto para subir de nivel
     */
    abstract public void subirNivel();

    // Métodos ____________________________________________________________
    /**
     *  Metodo para mostrar la información del personaje
     *  @return una cadena con la información del personaje
     */
    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", nivel=" + nivel + ", salud=" + salud + " daño=" + daño + "]";
    }

    /**
     *  Metodo hashCode para generar un código hash del objeto
     *  @return un entero que representa el código hash del objeto
     *  Se utiliza el nombre, nivel y salud del personaje para generar el código hash
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + nivel;
        result = prime * result + salud;
        return result;
    }

    /**
     *  Metodo equals para comparar dos objetos Personaje
     *  @param obj el objeto a comparar
     *  @return true si los objetos son iguales, false en caso contrario
     *  Se compara el nombre, nivel y salud del personaje para determinar si son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Personaje other = (Personaje) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (nivel != other.nivel)
            return false;
        if (salud != other.salud)
            return false;
        return true;
    }

    // Getters y Setters ____________________________
    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Establece el nivel del personaje.
     * @param nivel El nivel del personaje, debe estar entre 1 y 60.
     * @throws IllegalArgumentException Si el nivel es menor que 1 o mayor que 60.
     */
    public void setNivel(int nivel) {
        if (nivel < NIVEL_MINIMO) {
            throw new IllegalArgumentException("El nivel no puede ser menor que 1.");
        }
        if (nivel > NIVEL_MAXIMO) {
            throw new IllegalArgumentException("El nivel no puede ser mayor que 60.");
        }
        this.nivel = nivel;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setDaño(int daño) {
        if (daño < 0) {
            throw new IllegalArgumentException("El daño no puede ser menor que 0.");
        }
        this.daño = daño;
    }
    
}
