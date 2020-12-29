package com.ceiba.detalle_compra.puerto.repositorio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;

public interface RepositorioDetalleCompra {

    /**
     * Permite crear un detalle compra
     * @param detalleCompra
     * @return el id generado
     */
    Long crear(DetalleCompra detalleCompra);

    /**
     * Permite actualizar un detalle compra
     * @param detalleCompra
     */
    void actualizar(DetalleCompra detalleCompra);

    /**
     * Permite eliminar un detalle compra
     * @param id
     */
    void eliminar(Long id);

}
