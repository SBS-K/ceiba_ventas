package com.ceiba.categoria.puerto.dao;


import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoCategoria {

    /**
     * Permite listar categoria
     * @return las categorias
     */
    List<DtoUsuario> listar();

}
