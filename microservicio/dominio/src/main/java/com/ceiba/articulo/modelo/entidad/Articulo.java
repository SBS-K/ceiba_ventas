package com.ceiba.articulo.modelo.entidad;

import lombok.Getter;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Articulo {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ARTICULO = "Se debe ingresar el nombre del articulo";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_ARTICULO = "Se debe ingresar el precio del articulo";
    private static final String NO_DEBE_SER_VACIO_EL_NOMBRE_DEL_ARTICULO = "No debe ser vacio el nombre del articulo";
    private static final String EL_PRECIO_DEL_ARTICULO_DEBE_SER_MAYOR_A_CERO = "El precio del articulo debe ser mayor a cero";

    private static final Integer LONGITUD_NOMBRE = 3;

    private  Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public Articulo(Long id, String nombre, String descripcion, Double precio) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ARTICULO);
        validarLongitud(nombre, LONGITUD_NOMBRE, NO_DEBE_SER_VACIO_EL_NOMBRE_DEL_ARTICULO);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DEL_ARTICULO);
        validarPositivo(precio, EL_PRECIO_DEL_ARTICULO_DEBE_SER_MAYOR_A_CERO);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
