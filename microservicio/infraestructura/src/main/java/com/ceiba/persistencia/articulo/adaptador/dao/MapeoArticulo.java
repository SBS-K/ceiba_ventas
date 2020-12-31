package com.ceiba.persistencia.articulo.adaptador.dao;

import com.ceiba.articulo.modelo.dto.DtoArticulo;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoArticulo implements RowMapper<DtoArticulo>, MapperResult {

    @Override
    public DtoArticulo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Double precio = resultSet.getDouble("precio");
        Categoria categoria = (Categoria) resultSet.getObject("categoria_id");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
        LocalDateTime fechaActualizacion = extraerLocalDateTime(resultSet, "fecha_actualizacion");
        Boolean estado = resultSet.getBoolean("estado");

        return new DtoArticulo(id, nombre, descripcion, precio, categoria);
    }
}
