package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FabricaCompra {

    public Compra crear(ComandoCompra comandoCompra){
        return new Compra(
                comandoCompra.getId(),
                comandoCompra.getNumeroFactura(),
                comandoCompra.getCostoTotal(),
                comandoCompra.getListaDetalles(),
                comandoCompra.getFechaCompra(),
                comandoCompra.getEstadoCompra()
        );
    }

}
