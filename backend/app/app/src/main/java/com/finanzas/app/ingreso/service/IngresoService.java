package com.finanzas.app.ingreso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finanzas.app.ingreso.dto.CrearIngresoRequest;
import com.finanzas.app.ingreso.entity.Ingreso;
import com.finanzas.app.ingreso.mapper.IngresoMapper;
import com.finanzas.app.ingreso.repository.IngresoRepository;
import com.finanzas.app.usuario.entity.Usuario;
import com.finanzas.app.usuario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngresoService {

    private final IngresoRepository ingresoRepository;
    private final UsuarioRepository usuarioRepository;
    private final IngresoMapper ingresoMapper;

 	// ----------------------------------------------------
    // CREAR
    
    public Ingreso crear(CrearIngresoRequest request,  String email) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Ingreso ingreso = ingresoMapper.toEntity(request, usuario);

        return ingresoRepository.save(ingreso);
    }

    // ----------------------------------------------------
    // LISTAR

    public List<Ingreso> listar(String email) {
        return ingresoRepository.findByUsuarioEmail(email);
    }
}