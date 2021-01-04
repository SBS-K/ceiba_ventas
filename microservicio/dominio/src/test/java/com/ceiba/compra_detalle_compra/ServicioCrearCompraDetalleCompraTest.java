package com.ceiba.compra_detalle_compra;

import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;
import com.ceiba.compra_detalle_compra.puerto.repository.RepositorioCompraDetalleCompra;
import com.ceiba.compra_detalle_compra.servicio.ServicioCrearCompraDetalleCompra;
import com.ceiba.compra_detalle_compra.testdatabuilder.CompraDetalleCompraTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class ServicioCrearCompraDetalleCompraTest {

    private static final Long COMPRA_DETALLE_COMPRA_ID = 1L;

    private RepositorioCompraDetalleCompra repositorioCompraDetalleCompra;

    @Before
    public void setUp() {
        repositorioCompraDetalleCompra = Mockito.mock(RepositorioCompraDetalleCompra.class);
    }

    @Test
    public void ejecutar() {

        // Arrange
        CompraDetalleCompra compraDetalleCompra = new CompraDetalleCompraTestDataBuilder().conId(COMPRA_DETALLE_COMPRA_ID).build();
        Mockito.when(repositorioCompraDetalleCompra.crear(compraDetalleCompra)).thenReturn(COMPRA_DETALLE_COMPRA_ID);
        ServicioCrearCompraDetalleCompra servicioCrearCompraDetalleCompra = new ServicioCrearCompraDetalleCompra(repositorioCompraDetalleCompra);

        // Act
        Long compraDetalleCompraId = servicioCrearCompraDetalleCompra.ejecutar(compraDetalleCompra);

        // Assert
        assertEquals(compraDetalleCompraId, COMPRA_DETALLE_COMPRA_ID);
    }


}
