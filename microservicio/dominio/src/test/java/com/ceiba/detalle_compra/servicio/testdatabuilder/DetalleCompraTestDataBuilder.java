package com.ceiba.detalle_compra.servicio.testdatabuilder;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;

public class DetalleCompraTestDataBuilder {

    private static final Long ARTICULO_ID = 1L;
    private static final String ARTICULO_NOMBRE = "Vaso personalizada";
    private static final String ARTICULO_DESCRIPCION = "Vaso personalizada";
    private static final Double ARTICULO_PRECIO = 30000D;

    private static final Integer CANTIDAD = 2;
    private static final Double SUBTOTAL = 60000D;

    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private Double subtotal;

    public DetalleCompraTestDataBuilder() {
        this.articulo = new Articulo(ARTICULO_ID, ARTICULO_NOMBRE, ARTICULO_DESCRIPCION, ARTICULO_PRECIO);
        this.cantidad = CANTIDAD;
        this.subtotal = SUBTOTAL;
    }

    public DetalleCompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DetalleCompraTestDataBuilder conArticulo(Articulo articulo) {
        this.articulo = articulo;
        return this;
    }

    public DetalleCompraTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public DetalleCompraTestDataBuilder conSubtotal(Double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public DetalleCompra build() {
        return new DetalleCompra(id, articulo, cantidad, subtotal);
    }

}
