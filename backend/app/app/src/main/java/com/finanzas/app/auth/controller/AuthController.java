package com.finanzas.app.auth.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.app.auth.dto.LoginRequest;
import com.finanzas.app.auth.dto.RegistrarUsuarioRequest;
import com.finanzas.app.auth.service.AuthService;
import com.finanzas.app.usuario.dto.UsuarioResponse;
import com.finanzas.app.usuario.mapper.UsuarioMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
    private final AuthService authService;
    private final UsuarioMapper usuarioMapper;

    // ----------------------------------------------------
    // REGISTRO
    
    @PostMapping("/register")
    public Object register(@RequestBody RegistrarUsuarioRequest request) {
        return usuarioMapper.toResponse(authService.registrar(request));
    }
 
    // ----------------------------------------------------
    // LOGIN

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest request) {
    	String token = authService.login(request);
        return Map.of("token", token);
    }
    
    // ----------------------------------------------------
    // ME
    
    @GetMapping("/me")
    public String obtenerUsuario(Authentication auth) {
        return "Email: " + auth.getName(); // 👉 email
    }
    
    
}
