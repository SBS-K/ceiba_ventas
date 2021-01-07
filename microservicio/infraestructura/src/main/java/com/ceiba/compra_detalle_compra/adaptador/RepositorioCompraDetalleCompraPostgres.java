package com.ceiba.compra_detalle_compra.adaptador;

import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;
import com.ceiba.compra_detalle_compra.puerto.repository.RepositorioCompraDetalleCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraDetalleCompraPostgres implements RepositorioCompraDetalleCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="compra_detalle_compra", value="crear")
    private static String sqlCrear;

    public RepositorioCompraDetalleCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(CompraDetalleCompra compraDetalleCompra) {
        return this.customNamedParameterJdbcTemplate.crear(compraDetalleCompra, sqlCrear);
    }
}
