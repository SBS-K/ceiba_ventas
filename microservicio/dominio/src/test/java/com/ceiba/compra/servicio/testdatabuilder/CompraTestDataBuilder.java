package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;

import java.time.LocalDateTime;
import java.util.List;

public class CompraTestDataBuilder {

    private static final Long NUMERO_FACTURA = 1L;
    private static final Double COSTO_TOTAL = 180000.00;
    private static final String ESTADO_COMPRA = "Compra Finalizada";
    private static final LocalDateTime FECHA_COMPRA = LocalDateTime.now();

    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private String estadoCompra;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;

    public CompraTestDataBuilder() {
        this.numeroFactura = NUMERO_FACTURA;
        this.costoTotal = COSTO_TOTAL;
        this.estadoCompra = ESTADO_COMPRA;
        this.fechaCompra = FECHA_COMPRA;
    }

    public CompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CompraTestDataBuilder conCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
        return this;
    }

    public CompraTestDataBuilder conNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
        return this;
    }

    public CompraTestDataBuilder conEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
        return this;
    }

    public CompraTestDataBuilder conFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public CompraTestDataBuilder conListDetalles(List<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
        return this;
    }

    public Compra build() {
        return new Compra(id, numeroFactura, costoTotal, estadoCompra, listaDetalles, fechaCompra);
    }

}
