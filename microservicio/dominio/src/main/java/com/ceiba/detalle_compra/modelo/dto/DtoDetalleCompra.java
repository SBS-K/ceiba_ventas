package com.ceiba.detalle_compra.modelo.dto;


import com.ceiba.articulo.modelo.entidad.Articulo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DtoDetalleCompra {
    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private Double subtotal;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean Estado;
}
