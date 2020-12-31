package com.ceiba.articulo.comando;

import com.ceiba.categoria.modelo.entidad.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoArticulo {

    private  Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Categoria categoria;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean Estado;
}
