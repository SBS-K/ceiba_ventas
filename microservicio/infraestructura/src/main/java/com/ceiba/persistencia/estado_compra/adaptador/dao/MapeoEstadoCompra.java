package com.ceiba.persistencia.estado_compra.adaptador.dao;

import com.ceiba.estado_compra.modelo.dto.DtoEstadoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEstadoCompra implements RowMapper<DtoEstadoCompra>, MapperResult {
    @Override
    public DtoEstadoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");

        return new DtoEstadoCompra(id, nombre, descripcion);
    }
}
