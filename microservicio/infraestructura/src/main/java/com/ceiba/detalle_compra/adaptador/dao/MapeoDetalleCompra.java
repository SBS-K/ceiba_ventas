package com.ceiba.detalle_compra.adaptador.dao;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDetalleCompra implements RowMapper<DtoDetalleCompra>, MapperResult {
    @Override
    public DtoDetalleCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Integer cantidad = resultSet.getInt("cantidad");
        Double subtotal = resultSet.getDouble("subtotal");

        Long articuloId = resultSet.getLong("articulo_id");
        String articuloNombre = resultSet.getString("nombre");
        String articuloDescripcion = resultSet.getString("descripcion");
        Double articuloPrecio = resultSet.getDouble("precio");
        Articulo articulo = new Articulo(articuloId, articuloNombre, articuloDescripcion, articuloPrecio);

        return new DtoDetalleCompra(id, articulo, cantidad, subtotal);
    }
}
