package com.dane.oti.prueba.prueba_dane.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ViajeCapitulo3GastosDTO {

    private Long idViajeCapitulo3Gastos;

    @NotNull
    private Long idViaje;

    @Size(max = 255)
    private String tipoGasto;

    private RespuestaSINO huboGasto;

    private Double valorPagadoUd;

    @Size(max = 5)
    private String monedaPagadoUd;

    private Double valorPagadoTerceroNo;

    @Size(max = 5)
    private String monedaPagadoTerceroNo;

    private Double valorPagadoTerceroSi;

    @Size(max = 5)
    private String monedavalorPagadoTerceroSi;

    private Integer cuantasPersonas;

    @NotNull
    private Long viajeCap3Gastos;

}
