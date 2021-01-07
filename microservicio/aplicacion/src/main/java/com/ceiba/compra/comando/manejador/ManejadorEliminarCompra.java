package com.ceiba.compra.comando.manejador;

import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCompra implements ManejadorComando<Long> {

    private final FabricaCompra fabricaCompra;
    private final ServicioEliminarCompra servicioEliminarCompra;

    public ManejadorEliminarCompra(FabricaCompra fabricaCompra, ServicioEliminarCompra servicioEliminarCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioEliminarCompra = servicioEliminarCompra;
    }

    @Override
    public void ejecutar(Long idCompra) {
        this.servicioEliminarCompra.ejecutar(idCompra);
    }
}
