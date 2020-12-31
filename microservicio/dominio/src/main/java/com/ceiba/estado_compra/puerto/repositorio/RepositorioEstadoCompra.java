package com.ceiba.estado_compra.puerto.repositorio;

import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;

public interface RepositorioEstadoCompra {

    /**
     * Permite crear un estado compra
     * @param estadoCompra
     * @return el id generado
     */
    Long crear(EstadoCompra estadoCompra);

    /**
     * Permite actualizar un estado compra
     * @param estadoCompra
     */
    void actualizar(EstadoCompra estadoCompra);

    /**
     * Permite eliminar un estado compra
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un estado compra con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

}
