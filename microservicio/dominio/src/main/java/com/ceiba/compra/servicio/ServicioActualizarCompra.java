package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionDevolucion;

import java.time.Duration;
import java.time.LocalDateTime;

public class ServicioActualizarCompra {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";
    private static final String NO_SE_PUEDE_HACE_DEVOLUCION_VEINTICUATRO_HORAS_DESPUES = "No se puede hacer devolucion veinticuatro horas despues";
    private static final String ESTADO_DEVOLUCION = "Devolucion";

    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) { this.repositorioCompra = repositorioCompra; }

    public void ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);
        if ( esDevolucion(compra.getEstadoCompra()) && pasaronVeintiCuatroHoraDesdeCompra(compra.getFechaCompra()) ) {
            throw new ExcepcionDevolucion(NO_SE_PUEDE_HACE_DEVOLUCION_VEINTICUATRO_HORAS_DESPUES);
        }
        this.repositorioCompra.actualizar(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getNumeroFactura());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    public boolean pasaronVeintiCuatroHoraDesdeCompra(LocalDateTime fechaCompra) {
        LocalDateTime fechaActual = LocalDateTime.now();
        Duration duration = Duration.between(fechaCompra, fechaActual);
        long hours = duration.toHours();
        return hours > 24 ? true : false;
    }

    public boolean esDevolucion(String tipoEstadoCompra) {
        return tipoEstadoCompra == ESTADO_DEVOLUCION ? true : false;
    }

}
