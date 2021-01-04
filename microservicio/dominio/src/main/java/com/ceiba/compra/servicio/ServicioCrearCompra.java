package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra_detalle_compra.modelo.entidad.CompraDetalleCompra;
import com.ceiba.compra_detalle_compra.puerto.repository.RepositorioCompraDetalleCompra;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.detalle_compra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class ServicioCrearCompra {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";

    private final RepositorioCompra repositorioCompra;
    private final RepositorioDetalleCompra repositorioDetalleCompra;
    private final RepositorioCompraDetalleCompra repositorioCompraDetalleCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioDetalleCompra repositorioDetalleCompra, RepositorioCompraDetalleCompra repositorioCompraDetalleCompra) {
        this.repositorioCompra = repositorioCompra;
        this.repositorioDetalleCompra = repositorioDetalleCompra;
        this.repositorioCompraDetalleCompra = repositorioCompraDetalleCompra;
    }

    @Transactional
    public Long ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);
        Long compraId = this.repositorioCompra.crear(compra);
        guardarDetallesCompra(compra, compraId);
        return compraId;
    }

    public void guardarDetallesCompra(Compra compra, Long compraId) {
        List<DetalleCompra> listaDetalleCompra = compra.getListaDetalles();
        for (DetalleCompra detalleCompra : listaDetalleCompra) {
            Long detalleCompraId = repositorioDetalleCompra.crear(detalleCompra);
            guardarCompraDetalleCompra(compraId, detalleCompraId);
        }
    }

    public void guardarCompraDetalleCompra(Long compraId, Long detalleCompraId) {
        CompraDetalleCompra compraDetalleCompra = new CompraDetalleCompra(null, compraId, detalleCompraId);
        repositorioCompraDetalleCompra.crear(compraDetalleCompra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
