package com.ceiba.compra_detalle_compra.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class CompraDetalleCompra {

    private static final String DEBE_ESTAR_EL_ID_COMPRA = "Debe estar el id compra";
    private static final String DEBE_ESTAR_EL_ID_DETALLE_COMPRA = "Debe estar el id detalle compra";

    private Long id;
    private Long compraId;
    private Long detalleCompraId;

    public CompraDetalleCompra(Long id, Long compraId, Long detalleCompraId) {
        validarObligatorio(compraId, DEBE_ESTAR_EL_ID_COMPRA);
        validarObligatorio(detalleCompraId, DEBE_ESTAR_EL_ID_DETALLE_COMPRA);

        this.id = id;
        this.compraId = compraId;
        this.detalleCompraId = detalleCompraId;
    }
}
