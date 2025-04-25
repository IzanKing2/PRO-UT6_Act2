import model.Personaje;
import model.Hechicero;
import model.Juego;
import model.Mago;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Juego juego = new Juego();

        Personaje gandalf = new Mago("Gandalf");
        Personaje saruman = new Hechicero("Saruman");

        juego.agregarPersonaje(gandalf);
        juego.agregarPersonaje(saruman);
        System.out.println("\n---\n");

        juego.batalla(gandalf, saruman);
    }
}