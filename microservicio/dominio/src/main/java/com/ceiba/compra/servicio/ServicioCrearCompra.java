package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import org.springframework.stereotype.*;

public class ServicioCrearCompra {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";

    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) { this.repositorioCompra = repositorioCompra; }

    public Long ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);
        return this.repositorioCompra.crear(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }



}
