package com.ceiba.detalle_compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.detalle_compra.comando.ComandoDetalleCompra;
import com.ceiba.detalle_compra.comando.fabrica.FabricaDetalleCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.servicio.ServicioActualizarDetalleCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDetalleCompra {

    private final FabricaDetalleCompra detalleCompra;
    private final ServicioActualizarDetalleCompra servicioActualizarDetalleCompra;

    public ManejadorActualizarDetalleCompra(FabricaDetalleCompra detalleCompra, ServicioActualizarDetalleCompra servicioActualizarDetalleCompra) {
        this.detalleCompra = detalleCompra;
        this.servicioActualizarDetalleCompra = servicioActualizarDetalleCompra;
    }

    public void ejecutar(ComandoDetalleCompra comandoDetalleCompra) {
        DetalleCompra detalleCompra = this.detalleCompra.crear(comandoDetalleCompra);
        this.servicioActualizarDetalleCompra.ejecutar(detalleCompra);
    }

}
