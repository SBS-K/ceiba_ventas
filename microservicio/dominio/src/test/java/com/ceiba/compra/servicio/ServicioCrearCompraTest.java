package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCompraTest {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";

    private RepositorioCompra repositorioCompra;

    @Before
    public void setUp() {
        repositorioCompra = Mockito.mock(RepositorioCompra.class);
    }

    @Test
    public void validarExistenciaPreviaTest() {

        // Arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        Mockito.when(repositorioCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // Act - Assert
        BasePrueba.assertThrows(() ->
                servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class, LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
    }

}