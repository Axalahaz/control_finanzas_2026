package com.finanzas.app.ingreso.dto;

import java.math.BigDecimal;

import com.finanzas.app.usuario.entity.Usuario;

import lombok.Getter;

@Getter
public class CrearIngresoRequest {
    private BigDecimal monto;
    private String descripcion;
    private Usuario usuario;
}