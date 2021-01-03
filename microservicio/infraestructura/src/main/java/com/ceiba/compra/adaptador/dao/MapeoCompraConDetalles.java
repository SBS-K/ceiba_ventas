package com.ceiba.compra.adaptador.dao;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//public class MapeoCompraConDetalles implements RowMapper<DtoCompra>, MapperResult {
//
//    @Override
//    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//
//        Map<Long, DtoCompra> compraActual = new HashMap<>();
//        List<DetalleCompra> listaDetalles = new LinkedList<>();
//        while(resultSet.next()) {
//
//            Long id = resultSet.getLong("id");
//            Long numeroFactura = resultSet.getLong("numero_factura");
//            Double costoTotal = resultSet.getDouble("costo_total");
//            String estadoCompra = resultSet.getString("estado_compra");
//            LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fecha_compra");
//            LocalDateTime fechaEnvio = extraerLocalDateTime(resultSet, "fecha_envio");
//
//            DtoCompra dtoCompra = compraActual.get(id);
//            if ( dtoCompra == null ) {
//                listaDetalles = new LinkedList<>();
//                dtoCompra = new DtoCompra(id, numeroFactura, costoTotal, estadoCompra, listaDetalles, fechaCompra, fechaEnvio);
//                compraActual.put(id, dtoCompra);
//            }
//
//            Long detalleCompraId = resultSet.getLong("id");
//            Integer cantidad = resultSet.getInt("cantidad");
//            Double subtotal = resultSet.getDouble("subtotal");
//
//            Long articuloId = resultSet.getLong("articulo_id");
//            String articuloNombre = resultSet.getString("nombre");
//            String articuloDescripcion = resultSet.getString("descripcion");
//            Double articuloPrecio = resultSet.getDouble("precio");
//            Articulo articulo = new Articulo(articuloId, articuloNombre, articuloDescripcion, articuloPrecio);
//
//            DetalleCompra detalleCompra = new DetalleCompra(detalleCompraId, articulo, cantidad, subtotal);
//            listaDetalles.add(detalleCompra);
//
//        }
//
//        return new DtoCompra(id, numeroFactura, costoTotal, estadoCompra,null, fechaCompra, fechaEnvio);
//    }
//
//}
