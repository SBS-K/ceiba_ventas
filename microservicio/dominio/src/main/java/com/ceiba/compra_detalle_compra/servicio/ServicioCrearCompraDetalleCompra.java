package com.ceiba.compra_detalle_compra.servicio;

import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;
import com.ceiba.compra_detalle_compra.puerto.repository.RepositorioCompraDetalleCompra;

public class ServicioCrearCompraDetalleCompra {

    private final RepositorioCompraDetalleCompra repositorioCompraDetalleCompra;

    public ServicioCrearCompraDetalleCompra(RepositorioCompraDetalleCompra repositorioCompraDetalleCompra) {
        this.repositorioCompraDetalleCompra = repositorioCompraDetalleCompra;
    }

    public Long ejecutar(CompraDetalleCompra compraDetalleCompra) {
        return this.repositorioCompraDetalleCompra.crear(compraDetalleCompra);
    }

}
