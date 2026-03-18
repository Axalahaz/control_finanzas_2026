package com.finanzas.app.auth.service;

import org.springframework.stereotype.Service;

import com.finanzas.app.auth.dto.LoginRequest;
import com.finanzas.app.auth.dto.RegistrarUsuarioRequest;
import com.finanzas.app.config.JwtService;
import com.finanzas.app.usuario.entity.Usuario;
import com.finanzas.app.usuario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	// ----------------------------------------------------
    // REGISTRAR
	
    public Usuario registrar(RegistrarUsuarioRequest request) {

        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = Usuario.builder()
        		.nombre(request.getNombre())
        		.email(request.getEmail())
        		.password(passwordEncoder.encode(request.getPassword())) // encriptacion
        		.build();

        return usuarioRepository.save(usuario);
    }

    // ----------------------------------------------------
    // LOGIN
    
    public String login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return jwtService.generarToken(usuario.getEmail());
    }

}
