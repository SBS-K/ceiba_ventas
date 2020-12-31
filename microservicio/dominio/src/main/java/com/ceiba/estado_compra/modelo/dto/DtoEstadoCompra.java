package com.ceiba.estado_compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoEstadoCompra {
    private Long id;
    private String Nombre;
    private String Descripcion;
//    private LocalDateTime fechaCreacion;
//    private LocalDateTime fechaActualizacion;
//    private Boolean Estado;

}
