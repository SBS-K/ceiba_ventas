package com.ceiba.detalle_compra.servicio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;

public class ServicioCrearDetalleCompra {

    private final RepositorioDetalleCompra repositorioDetalleCompra;

    public ServicioCrearDetalleCompra(RepositorioDetalleCompra repositorioDetalleCompra) {
        this.repositorioDetalleCompra = repositorioDetalleCompra;
    }

    public Long ejecutar(DetalleCompra detalleCompra) {
        return this.repositorioDetalleCompra.crear(detalleCompra);
    }

}
