package com.ceiba.persistencia.categoria.adaptador.dao;

import com.ceiba.categoria.modelo.dto.DtoCategoria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCategoria implements RowMapper<DtoCategoria>, MapperResult {

    @Override
    public DtoCategoria mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");

        return new DtoCategoria(id, nombre, descripcion);
    }
}
