package com.ceiba.detalle_compra.comando.fabrica;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.detalle_compra.comando.ComandoDetalleCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import org.springframework.stereotype.Component;

@Component
public class FabricaDetalleCompra {

    public DetalleCompra crear(ComandoDetalleCompra comandoDetalleCompra) {
        return new DetalleCompra(
                comandoDetalleCompra.getId(),
                comandoDetalleCompra.getArticulo(),
                comandoDetalleCompra.getCantidad(),
                comandoDetalleCompra.getSubtotal()
        );
    }

}
