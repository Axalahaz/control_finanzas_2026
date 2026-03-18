package com.finanzas.app.usuario.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsuarioResponse {
    private Long id;
    private String nombre;
    private String email;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaDesactivacion;
}