package com.ceiba.detalle_compra.servicio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;

public class ServicioEliminarDetalleCompra {

    private final RepositorioDetalleCompra repositorioDetalleCompra;

    public ServicioEliminarDetalleCompra(RepositorioDetalleCompra repositorioDetalleCompra) { this.repositorioDetalleCompra = repositorioDetalleCompra; }

    public void ejecutar(Long id) { this.repositorioDetalleCompra.eliminar(id); }
}
k