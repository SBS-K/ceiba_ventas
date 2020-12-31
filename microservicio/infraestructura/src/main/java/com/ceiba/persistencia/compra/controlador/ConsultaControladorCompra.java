package com.ceiba.persistencia.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListarCompras;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
@Api(tags={"Controlador consulta compras"})
public class ConsultaControladorCompra {

    private final ManejadorListarCompras manejadorListarCompras;

    public ConsultaControladorCompra(ManejadorListarCompras manejadorListarCompras) {
        this.manejadorListarCompras = manejadorListarCompras;
    }

    @GetMapping
    @ApiOperation("Listar Compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompras.ejecutar();
    }

}
