package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo2;
import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo2Servicio;
import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo2ServicioDTO;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo2Repository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo2ServicioRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeCapitulo2ServicioService {

    private final ViajeCapitulo2ServicioRepository viajeCapitulo2ServicioRepository;
    private final ViajeCapitulo2Repository viajeCapitulo2Repository;

    public ViajeCapitulo2ServicioService(
            final ViajeCapitulo2ServicioRepository viajeCapitulo2ServicioRepository,
            final ViajeCapitulo2Repository viajeCapitulo2Repository) {
        this.viajeCapitulo2ServicioRepository = viajeCapitulo2ServicioRepository;
        this.viajeCapitulo2Repository = viajeCapitulo2Repository;
    }

    public List<ViajeCapitulo2ServicioDTO> findAll() {
        final List<ViajeCapitulo2Servicio> viajeCapitulo2Servicios = viajeCapitulo2ServicioRepository.findAll(Sort.by("idViajeCapitulo2Servicio"));
        return viajeCapitulo2Servicios.stream()
                .map((viajeCapitulo2Servicio) -> mapToDTO(viajeCapitulo2Servicio, new ViajeCapitulo2ServicioDTO()))
                .collect(Collectors.toList());
    }

    public ViajeCapitulo2ServicioDTO get(final Long idViajeCapitulo2Servicio) {
        return viajeCapitulo2ServicioRepository.findById(idViajeCapitulo2Servicio)
                .map(viajeCapitulo2Servicio -> mapToDTO(viajeCapitulo2Servicio, new ViajeCapitulo2ServicioDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeCapitulo2ServicioDTO viajeCapitulo2ServicioDTO) {
        final ViajeCapitulo2Servicio viajeCapitulo2Servicio = new ViajeCapitulo2Servicio();
        mapToEntity(viajeCapitulo2ServicioDTO, viajeCapitulo2Servicio);
        return viajeCapitulo2ServicioRepository.save(viajeCapitulo2Servicio).getIdViajeCapitulo2Servicio();
    }

    public void update(final Long idViajeCapitulo2Servicio,
            final ViajeCapitulo2ServicioDTO viajeCapitulo2ServicioDTO) {
        final ViajeCapitulo2Servicio viajeCapitulo2Servicio = viajeCapitulo2ServicioRepository.findById(idViajeCapitulo2Servicio)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeCapitulo2ServicioDTO, viajeCapitulo2Servicio);
        viajeCapitulo2ServicioRepository.save(viajeCapitulo2Servicio);
    }

    public void delete(final Long idViajeCapitulo2Servicio) {
        viajeCapitulo2ServicioRepository.deleteById(idViajeCapitulo2Servicio);
    }

    private ViajeCapitulo2ServicioDTO mapToDTO(final ViajeCapitulo2Servicio viajeCapitulo2Servicio,
            final ViajeCapitulo2ServicioDTO viajeCapitulo2ServicioDTO) {
        viajeCapitulo2ServicioDTO.setIdViajeCapitulo2Servicio(viajeCapitulo2Servicio.getIdViajeCapitulo2Servicio());
        viajeCapitulo2ServicioDTO.setIdCapitulo2(viajeCapitulo2Servicio.getIdCapitulo2());
        viajeCapitulo2ServicioDTO.setOpcion(viajeCapitulo2Servicio.getOpcion());
        viajeCapitulo2ServicioDTO.setViajeCapitulo2(viajeCapitulo2Servicio.getViajeCapitulo2() == null ? null : viajeCapitulo2Servicio.getViajeCapitulo2().getIdCapitulo2());
        return viajeCapitulo2ServicioDTO;
    }

    private ViajeCapitulo2Servicio mapToEntity(
            final ViajeCapitulo2ServicioDTO viajeCapitulo2ServicioDTO,
            final ViajeCapitulo2Servicio viajeCapitulo2Servicio) {
        viajeCapitulo2Servicio.setIdCapitulo2(viajeCapitulo2ServicioDTO.getIdCapitulo2());
        viajeCapitulo2Servicio.setOpcion(viajeCapitulo2ServicioDTO.getOpcion());
        final ViajeCapitulo2 viajeCapitulo2 = viajeCapitulo2ServicioDTO.getViajeCapitulo2() == null ? null : viajeCapitulo2Repository.findById(viajeCapitulo2ServicioDTO.getViajeCapitulo2())
                .orElseThrow(() -> new NotFoundException("viajeCapitulo2 not found"));
        viajeCapitulo2Servicio.setViajeCapitulo2(viajeCapitulo2);
        return viajeCapitulo2Servicio;
    }

}
