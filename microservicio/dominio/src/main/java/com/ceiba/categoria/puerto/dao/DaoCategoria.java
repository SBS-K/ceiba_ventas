package com.ceiba.categoria.puerto.dao;


import com.ceiba.categoria.modelo.dto.DtoCategoria;

import java.util.List;

public interface DaoCategoria {

    /**
     * Permite listar categoria
     * @return las categorias
     */
    List<DtoCategoria> listar();

}
