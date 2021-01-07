package com.ceiba.compra_detalle_compra.puerto.repository;

import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;

public interface RepositorioCompraDetalleCompra {

    /**
     * Permite crear una compra
     * @param compraDetalleCompra
     * @return el id generado
     */
    Long crear(CompraDetalleCompra compraDetalleCompra);

}
