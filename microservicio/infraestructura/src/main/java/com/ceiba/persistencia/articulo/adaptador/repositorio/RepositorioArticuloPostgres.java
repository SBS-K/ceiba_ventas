package com.ceiba.persistencia.articulo.adaptador.repositorio;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioArticuloPostgres implements RepositorioArticulo {

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

    public RepositorioArticuloPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Articulo articulo) {
        return this.customNamedParameterJdbcTemplate.crear(articulo, sqlCrear);
    }

    @Override
    public void actualizar(Articulo articulo) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existeConCategoria(String nombre, Categoria categoria) {
        return false;
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        return false;
    }
}
