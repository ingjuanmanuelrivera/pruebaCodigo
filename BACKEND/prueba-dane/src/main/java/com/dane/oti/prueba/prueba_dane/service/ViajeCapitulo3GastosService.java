package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.Viaje;
import com.dane.oti.prueba.prueba_dane.domain.ViajeCapitulo3Gastos;
import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo3GastosDTO;
import com.dane.oti.prueba.prueba_dane.repos.ViajeCapitulo3GastosRepository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeCapitulo3GastosService {

    private final ViajeCapitulo3GastosRepository viajeCapitulo3GastosRepository;
    private final ViajeRepository viajeRepository;

    public ViajeCapitulo3GastosService(
            final ViajeCapitulo3GastosRepository viajeCapitulo3GastosRepository,
            final ViajeRepository viajeRepository) {
        this.viajeCapitulo3GastosRepository = viajeCapitulo3GastosRepository;
        this.viajeRepository = viajeRepository;
    }

    public List<ViajeCapitulo3GastosDTO> findAll() {
        final List<ViajeCapitulo3Gastos> viajeCapitulo3Gastoss = viajeCapitulo3GastosRepository.findAll(Sort.by("idViajeCapitulo3Gastos"));
        return viajeCapitulo3Gastoss.stream()
                .map((viajeCapitulo3Gastos) -> mapToDTO(viajeCapitulo3Gastos, new ViajeCapitulo3GastosDTO()))
                .collect(Collectors.toList());
    }

    public ViajeCapitulo3GastosDTO get(final Long idViajeCapitulo3Gastos) {
        return viajeCapitulo3GastosRepository.findById(idViajeCapitulo3Gastos)
                .map(viajeCapitulo3Gastos -> mapToDTO(viajeCapitulo3Gastos, new ViajeCapitulo3GastosDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeCapitulo3GastosDTO viajeCapitulo3GastosDTO) {
        final ViajeCapitulo3Gastos viajeCapitulo3Gastos = new ViajeCapitulo3Gastos();
        mapToEntity(viajeCapitulo3GastosDTO, viajeCapitulo3Gastos);
        return viajeCapitulo3GastosRepository.save(viajeCapitulo3Gastos).getIdViajeCapitulo3Gastos();
    }

    public void update(final Long idViajeCapitulo3Gastos,
            final ViajeCapitulo3GastosDTO viajeCapitulo3GastosDTO) {
        final ViajeCapitulo3Gastos viajeCapitulo3Gastos = viajeCapitulo3GastosRepository.findById(idViajeCapitulo3Gastos)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeCapitulo3GastosDTO, viajeCapitulo3Gastos);
        viajeCapitulo3GastosRepository.save(viajeCapitulo3Gastos);
    }

    public void delete(final Long idViajeCapitulo3Gastos) {
        viajeCapitulo3GastosRepository.deleteById(idViajeCapitulo3Gastos);
    }

    private ViajeCapitulo3GastosDTO mapToDTO(final ViajeCapitulo3Gastos viajeCapitulo3Gastos,
            final ViajeCapitulo3GastosDTO viajeCapitulo3GastosDTO) {
        viajeCapitulo3GastosDTO.setIdViajeCapitulo3Gastos(viajeCapitulo3Gastos.getIdViajeCapitulo3Gastos());
        viajeCapitulo3GastosDTO.setIdViaje(viajeCapitulo3Gastos.getIdViaje());
        viajeCapitulo3GastosDTO.setTipoGasto(viajeCapitulo3Gastos.getTipoGasto());
        viajeCapitulo3GastosDTO.setHuboGasto(viajeCapitulo3Gastos.getHuboGasto());
        viajeCapitulo3GastosDTO.setValorPagadoUd(viajeCapitulo3Gastos.getValorPagadoUd());
        viajeCapitulo3GastosDTO.setMonedaPagadoUd(viajeCapitulo3Gastos.getMonedaPagadoUd());
        viajeCapitulo3GastosDTO.setValorPagadoTerceroNo(viajeCapitulo3Gastos.getValorPagadoTerceroNo());
        viajeCapitulo3GastosDTO.setMonedaPagadoTerceroNo(viajeCapitulo3Gastos.getMonedaPagadoTerceroNo());
        viajeCapitulo3GastosDTO.setValorPagadoTerceroSi(viajeCapitulo3Gastos.getValorPagadoTerceroSi());
        viajeCapitulo3GastosDTO.setMonedavalorPagadoTerceroSi(viajeCapitulo3Gastos.getMonedavalorPagadoTerceroSi());
        viajeCapitulo3GastosDTO.setCuantasPersonas(viajeCapitulo3Gastos.getCuantasPersonas());
        viajeCapitulo3GastosDTO.setViajeCap3Gastos(viajeCapitulo3Gastos.getViajeCap3Gastos() == null ? null : viajeCapitulo3Gastos.getViajeCap3Gastos().getIdViaje());
        return viajeCapitulo3GastosDTO;
    }

    private ViajeCapitulo3Gastos mapToEntity(final ViajeCapitulo3GastosDTO viajeCapitulo3GastosDTO,
            final ViajeCapitulo3Gastos viajeCapitulo3Gastos) {
        viajeCapitulo3Gastos.setIdViaje(viajeCapitulo3GastosDTO.getIdViaje());
        viajeCapitulo3Gastos.setTipoGasto(viajeCapitulo3GastosDTO.getTipoGasto());
        viajeCapitulo3Gastos.setHuboGasto(viajeCapitulo3GastosDTO.getHuboGasto());
        viajeCapitulo3Gastos.setValorPagadoUd(viajeCapitulo3GastosDTO.getValorPagadoUd());
        viajeCapitulo3Gastos.setMonedaPagadoUd(viajeCapitulo3GastosDTO.getMonedaPagadoUd());
        viajeCapitulo3Gastos.setValorPagadoTerceroNo(viajeCapitulo3GastosDTO.getValorPagadoTerceroNo());
        viajeCapitulo3Gastos.setMonedaPagadoTerceroNo(viajeCapitulo3GastosDTO.getMonedaPagadoTerceroNo());
        viajeCapitulo3Gastos.setValorPagadoTerceroSi(viajeCapitulo3GastosDTO.getValorPagadoTerceroSi());
        viajeCapitulo3Gastos.setMonedavalorPagadoTerceroSi(viajeCapitulo3GastosDTO.getMonedavalorPagadoTerceroSi());
        viajeCapitulo3Gastos.setCuantasPersonas(viajeCapitulo3GastosDTO.getCuantasPersonas());
        final Viaje viajeCap3Gastos = viajeCapitulo3GastosDTO.getViajeCap3Gastos() == null ? null : viajeRepository.findById(viajeCapitulo3GastosDTO.getViajeCap3Gastos())
                .orElseThrow(() -> new NotFoundException("viajeCap3Gastos not found"));
        viajeCapitulo3Gastos.setViajeCap3Gastos(viajeCap3Gastos);
        return viajeCapitulo3Gastos;
    }

}
