package com.ceiba.categoria.puerto.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;

public interface RepositorioCategoria {

    /**
     * Permite crear una categoria
     * @param categoria
     * @return el id generado
     */
    Long crear(Categoria categoria);

    /**
     * Permite actualizar una categoria
     * @param categoria
     */
    void actualizar(Categoria categoria);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una categoria con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe una categoria con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);

}
