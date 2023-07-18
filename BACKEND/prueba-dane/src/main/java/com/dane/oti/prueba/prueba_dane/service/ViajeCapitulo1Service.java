package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.Viaje;
import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo1;
import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo1DTO;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo1Repository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeCapitulo1Service {

    private final ViajeCapitulo1Repository viajeCapitulo1Repository;
    private final ViajeRepository viajeRepository;

    public ViajeCapitulo1Service(final ViajeCapitulo1Repository viajeCapitulo1Repository,
            final ViajeRepository viajeRepository) {
        this.viajeCapitulo1Repository = viajeCapitulo1Repository;
        this.viajeRepository = viajeRepository;
    }

    public List<ViajeCapitulo1DTO> findAll() {
        final List<ViajeCapitulo1> viajeCapitulo1s = viajeCapitulo1Repository.findAll(Sort.by("idViajeCapitulo1"));
        return viajeCapitulo1s.stream()
                .map((viajeCapitulo1) -> mapToDTO(viajeCapitulo1, new ViajeCapitulo1DTO()))
                .collect(Collectors.toList());
    }

    public ViajeCapitulo1DTO get(final Long idViajeCapitulo1) {
        return viajeCapitulo1Repository.findById(idViajeCapitulo1)
                .map(viajeCapitulo1 -> mapToDTO(viajeCapitulo1, new ViajeCapitulo1DTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeCapitulo1DTO viajeCapitulo1DTO) {
        final ViajeCapitulo1 viajeCapitulo1 = new ViajeCapitulo1();
        mapToEntity(viajeCapitulo1DTO, viajeCapitulo1);
        return viajeCapitulo1Repository.save(viajeCapitulo1).getIdViajeCapitulo1();
    }

    public void update(final Long idViajeCapitulo1, final ViajeCapitulo1DTO viajeCapitulo1DTO) {
        final ViajeCapitulo1 viajeCapitulo1 = viajeCapitulo1Repository.findById(idViajeCapitulo1)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeCapitulo1DTO, viajeCapitulo1);
        viajeCapitulo1Repository.save(viajeCapitulo1);
    }

    public void delete(final Long idViajeCapitulo1) {
        viajeCapitulo1Repository.deleteById(idViajeCapitulo1);
    }

    private ViajeCapitulo1DTO mapToDTO(final ViajeCapitulo1 viajeCapitulo1,
            final ViajeCapitulo1DTO viajeCapitulo1DTO) {
        viajeCapitulo1DTO.setIdViajeCapitulo1(viajeCapitulo1.getIdViajeCapitulo1());
        viajeCapitulo1DTO.setIdViaje(viajeCapitulo1.getIdViaje());
        viajeCapitulo1DTO.setPaisResidencia(viajeCapitulo1.getPaisResidencia());
        viajeCapitulo1DTO.setNacionalidad(viajeCapitulo1.getNacionalidad());
        viajeCapitulo1DTO.setSexo(viajeCapitulo1.getSexo());
        viajeCapitulo1DTO.setEdad(viajeCapitulo1.getEdad());
        viajeCapitulo1DTO.setViajeCapitulo1(viajeCapitulo1.getViajeCapitulo1() == null ? null : viajeCapitulo1.getViajeCapitulo1().getIdViaje());
        return viajeCapitulo1DTO;
    }

    private ViajeCapitulo1 mapToEntity(final ViajeCapitulo1DTO viajeCapitulo1DTO,
            final ViajeCapitulo1 viajeCapitulo1) {
        viajeCapitulo1.setIdViaje(viajeCapitulo1DTO.getIdViaje());
        viajeCapitulo1.setPaisResidencia(viajeCapitulo1DTO.getPaisResidencia());
        viajeCapitulo1.setNacionalidad(viajeCapitulo1DTO.getNacionalidad());
        viajeCapitulo1.setSexo(viajeCapitulo1DTO.getSexo());
        viajeCapitulo1.setEdad(viajeCapitulo1DTO.getEdad());
        final Viaje viajeCapitulo1 = viajeCapitulo1DTO.getViajeCapitulo1() == null ? null : viajeRepository.findById(viajeCapitulo1DTO.getViajeCapitulo1())
                .orElseThrow(() -> new NotFoundException("viajeCapitulo1 not found"));
        viajeCapitulo1.setViajeCapitulo1(viajeCapitulo1);
        return viajeCapitulo1;
    }

}
