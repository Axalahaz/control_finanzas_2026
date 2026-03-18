package com.finanzas.app.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.app.usuario.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}