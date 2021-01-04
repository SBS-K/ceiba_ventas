package com.ceiba.detalle_compra.adaptador.repositorio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDetalleCompraPostgres implements RepositorioDetalleCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="detalle_compra", value="crear")
    private static String sqlCrear;

    public RepositorioDetalleCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(DetalleCompra detalleCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("articulo", detalleCompra.getArticulo().getId());
        paramSource.addValue("cantidad", detalleCompra.getCantidad());
        paramSource.addValue("subtotal", detalleCompra.getSubtotal());
        return this.customNamedParameterJdbcTemplate.crearConProfundidad(paramSource, sqlCrear);
    }

}
