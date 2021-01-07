package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionNoExisteRegistroBD;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioUsuario.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioUsuario.existeById(id);
        if(!existe) {
            throw new ExcepcionNoExisteRegistroBD(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
