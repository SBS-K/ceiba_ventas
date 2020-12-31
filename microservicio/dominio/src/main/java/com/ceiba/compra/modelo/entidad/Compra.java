package com.ceiba.compra.modelo.entidad;

import com.ceiba.estado_compra.modelo.entidad.EstadoCompra;
import lombok.Getter;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Compra {

    private static final String EL_NUMERO_DE_COMPRA_DEBE_SER_MAYOR_A_CERO = "El precio del articulo debe ser mayor a cero";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_LA_FACTURA = "Se debe ingresar el numero de la factura";
    private static final String SE_DEBE_INGRESAR_EL_COSTO_TOTAL = "Se debe ingresar el costo total";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO_COMPRA = "Se debe ingresar el estado compra";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha compra";
    private static final String EL_COSTO_TOTAL_DEBE_SER_MAYOR_A_CERO = "El costo total debe ser mayor a cero";
    private static final String LA_LISTA_DE_DETALLES_DE_COMPRA_NO_DEBE_SER_VACIA = "La lista de detalles de compra no debe ser vacia";

    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;
    private EstadoCompra estadoCompra;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean Estado;


    public Compra(Long id, Long numeroFactura, Double costoTotal, List<DetalleCompra> listaDetalles, LocalDateTime fechaCompra, EstadoCompra estadoCompra) {
        validarPositivoLong(numeroFactura, EL_NUMERO_DE_COMPRA_DEBE_SER_MAYOR_A_CERO);
        validarObligatorio(numeroFactura, SE_DEBE_INGRESAR_EL_NUMERO_DE_LA_FACTURA);
        validarPositivo(costoTotal, EL_COSTO_TOTAL_DEBE_SER_MAYOR_A_CERO);
        validarObligatorio(costoTotal, SE_DEBE_INGRESAR_EL_COSTO_TOTAL);
        validarObligatorio(estadoCompra, SE_DEBE_INGRESAR_EL_ESTADO_COMPRA);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);
        validarNoVacio(listaDetalles, LA_LISTA_DE_DETALLES_DE_COMPRA_NO_DEBE_SER_VACIA);

        this.id = id;
        this.numeroFactura = numeroFactura;
        this.costoTotal = costoTotal;
        this.listaDetalles = listaDetalles;
        this.fechaCompra = fechaCompra;
        this.estadoCompra = estadoCompra;
    }

    // Agregar setter solo a los campos que puedan cambiar tal como si fuera en la vida real

}
