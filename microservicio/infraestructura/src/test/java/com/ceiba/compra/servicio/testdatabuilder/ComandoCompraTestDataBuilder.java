package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ComandoCompraTestDataBuilder {

    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;
    private EstadoCompra estadoCompra;

    public ComandoCompraTestDataBuilder() {
        this.numeroFactura = 4567L;
        this.costoTotal = 200000.00;
        this.listaDetalles = new LinkedList<>();
        this.fechaCompra = LocalDateTime.now();
        this.fechaEnvio = LocalDateTime.now();
        this.estadoCompra = new EstadoCompra(2L, "TestEstadoCompra", "DescripcionEstadoCompra");
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, numeroFactura, costoTotal, listaDetalles, fechaCompra, fechaEnvio, estadoCompra);
    }
}
