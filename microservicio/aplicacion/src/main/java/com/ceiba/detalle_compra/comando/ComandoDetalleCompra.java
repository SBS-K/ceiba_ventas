package com.ceiba.detalle_compra.comando;

import com.ceiba.articulo.modelo.entidad.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDetalleCompra {

    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private Double subtotal;
}
