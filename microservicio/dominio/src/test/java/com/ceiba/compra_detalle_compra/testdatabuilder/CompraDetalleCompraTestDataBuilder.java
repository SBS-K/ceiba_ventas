package com.ceiba.compra_detalle_compra.testdatabuilder;

import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;

public class CompraDetalleCompraTestDataBuilder {

    private static final Long COMPRA_ID = 1L;
    private static final Long DETALLE_COMPRA_ID = 1L;

    private Long id;
    private Long compraId;
    private Long detalleCompraId;

    public CompraDetalleCompraTestDataBuilder() {
        this.compraId = COMPRA_ID;
        this.detalleCompraId = DETALLE_COMPRA_ID;
    }

    public CompraDetalleCompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CompraDetalleCompraTestDataBuilder conCompraId(Long compraId) {
        this.compraId = compraId;
        return this;
    }

    public CompraDetalleCompraTestDataBuilder conDetalleCompraId(Long detalleCompraId) {
        this.detalleCompraId = detalleCompraId;
        return this;
    }

    public CompraDetalleCompra build() {
        return new CompraDetalleCompra(id, compraId, detalleCompraId);
    }
}
