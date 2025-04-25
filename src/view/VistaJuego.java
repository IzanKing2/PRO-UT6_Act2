package view;

import java.util.Scanner;

// 🕹️ Se encarga de la vista de la interfaz del juego, como el menú principal, los botones, etc.
public class VistaJuego {
    Scanner sc = new Scanner(System.in);

    public void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    public void menu() {
        imprimir("___MENU PRINCIPAL___");
        imprimir("\t├── Ver personajes");
        imprimir("\t├── Ver personajes");
        imprimir("\t├── Ver personajes");
        imprimir("\t├── Ver personajes");
    }
}
