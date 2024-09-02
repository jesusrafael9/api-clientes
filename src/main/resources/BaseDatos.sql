-- Crear la tabla Persona
CREATE TABLE persona (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         direccion VARCHAR(255),
                         edad INT NOT NULL,
                         genero VARCHAR(255),
                         identificacion VARCHAR(255),
                         nombre VARCHAR(255),
                         telefono VARCHAR(255)
);

-- Crear la tabla Cliente
CREATE TABLE cliente (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         contrasena VARCHAR(255),
                         email VARCHAR(255),
                         estado VARCHAR(255),
                         persona_id BIGINT,
                         UNIQUE (persona_id),
                         FOREIGN KEY (persona_id) REFERENCES persona(id)
);