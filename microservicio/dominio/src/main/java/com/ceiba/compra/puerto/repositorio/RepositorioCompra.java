package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {

    /**
     * Permite crear una compra
     * @param compra
     * @return el id generado
     */
    Long crear(Compra compra);

    /**
     * Permite actualizar una compra
     * @param compra
     */
    void actualizar(Compra compra);

    /**
     * Permite eliminar una compra
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una compra con un numeroFactura
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe una compra con un numeroFactura
     * @param numeroFactura
     * @return si existe o no
     */
    boolean existeByNumeroFactura(Long numeroFactura);

}
