package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.Usuario;
import com.dane.oti.prueba.prueba_dane.domain.Viaje;
import com.dane.oti.prueba.prueba_dane.model.ViajeDTO;
import com.dane.oti.prueba.prueba_dane.repos.UsuarioRepository;
import com.dane.oti.prueba.prueba_dane.repos.ViajeRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ViajeService {

    private final ViajeRepository viajeRepository;
    private final UsuarioRepository usuarioRepository;

    public ViajeService(final ViajeRepository viajeRepository,
            final UsuarioRepository usuarioRepository) {
        this.viajeRepository = viajeRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<ViajeDTO> findAll() {
        final List<Viaje> viajes = viajeRepository.findAll(Sort.by("idViaje"));
        return viajes.stream()
                .map((viaje) -> mapToDTO(viaje, new ViajeDTO()))
                .collect(Collectors.toList());
    }

    public ViajeDTO get(final Long idViaje) {
        return viajeRepository.findById(idViaje)
                .map(viaje -> mapToDTO(viaje, new ViajeDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ViajeDTO viajeDTO) {
        final Viaje viaje = new Viaje();
        mapToEntity(viajeDTO, viaje);
        return viajeRepository.save(viaje).getIdViaje();
    }

    public void update(final Long idViaje, final ViajeDTO viajeDTO) {
        final Viaje viaje = viajeRepository.findById(idViaje)
                .orElseThrow(NotFoundException::new);
        mapToEntity(viajeDTO, viaje);
        viajeRepository.save(viaje);
    }

    public void delete(final Long idViaje) {
        viajeRepository.deleteById(idViaje);
    }

    private ViajeDTO mapToDTO(final Viaje viaje, final ViajeDTO viajeDTO) {
        viajeDTO.setIdViaje(viaje.getIdViaje());
        viajeDTO.setIdUsuario(viaje.getIdUsuario());
        viajeDTO.setUsuarioViaje(viaje.getUsuarioViaje() == null ? null : viaje.getUsuarioViaje().getIdUsuario());
        return viajeDTO;
    }

    private Viaje mapToEntity(final ViajeDTO viajeDTO, final Viaje viaje) {
        viaje.setIdUsuario(viajeDTO.getIdUsuario());
        final Usuario usuarioViaje = viajeDTO.getUsuarioViaje() == null ? null : usuarioRepository.findById(viajeDTO.getUsuarioViaje())
                .orElseThrow(() -> new NotFoundException("usuarioViaje not found"));
        viaje.setUsuarioViaje(usuarioViaje);
        return viaje;
    }

}
