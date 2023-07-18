package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeCapitulo1DTO {

    private Long idViajeCapitulo1;

    private Long idViaje;

    @Size(max = 255)
    private String paisResidencia;

    @Size(max = 255)
    private String nacionalidad;

    private Sexo sexo;

    private Integer edad;

    @NotNull
    private Long viajeCapitulo1;

}
