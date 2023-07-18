package com.dane.oti.prueba.prueba_dane.service;

import com.dane.oti.prueba.prueba_dane.domain.Usuario;
import com.dane.oti.prueba.prueba_dane.model.UsuarioDTO;
import com.dane.oti.prueba.prueba_dane.repos.UsuarioRepository;
import com.dane.oti.prueba.prueba_dane.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> findAll() {
        final List<Usuario> usuarios = usuarioRepository.findAll(Sort.by("idUsuario"));
        return usuarios.stream()
                .map((usuario) -> mapToDTO(usuario, new UsuarioDTO()))
                .collect(Collectors.toList());
    }

    public UsuarioDTO get(final Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UsuarioDTO usuarioDTO) {
        final Usuario usuario = new Usuario();
        mapToEntity(usuarioDTO, usuario);
        return usuarioRepository.save(usuario).getIdUsuario();
    }

    public void update(final Long idUsuario, final UsuarioDTO usuarioDTO) {
        final Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(NotFoundException::new);
        mapToEntity(usuarioDTO, usuario);
        usuarioRepository.save(usuario);
    }

    public void delete(final Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    private UsuarioDTO mapToDTO(final Usuario usuario, final UsuarioDTO usuarioDTO) {
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setPassword(usuario.getPassword());
        return usuarioDTO;
    }

    private Usuario mapToEntity(final UsuarioDTO usuarioDTO, final Usuario usuario) {
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuario;
    }

    public boolean correoExists(final String correo) {
        return usuarioRepository.existsByCorreoIgnoreCase(correo);
    }

}
