package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import org.springframework.stereotype.*;

@Component
public class ServicioCrearCompra {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";

    // Horas de envio
    private static final Integer HORA_COMIENZO_DE_ENVIOS = 8;
    private static final Integer MINUTOS_COMIENZO_DE_ENVIOS = 0;
    private static final Integer MINUTOS_HASTA_REALIZAR_ENVIOS = 15;

    // Otros
    private static final Integer PORCENTAJE_RECARGO = 4;
    private static final Integer UN_DIA = 1;

    // Fin de semana
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;

    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) { this.repositorioCompra = repositorioCompra; }

    /**
     * Orden de Compra
     * Primero si es mayor a 200mil
     * Segundo si es fin de semana
     * Tercero Si es despues de la 6PM y antes de las 12PM,
     * si es entre las 12PM y a 7Am solo se asigna una hora cualquiera entre un rango y se aumenta 30 min o una hora
     * @param compra
     * @return idCompra
     */
    public Long ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);

        if( esFinDeSemana(compra.getFechaCompra()) && esMenorADocientosMilPesos(compra.getCostoTotal()) ) {
            compra.setCostoTotal(CalcularCostoTotalConRecargo(compra.getCostoTotal()));
        }
        compra.setFechaEnvio(calcularFechaEnvio(compra.getFechaCompra()));

        return this.repositorioCompra.crear(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getNumeroFactura());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private boolean esMenorADocientosMilPesos(Double costoTotal) {
        return costoTotal < 200000 ? true : false;
    }

    private boolean esFinDeSemana(LocalDateTime fechaCompra) {
        return (fechaCompra.getDayOfWeek().getValue() == SATURDAY || fechaCompra.getDayOfWeek().getValue() == SUNDAY) ? true : false;
    }

    private LocalDateTime calcularFechaEnvio(LocalDateTime fechaCompra) {

        LocalDateTime fechaEnvio = null;
        if( esMayorALas6PmYMenorALas12AM(fechaCompra) ) { fechaEnvio = fechaCompra.plusDays(UN_DIA).withHour(HORA_COMIENZO_DE_ENVIOS).withMinute(MINUTOS_COMIENZO_DE_ENVIOS); }
        else if ( esMayorALas12AMYMenorALas8AM (fechaCompra) ) { fechaEnvio = fechaCompra.withMinute(HORA_COMIENZO_DE_ENVIOS).withMinute(MINUTOS_COMIENZO_DE_ENVIOS); }
        else { fechaEnvio = fechaCompra.plusMinutes(MINUTOS_HASTA_REALIZAR_ENVIOS); }
        return fechaEnvio;
    }

    private boolean esMayorALas6PmYMenorALas12AM(LocalDateTime fechaEnvio) {
        LocalDateTime seisPm = LocalDateTime.now().withHour(18).withMinute(0);
        LocalDateTime finalDelDiaActual = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);

        return fechaEnvio.isAfter(seisPm) && fechaEnvio.isBefore(finalDelDiaActual) ? true : false;
    }

    private boolean esMayorALas12AMYMenorALas8AM(LocalDateTime fechaEnvio) {
        LocalDateTime doceAm = LocalDateTime.now().withHour(12).withMinute(1);
        LocalDateTime ochoAm = LocalDateTime.now().withHour(8).withMinute(0);

        return fechaEnvio.isAfter(doceAm) && fechaEnvio.isBefore(ochoAm) ? true : false;
    }

    private Double CalcularCostoTotalConRecargo(Double costoTotal) {
        return (costoTotal + ( (costoTotal * PORCENTAJE_RECARGO) / 100 ) );
    }

}
