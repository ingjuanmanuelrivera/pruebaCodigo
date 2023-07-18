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
public class Viaje {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

    @Column
    private Long idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_viaje_id", nullable = false)
    private Usuario usuarioViaje;

    @OneToMany(mappedBy = "viajeCapitulo1")
    private Set<ViajeCapitulo1> viajeCapitulo1ViajeCapitulo1s;

    @OneToMany(mappedBy = "viajeCapitulo2")
    private Set<ViajeCapitulo2> viajeCapitulo2ViajeCapitulo2s;

    @OneToMany(mappedBy = "viajeCap3Gastos")
    private Set<ViajeCapitulo3Gastos> viajeCap3GastosViajeCapitulo3Gastoss;

    @OneToMany(mappedBy = "viajeCap3Visitas")
    private Set<ViajeCapitulo3Visita> viajeCap3VisitasViajeCapitulo3Visitas;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
