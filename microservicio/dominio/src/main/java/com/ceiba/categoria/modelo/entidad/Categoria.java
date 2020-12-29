package com.ceiba.categoria.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Categoria {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean Estado;

    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
