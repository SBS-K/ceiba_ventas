package com.ceiba.persistencia.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long numeroFactura = resultSet.getLong("numero_factura");
        Double costoTotal = resultSet.getDouble("costo_total");
        EstadoCompra estadoCompra = (EstadoCompra) resultSet.getObject("estado_compra_id");
        LocalDateTime fechaEnvio = extraerLocalDateTime(resultSet, "fecha_envio");
//        List<DetalleCompra> listaDetalles = resultSet.getArray("detalle_compra_id");

        return new DtoCompra(id, numeroFactura, costoTotal, null, fechaEnvio, estadoCompra);
    }

}
