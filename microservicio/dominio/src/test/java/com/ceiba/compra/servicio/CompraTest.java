package com.ceiba.compra.servicio;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompraTest {

    private static final Long NUMERO_FACTURA = 2L;
    private static final Double COSTO_TOTAL = 280000.00;
    private static final String ESTADO_COMPRA = "Compra Finalizada";
    private static final LocalDateTime FECHA_COMPRA = LocalDateTime.now();

    @Test
    public void crearCompraTest() {

        // Arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder()
                .conNumeroFactura(NUMERO_FACTURA)
                .conCostoTotal(COSTO_TOTAL)
                .conEstadoCompra(ESTADO_COMPRA)
                .conFechaCompra(FECHA_COMPRA)
                .conListDetalles(getListDetalleCompra());

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertEquals(NUMERO_FACTURA, compra.getNumeroFactura());
        assertEquals(COSTO_TOTAL, compra.getCostoTotal());
        assertEquals(ESTADO_COMPRA, compra.getEstadoCompra());
        assertEquals(FECHA_COMPRA, compra.getFechaCompra());

    }

    public List<DetalleCompra> getListDetalleCompra() {
        List<DetalleCompra> listaDetallesCompra = new LinkedList<>();
        for (int i = 1; i <= 3; i++ ) {
            Articulo articulo = new Articulo((long) i, "Articulo " + i, "Articulo " + i, (i * 20000.00) );
            DetalleCompra detalleCompra = new DetalleCompra((long)i, articulo, i, articulo.getPrecio() * i );
            listaDetallesCompra.add(detalleCompra);
        }
        return listaDetallesCompra;
    }

}
