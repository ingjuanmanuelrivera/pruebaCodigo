package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeCapitulo3VisitaDTO {

    private Long idViajeCapitulo3Visita;

    @NotNull
    private Long idViaje;

    @Size(max = 100)
    private String paisVisita;

    private Integer viviendaPropia;

    private Integer hotel;

    private Integer viviendaFamiliar;

    private Integer viviendaAlquiler;

    private Integer otro;

    @NotNull
    private Long viajeCap3Visitas;

}
