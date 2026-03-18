package com.finanzas.app.usuario.mapper;

import org.springframework.stereotype.Component;

import com.finanzas.app.usuario.dto.UsuarioResponse;
import com.finanzas.app.usuario.entity.Usuario;

@Component
public class UsuarioMapper {

    public UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
        		.id(usuario.getId())
        		.nombre(usuario.getNombre())
        		.email(usuario.getEmail())
        		.activo(usuario.getActivo())
        		.fechaCreacion(usuario.getFechaCreacion())
        		.fechaModificacion(usuario.getFechaModificacion())
        		.fechaDesactivacion(usuario.getFechaDesactivacion())
        		.build();
    }
}