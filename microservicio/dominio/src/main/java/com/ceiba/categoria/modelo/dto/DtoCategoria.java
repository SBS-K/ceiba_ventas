package com.ceiba.categoria.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCategoria {
    private Long id;
    private String nombre;
    private String descripcion;
//    private LocalDateTime fechaCreacion;
//    private LocalDateTime fechaActualizacion;
//    private Boolean Estado;

}
