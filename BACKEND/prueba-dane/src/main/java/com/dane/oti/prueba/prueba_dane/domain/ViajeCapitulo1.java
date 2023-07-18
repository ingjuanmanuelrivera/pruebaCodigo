package com.dane.oti.prueba.prueba_dane.domain;

import com.dane.oti.prueba.prueba_dane.model.Sexo;
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
import jakarta.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class ViajeCapitulo1 {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViajeCapitulo1;

    @Column
    private Long idViaje;

    @Column
    private String paisResidencia;

    @Column
    private String nacionalidad;

    @Column
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viaje_capitulo1_id", nullable = false)
    private Viaje viajeCapitulo1;

    @OneToMany(mappedBy = "viajeQuienes")
    private Set<ViajeCapitulo1Quienes> viajeQuienesViajeCapitulo1Quieness;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
