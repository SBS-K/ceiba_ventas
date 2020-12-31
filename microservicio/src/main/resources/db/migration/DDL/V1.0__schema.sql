CREATE TABLE usuario (
 id SERIAL PRIMARY KEY,
 nombre varchar(100) NOT NULL,
 clave varchar(45) NOT NULL,
 fecha_creacion TIMESTAMP WITHOUT TIME ZONE null
);

CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion varchar(20) null,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE null,
    fecha_actualizacion TIMESTAMP WITHOUT TIME ZONE null,
    estado boolean null
);

CREATE TABLE estado_compra (
    id SERIAL PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion varchar(20) null,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE null,
    fecha_actualizacion TIMESTAMP WITHOUT TIME ZONE null,
    estado boolean null
);

CREATE TABLE articulo (
    id SERIAL PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion varchar(20) null,
    precio NUMERIC (5, 2) NOT NULL,
    categoria_id int NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE null,
    fecha_actualizacion TIMESTAMP WITHOUT TIME ZONE null,
    estado boolean null
);
ALTER TABLE articulo
    ADD CONSTRAINT fk_articulo_categoria
    FOREIGN KEY (categoria_id)
    REFERENCES categoria (id);

CREATE TABLE detalle_compra (
    id SERIAL PRIMARY KEY,
    articulo_id int NOT NULL,
    cantidad int NOT NULL,
    subtotal NUMERIC (5, 2) NOT NULL,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE null,
    fecha_actualizacion TIMESTAMP WITHOUT TIME ZONE null,
    estado boolean null
);
ALTER TABLE detalle_compra
    ADD CONSTRAINT fk_detalle_compra_articulo
    FOREIGN KEY (articulo_id)
    REFERENCES articulo (id);

CREATE TABLE compra (
    id SERIAL PRIMARY KEY,
    numero_factura SERIAL NOT NULL,
    costo_total NUMERIC (5, 2) NOT NULL,
    estado_compra_id int NOT NULL,
    fecha_compra TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    fecha_envio TIMESTAMP WITHOUT TIME ZONE null,
    fecha_creacion TIMESTAMP WITHOUT TIME ZONE null,
    fecha_actualizacion TIMESTAMP WITHOUT TIME ZONE null,
    estado boolean null
);
ALTER TABLE compra
    ADD CONSTRAINT fk_compra_estado_compra
    FOREIGN KEY (estado_compra_id)
    REFERENCES estado_compra (id);

CREATE TABLE compra_detalle_compra (
  id SERIAL PRIMARY KEY,
  compra_id INTEGER NOT NULL,
  detalle_compra_id INTEGER NOT NULL
);

ALTER TABLE compra_detalle_compra
    ADD CONSTRAINT fk_compra_detalle_compra_compra
         FOREIGN KEY (compra_id)
         REFERENCES compra (id) ON UPDATE CASCADE ON DELETE CASCADE,
    ADD CONSTRAINT fk_compra_detalle_compra_detalle_compra
         FOREIGN KEY (detalle_compra_id)
         REFERENCES detalle_compra (id) ON UPDATE CASCADE ON DELETE CASCADE;