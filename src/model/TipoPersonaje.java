package model;

// Enum TipoPersonaje que representa los diferentes tipos de personajes en el juego
// y contiene un método para crear personajes de cada tipo
// 🧑‍🤝‍🧑
public enum TipoPersonaje {
    //GUERRERO,
    HECHICERO {
        @Override
        public Personaje crearPersonaje(TipoPersonaje tipo, String nombre) {
            return new Hechicero(nombre);
        }
    },
    MAGO {
        @Override
        public Personaje crearPersonaje(TipoPersonaje tipo, String nombre) {
            return new Mago(nombre);
        }
    };
    //ASESINO,
    //ARQUERO,
    //GUERRERO;
    public abstract Personaje crearPersonaje(TipoPersonaje tipo, String nombre);
}