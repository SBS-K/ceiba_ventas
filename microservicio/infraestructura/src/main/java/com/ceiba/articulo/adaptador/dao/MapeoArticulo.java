package com.ceiba.articulo.adaptador.dao;

import com.ceiba.articulo.modelo.dto.DtoArticulo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoArticulo implements RowMapper<DtoArticulo>, MapperResult {

    @Override
    public DtoArticulo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Double precio = resultSet.getDouble("precio");

        return new DtoArticulo(id, nombre, descripcion, precio);
    }
}
