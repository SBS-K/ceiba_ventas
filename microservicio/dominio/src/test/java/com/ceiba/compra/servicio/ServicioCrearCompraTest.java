package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class ServicioCrearCompraTest {


    private RepositorioCompra repositorioCompra;

    @Before
    public void setUp() {
        repositorioCompra = mock(RepositorioCompra.class);
    }


    }
