package com.ceiba.articulo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoArticulo {
    private  Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

}
