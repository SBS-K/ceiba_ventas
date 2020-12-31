package com.ceiba.articulo.modelo.dto;


import com.ceiba.categoria.modelo.entidad.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoArticulo {
    private  Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Categoria categoria;
//    private LocalDateTime fechaCreacion;
//    private LocalDateTime fechaActualizacion;
//    private Boolean Estado;

}
