package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioDTO {

    private Long idUsuario;

    @NotNull
    @Size(max = 255)
    private String correo;

    @NotNull
    @Size(max = 255)
    private String password;

}
