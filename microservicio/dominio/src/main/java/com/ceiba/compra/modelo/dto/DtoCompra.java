package com.ceiba.compra.modelo.dto;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
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
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaEnvio;
    private EstadoCompra estadoCompra;
//    private LocalDateTime fechaCreacion;
//    private LocalDateTime fechaActualizacion;
//    private Boolean Estado;

}
