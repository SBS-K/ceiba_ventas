package com.ceiba.detalle_compra.servicio;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarDetalleCompra {

    private final RepositorioDetalleCompra repositorioDetalleCompra;

    public ServicioActualizarDetalleCompra(RepositorioDetalleCompra repositorioDetalleCompra) {
        this.repositorioDetalleCompra = repositorioDetalleCompra;
    }

    public Long ejecutar(DetalleCompra detalleCompra) {
        return this.repositorioDetalleCompra.crear(detalleCompra);
    }

}
