package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNoExisteRegistroBD;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarCompraTest {

    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "La compra no existe en el sistema";

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
        ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);
        // Act - Assert
        BasePrueba.assertThrows(() ->
                servicioEliminarCompra.ejecutar(compra.getId()), ExcepcionNoExisteRegistroBD.class, LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
    }

}
