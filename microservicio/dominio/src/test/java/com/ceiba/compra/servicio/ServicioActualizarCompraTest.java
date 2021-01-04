package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDevolucion;
import com.ceiba.dominio.excepcion.ExcepcionNoExisteRegistroBD;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ServicioActualizarCompraTest {

    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "La compra no existe en el sistema";
    private static final String NO_SE_PUEDE_HACE_DEVOLUCION_VEINTICUATRO_HORAS_DESPUES = "No se puede hacer devolucion veinticuatro horas despues";
    private static final String ESTADO_COMPRA = "Compra Finalizada";
    private static final String ESTADO_DEVOLUCION = "Devolucion";

    private RepositorioCompra repositorioCompra;

    @Before
    public void setUp() {
        repositorioCompra = Mockito.mock(RepositorioCompra.class);
    }

    @Test
    public void validarExistenciaPreviaTest() {

        // Arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        Mockito.when(repositorioCompra.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // Act - Assert
        BasePrueba.assertThrows(() ->
                servicioActualizarCompra.ejecutar(compra), ExcepcionNoExisteRegistroBD.class, LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarAccesoADevolucion() {
        // Arrange
        Compra compra = new CompraTestDataBuilder()
                .conEstadoCompra(ESTADO_DEVOLUCION)
                .conFechaCompra(LocalDateTime.now().minusHours(26)).build();
        Mockito.when(repositorioCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // Act - Assert
        BasePrueba.assertThrows(() ->
                servicioActualizarCompra.ejecutar(compra), ExcepcionDevolucion.class, NO_SE_PUEDE_HACE_DEVOLUCION_VEINTICUATRO_HORAS_DESPUES);
    }

    @Test
    public void pasaronVeintiCuatroHoraDesdeCompra() {
        // Arrange
        LocalDateTime fechaDespuesVeintiCuatroHoras = LocalDateTime.now().plusHours(27);
        LocalDateTime fechaAntesVeintiCuatroHoras = LocalDateTime.now().plusHours(5);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);

        // Act
        boolean pasaronVeintiCuatroHoraDesdeCompra = servicioActualizarCompra.pasaronVeintiCuatroHoraDesdeCompra(fechaDespuesVeintiCuatroHoras);
        boolean noPasaronVeintiCuatroHoraDesdeCompra = servicioActualizarCompra.pasaronVeintiCuatroHoraDesdeCompra(fechaAntesVeintiCuatroHoras);

        // Assert
        assertTrue(pasaronVeintiCuatroHoraDesdeCompra);
        assertFalse(noPasaronVeintiCuatroHoraDesdeCompra);
    }

    @Test
    public void esDevolucion() {

        // Arrage
        Compra compraUno = new CompraTestDataBuilder().conEstadoCompra(ESTADO_DEVOLUCION).build();
        Compra compraDos = new CompraTestDataBuilder().conEstadoCompra(ESTADO_COMPRA).build();
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);

        // Act
        boolean esDevolucionTestUno = servicioActualizarCompra.esDevolucion(compraUno.getEstadoCompra());
        boolean esUnaDevolucionTestDos = servicioActualizarCompra.esDevolucion(compraDos.getEstadoCompra());

        // Assert
        assertTrue(esDevolucionTestUno);
        assertFalse(esUnaDevolucionTestDos);
    }

}
