package com.ceiba.persistencia.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCompraPostgres implements DaoCompra {
    @Override
    public List<DtoCompra> listar() {
        return null;
    }
}
