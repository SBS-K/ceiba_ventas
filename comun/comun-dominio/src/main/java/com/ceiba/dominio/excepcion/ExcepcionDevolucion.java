package com.ceiba.dominio.excepcion;

public class ExcepcionDevolucion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDevolucion(String mensaje) { super(mensaje); }
}
