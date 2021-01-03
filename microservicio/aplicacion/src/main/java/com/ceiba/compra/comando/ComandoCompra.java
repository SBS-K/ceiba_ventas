package com.ceiba.compra.comando;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCompra {

    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private String estadoCompra;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;
}
