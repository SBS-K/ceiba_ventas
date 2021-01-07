CREATE TABLE usuario (
 id SERIAL PRIMARY KEY,
 nombre varchar(100) NOT NULL,
 clave varchar(45) NOT NULL,
 fecha_creacion TIMESTAMP  null
);

CREATE TABLE articulo (
    id SERIAL PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion varchar(20) null,
    precio NUMERIC (15, 2) NOT NULL
);

CREATE TABLE detalle_compra (
    id SERIAL PRIMARY KEY,
    articulo_id INTEGER NOT NULL,
    cantidad INTEGER NOT NULL,
    subtotal NUMERIC (15, 2) NOT NULL
);
ALTER TABLE detalle_compra
    ADD CONSTRAINT fk_detalle_compra_articulo
    FOREIGN KEY (articulo_id)
    REFERENCES articulo (id);

CREATE TABLE compra (
    id SERIAL PRIMARY KEY,
    numero_factura INTEGER NULL,
    costo_total NUMERIC (15, 2) NOT NULL,
    estado_compra varchar(20) NOT NULL,
    fecha_compra TIMESTAMP NOT NULL,
    fecha_envio TIMESTAMP NOT NULL
);

CREATE TABLE compra_detalle_compra (
  id SERIAL PRIMARY KEY,
  compra_id INTEGER NOT NULL,
  detalle_compra_id INTEGER NOT NULL
);

ALTER TABLE compra_detalle_compra
    ADD CONSTRAINT fk_compra_detalle_compra_compra
         FOREIGN KEY (compra_id)
         REFERENCES compra (id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE compra_detalle_compra
    ADD CONSTRAINT fk_compra_detalle_compra_detalle_compra
         FOREIGN KEY (detalle_compra_id)
         REFERENCES detalle_compra (id) ON UPDATE CASCADE ON DELETE CASCADE;