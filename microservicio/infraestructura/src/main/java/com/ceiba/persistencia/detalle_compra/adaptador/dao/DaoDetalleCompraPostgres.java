package com.ceiba.persistencia.detalle_compra.adaptador.dao;

import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalle_compra.puerto.dao.DaoDetalleCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import java.util.List;

public class DaoDetalleCompraPostgres implements DaoDetalleCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="detalle_compra", value="listar")
    private static String sqlListar;

    public DaoDetalleCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDetalleCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDetalleCompra());
    }
}
