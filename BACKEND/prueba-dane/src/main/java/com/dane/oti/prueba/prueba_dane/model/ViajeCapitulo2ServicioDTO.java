package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeCapitulo2ServicioDTO {

    private Long idViajeCapitulo2Servicio;

    @NotNull
    private Long idCapitulo2;

    @NotNull
    private Integer opcion;

    private Long viajeCapitulo2;

}
