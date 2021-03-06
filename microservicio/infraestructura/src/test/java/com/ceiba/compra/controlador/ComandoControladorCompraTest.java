package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.servicio.testdatabuilder.ComandoCompraTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCompra.class)
public class ComandoControladorCompraTest {

    private static final Long COMPRA_ID = 2L;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoCompra compra = new ComandoCompraTestDataBuilder()
                .conListaDetallesAutoGenerada()
                .build();
        // act - assert
        mocMvc.perform(post("/compras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(compra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        ComandoCompra comandoCompra = new ComandoCompraTestDataBuilder()
                .conId(2L)
                .conNumeroFactura(12346L)
                .build();

        // act - assert
        mocMvc.perform(put("/compras/{id}", COMPRA_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCompra)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(delete("/compras/{id}", COMPRA_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
}
