package com.ceiba.articulo.comando.fabrica;

import com.ceiba.articulo.comando.ComandoArticulo;
import com.ceiba.articulo.modelo.entidad.Articulo;
import org.springframework.stereotype.Component;

@Component
public class FabricaArticulo {

    public Articulo crear(ComandoArticulo comandoArticulo) {
        return new Articulo(
                comandoArticulo.getId(),
                comandoArticulo.getNombre(),
                comandoArticulo.getDescripcion(),
                comandoArticulo.getPrecio(),
                comandoArticulo.getCategoria()
        );
    }

}
