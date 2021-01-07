package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long numeroFactura = resultSet.getLong("numero_factura");
        Double costoTotal = resultSet.getDouble("costo_total");
        String estadoCompra = resultSet.getString("estado_compra");
        LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fecha_compra");
        LocalDateTime fechaEnvio = extraerLocalDateTime(resultSet, "fecha_envio");

        return new DtoCompra(id, numeroFactura, costoTotal, estadoCompra,new LinkedList<>(), fechaCompra, fechaEnvio);
    }

}
