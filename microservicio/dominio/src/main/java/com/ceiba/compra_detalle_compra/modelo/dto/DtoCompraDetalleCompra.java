package com.ceiba.compra_detalle_compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCompraDetalleCompra {

    private Long id;
    private Long compraId;
    private Long detalleCompraId;
}
