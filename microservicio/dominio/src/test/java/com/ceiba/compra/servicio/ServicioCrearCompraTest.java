package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;
import com.ceiba.compra_detalle_compra.puerto.repository.RepositorioCompraDetalleCompra;
import com.ceiba.compra_detalle_compra.servicio.ServicioCrearCompraDetalleCompra;
import com.ceiba.compra_detalle_compra.testdatabuilder.CompraDetalleCompraTestDataBuilder;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioCrearCompraTest {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";
    private static final Long COMPRA_ID = 1L;

    private RepositorioCompra repositorioCompra;
    private RepositorioDetalleCompra repositorioDetalleCompra;
    private RepositorioCompraDetalleCompra repositorioCompraDetalleCompra;

    @Before
    public void setUp() {
        repositorioCompra = Mockito.mock(RepositorioCompra.class);
        repositorioDetalleCompra = Mockito.mock(RepositorioDetalleCompra.class);
        repositorioCompraDetalleCompra = Mockito.mock(RepositorioCompraDetalleCompra.class);
    }

    @Test
    public void ejecutar() {

        // Arrange
        Compra compra = new CompraTestDataBuilder().conId(COMPRA_ID).conListaDetallesAutoGenerada().build();
        Mockito.when(repositorioCompra.crear(compra)).thenReturn(COMPRA_ID);
        Mockito.when(repositorioDetalleCompra.crear(compra.getListaDetalles().get(0))).thenReturn(COMPRA_ID);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioDetalleCompra, repositorioCompraDetalleCompra);
        // Act
        Long compraDetalleCompraId = servicioCrearCompra.ejecutar(compra);
        // Assert
        assertEquals(compraDetalleCompraId, COMPRA_ID);
    }

    @Test
    public void validarExistenciaPreviaTest() {

        // Arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        Mockito.when(repositorioCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioDetalleCompra, repositorioCompraDetalleCompra);
        // Act - Assert
        BasePrueba.assertThrows(() ->
                servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class, LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
    }

}