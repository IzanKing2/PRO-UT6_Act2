package model;

// Clase Personaje que representa a un personaje en el juego
// Esta es una clase abstracta que sirve como base para otros tipos de personajes
// 🧑‍🤝‍🧑
public abstract class Personaje {
    // Atributos
    private String nombre;
    private int nivel;
    private int salud;

    // Constructor
    public Personaje(String nombre, int nivel, int salud) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
    }

    // Métodos
    abstract public void atacar(Personaje enemigo);

    abstract public void subirNivel();

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", nivel=" + nivel + ", salud=" + salud + "]";
    }

    @Override
    // hash code y equals para comparar objetos de tipo Personaje
    // Se utiliza el nombre, nivel y salud para calcular el hash code y comparar la igualdad
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + nivel;
        result = prime * result + salud;
        return result;
    }

    @Override
    // Método equals para comparar dos objetos de tipo Personaje
    // Se compara el nombre, nivel y salud de ambos objetos
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

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSalud() {
        return salud;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    
}
