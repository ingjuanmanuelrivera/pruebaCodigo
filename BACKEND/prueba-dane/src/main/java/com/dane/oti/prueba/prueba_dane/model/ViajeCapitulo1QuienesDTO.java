package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeCapitulo1QuienesDTO {

    private Long idCapitulo1Quines;

    @NotNull
    private Long idCapitulo1;

    @NotNull
    private Integer opcion;

    @NotNull
    private Long viajeQuienes;

}
