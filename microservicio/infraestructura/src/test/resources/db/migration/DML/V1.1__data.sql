
CREATE TABLE usuario (
 id IDENTITY PRIMARY KEY,
 nombre varchar(100) NOT NULL,
 clave varchar(45) NOT NULL,
 fecha_creacion TIMESTAMP null
);

CREATE TABLE articulo (
    id IDENTITY PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion varchar(20) null,
    precio NUMERIC (15, 2) NOT NULL
);

CREATE TABLE detalle_compra (
    id IDENTITY PRIMARY KEY,
    articulo_id int NOT NULL,
    cantidad int NOT NULL,
    subtotal NUMERIC (15, 2) NOT NULL
);
ALTER TABLE detalle_compra
    ADD FOREIGN KEY (articulo_id)
    REFERENCES articulo (id);

CREATE TABLE compra (
    id IDENTITY PRIMARY KEY,
    numero_factura bigint auto_increment NOT NULL,
    costo_total NUMERIC (15, 2) NOT NULL,
    estado_compra varchar(20) NOT NULL,
    fecha_compra TIMESTAMP NOT NULL,
    fecha_envio TIMESTAMP null
);

CREATE TABLE compra_detalle_compra (
  id IDENTITY PRIMARY KEY,
  compra_id INTEGER NOT NULL,
  detalle_compra_id INTEGER NOT NULL
);

ALTER TABLE compra_detalle_compra
    ADD FOREIGN KEY (compra_id)
         REFERENCES compra (id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE compra_detalle_compra
    ADD FOREIGN KEY (detalle_compra_id)
         REFERENCES detalle_compra (id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO articulo (id, nombre, descripcion, precio) VALUES (1, 'Vaso modificado', 'Vaso modificado', 30000);
INSERT INTO articulo (id, nombre, descripcion, precio) VALUES (2, 'Camisa modificado', 'Camisa modificado', 50000);
INSERT INTO articulo (id, nombre, descripcion, precio) VALUES (3, 'Peluche', 'Peluche', 70000);

INSERT INTO detalle_compra (id, articulo_id, cantidad, subtotal) VALUES (1, 1, 3, 90000);
INSERT INTO detalle_compra (id, articulo_id, cantidad, subtotal) VALUES (2, 2, 2, 100000);
INSERT INTO detalle_compra (id, articulo_id, cantidad, subtotal) VALUES (3, 3, 5, 350000);
INSERT INTO detalle_compra (id, articulo_id, cantidad, subtotal) VALUES (4, 2, 5, 250000);
INSERT INTO detalle_compra (id, articulo_id, cantidad, subtotal) VALUES (5, 1, 1, 30000);

INSERT INTO compra (id, numero_factura, costo_total, estado_compra, fecha_compra, fecha_envio)
VALUES (1, 12345, 540000, 'Compra Finalizada', '2021-01-1 15:12:15.242', '2021-01-2 08:30:00.000');

INSERT INTO compra (id, numero_factura, costo_total, estado_compra, fecha_compra, fecha_envio)
VALUES (2, 12346, 250000, 'Compra Finalizada', '2021-01-5 11:12:15.242', '2021-01-2 13:30:00.000');

INSERT INTO compra (id, numero_factura, costo_total, estado_compra, fecha_compra, fecha_envio)
VALUES (3, 12347, 30000, 'Compra Finalizada', '2021-01-11 09:12:15.242', '2021-01-2 10:30:00.000');

INSERT INTO compra_detalle_compra (id, compra_id, detalle_compra_id) VALUES (1, 1, 1);
INSERT INTO compra_detalle_compra (id, compra_id, detalle_compra_id) VALUES (2, 1, 2);
INSERT INTO compra_detalle_compra (id, compra_id, detalle_compra_id) VALUES (3, 1, 3);

INSERT INTO compra_detalle_compra (id, compra_id, detalle_compra_id) VALUES (4, 2, 4);
INSERT INTO compra_detalle_compra (id, compra_id, detalle_compra_id) VALUES (5, 3, 5);

INSERT INTO usuario(nombre,clave,fecha_creacion) VALUES ('test','1234',now())
