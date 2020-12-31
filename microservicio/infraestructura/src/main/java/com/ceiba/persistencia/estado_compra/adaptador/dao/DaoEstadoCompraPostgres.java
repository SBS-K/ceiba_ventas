package com.ceiba.persistencia.estado_compra.adaptador.dao;

import com.ceiba.estado_compra.modelo.dto.DtoEstadoCompra;
import com.ceiba.estado_compra.puerto.dao.DaoEstadoCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import java.util.List;

public class DaoEstadoCompraPostgres implements DaoEstadoCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="estado_compra", value="listar")
    private static String sqlListar;

    public DaoEstadoCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEstadoCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEstadoCompra());
    }
}
