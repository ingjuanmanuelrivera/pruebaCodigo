package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.Viaje;
import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo3Visita;
import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo3VisitaDTO;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo3VisitaRepository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeCapitulo3VisitaService {

    private final ViajeCapitulo3VisitaRepository viajeCapitulo3VisitaRepository;
    private final ViajeRepository viajeRepository;

    public ViajeCapitulo3VisitaService(
            final ViajeCapitulo3VisitaRepository viajeCapitulo3VisitaRepository,
            final ViajeRepository viajeRepository) {
        this.viajeCapitulo3VisitaRepository = viajeCapitulo3VisitaRepository;
        this.viajeRepository = viajeRepository;
    }

    public List<ViajeCapitulo3VisitaDTO> findAll() {
        final List<ViajeCapitulo3Visita> viajeCapitulo3Visitas = viajeCapitulo3VisitaRepository.findAll(Sort.by("idViajeCapitulo3Visita"));
        return viajeCapitulo3Visitas.stream()
                .map((viajeCapitulo3Visita) -> mapToDTO(viajeCapitulo3Visita, new ViajeCapitulo3VisitaDTO()))
                .collect(Collectors.toList());
    }

    public ViajeCapitulo3VisitaDTO get(final Long idViajeCapitulo3Visita) {
        return viajeCapitulo3VisitaRepository.findById(idViajeCapitulo3Visita)
                .map(viajeCapitulo3Visita -> mapToDTO(viajeCapitulo3Visita, new ViajeCapitulo3VisitaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeCapitulo3VisitaDTO viajeCapitulo3VisitaDTO) {
        final ViajeCapitulo3Visita viajeCapitulo3Visita = new ViajeCapitulo3Visita();
        mapToEntity(viajeCapitulo3VisitaDTO, viajeCapitulo3Visita);
        return viajeCapitulo3VisitaRepository.save(viajeCapitulo3Visita).getIdViajeCapitulo3Visita();
    }

    public void update(final Long idViajeCapitulo3Visita,
            final ViajeCapitulo3VisitaDTO viajeCapitulo3VisitaDTO) {
        final ViajeCapitulo3Visita viajeCapitulo3Visita = viajeCapitulo3VisitaRepository.findById(idViajeCapitulo3Visita)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeCapitulo3VisitaDTO, viajeCapitulo3Visita);
        viajeCapitulo3VisitaRepository.save(viajeCapitulo3Visita);
    }

    public void delete(final Long idViajeCapitulo3Visita) {
        viajeCapitulo3VisitaRepository.deleteById(idViajeCapitulo3Visita);
    }

    private ViajeCapitulo3VisitaDTO mapToDTO(final ViajeCapitulo3Visita viajeCapitulo3Visita,
            final ViajeCapitulo3VisitaDTO viajeCapitulo3VisitaDTO) {
        viajeCapitulo3VisitaDTO.setIdViajeCapitulo3Visita(viajeCapitulo3Visita.getIdViajeCapitulo3Visita());
        viajeCapitulo3VisitaDTO.setIdViaje(viajeCapitulo3Visita.getIdViaje());
        viajeCapitulo3VisitaDTO.setPaisVisita(viajeCapitulo3Visita.getPaisVisita());
        viajeCapitulo3VisitaDTO.setViviendaPropia(viajeCapitulo3Visita.getViviendaPropia());
        viajeCapitulo3VisitaDTO.setHotel(viajeCapitulo3Visita.getHotel());
        viajeCapitulo3VisitaDTO.setViviendaFamiliar(viajeCapitulo3Visita.getViviendaFamiliar());
        viajeCapitulo3VisitaDTO.setViviendaAlquiler(viajeCapitulo3Visita.getViviendaAlquiler());
        viajeCapitulo3VisitaDTO.setOtro(viajeCapitulo3Visita.getOtro());
        viajeCapitulo3VisitaDTO.setViajeCap3Visitas(viajeCapitulo3Visita.getViajeCap3Visitas() == null ? null : viajeCapitulo3Visita.getViajeCap3Visitas().getIdViaje());
        return viajeCapitulo3VisitaDTO;
    }

    private ViajeCapitulo3Visita mapToEntity(final ViajeCapitulo3VisitaDTO viajeCapitulo3VisitaDTO,
            final ViajeCapitulo3Visita viajeCapitulo3Visita) {
        viajeCapitulo3Visita.setIdViaje(viajeCapitulo3VisitaDTO.getIdViaje());
        viajeCapitulo3Visita.setPaisVisita(viajeCapitulo3VisitaDTO.getPaisVisita());
        viajeCapitulo3Visita.setViviendaPropia(viajeCapitulo3VisitaDTO.getViviendaPropia());
        viajeCapitulo3Visita.setHotel(viajeCapitulo3VisitaDTO.getHotel());
        viajeCapitulo3Visita.setViviendaFamiliar(viajeCapitulo3VisitaDTO.getViviendaFamiliar());
        viajeCapitulo3Visita.setViviendaAlquiler(viajeCapitulo3VisitaDTO.getViviendaAlquiler());
        viajeCapitulo3Visita.setOtro(viajeCapitulo3VisitaDTO.getOtro());
        final Viaje viajeCap3Visitas = viajeCapitulo3VisitaDTO.getViajeCap3Visitas() == null ? null : viajeRepository.findById(viajeCapitulo3VisitaDTO.getViajeCap3Visitas())
                .orElseThrow(() -> new NotFoundException("viajeCap3Visitas not found"));
        viajeCapitulo3Visita.setViajeCap3Visitas(viajeCap3Visitas);
        return viajeCapitulo3Visita;
    }

}
