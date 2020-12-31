package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.*;

@Component
public class ServicioEliminarCompra {

    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarCompra(RepositorioCompra repositorioCompra) { this.repositorioCompra = repositorioCompra; }

    public void ejecutar(Long id) {
        this.repositorioCompra.eliminar(id);
    }

}