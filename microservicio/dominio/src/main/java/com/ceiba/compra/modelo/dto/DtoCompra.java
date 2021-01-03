package com.ceiba.compra.modelo.dto;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private String estadoCompra;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;

}
