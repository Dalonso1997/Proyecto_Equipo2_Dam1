# 🎮 Mini Reto — Minijuegos en Java

![Java](https://img.shields.io/badge/Java-24-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![Consola](https://img.shields.io/badge/interfaz-consola-333333)
![Equipo](https://img.shields.io/badge/trabajo-en%20equipo-blueviolet)

Aplicación de consola con un menú de **tres minijuegos** programados en Java orientado a objetos. Es el mini reto intermodular de 1º de DAM (2025/26), hecho por el **Equipo 2**.

📊 [Presentación del proyecto](https://docs.google.com/presentation/d/1ncu4lhpbSHAmoEV3hdwfd0_faUCgcn-1q3QFCPSTp_g/edit?usp=sharing)

## 🕹️ Juegos

| Juego | Descripción |
|---|---|
| 🚌 **Carrera de autobuses** | Eliges cuántos autobuses compiten, apuestas por uno y la carrera avanza por turnos hasta que hay un ganador |
| ⚫ **Damas** | Damas para dos jugadores sobre un tablero en consola |
| 🔴 **Cuatro en raya** | Cuatro en raya clásico para dos jugadores |

## 🧱 Estructura

```
mavenproject1/src/main/java/miniretoequipo2/
├── Main.java               # Menú principal
├── carreraautobuses/       # Autobus, Carrera, Apuesta
├── damas/                  # Damas, Tablero, Fichas, Jugador
└── cuatroenraya/           # CuatroEnRaya, Tablero
```

Conceptos que se trabajan: clases y objetos, arrays y matrices (tableros), estructuras de control, separación de cada juego en su propio paquete y reparto del trabajo en equipo con Git.

## 🚀 Cómo ejecutarlo

```bash
git clone https://github.com/Dalonso1997/Proyecto_Equipo2_Dam1.git
cd Proyecto_Equipo2_Dam1/mavenproject1
mvn clean package
mvn exec:java
```

También se puede abrir la carpeta `mavenproject1` en NetBeans y ejecutar `Main`.

## 👥 Equipo

- Guille Muñoz
- Saúl Gutiérrez
- David Alonso
- Héctor Guerra

## ✅ Valoración y mejoras

Los tres juegos funcionan y cumplen los requisitos del reto, y eso que el equipo tuvo un integrante menos. Como mejoras quedan pendientes añadir más juegos, una interfaz gráfica, guardar las puntuaciones en base de datos y seguir refactorizando el código.
