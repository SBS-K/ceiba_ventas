package com.ceiba.detalle_compra.puerto.dao;

import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;

import java.util.List;

public interface DaoDetalleCompra {

    /**
     * Permite listar detalles de compra
     * @return los detalle compra
     */
    List<DtoDetalleCompra> listar();

}
