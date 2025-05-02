package view;

import java.util.Scanner;

// 🕹️ Se encarga de la vista de la interfaz del juego, como el menú principal, los botones, etc.
public class VistaJuego {
    Scanner sc = new Scanner(System.in);

    public void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    public void menu() {
        imprimir("\n┌──── MENU PRINCIPAL ───────────────────────┐");
        imprimir("├── 1. Instrucciones del juego              │");
        imprimir("├── 2. Iniciar juego                        │");
        imprimir("├── 3. Salir del juego                      │");
        imprimir("├── PERSONAJES ──────────────────────────── ┘");
        imprimir("├── 4. Crear personaje                      │");
        imprimir("├── 5. Ver estadísticas de los personajes   │");
        imprimir("├── JUEGO ───────────────────────────────── ┘");
        imprimir("├── 6. Combatir                             │");
        imprimir("└───────────────────────────────────────────┘");
    }
}
