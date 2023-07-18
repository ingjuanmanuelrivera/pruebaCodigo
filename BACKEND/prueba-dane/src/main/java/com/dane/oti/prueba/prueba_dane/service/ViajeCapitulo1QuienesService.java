package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo1;
import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo1Quienes;
import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo1QuienesDTO;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo1QuienesRepository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo1Repository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeCapitulo1QuienesService {

    private final ViajeCapitulo1QuienesRepository viajeCapitulo1QuienesRepository;
    private final ViajeCapitulo1Repository viajeCapitulo1Repository;

    public ViajeCapitulo1QuienesService(
            final ViajeCapitulo1QuienesRepository viajeCapitulo1QuienesRepository,
            final ViajeCapitulo1Repository viajeCapitulo1Repository) {
        this.viajeCapitulo1QuienesRepository = viajeCapitulo1QuienesRepository;
        this.viajeCapitulo1Repository = viajeCapitulo1Repository;
    }

    public List<ViajeCapitulo1QuienesDTO> findAll() {
        final List<ViajeCapitulo1Quienes> viajeCapitulo1Quieness = viajeCapitulo1QuienesRepository.findAll(Sort.by("idCapitulo1Quines"));
        return viajeCapitulo1Quieness.stream()
                .map((viajeCapitulo1Quienes) -> mapToDTO(viajeCapitulo1Quienes, new ViajeCapitulo1QuienesDTO()))
                .collect(Collectors.toList());
    }

    public ViajeCapitulo1QuienesDTO get(final Long idCapitulo1Quines) {
        return viajeCapitulo1QuienesRepository.findById(idCapitulo1Quines)
                .map(viajeCapitulo1Quienes -> mapToDTO(viajeCapitulo1Quienes, new ViajeCapitulo1QuienesDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeCapitulo1QuienesDTO viajeCapitulo1QuienesDTO) {
        final ViajeCapitulo1Quienes viajeCapitulo1Quienes = new ViajeCapitulo1Quienes();
        mapToEntity(viajeCapitulo1QuienesDTO, viajeCapitulo1Quienes);
        return viajeCapitulo1QuienesRepository.save(viajeCapitulo1Quienes).getIdCapitulo1Quines();
    }

    public void update(final Long idCapitulo1Quines,
            final ViajeCapitulo1QuienesDTO viajeCapitulo1QuienesDTO) {
        final ViajeCapitulo1Quienes viajeCapitulo1Quienes = viajeCapitulo1QuienesRepository.findById(idCapitulo1Quines)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeCapitulo1QuienesDTO, viajeCapitulo1Quienes);
        viajeCapitulo1QuienesRepository.save(viajeCapitulo1Quienes);
    }

    public void delete(final Long idCapitulo1Quines) {
        viajeCapitulo1QuienesRepository.deleteById(idCapitulo1Quines);
    }

    private ViajeCapitulo1QuienesDTO mapToDTO(final ViajeCapitulo1Quienes viajeCapitulo1Quienes,
            final ViajeCapitulo1QuienesDTO viajeCapitulo1QuienesDTO) {
        viajeCapitulo1QuienesDTO.setIdCapitulo1Quines(viajeCapitulo1Quienes.getIdCapitulo1Quines());
        viajeCapitulo1QuienesDTO.setIdCapitulo1(viajeCapitulo1Quienes.getIdCapitulo1());
        viajeCapitulo1QuienesDTO.setOpcion(viajeCapitulo1Quienes.getOpcion());
        viajeCapitulo1QuienesDTO.setViajeQuienes(viajeCapitulo1Quienes.getViajeQuienes() == null ? null : viajeCapitulo1Quienes.getViajeQuienes().getIdViajeCapitulo1());
        return viajeCapitulo1QuienesDTO;
    }

    private ViajeCapitulo1Quienes mapToEntity(
            final ViajeCapitulo1QuienesDTO viajeCapitulo1QuienesDTO,
            final ViajeCapitulo1Quienes viajeCapitulo1Quienes) {
        viajeCapitulo1Quienes.setIdCapitulo1(viajeCapitulo1QuienesDTO.getIdCapitulo1());
        viajeCapitulo1Quienes.setOpcion(viajeCapitulo1QuienesDTO.getOpcion());
        final ViajeCapitulo1 viajeQuienes = viajeCapitulo1QuienesDTO.getViajeQuienes() == null ? null : viajeCapitulo1Repository.findById(viajeCapitulo1QuienesDTO.getViajeQuienes())
                .orElseThrow(() -> new NotFoundException("viajeQuienes not found"));
        viajeCapitulo1Quienes.setViajeQuienes(viajeQuienes);
        return viajeCapitulo1Quienes;
    }

}
