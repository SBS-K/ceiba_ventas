package com.ceiba.detalle_compra.modelo.dto;

import com.ceiba.articulo.modelo.entidad.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDetalleCompra {
    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private Double subtotal;

}
