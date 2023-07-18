package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeCapitulo2DTO {

    private Long idCapitulo2;

    @NotNull
    private Long idViaje;

    @NotNull
    private Integer idMotivo;

    @NotNull
    private Long viajeCapitulo2;

}
