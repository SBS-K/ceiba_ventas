package com.ceiba.persistencia.categoria.adaptador.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

public class RepositorioCategoriaPostgres implements RepositorioCategoria {

    @SqlStatement(namespace="usuario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="usuario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="usuario", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="usuario", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @Override
    public Long crear(Categoria categoria) {
        return null;
    }

    @Override
    public void actualizar(Categoria categoria) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        return false;
    }
}
