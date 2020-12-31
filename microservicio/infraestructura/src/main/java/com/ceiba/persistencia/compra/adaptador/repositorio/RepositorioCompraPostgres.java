package com.ceiba.persistencia.compra.adaptador.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraPostgres implements RepositorioCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="articulo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="articulo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="articulo", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="articulo", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="articulo", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioCompraPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Compra compra) { return this.customNamedParameterJdbcTemplate.crear(compra, sqlCrear); }

    @Override
    public void actualizar(Compra compra) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(Long numeroFactura) {
        return false;
    }
}
