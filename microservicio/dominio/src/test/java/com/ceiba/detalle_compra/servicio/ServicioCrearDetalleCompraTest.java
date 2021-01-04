package com.ceiba.detalle_compra.servicio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.detalle_compra.servicio.testdatabuilder.DetalleCompraTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioCrearDetalleCompraTest {

    private static final Long DETALLE_COMPRA_ID = 1L;

    private RepositorioDetalleCompra repositorioDetalleCompra;

    @Before
    public void setUp() {
        repositorioDetalleCompra = Mockito.mock(RepositorioDetalleCompra.class);
    }

    @Test
    public void ejecutar() {

        // Arrange
        DetalleCompra detalleCompra = new DetalleCompraTestDataBuilder().conId(DETALLE_COMPRA_ID).build();
        Mockito.when(repositorioDetalleCompra.crear(detalleCompra)).thenReturn(DETALLE_COMPRA_ID);
        ServicioCrearDetalleCompra servicioCrearDetalleCompra = new ServicioCrearDetalleCompra(repositorioDetalleCompra);

        // Act
        Long detalleCompraId = servicioCrearDetalleCompra.ejecutar(detalleCompra);

        // Assert
        assertEquals(detalleCompraId, DETALLE_COMPRA_ID);
    }

}
