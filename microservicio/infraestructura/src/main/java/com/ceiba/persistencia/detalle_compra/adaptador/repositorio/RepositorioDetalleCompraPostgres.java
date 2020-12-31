package com.ceiba.persistencia.detalle_compra.adaptador.repositorio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

public class RepositorioDetalleCompraPostgres implements RepositorioDetalleCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="detalle_compra", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="detalle_compra", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="detalle_compra", value="eliminar")
    private static String sqlEliminar;


    public RepositorioDetalleCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(DetalleCompra detalleCompra) {
        return null;
    }

    @Override
    public void actualizar(DetalleCompra detalleCompra) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
