package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.Viaje;
import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo2;
import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo2DTO;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo2Repository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeCapitulo2Service {

    private final ViajeCapitulo2Repository viajeCapitulo2Repository;
    private final ViajeRepository viajeRepository;

    public ViajeCapitulo2Service(final ViajeCapitulo2Repository viajeCapitulo2Repository,
            final ViajeRepository viajeRepository) {
        this.viajeCapitulo2Repository = viajeCapitulo2Repository;
        this.viajeRepository = viajeRepository;
    }

    public List<ViajeCapitulo2DTO> findAll() {
        final List<ViajeCapitulo2> viajeCapitulo2s = viajeCapitulo2Repository.findAll(Sort.by("idCapitulo2"));
        return viajeCapitulo2s.stream()
                .map((viajeCapitulo2) -> mapToDTO(viajeCapitulo2, new ViajeCapitulo2DTO()))
                .collect(Collectors.toList());
    }

    public ViajeCapitulo2DTO get(final Long idCapitulo2) {
        return viajeCapitulo2Repository.findById(idCapitulo2)
                .map(viajeCapitulo2 -> mapToDTO(viajeCapitulo2, new ViajeCapitulo2DTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeCapitulo2DTO viajeCapitulo2DTO) {
        final ViajeCapitulo2 viajeCapitulo2 = new ViajeCapitulo2();
        mapToEntity(viajeCapitulo2DTO, viajeCapitulo2);
        return viajeCapitulo2Repository.save(viajeCapitulo2).getIdCapitulo2();
    }

    public void update(final Long idCapitulo2, final ViajeCapitulo2DTO viajeCapitulo2DTO) {
        final ViajeCapitulo2 viajeCapitulo2 = viajeCapitulo2Repository.findById(idCapitulo2)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeCapitulo2DTO, viajeCapitulo2);
        viajeCapitulo2Repository.save(viajeCapitulo2);
    }

    public void delete(final Long idCapitulo2) {
        viajeCapitulo2Repository.deleteById(idCapitulo2);
    }

    private ViajeCapitulo2DTO mapToDTO(final ViajeCapitulo2 viajeCapitulo2,
            final ViajeCapitulo2DTO viajeCapitulo2DTO) {
        viajeCapitulo2DTO.setIdCapitulo2(viajeCapitulo2.getIdCapitulo2());
        viajeCapitulo2DTO.setIdViaje(viajeCapitulo2.getIdViaje());
        viajeCapitulo2DTO.setIdMotivo(viajeCapitulo2.getIdMotivo());
        viajeCapitulo2DTO.setViajeCapitulo2(viajeCapitulo2.getViajeCapitulo2() == null ? null : viajeCapitulo2.getViajeCapitulo2().getIdViaje());
        return viajeCapitulo2DTO;
    }

    private ViajeCapitulo2 mapToEntity(final ViajeCapitulo2DTO viajeCapitulo2DTO,
            final ViajeCapitulo2 viajeCapitulo2) {
        viajeCapitulo2.setIdViaje(viajeCapitulo2DTO.getIdViaje());
        viajeCapitulo2.setIdMotivo(viajeCapitulo2DTO.getIdMotivo());
        final Viaje viajeCapitulo2 = viajeCapitulo2DTO.getViajeCapitulo2() == null ? null : viajeRepository.findById(viajeCapitulo2DTO.getViajeCapitulo2())
                .orElseThrow(() -> new NotFoundException("viajeCapitulo2 not found"));
        viajeCapitulo2.setViajeCapitulo2(viajeCapitulo2);
        return viajeCapitulo2;
    }

}
