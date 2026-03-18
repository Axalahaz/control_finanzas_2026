package com.finanzas.app.gasto.service;

import com.finanzas.app.gasto.dto.CrearGastoRequest;
import com.finanzas.app.gasto.entity.Gasto;
import com.finanzas.app.gasto.mapper.GastoMapper;
import com.finanzas.app.gasto.repository.GastoRepository;
import com.finanzas.app.usuario.entity.Usuario;
import com.finanzas.app.usuario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository gastoRepository;
    private final UsuarioRepository usuarioRepository;
    private final GastoMapper gastoMapper;

 	// ----------------------------------------------------
    // CREAR
    
    public Gasto crear(CrearGastoRequest request, String email) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Gasto gasto = gastoMapper.toEntity(request, usuario);

        return gastoRepository.save(gasto);
    }

 	// ----------------------------------------------------
    // LISTAR
    
    public List<Gasto> listar(String email) {
        return gastoRepository.findByUsuarioEmail(email);
    }
}