package com.ceiba.persistencia.articulo.adaptador.dao;

import com.ceiba.articulo.modelo.dto.DtoArticulo;
import com.ceiba.articulo.puerto.dao.DaoArticulo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoArticuloPostgres implements DaoArticulo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="articulo", value="listar")
    private static String sqlListar;

    public DaoArticuloPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoArticulo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoArticulo());
    }
}
