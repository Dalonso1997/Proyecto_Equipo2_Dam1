-- CREACIÓN DE LA BASE DE DATOS
CREATE DATABASE IF NOT EXISTS minireto
CHARACTER SET utf8
COLLATE utf8_general_ci;
USE minireto;

-- TABLA JUEGO
CREATE TABLE IF NOT EXISTS juego (
    idJuego INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    PRIMARY KEY (idJuego),
    UNIQUE (nombre)
);

-- TABLA JUGADOR
CREATE TABLE IF NOT EXISTS jugador (
    idJugador INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apodo VARCHAR(50),
    PRIMARY KEY (idJugador)
);

-- TABLA PARTIDA
CREATE TABLE IF NOT EXISTS partida (
    idPartida INT UNSIGNED AUTO_INCREMENT,
    fecha DATE NOT NULL,
    duracion INT UNSIGNED,
    idJuego INT UNSIGNED NOT NULL,
    PRIMARY KEY (idPartida),
    FOREIGN KEY (idJuego)
        REFERENCES juego(idJuego)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CHECK (duracion >= 0)
);

-- TABLA PARTICIPA (N:M)
CREATE TABLE IF NOT EXISTS  participa (
    idJugador INT UNSIGNED,
    idPartida INT UNSIGNED,
    PRIMARY KEY (idJugador, idPartida),
    FOREIGN KEY (idJugador)
        REFERENCES jugador(idJugador)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (idPartida)
        REFERENCES partida(idPartida)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- TABLA RESULTADO
CREATE TABLE IF NOT EXISTS resultado (
    idResultado INT UNSIGNED AUTO_INCREMENT,
    puntuacion INT NOT NULL,
    posicion INT NOT NULL,
    idJugador INT UNSIGNED NOT NULL,
    idPartida INT UNSIGNED NOT NULL,
    PRIMARY KEY (idResultado),
    FOREIGN KEY (idJugador)
        REFERENCES jugador(idJugador)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (idPartida)
        REFERENCES partida(idPartida)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CHECK (puntuacion >= 0),
    CHECK (posicion > 0)
);

-- TRIGGER: POSICIÓN ÚNICA POR PARTIDA
/* Este trigger impide que dos jugadores obtengan la misma posición en una misma partida,
   garantizando una regla del mundo real que no puede asegurarse solo con claves primarias o foráneas */

DELIMITER $$

CREATE TRIGGER trg_posicion_unica
BEFORE INSERT ON resultado
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1
        FROM resultado
        WHERE idPartida = NEW.idPartida
          AND posicion = NEW.posicion
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No puede haber dos jugadores con la misma posición en una partida';
    END IF;
END$$

DELIMITER ;