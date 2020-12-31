package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;

import java.time.LocalDateTime;
import java.util.List;

public class CompraTestDataBuilder {

    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaEnvio;
    private EstadoCompra estadoCompra;

    public CompraTestDataBuilder() {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.costoTotal = costoTotal;
        this.listaDetalles = listaDetalles;
        this.fechaEnvio = fechaEnvio;
        this.estadoCompra = estadoCompra;
    }
}
