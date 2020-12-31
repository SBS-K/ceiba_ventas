package com.ceiba.detalle_compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.detalle_compra.comando.ComandoDetalleCompra;
import com.ceiba.detalle_compra.comando.fabrica.FabricaDetalleCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.servicio.ServicioCrearDetalleCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDetalleCompra {

    private final FabricaDetalleCompra detalleCompra;
    private final ServicioCrearDetalleCompra servicioCrearDetalleCompra;

    public ManejadorCrearDetalleCompra(FabricaDetalleCompra detalleCompra, ServicioCrearDetalleCompra servicioCrearDetalleCompra) {
        this.detalleCompra = detalleCompra;
        this.servicioCrearDetalleCompra = servicioCrearDetalleCompra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDetalleCompra comandoDetalleCompra) {
        DetalleCompra detalleCompra = this.detalleCompra.crear(comandoDetalleCompra);
        return new ComandoRespuesta<>(this.servicioCrearDetalleCompra.ejecutar(detalleCompra));
    }

}
