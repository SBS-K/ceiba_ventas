package com.ceiba.persistencia.estado_compra.adaptador.repositorio;

import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
import com.ceiba.estado_compra.puerto.repositorio.RepositorioEstadoCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

public class RepositorioEstadoCompraPostgres implements RepositorioEstadoCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="estado_compra", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="estado_compra", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="estado_compra", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="estado_compra", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="estado_compra", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioEstadoCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(EstadoCompra estadoCompra) {
        return null;
    }

    @Override
    public void actualizar(EstadoCompra estadoCompra) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }
}
