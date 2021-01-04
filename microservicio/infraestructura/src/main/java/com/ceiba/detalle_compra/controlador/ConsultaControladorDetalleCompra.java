package com.ceiba.detalle_compra.controlador;

import com.ceiba.articulo.consulta.ManejadorListarArticulos;
import com.ceiba.articulo.modelo.dto.DtoArticulo;
import com.ceiba.detalle_compra.consulta.ManejadorListaByIdCompraDetalleCompra;
import com.ceiba.detalle_compra.consulta.ManejadorListarDetalleCompra;
import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalleCompras")
public class ConsultaControladorDetalleCompra {

    private ManejadorListarDetalleCompra manejadorListarDetalleCompra;
    private ManejadorListaByIdCompraDetalleCompra manejadorListaByIdCompraDetalleCompra;

    public ConsultaControladorDetalleCompra(ManejadorListarDetalleCompra manejadorListarDetalleCompra, ManejadorListaByIdCompraDetalleCompra manejadorListaByIdCompraDetalleCompra) {
        this.manejadorListarDetalleCompra = manejadorListarDetalleCompra;
        this.manejadorListaByIdCompraDetalleCompra = manejadorListaByIdCompraDetalleCompra;
    }

    @GetMapping
    @ApiOperation("Listar Detalle de Compra")
    public List<DtoDetalleCompra> listar() { return this.manejadorListarDetalleCompra.ejecutar(); }

    @GetMapping("/byCompraId/{compraId}")
    @ApiOperation("Listar Detalle de Compra")
    public List<DtoDetalleCompra> listarByCompraId(@PathVariable Long compraId) { return this.manejadorListaByIdCompraDetalleCompra.ejecutar(compraId); }

}
