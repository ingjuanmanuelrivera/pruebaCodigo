package com.dane.oti.prueba.prueba_dane.domain;

import com.dane.oti.prueba.prueba_dane.model.RespuestaSINO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class ViajeCapitulo3Gastos {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViajeCapitulo3Gastos;

    @Column(nullable = false)
    private Long idViaje;

    @Column
    private String tipoGasto;

    @Column
    @Enumerated(EnumType.STRING)
    private RespuestaSINO huboGasto;

    @Column
    private Double valorPagadoUd;

    @Column(length = 5)
    private String monedaPagadoUd;

    @Column
    private Double valorPagadoTerceroNo;

    @Column(length = 5)
    private String monedaPagadoTerceroNo;

    @Column
    private Double valorPagadoTerceroSi;

    @Column(length = 5)
    private String monedavalorPagadoTerceroSi;

    @Column
    private Integer cuantasPersonas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viaje_cap3gastos_id", nullable = false)
    private Viaje viajeCap3Gastos;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
