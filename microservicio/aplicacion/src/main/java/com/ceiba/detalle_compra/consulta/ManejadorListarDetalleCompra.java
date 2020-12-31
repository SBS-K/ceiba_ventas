package com.ceiba.detalle_compra.consulta;

import com.ceiba.detalle_compra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalle_compra.puerto.dao.DaoDetalleCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDetalleCompra {

    private final DaoDetalleCompra daoDetalleCompra;

    public ManejadorListarDetalleCompra(DaoDetalleCompra daoDetalleCompra) { this.daoDetalleCompra = daoDetalleCompra; }

    public List<DtoDetalleCompra> ejecutar() { return this.daoDetalleCompra.listar(); }
}
