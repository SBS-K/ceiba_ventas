package com.ceiba.detalle_compra.adaptador.dao;

import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalle_compra.puerto.dao.DaoDetalleCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDetalleCompraPostgres implements DaoDetalleCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="detalle_compra", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="detalle_compra", value="listarByIdCompra")
    private static String sqlListarByIdCompra;

    public DaoDetalleCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDetalleCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDetalleCompra());
    }

    @Override
    public List<DtoDetalleCompra> listarByIdCompra(Long compraId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("compraId", compraId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarByIdCompra, paramSource, new MapeoDetalleCompra());
    }

}
