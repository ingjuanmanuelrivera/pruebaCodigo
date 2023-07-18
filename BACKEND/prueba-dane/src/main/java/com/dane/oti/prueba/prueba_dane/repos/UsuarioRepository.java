package com.dane.oti.prueba.prueba_dane.repos;

import com.dane.oti.prueba.prueba_dane.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByCorreoIgnoreCase(String correo);

}
