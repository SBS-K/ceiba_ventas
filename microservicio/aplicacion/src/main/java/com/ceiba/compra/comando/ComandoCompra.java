package com.ceiba.compra.comando;

import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;
    private EstadoCompra estadoCompra;
}
