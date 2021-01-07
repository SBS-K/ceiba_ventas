package com.ceiba.compra.modelo.entidad;

import lombok.Getter;
import com.ceiba.detalle_compra.modelo.entidad.DetalleCompra;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    // Horas de envio
    private static final Integer HORA_COMIENZO_DE_ENVIOS = 8;
    private static final Integer MINUTOS_COMIENZO_DE_ENVIOS = 0;
    private static final Integer MINUTOS_HASTA_REALIZAR_ENVIOS = 30;

    // Otros
    private static final Integer UN_DIA = 1;
    private static final Integer PORCENTAJE_RECARGO = 4;

    // Fin de semana
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;

    private Long id;
    private Long numeroFactura;
    private Double costoTotal;
    private String estadoCompra;
    private List<DetalleCompra> listaDetalles;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEnvio;

    public Compra(Long id, Long numeroFactura, Double costoTotal, String estadoCompra, List<DetalleCompra> listaDetalles, LocalDateTime fechaCompra) {
        //validarPositivoLong(numeroFactura, EL_NUMERO_DE_COMPRA_DEBE_SER_MAYOR_A_CERO);
        //validarObligatorio(numeroFactura, SE_DEBE_INGRESAR_EL_NUMERO_DE_LA_FACTURA);
        validarPositivo(costoTotal, EL_COSTO_TOTAL_DEBE_SER_MAYOR_A_CERO);
        validarObligatorio(costoTotal, SE_DEBE_INGRESAR_EL_COSTO_TOTAL);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);
        //validarNoVacio(listaDetalles, LA_LISTA_DE_DETALLES_DE_COMPRA_NO_DEBE_SER_VACIA);

        this.id = id;
        this.numeroFactura = numeroFactura;
        this.costoTotal = siTieneRecargoCalcularCostoTotal(fechaCompra, costoTotal);
        this.estadoCompra = estadoCompra;
        this.listaDetalles = listaDetalles;
        this.fechaCompra = fechaCompra;
        this.fechaEnvio = calcularFechaEnvio(fechaCompra);
    }

    // Setter
    public void setEstadoCompra(String estadoCompra) { this.estadoCompra = estadoCompra; }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void setListaDetalles(List<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    // Add
    public void addDetalleCompra(DetalleCompra detalleCompra) { this.listaDetalles.add(detalleCompra); }

    // Comportamiento
    public LocalDateTime calcularFechaEnvio(LocalDateTime fechaCompra) {

        LocalDateTime fechaEnvio = null;
        if( esMayorALas6PmYMenorALas12AM(fechaCompra) ) { fechaEnvio = fechaCompra.plusDays(UN_DIA).withHour(HORA_COMIENZO_DE_ENVIOS).withMinute(MINUTOS_COMIENZO_DE_ENVIOS); }
        else if ( esMayorALas12AmYMenorALas8Am(fechaCompra) ) { fechaEnvio = fechaCompra.withMinute(HORA_COMIENZO_DE_ENVIOS).withMinute(MINUTOS_COMIENZO_DE_ENVIOS); }
        else { fechaEnvio = fechaCompra.plusMinutes(MINUTOS_HASTA_REALIZAR_ENVIOS); }
        return fechaEnvio;
    }

    public boolean esMayorALas6PmYMenorALas12AM(LocalDateTime fechaCompra) {
        LocalDateTime seisPm = LocalDateTime.now().withHour(18).withMinute(0);
        LocalDateTime finalDelDiaActual = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return fechaCompra.isAfter(seisPm) && (fechaCompra.isBefore(finalDelDiaActual) || fechaCompra.isEqual(finalDelDiaActual)) ? true : false;
    }

    public boolean esMayorALas12AmYMenorALas8Am(LocalDateTime fechaCompra) {
        LocalDateTime doceAm = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime ochoAm = LocalDateTime.now().withHour(8).withMinute(0);
        return fechaCompra.isAfter(doceAm) && fechaCompra.isBefore(ochoAm) ? true : false;
    }

    // Calculo de recargo
    public Double siTieneRecargoCalcularCostoTotal(LocalDateTime fechaCompra, Double costoTotal) {
        double costoFinal = costoTotal;
        if( esFinDeSemana(fechaCompra) && esMenorADocientosMilPesos(costoTotal) ) {
            costoFinal = calcularCostoTotalConPorcentajeRecargo(costoTotal);
        }
        return costoFinal;
    }

    public Double calcularCostoTotalConPorcentajeRecargo(Double costoTotal) {
        return (costoTotal + ( (costoTotal * PORCENTAJE_RECARGO) / 100 ) );
    }

    public boolean esMenorADocientosMilPesos(Double costoTotal) {
        return costoTotal < 200000D ? true : false;
    }

    public boolean esFinDeSemana(LocalDateTime fechaCompra) {
        return (fechaCompra.getDayOfWeek().getValue() == SATURDAY || fechaCompra.getDayOfWeek().getValue() == SUNDAY) ? true : false;
    }

}
