package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeDTO {

    private Long idViaje;

    private Long idUsuario;

    @NotNull
    private Long usuarioViaje;

}
