package com.ceiba.estado_compra.puerto.dao;


import com.ceiba.estado_compra.modelo.dto.DtoEstadoCompra;

import java.util.List;

public interface DaoEstadoCompra {

    /**
     * Permite listar estados de compra
     * @return los estados de compra
     */
    List<DtoEstadoCompra> listar();

}
