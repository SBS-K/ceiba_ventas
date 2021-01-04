package com.ceiba.dominio.excepcion;

public class ExcepcionNoExisteRegistroBD extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionNoExisteRegistroBD(String message) { super(message); }
}
