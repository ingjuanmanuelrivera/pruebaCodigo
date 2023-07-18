package com.dane.oti.prueba.prueba_dane.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
public class ViajeCapitulo2 {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCapitulo2;

    @Column(nullable = false)
    private Long idViaje;

    @Column(nullable = false)
    private Integer idMotivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viaje_capitulo2_id", nullable = false)
    private Viaje viajeCapitulo2;

    @OneToMany(mappedBy = "viajeCapitulo2")
    private Set<ViajeCapitulo2Servicio> viajeCapitulo2ViajeCapitulo2Servicios;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
