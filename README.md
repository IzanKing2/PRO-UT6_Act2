# 🕹️ PRO-UT6_Act2

## 📖 Descripción del Proyecto
Este proyecto es un **juego de rol** en el que los jugadores pueden interactuar con diferentes tipos de personajes, cada uno con habilidades únicas. El objetivo es proporcionar una experiencia inmersiva mediante una arquitectura bien estructurada y un diseño modular.

## 🏗️ Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes y clases:

### 📦 `view`
- **VistaPersonaje**: 🦹 Gestiona la vista de los personajes, mostrando su apariencia, estadísticas y habilidades.
- **VistaJuego**: 🕹️ Maneja la interfaz gráfica del juego, como menús y botones.

### 📦 `model`
- **Juego**: 🎮 Clase Juego que representa el juego en sí y contiene la lógica principal del mismo
- **Personaje**: 🧑‍🤝‍🧑 Clase abstracta base para todos los personajes.
- **Magico**: 🧙‍♂️ Clase que representa personajes mágicos.
  - **Mago**: 🧙‍♂️ Un personaje especializado en magia.
  - **Hechicero**: 🧙‍♂️ Otro tipo de personaje mágico.
- **Fisico**: 🏋️‍♂️ Clase que representa personajes físicos.
  - **Guerrero**: 🛡️ Un personaje especializado en combate físico.
  - **Asesino**: 🗡️ Un personaje ágil y letal.
  - **Arquero**: 🏹 Un personaje experto en ataques a distancia.

### 📦 `model.interfaces`
- **Volador**: 🦅 Define el comportamiento de objetos que pueden volar.
- **Movilizable**: 🚶‍♂️ Define el comportamiento de objetos que pueden moverse.
- **Magico**: 🪄 Define el comportamiento de objetos que pueden lanzar hechizos.
- **Defendible**: 🛡️ Define el comportamiento de objetos que pueden defenderse.
- **Curable**: 🩹 Define el comportamiento de objetos que pueden curar.

### 📦 `controller`
- **ControladorJuego**: 👀 Gestiona la lógica del juego y la interacción con la vista.

### 📄 Otros Archivos
- **Main.java**: Punto de entrada del programa.

## 🚀 Cómo Ejecutar el Proyecto
1. Clona este repositorio:  
   ```bash
   git clone https://github.com/tu-usuario/PRO-UT6_Act2.git
   ```
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse).
3. Ejecuta la clase `Main.java`.

## 🛠️ Tecnologías Utilizadas
- **Java**: Lenguaje principal del proyecto.

## 📂 Estructura de Carpetas
```
PRO-UT6_Act2/
├── src/
│   ├── controller/
│   │   └── ControladorJuego.java
│   ├── model/
│   │   ├── interfaces/
│   │   │   ├── Volador.java
│   │   │   ├── Movilizable.java
│   │   │   ├── Magico.java
│   │   │   ├── Defendible.java
│   │   │   └── Curable.java
│   │   ├── Personaje.java
│   │   ├── Juego.java
│   │   ├── Magico.java
│   │   ├── Fisico.java
│   │   ├── Mago.java
│   │   ├── Hechicero.java
│   │   ├── Guerrero.java
│   │   ├── Asesino.java
│   │   └── Arquero.java
│   ├── view/
│   │   ├── VistaPersonaje.java
│   │   └── VistaJuego.java
│   └── Main.java
└── README.md
```
