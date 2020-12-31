package com.ceiba.categoria.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Categoria {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_CATEGORIA = "Se debe ingresar el nombre de la categoria";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION_DE_LA_CATEGORIA = "Se debe ingresar la descipcion de la categoria";
    private static final String NO_DEBE_SER_VACIO_EL_NOMBRE_DE_LA_CATEGORIA = "No debe ser vacio el nombre de la categoria";
    private static final String NO_DEBE_SER_VACIO_LA_DESCRIPCION_DE_LA_CATEGORIA = "No debe ser vacio la descripcion de la categoria";
    private static final Integer LONGITUD_MINIMA = 3;

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean Estado;

    public Categoria(Long id, String nombre, String descripcion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_CATEGORIA);
        validarLongitud(nombre, LONGITUD_MINIMA, NO_DEBE_SER_VACIO_EL_NOMBRE_DE_LA_CATEGORIA);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION_DE_LA_CATEGORIA);
        validarLongitud(descripcion, LONGITUD_MINIMA, NO_DEBE_SER_VACIO_LA_DESCRIPCION_DE_LA_CATEGORIA);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
