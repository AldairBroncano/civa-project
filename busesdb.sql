-- Crear base de datos
DROP DATABASE IF EXISTS busesdb;
CREATE DATABASE busesdb;




CREATE TABLE marcas (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE buses (
    id BIGSERIAL PRIMARY KEY,
    numero_bus VARCHAR(255) NOT NULL,
    placa VARCHAR(255) NOT NULL UNIQUE,
    fecha_creacion TIMESTAMP NOT NULL,
    caracteristicas VARCHAR(1000),
    activo BOOLEAN NOT NULL,
    marca_id BIGINT,
    CONSTRAINT fk_marca FOREIGN KEY (marca_id) REFERENCES marcas(id)
);


INSERT INTO marcas (id, name) VALUES 
(1, 'Volvo'),
(2, 'Scania'),
(3, 'Fiat');

INSERT INTO buses (id, numero_bus, placa, fecha_creacion, caracteristicas, activo, marca_id)
VALUES
(1, 'B001', 'BBB-111', CURRENT_TIMESTAMP, 'Interprovincial con baño', FALSE, 2),
(2, 'B002', 'BBB-222', CURRENT_TIMESTAMP, 'Interprovincial con baño', FALSE, 1),
(3, 'B003', 'BBB-333', CURRENT_TIMESTAMP, 'Interprovincial con baño', TRUE, 3),
(4, 'B004', 'AAA-444', CURRENT_TIMESTAMP, 'Bus de lujo, A/C', TRUE, 2),
(5, 'B005', 'BBB-555', CURRENT_TIMESTAMP, 'Interprovincial con baño', TRUE, 3),
(6, 'B006', 'AAA-666', CURRENT_TIMESTAMP, 'Bus de lujo, A/C', TRUE, 2),
(7, 'B007', 'BBB-777', CURRENT_TIMESTAMP, 'Interprovincial con baño', TRUE, 3),
(8, 'B008', 'AAA-888', CURRENT_TIMESTAMP, 'Bus de lujo, A/C', TRUE, 2),
(9, 'B009', 'BBB-999', CURRENT_TIMESTAMP, 'Interprovincial con baño', TRUE, 3),
(10, 'B010', 'BBB-100', CURRENT_TIMESTAMP, 'Interprovincial con baño', FALSE, 1);

-- Consultas para verificar
SELECT * FROM marcas;
SELECT * FROM buses;


