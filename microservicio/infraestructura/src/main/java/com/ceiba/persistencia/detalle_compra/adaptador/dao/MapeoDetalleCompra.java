package com.ceiba.persistencia.detalle_compra.adaptador.dao;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoDetalleCompra implements RowMapper<DtoDetalleCompra>, MapperResult {
    @Override
    public DtoDetalleCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Integer cantidad = resultSet.getInt("cantidad");
        Double subtotal = resultSet.getDouble("subtotal");
        Articulo articulo = (Articulo) resultSet.getObject("articulo_id");

        return new DtoDetalleCompra(id, articulo, cantidad, subtotal);
    }
}
