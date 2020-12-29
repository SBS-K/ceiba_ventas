package com.ceiba.articulo.puerto.repositorio;


import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.categoria.modelo.entidad.Categoria;

public interface RepositorioArticulo {

    /**
     * Permite crear un usuario
     * @param articulo
     * @return el id generado
     */
    Long crear(Articulo articulo);

    /**
     * Permite actualizar un articulo
     * @param articulo
     */
    void actualizar(Articulo articulo);

    /**
     * Permite eliminar un articulo
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un articulo con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un articulo con un nombre y categoria
     * @param nombre
     * @return si existe o no
     */
    boolean existeConCategoria(String nombre, Categoria categoria);

    /**
     * Permite validar si existe un articulo con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);

}
