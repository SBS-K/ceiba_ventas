package com.ceiba.articulo.puerto.dao;

import com.ceiba.articulo.modelo.dto.DtoArticulo;

import java.util.List;

public interface DaoArticulo {

    /**
     * Permite listar articulos
     * @return los articulos
     */
    List<DtoArticulo> listar();

}
