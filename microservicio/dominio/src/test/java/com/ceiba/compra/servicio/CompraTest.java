package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class CompraTest {

    private static final Long NUMERO_FACTURA = 2L;
    private static final Double COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL = 50000D;
    private static final Double COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL_RECARGO = 52000D;
    private static final Double COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL = 280000D;
    private static final Double COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL_RECARGO = 291200D;
    private static final String ESTADO_COMPRA = "Compra Finalizada";
    private static final LocalDateTime FECHA_COMPRA = LocalDateTime.now();

    // Horas de envio
    private static final Integer HORA_COMIENZO_DE_ENVIOS = 8;
    private static final Integer MINUTOS_COMIENZO_DE_ENVIOS = 0;
    private static final Integer MINUTOS_HASTA_REALIZAR_ENVIOS = 30;

    // Otros
    private static final Integer UN_DIA = 1;

//    private CompraTestDataBuilder compraTestDataBuilder;
//    private Compra compra;
//
//    @Before
//    public void setUp() {
//        // Arrange
//        compraTestDataBuilder = new CompraTestDataBuilder()
//                .conNumeroFactura(NUMERO_FACTURA)
//                .conCostoTotal(COSTO_TOTAL)
//                .conEstadoCompra(ESTADO_COMPRA)
//                .conFechaCompra(FECHA_COMPRA)
//                .conListDetalles(getListDetalleCompra());
//        compra = compraTestDataBuilder.build();
//    }

    @Test
    public void crearCompraTest() {

        // Arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder()
                .conNumeroFactura(NUMERO_FACTURA)
                .conCostoTotal(COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL)
                .conEstadoCompra(ESTADO_COMPRA)
                .conFechaCompra(FECHA_COMPRA)
                .conListDetalles(getListDetalleCompra());

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertEquals(NUMERO_FACTURA, compra.getNumeroFactura());
        assertEquals(COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL, compra.getCostoTotal());
        assertEquals(ESTADO_COMPRA, compra.getEstadoCompra());
        assertEquals(FECHA_COMPRA, compra.getFechaCompra());

    }

    @Test
    public void calcularFechaEnvio() {

        //Arrage
        LocalDateTime mediaNoche = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime mayorALas6PmYMenorALas12AM = LocalDateTime.now().withHour(21).withMinute(0);
        LocalDateTime mayorA12AmYMenorAlas8AM = LocalDateTime.now().withHour(6).withMinute(0);
        LocalDateTime mayorA8AmYMenorALas6Pm = LocalDateTime.now().withHour(13).withMinute(0);

        LocalDateTime fechaEntregaMayorALas6PmYMenorALas12AM = mayorALas6PmYMenorALas12AM.plusDays(UN_DIA).withHour(HORA_COMIENZO_DE_ENVIOS).withMinute(MINUTOS_COMIENZO_DE_ENVIOS);
        LocalDateTime fechaEntregaMayorA12AmYMenorAlas8AM = mayorA12AmYMenorAlas8AM.withMinute(HORA_COMIENZO_DE_ENVIOS).withMinute(MINUTOS_COMIENZO_DE_ENVIOS);
        LocalDateTime fechaEntregaMayorA8AmYMenorALas6Pm = mayorA8AmYMenorALas6Pm.plusMinutes(MINUTOS_HASTA_REALIZAR_ENVIOS);

        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertEquals(fechaEntregaMayorALas6PmYMenorALas12AM, compra.calcularFechaEnvio(mayorALas6PmYMenorALas12AM));
        assertEquals(fechaEntregaMayorA12AmYMenorAlas8AM, compra.calcularFechaEnvio(mayorA12AmYMenorAlas8AM));
        assertEquals(fechaEntregaMayorA8AmYMenorALas6Pm, compra.calcularFechaEnvio(mayorA8AmYMenorALas6Pm));
    }

    @Test
    public void esMayorALas6PmYMenorALas12AM() {

        //Arrage
        LocalDateTime mediaNoche = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime mayorALas6PmYMenorALas12AM = LocalDateTime.now().withHour(21).withMinute(0);
        LocalDateTime mayorA12AmYMenorAlas8AM = LocalDateTime.now().withHour(6).withMinute(0);
        LocalDateTime mayorA8AmYMenorALas6Pm = LocalDateTime.now().withHour(13).withMinute(0);
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertTrue(compra.esMayorALas6PmYMenorALas12AM(mediaNoche));
        assertTrue(compra.esMayorALas6PmYMenorALas12AM(mayorALas6PmYMenorALas12AM));
        assertFalse(compra.esMayorALas6PmYMenorALas12AM(mayorA12AmYMenorAlas8AM));
        assertFalse(compra.esMayorALas6PmYMenorALas12AM(mayorA8AmYMenorALas6Pm));
    }

    @Test
    public void esMayorALas12AmYMenorALas8Am() {

        // Arrage
        LocalDateTime comienzoDeDia = LocalDateTime.now().withHour(0).withMinute(0);
        LocalDateTime mayorA12AmYMenorAlas8AM = LocalDateTime.now().withHour(6).withMinute(0);
        LocalDateTime mayorALas6PmYMenorALas12AM = LocalDateTime.now().withHour(22).withMinute(0);
        LocalDateTime mayorA8AmYMenorALas6Pm = LocalDateTime.now().withHour(13).withMinute(0);
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertTrue(compra.esMayorALas12AmYMenorALas8Am(comienzoDeDia));
        assertTrue(compra.esMayorALas12AmYMenorALas8Am(mayorA12AmYMenorAlas8AM));
        assertFalse(compra.esMayorALas12AmYMenorALas8Am(mayorALas6PmYMenorALas12AM));
        assertFalse(compra.esMayorALas12AmYMenorALas8Am(mayorA8AmYMenorALas6Pm));
    }

    @Test
    public void siTieneRecargoCalcularCostoTotal() {

        // Arrage
        LocalDateTime siguienteMiercoles = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDateTime siguienteSabado = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertEquals(COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL, compra.siTieneRecargoCalcularCostoTotal(siguienteMiercoles, COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL));
        assertEquals(COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL, compra.siTieneRecargoCalcularCostoTotal(siguienteMiercoles, COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL));
        assertEquals(COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL_RECARGO, compra.siTieneRecargoCalcularCostoTotal(siguienteSabado, COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL));
        assertEquals(COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL, compra.siTieneRecargoCalcularCostoTotal(siguienteSabado, COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL));

    }

    @Test
    public void calcularCostoTotalConPorcentajeRecargo() {
        //Arrage
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Act - Assert
        assertEquals(COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL_RECARGO, compra.calcularCostoTotalConPorcentajeRecargo(COSTO_TOTAL_MAYOR_A_DOCIENTOS_MIL));
        assertEquals(COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL_RECARGO, compra.calcularCostoTotalConPorcentajeRecargo(COSTO_TOTAL_MENOR_A_DOCIENTOS_MIL));
    }

    @Test
    public void esMenorADocientosMilPesos() {

        // Arrage
        Double mayorADocientosMil = 500000D;
        Double menorADocientosMil = 10000D;
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertTrue(compra.esMenorADocientosMilPesos(menorADocientosMil));
        assertFalse(compra.esMenorADocientosMilPesos(mayorADocientosMil));
    }

    @Test
    public void esFinDeSemana() {
        // Arrage
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder();
        LocalDateTime siguienteMiercoles = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDateTime siguienteSabado = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDateTime siguienteDomingo = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        // Act
        Compra compra = compraTestDataBuilder.build();

        // Assert
        assertFalse(compra.esFinDeSemana(siguienteMiercoles));
        assertTrue(compra.esFinDeSemana(siguienteSabado));
        assertTrue(compra.esFinDeSemana(siguienteDomingo));
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
