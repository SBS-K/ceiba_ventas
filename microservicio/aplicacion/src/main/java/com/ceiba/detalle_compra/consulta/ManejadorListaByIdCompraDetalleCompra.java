package com.ceiba.detalle_compra.consulta;

import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalle_compra.puerto.dao.DaoDetalleCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaByIdCompraDetalleCompra {

    private final DaoDetalleCompra daoDetalleCompra;

    public ManejadorListaByIdCompraDetalleCompra(DaoDetalleCompra daoDetalleCompra) { this.daoDetalleCompra = daoDetalleCompra; }

    public List<DtoDetalleCompra> ejecutar(Long compraId) { return this.daoDetalleCompra.listarByIdCompra(compraId); }

}
