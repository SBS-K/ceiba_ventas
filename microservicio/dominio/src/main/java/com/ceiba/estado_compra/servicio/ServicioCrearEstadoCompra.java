package com.ceiba.estado_compra.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
import com.ceiba.estado_compra.puerto.repositorio.RepositorioEstadoCompra;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioCrearEstadoCompra {

    private static final String EL_ESTADO_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "El estado compra ya existe en el sistema";

    private final RepositorioEstadoCompra repositorioEstadoCompra;

    public ServicioCrearEstadoCompra(RepositorioEstadoCompra repositorioEstadoCompra) {
        this.repositorioEstadoCompra = repositorioEstadoCompra;
    }

    public Long ejecutar(EstadoCompra estadoCompra) {
        validarExistenciaPrevia(estadoCompra);
        return this.repositorioEstadoCompra.crear(estadoCompra);
    }

    private void validarExistenciaPrevia(EstadoCompra estadoCompra) {
        boolean existe = this.repositorioEstadoCompra.existe(estadoCompra.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ESTADO_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
