package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDevolucion;
import com.ceiba.dominio.excepcion.ExcepcionNoExisteRegistroBD;

import java.time.Duration;
import java.time.LocalDateTime;

public class ServicioActualizarCompra {

    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "La compra no existe en el sistema";
    private static final String NO_SE_PUEDE_HACE_DEVOLUCION_VEINTICUATRO_HORAS_DESPUES = "No se puede hacer devolucion veinticuatro horas despues";
    private static final String ESTADO_DEVOLUCION = "Devolucion";

    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) { this.repositorioCompra = repositorioCompra; }

    public void ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);
        validarAccesoADevolucion(compra);
        this.repositorioCompra.actualizar(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId());
        if(!existe) {
            throw new ExcepcionNoExisteRegistroBD(LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarAccesoADevolucion(Compra compra) {
        if ( esDevolucion(compra.getEstadoCompra()) && pasaronVeintiCuatroHoraDesdeCompra(compra.getFechaCompra()) ) {
            throw new ExcepcionDevolucion(NO_SE_PUEDE_HACE_DEVOLUCION_VEINTICUATRO_HORAS_DESPUES);
        }
    }

    public boolean pasaronVeintiCuatroHoraDesdeCompra(LocalDateTime fechaCompra) {
        LocalDateTime fechaActual = LocalDateTime.now();
        Duration duration = Duration.between(fechaCompra, fechaActual);
        long hours = Math.abs(duration.toHours());
        return hours > 24;
    }

    public boolean esDevolucion(String estadoCompra) {
        return estadoCompra.equals(ESTADO_DEVOLUCION);
    }

}
