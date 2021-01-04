package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import com.ceiba.compra.comando.manejador.ManejadorEliminarCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
@Api(tags = { "Controlador comando compra"})
public class ComandoControladorCompra {

    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorEliminarCompra manejadorEliminarCompra;
    private final ManejadorActualizarCompra manejadorActualizarCompra;

    @Autowired
    public ComandoControladorCompra(ManejadorCrearCompra manejadorCrearCompra, ManejadorEliminarCompra manejadorEliminarCompra, ManejadorActualizarCompra manejadorActualizarCompra) {
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorEliminarCompra = manejadorEliminarCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
    }

    @PostMapping
    @ApiOperation("Crear Compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCrearCompra.ejecutar(comandoCompra);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Compra")
    public void actualizar(@RequestBody ComandoCompra comandoCompra,@PathVariable Long id) {
        comandoCompra.setId(id);
        System.out.println("comandoCompra " + comandoCompra.getNumeroFactura());
        manejadorActualizarCompra.ejecutar(comandoCompra);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Compra")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCompra.ejecutar(id);
    }


}
