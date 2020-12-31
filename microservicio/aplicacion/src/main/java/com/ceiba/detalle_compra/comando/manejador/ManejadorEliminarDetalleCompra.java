package com.ceiba.detalle_compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.detalle_compra.comando.ComandoDetalleCompra;
import com.ceiba.detalle_compra.comando.fabrica.FabricaDetalleCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.servicio.ServicioActualizarDetalleCompra;
import com.ceiba.detalle_compra.servicio.ServicioEliminarDetalleCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarDetalleCompra {

    private final FabricaDetalleCompra detalleCompra;
    private final ServicioEliminarDetalleCompra servicioEliminarDetalleCompra;

    public ManejadorEliminarDetalleCompra(FabricaDetalleCompra detalleCompra, ServicioEliminarDetalleCompra servicioEliminarDetalleCompra) {
        this.detalleCompra = detalleCompra;
        this.servicioEliminarDetalleCompra = servicioEliminarDetalleCompra;
    }

    public void ejecutar(Long idDetalleCompra) {
        this.servicioEliminarDetalleCompra.ejecutar(idDetalleCompra);
    }
}
