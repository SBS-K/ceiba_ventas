package com.ceiba.detalle_compra.modelo.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import com.ceiba.articulo.modelo.entidad.Articulo;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivoInteger;

@Getter
@NoArgsConstructor
public class DetalleCompra {

    private static final String SE_DEBE_INGRESAR_UN_ARTICULO = "Se debe ingresar un articulo";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar la cantidad";
    private static final String SE_DEBE_INGRESAR_EL_SUBTOTAL = "Se debe ingresar el subtotal";
    private static final String LA_CANTIDAD_DEBE_SER_MAYOR_A_CERO = "La cantidad debe ser mayor a cero";
    private static final String EL_SUBTOTAL_DEBE_SER_MAYOR_A_CERO = "El subtotal debe ser mayor a cero";

    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private Double subtotal;

    public DetalleCompra(Long id, Articulo articulo, Integer cantidad, Double subtotal) {
        validarObligatorio(articulo, SE_DEBE_INGRESAR_UN_ARTICULO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD);
        validarPositivoInteger(cantidad, LA_CANTIDAD_DEBE_SER_MAYOR_A_CERO);
        validarObligatorio(subtotal, SE_DEBE_INGRESAR_EL_SUBTOTAL);
        validarPositivo(subtotal, EL_SUBTOTAL_DEBE_SER_MAYOR_A_CERO);

        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

}
