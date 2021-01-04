package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionNoExisteRegistroBD;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.*;

public class ServicioEliminarCompra {

    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "La compra no existe en el sistema";

    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarCompra(RepositorioCompra repositorioCompra) { this.repositorioCompra = repositorioCompra; }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioCompra.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioCompra.existe(id);
        if(!existe) {
            throw new ExcepcionNoExisteRegistroBD(LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
