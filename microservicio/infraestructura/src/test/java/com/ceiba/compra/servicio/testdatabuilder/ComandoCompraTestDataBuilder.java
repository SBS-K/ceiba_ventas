package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ComandoCompraTestDataBuilder {

    private static final Long NUMERO_FACTURA = 1L;
    private static final Double COSTO_TOTAL = 180000.00;
    private static final String ESTADO_COMPRA = "Compra Finalizada";
    private static final LocalDateTime FECHA_COMPRA = LocalDateTime.now();

    private static final Long DETALLE_COMPRA_ID_UNO = 1L;
    private static final Long DETALLE_COMPRA_ID_DOS = 2L;

    private static final Integer DETALLE_COMPRA_CANTIDAD_UNO = 2;
    private static final Integer DETALLE_COMPRA_CANTIDAD_DOS = 1;
    private static final Double DETALLE_COMPRA_SUBTOTAL_UNO = 30000D;
    private static final Double DETALLE_COMPRA_SUBTOTAL_DOS = 20000D;

    private static final Long ARTICULO_ID_UNO = 1L;
    private static final String ARTICULO_NOMBRE_UNO = "Vaso personalizada";
    private static final String ARTICULO_DESCRIPCION_UNO = "Vaso personalizada";
    private static final Double ARTICULO_PRECIO_UNO = 15000D;
    private static final Long ARTICULO_ID_DOS = 1L;
    private static final String ARTICULO_NOMBRE_DOS = "Camisa personalizada";
    private static final String ARTICULO_DESCRIPCION_DOS = "Camisa personalizada";
    private static final Double ARTICULO_PRECIO_DOS = 20000D;


    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private String estadoCompra;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;

    public ComandoCompraTestDataBuilder() {
        this.numeroFactura = NUMERO_FACTURA;
        this.costoTotal = COSTO_TOTAL;
        this.estadoCompra = ESTADO_COMPRA;
        this.fechaCompra = FECHA_COMPRA;
        this.listaDetalles = new LinkedList<>();
    }

    public ComandoCompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCompraTestDataBuilder conCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
        return this;
    }

    public ComandoCompraTestDataBuilder conNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
        return this;
    }

    public ComandoCompraTestDataBuilder conEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
        return this;
    }

    public ComandoCompraTestDataBuilder conFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public ComandoCompraTestDataBuilder conListaDetalles(List<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
        return this;
    }

    public ComandoCompraTestDataBuilder conListaDetallesAutoGenerada() {
        List<DetalleCompra> listaDetalleCompra = new LinkedList<>();
        Articulo articuloUno = new Articulo(ARTICULO_ID_UNO, ARTICULO_NOMBRE_UNO, ARTICULO_DESCRIPCION_UNO, ARTICULO_PRECIO_UNO);
        Articulo articuloDos = new Articulo(ARTICULO_ID_DOS, ARTICULO_NOMBRE_DOS, ARTICULO_DESCRIPCION_DOS, ARTICULO_PRECIO_DOS);
        DetalleCompra detalleCompraUno = new DetalleCompra(DETALLE_COMPRA_ID_UNO, articuloUno, DETALLE_COMPRA_CANTIDAD_UNO, DETALLE_COMPRA_SUBTOTAL_UNO);
        DetalleCompra detalleCompraDos = new DetalleCompra(DETALLE_COMPRA_ID_DOS, articuloDos,DETALLE_COMPRA_CANTIDAD_DOS, DETALLE_COMPRA_SUBTOTAL_DOS);
        listaDetalleCompra.add(detalleCompraUno);
        listaDetalleCompra.add(detalleCompraDos);

         this.listaDetalles = listaDetalleCompra;
         return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, numeroFactura, costoTotal, estadoCompra, listaDetalles, fechaCompra, fechaEnvio);
    }
}
