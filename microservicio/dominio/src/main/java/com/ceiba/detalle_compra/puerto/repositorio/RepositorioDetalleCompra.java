package com.ceiba.detalle_compra.puerto.repositorio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;

public interface RepositorioDetalleCompra {

    /**
     * Permite crear un detalle compra
     * @param detalleCompra
     * @return el id generado
     */
    Long crear(DetalleCompra detalleCompra);

}
